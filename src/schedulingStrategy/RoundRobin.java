package schedulingStrategy;

import java.util.ArrayList;

import job.Job;

public class RoundRobin {

	double avgResponseTime;
	double waitTime;
	int quantum;
	ArrayList<Job> allJobs;
	ArrayList<Job> readyJobs;

	public int getQuantum() {
		return quantum;
	}

	public void setQuantum(int quantum) {
		this.quantum = quantum;
	}

	public void run() {
		//TODO RoundRobin algorithm
	}

}

/*
 * 
 * Além disto imprimir um gráfico (texto) mostrando como os processo foram
 * executados. Considerar uma unidade de tempo para troca de contexto
 * (representado abaixo como C). Tempo começa em 1. Processos iniciam com 1.
 * Processo chega no tempo x e pode começar a executar (respeitando o algoritmo
 * de escalonamento) no tempo x+2 (1 unidade para troca de contexto).
 */

/*
 * https://www.geeksforgeeks.org/program-round-robin-scheduling-set-1/
 * https://www.tutorialspoint.com/operating_system/
 * os_process_scheduling_algorithms.htm
 */
