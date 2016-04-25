package com.luki.exercises.tutordam;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

public class SchedulerFactory {
	private volatile static Scheduler scheduler;
	
	private SchedulerFactory(){ 
		// Prevent instantiate
	}
	
	public static Scheduler getInstance() throws SchedulerException{
		if(scheduler == null){
			synchronized (SchedulerFactory.class) {
				if(scheduler == null){
					scheduler = new StdSchedulerFactory().getScheduler();
				}
			}
		}
		return scheduler;
	}
}
