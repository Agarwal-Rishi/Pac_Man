import java.awt.*;
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
        ImageIcon pacmanRightPhase1;
    ImageIcon pacmanLeftPhase1;
    ImageIcon pacmanUpPhase1;
    ImageIcon pacmanDownPhase1;
    ImageIcon pacmanRightPhase2;
    ImageIcon pacmanLeftPhase2;
    ImageIcon pacmanUpPhase2;
    ImageIcon pacmanDownPhase2;
    ImageIcon pacmanRightPhase3;
    ImageIcon pacmanLeftPhase3;
    ImageIcon pacmanUpPhase3;
    ImageIcon pacmanDownPhase3;

    Image scaledPacmanRightPhase1;
    Image scaledPacmanLeftPhase1;
    Image scaledPacmanUpPhase1;
    Image scaledPacmanDownPhase1;
    Image scaledPacmanRightPhase2;
    Image scaledPacmanLeftPhase2;
    Image scaledPacmanUpPhase2;
    Image scaledPacmanDownPhase2;
    Image scaledPacmanRightPhase3;
    Image scaledPacmanLeftPhase3;
    Image scaledPacmanUpPhase3;
    Image scaledPacmanDownPhase3;

    ImageIcon currentPacmanImage;

    int pacmanWidth = 13;
    int pacmanLength = 13;

    Image[] scaledPacmanRight;
    Image[] scaledPacmanLeft;
    Image[] scaledPacmanUp;
    Image[] scaledPacmanDown;

    int pacmanImageIndex;

   

    public Pacman() {
        pacmanUpPhase1 = new ImageIcon("pacman-art/pacman-up/1.png");
        pacmanDownPhase1 = new ImageIcon("pacman-art/pacman-down/1.png");
        pacmanRightPhase2 = new ImageIcon("pacman-art/pacman-right/2.png");
        pacmanLeftPhase2 = new ImageIcon("pacman-art/pacman-left/2.png");
        pacmanUpPhase2 = new ImageIcon("pacman-art/pacman-up/2.png");
        pacmanDownPhase2 = new ImageIcon("pacman-art/pacman-down/2.png");
        pacmanRightPhase3 = new ImageIcon("pacman-art/pacman-right/3.png");
        pacmanLeftPhase3 = new ImageIcon("pacman-art/pacman-left/3.png");
        pacmanUpPhase3 = new ImageIcon("pacman-art/pacman-up/3.png");
        pacmanDownPhase3 = new ImageIcon("pacman-art/pacman-down/3.png");

        scaledPacmanRightPhase1 = pacmanRightPhase1.getImage().getScaledInstance(pacmanWidth,pacmanLength, Image.SCALE_SMOOTH);
        scaledPacmanLeftPhase1 = pacmanLeftPhase1.getImage().getScaledInstance(pacmanWidth, pacmanLength, Image.SCALE_SMOOTH);
        scaledPacmanUpPhase1 = pacmanUpPhase1.getImage().getScaledInstance(pacmanWidth,pacmanLength, Image.SCALE_SMOOTH);
        scaledPacmanDownPhase1 = pacmanDownPhase1.getImage().getScaledInstance(pacmanWidth, pacmanLength, Image.SCALE_SMOOTH);
        scaledPacmanRightPhase2 = pacmanRightPhase2.getImage().getScaledInstance(pacmanWidth,pacmanLength, Image.SCALE_SMOOTH);
        scaledPacmanLeftPhase2 = pacmanLeftPhase2.getImage().getScaledInstance(pacmanWidth,pacmanLength,Image.SCALE_SMOOTH);
        scaledPacmanUpPhase2 = pacmanUpPhase2.getImage().getScaledInstance(pacmanWidth,pacmanLength, Image.SCALE_SMOOTH);
        scaledPacmanDownPhase2 = pacmanDownPhase2.getImage().getScaledInstance(pacmanWidth,pacmanLength, Image.SCALE_SMOOTH);
        scaledPacmanRightPhase3 = pacmanRightPhase3.getImage().getScaledInstance(pacmanWidth,pacmanLength,Image.SCALE_SMOOTH);
        scaledPacmanLeftPhase3 = pacmanLeftPhase3.getImage().getScaledInstance(pacmanWidth,pacmanLength,Image.SCALE_SMOOTH);
        scaledPacmanUpPhase3 = pacmanUpPhase3.getImage().getScaledInstance(pacmanWidth,pacmanLength, Image.SCALE_SMOOTH);
        scaledPacmanDownPhase3 = pacmanDownPhase3.getImage().getScaledInstance(pacmanWidth,pacmanLength,Image.SCALE_SMOOTH);

        scaledPacmanRight = {scaledPacmanRightPhase1, scaledPacmanRightPhase2, scaledPacmanRightPhase3};

        currentPacmanImage = pacmanRightPhase3;
        pacmanImageIndex = 0;

        
        
    }

    public void pacmanAnimation() {
        pacmanImageIndex += 1;
        if (pacmanImageIndex == 3) {
            pacmanImageIndex = 0;
        }
        currentPacmanImage = scaledPacmanRight[pacmanImageIndex];
    }

    public void PacmanDirectionRight() {
        
    }
}
