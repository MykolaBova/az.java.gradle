package org.bova.myko.az.java.gradle.quartz.quartz1_2;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements org.quartz.Job {

    public MyJob() {
    }

    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.err.println("Hello World!  MyJob is executing.");
    }
}
