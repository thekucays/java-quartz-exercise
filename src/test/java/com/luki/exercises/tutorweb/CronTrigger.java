package com.luki.exercises.tutorweb;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class CronTrigger {
	public static void main(String[] args) throws Exception{
		// bikin job nya
		JobDetail job = JobBuilder.newJob(HelloJob.class)
				.withIdentity("dummyJob", "group1")
				.build();
		
		// bikin trigger nya
		Trigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity("dummyTrigger", "group1")
				.withSchedule(
						// untuk referensi cron expression nya, bisa merujuk ke..
						// ..http://www.quartz-scheduler.org/documentation/quartz-2.x/tutorials/tutorial-lesson-06.html
						CronScheduleBuilder.cronSchedule("0/5 * * * * ?")
				)
				.build();
		
		// schedule job berdasarakan trigger nya
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);
	}
}