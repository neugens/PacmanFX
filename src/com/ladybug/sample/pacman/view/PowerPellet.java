package com.ladybug.sample.pacman.view;

import javafx.scene.paint.Color;

public class PowerPellet extends AbstractPellet {

    public PowerPellet() {
        super(4, Color.WHITE);
        createAnimation(1, 8, 2000);
    }
}
