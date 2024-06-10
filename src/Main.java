import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        String folderPath = "C:/Users/Admin/Desktop/ultrazvuk";
        File file = new File(folderPath);
        long start = System.currentTimeMillis();

        FolderSizeCalculator calculator = new FolderSizeCalculator(file);
        ForkJoinPool pool = new ForkJoinPool();
        long size = pool.invoke(calculator);
        System.out.println(size);

        //System.out.println(getFolderSize(file));

        long duration = (System.currentTimeMillis() - start);
        System.out.println(duration + " ms");


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