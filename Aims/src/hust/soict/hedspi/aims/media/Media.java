package hust.soict.hedspi.aims.media;

public abstract class Media {

	private String title;
	private String category;
	private float cost;
	private int id;
	
	public Media() {
		
	}
	
	public Media (String titte) {
		this.title = titte;
	}
	
	public Media (String title, String category) {
		this(title);
		this.category = category;
	}
	
	public Media(String title, String category, float cost) {
		this(title,category);
		this.cost = cost;
	}
	
	public Media(String title, String category, float cost,int id) {
		this(title,category,cost);
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public float getCost() {
		return cost;
	}
	public void printList() {
		System.out.print( " Title : "+title +" - "+ "Category : "+category +" - "+"Cost : "+ cost);
	}
	
//	public boolean equals(Object o) {
//		Media obj = (Media) o;
//		if( obj == null) return false;
//		if(this.getId()==obj.getId()) return true;
//		return false;
//	}
	
//	public int compareTo(Object obj) {
//		Media o = (Media)obj;
//		return this.title.compareTo(o.getTitle());
//	}
	
	public boolean equals(Object obj) {
        Media ob = (Media) obj;
        if (ob == null) {
            throw new NullPointerException("Obj Null");
        } else {
            if (obj instanceof Media) {
                if (ob.getId()==(this.getId()))
                    return true;
                return false;
            } else {
                throw new ClassCastException("Obj not media");
            }
        }
    }
	   public int compareTo(Object obj) {
	        if (obj == null) {
	            throw new NullPointerException("Obj null");
	        } else {
	            if (obj instanceof Media) {
	                Media media = (Media) obj;
	                return media.getTitle().compareTo(this.getTitle());
	            } else {
	                throw new ClassCastException("Obj not media");
	            }
	        }
	    }

	
}
