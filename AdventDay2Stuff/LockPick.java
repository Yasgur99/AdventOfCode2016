package advent2;

import java.util.ArrayList;

public class LockPick {

  private int[][] keypad;
  private int currentLocation;
  private ArrayList<String> instructions;
  private String code;

  public LockPick(ArrayList<String> instructions) {
    this.instructions = instructions;
    keypad = new int[][]{ {1,2,3},{4,5,6},{7,8,9} };
    currentLocation = 5;
    code = "";
  }
  
  public void followInstructions(){
    int counter = 0;
    for(String instruction : instructions){
      for(char command : instruction.toCharArray()){
      switch(command){
        case 'U': if(currentLocation - 3 >= 1)
          currentLocation -= 3;
          break;
        case 'D':if(currentLocation + 3 <= 9)
          currentLocation +=3;
          break;
        case 'L': if(currentLocation != 1 && currentLocation != 4 && currentLocation != 7)
          currentLocation -= 1;
          break;
        case 'R':if(currentLocation != 3 && currentLocation != 6 && currentLocation != 9)
          currentLocation += 1;
          break;
      }
    }
      code += currentLocation;
    }
    System.out.println("The code is: "+code);
  }
}
