package adventday2;

import java.util.ArrayList;

/**
 * @author yasgur99
 **/

public class LockPickPart2 {
  private int currentLocation;
  private ArrayList<String> instructions;
  private String code;

  public LockPickPart2(ArrayList<String> instructions) {
    this.instructions = instructions;
    currentLocation = 5;
    code = "";
  }
  
  public void followInstructions(){
    for(String instruction : instructions){
      for(char command : instruction.toCharArray()){
      switch(command){
        case 'U': if(currentLocation !=5 && currentLocation !=2 && currentLocation != 1 && currentLocation != 4 && currentLocation != 9)
            if(currentLocation == 13 || currentLocation == 3) currentLocation -= 2;
            else /*if(currentLocation >= 6 && currentLocation <= 12)*/ currentLocation -= 4;
          break;
        case 'D':if(currentLocation !=5 && currentLocation !=10 && currentLocation != 13 && currentLocation != 12 && currentLocation != 9)
            if(currentLocation == 1 || currentLocation == 11) currentLocation += 2;
            else /*if(currentLocation >= 2 && currentLocation <= 8)*/ currentLocation += 4;
          break;
        case 'L': if(currentLocation != 1 && currentLocation != 2 && currentLocation != 5 && currentLocation != 10 && currentLocation != 13)
          currentLocation -= 1;
          break;
        case 'R':if(currentLocation != 1 && currentLocation != 4 && currentLocation != 9 && currentLocation != 12 && currentLocation != 13)
          currentLocation += 1;
          break;
      }
    }
      if(currentLocation > 9)
          code += toLetter(currentLocation);
      else
        code += currentLocation;
    }
    System.out.println("The code is: "+code);
  }
  
  private String toLetter(int num){
      if(num ==10)
          return "A";
      else if(num == 11)
          return "B";
      else if(num==12)
          return "C";
      else if(num==13)
          return "D";
      return "X";
  }
}
