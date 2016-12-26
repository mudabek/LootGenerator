import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Treasure {
	Map<String, ArrayList<String>> treasures;

	/**
	 * treasure constructor that parses file into hashMap
	 * @param file with treasure names
	 * @throws IOException
	 */
	public Treasure(File file) throws IOException {
		treasures = new HashMap<String, ArrayList<String>>();

		Scanner in = new Scanner(file);
		while (in.hasNextLine()) {
			String[] columns = in.nextLine().split("\t");
			ArrayList<String> items = new ArrayList<String>();
			for (int i = 0; i < 3; i++) {
				items.add(i, columns[i + 1]);
			}
			treasures.put(columns[0], items);
		}
		in.close();
	}

	/**
	 * recursively picks a definitive defensive item
	 * @param TC, monster's treasure
	 * @return finalItem, final defensive item
	 */
	public String getItem(String TC) {
		String finalItem = TC;
		while (treasures.containsKey(finalItem)) {
			ArrayList<String> items = treasures.get(finalItem);
			Random rand = new Random();
			int n = rand.nextInt(3);
			finalItem = getItem(items.get(n));
		}
		return finalItem;
	}
}