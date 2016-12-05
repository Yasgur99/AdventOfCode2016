package adventday4;

import java.util.ArrayList;

/**
 *
 * @author yasgur99
 */

public class AdventDay4 {

    public static void main(String[] args) {
        FileParser parser = new FileParser("src/adventday4/ListOfRooms.txt");
        ArrayList<Room> valid = new ArrayList<Room>();
        
        //Make List of valid rooms
        for(Room r : parser.getList() ){
            if(r.isReal())
            valid.add(r);
        }
        
        //Find Sum of valid rooms
        int sum=0;
        for(Room r : valid){
            sum += r.getID();
        }
        System.out.println("Sum of valid room IDs: " + sum);
        
        //Part 2
        Cypher c = new Cypher(valid);
        c.shift();
    }

}
