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

//add dying animation when pacman dies


public class Screen extends JPanel implements ActionListener, KeyListener {

    // variables
    int dimensionX = 448;
    int dimensionY = 448;

 
    
    ImageIcon redGhostNormal;
    ImageIcon redGhostDead;
    ImageIcon pinkGhostNormal;
    ImageIcon pinkGhostDead;
    ImageIcon yellowGhostNormal;
    ImageIcon yellowGhostDead;
    ImageIcon blueGhostNormal;
    ImageIcon blueGhostDead;
    ImageIcon frightenedGhost;
   
   

    Image scaledRedGhostNormal;
    Image scaledRedGhostDead;
    Image scaledPinkGhostNormal;
    Image scaledPinkGhostDead;
    Image scaledYellowGhostNormal;
    Image scaledYellowGhostDead;
    Image scaledBlueGhostNormal;
    Image scaledBlueGhostDead;
    Image scaledFrightenedGhost;

    int pacmanWidth = 13;
    int pacmanLength = 13;

    int ghostWidth = 14;
    int ghostLength = 14;

    int gridLengthAndWidth;
  
    ArrayList<ArrayList<Integer>> arr;
    Scanner scanner;

    //constructor
    public Screen() {
        

        redGhostNormal = new ImageIcon("pacman-art/ghosts/blinky.png");
        // need to add the dead sprite for red ghost
        pinkGhostNormal = new ImageIcon("pacman-art/ghosts/pinky.png");
        // need to add the dead sprite for pink ghost
        yellowGhostNormal = new ImageIcon("pacman-art/ghosts/inky.png");
        // need to add the dead sprite for yellow ghost
        blueGhostNormal = new ImageIcon("pacman-art/ghosts/clyde.png");
        // need to add the dead sprite for blue ghost
        frightenedGhost = new ImageIcon("pacman-art/ghosts/frightened.png");

        gridLengthAndWidth = 16;

       

        scaledRedGhostNormal = redGhostNormal.getImage().getScaledInstance(ghostWidth, ghostLength, Image.SCALE_SMOOTH);
        // need to add the dead sprite for red ghost
        scaledPinkGhostNormal = pinkGhostNormal.getImage().getScaledInstance(ghostWidth, ghostLength, Image.SCALE_SMOOTH);
         // need to add the dead sprite for pink ghost
        scaledYellowGhostNormal = yellowGhostNormal.getImage().getScaledInstance(ghostWidth, ghostLength, Image.SCALE_SMOOTH);
         // need to add the dead sprite for yellow ghost
        scaledBlueGhostNormal = blueGhostNormal.getImage().getScaledInstance(ghostWidth, ghostLength, Image.SCALE_SMOOTH);
         // need to add the dead sprite for blue ghost

        

        FileReader file_io = new FileReader(new File("mazes/maze1.txt"));
        scanner = new Scanner(file_io);

        // todo: file io
        // assume that we read in maze1.txt into arr

    }

    public void animate(){

    }
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(dimensionX, dimensionY);
    }

    @Override
    public void keyPressed(KeyEvent event){
        //code to move the pacman
        if(event.getKeyCode() == 39) {
            //move the pacman to the right and change the image to the right
        }
        if(event.getKeyCode() == 37) {
            //move the pacman to the left and change the image to the left
        }
        if(event.getKeyCode() == 38) {
            //move the pacman up and change the image to the up
        }
        if(event.getKeyCode() == 40) {
            //move the pacman down and change the image to the down
        }
    }

    @Override
    public void keyReleased(KeyEvent event) {
        // Required by KeyListener interface
    }

    @Override
    public void keyTyped(KeyEvent event) {
        // Required by KeyListener interface
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        // Required by ActionListener interface
    }

    @Override
    public void paintComponent(Graphics graphics){
        for(int i = 0; i <= dimensionX;i += 16) {
            graphics.drawLine(i,0,i,dimensionX);
        }
        
    }
}
