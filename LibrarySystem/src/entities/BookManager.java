package entities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BookManager {
	private List <Book> books = new ArrayList <> ();
	private List <Users> user = new ArrayList <> ();
	SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
	public void Menu(Scanner scanner) throws ParseException 
	{
		
		
		int sel;
		try {
			do {
	            System.out.println("MENU: ");
	            System.out.println("1- CADASTRAR LIVROS: ");
	            System.out.println("2- CADASTRAR USUARIOS: ");
	            System.out.println("3- PESQUISAR POR TÍTULO: ");
	            System.out.println("4- PESQUISAR POR AUTOR: ");
	            System.out.println("5- SAIR");
	            sel = scanner.nextInt();
	            scanner.nextLine();
	
	            switch (sel) {
	                case 1:
	                    cadastrarLivro(scanner);
	                    break;
	                case 2:
	                	cadastrarUsuario(scanner);
	                	break;
	                case 3:
	                    procurarPorTitulo(scanner);
	                    break;
	                case 4:
	                    procurarPorAutor(scanner);
	                    break;
	                case 5:
	                    System.out.println("Encerrando...");
	                    break;
	                default:
	                    System.out.println("Opção inválida.");
	            }
	        } while (sel != 5);
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
	
	public void cadastrarUsuario(Scanner sc) throws ParseException
	{
		char opcao = 's';
		
		do {
			System.out.print("Nome do usuario: ");
			String name = sc.nextLine();
			System.out.print("Idade: ");
			int idade = sc.nextInt();
			System.out.print("CPF: ");
			sc.nextLine();
			String cpf = sc.nextLine();
			System.out.print("Endereço: ");
			String endereco = sc.nextLine();
			System.out.print("Telefone: ");
			String telefone = sc.nextLine();
			System.out.print("Email: ");
			String email = sc.nextLine();
			System.out.print("Data de nascimento: ");
			Date dataNasc = sdf.parse(sc.next());
			Users users = new Users(name, idade, cpf, endereco, telefone, email, dataNasc);
			user.add(users);
			System.out.println();
			
			System.out.print("Deseja cadastrar outro usuario?(s/n) ");
			opcao = sc.next().charAt(0);
			sc.nextLine();
		} while (opcao != 'n');
				
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
	
	public void arquivarUsers() throws ParseException 
	{
		String path = "c://temp//users.txt";
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path,true)))
		{
			for (Users u : user)
			{
				bw.write(StringUser());
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
	
	public void addUsers(Users users)
	{
		user.add(users);
	}
	
	public void removeUsers(Users users)
	{
		user.remove(users);
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
	
	public String StringUser() throws ParseException
	{
		StringBuilder arq = new StringBuilder();
		for (Users u : user)
		{
			arq.append("Nome: ").append(u.getName() + "\n").append("Idade: ").append(u.getIdade() + "\n").append("CPF: ").append(u.getCpf() + "\n").append("Endereço: ").append(u.getEmail() + "\n").
			append("Telefone: ").append(u.getTelefone() + "\n").append("Email: ").append(u.getEmail() + "\n").append("Data de nascimento: ").append(sdf.parse(u.getDataNascimento().toString()) + "\n");
		}
		return arq.toString();
	}
}