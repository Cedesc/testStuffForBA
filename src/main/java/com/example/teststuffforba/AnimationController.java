package com.example.teststuffforba;

import javafx.animation.*;
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
        letsRotate();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        simpleAnimation();
    }

    public void simpleAnimation() {
        // translate
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(welcomeText);
        translate.setDuration(Duration.millis(500));
        translate.setCycleCount(4);
        translate.setByX(100);
        translate.setAutoReverse(true);
        translate.play();
    }

    public void goCrazy() {

        letsTranslate();

        letsRotate();

        letsFade();

        letsScale();
    }

    public void letsTranslate() {
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(welcomeText);
        translate.setDuration(Duration.millis(500));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setByX(100);
        translate.setByY(100);
        translate.setAutoReverse(true);
        translate.play();
    }

    public void letsRotate() {
        RotateTransition rotate = new RotateTransition();
        rotate.setNode(welcomeText);
        rotate.setDuration(Duration.millis(1000));
        rotate.setCycleCount(TranslateTransition.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);

        rotate.setByAngle(360);
        rotate.play();
    }

    public void letsFade() {
        FadeTransition fade = new FadeTransition();
        fade.setNode(welcomeText);
        fade.setDuration(Duration.millis(1000));
        fade.setCycleCount(TranslateTransition.INDEFINITE);
        fade.setInterpolator(Interpolator.LINEAR);
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.play();
    }

    public void letsScale() {
        ScaleTransition scale = new ScaleTransition();
        scale.setNode(welcomeText);
        scale.setDuration(Duration.millis(15000));
        scale.setCycleCount(TranslateTransition.INDEFINITE);
        scale.setInterpolator(Interpolator.LINEAR);
        scale.setByX(15.0);
        scale.setByY(15.0);
        scale.setAutoReverse(true);
        scale.play();
    }

}