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
public class TestServiceConImpl implements TestServiceController{

    private String URL ="https://httpbin.org/user-agent";
            
    @Override
    public String getResponse(String data) {
        return data+" test response from controller :)";
    }

    @Override
    public void setDDOSCount(int count, String ipAddress, String hostName) {
        HostCalculator.appendHost(count, ipAddress,hostName);
    }

    @Override
    public String getClientInfo() {
        String cInfo="";
        String[] HNs=HostCalculator.getHostNames().toArray(new String[0]);
        String[] IPs=HostCalculator.getIPs().toArray(new String[0]);
        int[] getCount=HostCalculator.getGetCount();
        
        if(IPs.length>0 && IPs.length == getCount.length && IPs.length == HNs.length){
        for(int i = 0; i< getCount.length; i++){
        cInfo+=IPs[i]+" ("+HNs[i]+") "+ " >> has "+getCount[i]+"\n";
        }
        }
        
        return  cInfo;
    }

    @Override
    public int getNumofDDOSToBeExcecuted(String ipAddress) {
       return HostCalculator.calculateTheCountForThisBot(ipAddress);
    }

    @Override
    public void setProposedDDOSCount(int count) {
        HostCalculator.setProposedDDOSCount(count);
    }

    @Override
    public boolean isProposedDDOSCountSet() {
        return (HostCalculator.getProposedDDOSCount()!=0);
    }

    @Override
    public void sendGetDone(int count, String ipAddress, String hostName) {
        HostRewardCalculator.setRewardStatusText(count, ipAddress, hostName);
    }

    @Override
    public String getRewardsStatusText() {
        return HostRewardCalculator.getMainServerRewardsText();
    }

 

    
    
    
    
}
