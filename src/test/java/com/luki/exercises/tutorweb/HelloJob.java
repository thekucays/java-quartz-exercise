package com.luki.exercises.tutorweb;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


/*
 * class ini adalah sebuah Job akan di schedule untuk dipanggil
 */


public class HelloJob implements Job{

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("Hello Quartz! this is my first job");
	}

}
