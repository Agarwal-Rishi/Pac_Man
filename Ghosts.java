import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.ImageIcon;

public class Ghosts {
    int ghostWidth = 28;
    int ghostLength = 28;

    int redGhostX = 480;
    int redGhostY = 480;
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

    public void ghostAnimate(Direction currentDirection, int gridPacmanX, int gridPacmanY, boolean vulnerableGhosts) {
        this.blueGhostChaseAlgorithm(currentDirection);
        while (true) {
            this.paintComponent(null, false, gridPacmanX, gridPacmanY);
        }
    }

    public void redGhostChaseAlgorithm() {
        gridRedGhostY = redGhostY / 32;
        gridRedGhostX = redGhostX / 32;
        int gridPacmanX = pacmanX / 32;
        int gridPacmanY = pacmanY / 32;
        if (gridPacmanY < gridRedGhostY) {
            currentGhostDirection = Direction.UP;
            if (arr.get(gridRedGhostY - 1).get(gridRedGhostX) == 1) {
                currentGhostDirection = Direction.STOP;                     
            }else if(currentGhostDirection == Direction.UP && this.arr.get(gridRedGhostY - 1).get(gridRedGhostX) != 1) {
                if (pacmanX % 32 != 0) {
                    if (arr.get(gridRedGhostY - 1).get(gridRedGhostX + 1) == 1) {
                        currentGhostDirection = Direction.STOP;
                    }else {
                        redGhostY -= 4;
                    }
                } else {
                    redGhostY -= 4;
                }
            }
        } else if(gridPacmanY > gridRedGhostY) {
            currentGhostDirection = Direction.DOWN;
            if (currentGhostDirection == Direction.DOWN && this.arr.get(gridRedGhostY + 1).get(gridRedGhostX) == 1) {
                currentGhostDirection = Direction.STOP;
            } else if(currentGhostDirection == Direction.DOWN && this.arr.get(gridRedGhostY + 1).get(gridRedGhostX) != 1) {
                if (pacmanX % 32 != 0) {
                    if (arr.get(gridRedGhostY + 1).get(gridRedGhostX + 1) == 1) {
                        currentGhostDirection = Direction.STOP;
                    }else {
                        redGhostY += 4;
                    }
                } else {
                    redGhostY += 4;
                }
            }
        } else if(gridPacmanX > gridRedGhostX) {
            currentGhostDirection = Direction.RIGHT;
            if (currentGhostDirection == Direction.RIGHT && this.arr.get(gridRedGhostY).get(gridRedGhostX + 1) == 1) {
                currentGhostDirection = Direction.STOP;
            } else if(currentGhostDirection == Direction.RIGHT && this.arr.get(gridRedGhostY).get(gridRedGhostX + 1) != 1) {
                if (pacmanY % 32 != 0) {
                    if (arr.get(gridRedGhostY + 1).get(gridRedGhostX + 1) == 1) {
                        currentGhostDirection = Direction.STOP;
                    }else {
                        redGhostX += 4;
                    }
                } else {
                    redGhostX += 4;
                }
            }
        } else if(gridPacmanX < gridRedGhostX) {
            currentGhostDirection = Direction.LEFT;
            if (currentGhostDirection == Direction.LEFT && this.arr.get(gridRedGhostY).get(gridRedGhostX - 1) == 1) {
                currentGhostDirection = Direction.STOP;
            } else if(currentGhostDirection == Direction.LEFT && this.arr.get(gridRedGhostY).get(gridRedGhostX - 1) != 1) {
                if (pacmanY % 32 != 0) {
                    if (arr.get(gridRedGhostY + 1).get(gridRedGhostX - 1) == 1) {
                        currentGhostDirection = Direction.STOP;
                    }else {
                        redGhostX -= 4;
                    }
                } else {
                    redGhostX -= 4;
                }
            }
        }
         
    }


    public void pinkGhostChaseAlgorithm() {
        gridPinkGhostY = pinkGhostY / 32;
        gridPinkGhostX = pinkGhostX / 32;
        int gridPacmanY = pacmanY / 32;
        int gridPacmanX = pacmanX / 32;
        if (gridPacmanY - 4 < gridPinkGhostY) {
            currentGhostDirection = Direction.UP;
            if (currentGhostDirection == Direction.UP && this.arr.get(gridPinkGhostY - 1).get(gridPinkGhostX) == 1) {
                currentGhostDirection = Direction.STOP;
            } else if(currentGhostDirection == Direction.UP && this.arr.get(gridPinkGhostY - 1).get(gridPinkGhostX) != 1) {
                if (pacmanX % 32 != 0) {
                    if (arr.get(gridPinkGhostY - 1).get(gridPinkGhostX + 1) == 1) {
                        currentGhostDirection = Direction.STOP;
                    }else {
                        pinkGhostY -= 4;
                    }
                } else {
                    pinkGhostY -= 4;
                }
            }
        } else if(gridPacmanY + 4 > gridPinkGhostY) {
            currentGhostDirection = Direction.DOWN;
            if (currentGhostDirection == Direction.DOWN && this.arr.get(gridPinkGhostY + 1).get(gridPinkGhostX) == 1) {
                currentGhostDirection = Direction.STOP;
            } else if(currentGhostDirection == Direction.DOWN && this.arr.get(gridPinkGhostY + 1).get(gridPinkGhostX) != 1) {
                if (pacmanX % 32 != 0) {
                    if (arr.get(gridPinkGhostY + 1).get(gridPinkGhostX + 1) == 1) {
                        currentGhostDirection = Direction.STOP;
                    }else {
                        pinkGhostY += 4;
                    }
                } else {
                    pinkGhostY += 4;
                }
            }
        } else if(gridPacmanX + 4 > gridPinkGhostX) {
            currentGhostDirection = Direction.RIGHT;
            if (currentGhostDirection == Direction.RIGHT && this.arr.get(gridPinkGhostY).get(gridPinkGhostX + 1) == 1) {
                currentGhostDirection = Direction.STOP;
            } else if(currentGhostDirection == Direction.RIGHT && this.arr.get(gridPinkGhostY).get(gridPinkGhostX + 1) != 1) {
                if (pacmanY % 32 != 0) {
                    if (arr.get(gridPinkGhostY + 1).get(gridPinkGhostX + 1) == 1) {
                        currentGhostDirection = Direction.STOP;
                    }else {
                        pinkGhostX += 4;
                    }
                } else {
                    pinkGhostX += 4;
                }
            }
        } else if(gridPacmanX - 4 < gridPinkGhostX) {
            currentGhostDirection = Direction.LEFT;
            if (currentGhostDirection == Direction.LEFT && this.arr.get(gridPinkGhostY).get(gridPinkGhostX - 1) == 1) {
                currentGhostDirection = Direction.STOP;
            } else if(currentGhostDirection == Direction.LEFT && this.arr.get(gridPinkGhostY).get(gridPinkGhostX - 1) != 1) {
                if (pacmanY % 32 != 0) {
                    if (arr.get(gridPinkGhostY + 1).get(gridPinkGhostX - 1) == 1) {
                        currentGhostDirection = Direction.STOP;
                    }else {
                        pinkGhostX -= 4;
                    }
                } else {
                    pinkGhostX -= 4;
                }
            }
        }
    }

    public void blueGhostChaseAlgorithm(Direction currentDirection) {
        int gridPacmanY = pacmanY / 32;
        int gridPacmanX = pacmanX / 32;
        gridBlueGhostY = blueGhostY / 32;
        gridBlueGhostX = blueGhostX / 32;
        gridRedGhostX = redGhostX / 32;
        gridRedGhostY = redGhostY / 32;
        // where pacman will go
        int targetPacmanLocationX = 0;
        int targetPacmanLocationY = 0;

        if (currentDirection == Direction.RIGHT) {
            targetPacmanLocationX = gridPacmanX + 2;
        } else if(currentDirection == Direction.LEFT) {
            targetPacmanLocationX = gridPacmanX - 2;
        } else if(currentDirection == Direction.UP) {
            targetPacmanLocationY = gridPacmanY - 2;
        } else if(currentDirection == Direction.DOWN) {
            targetPacmanLocationY = gridPacmanY + 2;
        } else {
            targetPacmanLocationX = gridPacmanX;
            targetPacmanLocationY = gridPacmanY;
        }
        // where inky will go

       int targetBlueGhostLocationX = 2 * (targetPacmanLocationX - gridRedGhostX);
       int targetBlueGhostLocationY = 2 * (targetPacmanLocationY - gridRedGhostY);

       if (targetBlueGhostLocationX > 0) {
            currentGhostDirection = Direction.RIGHT;
            if (this.arr.get(gridBlueGhostY).get(gridBlueGhostX + 1) == 1) {
                currentGhostDirection = Direction.STOP;
            } else if(this.arr.get(gridBlueGhostY).get(gridBlueGhostX + 1) != 1) {
                if (pacmanY % 32 != 0) {
                    if (arr.get(gridBlueGhostY + 1).get(gridBlueGhostX + 1) == 1) {
                        currentGhostDirection = Direction.STOP;
                    }else {
                        blueGhostX += 4;
                    }
                } else {
                    blueGhostX += 4;
                }
            }
       } else if(targetBlueGhostLocationX < 0) {
        currentGhostDirection = Direction.LEFT;
        if (this.arr.get(gridBlueGhostY).get(gridBlueGhostX - 1) == 1) {
            currentGhostDirection = Direction.STOP;
        } else if(this.arr.get(gridBlueGhostY).get(gridBlueGhostX - 1) != 1) {
            if (pacmanY % 32 != 0) {
                if (arr.get(gridBlueGhostY + 1).get(gridBlueGhostX - 1) == 1) {
                    currentGhostDirection = Direction.STOP;
                }else {
                    blueGhostX -= 4;
                }
            } else {
                blueGhostX -= 4;
            }
        }
       } else if(targetBlueGhostLocationY > 0) {
        currentGhostDirection = Direction.DOWN;
        if (this.arr.get(gridBlueGhostY + 1).get(gridBlueGhostX) == 1) {
            currentGhostDirection = Direction.STOP;
        } else if(this.arr.get(gridBlueGhostY + 1).get(gridBlueGhostX) != 1) {
            if (pacmanX % 32 != 0) {
                if (arr.get(gridBlueGhostY + 1).get(gridBlueGhostX + 1) == 1) {
                    currentGhostDirection = Direction.STOP;
                }else {
                    blueGhostY += 4;
                }
            } else {
                blueGhostY += 4;
            }
        }
       }else if(targetBlueGhostLocationY < 0) {
        currentGhostDirection = Direction.UP;
        if (this.arr.get(gridBlueGhostY - 1).get(gridBlueGhostX) == 1) {
            currentGhostDirection = Direction.STOP;
        } else if(this.arr.get(gridBlueGhostY - 1).get(gridBlueGhostX) != 1) {
            if (pacmanX % 32 != 0) {
                if (arr.get(gridBlueGhostY - 1).get(gridBlueGhostX + 1) == 1) {
                    currentGhostDirection = Direction.STOP;
                }else {
                    blueGhostY -= 4;
                }
            } else {
                blueGhostY -= 4;
            }
        }
       }

        
        
        

    }

    public void yellowGhostChaseAlgorithm() {
        int gridPacmanY = pacmanY / 32;
        int gridPacmanX = pacmanX / 32;
        gridYellowGhostY = yellowGhostY / 32;
        gridYellowGhostX = yellowGhostX / 32;
        // where pacman will go
        int targetYellowGhostLocationX = gridPacmanX;
        int targetYellowGhostLocationY = gridPacmanY;

        boolean sameY = false;
        boolean sameX = false;

        if (gridPacmanY == yellowGhostY) {                  
            sameY = true;
        }
        if (gridPacmanX == yellowGhostX) {
            sameX = true;
        }


        if (targetYellowGhostLocationX > 8) {
            if (targetYellowGhostLocationX > 0) {
                currentGhostDirection = Direction.RIGHT;
                if (this.arr.get(gridYellowGhostY).get(gridYellowGhostX + 1) == 1) {
                    currentGhostDirection = Direction.STOP;
                } else if(this.arr.get(gridYellowGhostY).get(gridYellowGhostX + 1) != 1) {
                    if (pacmanY % 32 != 0) {
                        if (arr.get(gridYellowGhostY + 1).get(gridYellowGhostX + 1) == 1) {
                            currentGhostDirection = Direction.STOP;
                        }else {
                            yellowGhostX += 4;
                        }
                    } else {
                        yellowGhostX += 4;
                    }
                }
            } else if(targetYellowGhostLocationX < 0) {
                currentGhostDirection = Direction.LEFT;
                if (this.arr.get(gridYellowGhostY).get(gridYellowGhostX - 1) == 1) {
                    currentGhostDirection = Direction.STOP;
                } else if(this.arr.get(gridYellowGhostY).get(gridYellowGhostX - 1) != 1) {
                    if (pacmanY % 32 != 0) {
                        if (arr.get(gridYellowGhostY + 1).get(gridYellowGhostX - 1) == 1) {
                            currentGhostDirection = Direction.STOP;
                        } else {
                            yellowGhostX -= 4;
                        }
                    } else {
                        yellowGhostX -= 4;
                    }
                }
            } else if(targetYellowGhostLocationY > 0) {
                currentGhostDirection = Direction.DOWN;
                if (this.arr.get(gridYellowGhostY + 1).get(gridYellowGhostX) == 1) {
                    currentGhostDirection = Direction.STOP;
                } else if(this.arr.get(gridYellowGhostY + 1).get(gridYellowGhostX) != 1) {
                    if (pacmanX % 32 != 0) {
                        if (arr.get(gridYellowGhostY + 1).get(gridYellowGhostX + 1) == 1) {
                            currentGhostDirection = Direction.STOP;
                        }else {
                            yellowGhostY += 4;
                        }
                    } else {
                        yellowGhostY += 4;
                    }
                }
            }else if(targetYellowGhostLocationY < 0) {
                currentGhostDirection = Direction.UP;
                if (this.arr.get(gridYellowGhostY - 1).get(gridYellowGhostX) == 1) {
                    currentGhostDirection = Direction.STOP;
                } else if(this.arr.get(gridYellowGhostY - 1).get(gridYellowGhostX) != 1) {
                    if (pacmanX % 32 != 0) {
                        if (arr.get(gridYellowGhostY - 1).get(gridYellowGhostX + 1) == 1) {
                            currentGhostDirection = Direction.STOP;
                        }else {
                            yellowGhostY -= 4;
                        }
                    } else {
                        yellowGhostY -= 4;
                    }
                }
            }
        } else {
            targetYellowGhostLocationX = 2;
            targetYellowGhostLocationY  = 21;
            if (targetYellowGhostLocationX > 0) {
                currentGhostDirection = Direction.RIGHT;
                if (this.arr.get(gridYellowGhostY).get(gridYellowGhostX + 1) == 1) {
                    currentGhostDirection = Direction.STOP;
                } else if(this.arr.get(gridYellowGhostY).get(gridYellowGhostX + 1) != 1) {
                    if (pacmanY % 32 != 0) {
                        if (arr.get(gridYellowGhostY + 1).get(gridYellowGhostX + 1) == 1) {
                            currentGhostDirection = Direction.STOP;
                        }else {
                            yellowGhostX += 4;
                        }
                    } else {
                        yellowGhostX += 4;
                    }
                }
            } else if(targetYellowGhostLocationX < 0) {
                currentGhostDirection = Direction.LEFT;
                if (this.arr.get(gridYellowGhostY).get(gridYellowGhostX - 1) == 1) {
                    currentGhostDirection = Direction.STOP;
                } else if(this.arr.get(gridYellowGhostY).get(gridYellowGhostX - 1) != 1) {
                    if (pacmanY % 32 != 0) {
                        if (arr.get(gridYellowGhostY + 1).get(gridYellowGhostX - 1) == 1) {
                            currentGhostDirection = Direction.STOP;
                        }else {
                            yellowGhostX -= 4;
                        }
                    } else {
                        yellowGhostX -= 4;
                    }
                }
            } else if(targetYellowGhostLocationY > 0) {
                currentGhostDirection = Direction.DOWN;
                if (this.arr.get(gridYellowGhostY + 1).get(gridYellowGhostX) == 1) {
                    currentGhostDirection = Direction.STOP;
                } else if(this.arr.get(gridYellowGhostY + 1).get(gridYellowGhostX) != 1) {
                    if (pacmanX % 32 != 0) {
                        if (arr.get(gridYellowGhostY + 1).get(gridYellowGhostX + 1) == 1) {
                            currentGhostDirection = Direction.STOP;
                        }else {
                            yellowGhostY += 4;
                        }
                    } else {
                        yellowGhostY += 4;
                    }
                }
            } else if(targetYellowGhostLocationY < 0) {
                currentGhostDirection = Direction.UP;
                if (this.arr.get(gridYellowGhostY - 1).get(gridYellowGhostX) == 1) {
                    currentGhostDirection = Direction.STOP;
                } else if(this.arr.get(gridYellowGhostY - 1).get(gridYellowGhostX) != 1) {
                    if (pacmanX % 32 != 0) {
                        if (arr.get(gridYellowGhostY - 1).get(gridYellowGhostX + 1) == 1) {
                            currentGhostDirection = Direction.STOP;
                        }else {
                            yellowGhostY -= 4;
                        }
                    } else {
                        yellowGhostY -= 4;
                    }
                } 
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
    }

    public void moveYellowGhost(Direction dir ) {
        currentGhostDirection = dir;
        // Right: X:1 Y:1
        // Left: X:-1 Y:1
        //Up: X: 1  Y: -1
        //Down: X:1 Y:1
        // Down, Up, Right, Left
        int[] yUpdatesForMod = {1, 1, 1, -1};
        int[] xUpdatesForMod = {1, -1, 1, 1};
        int[] xUpdates = {0, 0, 1, -1};
        int[] yUpdates = {1, -1, 0, 0};

        int dirIndex;
        int modDirIndex;
        if (dir == Direction.RIGHT) {
            dirIndex = 2;
            modDirIndex = 2;
        } else if (dir == Direction.LEFT) {
            dirIndex = 3;
            modDirIndex = 3;
        } else if (dir == Direction.UP) {
            dirIndex = 1;
            modDirIndex = 1;
        } else {
            dirIndex = 0;
            modDirIndex = 0;
        }

        if (this.arr.get(gridYellowGhostY + yUpdates[dirIndex]).get(gridYellowGhostX + xUpdates[dirIndex]) == 1) {
            currentGhostDirection = Direction.STOP;
        } else if(this.arr.get(gridYellowGhostY + yUpdates[dirIndex]).get(gridYellowGhostX + xUpdates[dirIndex]) != 1) {
            if (pacmanY % 32 != 0) {
                if (arr.get(gridYellowGhostY + yUpdatesForMod[modDirIndex]).get(gridYellowGhostX + xUpdatesForMod[modDirIndex]) == 1) { // complicated case (diagonal)
                    currentGhostDirection = Direction.STOP;
                    // 
                    // 
                    //
                } else {
                    yellowGhostY += 4 * yUpdates[dirIndex];
                    yellowGhostX += 4 * xUpdates[dirIndex];
                }
            } else {
                yellowGhostY += 4 * yUpdates[dirIndex];
                yellowGhostX += 4 * xUpdates[dirIndex];
            }
        }
    }

    public void yellowGhostScatter() {
        int targetYellowGhostLocationX = 2;
        int targetYellowGhostLocationY  = 21;
        if (targetYellowGhostLocationX > 0) {
            currentGhostDirection = Direction.RIGHT;
            if (this.arr.get(gridYellowGhostY).get(gridYellowGhostX + 1) == 1) {
                currentGhostDirection = Direction.STOP;
            } else if(this.arr.get(gridYellowGhostY).get(gridYellowGhostX + 1) != 1) {
                if (pacmanY % 32 != 0) {
                    if (arr.get(gridYellowGhostY + 1).get(gridYellowGhostX + 1) == 1) {
                        currentGhostDirection = Direction.STOP;
                    }else {
                        yellowGhostX += 4;
                    }
                } else {
                    yellowGhostX += 4;
                }
            }
        } else if(targetYellowGhostLocationX < 0) {
            currentGhostDirection = Direction.LEFT;
            if (this.arr.get(gridYellowGhostY).get(gridYellowGhostX - 1) == 1) {
                currentGhostDirection = Direction.STOP;
            } else if(this.arr.get(gridYellowGhostY).get(gridYellowGhostX - 1) != 1) {
                if (pacmanY % 32 != 0) {
                    if (arr.get(gridYellowGhostY + 1).get(gridYellowGhostX - 1) == 1) {
                        currentGhostDirection = Direction.STOP;
                    }else {
                        yellowGhostX -= 4;
                    }
                } else {
                    yellowGhostX -= 4;
                }
            }
        } else if(targetYellowGhostLocationY > 0) {
            currentGhostDirection = Direction.DOWN;
            if (this.arr.get(gridYellowGhostY + 1).get(gridYellowGhostX) == 1) {
                currentGhostDirection = Direction.STOP;
            } else if(this.arr.get(gridYellowGhostY + 1).get(gridYellowGhostX) != 1) {
                if (pacmanX % 32 != 0) {
                    if (arr.get(gridYellowGhostY + 1).get(gridYellowGhostX + 1) == 1) {
                        currentGhostDirection = Direction.STOP;
                    }else {
                        yellowGhostY += 4;
                    }
                } else {
                    yellowGhostY += 4;
                }
            }
        }else if(targetYellowGhostLocationY < 0) {
            currentGhostDirection = Direction.UP;
            if (this.arr.get(gridYellowGhostY - 1).get(gridYellowGhostX) == 1) {
                currentGhostDirection = Direction.STOP;
            } else if(this.arr.get(gridYellowGhostY - 1).get(gridYellowGhostX) != 1) {
                if (pacmanX % 32 != 0) {
                    if (arr.get(gridYellowGhostY - 1).get(gridYellowGhostX + 1) == 1) {
                        currentGhostDirection = Direction.STOP;
                    }else {
                        yellowGhostY -= 4;
                    }
                } else {
                    yellowGhostY -= 4;
                }
            }
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


    public void blueGhostScatter() {
        int targetBlueGhostLocationX = 19;
        int targetBlueGhostLocationY = 21;
        if (targetBlueGhostLocationX > 0) {
            currentGhostDirection = Direction.RIGHT;
            if (this.arr.get(gridBlueGhostY).get(gridBlueGhostX + 1) == 1) {
                currentGhostDirection = Direction.STOP;
            } else if(this.arr.get(gridBlueGhostY).get(gridBlueGhostX + 1) != 1) {
                if (pacmanY % 32 != 0) {
                    if (arr.get(gridBlueGhostY + 1).get(gridBlueGhostX + 1) == 1) {
                        currentGhostDirection = Direction.STOP;
                    }else {
                        blueGhostX += 4;
                    }
                } else {
                    blueGhostX += 4;
                }
            }
        } else if(targetBlueGhostLocationX < 0) {
            currentGhostDirection = Direction.LEFT;
            if (this.arr.get(gridBlueGhostY).get(gridBlueGhostX - 1) == 1) {
                currentGhostDirection = Direction.STOP;
            } else if(this.arr.get(gridBlueGhostY).get(gridBlueGhostX - 1) != 1) {
                if (pacmanY % 32 != 0) {
                    if (arr.get(gridBlueGhostY + 1).get(gridBlueGhostX - 1) == 1) {
                        currentGhostDirection = Direction.STOP;
                    }else {
                        blueGhostX -= 4;
                    }
                } else {
                    blueGhostX -= 4;
                }
            }
        } else if(targetBlueGhostLocationY > 0) {
            currentGhostDirection = Direction.DOWN;
            if (this.arr.get(gridBlueGhostY + 1).get(gridBlueGhostX) == 1) {
                currentGhostDirection = Direction.STOP;
            } else if(this.arr.get(gridBlueGhostY + 1).get(gridBlueGhostX) != 1) {
                if (pacmanX % 32 != 0) {
                    if (arr.get(gridBlueGhostY + 1).get(gridBlueGhostX + 1) == 1) {
                        currentGhostDirection = Direction.STOP;
                    }else {
                        blueGhostY += 4;
                    }
                } else {
                    blueGhostY += 4;
                }
            }
        } else if(targetBlueGhostLocationY < 0) {
            currentGhostDirection = Direction.UP;
            if (this.arr.get(gridBlueGhostY - 1).get(gridBlueGhostX) == 1) {
                currentGhostDirection = Direction.STOP;
            } else if(this.arr.get(gridBlueGhostY - 1).get(gridBlueGhostX) != 1) {
                if (pacmanX % 32 != 0) {
                    if (arr.get(gridBlueGhostY - 1).get(gridBlueGhostX + 1) == 1) {
                        currentGhostDirection = Direction.STOP;
                    }else {
                        blueGhostY -= 4;
                    }
                } else {
                    blueGhostY -= 4;
                }
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
    }

    public void redGhostScatter() {
        int targetRedGhostLocationX = 19;
        int targetRedGhostLocationY = 2;
        if (targetRedGhostLocationX > 0) {
            currentGhostDirection = Direction.RIGHT;
            if (this.arr.get(gridRedGhostY).get(gridRedGhostX + 1) == 1) {
                currentGhostDirection = Direction.STOP;
            } else if(this.arr.get(gridRedGhostY).get(gridRedGhostX + 1) != 1) {
                if (pacmanY % 32 != 0) {
                    if (arr.get(gridRedGhostY + 1).get(gridRedGhostX + 1) == 1) {
                        currentGhostDirection = Direction.STOP;
                    }else {
                        redGhostX += 4;
                    }
                } else {
                    redGhostX += 4;
                }
            }
        } else if(targetRedGhostLocationX < 0) {
            currentGhostDirection = Direction.LEFT;
            if (this.arr.get(gridRedGhostY).get(gridRedGhostX - 1) == 1) {
                currentGhostDirection = Direction.STOP;
            } else if(this.arr.get(gridRedGhostY).get(gridRedGhostX - 1) != 1) {
                if (pacmanY % 32 != 0) {
                    if (arr.get(gridRedGhostY + 1).get(gridRedGhostX - 1) == 1) {
                        currentGhostDirection = Direction.STOP;
                    }else {
                        redGhostX -= 4;
                    }
                } else {
                    redGhostX -= 4;
                }
            }
        } else if(targetRedGhostLocationY > 0) {
            currentGhostDirection = Direction.DOWN;
            if (this.arr.get(gridRedGhostY + 1).get(gridRedGhostX) == 1) {
                currentGhostDirection = Direction.STOP;
            } else if(this.arr.get(gridRedGhostY + 1).get(gridRedGhostX) != 1) {
                if (pacmanX % 32 != 0) {
                    if (arr.get(gridRedGhostY + 1).get(gridRedGhostX + 1) == 1) {
                        currentGhostDirection = Direction.STOP;
                    }else {
                        redGhostY += 4;
                    }
                } else {
                    redGhostY += 4;
                }
            }
        } else if(targetRedGhostLocationY < 0) {
            currentGhostDirection = Direction.UP;
            if (this.arr.get(gridRedGhostY - 1).get(gridRedGhostX) == 1) {
                currentGhostDirection = Direction.STOP;
            } else if(this.arr.get(gridRedGhostY - 1).get(gridRedGhostX) != 1) {
                if (pacmanX % 32 != 0) {
                    if (arr.get(gridRedGhostY - 1).get(gridRedGhostX + 1) == 1) {
                        currentGhostDirection = Direction.STOP;
                    }else {
                        redGhostY -= 4;
                    }
                } else {
                    redGhostY -= 4;
                }
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
    }

    public void pinkGhostScatter() {
        int targetPinkGhostLocationX = 2;
        int targetPinkGhostLocationY = 2;
        if (targetPinkGhostLocationX > 0) {
            currentGhostDirection = Direction.RIGHT;
            if (this.arr.get(gridPinkGhostY).get(gridPinkGhostX + 1) == 1) {
                currentGhostDirection = Direction.STOP;
            } else if(this.arr.get(gridPinkGhostY).get(gridPinkGhostX + 1) != 1) {
                if (pacmanY % 32 != 0) {
                    if (arr.get(gridPinkGhostY + 1).get(gridPinkGhostX + 1) == 1) {
                        currentGhostDirection = Direction.STOP;
                    }else {
                        pinkGhostX += 4;
                    }
                } else {
                    pinkGhostX += 4;
                }
            }
        } else if(targetPinkGhostLocationX < 0) {
            currentGhostDirection = Direction.LEFT;
            if (this.arr.get(gridPinkGhostY).get(gridPinkGhostX - 1) == 1) {
                currentGhostDirection = Direction.STOP;
            } else if(this.arr.get(gridPinkGhostY).get(gridPinkGhostX - 1) != 1) {
                if (pacmanY % 32 != 0) {
                    if (arr.get(gridPinkGhostY + 1).get(gridPinkGhostX - 1) == 1) {
                        currentGhostDirection = Direction.STOP;
                    }else {
                        pinkGhostX -= 4;
                    }
                } else {
                    pinkGhostX -= 4;
                }
            }
        } else if(targetPinkGhostLocationY > 0) {
            currentGhostDirection = Direction.DOWN;
            if (this.arr.get(gridPinkGhostY + 1).get(gridPinkGhostX) == 1) {
                currentGhostDirection = Direction.STOP;
            } else if(this.arr.get(gridPinkGhostY + 1).get(gridPinkGhostX) != 1) {
                if (pacmanX % 32 != 0) {
                    if (arr.get(gridPinkGhostY + 1).get(gridPinkGhostX + 1) == 1) {
                        currentGhostDirection = Direction.STOP;
                    }else {
                        pinkGhostY += 4;
                    }
                } else {
                    pinkGhostY += 4;
                }
            }
        } else if(targetPinkGhostLocationY < 0) {
            currentGhostDirection = Direction.UP;
            if (this.arr.get(gridPinkGhostY - 1).get(gridPinkGhostX) == 1) {
                currentGhostDirection = Direction.STOP;
            } else if(this.arr.get(gridPinkGhostY - 1).get(gridPinkGhostX) != 1) {
                if (pacmanX % 32 != 0) {
                    if (arr.get(gridPinkGhostY - 1).get(gridPinkGhostX + 1) == 1) {
                        currentGhostDirection = Direction.STOP;
                    }else {
                        pinkGhostY -= 4;
                    }
                } else {
                    pinkGhostY -= 4;
                }
            }
        }
        
        for(int i = 0;i < pinkCornerPairs.size();i++) {
            Pair<Integer, Integer> futurePair = pinkCornerPairs.get(i + 1);
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