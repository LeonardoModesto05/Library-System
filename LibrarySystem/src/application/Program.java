package application;

import java.util.Scanner;

import entities.BookManager;

public class Program {

	public static void main(String[] args)  {
		Scanner sc = new Scanner (System.in);
		
		BookManager manager = new BookManager();
		
		manager.Menu(sc);
		
		manager.arquivarLivros();
		
		
		sc.close();
				
	}

}
