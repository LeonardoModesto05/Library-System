package application;

import java.util.List;
import java.util.Scanner;

import entities.Book;
import entities.BookManager;
import exception.DomainException;

public class Program {

	public static void main(String[] args)  {
		Scanner sc = new Scanner (System.in);
		
		BookManager manager = new BookManager();
		
		manager.Menu(sc);
		
		
		
		
		sc.close();
				
	}

}
