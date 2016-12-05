package adventday4;

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

    private ArrayList<Room> rooms;
    private String filename;

    public FileParser(String filename) {
        rooms = new ArrayList<Room>();
        this.filename = filename;
        read();
    }

    private void read() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;

            while ((line = br.readLine()) != null) {
                String name = "";
                int id = 0;
                String checkSum = "";
                String[] parts = line.split("-");
                for (String s : parts) {
                    if (s.contains("[")) {
                        id = Integer.parseInt(s.substring(0, s.indexOf("[")));
                        checkSum = s.substring(s.indexOf("[") + 1, s.indexOf("]"));
                    } else {
                        name += s;
                    }
                }
                rooms.add(new Room(name, id, checkSum));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Room> getList() {
        return this.rooms;
    }
}
