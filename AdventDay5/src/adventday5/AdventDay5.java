package adventday5;

/**
 *
 * @author michaelmaitland
 */
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

public class AdventDay5 {

    public static void main(String[] args) throws Exception {
        partOne("abbhdwsy");
        partTwo("abbhdwsy");
    }

    public static String hasher(String input) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(input.getBytes());
        byte[] digest = md.digest();
        return DatatypeConverter
                .printHexBinary(digest).toLowerCase();
    }

    public static void partOne(String base) throws Exception {
        String password = "";
        int numbers = 0;
        while (password.length() < 8) {
            if (hasher(base + numbers).startsWith("00000")) {
                password += hasher(base + numbers).charAt(5) + "";
            }
            numbers++;
        }
        System.out.println("Password to part one: " + password);

    }

    public static void partTwo(String base) throws Exception {
        char[] pass = new char[8];
        int numbers = 0;
        int counter = 0;
        for (int i = 0; i < 8; numbers++) {
            if (hasher(base + numbers).startsWith("00000")) {
                try {
                    int num = Integer.parseInt(hasher(base + numbers).charAt(5) + "");
                    if (num < 8) {
                        if (pass[num] == '\0') {
                            i++;
                            pass[num] = hasher(base + numbers).charAt(6);
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
        System.out.print("Password to part two: ");
        for (char c : pass) {
            System.out.print(c);
        }
        System.out.println("");
    }
}
