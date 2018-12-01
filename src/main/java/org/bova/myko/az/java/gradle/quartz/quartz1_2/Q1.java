package org.bova.myko.az.java.gradle.quartz.quartz1_2;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

// http://www.quartz-scheduler.org/
public class Q1 {

    public static void main(String[] args) throws SchedulerException {
        System.out.println("Hi");

        // Grab the Scheduler instance from the Factory
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        // and start it off
        scheduler.start();

        // define the job and tie it to our MyJob class
        JobDetail job = newJob(MyJob.class)
                .withIdentity("job1", "group1")
                .build();

        JobDetail job2 = newJob(MyJob2.class)
                .withIdentity("job2", "group2")
                .build();

        // Trigger the job to run now, and then repeat every 40 seconds
        Trigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(40)
                        .repeatForever())
                .build();

        Trigger trigger2 = newTrigger()
                .withIdentity("trigger2", "group2")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(40)
                        .repeatForever())
                .build();

        // Tell quartz to schedule the job using our trigger
        scheduler.scheduleJob(job, trigger);
        scheduler.scheduleJob(job2, trigger2);

    }

}
