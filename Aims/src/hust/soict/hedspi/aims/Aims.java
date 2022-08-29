package hust.soict.hedspi.aims;

import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.order.Order;
import hust.soict.hedspi.aims.utils.MyDate;


public class Aims {

	public static void showMenu() {
		System.out.println("Order Management Application: ");
		System.out.println("--------------------------------");
		System.out.println("1. Create new order");
		System.out.println("2. Add item to the order");
		System.out.println("3. Delete item by id");
		System.out.println("4. Display the items list of order");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		System.out.println("--------------------------------");
	}
	

	public static void main(String[] args) throws PlayerException {
		ArrayList <String> authors = new ArrayList<String>();
		ArrayList <Media> listMedia = new ArrayList<Media>();
		
		authors.add("Brown Dan");
		authors.add("JK Rowling");
		Book book1 = new Book("Da Vinci Code","Adventure",19.65f,authors,1001);
		listMedia.add(book1);
		Book book2 = new Book("Harry Potter","Children's Fiction",20.5f,authors,1002);
		listMedia.add(book2);
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation","Roger Allers",87,19.95f,101);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction","Geogre Lucas",124,24.95f,102);	
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin","Animation","John Musker",90,18.99f,103);
		
//		anOrder.removeDigitalVideoDisc(dvd3);
/*
		System.out.println("Total cost is: ");
		System.out.println(anOrder.totalCost());
*/
//		showMenu();

		int option = 0 ,id = 0, index = -1;
		Scanner scanner = new Scanner(System.in);
		ArrayList<Order> listOrder = new ArrayList<Order>();
		listOrder.clear();
		showMenu();
		option = scanner.nextInt();
		while(true) {
			switch (option) {
			case 0: {
				System.exit(0);
				break;
			}
			case 1: 
				Order newOrder = new Order();
				String input;
					System.out.println("Input id order");
					id = scanner.nextInt();
					newOrder.setId(id);
					listOrder.add(newOrder);
					index += 1;
					MyDate day = new MyDate();
					System.out.println("Date Order (Ex: June 21st 2001): ");
					scanner.nextLine();
					day.accept();
					listOrder.get(index).setDateOrdered(day);
				break;
			case 2:
				int type;
				System.out.println("Type of media:" + "\n(1.Book ; 2.CompactDisc ; 3.DigitalVideoDisc)\n");
				//type = scanner.nextInt();
				do {
					type = scanner.nextInt();
					if(type < 1 || type > 3)  System.out.println("Input type again !!");
				}while(type < 1 || type > 3);
				String  inputTitle, inputCategory,inputAuthor,inputDirector,inputArtist,inputTrackTitle;
				float inputCost =0;
				int inputID = 0,inputInt = 0 ,number = 0,inputTrackLength =0,inputLength =0;
				ArrayList<String> inputStr = new ArrayList<String>();
				ArrayList<Track> inputTracks = new ArrayList<Track>();
				System.out.println("Input id: ");
				inputID = scanner.nextInt();
				System.out.println("Input title: ");
				scanner.nextLine();
				inputTitle = scanner.nextLine();
				System.out.println("Input category: ");
				inputCategory = scanner.nextLine();
				System.out.println("Input cost: ");
				inputCost = scanner.nextFloat();
				scanner.nextLine();
				int play = 0;
				if(type == 1) {
					System.out.println("Input list of Author");
					System.out.println("\tInput number of Author");
					number = scanner.nextInt();
					scanner.nextLine();
					for(int i = 0 ; i < number ; i++) {
						System.out.println("\tInput Author");
						inputAuthor = scanner.nextLine();
						inputStr.add(inputAuthor);
					}
					Book newBook = new Book(inputTitle, inputCategory, inputCost, inputStr, id);
					listOrder.get(index).addMedia(newBook);
				}
				else if(type == 2) {
				
					System.out.println("Input length");
					inputLength = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Input director");
					inputDirector = scanner.nextLine();
					DigitalVideoDisc newDVD = new DigitalVideoDisc(inputTitle, inputCategory, inputDirector, inputLength, inputCost, id);
					listOrder.get(index).addMedia(newDVD);
					System.out.println("Do you want to play DVD? (1. Yes 0 .No)");
					play = scanner.nextInt();
					while(play !=0 && play != 1) {
						System.out.println("Choose again.");
						play = scanner.nextInt();
					}
					if(play == 1) {
						newDVD.play();
					}
					
				}
				else if (type ==3) {
					System.out.println("Input artist");
					inputArtist = scanner.nextLine();
					System.out.println("\tInput number of Track");
					number = scanner.nextInt();
					scanner.nextLine();
					for(int i = 0 ; i < number ; i++) {
						System.out.println("Input Track " + (i+1));
						System.out.println("\t\tInput title");
						inputTrackTitle = scanner.nextLine();
						System.out.println("\t\tInput length");
						inputTrackLength = scanner.nextInt();
						scanner.nextLine();
						Track inputTrack = new Track(inputTrackTitle,inputTrackLength);
						inputTracks.add(inputTrack);
					}
					CompactDisc  newCD = new CompactDisc(inputArtist, inputTracks, inputTitle, inputCategory, inputCost, id);
					listOrder.get(index).addMedia(newCD);
					System.out.println("DO you want to play CD? (1. Yes 0 .No)");
					play = scanner.nextInt();
					while(play !=0 && play != 1) {
						System.out.println("Choose again.");
						play = scanner.nextInt();
					}
					if(play == 1) {
						newCD.play();
					}
				}
				break;
	
			case 3:
				int deleteIDOrder = 0 , deleteIDMedia = 0,IDOrder = -1;
				System.out.println("Input id order you want to delete");
				deleteIDOrder = scanner.nextInt();
				System.out.println("input id media you want to delete");
				deleteIDMedia = scanner.nextInt();
				for(int i = 0; i < listOrder.size() ; i++) {
					if(listOrder.get(i).getId() == id) {
						IDOrder = id;
					}
				}
				if(IDOrder == -1){
					System.out.println("Can't find order ! Remove error!!");
				}
				else {
					listOrder.get(IDOrder).removeMedia(deleteIDMedia);
				}
				break;
			case 4:
				for(int  i = 0 ; i < listOrder.size(); i++) {
					Order tmp = listOrder.get(i);
					System.out.print("Order code: "+tmp.getId() + ". Date: ");
					tmp.getDateOrdered().print();
					for(int j = 0 ; j < tmp.getItemOrdered().size() ; j++) {		
						tmp.getItemOrdered().get(j).printList();
					}
				}
				break;
			default:
				System.out.println("Incorrect option! Input again (0 to 4).");
				break;
			}
			showMenu();
			option = scanner.nextInt();
			
		}
	}
}

