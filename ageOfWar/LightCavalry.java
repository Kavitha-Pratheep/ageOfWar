package ageOfWar;

import java.util.ArrayList;
import java.util.List;

public class LightCavalry implements Soldier {

	@Override
	public List<String> getOtherSoldierClass() {
		List<String> soldierList = new ArrayList<String>();
		soldierList.add("FOOTARCHER");
		soldierList.add("CAVALRYARCHER");
		return soldierList ;
	}


}
