package com.zilker.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class ReadFromPropertiesFile {
///////////call this method from jsp
public static String getProperties(String key) throws IOException
{
InputStream inputStream=ReadFromPropertiesFile.class.getClassLoader().getResourceAsStream("code.properties");
Properties myproperties = new Properties();
/////////////load the properties file
myproperties.load(inputStream);
return myproperties.getProperty(key);
}
}