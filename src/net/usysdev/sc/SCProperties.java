package net.usysdev.sc;

import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Properties;


/**
 * 常駐スクリーンキャプチャ。
 */
public final class SCProperties {

    public static final String PROPNAME_SAVE_FOLDER = "save.folder";

    public static final String PROP_FILENAME = "sc.properties";

    private final Properties properties = new Properties();


    public SCProperties() throws IOException {

        if (!new File(PROP_FILENAME).isFile()) {
            return;
        }

        boolean bCompleted = false;
        final InputStreamReader reader = new InputStreamReader(new FileInputStream(PROP_FILENAME), "UTF-8");
        try {
            properties.load(reader);
            bCompleted = true;
        } finally {
            if (bCompleted) {
                reader.close();
            } else {
                try {
                    reader.close();
                } catch (IOException __ignore__) {}
            }
        }
    }


    public String getSaveFolder() {
        final String folderName = properties.getProperty(PROPNAME_SAVE_FOLDER);
        if (folderName != null) {
            return folderName;
        }
        return System.getProperty("user.dir");
    }


    public void setSaveFolder(String folderName) throws IOException {

        properties.setProperty(PROPNAME_SAVE_FOLDER, folderName);

        boolean bCompleted = false;
        final OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(PROP_FILENAME, false), "UTF-8");
        try {
            properties.store(writer, null);
            bCompleted = true;
        } finally {
            if (bCompleted) {
                writer.close();
            } else {
                try {
                    writer.close();
                } catch (IOException __ignore__) {}
            }
        }
    }
}
