package helper;

import java.io.File;

public class Common {
    public static String getProjectPath() {
        return System.getProperty("user.dir");
    }

    public static File readFile(String path) {
        File file = new File(path);
        if (file.exists()) {
            return file;
        }
        return null;
    }

}
