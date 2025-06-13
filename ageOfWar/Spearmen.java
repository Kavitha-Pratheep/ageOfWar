package ageOfWar;

import java.util.ArrayList;
import java.util.List;

public class Spearmen implements Soldier {

	@Override
	public List<String> getOtherSoldierClass() {
		List<String> soldierList = new ArrayList<String>();
		soldierList.add("HEAVYCAVALRY");
		soldierList.add("LIGHTCAVALRY");
		return soldierList ;
	}


}
