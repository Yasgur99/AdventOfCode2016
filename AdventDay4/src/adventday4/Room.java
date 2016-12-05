package adventday4;

/**
 * @author yasgur99
 *
 */
import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

public class Room {

    private char[] name;
    private int sectorID;
    private String checkSum;
    private String unsortedName;

    public Room(String name, int sectorID, String checkSum) {
        this.name = name.toCharArray();
        this.unsortedName = name;
        Arrays.sort(this.name);
        this.sectorID = sectorID;
        this.checkSum = checkSum;
    }

    public boolean isReal() {
        HashMap<Character, Integer> nameMap = makeHashMap();
        ValueComparator bvc = new ValueComparator(nameMap);
        TreeMap<Character, Integer> sorted_map = new TreeMap<Character, Integer>(bvc);
        sorted_map.putAll(nameMap);

        ArrayList<Character> a = new ArrayList<Character>(sorted_map.keySet());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < checkSum.length(); i++) {
            sb.append(a.get(i));
        }
        return sb.toString().equals(checkSum);
    }

    private HashMap<Character, Integer> makeHashMap() {
        HashMap<Character, Integer> nameMap = new HashMap<Character, Integer>();
        for (int i = 0; i < name.length; i++) {
            if (!nameMap.containsKey(name[i])) {
                nameMap.put(name[i], 1);
            } else {
                nameMap.put(name[i], nameMap.get(name[i]) + 1);
            }
        }
        return nameMap;
    }
    
    public int getID(){
        return this.sectorID;
    }
    
    public String getChars(){
        return this.unsortedName;
    }
}
