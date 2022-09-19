package com.example.teststuffforba;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyZoomAndScrollApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        Group group = new Group();

        // create canvas
        MyPannableCanvas canvas = new MyPannableCanvas();

        // we don't want the canvas on the top/left in this example => just
        // translate it a bit
        canvas.setTranslateX(100);
        canvas.setTranslateY(100);



        group.getChildren().add(canvas);

        // create scene which can be dragged and zoomed
        Scene scene = new Scene(group, 1024, 768);

        MySceneGestures sceneGestures = new MySceneGestures(canvas);
        scene.addEventFilter(ScrollEvent.ANY, sceneGestures.getOnScrollEventHandler());

        stage.setScene(scene);
        stage.show();


        // create Label
        Label label0 = new Label("---------");

        // add it to canvas
        canvas.getChildren().add(label0);


        // create Label, Button and VBox
        Label label1 = new Label("Holla");
        Button button1 = new Button("Click");
        button1.setOnAction(event -> {
            System.out.println("HeyHey");
        });
        VBox vbox = new VBox();
        vbox.getChildren().addAll(label1, button1);

        // add all of them to canvas
        canvas.getChildren().add(vbox);

    }
}
