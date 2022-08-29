package hust.soict.hedspi.aims.media;

public class Disc extends Media{

	private int length;
	protected String director;
	public Disc() {
		super();
	}
	public Disc(String title) {
		super(title);
	}
	
	public Disc(String title,String category, float cost,int id) {
		super(title,category,cost,id);
	}
	public Disc(int length, String director,String title, String category, float cost,int id) {
		super(title,category,cost,id);
		this.length = length;
		this.director = director;
	}
	
	public int getLength() {
		return length;
	}
	public String getDirector() {
		return director;
	}
	
}
