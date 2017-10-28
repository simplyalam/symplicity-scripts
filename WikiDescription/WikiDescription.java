import java.net.URL;
import java.io.*;
import java.util.*;

public class WikiDescription {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String query = "https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro=&explaintext=&titles=";
		while (scan.hasNextLine()) {
			String s = scan.nextLine();
			try {
				URL page = new URL(query + s);
				BufferedReader in = new BufferedReader(new InputStreamReader(page.openStream()));
				String inputLine = in.readLine();
				in.close();
				StringBuilder cut = new StringBuilder(inputLine);
				int start = cut.indexOf("\"extract\":\"");
				int end = cut.lastIndexOf("}}}}");
				String done = cut.substring(start + 11,end - 1);
				if (done.substring(0, 1).equals("p") || done.substring(0, 1).equals("\"")) {
					System.out.println("");
				} else {
					System.out.println(done);
				}
			}
			catch (Exception e) {
				e.printStackTrace();
				continue;
			}
		}
	}
}