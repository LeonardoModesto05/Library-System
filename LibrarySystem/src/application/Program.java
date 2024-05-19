package application;

import java.text.ParseException;
import java.util.Scanner;

import entities.BookManager;

public class Program {

	public static void main(String[] args) throws ParseException  {
		Scanner sc = new Scanner (System.in);
		
		BookManager manager = new BookManager();
		
		manager.Menu(sc);
		
		manager.arquivarLivros();
		manager.arquivarUsers();
		
		sc.close();
				
	}

}
