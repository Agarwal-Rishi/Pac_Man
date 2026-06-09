import java.awt.Graphics;
import java.awt.Image;
import java.awt.GraphicsDevice.WindowTranslucency;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

import javax.swing.ImageIcon;

public class Ghosts {
    int ghostWidth = 32;
    int ghostLength = 32;
    int normalGhostSpeed = 3;

    int redGhostX = 448;
    int redGhostY = 416;
    int yellowGhostX = 480;
    int yellowGhostY = 416;
    int blueGhostX = 384;
    int blueGhostY = 416;
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

    int gridRedGhostY;
    int gridRedGhostX;
    int gridPinkGhostY;
    int gridPinkGhostX;
    int gridYellowGhostY;
    int gridYellowGhostX;
    int gridBlueGhostY;
    int gridBlueGhostX;

    Direction currentGhostDirection;

    Direction currentPacmanDirection;

    long firstSwitch;
    long secondSwitch;
    long thirdSwitch;
    long fourthSwitch;
    long fifthSwitch;
    long sixthSwitch;
    long seventhSwitch;

    record Pair<L, R>(L left, R right) {}

    private static final List<Pair<Integer, Integer>> yellowCornerPairs;
    private static final List<Pair<Integer, Integer>> redCornerPairs;
    private static final List<Pair<Integer, Integer>> pinkCornerPairs;
    private static final List<Pair<Integer, Integer>> blueCornerPairs;

    static {
        List<Pair<Integer, Integer>> yellowCoords = new ArrayList<>();
        yellowCoords.add(new Pair<Integer,Integer>(9,20));
        yellowCoords.add(new Pair<Integer,Integer>(8,20));
        yellowCoords.add(new Pair<Integer,Integer>(7,20));
        yellowCoords.add(new Pair<Integer,Integer>(6,20));
        yellowCoords.add(new Pair<Integer,Integer>(5,20));
        yellowCoords.add(new Pair<Integer,Integer>(4,20));
        yellowCoords.add(new Pair<Integer,Integer>(3,20));
        yellowCoords.add(new Pair<Integer,Integer>(2,20));
        yellowCoords.add(new Pair<Integer,Integer>(1,20));
        yellowCoords.add(new Pair<Integer,Integer>(1,21));
        yellowCoords.add(new Pair<Integer,Integer>(1,22));
        yellowCoords.add(new Pair<Integer,Integer>(1,23));
        yellowCoords.add(new Pair<Integer,Integer>(1,24));
        yellowCoords.add(new Pair<Integer,Integer>(1,25));
        yellowCoords.add(new Pair<Integer,Integer>(1,26)); // ★
        yellowCoords.add(new Pair<Integer,Integer>(2,26));
        yellowCoords.add(new Pair<Integer,Integer>(3,26));
        yellowCoords.add(new Pair<Integer,Integer>(4,26));
        yellowCoords.add(new Pair<Integer,Integer>(5,26));
        yellowCoords.add(new Pair<Integer,Integer>(6,26));
        yellowCoords.add(new Pair<Integer,Integer>(7,26));
        yellowCoords.add(new Pair<Integer,Integer>(8,26));
        yellowCoords.add(new Pair<Integer,Integer>(9,26));
        yellowCoords.add(new Pair<Integer,Integer>(9,25));
        yellowCoords.add(new Pair<Integer,Integer>(9,24));
        yellowCoords.add(new Pair<Integer,Integer>(9,23));
        yellowCoords.add(new Pair<Integer,Integer>(9,22));
        yellowCoords.add(new Pair<Integer,Integer>(9,21));
        
        yellowCornerPairs = Collections.unmodifiableList(yellowCoords);
    }

    static {
        List<Pair<Integer, Integer>> redCoords = new ArrayList<>();

        redCoords.add(new Pair<Integer,Integer>(18,7));
        redCoords.add(new Pair<Integer,Integer>(18,6));
        redCoords.add(new Pair<Integer,Integer>(18,5));
        redCoords.add(new Pair<Integer,Integer>(18,4));
        redCoords.add(new Pair<Integer,Integer>(18,3));
        redCoords.add(new Pair<Integer,Integer>(18,2));
        redCoords.add(new Pair<Integer,Integer>(18,1));
        redCoords.add(new Pair<Integer,Integer>(19,1));
        redCoords.add(new Pair<Integer,Integer>(20,1));
        redCoords.add(new Pair<Integer,Integer>(21,1));
        redCoords.add(new Pair<Integer,Integer>(22,1));
        redCoords.add(new Pair<Integer,Integer>(23,1));
        redCoords.add(new Pair<Integer,Integer>(24,1));
        redCoords.add(new Pair<Integer,Integer>(25,1));
        redCoords.add(new Pair<Integer,Integer>(26,1)); // ★
        redCoords.add(new Pair<Integer,Integer>(26,2));
        redCoords.add(new Pair<Integer,Integer>(26,3));
        redCoords.add(new Pair<Integer,Integer>(26,4));
        redCoords.add(new Pair<Integer,Integer>(26,5));
        redCoords.add(new Pair<Integer,Integer>(26,6));
        redCoords.add(new Pair<Integer,Integer>(26,7));
        redCoords.add(new Pair<Integer,Integer>(25,7));
        redCoords.add(new Pair<Integer,Integer>(24,7));
        redCoords.add(new Pair<Integer,Integer>(23,7));
        redCoords.add(new Pair<Integer,Integer>(22,7));
        redCoords.add(new Pair<Integer,Integer>(21,7));
        redCoords.add(new Pair<Integer,Integer>(20,7));
        redCoords.add(new Pair<Integer,Integer>(19,7));

        redCornerPairs = Collections.unmodifiableList(redCoords);
    }

    static{
        List<Pair<Integer, Integer>> pinkCoords = new ArrayList<>();
        pinkCoords.add(new Pair<Integer,Integer>(9,7));
        pinkCoords.add(new Pair<Integer,Integer>(9,6));
        pinkCoords.add(new Pair<Integer,Integer>(9,5));
        pinkCoords.add(new Pair<Integer,Integer>(9,4));
        pinkCoords.add(new Pair<Integer,Integer>(9,3));
        pinkCoords.add(new Pair<Integer,Integer>(9,2));
        pinkCoords.add(new Pair<Integer,Integer>(9,1));
        pinkCoords.add(new Pair<Integer,Integer>(8,1));
        pinkCoords.add(new Pair<Integer,Integer>(7,1));
        pinkCoords.add(new Pair<Integer,Integer>(6,1));
        pinkCoords.add(new Pair<Integer,Integer>(5,1));
        pinkCoords.add(new Pair<Integer,Integer>(4,1));
        pinkCoords.add(new Pair<Integer,Integer>(3,1));
        pinkCoords.add(new Pair<Integer,Integer>(2,1));
        pinkCoords.add(new Pair<Integer,Integer>(1,1)); // ★
        pinkCoords.add(new Pair<Integer,Integer>(1,2));
        pinkCoords.add(new Pair<Integer,Integer>(1,3));
        pinkCoords.add(new Pair<Integer,Integer>(1,4));
        pinkCoords.add(new Pair<Integer,Integer>(1,5));
        pinkCoords.add(new Pair<Integer,Integer>(1,6));
        pinkCoords.add(new Pair<Integer,Integer>(1,7));
        pinkCoords.add(new Pair<Integer,Integer>(2,7));
        pinkCoords.add(new Pair<Integer,Integer>(3,7));
        pinkCoords.add(new Pair<Integer,Integer>(4,7));
        pinkCoords.add(new Pair<Integer,Integer>(5,7));
        pinkCoords.add(new Pair<Integer,Integer>(6,7));
        pinkCoords.add(new Pair<Integer,Integer>(7,7));
        pinkCoords.add(new Pair<Integer,Integer>(8,7));

        pinkCornerPairs = Collections.unmodifiableList(pinkCoords);
    }

    static{
        List<Pair<Integer, Integer>> blueCoords = new ArrayList<>();
        blueCoords.add(new Pair<Integer,Integer>(18,20));
        blueCoords.add(new Pair<Integer,Integer>(18,21));
        blueCoords.add(new Pair<Integer,Integer>(18,22));
        blueCoords.add(new Pair<Integer,Integer>(18,23));
        blueCoords.add(new Pair<Integer,Integer>(18,24));
        blueCoords.add(new Pair<Integer,Integer>(18,25));
        blueCoords.add(new Pair<Integer,Integer>(18,26));
        blueCoords.add(new Pair<Integer,Integer>(19,26));
        blueCoords.add(new Pair<Integer,Integer>(20,26));
        blueCoords.add(new Pair<Integer,Integer>(21,26));
        blueCoords.add(new Pair<Integer,Integer>(22,26));
        blueCoords.add(new Pair<Integer,Integer>(23,26));
        blueCoords.add(new Pair<Integer,Integer>(24,26));
        blueCoords.add(new Pair<Integer,Integer>(25,26));
        blueCoords.add(new Pair<Integer,Integer>(26,26)); // ★
        blueCoords.add(new Pair<Integer,Integer>(26,25));
        blueCoords.add(new Pair<Integer,Integer>(26,24));
        blueCoords.add(new Pair<Integer,Integer>(26,23));
        blueCoords.add(new Pair<Integer,Integer>(26,22));
        blueCoords.add(new Pair<Integer,Integer>(26,21));
        blueCoords.add(new Pair<Integer,Integer>(26,20));
        blueCoords.add(new Pair<Integer,Integer>(25,20));
        blueCoords.add(new Pair<Integer,Integer>(24,20));
        blueCoords.add(new Pair<Integer,Integer>(23,20));
        blueCoords.add(new Pair<Integer,Integer>(22,20));
        blueCoords.add(new Pair<Integer,Integer>(21,20));
        blueCoords.add(new Pair<Integer,Integer>(20,20));
        blueCoords.add(new Pair<Integer,Integer>(19,20));
        blueCornerPairs = Collections.unmodifiableList(blueCoords);
    }

    public Ghosts(ArrayList<ArrayList<Integer>> arr,int pacmanY,int pacmanX,Direction currentPacmanDirection) {
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
        this.currentPacmanDirection = currentPacmanDirection;

        gridBlueGhostX = blueGhostX/32;
        gridBlueGhostY = blueGhostY/32;
        gridPinkGhostX = pinkGhostX/32;
        gridPinkGhostY = pinkGhostY/32;
        gridYellowGhostX = yellowGhostX/32;
        gridYellowGhostY = yellowGhostY/32;
        gridRedGhostX = redGhostX/32;
        gridRedGhostY = redGhostY/32;

        currentGhostDirection = Direction.STOP;

        
    }

    public void ghostAnimate(Direction currentDirection, int gridPacmanX, int gridPacmanY, boolean vulnerableGhosts, boolean gameStarted, int pacmanX, int pacmanY) {
        // System.out.println("ANIMATE");
        currentPacmanDirection = currentDirection;
        if (pacmanX != 416 || pacmanY != 288) {
            this.redGhostScatter();
        //     // System.out.println("LOOP");
        //     firstSwitch = System.currentTimeMillis() + 7000;
        //     secondSwitch = System.currentTimeMillis() + 27000;
        //     thirdSwitch = System.currentTimeMillis() + 34000;
        //     fourthSwitch = System.currentTimeMillis() + 54000;
        //     fifthSwitch = System.currentTimeMillis() + 59000;
        //     sixthSwitch = System.currentTimeMillis() + 79000;
        //     seventhSwitch = System.currentTimeMillis() + 84000;
        //     while(System.currentTimeMillis() <= firstSwitch) {
        //         // this.blueGhostScatter();
        //         this.redGhostScatter();
        //         // this.pinkGhostScatter();
        //         // this.blueGhostScatter();
        //     } 
        //     while( firstSwitch < System.currentTimeMillis() && System.currentTimeMillis() <= secondSwitch) {
        //         // this.blueGhostChaseAlgorithm(currentDirection);
        //         this.redGhostChaseAlgorithm(pacmanX, pacmanY);
        //         // this.pinkGhostChaseAlgorithm();
        //         // this.yellowGhostChaseAlgorithm();
        //     } 
        //     while(fourthSwitch < System.currentTimeMillis() && System.currentTimeMillis() <= fifthSwitch) {
        //         // this.blueGhostScatter();
        //         this.redGhostScatter();
        //         // this.pinkGhostScatter();
        //         // this.yellowGhostScatter();
        //     } 
        //     while(fifthSwitch < System.currentTimeMillis() && System.currentTimeMillis() <= sixthSwitch) {
        //         // this.blueGhostChaseAlgorithm(currentDirection);
        //         this.redGhostChaseAlgorithm(pacmanX, pacmanY);
        //         // this.pinkGhostChaseAlgorithm();
        //         // this.yellowGhostChaseAlgorithm();
        //     } 
        //     while(sixthSwitch < System.currentTimeMillis() && System.currentTimeMillis() <= seventhSwitch) {
        //         // this.blueGhostScatter();
        //         this.redGhostScatter();
        //         // this.pinkGhostScatter();
        //         // this.yellowGhostScatter();
        //     } 
        //     while(System.currentTimeMillis() <= seventhSwitch) {
        //         // this.blueGhostChaseAlgorithm(currentDirection);
        //         // this.yellowGhostChaseAlgorithm();
        //         this.redGhostChaseAlgorithm(pacmanX, pacmanY);
        //         // this.pinkGhostChaseAlgorithm();
        //     }
        }

    }

    public Direction bfs(int startX, int startY, int endX, int endY) {
        // System.out.println(startX);
        // System.out.println(startY);
        // System.out.println(endX);
        // System.out.println(endY);
        // System.out.println("=================");
        // System.out.println("RUNNING BFS");
        HashMap<Pair<Integer, Integer>, Pair<Integer, Integer>> hashmap = new HashMap<>();
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        HashSet<Pair<Integer, Integer>> hashSet = new HashSet<>();
        boolean pacmanFound = false;
        // TO REMEMBER: URGENT
        // dirtomove = bfs(start, end), 
        // take in: start location, end location
        // returb: directiont o move in

        Pair<Integer, Integer> start = new Pair<Integer,Integer>(startX, startY);
        queue.add(start);
        hashmap.put(start, null);
        int[] xdiffs = {-4, 0, 4, 0};
        int[] ydiffs = {0, -4, 0, 4};
            
        while (!queue.isEmpty() && !pacmanFound) {
            Pair<Integer, Integer> cur = queue.poll();
            if (cur.equals(new Pair<Integer,Integer>(endX, endY))) {
                // System.out.println(endX);
                // System.out.println(endY);
                pacmanFound = true;
                // System.out.println("the pacman has been found");
                break;
            }
            if (hashSet.contains(cur)) {
                continue;
            } else{
                hashSet.add(cur);
            }
                
            for (int i = 0; i < 4; i++) {
                // System.out.println("FOR LOOP");
                int diff_x = xdiffs[i]; 
                int diff_y = ydiffs[i];
                int nextX = cur.left() + diff_x;
                int nextY = cur.right() + diff_y;
                Pair<Integer, Integer> nei = new Pair<Integer,Integer>(nextX, nextY);
                
                if (nextX < 0 || nextX >= 896 || nextY < 0 || nextY >= 896 || arr.get(nextY / 32).get(nextX /  32) == 1) {
                    continue;
                }

                int leftCol   = nextX / 32;
                int rightCol  = (nextX + ghostWidth - 1) / 32;
                int topRow    = nextY / 32;
                int bottomRow = (nextY + ghostLength - 1) / 32;

                int squares = (rightCol - leftCol) + (bottomRow - topRow);
                // System.out.println(squares);

                boolean blocked = false;
                for (int r = topRow; r <= bottomRow && !blocked; r++) {
                    for (int c = leftCol; c <= rightCol; c++) {
                        if (arr.get(r).get(c) == 1) {   // 1 == wall
                            blocked = true;
                            break;
                        }
                    }
                }

                if (!blocked && !hashSet.contains(nei)) {
                    queue.add(nei);
                    hashmap.put(nei, cur);
                }

            }
        }

        if (!pacmanFound) {
            // System.out.println("STOP");
            return Direction.STOP;
        } else {
            // System.out.println("BACKTRACK");
            Pair<Integer, Integer> backtrackStart = new Pair<>(endX, endY);

            

            while (!backtrackStart.equals(start)) {
                // System.out.println("HERE");
                Pair<Integer, Integer> previous = hashmap.get(backtrackStart);
                
                if (previous == null) {
                    // System.out.println("ISSUE, STOP");
                    return Direction.STOP;
                }

                if (previous.equals(start)) {
                    // System.out.println("FOUND");
                    if (backtrackStart.left() + 4 == start.left()) {
                        // System.out.println("LEFT");
                        return Direction.LEFT;
                    }
                    if (backtrackStart.right() + 4 == start.right()) {
                        // System.out.println("UP");
                        return Direction.UP;
                    }
                    if (backtrackStart.left() - 4 == start.left()) {
                        // System.out.println("RIGHT");
                        return Direction.RIGHT;
                    }
                    if (backtrackStart.right() - 4 == start.right()) {
                        // System.out.println("DOWN");
                        return Direction.DOWN;
                    }
                }
                backtrackStart = previous;
            }

        }
        return Direction.STOP;

    }

    public void redGhostChaseAlgorithm(int pacmanX, int pacmanY) {
        gridRedGhostY = redGhostY / 32;
        gridRedGhostX = redGhostX / 32;

        // System.out.println("RED GHOST ALG");
        
        Direction direction = this.bfs(redGhostX, redGhostY, pacmanX, pacmanY);
        // System.out.println(direction);
        if (direction == Direction.RIGHT) {
            redGhostX += 4;
        } else if(direction == Direction.LEFT) {
            redGhostX -= 4;
        } else if(direction == Direction.UP) {
            redGhostY -= 4;
        } else if(direction == Direction.DOWN) {
            redGhostY += 4;
        } 
        
    }

    public void pinkGhostChaseAlgorithm() {
        gridPinkGhostY = pinkGhostY / 32;
        gridPinkGhostX = pinkGhostX / 32;
        int gridPacmanY = pacmanY / 32;
        int gridPacmanX = pacmanX / 32;
        int xChange = 0;
        int yChange = 0;
        if (currentPacmanDirection == Direction.RIGHT) {
            xChange = 4;
        } else if (currentPacmanDirection == Direction.LEFT) {
            xChange = -4;
        } else if (currentPacmanDirection == Direction.UP) {
            yChange = -4;
        } else if (currentPacmanDirection == Direction.DOWN) {
            yChange = 4;
        }
        Direction shortenedBFS = this.bfs(gridPinkGhostX, gridPinkGhostY, gridPacmanX + xChange, gridPacmanY + yChange);
        if (shortenedBFS == Direction.RIGHT) {
            pinkGhostX += 4;
        } else if (shortenedBFS == Direction.LEFT) {
            pinkGhostX -= 4;
        } else if(shortenedBFS == Direction.UP) {
            pinkGhostY -= 4;
        } else if (shortenedBFS == Direction.DOWN) {
            pinkGhostY += 4;
        }
        
    }

    public void blueGhostChaseAlgorithm(Direction currentDirection) {
        int gridPacmanY = pacmanY / 32;
        int gridPacmanX = pacmanX / 32;
        gridBlueGhostY = blueGhostY / 32;
        gridBlueGhostX = blueGhostX / 32;
        gridRedGhostX = redGhostX / 32;
        gridRedGhostY = redGhostY / 32;
        
        int xChange = 0;
        int yChange = 0;
        if (currentPacmanDirection == Direction.RIGHT) {
            xChange = 2;
        } else if (currentPacmanDirection == Direction.LEFT) {
            xChange = -2;
        } else if (currentPacmanDirection == Direction.UP) {
            yChange = -2;
        } else if (currentPacmanDirection == Direction.DOWN) {
            yChange = 2;
        }
        
        int targetLocX = gridRedGhostX + 2 * (gridPacmanX + xChange - gridRedGhostX);
        int targetLocY = gridRedGhostY + 2 * (gridPacmanY + yChange - gridRedGhostY);
        Direction shortenedBFS = this.bfs(gridPinkGhostX, gridPinkGhostY, targetLocX, targetLocY + yChange);
        if (shortenedBFS == Direction.RIGHT) {
            gridBlueGhostX += 4;
        } else if (shortenedBFS == Direction.LEFT) {
            gridBlueGhostX -= 4;
        } else if(shortenedBFS == Direction.UP) {
            gridBlueGhostY -= 4;
        } else if (shortenedBFS == Direction.DOWN) {
            gridBlueGhostY += 4;
        }
    }

    public void yellowGhostChaseAlgorithm() {
        int gridPacmanY = pacmanY / 32;
        int gridPacmanX = pacmanX / 32;
        gridYellowGhostY = yellowGhostY / 32;
        gridYellowGhostX = yellowGhostX / 32;
        if (Math.abs(gridPacmanX + gridPacmanY - gridYellowGhostX + gridYellowGhostY) != 8) {
            if (this.bfs(gridYellowGhostX, gridYellowGhostY, gridPacmanX, gridPacmanY) == Direction.RIGHT) {
                redGhostX += 4;
            } else if(this.bfs(gridYellowGhostX, gridYellowGhostY, gridPacmanX, gridPacmanY) == Direction.LEFT) {
                yellowGhostX -= 4;
            } else if(this.bfs(gridYellowGhostX, gridYellowGhostY, gridPacmanX, gridPacmanY) == Direction.UP) {
                yellowGhostY -= 4;
            } else if(this.bfs(gridYellowGhostX, gridYellowGhostY, gridPacmanX, gridPacmanY) == Direction.DOWN) {
                yellowGhostY += 4;
            }
        } else {
            for(int i = 0;i < yellowCornerPairs.size();i++) {
                Pair<Integer, Integer> futurePair = yellowCornerPairs.get(i + 1);
                gridYellowGhostX = futurePair.left();
                gridYellowGhostY = futurePair.right();
                if (futurePair == null) {
                    futurePair = yellowCornerPairs.get(0);
                }
            }
        }
    }


    public void yellowGhostScatter() {
        gridYellowGhostY = yellowGhostY / 32;
        gridYellowGhostX = yellowGhostX / 32;
        int targetYellowGhostLocationX = 288;
        int targetYellowGhostLocationY  = 640;
        Direction shortenedBFS = this.bfs(yellowGhostX, yellowGhostY, targetYellowGhostLocationX, targetYellowGhostLocationY);
        if (this.bfs(yellowGhostX, yellowGhostY, targetYellowGhostLocationX, targetYellowGhostLocationY) == Direction.RIGHT) {
            yellowGhostX += 4;
        } else if(this.bfs(yellowGhostX, yellowGhostY, targetYellowGhostLocationX, targetYellowGhostLocationY) == Direction.LEFT) {
            yellowGhostX -= 4;
        } else if(this.bfs(yellowGhostX, yellowGhostY, targetYellowGhostLocationX, targetYellowGhostLocationY) == Direction.UP) {
            yellowGhostY -= 4;
        } else if(this.bfs(yellowGhostX, yellowGhostY, targetYellowGhostLocationX, targetYellowGhostLocationY) == Direction.DOWN) {
            yellowGhostY += 4;
        } 
        
        for (int i = 0;i < yellowCornerPairs.size();i++) {
            if (i != 27) {
                Pair<Integer, Integer> futurePair = yellowCornerPairs.get(i + 1);
                gridYellowGhostX = futurePair.left();
                gridYellowGhostY = futurePair.right();
            } else {
                Pair<Integer, Integer> futurePair = yellowCornerPairs.get(0);
                gridYellowGhostX = futurePair.left();  
                gridYellowGhostY = futurePair.right();
            }
            
        }
        
    }


    public void blueGhostScatter() {
        int targetBlueGhostLocationX = 576;
        int targetBlueGhostLocationY = 640;
        // System.out.println(this.bfs(gridRedGhostX, gridRedGhostY, targetBlueGhostLocationX, targetBlueGhostLocationY));
        if (this.bfs(blueGhostX, blueGhostY, targetBlueGhostLocationX, targetBlueGhostLocationY) == Direction.RIGHT) {
            blueGhostX += 4;
        } else if(this.bfs(blueGhostX, blueGhostY, targetBlueGhostLocationX, targetBlueGhostLocationY) == Direction.LEFT) {
            blueGhostX -= 4;
        } else if(this.bfs(blueGhostX, blueGhostY, targetBlueGhostLocationX, targetBlueGhostLocationY) == Direction.UP) {
            blueGhostY -= 4;
        } else if(this.bfs(blueGhostX, blueGhostY, targetBlueGhostLocationX, targetBlueGhostLocationY) == Direction.DOWN) {
            blueGhostY += 4;
        } 
        
        for (int i = 0;i < blueCornerPairs.size();i++) {
            if (i!= 27) {
                Pair<Integer, Integer> futurePair = blueCornerPairs.get(i + 1);
                gridBlueGhostX = futurePair.left();
                gridBlueGhostY = futurePair.right();
            } else {
                Pair<Integer, Integer> futurePair = blueCornerPairs.get(0);
                gridBlueGhostX = futurePair.left();  
                gridBlueGhostY = futurePair.right();
            }
            
        }
    }

    public void redGhostScatter() {
        int redPatrolIndex = 0;
        int targetRedGhostLocationX = 576;
        int targetRedGhostLocationY = 224;
        // System.out.println("red ghost");
        // System.out.println(arr.get(targetRedGhostLocationY / 32).get(targetRedGhostLocationX / 32));
        // redCornerPairs relys on start location where call bfs to. But its a wall so we need to have claude or codex redo the corner pairs
        if (redCornerPairs.contains(new Pair<Integer,Integer>(gridRedGhostX, gridRedGhostY))) {
            int nextIndex = (redPatrolIndex + 1) % redCornerPairs.size();
            Pair<Integer, Integer> next = redCornerPairs.get(nextIndex);
            Direction shortenedBFS = this.bfs(redGhostX, redGhostY, next.left(), next.right());
            if (shortenedBFS == Direction.RIGHT) {
                redGhostX += 4;
            } else if(shortenedBFS == Direction.LEFT) {
                redGhostX -= 4;
            } else if(shortenedBFS == Direction.UP) {
                redGhostY -= 4;
            } else if(shortenedBFS == Direction.DOWN) {
                redGhostY += 4;
            }
            
        } else {
            Direction shortenedBFS2 = this.bfs(redGhostX, redGhostY, targetRedGhostLocationX, targetRedGhostLocationY);
            if (shortenedBFS2 == Direction.RIGHT) {
                redGhostX += 4;
            } else if(shortenedBFS2 == Direction.LEFT) {
                redGhostX -= 4;
            } else if(shortenedBFS2 == Direction.UP) {
                redGhostY -= 4;
            } else if(shortenedBFS2 == Direction.DOWN) {
                redGhostY += 4;
            }
        } 

        
        // for (int i = 0;i < redCornerPairs.size();i++) {
        //     Pair<Integer, Integer> futurePair;
        //     if (i != 27) {
        //         futurePair = redCornerPairs.get(i + 1);
        //         if (futurePair.left() > redGhostX) {
        //             redGhostX += 4;
        //         } else if(futurePair.left() < redGhostX) {
        //             redGhostX -= 4;
        //         } else if(futurePair.right() > redGhostY) {
        //             redGhostY -= 4;
        //         } else if(futurePair.right() < redGhostY) {
        //             redGhostY += 4;
        //         }
        //     } else {
        //         futurePair = redCornerPairs.get(0);
        //         if (futurePair.left() > redGhostX) {
        //             redGhostX += 4;
        //         } else if(futurePair.left() < redGhostX) {
        //             redGhostX -= 4;
        //         } else if(futurePair.right() > redGhostY) {
        //             redGhostY -= 4;
        //         } else if(futurePair.right() < redGhostY) {
        //             redGhostY += 4;
        //         }
        //     }
            
        // }
    }

    public void pinkGhostScatter() {
        int targetPinkGhostLocationX = 288;
        int targetPinkGhostLocationY = 224;

        if (this.bfs(pinkGhostX, pinkGhostY, targetPinkGhostLocationX, targetPinkGhostLocationY) == Direction.RIGHT) {
            pinkGhostX += 4;
        } else if(this.bfs(pinkGhostX, pinkGhostY, targetPinkGhostLocationX, targetPinkGhostLocationY) == Direction.LEFT) {
            pinkGhostX -= 4;
        } else if(this.bfs(pinkGhostX, pinkGhostY, targetPinkGhostLocationX, targetPinkGhostLocationY) == Direction.UP) {
            pinkGhostY -= 4;
        } else if(this.bfs(pinkGhostX, pinkGhostY, targetPinkGhostLocationX, targetPinkGhostLocationY) == Direction.DOWN) {
            pinkGhostY += 4;
        } 

        for (int i = 0;i < pinkCornerPairs.size();i++) {
            if (i != 27) {
                Pair<Integer, Integer> futurePair = pinkCornerPairs.get(i + 1);
                if (futurePair.left() > pinkGhostX) {
                    pinkGhostX += 4;
                } else if(futurePair.left() < pinkGhostX) {
                    pinkGhostX -= 4;
                } else if(futurePair.right() > pinkGhostY) {
                    pinkGhostY -= 4;
                } else if(futurePair.right() < pinkGhostY) {
                    pinkGhostY += 4;
                }
            } else {
                Pair<Integer, Integer> futurePair = pinkCornerPairs.get(0);
                if (futurePair.left() > pinkGhostX) {
                    pinkGhostX += 4;
                } else if(futurePair.left() < pinkGhostX) {
                    pinkGhostX -= 4;
                } else if(futurePair.right() > pinkGhostY) {
                    pinkGhostY -= 4;
                } else if(futurePair.right() < pinkGhostY) {
                    pinkGhostY += 4;
                }
            }
            
        }
    }

    public void paintComponent(Graphics graphics, boolean ghostsVulnerable, long timerEnd1, long timerEnd2) {
        if (ghostsVulnerable == true) {
            if (System.currentTimeMillis() < timerEnd1)  {
                graphics.drawImage(scaledBluePhaseScaredGhost, blueGhostX, blueGhostY, null);
                graphics.drawImage(scaledBluePhaseScaredGhost, redGhostX, redGhostY, null);
                graphics.drawImage(scaledBluePhaseScaredGhost, yellowGhostX, yellowGhostY, null);
                graphics.drawImage(scaledBluePhaseScaredGhost, pinkGhostX, pinkGhostY, null);
            } else {
                Image[] flashArrayImages = {scaledBluePhaseScaredGhost, scaledWhitePhaseScaredGhost};
                for(int i = 0;i < flashArrayImages.length;i++) {
                    graphics.drawImage(flashArrayImages[i], blueGhostX, blueGhostY, null);
                    graphics.drawImage(flashArrayImages[i], redGhostX, redGhostY, null);
                    graphics.drawImage(flashArrayImages[i], yellowGhostX, yellowGhostY, null);
                    graphics.drawImage(flashArrayImages[i], pinkGhostX, pinkGhostY, null);
                }
            }
        } else{
            graphics.drawImage(scaledBlueGhostUp, blueGhostX, blueGhostY, null);
            graphics.drawImage(scaledRedGhostUp, redGhostX, redGhostY, null);
            graphics.drawImage(scaledYellowGhostUp, yellowGhostX, yellowGhostY, null);
            graphics.drawImage(scaledPinkGhostUp, pinkGhostX, pinkGhostY, null);
        }

    }  

    public int getGridRedGhostX() {
        return this.gridRedGhostX;
    }

    public int getGridRedGhostY() {
        return this.gridRedGhostY;
    }

    public int getGridPinkGhostX() {
        return this.gridPinkGhostX;
    }

    public int getGridPinkGhostY() {
        return this.gridPinkGhostY;
    }
    
    public int getGridYellowGhostX() {
        return this.gridYellowGhostX;
    }

    public int getGridYellowGhostY() {
        return this.gridYellowGhostY;
    }
    
    public int getGridBlueGhostX() {
        return this.gridBlueGhostX;
    }

    public int getGridBlueGhostY() {
        return this.gridBlueGhostY;
    }

}
