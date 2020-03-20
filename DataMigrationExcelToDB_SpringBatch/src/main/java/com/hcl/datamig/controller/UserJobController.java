	package com.hcl.datamig.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author saluri
 *
 */
@RestController
@RequestMapping("/api/job")
public class UserJobController {

	@Autowired
	JobLauncher jobLauncher;
	
	@Autowired
	@Qualifier("createUserJob")
      Job createJob;

	@GetMapping("/launch")
	public String startUserJob() {
		String status="job failure";
	try {
		JobExecution execution=jobLauncher.run(createJob,new JobParametersBuilder().addLong("accountJob",System.currentTimeMillis()).toJobParameters());
		status =execution.getStatus().getBatchStatus().toString();
	} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
			| JobParametersInvalidException e) {
		e.printStackTrace();
	    status="Failure In application";
	}
		return status;
	}
}
