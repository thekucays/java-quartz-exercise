package com.luki.exercises.tutordam.batches;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class Batch01 implements BatchInterface, Job{

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		Batch01 batch = new Batch01();
		batch.doBatch();
	}

	public void doBatch() {
		System.out.println("hello world! this is Batch01.java doing doBatch() method! Have fun guys :)");
	}

}
