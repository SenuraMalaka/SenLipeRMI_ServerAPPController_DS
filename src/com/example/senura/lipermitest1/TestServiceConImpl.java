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
        return data+" hey babe.. from controller :)";
    }

    @Override
    public void setDDOSCount(int count, String ipAddress) {
        HostCalculator.appendHost(count, ipAddress);
    }

    @Override
    public String getClientInfo() {
        String cInfo="";
        String[] IPs=HostCalculator.getIPs().toArray(new String[0]);
        int[] getCount=HostCalculator.getGetCount();
        
        if(IPs.length>0 && IPs.length == getCount.length){
        for(int i = 0; i< getCount.length; i++){
        cInfo+=IPs[i]+" >> has "+getCount[i]+"\n";
        }
        }
        
        return  cInfo;
    }

 

    
    
    
    
}
