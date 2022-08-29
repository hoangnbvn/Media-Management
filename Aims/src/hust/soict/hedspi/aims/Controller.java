package hust.soict.hedspi.aims;

import java.io.IOException;
import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.order.Order;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controller {
	@FXML
	Label lb_message;
	@FXML
	TextField tf_id;
	TextField tf_id1;
	TextField tf_id2;
	
	ArrayList<Order> listOrder = new ArrayList<Order>();
	private static Order anOrder;
	public void Create(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(this.getClass().getResource("input.fxml"));
			Stage stage = new Stage();
            stage.setTitle("Add Order");
            stage.setScene(new Scene(root));
            stage.show();
            
            anOrder.setId(Integer.parseInt(tf_id1.getText()));
			listOrder.add(anOrder);
            // Hide this current window (if this is what you want)
            //((Node)(event.getSource())).getScene().getWindow().hide();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void SubmitCreate(ActionEvent event)
	{
		((Node)(event.getSource())).getScene().getWindow().hide();
		try {
	
			Parent root = FXMLLoader.load(this.getClass().getResource("gui.fxml"));
			Stage stage = new Stage();
            stage.setTitle("Add Order");
            stage.setScene(new Scene(root));
            stage.show();
            // Hide this current window (if this is what you want)
            
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Exit(ActionEvent event) {
        System.exit(0);
	}

	public void deleteItem(ActionEvent event) {
				try {
					Parent root = FXMLLoader.load(this.getClass().getResource("delete.fxml"));
					Stage stage = new Stage();
		            stage.setTitle("Input ID");
		            stage.setScene(new Scene(root));
		            stage.show();
		            // Hide this current window (if this is what you want)
		            //((Node)(event.getSource())).getScene().getWindow().hide();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	           
}
	 
	 public void submitDelete(ActionEvent event){
		 if(tf_id.getText() == null) {
			 
		 }else {
				anOrder.removeMedia(Integer.parseInt(tf_id.getText()));
				 Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Delete by id");
					alert.setHeaderText(null);
					alert.setContentText("Deleted!!!");
					alert.showAndWait();
				((Node)(event.getSource())).getScene().getWindow().hide();
	        	Parent root;
	    		try {
	    			root = FXMLLoader.load(this.getClass().getResource("gui.fxml"));
	    			Scene scene = new Scene(root);
	    	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	    			window.setScene(scene);
	    			window.show();
	    		} catch (IOException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
		 }
	 }
	
	 
}
