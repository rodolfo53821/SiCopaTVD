/*
 * @(#)EncapDatagramSocketImpl.java	1.6 00/01/24
 *
 * Copyright 1999 by Sun Microsystems, Inc.,
 * 901 San Antonio Road, Palo Alto, California, 94303, U.S.A.
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information
 * of Sun Microsystems, Inc. ("Confidential Information").  You
 * shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * you entered into with Sun.
 *
 * SUN MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE
 * SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE, OR NON-INFRINGEMENT. SUN SHALL NOT BE LIABLE FOR ANY DAMAGES
 * SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING
 * THIS SOFTWARE OR ITS DERIVATIVES.
 */

package com.sun.tv.net;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.*;
import java.net.*;
import java.util.Vector;

import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.protocol.DataSource;
import javax.media.protocol.PushDataSource;
import javax.media.protocol.PushSourceStream;
import javax.media.protocol.SourceTransferHandler;
import javax.tv.media.protocol.DataLostException;
import javax.tv.media.protocol.PushSourceStream2;
import javax.tv.locator.Locator;
import javax.tv.locator.MalformedLocatorException;

/**
 * Encapsulated IP Datagram Socket Implementation. This implementation does
 * not implement any security checks.  It does support SOCKS version 4.
 * Note this class should <b>NOT</b> be public.
 *
 * @author  Tao Ye
 * @version 1.1 09/99

 * Concrete datagram and multicast socket implementation base class.
 * Note: This is not a public class, so that applets cannot call
 * into the implementation directly and hence cannot bypass the
 * security checks present in the DatagramSocket and MulticastSocket 
 * classes.
 *
 */
public class EncapDatagramSocketImpl extends DatagramSocketImpl implements SourceTransferHandler {

    /* timeout value for receive() */
    private int timeout = 0;
    private PushSourceStream2 inStream;
    private final static int MTU = 4072;
    private Vector inBuf = new Vector();
    private PushDataSource source;
    private InetAddress localAddr;
    private int localPort = -1;
    private int mcastAddr;
    private boolean mcast;

    /**
     * Creates a datagram socket
     */
    protected synchronized void create() throws SocketException {
	fd = new FileDescriptor();
	//	datagramSocketCreate();
    }

    /**
     * Binds a datagram socket to a local port.
     */
    protected synchronized void bind(int lport, InetAddress laddr) throws SocketException {

	this.localAddr = laddr;
	this.localPort = lport;
	Locator loc = InterfaceMapImpl.getLocator(laddr);
	if ( loc != null) { //just to make sure
	    // This is a current private interface to underline IPstream 
	    // implementation. See below.
	    //System.out.println("EncapDSI: getting PushSourceStream2");
	    
	    //inStream = (PushSourceStream2) new EncapIPStream(loc);
	    //((EncapIPStream)inStream).setTransferHandler(this); 
	    
	    /* this will start the reading thread*/
	    //((EncapIPStream)inStream).setOpen(true);
	    /*this will start transfering */
	    //((EncapIPStream)inStream).setTransfer(true); 
	    try {
	    source = (PushDataSource) new EncapIPDataSource(new MediaLocator(loc.toExternalForm()));
	    source.connect();
	    inStream = (PushSourceStream2) source.getStreams()[0];
	    ((EncapIPStream)inStream).setTransferHandler(this); 

		source.start();
	    } catch (IOException ioe) {
		throw new SocketException("can not bind to stream");
	    } catch (MalformedLocatorException mle) {
		throw new SocketException("can not bind to stream");
	    }
	    /*
	     * This should be the right way to get the stream through JMF.
	     * But since JMF is not yet implemented, we take a shortcut to 
	     * just instanciate EncapIPStream.
	     */
	    /*
	    source = Manager.createDataSource(new MediaLocator(loc.toExternalForm()));
	    if (source instanceof PushDataSource) {
		PushSourceStream streams[] = ((PushDataSource)source).getStreams();
		if ( (streams != null) && (streams.length == 1) ) {
		    PushSourceStream stream = streams[0];
		    if ( stream instanceof PushSourceStream2) {
			inStream = (PushSourceStream) stream;
			inStream.setTransferHandler(this);
                        source.start();
			return;
		    }
		} else {
		    throw new SocketException("no stream or multiple streams for this data source");
		}
	    } else {
		throw new SocketException("no data source available for this locator");
	    }
	    */
	} else {
	    throw new SocketException("this IP address is not a valid Encapsulated IP broadcast address");
	}
    }

    /**
     * Sends a datagram packet. The packet contains the data and the
     * destination address to send the packet to.
     * @param packet to be sent.
     */
    protected void send(DatagramPacket p) throws IOException {
	throw new IOException("this is a read only socket");
     }

    /**
     * Peek at the packet to see who it is from.
     * @param return the port number which the packet came from.
     */
    protected synchronized int peek(InetAddress i) throws IOException {
	throw new IOException("not enough info to determine port number for encap IP");
    }

    /**
     * Receive the datagram packet.
     * @param Packet Received.
     */
    protected synchronized void receive(DatagramPacket p) throws IOException {
	GenericPacket encapIPpacket = null;
	int i=0;
	int time_out = 100;
	int ip_time_out = 0;

	if (timeout > 0) 
	    time_out = timeout; // if a timeout option is set for this socket.

	// Try 1000 times to parse a packet (in case of IP frag
	while ( (ip_time_out<1000) ) {

	    // try (timeout or 100) * 5 time to get something from the stream.
	    while ( (i<time_out) && (inBuf.isEmpty())) {
		try {
		    Thread.sleep(5);
		    i++;
		} catch (InterruptedException ie) {
		}
	    }
	    
	    if ( !inBuf.isEmpty() ) {
		encapIPpacket = (GenericPacket) inBuf.firstElement();
		inBuf.removeElementAt(0); // pop this packet out
	    } else {
		throw new IOException(" can not get packet, timed out");
	    }

	    // if for some reason this packet is ignored, try another one.
	    // In case of IP frag, this packet is put at the global IPReass
	    // for further matching.

	    // if mcastAddr is set, this is mcast socket, then scan for only
	    // pkt dst_ip=mcastAdrr, port=localPort
	    // localPort now really becomes multicast port.
	    try {
		if ( EncapIP.inputIP(encapIPpacket, mcast, mcastAddr, localPort, p) == false )
		    ip_time_out++;
		else {
		    return;
		}
	    } catch (PacketDiscardedException pde) {
		pde.printStackTrace();
	    }
	}
	throw new IOException("timed out");
    }

    /**
     * Set the TTL (time-to-live) option.
     * @param TTL to be set.
     */
    protected void setTTL(byte ttl) throws IOException {
	throw new IOException("this is a read only socket, can not set TTL");
    }	

    protected void setTimeToLive(int ttl) throws IOException {
	throw new IOException("this is a read only socket, can not set TTL");
    }	

    /**
     * Get the TTL (time-to-live) option.
     */
    protected byte getTTL() throws IOException {
	System.out.println("EncapDatagramSocket: getting TTL");
	throw new IOException("this is a read only socket, can not get TTL");
    }

    protected int getTimeToLive() throws IOException {
	System.out.println("EncapDatagramSocket: getting TTL");
	throw new IOException("this is a read only socket, can not get TTL");
    }

    /**
     * Join the multicast group.
     * @param multicast address to join.
     */
    protected void join(InetAddress inetaddr) throws IOException {

	// tell lower layer to filter for this mcastAddr
	mcast = true;
	byte mcastAddrBytes[] = inetaddr.getAddress();

	mcastAddr = ((mcastAddrBytes[0] ) << 24) |
	((mcastAddrBytes[1] & 0xff) << 16) | 
	    ((mcastAddrBytes[2] & 0xff) << 8) |
	    (mcastAddrBytes[3] & 0xff);

    }

    /**
     * Leave the multicast group.
     * @param multicast address to leave.
     */
    protected void leave(InetAddress inetaddr) throws IOException {
	mcast = false;
	mcastAddr = 0;
    }

    /**
     * Close the socket.
     */
    protected void close() {
	if (fd != null) {
	    //((EncapIPStream)inStream).setTransfer(false);
	    //((EncapIPStream)inStream).setOpen(false);
	    try {
		source.stop();
	    } catch (IOException ioe) {
	    }
	    source.disconnect();
	    inStream = null; // XXX anything else? datasource to disconnect?
	    fd = null;
	    InterfaceMapImpl.returnToAddrPool(localAddr);
	    localAddr = null;
	}
    }

    protected synchronized void finalize() {
	close();
    }

    /**
     * set a value - since we only support (setting) binary options 
     * here, o must be a Boolean
     */

     public void setOption(int optID, Object o) throws SocketException {
	 switch (optID) {
	    /* check type safety b4 going native.  These should never
	     * fail, since only java.Socket* has access to 
	     * PlainSocketImpl.setOption().
	     */
	 case SO_TIMEOUT:
	     if (o == null || !(o instanceof Integer)) {
		 throw new SocketException("bad argument for SO_TIMEOUT");
	     }
	     int tmp = ((Integer) o).intValue();
	     if (tmp < 0) 
		 throw new IllegalArgumentException("timeout < 0");
	     timeout = tmp;
	     return;
	 case SO_BINDADDR:
	     throw new SocketException("Cannot re-bind Socket");
	 case SO_REUSEADDR:
	     if (o == null || !(o instanceof Integer)) {
		 throw new SocketException("bad argument for SO_REUSEADDR");
	     } 
	     break;
	 case IP_MULTICAST_IF:
	     if (o == null || !(o instanceof InetAddress))
		 throw new SocketException("bad argument for IP_MULTICAST_IF");
	     localAddr = (InetAddress) o; // set local addr
	     break;
	 default:
	     throw new SocketException("invalid option: " + optID);
	 }
	 // I don't think you should be able to set the option on this socket
	 // other than timeout.
	 // XXX ?
     }

    /*
     * get option's state - set or not
     */

    public Object getOption(int optID) throws SocketException {
	if (optID == SO_TIMEOUT) {
	    return new Integer(timeout);
	}
	//	int ret = socketGetOption(optID);

	if (optID == SO_BINDADDR)
	    //	    InetAddress in = new InetAddress();
	    // in.address = ret;
	    // return in;
	    
	    return localAddr;

	if ( optID == IP_MULTICAST_IF) {
	    throw new SocketException("no interface for sending for read only socket");
	} else {
	    return null;
	}
    }

    /**
     * transferData
     *
     * This is SourceTransferHandler interface's method. It's supposedly
     * called when there is data on the stream to be read.
     *
     * I'm hoping one transfer size is equal to a packet. 
     */
    public void transferData(PushSourceStream stream) {

	int minSize = stream.getMinimumTransferSize();
	int size = ( minSize > MTU ) ? minSize : MTU;
	int readBytes = 0;
	byte buf[] = new byte[size];

	if (!stream.endOfStream() ) {
	    try {
		readBytes = ((PushSourceStream2)stream).readStream(buf, 0, size);
	    } catch (DataLostException dle) {
		// XXX throw a new exception
	    } catch (IOException ioe) {
		// XXX throw a new exception
	    }
	    
	    if (readBytes < 0) {
		// XXX close this stream
		System.out.println("EncapDSI: in transferData,end1,close the stream");
		//		((EncapIPStream)stream).setTransfer(false);
		//((EncapIPStream)stream).setOpen(false);
		try {
		    source.stop();
		} catch (IOException ioe) {
		}
		source.disconnect();
	    } else if (readBytes > 0 ) // do nothing if it's 0
		dumpBuf(buf, readBytes);
	} else {
	    // XXX close the stream
	    System.out.println("EncapDSI: in transferData,end2,close the stream");
	    //	    ((EncapIPStream)stream).setTransfer(false);
	    //((EncapIPStream)stream).setOpen(false);
	    try {
		source.stop();
	    } catch (IOException ioe) {
	    }

	    source.disconnect();

	}
    }

    /**
     * dumpBuf takes a byte array and its content length, make a
     * GenericPacket out of it, then add the packet to a vector. This
     * buffer keeps all the data transfered from the PushSourceStream2
     * that's not been read by the socket yet.
     *
     * private variable -- inBuf, init to Vector() at declaration time
     * @param buf -- new byte array to be added
     * @param length -- length of content in this byte array 
     */
    private void dumpBuf(byte[] buf, int length) {

	synchronized (inBuf) {

	    System.out.println("EncapDSI:dumpingBuf");
	    GenericPacket pkt = new GenericPacket(0, length);
	    pkt.putBytes(buf, 0, 0, length);
	    inBuf.addElement(pkt);

	    if (inBuf.isEmpty()) {
		System.out.println("EncapDSI:inBuf is still empty");
	    } else {
		System.out.println("EncapDSI:inBuf has stuff");
	    }
	}
    }

    
}

