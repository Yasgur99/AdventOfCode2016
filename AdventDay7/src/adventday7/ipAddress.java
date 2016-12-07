package adventday7;

import java.util.ArrayList;

/**
 * @author michaelmaitland
 */
public class ipAddress {

  String ipOutOfBracket;
  String ipWithinBracket;

  public ipAddress(String ipOutOfBracket, String ipWithinBracket) {
    this.ipOutOfBracket = ipOutOfBracket;
    this.ipWithinBracket = ipWithinBracket;
  }

  public String getIpOutOfBracket() {
    return this.ipOutOfBracket;
  }

  public String getIpWithinOfBracket() {
    return this.ipWithinBracket;
  }

  public boolean supportTLS() {
    for (int i = 0; i < ipWithinBracket.length() - 3; i++) {
      if (ipWithinBracket.charAt(i) == ipWithinBracket.charAt(i + 3)
              && ipWithinBracket.charAt(i + 1) == ipWithinBracket.charAt(i + 2)
              && ipWithinBracket.charAt(i) != ipWithinBracket.charAt(i + 1)) {
        return false;
      }
    }

    for (int i = 0; i < ipOutOfBracket.length() - 3; i++) {
      if (ipOutOfBracket.charAt(i) == ipOutOfBracket.charAt(i + 3)
              && ipOutOfBracket.charAt(i + 1) == ipOutOfBracket.charAt(i + 2)
              && ipOutOfBracket.charAt(i) != ipOutOfBracket.charAt(i + 1)) {
        return true;
      }
    }
    return false;
  }

  public boolean supportSSL() {
    ArrayList<String> inKeys = new ArrayList<String>();
    for (int i = 0; i < ipWithinBracket.length() - 2; i++) 
      if (ipWithinBracket.charAt(i) == ipWithinBracket.charAt(i + 2)) 
        inKeys.add("" + ipWithinBracket.charAt(i + 1) + ipWithinBracket.charAt(i) + ipWithinBracket.charAt(i + 1));
      
    for (int i = 0; i < ipOutOfBracket.length() - 2; i++) {
      if (ipOutOfBracket.charAt(i) == ipOutOfBracket.charAt(i + 2)
              && ipOutOfBracket.charAt(i) != ipOutOfBracket.charAt(i + 1)) 
        if(inKeys.contains(ipOutOfBracket.substring(i, i+3)))
          return true;
    }
    return false;
  }
}

