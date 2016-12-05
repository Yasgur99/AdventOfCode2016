package adventday4;

import java.util.ArrayList;

/**
 * @author yasgur99
 *
 */
public class Cypher {

    private ArrayList<Room> rooms;

    public Cypher(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public void shift() {
        for (Room r : rooms) {
            encrypt(r.getChars(), r.getID());
        }
    }

    public static void encrypt(String plainText, int shiftKey) {
        final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
        plainText = plainText.toLowerCase();

        String cipherText = "";

        for (int i = 0; i < plainText.length(); i++) {

            int charPosition = ALPHABET.indexOf(plainText.charAt(i));

            int keyVal = (shiftKey + charPosition) % 26;

            char replaceVal = ALPHABET.charAt(keyVal);

            cipherText += replaceVal;

        }

       if(cipherText.contains("northpole"))
            System.out.println("Key to north pole room: " + shiftKey);
    }

}
