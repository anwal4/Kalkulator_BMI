package sample;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;

public class Controller {

    @FXML
    TextField waga;
    public void restrictNumbersOnly(KeyEvent keyEvent){
        waga.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) waga.setText(newValue.replaceAll("[^\\d]", ""));
        });
    }

    @FXML
    TextField wzrost;

    @FXML
    Label output;

    public void handleButtonAction(javafx.event.ActionEvent event) {
        try {
            Double waga1 = Double.parseDouble(waga.getText());
            Double wzrost1 = Double.parseDouble(wzrost.getText());
            Double BMI = (waga1) / ((wzrost1/100) * (wzrost1/100));
            setResult(BMI);
            System.out.println(BMI);
        }catch (Exception e) {
            //TODO: exception
            //podświetlenie wyniku
            //aktualizowanie wyniku bezpośrednio po wprowadzeniu zmian
            //być może wyświetlanie wyniku po przeliczeniu
        }
        }
        void setResult(Double BMI){
        output.setText(BMI.toString());
        output.setUnderline(true);     //Powoduje podkreślenie wyniku

    }
}