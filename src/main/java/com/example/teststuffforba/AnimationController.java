package com.example.teststuffforba;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * <a href="https://www.youtube.com/watch?v=UdGiuDDi7Rg&ab_channel=BroCode">Source</a>
 */
public class AnimationController implements Initializable {

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        // translate
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(welcomeText);
        translate.setDuration(Duration.millis(1000));
        translate.setCycleCount(3);
        translate.setByX(100);
        translate.setAutoReverse(true);
        translate.play();

    }


}