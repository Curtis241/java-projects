package org.sakila.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.StatefulJob;
import org.springframework.scheduling.quartz.QuartzJobBean;


@SuppressWarnings("deprecation")
public class SchedulerJob extends QuartzJobBean implements StatefulJob{

	protected static Logger logger = Logger.getLogger(SchedulerJob.class);
	private static final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	private Worker worker;
	
	@Override
	protected void executeInternal(JobExecutionContext ctx)
			throws JobExecutionException {
		
		try {
			// Retrieve the last date when the job was run
			Date lastDateRun  = ctx.getPreviousFireTime();
			
			// Job was run previously
			if (lastDateRun != null) {
				logger.debug("Last date run: " + sdf.format(lastDateRun));
				
				// Retrieve the number of times this job has been attempted
				int refireCount = ctx.getRefireCount();
				
				if (refireCount > 0) {
					logger.debug("Total attempts: " + refireCount);
				}
			}
			else {
				// Job is run for the first time
				logger.debug("Job is run for the first time");
			}
			
			// Do the actual work
			logger.debug("Delegating work to worker");
			worker.work();
			
			// Retrieve the next date when the job will be run
			String nextDateRun = sdf.format(ctx.getNextFireTime());
			
			logger.debug("Next date run: " + nextDateRun);

		} 
		catch (Exception e) {
			logger.error("Unexpected exception" , e);
			throw new JobExecutionException("Unexpected exception", e, true);
		}
	}

	/**
	 * The worker
	 * <p> 
	 * This is required so that Spring's {@link JobDetailsBean} will
	 * automatically inject the values
	 */ 
	public void setWorker(Worker worker) {
		this.worker = worker;
	}
}
