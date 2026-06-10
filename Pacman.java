import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import javax.swing.*;

public class Pacman {   
    //variables
    ImageIcon pacmanPhase1;
    ImageIcon pacmanRightPhase2;
    ImageIcon pacmanLeftPhase2;
    ImageIcon pacmanUpPhase2;
    ImageIcon pacmanDownPhase2;
    ImageIcon pacmanRightPhase3;
    ImageIcon pacmanLeftPhase3;
    ImageIcon pacmanUpPhase3;
    ImageIcon pacmanDownPhase3;

    ImageIcon pacmanDyingPhase4;
    ImageIcon pacmanDyingPhase5;
    ImageIcon pacmanDyingPhase6;
    ImageIcon pacmanDyingPhase7;
    ImageIcon pacmanDyingPhase8;
    ImageIcon pacmanDyingPhase9;
    ImageIcon pacmanDyingPhase10;
    ImageIcon pacmanDyingPhase11;
    ImageIcon pacmanDyingPhase12;
    ImageIcon pacmanDyingPhase13;

    Image scaledPacmanPhase1;
    Image scaledPacmanRightPhase2;
    Image scaledPacmanLeftPhase2;
    Image scaledPacmanUpPhase2;
    Image scaledPacmanDownPhase2;
    Image scaledPacmanRightPhase3;
    Image scaledPacmanLeftPhase3;
    Image scaledPacmanUpPhase3;
    Image scaledPacmanDownPhase3;

    Image scaledPacmanDyingPhase4;
    Image scaledPacmanDyingPhase5;
    Image scaledPacmanDyingPhase6;
    Image scaledPacmanDyingPhase7;
    Image scaledPacmanDyingPhase8;
    Image scaledPacmanDyingPhase9;
    Image scaledPacmanDyingPhase10;
    Image scaledPacmanDyingPhase11;
    Image scaledPacmanDyingPhase12;
    Image scaledPacmanDyingPhase13;

    Image currentPacmanImage;
    int pacmanWidth = 32;
    int pacmanLength = 32;

    Image[] scaledPacmanRight;
    Image[] scaledPacmanLeft;
    Image[] scaledPacmanUp;
    Image[] scaledPacmanDown;
    Image[] scaledPacmanDying;
    
    int pacmanImageIndex;

    int pacmanX = 416;
    int pacmanY = 288;

    int gridX;
    int gridY;

    Direction currentDirection;

    ArrayList<ArrayList<Integer>> arr;

    boolean hasMoved = false;

    public Pacman(ArrayList<ArrayList<Integer>> arr) {

        pacmanPhase1 = new ImageIcon("pacman-art/PacmanPhase1.png");
        pacmanRightPhase2 = new ImageIcon("pacman-art/PacmanRightPhase2.png");
        pacmanLeftPhase2 = new ImageIcon("pacman-art/PacmanLeftPhase2.png");
        pacmanUpPhase2 = new ImageIcon("pacman-art/PacmanUpPhase2.png");
        pacmanDownPhase2 = new ImageIcon("pacman-art/PacmanDownPhase2.png");
        pacmanRightPhase3 = new ImageIcon("pacman-art/PacmanRightPhase3.png");
        pacmanLeftPhase3 = new ImageIcon("pacman-art/PacmanLeftPhase3.png");
        pacmanUpPhase3 = new ImageIcon("pacman-art/PacmanUpPhase3.png");
        pacmanDownPhase3 = new ImageIcon("pacman-art/PacmanDownPhase3.png");
        //The chomping phases are part of the dying animation, which means that the "real"  1st dying animation phase will be named accordingly
        pacmanDyingPhase4 = new ImageIcon("pacman-art/PacmanDyingPhase4.png");
        pacmanDyingPhase5 = new ImageIcon("pacman-art/PacmanDyingPhase5.png");
        pacmanDyingPhase6 = new ImageIcon("pacman-art/PacmanDyingPhase6.png");
        pacmanDyingPhase7 = new ImageIcon("pacman-art/PacmanDyingPhase7.png");
        pacmanDyingPhase8 = new ImageIcon("pacman-art/PacmanDyingPhase8.png");
        pacmanDyingPhase9 = new ImageIcon("pacman-art/PacmanDyingPhase9.png");
        pacmanDyingPhase10 = new ImageIcon("pacman-art/PacmanDyingPhase10.png");
        pacmanDyingPhase11 = new ImageIcon("pacman-art/PacmanDyingPhase11.png");
        pacmanDyingPhase12 = new ImageIcon("pacman-art/PacmanDyingPhase12.png");
        pacmanDyingPhase13 = new ImageIcon("pacman-art/PacmanDyingPhase13.png");

        scaledPacmanPhase1 = pacmanPhase1.getImage().getScaledInstance(pacmanWidth,pacmanLength, Image.SCALE_SMOOTH);
        scaledPacmanRightPhase2 = pacmanRightPhase2.getImage().getScaledInstance(pacmanWidth,pacmanLength, Image.SCALE_SMOOTH);
        scaledPacmanLeftPhase2 = pacmanLeftPhase2.getImage().getScaledInstance(pacmanWidth,pacmanLength,Image.SCALE_SMOOTH);
        scaledPacmanUpPhase2 = pacmanUpPhase2.getImage().getScaledInstance(pacmanWidth,pacmanLength, Image.SCALE_SMOOTH);
        scaledPacmanDownPhase2 = pacmanDownPhase2.getImage().getScaledInstance(pacmanWidth,pacmanLength, Image.SCALE_SMOOTH);
        scaledPacmanRightPhase3 = pacmanRightPhase3.getImage().getScaledInstance(pacmanWidth,pacmanLength,Image.SCALE_SMOOTH);
        scaledPacmanLeftPhase3 = pacmanLeftPhase3.getImage().getScaledInstance(pacmanWidth,pacmanLength,Image.SCALE_SMOOTH);
        scaledPacmanUpPhase3 = pacmanUpPhase3.getImage().getScaledInstance(pacmanWidth,pacmanLength, Image.SCALE_SMOOTH);
        scaledPacmanDownPhase3 = pacmanDownPhase3.getImage().getScaledInstance(pacmanWidth,pacmanLength,Image.SCALE_SMOOTH);


        scaledPacmanDyingPhase4 = pacmanDyingPhase4.getImage().getScaledInstance(pacmanWidth,pacmanLength,Image.SCALE_SMOOTH);
        scaledPacmanDyingPhase5 = pacmanDyingPhase5.getImage().getScaledInstance(pacmanWidth,pacmanLength,Image.SCALE_SMOOTH);
        scaledPacmanDyingPhase6 = pacmanDyingPhase6.getImage().getScaledInstance(pacmanWidth,pacmanLength,Image.SCALE_SMOOTH);
        scaledPacmanDyingPhase7 = pacmanDyingPhase7.getImage().getScaledInstance(pacmanWidth,pacmanLength,Image.SCALE_SMOOTH);
        scaledPacmanDyingPhase8 = pacmanDyingPhase8.getImage().getScaledInstance(pacmanWidth,pacmanLength,Image.SCALE_SMOOTH);
        scaledPacmanDyingPhase9 = pacmanDyingPhase9.getImage().getScaledInstance(pacmanWidth,pacmanLength,Image.SCALE_SMOOTH);
        scaledPacmanDyingPhase10 = pacmanDyingPhase10.getImage().getScaledInstance(pacmanWidth,pacmanLength,Image.SCALE_SMOOTH);
        scaledPacmanDyingPhase11 = pacmanDyingPhase11.getImage().getScaledInstance(pacmanWidth,pacmanLength,Image.SCALE_SMOOTH);
        scaledPacmanDyingPhase12 = pacmanDyingPhase12.getImage().getScaledInstance(pacmanWidth,pacmanLength,Image.SCALE_SMOOTH);
        scaledPacmanDyingPhase13 = pacmanDyingPhase13.getImage().getScaledInstance(pacmanWidth,pacmanLength,Image.SCALE_SMOOTH);

        scaledPacmanRight = new Image[] {scaledPacmanPhase1, scaledPacmanRightPhase2, scaledPacmanRightPhase3};
        scaledPacmanLeft = new Image[] {scaledPacmanPhase1, scaledPacmanLeftPhase2, scaledPacmanLeftPhase3};
        scaledPacmanUp = new Image[] {scaledPacmanPhase1, scaledPacmanUpPhase2, scaledPacmanUpPhase3};
        scaledPacmanDown = new Image[] {scaledPacmanPhase1, scaledPacmanDownPhase2, scaledPacmanDownPhase3};
        scaledPacmanDying = new Image[] {scaledPacmanDyingPhase4, scaledPacmanDyingPhase5, scaledPacmanDyingPhase6, scaledPacmanDyingPhase7, scaledPacmanDyingPhase8, scaledPacmanDyingPhase9, scaledPacmanDyingPhase10, scaledPacmanDyingPhase11, scaledPacmanDyingPhase12, scaledPacmanDyingPhase13};

        currentPacmanImage = scaledPacmanRight[0];

        pacmanImageIndex = 0;   


        currentDirection = Direction.STOP;

        this.arr = arr;

        gridX = pacmanX/32;
        gridY = pacmanY/32;
        
    }
        
    public void drawPacman(Graphics graphics, ImageObserver observer) {
        if (currentPacmanImage != null) {
            graphics.drawImage(currentPacmanImage, pacmanX, pacmanY, observer);
        }
    }

    public void pacmanAnimationRight() {
        if (pacmanImageIndex != 2) {
            pacmanImageIndex += 1;
        }else {
            pacmanImageIndex = 0;
        }
        currentPacmanImage = scaledPacmanRight[pacmanImageIndex];
    }

    public void pacmanAnimationLeft() {
        if (pacmanImageIndex != 2) {
            pacmanImageIndex += 1;
        }else {
            pacmanImageIndex = 0;
        }
        currentPacmanImage = scaledPacmanLeft[pacmanImageIndex];
    }

    public void pacmanAnimationUp() {
        if (pacmanImageIndex != 2) {
            pacmanImageIndex += 1;
        }else {
            pacmanImageIndex = 0;
        }
        currentPacmanImage = scaledPacmanUp[pacmanImageIndex];
    }
    public void pacmanAnimationDown() {
        if (pacmanImageIndex != 2) {
            pacmanImageIndex += 1;
        }else {
            pacmanImageIndex = 0;
        }
        currentPacmanImage = scaledPacmanDown[pacmanImageIndex];
    }
    
    public void move(boolean gameStarted) {
        // System.out.println("MOVE");
        gridY = pacmanY / 32;
        gridX = pacmanX / 32;
        if (pacmanX % 32 != 0 && currentDirection == Direction.LEFT) {
            gridX += 1;
        }
        if (pacmanY % 32 != 0 && currentDirection == Direction.UP) {
            gridY += 1; 
        } 

        if (currentDirection == Direction.RIGHT && gridX == 27) {
            hasMoved = true;
            pacmanX = 0;
        } else if (currentDirection == Direction.RIGHT && this.arr.get(gridY).get(gridX + 1) == 1) {
            currentDirection = Direction.STOP;
        } else if(currentDirection == Direction.RIGHT && this.arr.get(gridY).get(gridX + 1) != 1) {
            if (pacmanY % 32 != 0) {
                if (arr.get(gridY + 1).get(gridX + 1) == 1) {
                    currentDirection = Direction.STOP;
                } else {
                    hasMoved = true;
                    pacmanX += 4;
                    this.pacmanAnimationRight();
                }
            } else {
                hasMoved = true;
                pacmanX += 4;
                this.pacmanAnimationRight();
            }
        }
        if(currentDirection == Direction.LEFT && gridX == 0) {
            hasMoved = true;
            pacmanX = 864;
        } else if (currentDirection == Direction.LEFT && this.arr.get(gridY).get(gridX - 1) == 1) {
            currentDirection = Direction.STOP;
        } else if(currentDirection == Direction.LEFT && this.arr.get(gridY).get(gridX - 1) != 1) {
            if (pacmanY % 32 != 0) {
                if (arr.get(gridY + 1).get(gridX - 1) == 1) {
                    currentDirection = Direction.STOP;
                }else {
                    hasMoved = true;
                    pacmanX -= 4;
                    this.pacmanAnimationLeft();
                }
            } else {
                hasMoved = true;
                pacmanX -= 4;
                this.pacmanAnimationLeft();
            }
        }

        if (currentDirection == Direction.UP && this.arr.get(gridY - 1).get(gridX) == 1) {
            currentDirection = Direction.STOP;
        } else if(currentDirection == Direction.UP && this.arr.get(gridY - 1).get(gridX) != 1) {
            if (pacmanX % 32 != 0) {
                if (arr.get(gridY - 1).get(gridX + 1) == 1) {
                    currentDirection = Direction.STOP;
                }else {
                    hasMoved = true;
                    pacmanY -= 4;
                    this.pacmanAnimationUp();
                }
            } else {
                hasMoved = true;
                pacmanY -= 4;
                this.pacmanAnimationUp();
            }
        }

        if (currentDirection == Direction.DOWN && this.arr.get(gridY + 1).get(gridX) == 1) {
            currentDirection = Direction.STOP;
        } else if(currentDirection == Direction.DOWN && this.arr.get(gridY + 1).get(gridX) != 1) {
            if (pacmanX % 32 != 0) {
                if (arr.get(gridY + 1).get(gridX + 1) == 1) {
                    currentDirection = Direction.STOP;
                }else {
                    hasMoved = true;
                    pacmanY += 4;
                    this.pacmanAnimationDown();
                }
            } else {
                hasMoved = true;
                pacmanY += 4;
                this.pacmanAnimationDown();
            }
        }
    }

    public void pacmanDead() {

    }

    public int getPacmanX() {
        return this.pacmanX;
    }

    public int getPacmanY() {
        return this.pacmanY;
    }
    public int getGridX() {
        return this.gridX;
    }
    public int getGridY() {
        return this.gridY;
    }
    public Direction getCurrentDirection() {
        return this.currentDirection;
    }
    public Image getCurrentPacmanImage() {
        return this.currentPacmanImage;
    }

    public int getPacmanImageIndex() {
        return this.pacmanImageIndex;
    }

}
