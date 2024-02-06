package com.kinumz;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

public class FajarTest {

  @Test
  public void japs() throws IOException {
    String[] value = new String[]{"Vienna-Prague 312","Prague-Zurich 676"};
   // String[] value = new String[]{};
    System.out.println(calculator(value));

    Thread th = new Thread();
    Socket socket = new ServerSocket(1234).accept();


  }

  public OptionalInt multiply (int start, int finish){
    return IntStream.of(start, finish).reduce((a,b)-> a*b);
  }

  public String calculator( String[] distancesList ) {
    if(distancesList == null){
      return "Empty List";
    }
    final double perLitre= 1.30;
    final int consumption = 8;
    int totalDistance = 0;
    int[] distances = new int[distancesList.length];
    for(int i = 0; i < distancesList.length; i++) {
      String item = distancesList[i];
      String[] words = item.split(" ");
      String distInKm = words[words.length-1];
      distances[i] = Integer.parseInt(distInKm);
    }
    int maxDistance = 0;
    int max = 0;
    for(int i = 0; i < distances.length; i++) {
      if(distances[i] > maxDistance) {
        totalDistance += distances[i];
        max = i;
      }
    }
    Double totalExpences = totalDistance * perLitre;
    BigDecimal expences = BigDecimal.valueOf(totalExpences).setScale(2, RoundingMode.HALF_UP);

    int endOfTitle = distancesList[max].indexOf("" + maxDistance);
    String distanceTitle = new String();
    if(endOfTitle != -1) {
      distanceTitle = distancesList[max].substring(0, endOfTitle);
    }
    StringBuffer sb = new StringBuffer();
    sb.append("Total expenses:").
        append(expences).
        append("$;Longest distance:").append(distanceTitle).append(" ");

    return sb.toString();
  }

}
