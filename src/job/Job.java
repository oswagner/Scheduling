package job;

public class Job {

	int id;
	int arrivalTime;
	int executionTime;
	int priority;
	int initialIOTime;

	int responseTime;
	int completionTime;

	public Job(int id, int arrivalTime, int executionTime, int priority) {
		this.id = id;
		this.arrivalTime = arrivalTime;
		this.executionTime = executionTime;
		this.priority = priority;
		this.initialIOTime = -1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(int executionTime) {
		this.executionTime = executionTime;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getInitialIOTime() {
		return initialIOTime;
	}

	public void setInitialIOTime(int initialIOTime) {
		this.initialIOTime = initialIOTime;
	}

	public int getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(int responseTime) {
		this.responseTime = responseTime;
	}

	public int getCompletionTime() {
		return completionTime;
	}

	public void setCompletionTime(int completionTime) {
		this.completionTime = completionTime;
	}

	@Override
	public String toString() {
		return "Job [arrivalTime=" + arrivalTime + ", executionTime=" + executionTime + ", priority=" + priority
				+ ", initialIOTime=" + initialIOTime + "]";
	}
}

/*
 * número de processos, tamanho de fatia de tempo, e para cada processo, tempo
 * de chegada, tempo de execução, prioridade (1 até 9 - prioridade 1 é a melhor)
 * e tempos de acesso a operações de E/S (tempo correspondente a sua execução).
 */

/*
 * EXEMPLO ENTRADA
 * 
 * 5 - número de processos 3 - tamanho de fatia de tempo --------- jobs ---- 3 -
 * tmp chegada 10 - tmp execução 2 - prioridade 5 - tmp chegada 12 - tmp
 * execução 1 - prioridade 9 - tmp chegada 15 - tmp execução 2 - prioridade 11 -
 * tmp chegada 15 - tmp execução 1 - prioridade 12 - tmp chegada 8 - tmp
 * execução 5 - prioridade 2 - tempo inicial E/S 35 - tmp chegada 15- tmp
 * execução 2 - prioridade 4 - tempo inicial E/S 8 - tempo inicial E/S 12 -
 * tempo inicial E/S 1 - tmp chegada 15- tmp execução 2 - prioridade 5 - tempo
 * inicial E/S 10 - tempo inicial E/S
 * 
 */