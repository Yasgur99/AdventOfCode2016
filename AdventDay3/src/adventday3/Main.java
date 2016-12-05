package adventday3;

/**
 *
 * @author yasgur99
 */

public class Main {

    public static void main(String[] args) {
        FileParser parser = new FileParser("src/adventday3/PossibleTriangleList.txt");
        int numOfTri = 0;
        for(Triangle t : parser.getList()){
            if(t.isTriangle())
                numOfTri++;
        }
        System.out.println("There are " + numOfTri + " triangles");
        
        numOfTri= 0;
        for(Triangle t : parser.getByColumn()){
             if(t.isTriangle())
                numOfTri++;
        }
        System.out.println("There are " + numOfTri + " triangles");
        }
    }


