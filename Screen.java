import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
//1. Runner.java (The Entry Point) This file is the starting point of your application. It typically contains the main method. Initialization: Creates the main window (e.g., a JFrame).Setup: Instances the Screen (your game board) and adds it to the window.Window Settings: Configures basic window properties like size, title, and "close on exit" behavior. 
// 2. Screen.java (The Game Engine/View) This is usually a JPanel that acts as the "manager" for everything happening during active gameplay. The Maze: Stores the level layout, often as a 2D array of characters or integers (e.g., '#' for wall, '.' for pellet).Rendering: Overrides paintComponent to draw the maze, Pac-Man, and ghosts on the screen.Game Loop: Contains a Timer or thread that updates the game state many times per second.Collision Detection: Checks if Pac-Man hit a wall, ate a pellet, or collided with a ghost.Game State: Manages the score, lives remaining, and game-over conditions. 
// 3. Pacman.java (The Player) This class encapsulates the properties and actions of the player-controlled character. Properties: Position (\(x,y\)), current direction, and speed.Input Handling: Listens for arrow key presses to update the intended direction.Movement Logic: Updates its position based on the current direction, ensuring it doesn't walk through walls.Animation: Logic for the "chomping" mouth effect. 
// 4. Ghost.java (The Enemy AI) This file defines the behavior of the ghosts that chase the player. AI Logic: Implements movement patterns such as "Chase" (tracking Pac-Man), "Scatter" (moving to a corner), or "Frightened" (running away when a power pellet is eaten).Targeting: Calculates the shortest path or next best move to reach its target tile.Visuals: Manages different colors for each ghost (Blinky, Pinky, Inky, Clyde). 

public class Screen extends JPanel implements ActionListener, KeyListener {
    //variables
    int dimensionX;
    int dimensionY;
    //constructor
    dimensionX = 448;
    dimensionY = 448;
    public Screen() {
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

    }
}
