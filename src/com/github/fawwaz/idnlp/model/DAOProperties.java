/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.fawwaz.idnlp.model;

import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;
/**
 *
 * @author Asus
 */
public class DAOProperties {
    // --- Constant ---
    private static final String PROPERTIES_FILE = "dao.properties";
    private static final Properties PROPERTIES = new Properties();
    
    static{
        ClassLoader classLoader     = Thread.currentThread().getContextClassLoader();
        InputStream propertiesfile  = classLoader.getResourceAsStream(PROPERTIES_FILE);
        
        if(propertiesfile==null){
            throw(new DAOConfigurationException("Properties file '"+PROPERTIES_FILE+"' is missing from classpath."));
        }
        
        try{
            PROPERTIES.load(propertiesfile);
        }catch (IOException e){
            throw(new DAOConfigurationException("Cannot load properties file '"+PROPERTIES_FILE+"'.",e));
        }
    }
    
    // --- vars ---
    private String specifickey;
    
    // --- Constructor ---
    public DAOProperties(String specifickey) throws DAOConfigurationException{
        this.specifickey = specifickey;
    }
    
    // --- actions ---
    public String getProperty(String key,boolean mandatory) throws DAOConfigurationException{
        String fullkey      = specifickey + "." + key;
        String property     = PROPERTIES.getProperty(fullkey);
        
        if(property == null || property.trim().length() == 0){
            if(mandatory){
                throw(new DAOConfigurationException("Required property '" + fullkey + "'"+ " is missing in properties file '" + PROPERTIES_FILE + "'."));
            }else{
                property = null;
            }
        }
        
        return property;
    }
}
