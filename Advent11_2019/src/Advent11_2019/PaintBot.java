package Advent11_2019;

import java.util.Map;
import java.util.HashMap;

public class PaintBot {

    boolean[][] whatColorIsCoordinate = new boolean[200][200];
    boolean[][] haveIPaintedHere = new boolean[200][200];

    int xCoordinate = 100;
    int yCoordinate = 100;
    Long white = 1L;
    Long black = 0L;
    char currentDirection = 'n';

    public PaintBot() {
        whatColorIsCoordinate[99][99] = false;
    }

    //returns whether the coordinate the paintBot is currently located at has been painted or not.
    public boolean getIsItPainted() {
        return haveIPaintedHere[xCoordinate][yCoordinate];
    }

    /*returns the color of the coordinate the paintBot is currently located at.
    NOTE: if it has not been painted yet it will return '0', representing black.*/
    public Long getWhatColor() {
        if (whatColorIsCoordinate[xCoordinate][yCoordinate]) {
            return white;
        } else {
            return black;
        }
    }

    //sets the direction of the paintBot
    public void setDirection(Long turnIn) {

        switch (currentDirection) {
            case 'n':
                if (turnIn == 0) {
                    currentDirection = 'w';
                } else if (turnIn == 1) {
                    currentDirection = 'e';
                } else {
                    System.out.println("SD-n | error");
                }
                break;
            case 'w':
                if (turnIn == 0) {
                    currentDirection = 's';
                } else if (turnIn == 1) {
                    currentDirection = 'n';
                } else {
                    System.out.println("SD-w | error");
                }
                break;
            case 's':
                if (turnIn == 0) {
                    currentDirection = 'e';
                } else if (turnIn == 1) {
                    currentDirection = 'w';
                } else {
                    System.out.println("SD-s | error");
                }
                break;
            case 'e':
                if (turnIn == 0) {
                    currentDirection = 'n';
                } else if (turnIn == 1) {
                    currentDirection = 's';
                } else {
                    System.out.println("SD-e | error");
                }
                break;
        }
    }

    //moves the paintBot 1 unit in the direction it is facing
    public void moveBot() {
        switch (currentDirection) {
            case 'n':
                yCoordinate = yCoordinate++;
                break;
            case 'w':
                xCoordinate = xCoordinate--;
                break;
            case 's':
                yCoordinate = yCoordinate--;
                break;
            case 'e':
                xCoordinate = xCoordinate++;
                break;
        }
    }

    //paints the coordinates the paintBot is currently located at to a color based on the input
    public void paint(Long input) {

        if (input == 0) {
            whatColorIsCoordinate[xCoordinate][yCoordinate] = false;
            haveIPaintedHere[xCoordinate][yCoordinate] = true;
        } else if (input == 1) {
            whatColorIsCoordinate[xCoordinate][yCoordinate] = true;
            haveIPaintedHere[xCoordinate][yCoordinate] = true;
        } else {
            System.out.println("P    | error");
        }
    }

    //returns the proper char at a specific coordinate. To be used for the display Map.
    public char getMapChar(int xIn, int yIn) {

        char toReturn = '$';
        if (xIn == xCoordinate && yIn == yCoordinate) {
            switch (currentDirection) {
                case 'n':
                   toReturn = '^';
                break;
                case 'w':
                    toReturn = '<';
                break;
                case 's':
                    toReturn = 'v';
                break;
                case 'e':
                    toReturn = '>';
                break;
            }
        } else {
            if (whatColorIsCoordinate[xIn][yIn]) {
                toReturn = '#';
            } else {
                toReturn = '.';
            }
        }
      return toReturn;
    }
}

