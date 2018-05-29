// Assignment #: 8
//         Name: Michael Pardi
//    StudentID: 1201659320
//      Lecture: TTh 4:30-5:45
//  Description: Manages all the Athlete object institution into an ArrayList, as well as the sorting aspects of it's parameters.

import java.util.ArrayList;
import java.util.Comparator;

public class AthleteManagement implements java.io.Serializable {
	ArrayList<Athlete> athleteList;
	
	public AthleteManagement() {
		athleteList = new ArrayList<Athlete>();
	}
	
	public int athleteNameExists(String firstName, String lastName) {
		int result = 0;
		
		if(athleteList.size() > 0) {	
			for(int i = 0; i < athleteList.size(); i++) {
				if(firstName.equals(athleteList.get(i).getFirstName()) && lastName.equals(athleteList.get(i).getLastName())) {
					result = i;
				}
				else {
					result = -1;
				}
			}
		}
		else {
			result = -1;
		}
		
		return result;
	}
	
	public int countHowManyAthleteHaveMedals(int medalType) {
		int result = 0;
		
		if(athleteList.size() > 0) {
			
			if(medalType == 0) {	
				for(int i = 0; i < athleteList.size(); i++) {
					
					if(athleteList.get(i).getGold() > 0) {
						result++;
					}
				}
			}
			else if(medalType == 1) {
				for(int i = 0; i < athleteList.size(); i++) {
					
					if(athleteList.get(i).getSilver() > 0) {
						result++;
					}
				}
			}
			else if(medalType == 2) {
				for(int i = 0; i < athleteList.size(); i++) {
					
					if(athleteList.get(i).getBronze() > 0) {
						result++;
					}
				}
			}
		}
		
		return result;
	}
	
	public boolean addAthlete(String firstName, String lastName, String sport, int gold, int silver, int bronze) {
		boolean result;
		int num = athleteNameExists(firstName, lastName);
		
		Athlete a = new Athlete();
		
		if(athleteList.size() > 0) {
			if(num == -1) {
				a.setFirstName(firstName);
				a.setLastName(lastName);
				a.setSport(sport);
				a.setGold(gold);
				a.setSilver(silver);
				a.setBronze(bronze);
				
				athleteList.add(a);
				
				result = true;
			}
			else {
				result = false;
			}
		}
		else {
			a.setFirstName(firstName);
			a.setLastName(lastName);
			a.setSport(sport);
			a.setGold(gold);
			a.setSilver(silver);
			a.setBronze(bronze);
			
			athleteList.add(a);
			
			result = true;
		}
		
		return result;
	}
	
	public boolean removeAthleteByName(String firstName, String lastName) {
		boolean result;
		int num = athleteNameExists(firstName, lastName);
		
		if(athleteList.size() > 0) {
			if(num == -1) {
				result = false;
			}
			else {
				athleteList.remove(num);
				result = true;
			}
		}
		else {
			result = false;
		}
		
		return result;
	}
	
	public void sortByAthleteNames() {
		AthleteNameComparator a = new AthleteNameComparator();
		Sorts.insertionSort(athleteList, a);
	}
	
	public void sortByMedalCounts() {
		MedalCountComparator m = new MedalCountComparator();
		Sorts.insertionSort(athleteList, m);
	}
	
	public String listAthletes() {
		String result = "";
		
		return result;
	}
	
	public void closeAthleteManagement() {
		
	}
}
