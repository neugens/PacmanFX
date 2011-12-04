package com.ladybug.sample.pacman.view;

import com.ladybug.sample.pacman.controller.Direction;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.util.Duration;

public class Pacman extends Arc {

    private Direction currectDirection = Direction.RIGHT;
    
    public Pacman() {
        super(0, 0, 10, 10, 15, 300);
        setFill(Color.YELLOW);
        setType(ArcType.ROUND);
        createAnimation();
    }
    
    protected void createAnimation() {
        final Timeline timeline = new Timeline();
        timeline.setAutoReverse(true);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO, new KeyValue(startAngleProperty(), 0),
                                            new KeyValue(lengthProperty(), 360)),
                new KeyFrame(new Duration(250), new KeyValue(startAngleProperty(), 30),
                                            new KeyValue(lengthProperty(), 300)));
                
        timeline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                timeline.play();
            }
        });
        timeline.play();
    }
    
    public Direction getDirection() {
        return currectDirection;
    }
    
    void up() {
        getTransforms().clear();
        getTransforms().add(new Rotate(-90));
        currectDirection = Direction.UP;
    }
    
    void down() {
        getTransforms().clear();
        getTransforms().add(new Rotate(90));
        currectDirection = Direction.DOWN;
    }
    
    void left() {
        getTransforms().clear();
        getTransforms().add(new Scale(-1, -1));
        currectDirection = Direction.LEFT;
    }
    
    void right() {
        getTransforms().clear();
        currectDirection = Direction.RIGHT;
    }
}