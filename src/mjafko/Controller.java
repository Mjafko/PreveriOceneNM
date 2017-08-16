package mjafko;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{


    public  ChoiceBox dropDown;
    public  TextField textField;
    public  Button btnPrikazi;
    public ProgressIndicator progressIndicator;
    public Label lblAbout;
    private String izpis = "";

    // On Button click
    public void onPrikazi(ActionEvent event) throws Exception {

        progressIndicator.setProgress(-1.0);

        FindingGrades findingGrades = new FindingGrades();

        String selected_program = String.valueOf(dropDown.getValue());
        String vpisna_stevilka  = textField.getText();
        izpis = findingGrades.checkSite(vpisna_stevilka,selected_program);

        if(izpis != null && izpis != "") {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mjafko/fxml/printText.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();

            progressIndicator.setProgress(1.0);
            PrintText printText = fxmlLoader.getController();
            printText.setTextArea(izpis);

            Stage stage = new Stage();
            stage.setTitle("Ocene za vpisno številko - " + vpisna_stevilka);
            stage.setScene(new Scene(root1));
            stage.show();
            stage.getIcons().add(new Image("mjafko/icon.png"));
        } else {
            JOptionPane.showMessageDialog(null, "Ni najdenih vpisov za vašo vpisno številko! Preverite vpisno št. ter izbrani program!");
            progressIndicator.setProgress(0);
        }
    }   //  End of Button click

    public void setDataDropDown () {
        dropDown.getItems().clear();
        dropDown.getItems().addAll(
                "Elektronika - Redni",
                "Elektronika - Izredni",
                "Informatika - Redni",
                "Informatika - Izredni",
                "Kozmetika - Redni",
                "Kozmetika - Izola",
                "Lesarstvo - Redni",
                "Lesarstvo - Izredni",
                "Logistika - Novo mesto",
                "Logistika - Ljubljana",
                "Strojništvo - Redni",
                "Strojništvo - Izredni",
                "Strojništvo - Zagorje",
                "Strojništvo - Murska Sobota",
                "Varstvo okolja in komunala - Redni",
                "Varstvo okolja in komunala - Izredni"
        );
        dropDown.getSelectionModel().selectFirst();
    }

    public void about_me(MouseEvent mouseEvent) throws IOException {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("/mjafko/fxml/about.fxml"));
        Parent root = (Parent) Loader.load();
        Stage stage = new Stage();
        stage.setTitle("About");
        stage.setScene(new Scene(root, 600, 400));
        stage.setResizable(false);
        stage.show();
        stage.getIcons().add(new Image("mjafko/icon.png"));
    }

    public void ClickMe(MouseEvent mouseEvent) {
        lblAbout.setFont(Font.font("Hack", FontWeight.BOLD, 10));
        lblAbout.setTextFill(Color.BLUE);
    }

    public void ClickMeExit(MouseEvent mouseEvent) {
        lblAbout.setFont(Font.font("Hack", FontWeight.NORMAL, 9));
        lblAbout.setTextFill(Paint.valueOf("#656565"));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
