// Assignment #: 8
//         Name: Michael Pardi
//    StudentID: 1201659320
//      Lecture: TTh 4:30-5:45
//  Description: The class Athlete represents an athlete with 
//  their information.

public class AthleteNameComparator implements java.util.Comparator<Athlete>{
	public int compare(Athlete first, Athlete second) {
		int result;
		int compare = first.getLastName().compareTo(second.getLastName());
		
		if(compare < 0) {
			result = -1;
		}
		else if(compare == 0) {
			compare = first.getFirstName().compareTo(second.getFirstName());
			
			if(compare < 0) {
				result = -1;
			}
			else if(compare == 0) {
				result = 0;
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
