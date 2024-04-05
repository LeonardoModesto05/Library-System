package entities;

import java.util.InputMismatchException;



public class Book {
	private String title;
	private String author;
	private Integer publicationYear;
	
	public Book ()
	{
		
	}
	
	public Book (String title, String author, int publicationYear) 
	{
		try
		{	
			this.title = title;
			this.author = author;
			this.publicationYear = publicationYear;
		} catch (InputMismatchException e)
		{
			System.out.println("Insira o ano corretamente");
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(Integer publicationYear) {
		this.publicationYear = publicationYear;
	}
	
	
}
