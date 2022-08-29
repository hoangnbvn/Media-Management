package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.PlayerException;

public class Track extends Media implements Playable, Comparable{

	private String title;
	private int length;
	
	public Track() {
		
	}
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	
//	public void play() {
//		System.out.println("Playing track: " + this.getTitle());
//		System.out.println("Track length: " + this.getLength());
//	}

	@Override
	public boolean equals(Object o) {
		Track obj = (Track) o;
		if(obj == null) return false;
		if(this.getTitle().equals(obj.getTitle()) && this.getLength() == obj.getLength()) return true;
		return false;
	}
	
	public void play() throws PlayerException{
		if (this.getLength() > 0) {
			System.out.println("Playing Track: " + this.getTitle());
			System.out.println("Track length: " + this.getLength());
		} else {
			throw new PlayerException("ERROR: Track length is non-positive");
		}
	}

}
