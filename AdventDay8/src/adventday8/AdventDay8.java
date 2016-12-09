package adventday8;

import java.util.Arrays;

/**
 *
 * @author yasgur99
 */
public class AdventDay8 {

    public static void main(String[] args) {
        char[][] screen = initScreen();
        FileParser parser = new FileParser("src/adventday8/input.txt");
        for(String instruction : parser.getInstructions()) {
            if(instruction.contains("rect")){
                instruction = instruction.substring(instruction.indexOf(" ") + 1);
                screen = rect(instruction, screen);
            } else if(instruction.contains("rotate row")){
                instruction = instruction.substring(instruction.indexOf(" ") + 1);
                instruction = instruction.substring(instruction.indexOf(" ") + 1);
                screen = rotateRow(instruction, screen);
            } else {
                instruction = instruction.substring(instruction.indexOf(" ") + 1);
                instruction = instruction.substring(instruction.indexOf(" ") + 1);
                screen = rotateColumn(instruction, screen);
            }
        }
        printArray(screen);

    }

    public static char[][] rect(String instruction, char[][] screen) {
        int x = Integer.parseInt("" + instruction.substring(0, instruction.indexOf("x")));
        int y = Integer.parseInt("" + instruction.substring(instruction.indexOf("x") + 1));
        for(int i = 0; i < screen.length; i++) {
            for(int j = 0; j < screen[0].length; j++) {
                if(i < y && j < x)
                    screen[i][j] = '#';
            }
        }
        return screen;
    }

    public static char[][] rotateRow(String instruction, char[][] screen) {
        int row = Integer.parseInt(instruction.substring(2, instruction.indexOf(' ')));
        String tempa = instruction.substring(instruction.indexOf(' ') + 1);
        int amount = Integer.parseInt(tempa.substring(tempa.indexOf(' ') + 1));
        for(int i = 0; i < amount; i++) {
            for(int j = screen[0].length - 1; j > 0; j--) {
                char temp = screen[row][j];
                screen[row][j] = screen[row][j - 1];
                screen[row][j - 1] = temp;
            }
        }
        return screen;
    }

    public static char[][] rotateColumn(String instruction, char[][] screen) {
        int column = Integer.parseInt(instruction.substring(2, instruction.indexOf(' ')));
        String tempa = instruction.substring(instruction.indexOf(' ') + 1);
        int amount = Integer.parseInt(tempa.substring(tempa.indexOf(' ') + 1));
        for(int i = 0; i < amount; i++) {
            for(int j = screen.length - 1; j > 0; j--) {
                char temp = screen[j][column];
                screen[j][column] = screen[j - 1][column];
                screen[j - 1][column] = temp;
            }
        }
        return screen;
    }

    public static void printArray(char[][] screen) {
        int numPixels = 0;
        for(int i = 0; i < screen.length; i++) {
            for(int j = 0; j < screen[0].length; j++) {
                System.out.print(screen[i][j]);
                if(screen[i][j] == '#')
                    numPixels++;
            }
            System.out.println("");
        }
        System.out.println("There are " + numPixels + " visible");
    }

    public static char[][] initScreen() {
        char[][] array = new char[6][50];
        for(int i = 0; i < 6; i++)
            Arrays.fill(array[i], '.');
        return array;
    }
}
