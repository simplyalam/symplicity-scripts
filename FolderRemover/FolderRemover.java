import java.util.*;
import java.io.*;

public class FolderRemover {
    public static void main(String[] args) {
        System.out.print("\n\n\n");;
        File folder = new File("C:\\Users\\alamm\\Desktop\\Movies");
        moveDir(folder, folder);
    }

    public static File[] getFiles(File folder) {
        System.out.println("CURRENT DIRECTORY ( " + folder + " )");
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
          if (listOfFiles[i].isFile()) {
            System.out.println("File:      " + listOfFiles[i].getName());
          } else if (listOfFiles[i].isDirectory()) {
            System.out.println("Directory: " + listOfFiles[i].getName());
          }
        }
        System.out.println("");
        return listOfFiles;
    }

    public static void moveDir(File toDir, File curDir) {
        File[] listOfFiles = getFiles(curDir);
        System.out.println("MOVING FILES");
        for (File file : listOfFiles) {
            if (file.isDirectory()) {
                System.out.println("\nCHANGING DIRECTORY\n");
                moveDir(toDir, file);
            } else if (file.getParent().equals(toDir.getPath())) {
                System.out.println("File " + file.getName() + " already in " + toDir);
            } else {
                file.renameTo(new File(toDir, file.getName()));
                System.out.println("Moving " + file.getName() + " to " + toDir);
            }
            if (file.isDirectory()) {
                removeDir(file);
            }
        }
    }
    public static void removeDir(File folder) {
        if (folder.listFiles().length == 0) {
            System.out.println("\nREMOVING DIRECTORY\n" + folder + "\n");
            folder.delete();
        }
    }
}
