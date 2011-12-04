package com.ladybug.sample.pacman;

import com.ladybug.sample.pacman.controller.GameController;
import com.ladybug.sample.pacman.view.GameGroup;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        GameGroup gameGroup = new GameGroup();
        
        Group root = new Group();
        Scene scene = new Scene(root, gameGroup.getSize().getWidth(),
                                gameGroup.getSize().getHeight(), Color.BLACK);
        root.getChildren().add(gameGroup);

        GameController controller = new GameController(scene, gameGroup);
        controller.initGame();
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}
