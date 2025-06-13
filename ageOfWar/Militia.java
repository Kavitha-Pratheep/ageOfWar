package ageOfWar;

import java.util.ArrayList;
import java.util.List;

public class Militia implements Soldier {
	
	@Override
	public List<String> getOtherSoldierClass() {
		List<String> soldierList = new ArrayList<String>();
		soldierList.add("SPEARMEN");
		soldierList.add("LIGHTCAVALRY");
		return soldierList ;
	}

}
