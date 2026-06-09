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
    int powerPelletWidth = 32;
    int powerPelletLength = 32;
    int bigPowerPelletWidth = 32;
    int bigPowerPelletLength = 32;

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

    boolean gameStarted = false;

    ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    
    int score;

    int numOfPellets = 0;
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

        for(int i = 0; i < arr.size(); i++) {
            for(int j = 0; j < arr.get(i).size(); j++) {
                if(arr.get(i).get(j) == 0) {
                    numOfPellets += 1;
                }
            }
        }


        // iterate through grid and ensure everything was read in correctly
        // TODO: URGENT


        

        powerPellet = new ImageIcon("pacman-art/Pellet.png");
        scaledPowerPellet = powerPellet.getImage().getScaledInstance(powerPelletWidth,powerPelletLength, Image.SCALE_SMOOTH);

        bigPowerPellet = new ImageIcon("pacman-art/PowerPellet.png");
        scaledBigPowerPellet = bigPowerPellet.getImage().getScaledInstance(bigPowerPelletWidth,bigPowerPelletLength, Image.SCALE_SMOOTH);

        

        wall = new ImageIcon("pacman-art/wallFinal.png");
        scaledWall = wall.getImage().getScaledInstance(gridLengthWidth, gridLengthWidth, Image.SCALE_SMOOTH);

        pacman = new Pacman(arr);
        ghosts = new Ghosts(arr,pacman.getPacmanY(),pacman.getPacmanX(),pacman.getCurrentDirection());

        score = 0;
    }

    public void animate() {
        while (true) {
            if (ghostsVulnerable()) {
                this.ghosts.redGhostScatter();
                // this.ghosts.yellowGhostScatter();
                // this.ghosts.pinkGhostScatter();
                // this.ghosts.blueGhostScatter();
            }
            repaint();  
            pacman.move(gameStarted);
            this.checkLocation();     
            ghosts.ghostAnimate(pacman.currentDirection, pacman.getGridX(),pacman.getGridY(), this.ghostsVulnerable(), this.gameStarted, pacman.getPacmanX(), pacman.getPacmanY());
            
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

        if (!win()) {
            super.paintComponent(graphics);
    
            graphics.setColor(Color.BLACK);
            graphics.fillRect(0,0,dimensionX,dimensionY);
    
            for (int i = 0; i <= dimensionX; i += gridLengthWidth) {
                graphics.drawLine(i,0,i,dimensionY);
                graphics.drawLine(0,i,dimensionX,i);
            } 
    
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
                        graphics.drawImage(scaledPowerPellet, j * 32, i * 32, this);
                    } else if(this.arr.get(i).get(j) ==  3) {
                        graphics.drawImage(scaledBigPowerPellet, j * 32, i * 32, this);
                    }
                }
            }
    
            pacman.drawPacman(graphics, this);
    
            ghosts.paintComponent(graphics, this.ghostsVulnerable(), this.timerEnd1, this.timerEnd2);
            
            graphics.drawString(String.valueOf(score), 5, 5); 
        } else {
            graphics.drawString("YOU WIN, LUCKY AHHH NO SKILLER", 400, 400);
        }
    }


    public boolean deadOrAlive() {
        if(!ghostsVulnerable()) {
            if (arr.get(this.pacman.getGridY()).get(this.pacman.getGridX()) == 
            arr.get(this.ghosts.getGridBlueGhostY()).get(this.ghosts.getGridBlueGhostX()) || 
            arr.get(this.pacman.getGridY()).get(this.pacman.getGridX()) == 
            arr.get(this.ghosts.getGridPinkGhostY()).get(this.ghosts.getGridPinkGhostX()) ||
             arr.get(this.pacman.getGridY()).get(this.pacman.getGridX()) ==
              arr.get(this.ghosts.getGridYellowGhostY()).get(this.ghosts.getGridYellowGhostX()) ||
               (gameStarted && arr.get(this.pacman.getGridY()).get(this.pacman.getGridX()) ==
                arr.get(this.ghosts.getGridRedGhostY()).get(this.ghosts.getGridRedGhostX()))) {
                this.pacman.pacmanDying();
                return true;
            }
            if (arr.get(this.pacman.getGridY()).get(this.pacman.getGridX()) ==
             arr.get(this.ghosts.getGridPinkGhostY()).get(this.ghosts.getGridPinkGhostX())) {
                this.pacman.pacmanDying();
                return true;
            }
            if (arr.get(this.pacman.getGridY()).get(this.pacman.getGridX()) ==
             arr.get(this.ghosts.getGridYellowGhostY()).get(this.ghosts.getGridYellowGhostX())) {
                this.pacman.pacmanDying();
                return true;
            }
            if (gameStarted && arr.get(this.pacman.getGridY()).get(this.pacman.getGridX()) ==
             arr.get(this.ghosts.getGridRedGhostY()).get(this.ghosts.getGridRedGhostX())) {
                this.pacman.pacmanDying();
                return true;
            }
        }else {
            
            return false;
        }
        return false;
    }

    // DONT REMOVE:some functions have variables that need to be updated, but don't get called alot. This means we have to store them in a different file.

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
        if (event.getKeyCode() == KeyEvent.VK_RIGHT) {

            // move the pacman to the right and change the image to the right
            this.pacman.currentDirection = Direction.RIGHT;
            this.pacman.pacmanAnimationRight();
            gameStarted = true;
            
        }
        if (event.getKeyCode() == KeyEvent.VK_LEFT) {
            // move the pacman to the left and change the image to the left
            this.pacman.currentDirection = Direction.LEFT;
            this.pacman.pacmanAnimationLeft();
            gameStarted = true;
            
        }
        if (event.getKeyCode() == KeyEvent.VK_UP) {
            // move the pacman up and change the image to the up
            this.pacman.currentDirection = Direction.UP;
            this.pacman.pacmanAnimationUp();
            gameStarted = true;
            
        }
        if (event.getKeyCode() == KeyEvent.VK_DOWN) {
            // move the pacman down and change the image to the down
            this.pacman.currentDirection = Direction.DOWN;
            this.pacman.pacmanAnimationDown();
            gameStarted = true;
        }
        
        

    }

    public void checkLocation() {
        int amount = 32 - (this.pacman.getPacmanY() - (this.pacman.getGridY() * 32));
        if (amount > 16) {
            if (this.arr.get(this.pacman.getGridY()).get(this.pacman.getGridX()) == 0) {
                this.arr.get(this.pacman.getGridY()).set(this.pacman.getGridX(), 2);
                score += 100;
                numOfPellets -= 1;
            }
        } else if (amount == 16) {
            if (this.arr.get(this.pacman.getGridY()).get(this.pacman.getGridX()) == 0) {
                score += 100;
                numOfPellets -= 1;
                this.arr.get(this.pacman.getGridY()).set(this.pacman.getGridX(), 2);
            }
            
            if (this.arr.get(this.pacman.getGridY() + 1).get(this.pacman.getGridX()) == 0) {
                score += 100;
                numOfPellets -= 1;
                this.arr.get(this.pacman.getGridY() + 1).set(this.pacman.getGridX(), 2);
            }
        } else if (amount < 16) {
            if (this.arr.get(this.pacman.getGridY() + 1).get(this.pacman.getGridX()) == 0) {
                this.arr.get(this.pacman.getGridY() + 1).set(this.pacman.getGridX(), 2);
                score += 100;
                numOfPellets -= 1;
            }
        }

        if (this.arr.get(this.pacman.getGridY()).get(this.pacman.getGridX()) == 3) {
            timerEnd1 = System.currentTimeMillis() + 8000;
            timerEnd2 = System.currentTimeMillis() + 10000;
            this.arr.get(this.pacman.getGridY()).set(this.pacman.getGridX(), 2);
        }

        // these next lines will see if the pacman has won the game

        
    }

    public boolean win() {
        if (numOfPellets == 0) {
            return true;
        } else {
            return false;
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
