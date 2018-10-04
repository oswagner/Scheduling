package utils;

import java.util.Collection;

import job.Job;

public final class JobUtils {

	public static Job findByArrivalTime(Collection<Job> jobsList, int arrivalTime) {
		return FindUtils.findByProperty(jobsList, job -> arrivalTime == job.getArrivalTime());
	}

	public static Job findByPriority(Collection<Job> jobsList, int priority) {
		return FindUtils.findByProperty(jobsList, job -> priority == job.getPriority());
	}
}
