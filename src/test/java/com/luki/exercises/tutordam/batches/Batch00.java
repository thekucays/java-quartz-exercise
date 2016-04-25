package com.luki.exercises.tutordam.batches;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class Batch00 implements BatchInterface, Job{

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		Batch00 batch = new Batch00();
		batch.doBatch();
	}

	public void doBatch() {
		System.out.println("hello world! this is Batch00.java doing doBatch() method! Have fun :)");
	}

}
