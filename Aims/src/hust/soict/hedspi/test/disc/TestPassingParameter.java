package hust.soict.hedspi.test.disc;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class TestPassingParameter {

		public static void main(String[] args) {
			DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
			DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
			
		//	swap(jungleDVD, cinderellaDVD);
			System.out.println("jungle dvd: " + jungleDVD.getTitle());
			changeTitle(jungleDVD, cinderellaDVD.getTitle());
			System.out.println("jungle dvd: " + jungleDVD.getTitle());
		}
		
		public static void swap (DigitalVideoDisc o1, DigitalVideoDisc o2) {
			DigitalVideoDisc tmp = new DigitalVideoDisc(o1.getTitle(), o1.getCategory(), o1.getDirector(), o1.getLength(), o1.getCost(), o1.getId());
			
			o1 = tmp;
			o1 = o2;
			o2 = tmp;
	/*		o1.setTitle(o2.getTitle());
			o1.setCategory(o2.getCategory());
			o1.setDirector(o2.getDirector());
			o1.setLength(o2.getLength());
			o1.setCost(o2.getCost());
			
			o2.setTitle(tmp.getTitle());
			o2.setCategory(tmp.getCategory());
			o2.setDirector(tmp.getDirector());
			o2.setLength(tmp.getLength());
			o2.setCost(tmp.getCost());
	*/	}
		
		public static void changeTitle(DigitalVideoDisc dvd, String title)
		{
			String oldTitle = dvd.getTitle();
		//	dvd.setTitle(title);
			dvd = new DigitalVideoDisc(oldTitle);
		}

}
