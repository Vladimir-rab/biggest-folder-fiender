import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String folderPath = "C:/Users/Admin/Desktop/ultrazvuk";
        File file = new File(folderPath);

        System.out.println(getFolderSize(file));


    }

    public static long getFolderSize(File folder) {
        if (folder.isFile()) {
            return folder.length();
        }
        File[] files = folder.listFiles();
        if (files == null) {
            return 0;
        }
        return Arrays.stream(files).mapToLong(file -> getFolderSize(file)).sum();


    }
}