import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SimpleCalculator extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader ( getClass().getResource( "SimpleCalculator.fxml" ));
//            loader.setController(new SimpleCalculatorController());
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root, 351, 410));
            primaryStage.show();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
