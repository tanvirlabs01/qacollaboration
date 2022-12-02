package com.qacollaboration.utils;

import com.qacollaboration.enums.ConfigProperties;
import com.qacollaboration.exceptions.InvalidPathForPropertiesFileException;
import com.qacollaboration.exceptions.PropertiesFileUsageException;
import com.qacollaboration.frameworkconstants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class PropertiesUtil {
    private PropertiesUtil() {
    }
    private static Properties properties = new Properties();
    private static final Map<String, String> CONFIGMAP = new HashMap<>();
    static {
        try(FileInputStream file = new FileInputStream(FrameworkConstants.getConfigFilePath()))
        {
            properties.load(file);
            properties.entrySet().forEach(entry -> CONFIGMAP.put(entry.getKey().toString(),entry.getValue().toString().trim()));
        }
        catch(IOException e)
        {
            throw new InvalidPathForPropertiesFileException("Please check the path of the config file");
            //exit(0);
        }

    }
    public static String get(ConfigProperties key) {
        if(Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase())))
        {
            throw new PropertiesFileUsageException("Property not found "+key+". Please check config.properties");
        }
        return CONFIGMAP.get(key.name().toLowerCase());
    }
}
