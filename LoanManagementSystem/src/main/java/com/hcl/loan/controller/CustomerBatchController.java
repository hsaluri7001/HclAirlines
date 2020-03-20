package com.hcl.loan.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/job")
public class CustomerBatchController {

@Autowired
private JobLauncher jobLauncher;

@Autowired
private Job customerJob;

	@GetMapping("/launch")
	public String customerJobLauncher() {
		String status="job failed";
		try {
			jobLauncher.run(customerJob, new JobParametersBuilder().addLong("customerJob",System.currentTimeMillis()).toJobParameters());
			status="jobCompleter";
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;

	}

}
