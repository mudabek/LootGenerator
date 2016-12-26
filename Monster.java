import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Monster {
	Map<String, String> monster;
	
	/**
	 * monster constructor that parses file into hashMap
	 * @param file with monster names
	 * @throws IOException
	 */
	public Monster(File file) throws IOException {
		monster = new HashMap<String, String>();

		Scanner in = new Scanner(file);
		while (in.hasNextLine()) {
			String[] columns = in.nextLine().split("\t");
			monster.put(columns[0], columns[3]);
		}
		in.close();
	}
	
	/**
	 * Picks a random monster
	 * @return randomMonster
	 */
	public String pickMonster() {
		Random random = new Random();
		List<String> monsters = new ArrayList<String>(monster.keySet());
		String randomMonster = monsters.get(random.nextInt(monsters.size()));
		return randomMonster;
	}

	/**
	 * gives a monster specific treasure
	 * @param randomMonster
	 * @return TC, treasure
	 */
	public String monsterTC(String randomMonster) {
		String TC = monster.get(randomMonster);
		return TC;
	}
}