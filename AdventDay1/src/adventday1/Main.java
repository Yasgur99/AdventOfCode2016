package adventday1;

import java.lang.Math;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String[] instructions = "L2, L5, L5, R5, L2, L4, R1, R1, L4, R2, R1, L1, L4, R1, L4, L4, R5, R3, R1, L1, R1, L5, L1, R5, L4, R2, L5, L3, L3, R3, L3, R4, R4, L2, L5, R1, R2, L2, L1, R3, R4, L193, R3, L5, R45, L1, R4, R79, L5, L5, R5, R1, L4, R3, R3, L4, R185, L5, L3, L1, R5, L2, R1, R3, R2, L3, L4, L2, R2, L3, L2, L2, L3, L5, R3, R4, L5, R1, R2, L2, R4, R3, L4, L3, L1, R3, R2, R1, R1, L3, R4, L5, R2, R1, R3, L3, L2, L2, R2, R1, R2, R3, L3, L3, R4, L4, R4, R4, R4, L3, L1, L2, R5, R2, R2, R2, L4, L3, L4, R4, L5, L4, R2, L4, L4, R4, R1, R5, L2, L4, L5, L3, L2, L4, L4, R3, L3, L4, R1, L2, R3, L2, R1, R2, R5, L4, L2, L1, L3, R2, R3, L2, L1, L5, L2, L1, R4".split(", ");
        int x = 0;
        int y = 0;
        int direction = 1;
        ArrayList<String> points = new ArrayList<String>();
        for (String current : instructions) {
            String toTurn = current.charAt(0) + "";
            int distance = Integer.parseInt(current.substring(1));

            //Set NSEW
            if (toTurn.equals("R")) {
                direction++;
                if (direction == 5) {
                    direction = 1;
                }
            } else {
                direction--;
                if (direction == 0) {
                    direction = 4;
                }
            }

            //Create xy point
            if (direction == 1) {
                for (int i = 0; i < distance; i++) {
                    y++;
                    if (points.contains(x + "," + y)) {
                        System.out.println(x + "," + y);
                        break;
                    }
                    points.add(x + "," + y);
                }
            } else if (direction == 2) {
                for (int i = 0; i < distance; i++) {
                    x++;
                    if (points.contains(x + "," + y)) {
                        System.out.println(x + "," + y);
                    }
                    points.add(x + "," + y);
                }
            } else if (direction == 3) {
                for (int i = 0; i < distance; i++) {
                    y--;
                    if (points.contains(x + "," + y)) {
                        System.out.println(x + "," + y);
                    }
                    points.add(x + "," + y);
                }
            } else if (direction == 4) {
                for (int i = 0; i < distance; i++) {
                    x--;
                    if (points.contains(x + "," + y)) {
                        System.out.println(x + "," + y);
                    }
                    points.add(x + "," + y);
                }
            }
        }
    }
}
