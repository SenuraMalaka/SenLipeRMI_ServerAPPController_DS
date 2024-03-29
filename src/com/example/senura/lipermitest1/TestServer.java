/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.senura.lipermitest1;

import java.io.IOException;
import java.net.Socket;
import net.sf.lipermi.exception.LipeRMIException;
import net.sf.lipermi.handler.CallHandler;
import net.sf.lipermi.net.IServerListener;
import net.sf.lipermi.net.Server;

/**
 *
 * @author senura
 */
public class TestServer {
    
    
    Server server=null;
    IServerListener serverListener1=null;
    CallHandler callHandler=null;
   TestServiceController interfaceImplementation=null;
   private final static String serverAddress="172.20.8.65";//"192.168.1.4";
    
    public TestServer () throws LipeRMIException, IOException {

        System.out.println(TimeClass.getTime()+"Connection Init");
     
            callHandler = new CallHandler(); 
            

            
          interfaceImplementation = new TestServiceConImpl();

        
          callHandler.registerGlobal(TestServiceController.class,
            interfaceImplementation);

          server = new Server();
          int thePortIWantToBind = 58883;
          
          server.bind(thePortIWantToBind, callHandler);
          
          
         System.out.println(TimeClass.getTime()+"Connection Started");
         
         
         
         IServerListener serverListener1=new IServerListener() {

            @Override
            public void clientDisconnected(Socket socket) {
                System.out.println(TimeClass.getTime()+"Bot Disconnected: " + socket.getInetAddress().getHostAddress());
                
                if(socket.getInetAddress().getHostAddress().equals(serverAddress)){
                    HostCalculator.resetTheBotStatus();
                    System.out.println("resetedddddd");
                }
                
            }

            @Override
            public void clientConnected(Socket socket) {
                System.out.println(TimeClass.getTime()+"Bot Connected: " + socket.getInetAddress().getHostAddress());
            }
            
        };
          
          
           server.addServerListener(serverListener1);
          
         
           System.out.println(TimeClass.getTime()+"server running..");
        
          
    
    }
    
    public boolean closeConnection(){
        
        boolean isClosingSuccessful=false;
        
        if(!server.equals(null))
        {
            try{
            server.removeServerListener(serverListener1);
        
            server.close();
            callHandler.exportObject(TestServiceController.class, interfaceImplementation);
            
            isClosingSuccessful=true;
            System.out.println(TimeClass.getTime()+"Server Closed");
            }
            catch(Exception ex)
            {
                isClosingSuccessful=false;
                System.out.println(TimeClass.getTime()+"Connection Close Error - "+ex.getMessage());
            }
        }else{
        isClosingSuccessful=false;
        System.out.println(TimeClass.getTime()+"Server Closing Error - No Server");
        }
        
        return isClosingSuccessful;
    
    }
    
   
    
    
    
    
    
    
}
