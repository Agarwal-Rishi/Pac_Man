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
    int powerPelletWidth = 6;
    int powerPelletLength = 6;
    int bigPowerPelletWidth = 16;
    int bigPowerPelletLength = 16;

    Pacman pacman;
    Ghosts ghosts;

    ImageIcon wall;
    Image scaledWall;


    ImageIcon powerPellet;
    Image scaledPowerPellet;
    ImageIcon bigPowerPellet;
    Image scaledBigPowerPellet;

    long timerEnd1;
    long timerEnd2;

    ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    
    int score;
    // constructor
    public Screen() {

        setFocusable(true);
        addKeyListener(this);

        this.timerEnd2 = System.currentTimeMillis();

        File mazeFile = new File("mazes/maze4.txt");
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

        powerPellet = new ImageIcon("pacman-art/other/dot.png");
        scaledPowerPellet = powerPellet.getImage().getScaledInstance(powerPelletWidth,powerPelletLength, Image.SCALE_SMOOTH);

        bigPowerPellet = new ImageIcon("pacman-art/other/dot.png");
        scaledPowerPellet = powerPellet.getImage().getScaledInstance(bigPowerPelletWidth,bigPowerPelletLength, Image.SCALE_SMOOTH);

        wall = new ImageIcon("pacman-art/wallFinal.png");
        scaledWall = wall.getImage().getScaledInstance(gridLengthWidth, gridLengthWidth, Image.SCALE_SMOOTH);

        pacman = new Pacman(arr);
        ghosts = new Ghosts(arr,pacman.getPacmanY(),pacman.getPacmanX(),pacman.getCurrentDirection());

        score = 0;
    }

    public void animate() {
        while (true) {
            repaint();  
            pacman.move();
            ghosts.ghostAnimate(pacman.currentDirection, pacman.getGridX(),pacman.getGridY(), this.ghostsVulnerable());
            
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
        super.paintComponent(graphics);

        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0,dimensionX,dimensionY);

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

        for (int i = 0; i < this.arr.size(); i++) {
            for (int j = 0; j < this.arr.get(i).size(); j++) {
                if (this.arr.get(i).get(j) == 0) {
                    graphics.drawImage(scaledPowerPellet, i, j, this);
                    
                } else if(this.arr.get(i).get(j) == 3) {
                    graphics.drawImage(scaledBigPowerPellet, i, j, this);
                }
            }
        }

        ghosts.paintComponent(graphics, this.ghostsVulnerable(), this.timerEnd1, this.timerEnd2);
        
        graphics.drawString(String.valueOf(score), 5, 5); 
    }
    // some functions have variables that need to be updated, but don't get called alot. This means we have to store them in a different file
    //TODO: URGENT
    // CREATE BOOLEAN FUCTION THAT MAKES SURE THAT GHOSTS ARE ONLY VULNERABLE WHEN THEY ARE DEAD, NOT IF THEY ARE ALIVE
    private boolean ghostsVulnerable() {
        if (System.currentTimeMillis() < this.timerEnd2) {
            return true;
        } else {
            return false;
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

    public void checkLocation() {
        if (this.arr.get(this.pacman.getGridY()).get(this.pacman.getGridX()) == 0) {
            score += 10;
            this.arr.get(this.pacman.getGridY()).set(this.pacman.getGridX(), 2);
        } else if(this.arr.get(this.pacman.getGridY()).get(this.pacman.getGridX()) == 3) {
            this.arr.get(this.pacman.getGridY()).set(this.pacman.getGridX(), 0);
            timerEnd1 = System.currentTimeMillis() + 8000;
            timerEnd2 = System.currentTimeMillis() + 10000;
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
