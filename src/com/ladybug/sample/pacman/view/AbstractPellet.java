package com.ladybug.sample.pacman.view;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

class AbstractPellet extends Circle {

    public AbstractPellet(int size, Color color) {
        super(size, color);
    }

    protected void createAnimation(double start, double stop, int time) {
        final Timeline timeline = new Timeline();
        timeline.setAutoReverse(true);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO, new KeyValue(radiusProperty(), start)),
                new KeyFrame(new Duration(time), new KeyValue(radiusProperty(), stop)));
                
        timeline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                timeline.play();
            }
        });
        timeline.play();
    }
}
