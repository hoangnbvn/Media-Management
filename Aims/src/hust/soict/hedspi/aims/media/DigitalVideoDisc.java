package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable, Comparable{
	private String director;
	public int length;
	public DigitalVideoDisc(String title) {
		super(title);
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost, int id) {
		super(title,category,cost,id);
		this.setLength(length);
		this.setDirector(director);
	
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public boolean SearchOneToken(String title) 
	{
		String str = title.toLowerCase();
		String[] arr = super.getTitle().toLowerCase().split(" ");
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].equals(str)) return true;
		}
		return false;
	}
	public boolean search(String title)
	{
		String[] arr = title.toLowerCase().split(" ");
		int i=0;
		boolean result = true;
		while(i<arr.length)
		{
			result = SearchOneToken(arr[i]);
			if(result == false) break;
			i++;
		}
		return result;
	}
//	public void play() {
//		System.out.println("Playing DVD: " + this.getTitle());
//		System.out.println("DVD length: " + this.getLength());
//	}
	public int compareTo(Object obj){
		DigitalVideoDisc o = (DigitalVideoDisc) obj;
		if(this.getCost() < o.getCost()) return -1;
		else if(this.getCost() == o.getCost()) return 0;
		else return 1;
	}
	@Override
	public void play() throws PlayerException {
		if (this.getLength() > 0) {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
		} else {
			throw new PlayerException("ERROR: DVD length is non-positive");
		}
	}
}
