package ageOfWar;

import java.util.ArrayList;
import java.util.List;

public class FootArcher implements Soldier {

	@Override
	public List<String> getOtherSoldierClass() {
		List<String> soldierList = new ArrayList<String>();
		soldierList.add("MILITIA");
		soldierList.add("CAVALRYARCHER");
		return soldierList ;
	}


}
