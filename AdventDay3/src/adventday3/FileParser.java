package adventday3;

/**
 * @author yasgur99
 *
 */
import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class FileParser {

    private List<Triangle> possibleTriangles;
    private List<Triangle> possibleByColumn;
    private String filename;

    public FileParser(String filename) {
        possibleTriangles = new ArrayList<Triangle>();
        possibleByColumn = new ArrayList<Triangle>();
        this.filename = filename;
        readRows();
        readColumns();
    }

    private void readRows() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                String[] parts = line.split(" +");
                possibleTriangles.add(new Triangle(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("File Not found");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void readColumns() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            int[] row1 = new int[1902];
            int[] row2 = new int[1902];
            int[] row3 = new int[1902];
            int counter = 0;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                String[] parts = line.split(" +");
                row1[counter] = Integer.parseInt(parts[0]);
                row2[counter] = Integer.parseInt(parts[1]);
                row3[counter++] = Integer.parseInt(parts[2]);
            }
            for (int i = 0; i < 3; i++) {
                counter = 0;
                while (counter < 1902) {
                    if (i == 0) {
                        this.possibleByColumn.add(new Triangle(row1[counter++], row1[counter++], row1[counter++]));
                    } else if (i == 1) {
                        this.possibleByColumn.add(new Triangle(row2[counter++], row2[counter++], row2[counter++]));
                    } else if (i == 2) {
                        this.possibleByColumn.add(new Triangle(row3[counter++], row3[counter++], row3[counter++]));
                    }
                }
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("File Not found");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public List<Triangle> getList() {
        return possibleTriangles;
    }

    public List<Triangle> getByColumn() {
        return this.possibleByColumn;
    }
}
