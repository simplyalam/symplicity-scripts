import java.io.*;
import java.util.*;

public class Combinations {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		while(scan.hasNextLine()) {
			list.add(scan.nextLine());
		}
		for (int k = 1; k <= list.size(); k++) {
			combinations2(list.toArray(new String[list.size()]), k, 0, new String[k]);
		}
	}
	static void combinations2(String[] arr, int len, int startPosition, String[] result) {
        if (len == 0) {
			String s = Arrays.toString(result);
            System.out.println(s.substring(1,s.length() - 1));
            return;
        }
        for (int i = startPosition; i <= arr.length-len; i++) {
            result[result.length - len] = arr[i];
            combinations2(arr, len-1, i+1, result);
        }
    }
}