package main;

import java.util.Comparator;

import job.Job;

public class JobPriorityComparator implements Comparator<Job> {

	@Override
	public int compare(Job job1, Job job2) {
		if (job1.getPriority() < job2.getPriority()) {
			return -1;
		} else if (job1.getPriority() == job2.getPriority()) {
			return 0;
		} else {
			return 1;
		}
	}

}
