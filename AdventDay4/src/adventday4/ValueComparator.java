package adventday4;

/**
 * @author yasgur99
 *
 */

import java.util.*;

class ValueComparator implements Comparator<Character> {
    Map<Character, Integer> base;

    public ValueComparator(Map<Character, Integer> base) {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with
    // equals.
    public int compare(Character a, Character b) {
        if (base.get(a) > base.get(b)) {
            return -1;
        }else if(base.get(a) == base.get(b)){
            return a.compareTo(b);
        } else {
            return 1;
        } // returning 0 would merge keys
    }
}