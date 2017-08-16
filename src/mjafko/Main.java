package mjafko;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/*
* Author : Marko Divjak
* */

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/main_form.fxml"));
        Parent root = loader.load();

        Controller controller = loader.getController();
        controller.setDataDropDown();

        primaryStage.setTitle("Preveri svoje ocene pridoblene na izpitih");
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.getIcons().add(new Image("mjafko/icon.png"));
    }


    public static void main(String[] args) {
        launch(args);
    }
}
