package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.*;
import java.util.Map.Entry;

public class Book extends Media implements Comparable {

	private ArrayList <String> authors = new ArrayList<String>();
	
	public Book() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public Book(String title, String category,float cost,ArrayList<String> authors, int id) {
		super(title,category,cost,id);
		this.authors = authors;
	}

	private String contentString;
	private List<String> contentTokens = new ArrayList<String>();
	private Map<String, Integer> wordFrequency = new TreeMap<String, Integer>();
	
	
	public String getContentString() {
		return contentString;
	}

	public void setContentString(String contentString) {
		this.contentString = contentString;
		this.processContent();
	}
	public String toString() {
		int i = 1;
		String outString = "Id: "+this.getId()+"\n";
		outString += "Title: "+ this.getTitle()+ "\n";
		outString += "Category: "+this.getCategory()+"\n";
		outString += "Cost: "+this.getCost()+"\n";
		outString += "List Authous: \n";
		for(String author: this.authors) {
			outString += "Author"+ (i++) + ": "+ author+"\n";
		}
		outString += "Content Length: " + this.contentTokens.size()+ "\n";
		outString += "Word Frequency: \n";
		for(Entry<String, Integer> entry: wordFrequency.entrySet()) {
			String key = entry.getKey();
            Integer value = entry.getValue();
			outString += String.format("%-20s%d\n",key,value);
		}
		outString +="-----\n";
		return outString;
	}
	private void printContenTokens() {
		for(String content: this.contentTokens) {
			System.out.print(content+" ");
		}
		System.out.println();
	}
	private void printwordFrequency() {
		for(Entry<String, Integer> entry: wordFrequency.entrySet()) {
			String key = entry.getKey();
            Integer value = entry.getValue();
			System.out.printf("%-20s%d\n",key,value);
		}
	}
	
	public void processContent() {
		this.contentTokens.clear();
		this.wordFrequency.clear();
		String[] outputString = this.contentString.split("[ ?.,;\"'!]+"); //[ ?.,;"'!]
		for(String output: outputString) {
			int dem = 0;
			for(String content: contentTokens)
				if(content.equals(output)) {
					wordFrequency.put(output, wordFrequency.get(output)+1);
					dem = 1;
					break;
				}
			if(dem == 0) {
				contentTokens.add(output);
				wordFrequency.put(output,1);
			}
		}
		Collections.sort((ArrayList<String>)contentTokens);
	}
	
	public ArrayList<String> getAuthors() {
		return authors;
	}

	public void setAuthors(ArrayList<String> authors) {
		this.authors = authors;
	}
	
	public void addAuthor(String authorName) {
		
		if(authors.contains(authorName)) 
			System.out.println("Author has already existed.");
		else {
			authors.add(authorName);
		}
	}
	
	public void removeAuthor(String authorName) {
	
		if(!authors.contains(authorName)) 
			System.out.println("Can't find author.");
		else {
			authors.remove(authorName);
		}	
	}
	
	public void printList() {
		System.out.print("\t"+super.getId()+ ". Book.  ");
		super.printList();
		System.out.print(" - Authors: ");
		for(String tmp : authors) {
			System.out.print(tmp + ", ");
		}	
		System.out.println();
	}
	
	
}
