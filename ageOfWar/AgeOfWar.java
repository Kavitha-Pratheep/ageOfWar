package ageOfWar;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class AgeOfWar {

	public static void main(String[] args) {
		Scanner scannerInput = new Scanner(System.in);
		System.out.println("Please enter the platoon details: ");
		String ownPlatoon = scannerInput.hasNextLine() ? scannerInput.nextLine() : "";
		String opponentPlatoon = scannerInput.hasNextLine() ? scannerInput.nextLine() : "";
		if (ownPlatoon.equals("") || opponentPlatoon.equals("")) {
			System.out.println("Required details are not there.Please try again.");
		} else {
			String[] ownPlatoonArray = ownPlatoon.split(";");
			String[] opponentPlatoonArray = opponentPlatoon.split(";");
			AtomicInteger winCount = new AtomicInteger(0);
			Map<String, Integer> arrangementMap = new LinkedHashMap<String, Integer>();
			Map<String, Integer> opponentArrangementMap = new LinkedHashMap<String, Integer>();
			if (ownPlatoonArray.length == 5 && ownPlatoonArray.length == opponentPlatoonArray.length) {
				Map<String, Integer> ownPlatoonMap = getPlatoonDetails(ownPlatoonArray);
				Map<String, Integer> otherPlatoonMap = getPlatoonDetails(opponentPlatoonArray);
				otherPlatoonMap.forEach((key, value) -> {
					if (ownPlatoonMap.containsKey(key) && !arrangementMap.containsKey(key)) {
						Integer myCount = ownPlatoonMap.get(key);
						int compareValue = myCount.compareTo(value);
						if (compareValue > 0) {
							winCount.incrementAndGet();
							arrangementMap.put(key, myCount);
							opponentArrangementMap.put(key, value);
						} else {
							List<String> soldiersList = getLowerSoldierClass(key);
							for (String soldier : soldiersList) {
								if (ownPlatoonMap.containsKey(soldier) && !arrangementMap.containsKey(soldier)) {
									myCount = ownPlatoonMap.get(soldier);
									compareValue = myCount.compareTo(value * 2);
									if (compareValue > 0) {
										winCount.incrementAndGet();
										arrangementMap.put(soldier, myCount);
										opponentArrangementMap.put(key, value);
										break;
									}
								}
							}
						}
					}
				});
				ownPlatoonMap.keySet().stream().filter(key -> !arrangementMap.containsKey(key)).forEach(key -> {
					arrangementMap.put(key, ownPlatoonMap.get(key));
				});
				otherPlatoonMap.keySet().stream().filter(key -> !opponentArrangementMap.containsKey(key))
						.forEach(key -> {
							opponentArrangementMap.put(key, otherPlatoonMap.get(key));
						});
				if (winCount.get() >= 3) {
					System.out.println("Own Platoon");
					arrangementMap.forEach((key, value) -> {
						System.out.println(key + "#" + value);
					});
					System.out.println();
					System.out.println("Opponent Platoon");
					opponentArrangementMap.forEach((key, value) -> {
						System.out.println(key + "#" + value);
					});
				} else {
					System.out.println("There is no chance of winning");
				}
			} else {
				System.out.println("Try to enter input in the format PLATOON#COUNT; for 5 times in a single line");
			}
		}

	}

	private static Map<String, Integer> getPlatoonDetails(String[] ownPlatoonArray) {
		Map<String, Integer> platoonDetailsMap = new LinkedHashMap<String, Integer>();
		for (String platoon : ownPlatoonArray) {
			String[] details = platoon.split("#");
			platoonDetailsMap.put(details[0].toUpperCase(), Integer.parseInt(details[1]));
		}
		return platoonDetailsMap;
	}

	private static List<String> getLowerSoldierClass(String className) {
		Soldier soldier;
		switch (className) {
			case "MILITIA": {
				soldier = new Militia();
				return soldier.getOtherSoldierClass();
			}
			case "SPEARMEN": {
				soldier = new Spearmen();
				return soldier.getOtherSoldierClass();
			}
			case "LIGHTCAVALRY": {
				soldier = new LightCavalry();
				return soldier.getOtherSoldierClass();
			}
			case "HEAVYCAVALRY": {
				soldier = new HeavyCavalry();
				return soldier.getOtherSoldierClass();
			}
			case "FOOTARCHER": {
				soldier = new FootArcher();
				return soldier.getOtherSoldierClass();
			}
			case "CAVALRYARCHER": {
				soldier = new CavalryArcher();
				return soldier.getOtherSoldierClass();
			}
		}
		return new ArrayList<String>();
	}
}
