`import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.random.*;
import java.util.*;
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

    int pacmanWidth = 13;
    int pacmanLength = 13;

    Image[] scaledPacmanRight;
    Image[] scaledPacmanLeft;
    Image[] scaledPacmanUp;
    Image[] scaledPacmanDown;
    Image[] scaledPacmanDying;
    

    int pacmanImageIndex;

    int pacmanX;
    int pacmanY;

   

    public Pacman() {

        pacmanPhase1 = new ImageIcon("pacman-art/PacmanPhase1");
        pacmanRightPhase2 = new ImageIcon("pacman-art/PacmanRightPhase2");
        pacmanLeftPhase2 = new ImageIcon("pacman-art/PacmanLeftPhase2");
        pacmanUpPhase2 = new ImageIcon("pacman-art/PacmanUpPhase2");
        pacmanDownPhase2 = new ImageIcon("pacman-art/PacmanDownPhase2");
        pacmanRightPhase3 = new ImageIcon("pacman-art/PacmanRightPhase3");
        pacmanLeftPhase3 = new ImageIcon("pacman-art/PacmanLeftPhase3");
        pacmanUpPhase3 = new ImageIcon("pacman-art/PacmanUpPhase3");
        pacmanDownPhase3 = new ImageIcon("pacman-art/PacmanDownPhase3");
        //The chomping phases are part of the dying animation, which means that the "real"  1st dying animation phase will be named accordingly
        pacmanDyingPhase4 = new ImageIcon("pacman-art/PacmanDyingPhase4");
        pacmanDyingPhase5 = new ImageIcon("pacman-art/PacmanDyingPhase5");
        pacmanDyingPhase6 = new ImageIcon("pacman-art/PacmanDyingPhase6");
        pacmanDyingPhase7 = new ImageIcon("pacman-art/PacmanDyingPhase7");
        pacmanDyingPhase8 = new ImageIcon("pacman-art/PacmanDyingPhase8");
        pacmanDyingPhase9 = new ImageIcon("pacman-art/PacmanDyingPhase9");
        pacmanDyingPhase10 = new ImageIcon("pacman-art/PacmanDyingPhase10");
        pacmanDyingPhase11 = new ImageIcon("pacman-art/PacmanDyingPhase11");
        pacmanDyingPhase12 = new ImageIcon("pacman-art/PacmanDyingPhase12");
        pacmanDyingPhase13 = new ImageIcon("pacman-art/PacmanDyingPhase13");

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
        scaledPacmanDying = new Image[] {scaledPacmanDyingPhase4, scaledPacmanDyingPhase5, scaledPacmanDyingPhase6, scaledPacmanDyingPhase7, scaledPacmanDyingPhase8, scaledPacmanDyingPhase9, scaledPacmanDyingPhase10, scaledPacmanDyingPhase11, scaledPacmanDyingPhase12, scaledPacmanDyingPhase13};
        scaledPacmanLeft = new Image[] {scaledPacmanPhase1, scaledPacmanLeftPhase2, scaledPacmanLeftPhase3};
        scaledPacmanUp = new Image[] {scaledPacmanPhase1, scaledPacmanUpPhase2, scaledPacmanUpPhase3};
        scaledPacmanDown = new Image[] {scaledPacmanPhase1, scaledPacmanDownPhase2, scaledPacmanDownPhase3};

        currentPacmanImage = pacmanRightPhase3.getImage();

        pacmanImageIndex = 0;
        
    }

    public void drawPacman(Graphics graphics) {
        if (currentPacmanImage != null) {
            graphics.drawImage(currentPacmanImage, pacmanX, pacmanY, null);
        }
    }

    public void pacmanAnimationRight() {
        pacmanImageIndex += 1;
        if (pacmanImageIndex == 3) {
            pacmanImageIndex = 0;
        }
        currentPacmanImage = scaledPacmanRight[pacmanImageIndex];
    }

    public void pacmanAnimationLeft() {
        pacmanImageIndex += 1;
        if (pacmanImageIndex == 3) {
            pacmanImageIndex = 0;
        }
        currentPacmanImage = scaledPacmanLeft[pacmanImageIndex];
    }

    public void pacmanAnimationUp() {
        pacmanImageIndex += 1;
        if (pacmanImageIndex == 3) {
            pacmanImageIndex = 0;
        }
        currentPacmanImage = scaledPacmanUp[pacmanImageIndex];
    }
    public void pacmanAnimationDown() {
        pacmanImageIndex += 1;
        if (pacmanImageIndex == 3) {
            pacmanImageIndex = 0;
        }
        currentPacmanImage = scaledPacmanDown[pacmanImageIndex];
    }

    public void pacmanDirectionRight() {
        pacmanX += 5;
    }
    public void pacmanDirectionLeft() {
        pacmanX -= 5;
    }
    public void pacmanDirectionUp() {
        pacmanY -= 5;
    }
    public void pacmanDirectionDown() {
        pacmanY += 5;
    }
}
