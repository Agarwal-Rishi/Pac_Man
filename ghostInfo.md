4 Phases of Ghosts:
chase: they aggresivly attack pacman
scatter: they each travel to their respective corners: Blinky;top right , Inky;bottom right , Pinky;top left , Clyde:bottom left
frightended: they try to run away from the pacman

Time Stamps:

mode       Level 1     Level 2-4     Level 5+
scatter    7 secs
chase      20 secs
scatter    7 secs
chase      20 secs
scatter    5 secs
chase      20 secs
scatter    5 secs
chase      indefinite 


import java.util.AbstractMap;

public class Main {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;

        AbstractMap.SimpleEntry<Integer, Integer> pair =
            new AbstractMap.SimpleEntry<>(a, b);

        System.out.println(pair.getKey());   // 5
        System.out.println(pair.getValue()); // 10
    }
}

# Top edge (y = 21)
(2,21) (3,21) (4,21) (5,21) (6,21) (7,21) (8,21) (9,21) (10,21)

# Bottom edge (y = 27)
(2,27) (3,27) (4,27) (5,27) (6,27) (7,27) (8,27) (9,27) (10,27)

# Left edge (x = 2, excluding corners)
(2,22) (2,23) (2,24) (2,25) (2,26)

# Right edge (x = 10, excluding corners)
(10,22) (10,23) (10,24) (10,25) (10,26)


Top Path (Row 21)
blueCoords.add(new Pair<Integer,Integer>(21, 19));
blueCoords.add(new Pair<Integer,Integer>(21, 20));
blueCoords.add(new Pair<Integer,Integer>(21, 21));
blueCoords.add(new Pair<Integer,Integer>(21, 22));
blueCoords.add(new Pair<Integer,Integer>(21, 23));
blueCoords.add(new Pair<Integer,Integer>(21, 24));
blueCoords.add(new Pair<Integer,Integer>(21, 25));
blueCoords.add(new Pair<Integer,Integer>(21, 26));
blueCoords.add(new Pair<Integer,Integer>(21, 27));
blueCoords.add(new Pair<Integer,Integer>(22, 27));
blueCoords.add(new Pair<Integer,Integer>(23, 27));
blueCoords.add(new Pair<Integer,Integer>(24, 27));
blueCoords.add(new Pair<Integer,Integer>(25, 27));
blueCoords.add(new Pair<Integer,Integer>(26, 27));
blueCoords.add(new Pair<Integer,Integer>(27, 19));
blueCoords.add(new Pair<Integer,Integer>(27, 20));
blueCoords.add(new Pair<Integer,Integer>(27, 21));
blueCoords.add(new Pair<Integer,Integer>(27, 22));
blueCoords.add(new Pair<Integer,Integer>(27, 23));
blueCoords.add(new Pair<Integer,Integer>(27, 24));
blueCoords.add(new Pair<Integer,Integer>(27, 25));
blueCoords.add(new Pair<Integer,Integer>(27, 26));
blueCoords.add(new Pair<Integer,Integer>(27, 27));
blueCoords.add(new Pair<Integer,Integer>(22, 19));
blueCoords.add(new Pair<Integer,Integer>(23, 19));
blueCoords.add(new Pair<Integer,Integer>(24, 19));
blueCoords.add(new Pair<Integer,Integer>(25, 19));
blueCoords.add(new Pair<Integer,Integer>(26, 19));






    