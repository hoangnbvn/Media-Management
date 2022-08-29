package hust.soict.hedspi.aims.order;

import java.util.ArrayList;

import javax.naming.LimitExceededException;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.utils.MyDate;

public class Order {
	public static final int MAX_NUMBER_ORDERED = 10;
	public static final int MAX_LIMITED_ORDERS = 5;
	private MyDate dateOrdered;
	private static int nbOrders = 0;
	private ArrayList<Media> itemOrdered = new ArrayList<Media>();
	private int id;
	private MyDate myDate;
	
	public static int getNbOrders() {
		return nbOrders;
	}

	public static void setNbOrders(int nbOrders) {
		Order.nbOrders = nbOrders;
	}
	public Order() {
		if(nbOrders > MAX_LIMITED_ORDERS - 1) {
			System.out.println( "You can't create more order"); 
		}
		else {
			nbOrders += 1;
		}
	}
	
	public static Order createOrder() {
		if (nbOrders < MAX_LIMITED_ORDERS) {
			nbOrders++;
			Order objOrder = new Order();
			objOrder.myDate = new MyDate();
			return objOrder;
		}
		return null;
	}
	
	static private class NbOdered{
		public static final int MAX_LIMITTED_ORDERS = 5;
		private static int nbOrders = 0;
		public static int getNbOrders() {
			return nbOrders;
		}
		public static void setNbOrders(int nbOrders) {
			NbOdered.nbOrders = nbOrders;
		}	
	}
	public boolean isInitemsOrdered(Media media){
		for(Media media2: itemOrdered) {
			if(media2.equals(media))
				return true;
		}
		return false;
	}
	public boolean isEmpty() {
		if(this.itemOrdered.size()>0) {
			return false;
		}
		return true;
	}
	public boolean isFull(){
		if(itemOrdered.size() == MAX_LIMITED_ORDERS)
			return true;
		return false;
	}
	
	public boolean isId(int id) {
		for(Media media: itemOrdered) {
			if(media.getId()==id)
				return true;
		}
		return false;
	}
	
	public MyDate getDateOrdered() {
		return dateOrdered;
	}
	public void setDateOrdered(MyDate dateOrdered) {
		this.dateOrdered = dateOrdered;
	}
	
	///id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public ArrayList<Media> getItemOrdered() {
		return itemOrdered;
	}

	public void setItemOrdered(ArrayList<Media> itemOrdered) {
		this.itemOrdered = itemOrdered;
	}

	
	/// Remove Media
	public void removeMedia(DigitalVideoDisc dvd) {
		if(itemOrdered.contains(dvd))
			itemOrdered.remove(dvd);
		else
			System.out.println("Can't find media.");
	}
	
	public void removeMedia(Book book) {
		if(itemOrdered.contains(book))
			itemOrdered.remove(book);
		else
			System.out.println("Can't find media.");
	}
	public void removeMedia(int id) {
		int check = 0;
		for(int i = 0 ; i < itemOrdered.size();i++) {
			if(itemOrdered.get(i).getId() == id) {
				itemOrdered.remove(i);
				check = 1;
			}
		}
		if(check == 0) 
			System.out.println("Can't find media.");
		else
			System.out.println("Remove Success!!");
		
	}
	/// Add Media
	public void addMedia(Media book) {
		if(this.itemOrdered.size() < MAX_NUMBER_ORDERED && !itemOrdered.contains(book)) {
			this.itemOrdered.add(book);
		}
		else {
			System.out.println("Error out of memory.");
		}
	}
	/// Total
	public float totalCost() {
		float total = 0 ;
		for(int i = 0 ; i < this.itemOrdered.size() ; i++) {
			total += this.itemOrdered.get(i).getCost();
		}
		return total;
	}
	
	public Media getALuckyItem() {
		int randomNum = 0 + (int)(Math.random() * (itemOrdered.size()));
        Media item = itemOrdered.get(randomNum);
    //   item.setCost(0);
        return item;
    }
	
//	public Order() throws LimitExceededException{
//	if (Order.nbOrders < MAX_LIMITED_ORDERS) {
//		// TODO Set initial values for object attributes
//		nbOrders = nbOrders;
//	}
//	else {
//		throw new LimitExceededException("ERROR: The number of orders has reached its limit!");
//	}
//	}
}
