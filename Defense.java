import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Defense {

	Map<String, ArrayList<Integer>> defenses = new HashMap<String, ArrayList<Integer>>();

	/**
	 * defense constructor that parses file into hashMap
	 * @param file with defense names
	 * @throws IOException
	 */
	public Defense(File file) throws IOException {
		defenses = new HashMap<String, ArrayList<Integer>>();
		
		Scanner in = new Scanner(file);
		while (in.hasNextLine()) {
			String[] columns = in.nextLine().split("\t");
			ArrayList<Integer> stats = new ArrayList<Integer>();
			for (int i = 0; i < 2; i++) {
				stats.add(i, Integer.parseInt(columns[i + 1]));
			}
			defenses.put(columns[0], stats);
		}
		in.close();
	}

	/**
	 * picks a value for defense in the specific boundary
	 * @param item, armor item 
	 * @return randNumb, value of defense between max and min
	 */
	public int valDefense(String item) {
		ArrayList<Integer> vals = defenses.get(item);
		int min = vals.get(0);
		int max = vals.get(1);
		Random random = new Random();
		int randNumb = random.nextInt(max - min) + min;
		return randNumb;
	}
}