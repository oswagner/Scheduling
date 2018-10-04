package schedulingStrategy;

import job.Job;
import utils.CircularLinkedList;

public class Scheduler {
	private CircularLinkedList<Job> readyQueue;

	public Scheduler() {
		readyQueue = new CircularLinkedList<Job>();
	}

	// adiciona um process na fila
	public void addProcess(Job p) {
		readyQueue.add(p);
	}

	// remove um processo da fila
	public void removeProcess(int p) {
		readyQueue.remove(p);
	}

	// retorna um processo pela posicão
	public Job getProcess(int position) {
		return readyQueue.get(position);
	}

	// verificar de se a fila está vazia
	public boolean readyQueueEmpty() {
		return readyQueue.isEmpty();
	}

	// retorna o tamanho da fila
	public int readyQueueSize() {
		return readyQueue.size();
	}

	// rotaciona a fila
	public void rotateReadyQueue() {
		readyQueue.rotate();
	}
}
