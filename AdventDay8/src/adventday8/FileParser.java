package adventday8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author yasgur99
 *
 */
public class FileParser {

    private ArrayList<String> instructions;
    private String filename;

    public FileParser(String filename) {
        this.filename = filename;
        this.instructions = new ArrayList<String>();
        read();
    }

    private void read() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while((line = br.readLine()) != null) {
                this.instructions.add(line);
            }
        } catch(FileNotFoundException e) {
            System.out.println("File not found");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<String> getInstructions(){
        return this.instructions;
    }
}
