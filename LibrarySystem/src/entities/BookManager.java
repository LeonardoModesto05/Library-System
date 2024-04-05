package entities;

import java.util.ArrayList;
import java.util.List;

public class BookManager {
	private List <Book> books = new ArrayList <> ();
	
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
}