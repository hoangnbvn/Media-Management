package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.hedspi.aims.PlayerException;

public class CompactDisc extends Disc implements Playable, Comparable {

	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	public CompactDisc() {
		// TODO Auto-generated constructor stub
	}
	public CompactDisc(String title, String category, float cost,String director,String artist, int id) {
		super(title, category, cost, id);
		this.artist = artist;
		this.director = director;
	}
	public CompactDisc(String artist, ArrayList<Track> tracks,String title, String category, float cost,int id) {
		super(title,category,cost,id);
		this.artist = artist;
		this.tracks = tracks;
	}

	public String getArtist() {
		return artist;
	}
	
	public int numberTracks() {
		return this.tracks.size();
	}
	
	public ArrayList<Track> getTracks(){
		return this.tracks;
	}
	public void addTrack(Track track) {
		if(tracks.contains(track)) 
			System.out.println("Input track has already existed!");
		else {
			tracks.add(track);
			System.out.println("Done!");
		}
	}
	public void removeTrack(Track track) {
		if(!tracks.contains(track))
			System.out.println("Input track hasn't existed!");
		else {
			tracks.remove(track);
			System.out.println("Done!");
		}
	}
	
	public int getLength() {
		int sLength = 0;
		for(Track tmp : tracks) {
			sLength += tmp.getLength();
		}
		return sLength;
	}
	
//	public void play() throws PlayerException {
//		Scanner scanner= new Scanner(System.in);
//		System.out.println("Compact disc title is "+getTitle());
//		System.out.println("Artist: "+this.artist);
//		for(int i = 0 ; i < this.tracks.size();i++) {
//			this.tracks.get(i).play();
//			System.out.println("Press enter to continue");
//			try{System.in.read();	scanner.nextLine();}
//			        catch(Exception e){}
//		}
//	}
	@Override
	public void play() throws PlayerException {
		if (this.getLength() > 0) {
			java.util.Iterator iter = tracks.iterator();
			Track nextTrack;
			while(iter.hasNext()) {
				nextTrack = (Track) iter.next();
				try {
					nextTrack.play();
				} catch (Exception e) {
					// TODO: handle exception
					throw e;
				}
			}
		} else {
			throw new PlayerException("ERROR: CD length is non-positive");
		}
	}
	public void printList() {
		System.out.print("\t"+super.getId()+ ". CD. ");
		super.printList();
		System.out.println(" - Artist : "+ getArtist() + " - " + "Track : ");
		for(Track tmp : tracks) {
			System.out.println("\t\t"+ "Title : "+ tmp.getTitle() + "Length: "+tmp.getTitle());
		}	
	} 
	public int compareTo(Object obj) {
		CompactDisc o = (CompactDisc) obj;
		if(this.tracks.size() == o.tracks.size())
		{
			if(this.getLength() < o.getLength()) return -1;
			if(this.getLength() == o.getLength()) return 0;
			else return 1;
		}
		else if (this.tracks.size() < o.tracks.size())  return -1;
		else return 1;
	}
}
