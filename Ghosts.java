import java.awt.Graphics;
import java.awt.Image;
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
    int ghostWidth = 28;
    int ghostLength = 28;
    int normalGhostSpeed = 4;

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
        yellowCoords.add(new Pair<Integer,Integer>(2,21));
        yellowCoords.add(new Pair<Integer,Integer>(3,21));
        yellowCoords.add(new Pair<Integer,Integer>(4,21));
        yellowCoords.add(new Pair<Integer,Integer>(5,21));
        yellowCoords.add(new Pair<Integer,Integer>(6,21));
        yellowCoords.add(new Pair<Integer,Integer>(7,21));
        yellowCoords.add(new Pair<Integer,Integer>(8,21));
        yellowCoords.add(new Pair<Integer,Integer>(9,21));
        yellowCoords.add(new Pair<Integer,Integer>(10,21));
        yellowCoords.add(new Pair<Integer,Integer>(10,22));
        yellowCoords.add(new Pair<Integer,Integer>(10,23));
        yellowCoords.add(new Pair<Integer,Integer>(10,24));
        yellowCoords.add(new Pair<Integer,Integer>(10,25));
        yellowCoords.add(new Pair<Integer,Integer>(10,26));
        yellowCoords.add(new Pair<Integer,Integer>(10,27));
        yellowCoords.add(new Pair<Integer,Integer>(9,27));
        yellowCoords.add(new Pair<Integer,Integer>(8,27));
        yellowCoords.add(new Pair<Integer,Integer>(7,27));
        yellowCoords.add(new Pair<Integer,Integer>(6,27));
        yellowCoords.add(new Pair<Integer,Integer>(5,27));
        yellowCoords.add(new Pair<Integer,Integer>(4,27));
        yellowCoords.add(new Pair<Integer,Integer>(3,27));
        yellowCoords.add(new Pair<Integer,Integer>(2,27));
        yellowCoords.add(new Pair<Integer,Integer>(2,26));
        yellowCoords.add(new Pair<Integer,Integer>(2,25));
        yellowCoords.add(new Pair<Integer,Integer>(2,24));
        yellowCoords.add(new Pair<Integer,Integer>(2,23));
        yellowCoords.add(new Pair<Integer,Integer>(2,22));
        
        yellowCornerPairs = Collections.unmodifiableList(yellowCoords);
    }

    static {
        List<Pair<Integer, Integer>> redCoords = new ArrayList<>();

        redCoords.add(new Pair<Integer,Integer>(19,2));
        redCoords.add(new Pair<Integer,Integer>(20,2));
        redCoords.add(new Pair<Integer,Integer>(21,2));
        redCoords.add(new Pair<Integer,Integer>(22,2));
        redCoords.add(new Pair<Integer,Integer>(23,2));
        redCoords.add(new Pair<Integer,Integer>(24,2));
        redCoords.add(new Pair<Integer,Integer>(25,2));
        redCoords.add(new Pair<Integer,Integer>(26,2));
        redCoords.add(new Pair<Integer,Integer>(27,2));
        redCoords.add(new Pair<Integer,Integer>(27,3));
        redCoords.add(new Pair<Integer,Integer>(27,4));
        redCoords.add(new Pair<Integer,Integer>(27,5));
        redCoords.add(new Pair<Integer,Integer>(27,6));
        redCoords.add(new Pair<Integer,Integer>(27,7));
        redCoords.add(new Pair<Integer,Integer>(27,8));
        redCoords.add(new Pair<Integer,Integer>(26,8));
        redCoords.add(new Pair<Integer,Integer>(25,8));
        redCoords.add(new Pair<Integer,Integer>(24,8));
        redCoords.add(new Pair<Integer,Integer>(23,8));
        redCoords.add(new Pair<Integer,Integer>(22,8));
        redCoords.add(new Pair<Integer,Integer>(21,8));
        redCoords.add(new Pair<Integer,Integer>(20,8));
        redCoords.add(new Pair<Integer,Integer>(19,8));
        redCoords.add(new Pair<Integer,Integer>(19,7));
        redCoords.add(new Pair<Integer,Integer>(19,6));
        redCoords.add(new Pair<Integer,Integer>(19,5));
        redCoords.add(new Pair<Integer,Integer>(19,4));
        redCoords.add(new Pair<Integer,Integer>(19,3));

        redCornerPairs = Collections.unmodifiableList(redCoords);
    }

    static{
        List<Pair<Integer, Integer>> pinkCoords = new ArrayList<>();
        pinkCoords.add(new Pair<Integer,Integer>(2,2));
        pinkCoords.add(new Pair<Integer,Integer>(3,2));
        pinkCoords.add(new Pair<Integer,Integer>(4,2));
        pinkCoords.add(new Pair<Integer,Integer>(5,2));
        pinkCoords.add(new Pair<Integer,Integer>(6,2));
        pinkCoords.add(new Pair<Integer,Integer>(7,2));
        pinkCoords.add(new Pair<Integer,Integer>(8,2));
        pinkCoords.add(new Pair<Integer,Integer>(9,2));
        pinkCoords.add(new Pair<Integer,Integer>(10,2));
        pinkCoords.add(new Pair<Integer,Integer>(10,3));
        pinkCoords.add(new Pair<Integer,Integer>(10,4));
        pinkCoords.add(new Pair<Integer,Integer>(10,5));
        pinkCoords.add(new Pair<Integer,Integer>(10,6));
        pinkCoords.add(new Pair<Integer,Integer>(10,7));
        pinkCoords.add(new Pair<Integer,Integer>(10,8));
        pinkCoords.add(new Pair<Integer,Integer>(9,8));
        pinkCoords.add(new Pair<Integer,Integer>(8,8));
        pinkCoords.add(new Pair<Integer,Integer>(7,8));
        pinkCoords.add(new Pair<Integer,Integer>(6,8));
        pinkCoords.add(new Pair<Integer,Integer>(5,8));
        pinkCoords.add(new Pair<Integer,Integer>(4,8));
        pinkCoords.add(new Pair<Integer,Integer>(3,8));
        pinkCoords.add(new Pair<Integer,Integer>(2,8));
        pinkCoords.add(new Pair<Integer,Integer>(2,7));
        pinkCoords.add(new Pair<Integer,Integer>(2,6));
        pinkCoords.add(new Pair<Integer,Integer>(2,5));
        pinkCoords.add(new Pair<Integer,Integer>(2,4));
        pinkCoords.add(new Pair<Integer,Integer>(2,3));
        pinkCornerPairs = Collections.unmodifiableList(pinkCoords);
    }

    static{
        List<Pair<Integer, Integer>> blueCoords = new ArrayList<>();
        blueCoords.add(new Pair<Integer,Integer>(19,21));
        blueCoords.add(new Pair<Integer,Integer>(20,21));
        blueCoords.add(new Pair<Integer,Integer>(21,21));
        blueCoords.add(new Pair<Integer,Integer>(22,21));
        blueCoords.add(new Pair<Integer,Integer>(23,21));
        blueCoords.add(new Pair<Integer,Integer>(24,21));
        blueCoords.add(new Pair<Integer,Integer>(25,21));
        blueCoords.add(new Pair<Integer,Integer>(26,21));
        blueCoords.add(new Pair<Integer,Integer>(27,21));
        blueCoords.add(new Pair<Integer,Integer>(27,22));
        blueCoords.add(new Pair<Integer,Integer>(27,23));
        blueCoords.add(new Pair<Integer,Integer>(27,24));
        blueCoords.add(new Pair<Integer,Integer>(27,25));
        blueCoords.add(new Pair<Integer,Integer>(27,26));
        blueCoords.add(new Pair<Integer,Integer>(27,27));
        blueCoords.add(new Pair<Integer,Integer>(26,27));
        blueCoords.add(new Pair<Integer,Integer>(25,27));
        blueCoords.add(new Pair<Integer,Integer>(24,27));
        blueCoords.add(new Pair<Integer,Integer>(23,27));
        blueCoords.add(new Pair<Integer,Integer>(22,27));
        blueCoords.add(new Pair<Integer,Integer>(21,27));
        blueCoords.add(new Pair<Integer,Integer>(20,27));
        blueCoords.add(new Pair<Integer,Integer>(19,27));
        blueCoords.add(new Pair<Integer,Integer>(19,26));
        blueCoords.add(new Pair<Integer,Integer>(19,25));
        blueCoords.add(new Pair<Integer,Integer>(19,24));
        blueCoords.add(new Pair<Integer,Integer>(19,23));
        blueCoords.add(new Pair<Integer,Integer>(19,22));
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

    public void ghostAnimate(Direction currentDirection, int gridPacmanX, int gridPacmanY, boolean vulnerableGhosts, boolean gameStarted) {
        currentPacmanDirection = currentDirection;
        if (gameStarted) {
            this.redGhostChaseAlgorithm(gridPacmanX, gridPacmanY);
        }

    }

    public Direction bfs(int startX, int startY, int endX, int endY) {
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
        int[] xdiffs = {-1, 0, 1, 0};
        int[] ydiffs = {0, -1, 0, 1};
            
        while (!queue.isEmpty() && !pacmanFound) {
            Pair<Integer, Integer> cur = queue.poll();
            if (cur.equals(new Pair<Integer,Integer>(endX, endY))) {
                pacmanFound = true;
                break;
            }
            if (hashSet.contains(cur)) {
                continue;
            } else{
                hashSet.add(cur);
            }
                
            for (int i = 0; i < 4; i++) {
                int diff_x = xdiffs[i]; 
                int diff_y = ydiffs[i];
                int nextX = cur.left() + diff_x;
                int nextY = cur.right() + diff_y;
                Pair<Integer, Integer> nei = new Pair<Integer,Integer>(nextX, nextY);
                if (nextX > 0 && nextX < 27 && nextY > 0 && nextY < 27 && arr.get(nextY).get(nextX) != 1 && !hashSet.contains(nei) && !hashmap.containsKey(nei)) {
                    queue.add(nei);
                    hashmap.put(nei, cur);
                }
            }
        }

        if (!pacmanFound) {
            return Direction.STOP;
        } else {
            Pair<Integer, Integer> backtrackStart = new Pair<>(endX, endY);
            while (!backtrackStart.equals(start)) {
                Pair<Integer, Integer> previous = hashmap.get(backtrackStart);
                if (previous == null) {
                    return Direction.STOP;
                }
                backtrackStart = previous;
                int startDiff = Math.abs((backtrackStart.left() + backtrackStart.right()) - (start.left() + start.right()));
                if (startDiff == 1) {
                    if (start.right() == backtrackStart.right() + 1) {
                        return Direction.UP;
                    }
                    if (start.right() == backtrackStart.right() - 1) {
                        return Direction.DOWN;
                    }
                    if (start.left() == backtrackStart.left() + 1) {
                        return Direction.LEFT;
                    }
                    if (start.left() == backtrackStart.left() - 1) {
                        return Direction.RIGHT;
                    }
                } else{
                    continue;
                }
            }

        }
        return Direction.STOP;

    }

    public void redGhostChaseAlgorithm(int gridPacmanX, int gridPacmanY) {
        gridRedGhostY = redGhostY / 32;
        gridRedGhostX = redGhostX / 32;
        
        if (redGhostX % 32 == 0 && redGhostY % 32 == 0) {
            Direction direction = this.bfs(gridRedGhostX, gridRedGhostY, gridPacmanX, gridPacmanY);
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
        int targetYellowGhostLocationX = 2;
        int targetYellowGhostLocationY  = 21;
        Direction shortenedBFS = this.bfs(gridYellowGhostX, gridYellowGhostY, targetYellowGhostLocationX, targetYellowGhostLocationY);
        if (this.bfs(gridYellowGhostX, gridYellowGhostY, targetYellowGhostLocationX, targetYellowGhostLocationY) == Direction.RIGHT) {
            redGhostX += 4;
        } else if(this.bfs(gridYellowGhostX, gridYellowGhostY, targetYellowGhostLocationX, targetYellowGhostLocationY) == Direction.LEFT) {
            yellowGhostX -= 4;
        } else if(this.bfs(gridYellowGhostX, gridYellowGhostY, targetYellowGhostLocationX, targetYellowGhostLocationY) == Direction.UP) {
            yellowGhostY -= 4;
        } else if(this.bfs(gridYellowGhostX, gridYellowGhostY, targetYellowGhostLocationX, targetYellowGhostLocationY) == Direction.DOWN) {
            yellowGhostY += 4;
        } 
        
        for(int i = 0;i < yellowCornerPairs.size();i++) {
            Pair<Integer, Integer> futurePair = yellowCornerPairs.get(i + 1);
            gridYellowGhostX = futurePair.left();                gridYellowGhostY = futurePair.right();
            if (futurePair == null) {
                futurePair = yellowCornerPairs.get(0);
            }
        }
        
    }


    public void blueGhostScatter() {
        int targetBlueGhostLocationX = 19;
        int targetBlueGhostLocationY = 21;

        if (this.bfs(gridRedGhostX, gridRedGhostY, targetBlueGhostLocationX, targetBlueGhostLocationY) == Direction.RIGHT) {
            blueGhostX += 4;
        } else if(this.bfs(gridRedGhostX, gridRedGhostY, targetBlueGhostLocationX, targetBlueGhostLocationY) == Direction.LEFT) {
            blueGhostX -= 4;
        } else if(this.bfs(gridRedGhostX, gridRedGhostY, targetBlueGhostLocationX, targetBlueGhostLocationY) == Direction.UP) {
            blueGhostY -= 4;
        } else if(this.bfs(gridRedGhostX, gridRedGhostY, targetBlueGhostLocationX, targetBlueGhostLocationY) == Direction.DOWN) {
            blueGhostY += 4;
        } 
        
        for(int i = 0;i < blueCornerPairs.size();i++) {
            Pair<Integer, Integer> futurePair = blueCornerPairs.get(i + 1);
            gridBlueGhostX = futurePair.left();
            gridBlueGhostY = futurePair.right();
            if (futurePair == null) {
                futurePair = blueCornerPairs.get(0);
            }
        }
    }

    public void redGhostScatter() {
        int targetRedGhostLocationX = 19;
        int targetRedGhostLocationY = 2;

        if (this.bfs(gridRedGhostX, gridRedGhostY, targetRedGhostLocationX, targetRedGhostLocationY) == Direction.RIGHT) {
            redGhostX += 4;
        } else if(this.bfs(gridRedGhostX, gridRedGhostY, targetRedGhostLocationX, targetRedGhostLocationY) == Direction.LEFT) {
            redGhostX -= 4;
        } else if(this.bfs(gridRedGhostX, gridRedGhostY, targetRedGhostLocationX, targetRedGhostLocationY) == Direction.UP) {
            redGhostY -= 4;
        } else if(this.bfs(gridRedGhostX, gridRedGhostY, targetRedGhostLocationX, targetRedGhostLocationY) == Direction.DOWN) {
            redGhostY += 4;
        } 

        
        for (int i = 0;i < redCornerPairs.size();i++) {
            Pair<Integer, Integer> futurePair = redCornerPairs.get(i + 1);
            gridRedGhostX = futurePair.left();
            gridRedGhostY = futurePair.right();
            if (futurePair == null) {
                futurePair = redCornerPairs.get(0);
            }
        }
    }

    public void pinkGhostScatter() {
        int targetPinkGhostLocationX = 2;
        int targetPinkGhostLocationY = 2;

        if (this.bfs(gridRedGhostX, gridRedGhostY, targetPinkGhostLocationX, targetPinkGhostLocationY) == Direction.RIGHT) {
            pinkGhostX += 4;
        } else if(this.bfs(gridRedGhostX, gridRedGhostY, targetPinkGhostLocationX, targetPinkGhostLocationY) == Direction.LEFT) {
            pinkGhostX -= 4;
        } else if(this.bfs(gridRedGhostX, gridRedGhostY, targetPinkGhostLocationX, targetPinkGhostLocationY) == Direction.UP) {
            pinkGhostY -= 4;
        } else if(this.bfs(gridRedGhostX, gridRedGhostY, targetPinkGhostLocationX, targetPinkGhostLocationY) == Direction.DOWN) {
            pinkGhostY += 4;
        } 

        for(int i = 0; i < pinkCornerPairs.size(); i++) {
            Pair<Integer, Integer> futurePair = pinkCornerPairs.get((i + 1) % pinkCornerPairs.size());
            gridPinkGhostX = futurePair.left();
            gridPinkGhostY = futurePair.right();
            if (futurePair == null) {
                futurePair = pinkCornerPairs.get(0);
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
