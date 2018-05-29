// Assignment #: 8
//         Name: Michael Pardi
//    StudentID: 1201659320
//      Lecture: TTh 4:30-5:45
//  Description: Sorts the objects using insertion sort.

import java.util.ArrayList;
import java.util.Comparator;

public class Sorts {
	//JUnit
	public static void insertionSort(ArrayList<Athlete> objects, Comparator<Athlete> a) {
		for(int i = 1; i < objects.size(); i++) {
			Athlete key = objects.get(i);
			int position = i;
			while(position > 0 && a.compare(objects.get(position - 1), key) == 1) {
				objects.set(position, objects.get(position - 1));
				position--;
			}
			objects.set(position, key);
		}
	}
}
