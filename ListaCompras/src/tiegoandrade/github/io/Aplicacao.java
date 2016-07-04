package tiegoandrade.github.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplicacao {
	
	// Constante que armazena o arquivo da lista.
	private static final String LIST_FILE = "lista.txt";
	
	public static void main(String[] args) throws IOException {
		
		// Caso haja registros cadastrados, o método lê esses registros.
		List<String> lista = readFile();
		
		// Identifica se já há itens cadastrados na lista.
		if (lista != null && lista.size() > 0) {
			System.out.println("Esses são os itens já cadastrados: ");
				
			// Laço que lista os itens já cadastrados na lista.
			for (String item : lista) {
				System.out.println("-> " + item);
			}	
		}
		
		// Cria-se um Scanner capaz de ler informações vindas do teclado.
		Scanner keyboard = new Scanner(System.in);
		
		/* 
		 * Variável writer receberá um PrintWriter, 
		 * que será usadada o para escrever no arquivo texto de saída. 
		 */
		
		try (PrintWriter writer = new PrintWriter(new FileWriter(LIST_FILE, true))) {
			
			// Loop
			while (true) {
				
				// Recebe um item que foi inserido pelo teclado.
				System.out.print("Insira um novo item: ");
				String item = keyboard.nextLine();
				
				/* 
				 * Se um item vazio for inserido,desconsidera o que foi digitado
				 * e volta para o início do loop.
				 */
				if (item.trim().length() == 0) {
					continue;
				}
				
				// Se o usuário digitar o número "0", o programa é encerrado.
				if (item.equals("0")) {
					System.out.println("Fim da execução");
					break;
				}
				
				// Grava o item digitado no arquivo de saída.
				writer.println(item);
			}	
		}
	}
		
	// Método que lê os itens cadastrados no arquivo para uma lista.
	private static List<String> readFile() throws IOException {
		
		// Criação de um arquivo que representa a lista de compras.
		File file = new File(LIST_FILE);
			
		// Verifica se o arquivo existe.
		if (!file.exists()) {
				return null;
		}
			
		// Cria a lista onde serão adicionados os itens.
		List<String> lista = new ArrayList<String>();
		
		// Lê o arquivo que contém a lista de compras.
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			
			// Variável do tipo String que armazena o retorno do método "readLine".
			String line;
				
			// Loop que é executado enquanto houver linhas no arquivo para ler
			while ((line = reader.readLine())!= null) {
					
			// Adiciona a linha na lista, eliminando os espaços em branco da linha.
			lista.add(line.trim());
		}
			
		// Retorna a lista.
		return lista;
		}
	}
}

