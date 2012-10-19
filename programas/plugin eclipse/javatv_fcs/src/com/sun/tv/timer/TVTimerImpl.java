/*
 * @(#)TVTimerImpl.java        1.27 00/08/27
 *
 * Copyright 1998-2000 by Sun Microsystems, Inc.,
 * 901 San Antonio Road, Palo Alto, California, 94303, U.S.A.
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information
 * of Sun Microsystems, Inc. ("Confidential Information").  You
 * shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * you entered into with Sun.
 *
 */
package com.sun.tv.timer;

import com.sun.util.*;
import javax.tv.util.*;

import java.util.Hashtable;

public class TVTimerImpl extends TVTimer implements PTimerWentOffListener {
    private static PTimer ptimer = null;
    private static Hashtable spec_hash = null;
    private static Hashtable reverse_hash = null;

    private static Hashtable ptimer_hashed_by_tv = null;
    private static Hashtable tv_timer_hashed_by_p = null;

    private static TVTimerImpl impl = null;

    public TVTimerImpl(){


	if(ptimer == null){
	    ptimer = PTimer.getTimer();

	    // ------
	    spec_hash = new Hashtable();
	    reverse_hash = new Hashtable();
	    // ------
	    ptimer_hashed_by_tv = new Hashtable();
	    tv_timer_hashed_by_p = new Hashtable();
	}
    }

    
    public PTimer getPTimer(){
	return ptimer;
    }
    
    public void putTVTimerSpec(TVTimerSpec spec){
	PTimerSpec tmp;

	spec_hash.put(spec, tmp = new PTimerSpec());
	reverse_hash.put(tmp , spec);
	    
    }

    public PTimerSpec getTVTimerSpec(TVTimerSpec spec){

	return (PTimerSpec)spec_hash.get(spec);
    }

    public TVTimerSpec tvFromPTimer(PTimerSpec spec){
	return (TVTimerSpec)reverse_hash.get(spec);
	
    }

    /**
     * is called when one of the PTimers (associated with a TVTimer)
     * went off
     */
    public void timerWentOff(PTimerWentOffEvent evt){
	// find PTimer
	// get TVTimer
	// notify TVTimer listeners


	PTimerSpec pt_spec = evt.getTimerSpec();

	TVTimerSpec tv_spec = (TVTimerSpec)tv_timer_hashed_by_p.get(pt_spec);

	if(tv_spec != null){
	    tv_spec.notifyListeners(this);
	} else {
	    System.out.println("TV TIMER NOT FOUND!");
	}
	

    }

    /**
     * Returns the default timer for the system.
     * There may be one TVTimer instance per virtual machine,
     * one per applet, one per call to getTimer, or some other platform 
     * dependent implementation.
     * @return A non-null TVTimer object.
     */
    public static TVTimer getTimer() {

	if(impl == null){
	    impl = new TVTimerImpl();
	}
	
	return impl;
    }

    /**
     * Begins monitoring a TVTimerSpec.  <p>When the timer
     * specification should go off, the timer will call
     * TVTimerSpec.notifyListeners. </p> 
     * 
     * <p> Returns the real TVTimerSpec that got scheduled. If you schedule a
     * spec that implies a smaller granularity than this timer can provide,
     * or a repeat timer spec that has a smaller repeating interval than
     * this timer can provide, the timer should round to the closest value 
     * and return that value as a {@link TVTimerSpec} object. An interested application
     * can use accessor methods {@link #getMinRepeatInterval} and {@link #getGranularity} to 
     * obtain the Timer's best knowledge of the Timer's limitation on 
     * granularity and repeat interval. If you schedule an 
     * absolute specification that should have gone off already, it will 
     * go off immediately. If the scheduled specification can not be met
     * at all, the exception {@link TVTimerScheduleFailedException} should be 
     * thrown. </p>
     * 
     * <p>You may schedule a timer specification with multiple timers.
     * You may schedule a timer specification with the same timer
     * multiple times (in which case it will go off multiple times).  If
     * you modify a timer specification after it has been scheduled
     * with any timer, the results are unspecified.</p>
     *
     * @param t The timer specification to begin monitoring.  
     * @return The real TVTimerSpec that was scheduled.
     * @exception TVTimerScheduleFailedException is thrown when the scheduled 
     *            spec can not be met at all.
     */
    public TVTimerSpec scheduleTimerSpec(TVTimerSpec t) throws TVTimerScheduleFailedException {

	if (t == null) {
		throw new NullPointerException();
	}
	
	PTimerSpec tmp_pts = null;
	// return ptimer.scheduleTimerSpec(t);
	
// 	try {
// 	    System.out.println("...entering schedule");
// 	    ptimer.scheduleTimerSpec(getTVTimerSpec(t));
// 	    System.out.println("........scheduled sucessfully");
// 	} catch(PTimerScheduleFailedException e){
// 	    throw new TVTimerScheduleFailedException();
// 	}

	//	System.out.println("check to see if Ptimer for this TV is hashed");
	tmp_pts = (PTimerSpec)ptimer_hashed_by_tv.get(t);
	
	if(tmp_pts == null){ // not hashed
	    // create the new PTimerSpec...
	    //  System.out.println("Creating Ptimer");
	    tmp_pts = new PTimerSpec();

	    tmp_pts.setAbsolute(t.isAbsolute());
	    if(t.isAbsolute()){
		tmp_pts.setAbsoluteTime(t.getTime());
	    } else {
		tmp_pts.setDelayTime(t.getTime());
	    }
	    
	    tmp_pts.setRegular(t.isRegular());
	    tmp_pts.setRepeat(t.isRepeat());

	    ptimer_hashed_by_tv.put(t, tmp_pts);
	    tv_timer_hashed_by_p.put(tmp_pts, t);

	    tmp_pts.addPTimerWentOffListener(this);
	    
	}
	//System.out.println("Scheduling Ptimer");
	ptimer.schedule(tmp_pts);

	return t;
    }


    /**
     * Removes a timer specification from the set of monitored specifications.
     * The descheduling happens as soon as practical, but may not happen immediately.
     * If the timer specification has been scheduled multiple times with this
     * timer, all the schedulings are cancelled.
     * @ param t The timer specification to end monitoring.
     */
    public void deschedule(TVTimerSpec t){

	if (t == null) {
		throw new NullPointerException();
	}

	PTimerSpec tmp_pts = (PTimerSpec)ptimer_hashed_by_tv.get(t);
	
	if(tmp_pts != null){
	    ptimer.deschedule(tmp_pts);
	    // should it be removed from the hashes?
	}
    }

    /**
     * Report the minimum interval that this timer can repeat tasks. 
     * For example, it's perfectly reasonable for a Timer to specify that
     * the minimum interval for a repeatedly performed task is 1000 msec in 
     * between every run. This is to avoid possible system overloading.
     *
     * @return The timer's best knowledge of minimum repeat interval
     * in mili-seconds. Return -1 if this timer doesn't know its repeating
     * interval limitation.
     */
    public long getMinRepeatInterval(){
	return ptimer.getMinRepeatInterval();
    }

    /**
     * Report the granularity of this timer, i.e. the length of time between
     * "tick"s of this timer. 
     *
     * @return The timer's best knowledge of the granularity in
     * mili-seconds. Return -1 if this timer doesn't know its granularity. 
     *
     */
    public long getGranularity(){
	return ptimer.getGranularity();
    }

}
