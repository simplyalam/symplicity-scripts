import java.util.*;

public class GetHeader {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
			String s = scan.nextLine();
			int x = s.indexOf('>');
			int y = s.lastIndexOf('<');
			System.out.println(s.substring(x+1, y));
		}
	}
}