1. Runner.java (The Entry Point) This file is the starting point of your application. It typically contains the main method.
 Initialization: Creates the main window (e.g., a JFrame).
Setup: Instances the Screen (your game board) and adds it to the window.
Window Settings: Configures basic window properties like size, title, and "close on exit" behavior.
 
2. Screen.java (The Game Engine/View) This is usually a JPanel that acts as the "manager" for everything happening during active gameplay. 
The Maze: Stores the level layout, often as a 2D array of characters or integers (e.g., '#' for wall, '.' for pellet).
Rendering: Overrides paintComponent to draw the maze, Pac-Man, and ghosts on the screen.
Game Loop: Contains a Timer or thread that updates the game state many times per second.Collision Detection: Checks if Pac-Man hit a wall, ate a pellet, or collided with a ghost.Game 
State: Manages the score, lives remaining, and game-over conditions. 

3. Pacman.java (The Player) This class encapsulates the properties and actions of the player-controlled character. Properties: Position (\(x,y\)), current direction, and speed.
Input Handling: Listens for arrow key presses to update the intended direction.Movement Logic
: Updates its position based on the current direction, ensuring it doesn't walk through walls.Animation
: Logic for the "chomping" mouth effect. 

4. Ghost.java (The Enemy AI) This file defines the behavior of the ghosts that chase the player. AI Logic
: Implements movement patterns such as "Chase" (tracking Pac-Man), "Scatter" (moving to a corner), or "Frightened" (running away when a power pellet is eaten).Targeting
: Calculates the shortest path or next best move to reach its target tile.Visuals
: Manages different colors for each ghost (Blinky, Pinky, Inky, Clyde). 