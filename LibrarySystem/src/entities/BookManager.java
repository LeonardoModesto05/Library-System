package entities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BookManager {
	private List <Book> books = new ArrayList <> ();
	
	
	public void Menu(Scanner scanner) 
	{
		
		
		int sel;
		try {
			do {
	            System.out.println("MENU: ");
	            System.out.println("1- CADASTRAR: ");
	            System.out.println("2- PESQUISAR POR TÍTULO: ");
	            System.out.println("3- PESQUISAR POR AUTOR: ");
	            System.out.println("4- SAIR");
	            sel = scanner.nextInt();
	            scanner.nextLine();
	
	            switch (sel) {
	                case 1:
	                    cadastrarLivro(scanner);
	                    break;
	                case 2:
	                    procurarPorTitulo(scanner);
	                    break;
	                case 3:
	                    procurarPorAutor(scanner);
	                    break;
	                case 4:
	                    System.out.println("Encerrando...");
	                    break;
	                default:
	                    System.out.println("Opção inválida.");
	            }
	        } while (sel != 4);
		} catch(InputMismatchException e)
		{
			System.out.println("Digite o valor correto");
		}
	}
	
	public void cadastrarLivro(Scanner scanner) 
	{
		char opcao = 's';
		
		
        while (opcao == 's') {
            System.out.printf("Escreva o título do livro: ");
            String titulo = scanner.nextLine();
            System.out.printf("Escreva o autor do livro: ");
            String autor = scanner.nextLine();
            System.out.printf("Escreva a data de publicação: ");
            int yearPublication = scanner.nextInt();
            scanner.nextLine();
            Book book = new Book(titulo, autor, yearPublication);
            books.add(book);

            System.out.println("Deseja cadastrar mais livros?(s/n) ");
            opcao = scanner.next().charAt(0);
            scanner.nextLine();
        }
	}
	
	public void arquivarLivros()
	{
		String path = "c://temp//books.txt";
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path,true)))
		{
			for (Book book : books)
			{
				bw.write(toString());
				bw.newLine();
			}
			bw.flush();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void procurarPorTitulo(Scanner scanner)
	{
		System.out.println("Digite o nome do título: ");
		String title = scanner.nextLine();
		List <Book> titulo = searchByTitle(title);
		System.out.println("Livros encotrados pelo nome: " + title);
		for (Book book : titulo)
		{
			System.out.println("- " + book.getTitle() + " por " + book.getAuthor());
		}
	}
	
	public void procurarPorAutor(Scanner scanner)
	{
		System.out.println("Digite o nome do autor: ");
		String author = scanner.nextLine();
		List<Book> autor = searchByAuthor(author);
		System.out.println("Livros encotrados do autor: " + author);
		for (Book a : autor)
		{
			System.out.println("- " + a.getTitle());
		}
	}
		
	
	public void addBook (Book books)
	{
		this.books.add(books);
	}
	
	public void removeBook (Book books)
	{
		this.removeBook(books);
	}
	
	public List <Book> searchByTitle (String title)
	{
		List <Book> matchingBooks = new ArrayList<> ();
		
		for (Book book : books)
		{
			if (book.getTitle().equalsIgnoreCase(title))
			{
				matchingBooks.add(book);
			}
		}
		return matchingBooks;
	}

	public List <Book> searchByAuthor (String author)
	{
		List <Book> matchingAuthors = new ArrayList<> ();
		
		for (Book book : books)
		{
			if (book.getAuthor().equalsIgnoreCase(author))
			{
				matchingAuthors.add(book);
			}
		}
		return matchingAuthors;
	}
	public String toString() {
	    StringBuilder result = new StringBuilder();
	    for (Book book : books) {
	        result.append("Title: ").append(book.getTitle()).append(" Author: ").append(book.getAuthor()).append(" Year of publication: ").append(book.getPublicationYear()).append("\n");
	    }
	    return result.toString();
	}
}