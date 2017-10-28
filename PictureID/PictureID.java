import java.io.*;
import java.util.*;


public class PictureID {
	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(new File("genderID.txt"));
			int m = 1;
			int f = 1;
			
			while(scan.hasNext()) {
				String id = String.format("%07d", scan.nextInt());
				String gender = scan.next();
				
				if (gender.equals("Male")) {
					copyFileUsingStream(new File("C:\\Users\\alam\\Desktop\\demo_csm_data\\photos\\male\\" + m + ".jpg"), new File(id + ".jpg"));
					System.out.println("Copying " + m + ".jpg" + " to " + id + ".jpg");
					if (m == 13) {
						m = 0;
					}
					m++;
				} else {
					copyFileUsingStream(new File("C:\\Users\\alam\\Desktop\\demo_csm_data\\photos\\female\\" + f + ".jpg"), new File(id + ".jpg"));
					System.out.println("Copying " + f + ".jpg" + " to " + id + ".jpg");
					if (f == 12) {
						f = 0;
					}
					f++;
				}
			}
			scan.close();
		}
		catch (Exception e) {
			System.out.println("Error:");
			System.out.println(e);
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