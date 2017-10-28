import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.zip.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.nio.file.Files;

public class ZipFiles {

	public static void main(String[] args) {

		try {
			String filename = args[0];
			int from = 1;
			int to = Integer.parseInt(args[1]);
			Scanner scan = new Scanner(new File(filename));
			
			// The extension of the file is retrieved.
			String extension = filename.substring(filename.lastIndexOf("."), filename.length());
			
			while(t <= 5000) {
				FileOutputStream fos = new FileOutputStream("transcript" + f + "to" + t + ".zip");
				ZipOutputStream zos = new ZipOutputStream(fos);
				
				for(int i = 0; i < 500; i++) {
					String file = scan.next() + extension;
					scan.next();
					addToZipFile(file, zos);
				}
				System.out.println("Continue?");
				System.out.println("(Type NO to stop)");
				Scanner reader = new Scanner(System.in);
				String s = reader.nextLine();
				if (s.equals("NO")) {
					break;
				}
				f += from;
				t += to;
				zos.close();
				fos.close();
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void addToZipFile(String fileName, ZipOutputStream zos) throws FileNotFoundException, IOException {

		System.out.println("Writing '" + fileName + "' to zip file");

		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);
		ZipEntry zipEntry = new ZipEntry(fileName);
		zos.putNextEntry(zipEntry);

		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) {
			zos.write(bytes, 0, length);
		}
		zos.closeEntry();
		fis.close();
	}
}