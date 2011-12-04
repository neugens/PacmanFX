package com.ladybug.sample.pacman.view;

import javafx.scene.paint.Color;

public class Pellet extends AbstractPellet {

    public Pellet() {
        super(2, Color.WHITE);
        createAnimation(1, 3, 4000);
    }
}
