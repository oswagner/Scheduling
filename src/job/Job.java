package job;

public class Job {
	
	int arrivalTime;
	int executionTime;
	int priority;
	int initialIOTime;
	
	public Job(int arrivalTime, int executionTime, int priority) {
		this.arrivalTime = arrivalTime;
		this.executionTime = executionTime;
		this.priority = priority;
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
	
	
}


/*
 * número de processos,
 * tamanho de fatia de tempo, 
 * e para cada processo, 
 * tempo de chegada, 
 * tempo de execução, 
 * prioridade (1 até 9 - prioridade 1 é a melhor) 
 * e tempos de acesso a operações de E/S (tempo correspondente a sua execução). 
 */

/*
 * EXEMPLO ENTRADA
 * 
 * 5 - número de processos
 * 3 - tamanho de fatia de tempo
 * --------- jobs ----
 * 3 - tmp chegada 10 - tmp execução 2 - prioridade
 * 5 - tmp chegada 12 - tmp execução 1 - prioridade
 * 9 - tmp chegada 15 - tmp execução 2 - prioridade
 * 11 - tmp chegada 15 - tmp execução 1 - prioridade
 * 12 - tmp chegada 8 - tmp execução 5 - prioridade 2 - tempo inicial E/S
 * 
 */