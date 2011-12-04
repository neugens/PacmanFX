package com.ladybug.sample.pacman.controller;

import com.ladybug.sample.pacman.view.GameGroup;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class GameController {
    
    public static final int ROWS = 31;
    public static final int COLUMNS = 28;
    
    private static final int[][] MAZE = {
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,2,2,2,2,2,2,2,2,2,2,2,2,0,0,2,2,2,2,2,2,2,2,2,2,2,2,0},
        {0,2,0,0,0,0,2,0,0,0,0,0,2,0,0,2,0,0,0,0,0,2,0,0,0,0,2,0},
        {0,3,0,0,0,0,2,0,0,0,0,0,2,0,0,2,0,0,0,0,0,2,0,0,0,0,3,0},
        {0,2,0,0,0,0,2,0,0,0,0,0,2,0,0,2,0,0,0,0,0,2,0,0,0,0,2,0},
        {0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
        {0,2,0,0,0,0,2,0,0,2,0,0,0,0,0,0,0,0,2,0,0,2,0,0,0,0,2,0},
        {0,2,0,0,0,0,2,0,0,2,0,0,0,0,0,0,0,0,2,0,0,2,0,0,0,0,2,0},
        {0,2,2,2,2,2,2,0,0,2,2,2,2,0,0,2,2,2,2,0,0,2,2,2,2,2,2,0},
        {0,0,0,0,0,0,2,0,0,0,0,0,1,0,0,1,0,0,0,0,0,2,0,0,0,0,0,0},
        {0,0,0,0,0,0,2,0,0,0,0,0,1,0,0,1,0,0,0,0,0,2,0,0,0,0,0,0},
        {0,0,0,0,0,0,2,0,0,1,1,1,1,1,1,1,1,1,1,0,0,2,0,0,0,0,0,0},
        {0,0,0,0,0,0,2,0,0,1,0,0,0,4,4,0,0,0,1,0,0,2,0,0,0,0,0,0},
        {0,0,0,0,0,0,2,0,0,1,0,4,4,4,4,4,4,0,1,0,0,2,0,0,0,0,0,0},
        {5,1,1,1,1,1,2,1,1,1,0,4,4,7,4,4,4,0,1,1,1,2,1,1,1,1,1,5},
        {0,0,0,0,0,0,2,0,0,1,0,4,4,4,4,4,4,0,1,0,0,2,0,0,0,0,0,0},
        {0,0,0,0,0,0,2,0,0,1,0,0,0,0,0,0,0,0,1,0,0,2,0,0,0,0,0,0},
        {0,0,0,0,0,0,2,0,0,1,1,1,1,1,1,1,1,1,1,0,0,2,0,0,0,0,0,0},
        {0,0,0,0,0,0,2,0,0,1,0,0,0,0,0,0,0,0,1,0,0,2,0,0,0,0,0,0},
        {0,0,0,0,0,0,2,0,0,1,0,0,0,0,0,0,0,0,1,0,0,2,0,0,0,0,0,0},
        {0,2,2,2,2,2,2,2,2,2,2,2,2,0,0,2,2,2,2,2,2,2,2,2,2,2,2,0},
        {0,2,0,0,0,0,2,0,0,0,0,0,2,0,0,2,0,0,0,0,0,2,0,0,0,0,2,0},
        {0,2,0,0,0,0,2,0,0,0,0,0,2,0,0,2,0,0,0,0,0,2,0,0,0,0,2,0},
        {0,3,2,2,0,0,2,2,2,2,2,2,2,6,1,2,2,2,2,2,2,2,0,0,2,2,3,0},
        {0,0,0,2,0,0,2,0,0,2,0,0,0,0,0,0,0,0,2,0,0,2,0,0,2,0,0,0},
        {0,0,0,2,0,0,2,0,0,2,0,0,0,0,0,0,0,0,2,0,0,2,0,0,2,0,0,0},
        {0,2,2,2,2,2,2,0,0,2,2,2,2,0,0,2,2,2,2,0,0,2,2,2,2,2,2,0},
        {0,2,0,0,0,0,0,0,0,0,0,0,2,0,0,2,0,0,0,0,0,0,0,0,0,0,2,0},
        {0,2,0,0,0,0,0,0,0,0,0,0,2,0,0,2,0,0,0,0,0,0,0,0,0,0,2,0},
        {0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
    };
    
    public static final int PELLET = 2;
    public static final int POWER_PELLET = 3;
    public static final int PACMAN = 6;
    
    private Scene scene;
    private GameGroup gameGroup;
    
    public GameController(Scene scene, GameGroup gameGroup) {
        this.scene = scene;
        this.gameGroup = gameGroup;
    }
    
    public void initGame() {
        gameGroup.resetView(MAZE);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                case LEFT:
                    gameGroup.getPacman().left();
                    break;
                case RIGHT:
                    gameGroup.getPacman().right();
                    break;
                case UP:
                    gameGroup.getPacman().up();
                    break;
                case DOWN:
                    gameGroup.getPacman().down();
                    break;
                default:
                    break;
                }
            }
        });
//        Thread pacmanAnimator = new Thread(new PacmanAnimator());
//        pacmanAnimator.setDaemon(true);
//        pacmanAnimator.start();
    }

    public boolean isRunning() {
        return true;
    }
//    
//    private class PacmanAnimator implements Runnable {
//        @Override
//        public void run() {
//            long before = System.nanoTime();
//            while (isRunning()) {
//                long now = System.nanoTime();
//                long elapsedTime = now - before;
//                if (elapsedTime < 25) {
//                    try {
//                        Thread.sleep(25 - elapsedTime);
//                    } catch (InterruptedException ignore) {}
//                }
//                gameGroup.getPacman().move();
//                before = System.nanoTime();
//            }
//        }
//    }
}
