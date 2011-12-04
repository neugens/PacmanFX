package com.ladybug.sample.pacman.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PlayField extends ImageView {

    private static final String BG_IMAGE = "/resources/labyrinth.png";
    
    public PlayField() {
        setImage(new Image(getClass().getResourceAsStream(BG_IMAGE)));
    }
    
    public double getWidth() {
        return getImage().getWidth();
    }
    
    public double getHeight() {       
        return getImage().getHeight();
    }
}
