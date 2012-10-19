/*
 * @(#)IncompatibleSourceException.java	1.3 98/03/28
 *
 * Copyright 1996-1998 by Sun Microsystems, Inc.,
 * 901 San Antonio Road, Palo Alto, California, 94303, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of Sun Microsystems, Inc. ("Confidential Information").  You
 * shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * you entered into with Sun.
 */

package javax.media;

/**
 * An <CODE>IncompatibleSourceException</CODE> is thrown
 * by a <CODE>MediaHandler</CODE> when <code>setSource</code>
 * is invoked and the <code>MediaHandler</code> cannot
 * support the <code>DataSource</code>.
 * <p>
 **/

public class IncompatibleSourceException extends MediaException {

    public IncompatibleSourceException() {
	super();
    }
    
    public IncompatibleSourceException(String reason) {
	super(reason);
    }
}
