package com.ladybug.sample.pacman.view;

import javafx.scene.Group;

public class PacmanGroup extends Group {

    private Pacman pacman;
    public PacmanGroup(Pacman pacman) {
        this.pacman = pacman;
        this.getChildren().add(pacman);
    }

    public void up() {
        pacman.up();
    }
    
    public void down() {
        pacman.down();
    }
    
    public void left() {
        pacman.left();
    }
    
    public void right() {
        pacman.right();
    }

    public void move() {
        switch (pacman.getDirection()) {
        case LEFT:
            pacman.setLayoutX(pacman.getLayoutX() - 1);
            break;
        case RIGHT:
            pacman.setLayoutX(pacman.getLayoutX() + 1);
            break;
        case UP:
            pacman.setLayoutY(pacman.getLayoutY() - 1);
            break;
        case DOWN:
            pacman.setLayoutY(pacman.getLayoutY() + 1);
            break;

        default:
            break;
        }
    }
}
