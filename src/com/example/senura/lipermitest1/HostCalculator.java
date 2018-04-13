/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.senura.lipermitest1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author senura
 */
public class HostCalculator {
    
    private static int [] GETCount= {};
    //private static String[] ipAdresses={};
    private static List<String> ipAdresses = new ArrayList<String>();
    
    public static void appendHost(int count, String ipAddress){
        GETCount=arrayIntPush(count, GETCount);
        ipAdresses.add(ipAddress);
        
        System.out.println("array Gcount"+Arrays.toString(ipAdresses.toArray()));
        //System.out.println("array ip = "+GETCount[0]);
        System.out.println("array Gcount"+Arrays.toString(GETCount));
        
        
    }
    
    
    public static int [] getGetCount(){
    return GETCount;
    }
    
    
    public static List<String> getIPs(){
    return ipAdresses;
    }
    
    
    
    
    private static int[] arrayIntPush(int item, int[] oldArray) {
    int len = oldArray.length;
    int[] newArray = new int[len+1];
    System.arraycopy(oldArray, 0, newArray, 0, len);
    newArray[len] = item;

    return newArray;
}
   
  
    
    
    
}
