import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.*;

//add dying animation when pacman dies


public class Screen extends JPanel implements ActionListener, KeyListener {

    // variables
    int dimensionX = 896;
    int dimensionY = 896;
    int pacmanWidth = 26;
    int pacmanLength = 26;
    int gridLengthWidth = 32;
    int ghostWidth = 28;
    int ghostLength = 28;

    Pacman pacman;

    ImageIcon redGhostRight;
    ImageIcon redGhostLeft;
    ImageIcon redGhostUp;
    ImageIcon redGhostDown;
    ImageIcon redGhostDead;
    ImageIcon pinkGhostRight;
    ImageIcon pinkGhostLeft;
    ImageIcon pinkGhostDead;
    ImageIcon pinkGhostUp;
    ImageIcon pinkGhostDown;
    ImageIcon yellowGhostRight;
    ImageIcon yellowGhostLeft;
    ImageIcon yellowGhostDead;
    ImageIcon yellowGhostUp;
    ImageIcon yellowGhostDown;
    ImageIcon blueGhostRight;
    ImageIcon blueGhostLeft;
    ImageIcon blueGhostUp;
    ImageIcon blueGhostDown;
    ImageIcon blueGhostDead;
    ImageIcon bluePhaseScaredGhost;
    ImageIcon whitePhaseScaredGhost;
    ImageIcon upDeadGhost;
    ImageIcon downDeadGhost;
    ImageIcon leftDeadGhost;
    ImageIcon rightDeadGhost;

    ImageIcon wall;
   

    Image scaledRedGhostRight;
    Image scaledRedGhostLeft;
    Image scaledRedGhostUp;
    Image scaledRedGhostDown;
    Image scaledRedGhostDead;
    Image scaledPinkGhostRight;
    Image scaledPinkGhostLeft;
    Image scaledPinkGhostUp;
    Image scaledPinkGhostDown;
    Image scaledPinkGhostDead;
    Image scaledYellowGhostRight;
    Image scaledYellowGhostLeft;
    Image scaledYellowGhostUp;
    Image scaledYellowGhostDown;
    Image scaledYellowGhostDead;
    Image scaledBlueGhostRight;
    Image scaledBlueGhostLeft;
    Image scaledBlueGhostUp;
    Image scaledBlueGhostDown;
    Image scaledBlueGhostDead;
    Image scaledBluePhaseScaredGhost;
    Image scaledWhitePhaseScaredGhost;
    Image scaledUpDeadGhost;
    Image scaledDownDeadGhost;
    Image scaledLeftDeadGhost;
    Image scaledRightDeadGhost;

    Image scaledWall;

    
    
    ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

    

    // constructor
    public Screen() {

        setFocusable(true);
        addKeyListener(this);

        File mazeFile = new File("mazes/maze3.txt");
        Scanner fin = null;
        try {
            fin = new Scanner(mazeFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int howManyTimes = 0;
        while (fin.hasNextLine() ) {
            String currentLine = fin.nextLine();                    
            ArrayList<Integer> smallArr = new ArrayList<>();
            for (int i = 0; i < currentLine.length(); i++) {
                if (currentLine.charAt(i) != ' ') {
                    howManyTimes += 1;
                    int value = Character.getNumericValue(currentLine.charAt(i));
                    smallArr.add(value);
                }
            }
            arr.add(smallArr);
        }
        System.out.println("howManyTimes: " + howManyTimes);

        // iterate through grid and ensure everything was read in correctly
        // TODO: URGENT

        for(int i = 0; i < arr.size(); i++) {
            for(int j = 0; j < arr.get(i).size(); j++) {
                System.out.print(arr.get(i).get(j) + " ");
            }
            System.out.println();
        }

        redGhostRight = new ImageIcon("pacman-art/RedGhostRight.png");
        redGhostLeft = new ImageIcon("pacman-art/RedGhostLeft.png");
        redGhostUp = new ImageIcon("pacman-art/RedGhostUp.png");
        redGhostDown = new ImageIcon("pacman-art/RedGhostDown.png");
        pinkGhostRight = new ImageIcon("pacman-art/PinkGhostRight.png");
        pinkGhostLeft = new ImageIcon("pacman-art/PinkGhostLeft.png");
        pinkGhostUp = new ImageIcon("pacman-art/PinkGhostUp.png");
        pinkGhostDown = new ImageIcon("pacman-art/PinkGhostDown.png");
        yellowGhostRight = new ImageIcon("pacman-art/YellowGhostRight.png");
        yellowGhostLeft = new ImageIcon("pacman-art/YellowGhostLeft.png");
        yellowGhostUp = new ImageIcon("pacman-art/YellowGhostUp.png");
        yellowGhostDown = new ImageIcon("pacman-art/YellowGhostDown.png");
        blueGhostRight = new ImageIcon("pacman-art/BlueGhostRight.png");
        blueGhostLeft = new ImageIcon("pacman-art/BlueGhostLeft.png");
        blueGhostUp = new ImageIcon("pacman-art/BlueGhostUp.png");
        blueGhostDown = new ImageIcon("pacman-art/BlueGhostDown.png");
        bluePhaseScaredGhost = new ImageIcon("pacman-art/BluePhaseScaredGhost.png");
        whitePhaseScaredGhost = new ImageIcon("pacman-art/WhitePhaseScaredGhost.png");
        upDeadGhost = new ImageIcon("pacman-art/UpDeadGhost.png");
        downDeadGhost = new ImageIcon("pacman-art/DownDeadGhost.png");
        leftDeadGhost = new ImageIcon("pacman-art/LeftDeadGhost.png");
        rightDeadGhost = new ImageIcon("pacman-art/RightDeadGhost.png");

        wall = new ImageIcon("pacman-art/wallFinal.png");

        scaledRedGhostRight = redGhostRight.getImage().getScaledInstance(ghostWidth, ghostLength, Image.SCALE_SMOOTH);
        scaledRedGhostLeft = redGhostLeft.getImage().getScaledInstance(ghostWidth, ghostLength, Image.SCALE_SMOOTH);
        scaledRedGhostUp = redGhostUp.getImage().getScaledInstance(ghostWidth, ghostLength, Image.SCALE_SMOOTH);
        scaledRedGhostDown = redGhostDown.getImage().getScaledInstance(ghostWidth, ghostLength, Image.SCALE_SMOOTH);
        scaledPinkGhostRight = pinkGhostRight.getImage().getScaledInstance(ghostWidth, ghostLength, Image.SCALE_SMOOTH);
        scaledPinkGhostLeft = pinkGhostLeft.getImage().getScaledInstance(ghostWidth, ghostLength, Image.SCALE_SMOOTH);
        scaledPinkGhostUp = pinkGhostUp.getImage().getScaledInstance(ghostWidth, ghostLength, Image.SCALE_SMOOTH);
        scaledPinkGhostDown = pinkGhostDown.getImage().getScaledInstance(ghostWidth, ghostLength, Image.SCALE_SMOOTH);
        scaledYellowGhostRight = yellowGhostRight.getImage().getScaledInstance(ghostWidth, ghostLength, Image.SCALE_SMOOTH);
        scaledYellowGhostLeft = yellowGhostLeft.getImage().getScaledInstance(ghostWidth, ghostLength, Image.SCALE_SMOOTH);
        scaledYellowGhostUp = yellowGhostUp.getImage().getScaledInstance(ghostWidth, ghostLength, Image.SCALE_SMOOTH);
        scaledYellowGhostDown = yellowGhostDown.getImage().getScaledInstance(ghostWidth, ghostLength, Image.SCALE_SMOOTH);
        scaledBlueGhostRight = blueGhostRight.getImage().getScaledInstance(ghostWidth, ghostLength, Image.SCALE_SMOOTH);
        scaledBlueGhostLeft = blueGhostLeft.getImage().getScaledInstance(ghostWidth, ghostLength, Image.SCALE_SMOOTH);
        scaledBlueGhostUp = blueGhostUp.getImage().getScaledInstance(ghostWidth, ghostLength, Image.SCALE_SMOOTH);
        scaledBlueGhostDown = blueGhostDown.getImage().getScaledInstance(ghostWidth, ghostLength, Image.SCALE_SMOOTH);
        scaledBluePhaseScaredGhost = bluePhaseScaredGhost.getImage().getScaledInstance(ghostWidth, ghostLength, Image.SCALE_SMOOTH);
        scaledWhitePhaseScaredGhost = whitePhaseScaredGhost.getImage().getScaledInstance(ghostWidth, ghostLength, Image.SCALE_SMOOTH);
        scaledUpDeadGhost = upDeadGhost.getImage().getScaledInstance(ghostWidth, ghostLength, Image.SCALE_SMOOTH);
        scaledDownDeadGhost = downDeadGhost.getImage().getScaledInstance(ghostWidth, ghostLength, Image.SCALE_SMOOTH);
        scaledLeftDeadGhost = leftDeadGhost.getImage().getScaledInstance(ghostWidth, ghostLength, Image.SCALE_SMOOTH);
        scaledRightDeadGhost = rightDeadGhost.getImage().getScaledInstance(ghostWidth, ghostLength, Image.SCALE_SMOOTH);

        

        scaledWall = wall.getImage().getScaledInstance(gridLengthWidth, gridLengthWidth, Image.SCALE_SMOOTH);

        pacman = new Pacman(arr);
    }

    public void animate() {
        while (true) {
            repaint();  
            pacman.move();
            
            try {
                Thread.sleep(50);// sleeps for 50 milliseconds
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // reset the interruption status
                e.printStackTrace(); // or handle it in some other way
            }
        } 
    } 

    

    @Override
    public Dimension getPreferredSize(){
        return new Dimension(dimensionX, dimensionY);
    }

    @Override
    public void paintComponent(Graphics graphics){
        for (int i = 0; i <= dimensionX; i += gridLengthWidth) {
            graphics.drawLine(i,0,i,dimensionY);
            graphics.drawLine(0,i,dimensionX,i);
        } 

        pacman.drawPacman(graphics);

        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(i).size(); j++) {
                if (arr.get(i).get(j) == 1) {
                    graphics.drawImage(scaledWall, j * 32, i * 32, this);
                } 
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent event) {
        // code to move the pacman
        if (event.getKeyCode() == 39) {
            // move the pacman to the right and change the image to the right
            pacman.currentDirection = Direction.RIGHT;
            pacman.pacmanAnimationRight();
        }
        if (event.getKeyCode() == 37) {
            // move the pacman to the left and change the image to the left
            pacman.currentDirection = Direction.LEFT;
            pacman.pacmanAnimationLeft();
        }
        if (event.getKeyCode() == 38) {
            // move the pacman up and change the image to the up
            pacman.currentDirection = Direction.UP;
            pacman.pacmanAnimationUp();
        }
        if (event.getKeyCode() == 40) {
            // move the pacman down and change the image to the down
            pacman.currentDirection = Direction.DOWN;
            pacman.pacmanAnimationDown();
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

    
    
}
