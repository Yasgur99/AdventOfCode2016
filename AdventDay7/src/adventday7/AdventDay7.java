
package adventday7;

import java.util.ArrayList;

public class AdventDay7 {
  
  public static void main(String[] args) {
    FileParser parser = new FileParser("src/adventday7/ipaddresses.txt");
    int tls = 0;
    int ssl = 0;
    for(ipAddress a : parser.getMessages()){
      if(a.supportTLS())
        tls++;
      if(a.supportSSL()){
        ssl++;
      }
    }
    System.out.println("Number of addresses that support TLS: " + tls);
    System.out.println("Number of addresses that support SSL: " + ssl);
  }
  
}

