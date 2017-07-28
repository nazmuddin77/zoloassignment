package mavliwala.nazmuddin.data.network;

import java.io.File;

/**
 * Created by nazmuddinmavliwala on 13/01/17.
 */
public class MultiPartObject {

    private final String key;
    private final File file;

    public MultiPartObject(String key, File file) {
        this.key = key;
        this.file = file;
    }

    public String getKey() {
        return key;
    }

    public File getFile() {
        return file;
    }
}
