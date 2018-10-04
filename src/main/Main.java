package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import job.Job;
import schedulingStrategy.RoundRobin;

public class Main {

	static int READ_WRITE_TIME = 4;

	static RoundRobin scheduling;
	
	static final String FILENAME = "trab-so1-teste4";

	public static void main(String[] args) {
		scheduling = new RoundRobin();
		
		ArrayList<Job> allJobs = new ArrayList<>();
		FileReader file = null;
		try {
			file = new FileReader(FILENAME);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		BufferedReader bufferReader = new BufferedReader(file);
		String line;

		try {

			// número de processos
			line = bufferReader.readLine();
			scheduling.setTotalJobs(Integer.parseInt(line));

			// tamanho de fatia de tempo
			line = bufferReader.readLine();
			scheduling.setQuantum(Integer.parseInt(line));

			int i = 1;
			while ((line = bufferReader.readLine()) != null) {
				String[] jobElements;
				jobElements = line.split(" ");
				Job job = new Job(i, Integer.parseInt(jobElements[0]), Integer.parseInt(jobElements[1]),
						Integer.parseInt(jobElements[2]));
				if (jobElements.length == 4) {
					job.setInitialIOTime(Integer.parseInt(jobElements[3]));
				}
				i++;
				allJobs.add(job);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferReader.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
		scheduling.run(allJobs);
	}

}
