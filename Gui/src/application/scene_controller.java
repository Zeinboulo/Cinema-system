package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class scene_controller {
	@FXML
	private Stage stage;
	private Scene scene;
	private Parent root;
	private String[] buttonIds;
	@FXML
	private AnchorPane anchor;
	 
	private Map<String, Seat> seatMap = new HashMap<>();

    // Initialize seatMap with seat IDs
    public void initializeSeat() {
        for (String id : buttonIds) {
            seatMap.put(id, new Seat());
        }
    }
	
	// Method to set the scene
    public void setScene(Scene scene) {
        this.scene = scene;
    }


	public void switch_to_Main(ActionEvent event) throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();		
	}
	public void switch_to_scene1(ActionEvent event) throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();		
	}  
	
	public void switch_to_scene2(ActionEvent event) throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();		
	}

	public void switch_to_scene3(ActionEvent event) throws IOException {
	
		Parent root = FXMLLoader.load(getClass().getResource("Scene3.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
		
	}
	
	@FXML
    void show_alert(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        String buttonId = clickedButton.getId();
        int seatNumber = Integer.parseInt(buttonId.substring(1)); // Extract seat number from button ID

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setContentText("Are you sure you want to reserve seat " + seatNumber + "?");
        Optional<ButtonType> result = alert.showAndWait();

        if(result.isPresent() && result.get() == ButtonType.OK) {
            clickedButton.setDisable(true);
            clickedButton.setStyle("-fx-background-color: red");
        } else {
            System.out.println("cancel!");
        }
    }
    
	
	 
	public void initialize() {
		 if (anchor != null) {
		        adding_idTo_array();
		    } else {
		        System.err.println("AnchorPane not initialized.");
		    }
	}
	
	
	void adding_idTo_array(){
		ObservableList<Node> children = anchor.getChildrenUnmodifiable(); // parent for all buttons.
	    List<String> idList = new ArrayList<>();

	    for (Node node : children) {
	        if (node instanceof Button) {
	            Button button = (Button) node;
	            idList.add(button.getId());
	        }
	    }

	    // Convert the list to an array
	    buttonIds = idList.toArray(new String[0]);

	    // Print the list
	    //System.out.println("Button IDs:");
	    //for (String id : buttonIds) {
	        //System.out.println(id);
	    //}
	}
	
	public void enableAllButtons1() {
		// Iterate through the button IDs array
	    for (String id : buttonIds) {
	        // Check if the button ID starts with "b"
	        if (id.startsWith("b")) {
	            // Lookup the button by ID
	            Button button = (Button) anchor.lookup("#" + id);
	            if (button != null) {
	                // Enable the button
	                button.setDisable(false);
	                button.setStyle("-fx-background-color: green");
	            }
	        }
	    }
	}
	public void enableAllButtons2() {
		// Iterate through the button IDs array
	    for (String id : buttonIds) {
	        // Check if the button ID starts with "s"
	        if (id.startsWith("s")) {
	            // Lookup the button by ID
	            Button button = (Button) anchor.lookup("#" + id);
	            if (button != null) {
	                // Enable the button
	                button.setDisable(false);
	                button.setStyle("-fx-background-color: green");
	            }
	        }
	    }
	}
	
	public void enableAllButtons3() {
		// Iterate through the button IDs array
	    for (String id : buttonIds) {
	        // Check if the button ID starts with "t"
	        if (id.startsWith("t")) {
	            // Lookup the button by ID
	            Button button = (Button) anchor.lookup("#" + id);
	            if (button != null) {
	                // Enable the button
	                button.setDisable(false);
	                button.setStyle("-fx-background-color: green");
	            }
	        }
	    }
	}

	
	public void countDisabledButtons() {
		int disabledCount = 0;

	    // Iterate through the button IDs array
	    for (String id : buttonIds) {
	        // Lookup the button by ID
	        Button button = (Button) anchor.lookup("#" + id);
	        if (button != null && button.isDisabled()) {
	            // If the button is disabled, increment the count
	            disabledCount++;
	        }
	    }

	    // Create an alert dialog
	    Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Disabled Seats");
	    alert.setHeaderText(null);
	    alert.setContentText("Total price is : " + disabledCount*50);
	    alert.showAndWait();
	    
	}
	
	public void countDisabledButtons2() {
		int disabledCount = 0;

	    // Iterate through the button IDs array
	    for (String id : buttonIds) {
	        // Lookup the button by ID
	        Button button = (Button) anchor.lookup("#" + id);
	        if (button != null && button.isDisabled()) {
	            // If the button is disabled, increment the count
	            disabledCount++;
	        }
	    }

	    // Create an alert dialog
	    Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Disabled Seats");
	    alert.setHeaderText(null);
	    alert.setContentText("Total price is : " + disabledCount*15);
	    alert.showAndWait();
	    
	}
	
	public void countDisabledButtons3() {
		int disabledCount = 0;

	    // Iterate through the button IDs array
	    for (String id : buttonIds) {
	        // Lookup the button by ID
	        Button button = (Button) anchor.lookup("#" + id);
	        if (button != null && button.isDisabled()) {
	            // If the button is disabled, increment the count
	            disabledCount++;
	        }
	    }

	    // Create an alert dialog
	    Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Disabled Seats");
	    alert.setHeaderText(null);
	    alert.setContentText("Total price is : " + disabledCount*10);
	    alert.showAndWait();
	    
	}
	
	@FXML
    void cancel_alert(ActionEvent event) {
		// Create a custom dialog for user input
	    TextInputDialog dialog = new TextInputDialog();
	    dialog.setTitle("Enable Seat");
	    dialog.setHeaderText(null);
	    dialog.setContentText("Enter the Seat ID:");

	    // Show the dialog and wait for user input
	    Optional<String> result = dialog.showAndWait();

	    // If the user entered a value and clicked OK
	    result.ifPresent(buttonId -> {
	        boolean buttonFound = false;
	        // Iterate through the button IDs array
	        for (String id : buttonIds) {
	            // Compare the user input to each button ID
	            if (buttonId.equals(id)) {
	                // If a match is found, enable the corresponding button
	                Button button = (Button) anchor.lookup("#" + id);
	                if (button != null) {
	                    button.setDisable(false);
	                    button.setStyle("-fx-background-color: green");
	                    buttonFound = true;
	                    
	                    // Show a confirmation alert
	                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
	                    alert.setTitle("Seat Enabled");
	                    alert.setHeaderText(null);
	                    alert.setContentText("Seat " + id + " has been enabled.");
	                    alert.showAndWait();
	                    break; // Exit the loop after enabling the button
	                }
	            }
	        }

	        // If no match is found, show an error alert
	        if (!buttonFound) {
	            Alert alert = new Alert(Alert.AlertType.ERROR);
	            alert.setTitle("Seat Not Found");
	            alert.setHeaderText(null);
	            alert.setContentText("Seat " + buttonId + " not found.");
	            alert.showAndWait();
	            
	        }
	    });
		
		
    }
	
	
	
	
	
	}

