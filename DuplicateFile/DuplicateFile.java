0import java.io.*;
import java.util.*;

public class DuplicateFile {
	public static void main(String[] args) {
		// Name of the original file.
		String filename = args[0];
		
		// The number of copies to be made.
		int max = Integer.parseInt(args[1]);
		
		// The extension of the file is retrieved.
		String extension = filename.substring(filename.lastIndexOf("."), filename.length());
		
		int num = 1;
		while(num <= max){
			// New files are formatted like "0000001".
			String x = String.format("%07d", num);
			try {
				copyFileUsingStream(new File(filename), new File(x + extension));
			}
			catch(Exception e){
				e.printStackTrace();
			}
			num++;
		}
	}
	private static void copyFileUsingStream(File source, File dest) throws IOException {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(source);
			os = new FileOutputStream(dest);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
		} finally {
			is.close();
			os.close();
		}
	}
}