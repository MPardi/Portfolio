// Assignment #: 8
//         Name: Michael Pardi
//    StudentID: 1201659320
//      Lecture: TTh 4:30-5:45
//  Description: The class Athlete represents an athlete with 
//  their information.

public class MedalCountComparator implements java.util.Comparator<Athlete> {
	public int compare(Athlete first, Athlete second) {
		int result;
		
		if(first.getGold() > second.getGold()) {
			result = -1;
		}
		else if(first.getGold() == second.getGold()) {
			
			if(first.getSilver() > second.getSilver()) {
				result = -1;
			}
			else if(first.getSilver() == second.getSilver()) {
				
				if(first.getBronze() > second.getBronze()) {
					result = -1;
				}
				else if(first.getBronze() == second.getBronze()) {
					result = 0;
				}
				else {
					result = 1;
				}
			}
			else {
				result = 1;
			}
		}
		else {
			result = 1;
		}
		
		return result;
	}
}
