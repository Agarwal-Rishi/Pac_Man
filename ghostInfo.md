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

Top-left (starts at (2,2))
(2,2), (3,2), (4,2), (5,2), (6,2), (7,2), (8,2), (9,2), (10,2), (10,3), (10,4), (10,5), (10,6), (10,7), (10,8), (9,8), (8,8), (7,8), (6,8), (5,8), (4,8), (3,8), (2,8), (2,7), (2,6), (2,5), (2,4), (2,3)
Top-right (starts at (19,2))
(19,2), (20,2), (21,2), (22,2), (23,2), (24,2), (25,2), (26,2), (27,2), (27,3), (27,4), (27,5), (27,6), (27,7), (27,8), (26,8), (25,8), (24,8), (23,8), (22,8), (21,8), (20,8), (19,8), (19,7), (19,6), (19,5), (19,4), (19,3)
Bottom-left (starts at (2,21))
(2,21), (3,21), (4,21), (5,21), (6,21), (7,21), (8,21), (9,21), (10,21), (10,22), (10,23), (10,24), (10,25), (10,26), (10,27), (9,27), (8,27), (7,27), (6,27), (5,27), (4,27), (3,27), (2,27), (2,26), (2,25), (2,24), (2,23), (2,22)
Bottom-right (starts at (19,21))
(19,21), (20,21), (21,21), (22,21), (23,21), (24,21), (25,21), (26,21), (27,21), (27,22), (27,23), (27,24), (27,25), (27,26), (27,27), (26,27), (25,27), (24,27), (23,27), (22,27), (21,27), (20,27), (19,27), (19,26), (19,25), (19,24), (19,23), (19,22)







    