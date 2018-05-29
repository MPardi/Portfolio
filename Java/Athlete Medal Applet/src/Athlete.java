// Assignment #: 6
//         Name: Michael Pardi
//    StudentID: 1201659320
//      Lecture: TTh 4:30-5:45
//  Description: The class Athlete represents an athlete with 
//  their information.

public class Athlete
 {
   private String firstName, lastName;
   private String sport;
   private int gold, silver, bronze;

   //Constructor to initialize all member variables
   public Athlete()
    {
      firstName = "?";
      lastName = "?";
      sport = "?";
      gold = 0;
      silver = 0;
      bronze = 0;
    }

   //Accessor methods
   public String getFirstName()
    {
      return firstName;
    }

   public String getLastName()
    {
      return lastName;
    }

   public String getSport()
    {
      return sport;
    }

   //Mutator methods
   public void setFirstName(String first)
    {
     firstName = first;
    }

   public void setLastName(String last)
    {
     lastName = last;
    }

   public void setSport(String someSport)
    {
     sport = someSport;
    }

   //Methods to increase the count of medals
   public void increaseGold()
    {
     gold++;
    }

   public void increaseSilver()
    {
     silver++;
    }

   public void increaseBronze()
    {
     bronze++;
    }

   //toString() method returns a string containg information of an athlete
   public String toString()
    {
      String result = "Name:\t" + lastName + "," + firstName + "\n"
                    + "Sport:\t" + sport + "\n"
                    + "Medal Count:\n" 
                    + "Gold: " + gold + "\n"
                    + "Silver: " + silver + "\n"
                    + "Bronze: " + bronze + "\n\n";
      return result;
     }
  }