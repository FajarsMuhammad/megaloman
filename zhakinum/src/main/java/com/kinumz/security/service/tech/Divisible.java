package com.kinumz.security.service.tech;

public class Divisible {


  public static String calculator( String[] distancesList ) {
    if(distancesList == null || distancesList.length == 0){
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

    int endOfTitle = distancesList[max].indexOf("" + maxDistance);
    String distanceTitle = new String();
    if(endOfTitle != -1) {
      distanceTitle = distancesList[max].substring(0, endOfTitle);
    }
    StringBuffer sb = new StringBuffer();
    sb.append("Total expenses:").
        append(totalExpences).
        append("$;Longest distance:").append(distanceTitle).append(" ");

    return sb.toString();
  }

}
