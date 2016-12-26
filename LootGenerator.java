import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LootGenerator {

	public static void main(String[] args) throws IOException {

		// Parses files appropriately
		Monster monsters = new Monster(new File("monstats.txt"));
		Treasure treasures = new Treasure(new File("TreasureClassEx.txt"));
		Defense defenses = new Defense(new File("armor.txt"));
		Affixes prefixes = new Affixes(new File("MagicPrefix.txt"));
		Affixes suffixes = new Affixes(new File("MagicSuffix.txt"));

		Scanner in = new Scanner(System.in);
		boolean shouldContinue = true;
		while (shouldContinue) {

			// Stores appropriate variables to print
			String randMonster = monsters.pickMonster();
			String TC = monsters.monsterTC(randMonster);
			String pickedTC = treasures.getItem(TC);
			int defVal = defenses.valDefense(pickedTC);
			boolean includePref = prefixes.pickAffix();
			boolean includeSuff = suffixes.pickAffix();

			// Print out the monster the user is fighting
			System.out.printf("Fighting ");
			System.out.println(randMonster);
			System.out.printf("You have slain ");
			System.out.println(randMonster + "!");
			System.out.printf(randMonster);
			System.out.println(" dropped:");
			System.out.println("");

			// Prints out items, defenses, and affixes if chosen
			if (includePref && includeSuff) {
				int randNumb = prefixes.randPick(prefixes.names);
				String prefix = prefixes.affName(randNumb);
				String codePref = prefixes.codeName(randNumb);
				int armorPref = prefixes.armorVal(randNumb);

				int randNumb2 = suffixes.randPick(suffixes.names);
				String suffix = suffixes.affName(randNumb2);
				String codeSuff = suffixes.codeName(randNumb2);
				int armorSuff = suffixes.armorVal(randNumb2);
				System.out.printf(prefix + " ");
				System.out.printf(pickedTC + " ");
				System.out.println(suffix);
				System.out.printf("Defense: ");
				System.out.println(defVal);
				System.out.print(armorPref + " ");
				System.out.println(codePref);
				System.out.print(armorSuff + " ");
				System.out.println(codeSuff);
			} else if (includePref) {
				int randNumb = prefixes.randPick(prefixes.names);
				String prefix = prefixes.affName(randNumb);
				String codePref = prefixes.codeName(randNumb);
				int armorPref = prefixes.armorVal(randNumb);
				System.out.printf(prefix + " ");
				System.out.println(pickedTC);
				System.out.printf("Defense: ");
				System.out.println(defVal);
				System.out.print(armorPref + " ");
				System.out.println(codePref);
			} else if (includeSuff) {
				int randNumb = suffixes.randPick(suffixes.names);
				String suffix = suffixes.affName(randNumb);
				String codeSuff = suffixes.codeName(randNumb);
				int armorSuff = suffixes.armorVal(randNumb);
				System.out.printf(pickedTC + " ");
				System.out.println(suffix);
				System.out.printf("Defense: ");
				System.out.println(defVal);
				System.out.print(armorSuff + " ");
				System.out.println(codeSuff);
			} else {
				System.out.println(pickedTC);
				System.out.printf("Defense: ");
				System.out.println(defVal);
			}

			// Prompts user whether to continue or not
			System.out.println("Fight again [y/n]?");
			if (in.nextLine().equalsIgnoreCase("n")) {
				shouldContinue = false;
			}
		}
		in.close();
	}
}