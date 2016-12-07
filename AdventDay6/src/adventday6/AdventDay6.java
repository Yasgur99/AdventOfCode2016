package adventday6;

public class AdventDay6 {

    public static void main(String[] args) {
        FileParser parser = new FileParser("src/adventday6/messages.txt");
        char[][] messages = parser.getMessages();
        System.out.print("Most popular letters: ");
        for (int i = 0; i < messages.length; i++) 
            System.out.print(getPopularElement(messages[i], true));
        System.out.print("\nLeast popular letters: ");
        for (int i = 0; i < messages.length; i++) 
            System.out.print(getPopularElement(messages[i], false));
        System.out.println("");
    }

    public static char getPopularElement(char[] a, boolean findPopular) {
        int count = 0, tempCount;
        char popular = a[0];
        char temp;
        for (int i = 0; i < (a.length - 1); i++) {
            temp = a[i];
            tempCount = 0;
            for (int j = 0; j < a.length; j++) 
                if (temp == a[j]) 
                    tempCount++;
            if (findPopular) {
                if (tempCount > count) {
                    popular = temp;
                    count = tempCount;
                }
            } else if (tempCount < count || i == 0) {
                popular = temp;
                count = tempCount;
            }
        }
        return popular;
    }
}