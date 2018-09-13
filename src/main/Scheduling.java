package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Scheduling {

	static String CONTEXT_CHANGE = "C";
	static int READ_WRITE_TIME = 4;

	public static void main(String[] args) {
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
			// TODO: armazenar numero total de processos
			
			// tamanho de fatia de tempo
			line = bufferReader.readLine();
			// TODO: armezenar fatia de tempo (tempo de execução dentro do processador) == quantum
			
			while((line = bufferReader.readLine()) != null) {
				String[] jobElements;
				jobElements = line.split(" ");
				//TODO: Criar processos com seus elementos e adicionar na fila de processos na ordem de execução
				System.out.println("================================================");
				for (String e : jobElements) {
					System.out.println(e);
				}
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

	}

}
