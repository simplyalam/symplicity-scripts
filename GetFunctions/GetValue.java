import java.util.*;

public class GetValue {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
			String s = scan.nextLine();
			int x = s.indexOf('\"');
			String z = s.substring(x + 1, s.length());
			int y = z.indexOf('\"') + x;
			System.out.println(s.substring(x + 1, y + 1));
		}
	}
}