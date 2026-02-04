import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Ghosts {
    int ghostWidth = 28;
    int ghostLength = 28;

    int redGhostX = 470;
    int redGhostY = 470;
    int yellowGhostX = 450;
    int yellowGhostY = 450;
    int blueGhostX = 430;
    int blueGhostY = 430;
    int pinkGhostX = 416;
    int pinkGhostY = 416;

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

    ArrayList<ArrayList<Integer>> arr;

    int pacmanY;
    int pacmanX;

    
    public Ghosts(ArrayList<ArrayList<Integer>> arr,int pacmanY,int pacmanX) {
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

        this.arr = arr;

        this.pacmanX = pacmanX;
        this.pacmanY = pacmanY;
    }

    





}
