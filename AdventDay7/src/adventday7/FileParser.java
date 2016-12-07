package adventday7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author michaelmaitland
 */
public class FileParser {

  private String filename;
  private ArrayList<ipAddress> addresses;

  public FileParser(String filename) {
    this.filename = filename;
    this.addresses = new ArrayList<ipAddress>();
    read();
  }

  private void read() {
    try {
      BufferedReader br = new BufferedReader(new FileReader(filename));
      String line;
      while ((line = br.readLine()) != null) { //Read each line
        char[] chars = line.toCharArray(); //Convert line to char[]
        String outOf = "";
        String inOf = "";
        for (int i = 0; i < chars.length; i++) {
          if (chars[i] == '[') { //if its within braces
            for (;; i++) { 
              inOf += chars[i] + "";
              if (chars[i] == ']') {//end in braces
                inOf += chars[i];
                break;
              }
            }
          }
          outOf += chars[i] + "";
        }
        this.addresses.add(new ipAddress(outOf, inOf));
      }
    } catch (FileNotFoundException e) {
      System.out.println("File not Found");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public ArrayList<ipAddress> getMessages() {
    return addresses;
  }
}

