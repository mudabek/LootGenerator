import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Affixes {

	ArrayList<String> names;
	ArrayList<String> codes;
	ArrayList<Integer> mins;
	ArrayList<Integer> maxs;

	/**
	 * affixes constructor that parses file into ArrayLists
	 * @param file with affixes names
	 * @throws IOException
	 */
	public Affixes(File file) throws IOException {
		names = new ArrayList<String>();
		codes = new ArrayList<String>();
		mins = new ArrayList<Integer>();
		maxs = new ArrayList<Integer>();

		Scanner in = new Scanner(file);
		while (in.hasNextLine()) {
			String[] columns = in.nextLine().split("\t");
			names.add(columns[0]);
			codes.add(columns[1]);
			mins.add(Integer.parseInt(columns[2]));
			maxs.add(Integer.parseInt(columns[3]));
		}
		in.close();
	}

	/**
	 * pick a random index from affix ArrayLists
	 * @param names, ArrayList of affixes
	 * @return randNumb, index from ArrayLists
	 */
	public int randPick(ArrayList<String> names) {
		Random random = new Random();
		int randNumb = random.nextInt(names.size());
		return randNumb;
	}

	/**
	 * gives a name of the affix we randomly picked
	 * @param numb, randomly generated index
	 * @return name, name of the affix chosen
	 */
	public String affName(int numb) {
		return names.get(numb);
	}

	/**
	 * gives a name of the code of the affix we randomly picked
	 * @param numb, randomly generated index
	 * @return code, name of the code chosen
	 */
	public String codeName(int numb) {
		return codes.get(numb);
	}

	/**
	 * gives a random val between min and max for the given code 
	 * @param numb, randomly generated index
	 * @return randNumb, the random defense val we picked
	 */
	public int armorVal(int numb) {
		int min = mins.get(numb);
		int max = maxs.get(numb);
		Random random = new Random();
		int randNumb = random.nextInt(max - min + 1) + min;
		return randNumb;
	}
	
	/**
	 * decides whether we have affixes or not
	 * @return true, if we pick affix
	 */
	public boolean pickAffix () {
		Random random = new Random();
		int randNumb = random.nextInt(2);
		if (randNumb == 0) {
			return true;
		} else {
			return false;
		}
	}
}