package com.luki.exercises.tutordam;

import java.io.IOException;
import java.text.ParseException;

import org.quartz.Job;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.triggers.CronTriggerImpl;
//import com.luki.exercises.tutordam.SchedulerFactory;

public class BatchScheduler {
	// dummy total batch
	private static int totalBatch = 2;
	// untuk nyimpen daftar job nya..kalo bingung liat referensi lagi ke com.luki.exercise.tutorweb.CronTrigger.java
	private static JobDetailImpl []job = new JobDetailImpl[totalBatch];
	// untuk nyimpen daftar trigger nya
	private static CronTriggerImpl []trigger = new CronTriggerImpl[totalBatch];
	// dummy expression untuk scheduling trigger nya.. dummy setiap 5 detik
	private static String dummyExpression = "0/5 * * * * ?";
	
	// constructor
	public BatchScheduler() throws ParseException, ClassNotFoundException, IOException{
		// loop batch nya (dummy), insialisasi job dan trigger nya
		for(int i=0; i<totalBatch; i++){
			job[i] = new JobDetailImpl(); // kok bisa yah inisialisasi lagi gini? cari tau
			job[i].setName("job ke : 0" + i);
			job[i].setJobClass((Class<? extends Job>) Class.forName("com.luki.exercises.tutordam.batches.Batch0" + i));
			
			trigger[i] = new CronTriggerImpl();
			trigger[i].setName("trigger ke : 0" + i);
			trigger[i].setCronExpression(dummyExpression);
		}
	}
	
	public static void main(String[] args){
		try{
			// bikin objek baru, supaya konstruktor nya jalan
			BatchScheduler bScheduler = new BatchScheduler();
			
			Scheduler scheduler = com.luki.exercises.tutordam.SchedulerFactory.getInstance();
			scheduler.start();
			
			// inisialisasi schedule nya berdasarkan job dan trigger nya
			for(int i=0; i<totalBatch; i++){
				scheduler.scheduleJob(job[i], trigger[i]);
			}
		}
		catch(SchedulerException se){
			se.printStackTrace();
		}
		catch(ParseException pe){
			pe.printStackTrace();
		}
		catch(ClassNotFoundException cnf){
			cnf.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
