/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.senura.lipermitest1;

import java.net.MalformedURLException;
import java.net.URL;


/**
 *
 * @author senura
 */
public class URLValidate {
    
    
    
    public static boolean isUrlValid(String urlToRead) {
      URL url;
        
        try {
            url = new URL(urlToRead);
        } catch (MalformedURLException ex) {
            return false;
        }
        
      return true;
   }
    
    
    
}
