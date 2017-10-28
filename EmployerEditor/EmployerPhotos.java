import java.io.*;
import java.util.*;


public class EmployerPhotos {
	public static void main(String[] args) {
		File folder = new File("C:\\Users\\alam\\Desktop\\photos");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
		  if (listOfFiles[i].isFile()) {
			System.out.println("File " + listOfFiles[i].getName());
		  } else if (listOfFiles[i].isDirectory()) {
			System.out.println("Directory " + listOfFiles[i].getName());
		  }
		}
		int n = 1;
		for (File file : listOfFiles) {

			// File (or directory) with new name
			File file2 = new File("C:\\Users\\alam\\Desktop\\photos\\" + n + ".jpg");

			// Rename file (or directory)
			boolean success = file.renameTo(file2);

			if (!success) {
			   System.out.println("FAIL");
			}
			n++;
		}
	}
}