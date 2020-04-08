package libs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigClass {

    public static String cfgFile = "src/config.properties";

    public static String getValuesFromFile(String key, String filename) throws IOException{
        Properties p = new Properties();
        FileInputStream cfg = new FileInputStream(filename);
        p.load(cfg);
        cfg.close();
        return (p.getProperty(key));
    }

    public static String getCfgValue(String key) throws IOException{
        return getValuesFromFile(key,cfgFile);
    }
}
