
package adventday6;

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
  private char[][] lines;
  
  public FileParser(String filename){
    this.filename = filename;
    this.lines = new char[8][598];
    read();
  }
  
  private void read(){
    try{
      BufferedReader br = new BufferedReader(new FileReader(filename));
      String line;
      int counter = 0;
      while((line = br.readLine()) != null){
        for(int i=0;i<8;i++){
          lines[i][counter] = line.charAt(i);
        }
        counter++;
      }
    }catch (FileNotFoundException e){
      System.out.println("File not Found");
    }catch(IOException e){
      e.printStackTrace();
    }
  } 
  
  public char[][] getMessages(){
    return lines;
  }
}

