package com.ladybug.sample.pacman.view;

import com.ladybug.sample.pacman.controller.GameController;

import javafx.geometry.Dimension2D;
import javafx.scene.Group;
import javafx.scene.Node;

public class GameGroup extends Group {

    static final short DELTA = 7;
    
    private Group pelletsGroup;
    private Group powerPelletsGroup;
    private PacmanGroup pacmanGroup;
    
    private PlayField playField;
    private int[][] maze;
    
    private double slotWidth;
    private double slotHeight;
    
    public GameGroup() {
        pelletsGroup = new Group();
        powerPelletsGroup = new Group();        
        initPlayField();
    }

    private void initPlayField() {
        playField = new PlayField();
        this.getChildren().add(playField);
        
        Dimension2D size = getSize();
        slotWidth = size.getWidth() / GameController.COLUMNS;
        slotHeight = size.getHeight() / GameController.ROWS;
    }
    
    public Dimension2D getSize() {
        Dimension2D size =
                new Dimension2D(playField.getWidth(), playField.getHeight());
        return size;
    }

    public void resetView(final int[][] sourceMaze) {
        
        maze = new int[GameController.ROWS][GameController.COLUMNS];
        for (int i = 0; i < sourceMaze.length; i++) {
            System.arraycopy(sourceMaze[i], 0, maze[i], 0, sourceMaze[i].length);
        }
        
        for (int i = 0; i < GameController.ROWS; i++) {
            for (int j = 0; j < GameController.COLUMNS; j++) {
                switch (maze[i][j]) {
                case GameController.PELLET:
                    addPellets(new Pellet(), j, i);
                    break;
                case GameController.POWER_PELLET:
                    addPellets(new PowerPellet(), j, i);
                    break;
                case GameController.PACMAN:
                    Pacman pacman = new Pacman();
                    pacman.setLayoutX(10 + DELTA + slotWidth * j);
                    pacman.setLayoutY(DELTA + slotHeight * i);
                    pacmanGroup = new PacmanGroup(pacman);
                    break;
                default:
                    break;
                }
            }
        }
        getChildren().addAll(pelletsGroup, powerPelletsGroup, pacmanGroup);
    }

    private void addPellets(Node node, int x, int y) {
        node.setLayoutX(DELTA + slotWidth * x);
        node.setLayoutY(DELTA + slotHeight * y);
        if (node instanceof Pellet) {
            pelletsGroup.getChildren().add(node);
        } else {
            powerPelletsGroup.getChildren().add(node);
        }
    }

    public PacmanGroup getPacman() {
        return pacmanGroup;
    }
}
