/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.senura.lipermitest1;

/**
 *
 * @author senura
 */
public class HostRewardCalculator {
    
    private static final float rewardAmountPerGet=0.01f;
    private static String mainServerRewardsStatusText="";
    
    private static float totalRewardObtained(int count){
    return rewardAmountPerGet*count;
    }
    
    public static void setRewardStatusText(int count, String ipAddress, String hostName){
        mainServerRewardsStatusText+=ipAddress+" ("+hostName+")"+" obtained "+totalRewardObtained(count)+"$\n";
    }
    
    public static String getMainServerRewardsText(){
    return mainServerRewardsStatusText;
    }
    
    public static void clearMainServerRewardsText(){
    mainServerRewardsStatusText="";
    }
    
    
    
}
