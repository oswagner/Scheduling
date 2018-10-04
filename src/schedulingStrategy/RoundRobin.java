package schedulingStrategy;

import java.util.ArrayList;

import job.Job;
import utils.JobUtils;

public class RoundRobin extends Scheduler {

	double avgResponseTime;
	double waitTime;
	int quantum;
	int totalJobs;
	Job runningJob;
	int CPUTime;

	public RoundRobin() {
		super();
		this.CPUTime = 0;
		this.runningJob = null;
	}

	public int getTotalJobs() {
		return totalJobs;
	}

	public void setTotalJobs(int totalJobs) {
		this.totalJobs = totalJobs;
	}

	public int getQuantum() {
		return quantum;
	}

	public void setQuantum(int quantum) {
		this.quantum = quantum;
	}

	public void run(ArrayList<Job> allJobs) {
		int jobCounter = 0;
		// CPU começa ocioso
		boolean CPUIdle = true;
		while (CPUIdle) {
			runningJob = JobUtils.findByArrivalTime(allJobs, CPUTime);
			if (runningJob != null) {
				CPUIdle = false;
				// adiciona o primeiro processo na fila ready
				addProcess(runningJob);
				jobCounter++;
				// adiciona no processo o seu tempo de resposta
				runningJob.setResponseTime(CPUTime - runningJob.getArrivalTime());
			} else {
				System.out.print("-");
				CPUTime++;
			}
		}

		// caso tenha mais de um processo com o mesmo tempo de chegada adiciona todos na
		// fila ready
		while (jobCounter != totalJobs && allJobs.get(jobCounter).getArrivalTime() == CPUTime) {
			addProcess(allJobs.get(jobCounter));
			jobCounter++;
		}

		while (true) {
			// veririfica se ainda existes processos par serem adicionados na fila ready
			while ((jobCounter != totalJobs) && readyQueueEmpty()) {
				if (allJobs.get(jobCounter).getArrivalTime() == CPUTime) {
					addProcess(allJobs.get(jobCounter)); // adiciona na fila
					// como a fila estava vazia altera o processo que estava executando para o
					// inicio da fila
					runningJob = getProcess(0);
					// adiciona no processo o seu tempo de resposta
					runningJob.setResponseTime(CPUTime - runningJob.getArrivalTime());
					jobCounter++;
				} else {
					// não processos a serem adicionados a CPU fica idle
					CPUTime++;
				}
			}

			// imprime a troca de contexto
			System.out.print("C");

			for (int i = 0; i < quantum; i++) {
				// executa de fato o processo
				int executionTime = runningJob.getExecutionTime();
				if (executionTime != 0) {
					// subtrai o tempo de execução do processo em 1 unidade de tempo
					runningJob.setExecutionTime(executionTime - 1);
					// incrementa o tempo de CPU
					CPUTime++;

					// verifica se ao executar o processo acima, nenhum outro processo chegou para
					// execução
					while ((jobCounter != totalJobs) && allJobs.get(jobCounter).getArrivalTime() == CPUTime) {

						// TODO: Lidar com a prioridade quando um novo processo chega para execução
						if (allJobs.get(jobCounter).getPriority() < runningJob.getPriority()) {
							addProcess(allJobs.get(jobCounter));
//							---C1C222C222C444C222C444C222C444C444C444C11C333C111C333C111C333C1C333C333C55C---C5C555C55
//							---C122C222C222C111C333C222C444C555C22CCCCCC
						}

						// TODO: lidar com chamada de I/O

						// adiciona o novo processo na fila ready
						addProcess(allJobs.get(jobCounter));
						jobCounter++;
					}

					// imprime processo que foi executado
					System.out.print(runningJob.getId());

					// se o processo que estava executando terminou de executar
					if (runningJob.getExecutionTime() == 0) {
						// adiciona o tempo total desde sua chegada até o fim de sua execução
						runningJob.setCompletionTime(CPUTime);
						// libera o CPU pois não precisa mais executar
						break;
					}
				}
			}

			// se a fila não esta vazia ainda existem outros processos para executar
			if (!readyQueueEmpty()) {

				// se o processo que estava na CPU estiver executado por completo, remove da
				// fila ready
				if (runningJob.getExecutionTime() == 0) {
					// remove o processo que está no inicio da fila
					removeProcess(0);
				} else {
					// se nenhum processo foi removido até o momento giramos a fila
					rotateReadyQueue();
					// atualizamos o processo que está em excução na CPU
					runningJob = getProcess(0);
				}
			} else if (readyQueueEmpty() && jobCounter == totalJobs) {
				// se a fila ready está vazia e o total de processos foi atigindo paramos a
				// execução
				break;
			}
		}
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
