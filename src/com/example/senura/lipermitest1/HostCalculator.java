/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.senura.lipermitest1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 *
 * @author senura
 */
public class HostCalculator {
    
    private static int [] GETCount= {};
    private static List<String> ipAdresses = new ArrayList<String>();
    private static List<String> hostNames = new ArrayList<String>();
    
    
    private static int proposedDDOSCount=0;

    public static void appendHost(int count, String ipAddress,String hostName){
        GETCount=arrayIntPush(count, GETCount);
        ipAdresses.add(ipAddress);
        hostNames.add(hostName);
        
        System.out.println("array Ipcount"+Arrays.toString(ipAdresses.toArray()));
        System.out.println("array Hcount"+Arrays.toString(hostNames.toArray()));
        System.out.println("array Gcount"+Arrays.toString(GETCount));
        
        
    }
    
    
    public static int [] getGetCount(){
    return GETCount;
    }
    
    
    public static List<String> getIPs(){
    return ipAdresses;
    }
    
    public static List<String> getHostNames(){
    return hostNames;
    }
    
    //when server is down
    public static void resetTheBotStatus(){
            GETCount=new int[]{};
            ipAdresses.clear();
            hostNames.clear();
            proposedDDOSCount=0;
    }
    
    public static void setProposedDDOSCount(int count){
    proposedDDOSCount=count;
    }
    
    public static int getProposedDDOSCount(){
    return proposedDDOSCount;
    }
    
    
    
    
    private static int[] arrayIntPush(int item, int[] oldArray) {
    int len = oldArray.length;
    int[] newArray = new int[len+1];
    System.arraycopy(oldArray, 0, newArray, 0, len);
    newArray[len] = item;

    return newArray;
}
    
    public static int getTheIndexOfHost(String ipAdrs){
        return ipAdresses.indexOf(ipAdrs);
    }
    
    public static int calculateTheCountForThisBot(String ipAdrs){
        
        float getCount =GETCount[getTheIndexOfHost(ipAdrs)];
      
        float totalSumofGetsFromClients=IntStream.of(GETCount).sum();
        
        System.out.println("index of host = "+getTheIndexOfHost(ipAdrs));
        System.out.println(" proposed ddos count = "+proposedDDOSCount);
        System.out.println(" total sum of gets from clients= "+totalSumofGetsFromClients);
        System.out.println(" get count = "+getCount);
        
        
        if(proposedDDOSCount==0) return 0;
        else
        {
            if(proposedDDOSCount<getCount){
                    proposedDDOSCount = Math.round(getCount); 
            }
            return Math.round((proposedDDOSCount/totalSumofGetsFromClients)*getCount);
        
        }
        
        
    }
   
  
    
    
    
}
