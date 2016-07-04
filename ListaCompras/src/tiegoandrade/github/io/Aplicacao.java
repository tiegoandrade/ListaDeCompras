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
		
		// Caso haja registros cadastrados, o m�todo l� esses registros.
		List<String> lista = readFile();
		
		// Identifica se j� h� itens cadastrados na lista.
		if (lista != null && lista.size() > 0) {
			System.out.println("Esses s�o os itens j� cadastrados: ");
				
			// La�o que lista os itens j� cadastrados na lista.
			for (String item : lista) {
				System.out.println("-> " + item);
			}	
		}
		
		// Cria-se um Scanner capaz de ler informa��es vindas do teclado.
		Scanner keyboard = new Scanner(System.in);
		
		/* 
		 * Vari�vel writer receber� um PrintWriter, 
		 * que ser� usadada o para escrever no arquivo texto de sa�da. 
		 */
		
		try (PrintWriter writer = new PrintWriter(new FileWriter(LIST_FILE, true))) {
			
			// Loop
			while (true) {
				
				// Recebe um item que foi inserido pelo teclado.
				System.out.print("Insira um novo item: ");
				String item = keyboard.nextLine();
				
				/* 
				 * Se um item vazio for inserido,desconsidera o que foi digitado
				 * e volta para o in�cio do loop.
				 */
				if (item.trim().length() == 0) {
					continue;
				}
				
				// Se o usu�rio digitar o n�mero "0", o programa � encerrado.
				if (item.equals("0")) {
					System.out.println("Fim da execu��o");
					break;
				}
				
				// Grava o item digitado no arquivo de sa�da.
				writer.println(item);
			}	
		}
	}
		
	// M�todo que l� os itens cadastrados no arquivo para uma lista.
	private static List<String> readFile() throws IOException {
		
		// Cria��o de um arquivo que representa a lista de compras.
		File file = new File(LIST_FILE);
			
		// Verifica se o arquivo existe.
		if (!file.exists()) {
				return null;
		}
			
		// Cria a lista onde ser�o adicionados os itens.
		List<String> lista = new ArrayList<String>();
		
		// L� o arquivo que cont�m a lista de compras.
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			
			// Vari�vel do tipo String que armazena o retorno do m�todo "readLine".
			String line;
				
			// Loop que � executado enquanto houver linhas no arquivo para ler
			while ((line = reader.readLine())!= null) {
					
			// Adiciona a linha na lista, eliminando os espa�os em branco da linha.
			lista.add(line.trim());
		}
			
		// Retorna a lista.
		return lista;
		}
	}
}

