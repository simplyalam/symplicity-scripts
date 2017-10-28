import java.util.*;
import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.Charset;

public class RecomGenerator {
	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(new File("student.txt"));
			
			final String EoL = System.getProperty("line.separator");
			List<String> lines = Files.readAllLines(Paths.get("recom.txt"),
					Charset.defaultCharset());

			StringBuilder sb = new StringBuilder();
			for (String line : lines) {
				sb.append(line).append(EoL);
			}
			String recom = sb.toString();
			System.out.println(recom);
			
			while (scan.hasNext()) {
				String name = scan.next();
				String gender = scan.next();
				System.out.println(name);
				PrintWriter write = new PrintWriter(new File(name + ".txt"));
				String temp = recom;
				if (gender.equals("Male")) {
					temp = temp.replaceAll("Name", name);
					temp = temp.replaceAll("His/Her", "His");
					temp = temp.replaceAll("He/She", "He");
					temp = temp.replaceAll("his/her", "his");
					System.out.println(temp);
					write.print(temp);
				} else {
					temp = temp.replaceAll("Name", name);
					temp = temp.replaceAll("His/Her", "Her");
					temp = temp.replaceAll("He/She", "She");
					temp = temp.replaceAll("his/her", "her");
					write.print(temp);
				}
				write.close();
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}