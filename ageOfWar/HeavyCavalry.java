package ageOfWar;

import java.util.ArrayList;
import java.util.List;

public class HeavyCavalry implements Soldier {

	@Override
	public List<String> getOtherSoldierClass() {
		List<String> soldierList = new ArrayList<String>();
		soldierList.add("MILITIA");
		soldierList.add("FOOTARCHER");
		soldierList.add("LIGHTCAVALRY");
		return soldierList ;
	}


}
