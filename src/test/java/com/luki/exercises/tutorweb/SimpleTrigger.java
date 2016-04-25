package com.luki.exercises.tutorweb;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;

/*
 * class SimpleTrigger dan CronTrigger berdiri sendiri..ga pake factory kaya yang lain 
 */

public class SimpleTrigger {
	public static void main(String[] args) throws Exception{
		// bikin job yang akan di schedule
		JobDetail job = JobBuilder.newJob(HelloJob.class)
				.withIdentity("dummyJobName", "group1").build();  // withidentity(name, group)
		
		// bikin trigger untuk job nya
		Trigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity("dummyTriggerName", "group1")
				.withSchedule(
					SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever()   // jalan setiap 'n' second
				)
				.build();
		
		// baru deh di schedule
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);
	}
}
