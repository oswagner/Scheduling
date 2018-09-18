package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import job.Job;
import schedulingStrategy.RoundRobin;

public class Scheduling {

	static String CONTEXT_CHANGE = "C";
	static int READ_WRITE_TIME = 4;

	static ArrayList<Job> allJobs;
	static RoundRobin scheduling;

	public static void main(String[] args) {
		allJobs = new ArrayList<>();
		scheduling = new RoundRobin();
		readFile("InputFile");
	}

	public static void readFile(String fileName) {
		FileReader file = null;
		try {
			file = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		BufferedReader bufferReader = new BufferedReader(file);
		String line;

		try {

			// número de processos
			line = bufferReader.readLine();

			// tamanho de fatia de tempo
			line = bufferReader.readLine();
			scheduling.setQuantum(Integer.parseInt(line));

			while ((line = bufferReader.readLine()) != null) {
				String[] jobElements;
				jobElements = line.split(" ");
				Job job = new Job(Integer.parseInt(jobElements[0]), Integer.parseInt(jobElements[1]),
						Integer.parseInt(jobElements[2]));
				if (jobElements.length == 4) {
					job.setInitialIOTime(Integer.parseInt(jobElements[3]));
				}
				allJobs.add(job);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			Comparator<Job> c = new Comparator<Job>() {

				@Override
				public int compare(Job job1, Job job2) {
					if (job1.getArrivalTime() < job2.getArrivalTime()) {
						return -1;
					} else if (job1.getArrivalTime() == job2.getArrivalTime()) {
						return 0;
					} else {
						return 1;
					}
				}
			};

			allJobs.sort(c);
			try {
				bufferReader.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}

	}

}
