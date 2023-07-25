package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class Controller{

    @FXML
    private TextField weightBmi;

    @FXML
    private TextField heightBmi;

    @FXML
    private Label resultBmi;

    @FXML
    private ImageView logoBmi;

    @FXML
    private Text titleBmi;

    @FXML
    private ImageView bodyBmi;

    @FXML
    private Label textBmi;

    @FXML
    private Text valuesBmi;

    @FXML
    private Line lineBmi;


    public void calculateBmi(javafx.event.ActionEvent actionEvent) {
        double w = Double.parseDouble(this.weightBmi.getText());
        double h = Double.parseDouble(this.heightBmi.getText())/100;
        double result = w/(h*h);
        String stringResult = String.format("%.2f", result); //2f = 2 desetiný místa
        resultBmi.setText(String.valueOf(stringResult));
        logoBmi.setVisible(false);
        titleBmi.setVisible(false);
        if(result<18.5){
            bodyBmi.setImage(new Image(getClass().getResourceAsStream("./image/UnderW.jpg")));
            textBmi.setText("PODVÁHA");
            valuesBmi.setText("" + 18.5);

        }else if (result>=18.5 && result<25){
            bodyBmi.setImage(new Image(getClass().getResourceAsStream("./image/NormalW.jpg")));
            textBmi.setText("NORMÁLNÍ");
            valuesBmi.setText("" + 18.5 + " "+25.0);
        }
        else if (result>=25.01 && result<30) {
            bodyBmi.setImage(new Image(getClass().getResourceAsStream("./image/OverW.jpg")));
            textBmi.setText("NADVÁHA");
            valuesBmi.setText("" + 25.0 + " " +30.0);
        }
        else if (result>=30.01 && result<35.0) {
            bodyBmi.setImage(new Image(getClass().getResourceAsStream("./image/OB1.jpg")));
            textBmi.setText("MORBIDNOST 1.stupeň");
            valuesBmi.setText("" + 30.0 + " " + 35.0);
        }
        else if (result>=35.01 && result<40.0) {
            bodyBmi.setImage(new Image(getClass().getResourceAsStream("./image/OB2.jpg")));
            textBmi.setText("MORBIDNOST 2.stupeň");
            valuesBmi.setText("" + 35.0 + " " + 40.0);
        }

        else if (result>=40.01 && result<60.0) {
            bodyBmi.setImage(new Image(getClass().getResourceAsStream("./image/OB3.jpg")));
            textBmi.setText("MORBIDNOST 3.stupeň");
            valuesBmi.setText(">"+ 40 +"");
        }

        bodyBmi.setVisible(true);
        textBmi.setVisible(true);
        valuesBmi.setVisible(true);
    }

}

/*
*25-30 Nadváha
* 30-35 Obezita
* >35 Obezita druhého stupně
* >40 Obezita třetího stupně
 */