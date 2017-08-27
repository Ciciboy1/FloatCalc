package com.ciciboy.base;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.WeakHashMap;

public class PropertyManager {

    Properties props;
    File file;
    private static final Map<String, String> defaults = new HashMap<String, String>(){
        {
            put("Design", "Metal");
            put("Language", "English");
        }
    };


    public PropertyManager(File propFile) {
        this.props = new Properties();
        try {
            propFile.getParentFile().mkdirs();
            propFile.createNewFile();
        }catch(Exception ex){ }
        file = propFile;
    }

    public void writeProperty(String key, String value) {
        OutputStream out = null;
        try {
            out = new FileOutputStream(file);
            props.setProperty(key, value);
            props.store(out, null);
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String readProperty(String key){
        InputStream input = null;
        String property = null;
        try {
            input = new FileInputStream(file);

            props.load(input);

            property = props.getProperty(key);
            if(property == null){
                writeDefaultProps(key);
            }
            property = props.getProperty(key);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return property;
    }

    private void writeDefaultProps(String key){
        writeProperty(key, defaults.get(key));
    }

}
