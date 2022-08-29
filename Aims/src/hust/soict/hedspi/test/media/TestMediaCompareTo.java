package hust.soict.hedspi.test.media;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import hust.soict.hedspi.aims.PlayerException;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

public class TestMediaCompareTo {

	public static void main (String[] args) throws PlayerException
	{
		ArrayList <String> authors = new ArrayList<String>();
		ArrayList <Media> listMedia = new ArrayList<Media>();
		
		authors.add("Brown Dan");
		authors.add("JK Rowling");
		Book book1 = new Book("Da Vinci Code","Adventure",19.65f,authors,1001);
		listMedia.add(book1);
		Book book2 = new Book("Harry Potter","Children's Fiction",20.5f,authors,1002);
		listMedia.add(book2);
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation","Roger Allers", 87, 19.95f, 101);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction","Geogre Lucas", 124, 24.95f, 102);	
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin","Animation","John Musker",90, 18.99f, 103);
		
		Collection collection = new ArrayList();
		collection.add(dvd1);
		collection.add(dvd2);
		collection.add(dvd3);
	//	collection.add(book1);
	//	collection.add(book2);
		
		Iterator iterator = collection.iterator();
		System.out.println("-------------------------------");
		while(iterator.hasNext()){
			((DigitalVideoDisc)iterator.next()).play();
		}
		
	    iterator = collection.iterator();
		System.out.println("-------------------------------");
		System.out.println("The DVDs currently in the order  are:");
		while(iterator.hasNext()){
			System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
		}
		// Sort the collection of DVDs
		Collections.sort((ArrayList)collection);
		iterator = collection.iterator();
		
		System.out.println("-------------------------------");
		System.out.println("The DVDs after sort in the order  are:");
		while(iterator.hasNext()){
			System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
		}
		System.out.println("-------------------------------");
	
	}
}
