package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {

    	//adding the root of the main menu and the scene
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
    	Parent root = loader.load();
        Scene scene = new Scene(root);
        
        scene_controller controller = loader.getController();
        controller.setScene(scene);
        
        stage.setScene(scene);
        stage.show();
        
        
        
        //css
        //String css = this.getClass().getResource("application.css").toExternalForm();
        //scene.getStylesheets().add(css);
        
        
        
        
    }
    
    
    
    
    
    
    
    
    

    public static void main(String[] args) {
        launch(args);
    }
}
