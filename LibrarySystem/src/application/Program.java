package application;

import java.util.List;
import java.util.Scanner;

import entities.Book;
import entities.BookManager;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		BookManager manager = new BookManager();
		int sel;
		
		do
		{
			System.out.println("MENU: ");
			System.out.println("1- CADASTRAR: ");
			System.out.println("2- PESQUISAR POR TÍTULO: ");
			System.out.println("3- PESQUISAR POR AUTOR: ");
			System.out.println("4- SAIR");
			sel = sc.nextInt();
			sc.nextLine();
			
			switch (sel)
			{
				case 1:
					char opcao = 's';
					while (opcao == 's') {
						System.out.printf("Escreva o título do livro: ");
						String titulo = sc.nextLine();
						System.out.printf("Escreva o autor do livro: ");
						String autor = sc.nextLine();
						System.out.printf("Escreva a data de publicação: ");
						int yearPublication = sc.nextInt();
						Book book = new Book(titulo, autor, yearPublication);
						manager.addBook(book);
						
						System.out.println("Deseja cadastrar mais livros?(s/n) ");
						opcao = sc.next().charAt(0);
						sc.nextLine();
						
					} 
					break;
				case 2: 
					
					System.out.println("Escreva o nome do título: ");
					String titulo = sc.nextLine();
					List <Book> books =  manager.searchByTitle(titulo);
					System.out.println("Livros encontrados com o nome: " + titulo);
					for (Book livro : books)
					{
						System.out.println("- " + livro.getTitle() + " por " + livro.getAuthor());
					}
					break;
				case 3: 
					System.out.println("Escreva o nome do autor: ");
					String autor = sc.nextLine();
					List <Book> author = manager.searchByAuthor(autor);
					System.out.println("Livros encontrados do autor: " + autor);
					for (Book a : author)
					{
						System.out.println("- " + a.getTitle());
					}
					break;
				case 4: 
					System.out.println("Encerrando...");
			}
		} while (sel != 4);
		
		
		
		
		
		sc.close();
				
	}

}
