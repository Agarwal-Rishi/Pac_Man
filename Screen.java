import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
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

    Pacman pacman;
    
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

  
    
    ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

    //constructor
    public Screen() {
        File mazeFile = new File("mazes/maze1.txt");
        Scanner fin = null;
        try {
            fin = new Scanner(mazeFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (fin.hasNextLine() ) {
            String currentLine = fin.nextLine();                    
            ArrayList<Integer> smallArr = new ArrayList<>();
            for (int i = 0; i < currentLine.length(); i++) {
                if (currentLine.charAt(i) != ' ') {
                    int value = Character.getNumericValue(currentLine.charAt(i));
                    smallArr.add(value);
                    arr.add(smallArr);
                }
                
            }
            // 
            // grid[pacmanX][pacmanY] is that position blocked or not
        }

        redGhostNormal = new ImageIcon("pacman-art/ghosts/blinky.png");
        // need to add the dead sprite for red ghost
        pinkGhostNormal = new ImageIcon("pacman-art/ghosts/pinky.png");
        // need to add the dead sprite for pink ghost
        yellowGhostNormal = new ImageIcon("pacman-art/ghosts/inky.png");
        // need to add the dead sprite for yellow ghost
        blueGhostNormal = new ImageIcon("pacman-art/ghosts/clyde.png");
        // need to add the dead sprite for blue ghost
        frightenedGhost = new ImageIcon("pacman-art/ghosts/frightened.png");

       

        scaledRedGhostNormal = redGhostNormal.getImage().getScaledInstance(ghostWidth, ghostLength, Image.SCALE_SMOOTH);
        // need to add the dead sprite for red ghost
        scaledPinkGhostNormal = pinkGhostNormal.getImage().getScaledInstance(ghostWidth, ghostLength, Image.SCALE_SMOOTH);
         // need to add the dead sprite for pink ghost
        scaledYellowGhostNormal = yellowGhostNormal.getImage().getScaledInstance(ghostWidth, ghostLength, Image.SCALE_SMOOTH);
         // need to add the dead sprite for yellow ghost
        scaledBlueGhostNormal = blueGhostNormal.getImage().getScaledInstance(ghostWidth, ghostLength, Image.SCALE_SMOOTH);
         // need to add the dead sprite for blue ghost\

         pacman = new Pacman();

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
            pacman.pacmanDirectionRight();
        }
        if(event.getKeyCode() == 37) {
            //move the pacman to the left and change the image to the left
            pacman.pacmanDirectionLeft();
        }
        if(event.getKeyCode() == 38) {
            //move the pacman up and change the image to the up
            pacman.pacmanDirectionUp();
        }
        if(event.getKeyCode() == 40) {
            //move the pacman down and change the image to the down
            pacman.pacmanDirectionDown();        
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

        pacman.drawPacman(graphics);
        
        
    }
}
