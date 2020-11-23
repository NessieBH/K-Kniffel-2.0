/**
 * @author Vanessa Lutz
 *
 */

package kniffel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class StartKniffel extends Application {

	@Override
    public void start(Stage primaryStage) {
        try {
            // Read file fxml and draw interface.
            Parent root = FXMLLoader.load(getClass()
                    .getResource("Kniffel.fxml"));
            
            primaryStage.setTitle("K-Kniffel");
            primaryStage.getIcons().add(new Image("file:Icon.jpg"));
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
   
}