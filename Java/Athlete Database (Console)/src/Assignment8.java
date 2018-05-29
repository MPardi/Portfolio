// Assignment #: 8
//         Name: Michael Pardi
//    StudentID: 1201659320
//      Lecture: TTh 4:30-5:45
//  Description: The Assignment 8 class displays a menu of choices to a user
//               and performs the chosen task. It will keep asking a user to
//               enter the next choice until the choice of 'Q' (Quit) is
//               entered. 

import java.io.*;

public class Assignment8
 {
  public static void main (String[] args)
   {
     char input1;
     String firstName, lastName, sport;
     int gold, silver, bronze;
     boolean operation = false;
     int operation2 = 0;
     String line;
     String filename;

     // create a AthleteManagement object. This is used throughout this class.
     AthleteManagement athleteRecord1 = new AthleteManagement();

     try
      {
       // print out the menu
       printMenu();

       // create a BufferedReader object to read input from a keyboard
       InputStreamReader isr = new InputStreamReader (System.in);
       BufferedReader stdin = new BufferedReader (isr);

       do
        {
         System.out.print("What action would you like to perform?\n");
         line = stdin.readLine().trim();  //read a line
         input1 = line.charAt(0);
         input1 = Character.toUpperCase(input1);

         if (line.length() == 1)          //check if a user entered only one character
          {
           switch (input1)
            {
             case 'A':   //Add Athlete
               try 
                {
                 System.out.print("Please enter the following information of an athlete:\n");
                 System.out.print("First Name:\n");
                 firstName = stdin.readLine().trim();
                 System.out.print("Last Name:\n");
                 lastName = stdin.readLine().trim();
                 System.out.print("Sport:\n");
                 sport = stdin.readLine().trim();
                 System.out.print("The number of gold medals\n");
                 gold = Integer.parseInt(stdin.readLine().trim());
                 System.out.print("The number of silver medals\n");
                 silver = Integer.parseInt(stdin.readLine().trim());
                 System.out.print("The number of bronze medals\n");
                 bronze = Integer.parseInt(stdin.readLine().trim());

                 operation = athleteRecord1.addAthlete(firstName,lastName,sport,gold,silver,bronze);
                 if (operation == true)
                  System.out.print("athlete added\n");
                 else
                  System.out.print("athlete exists\n");
                }
                /************************************************************************************
                ***  Complete the follwing catch statement
                ***********************************************************************************/
                catch(NumberFormatException ex)
                {
                	System.out.print("Please enter a numeric value for the number of medals. Athlete not added\n");
                }
               break;
             case 'D':  //Count athletes by medal type
              try
               {
                 System.out.print("Please enter a medal type, 0 for gold, 1 for silver, 2 for bronze, to count the athletes with such medal:\n");
                 int medalType = Integer.parseInt(stdin.readLine().trim());
                 int athleteCount =athleteRecord1.countHowManyAthleteHaveMedals(medalType);

                 System.out.print("The number of athletes with the given medal type: " + athleteCount + "\n");
                }
                /************************************************************************************
                ***  Complete the follwing catch statement
                ***********************************************************************************/
                catch(NumberFormatException ex)
                {
                	System.out.print("Please enter an integer for a medal type, 0 for gold, 1 for silver, 2 for bronze.\n");
                }
               break;
             case 'E':  //Search by athlete name
                 System.out.print("Please enter the first and last names of an athlete to search:\n");
                 System.out.print("First Name:\n");
                 firstName = stdin.readLine().trim();
                 System.out.print("Last Name:\n");
                 lastName = stdin.readLine().trim();
                 operation2=athleteRecord1.athleteNameExists(firstName, lastName);
                    
                if (operation2 > -1)
                    System.out.print("athlete found\n");
                else
                    System.out.print("athlete not found\n");
                break;
             case 'L':   //List athletes
               System.out.print(athleteRecord1.listAthletes());
               break;
             case 'O':  // Sort by athlete names
               athleteRecord1.sortByAthleteNames();
               System.out.print("sorted by athlete names\n");
               break;
             case 'P':  // Sort by medal counts
               athleteRecord1.sortByMedalCounts();
               System.out.print("sorted by medal counts\n");
               break;
             case 'Q':   //Quit
               break;
             case 'R':  //Remove by athlete names
                    System.out.print("Please enter the first and last names of an athlete to remove:\n");
                    System.out.print("First Name:\n");
                    firstName = stdin.readLine().trim();
                    System.out.print("Last Name:\n");
                    lastName = stdin.readLine().trim();
                    operation=athleteRecord1.removeAthleteByName(firstName, lastName);
                    
                    if (operation == true)
                        System.out.print("athlete removed\n");
                    else
                        System.out.print("athlete not found\n");
                    break;
             case 'T':  //Close AthleteManagement
               athleteRecord1.closeAthleteManagement();
               System.out.print("athlete management system closed\n");
               break;
                case 'U':  //Write Text to a File
                    System.out.print("Please enter a file name to write:\n");
                    filename = stdin.readLine().trim();
                    /************************************************************************************
                     ***  ADD your code to write a text (string) to the specified file. Catch exceptions.
                     ************************************************************************************/
                    try {
                    	FileWriter fw = new FileWriter(filename);
                    	BufferedWriter bw = new BufferedWriter(fw);
                    	PrintWriter pw = new PrintWriter(bw);
                    	
                    	System.out.print("Please enter a string to write in the file:\n");
                    	line = stdin.readLine().trim();
                    	
                    	pw.print(line);
                    }
                    catch(FileNotFoundException ex) {
                    	System.out.print("The filename was not found...\n");
                    }
                    catch(IOException ex) {
                    	System.out.println("General I/O exception: " + ex.getMessage());
                    }
                    break;
                case 'V':  //Read Text from a File
                    System.out.print("Please enter a file name to read:\n");
                    filename = stdin.readLine().trim();
                    /************************************************************************************
                     ***  ADD your code to read a text (string) from the specified file. Catch exceptions.
                     ************************************************************************************/
                    break;
                case 'W':  //Serialize ProjectManagement to a File
                    System.out.print("Please enter a file name to write:\n");
                    filename = stdin.readLine().trim();
                    /************************************************************************************
                     ***  ADD your code to write the project management bject to the specified file. Catch exceptions.
                     ************************************************************************************/
                    break;
                case 'X':  //Deserialize ProjectManagement from a File
                    System.out.print("Please enter a file name to read:\n");
                    filename = stdin.readLine().trim();
                    /************************************************************************************
                     ***  ADD your code to read a project management object from the specified file. Catch exceptions.
                     ***********************************************************************************/
                    break;             case '?':   //Display Menu
               printMenu();
               break;
             default:
               System.out.print("Unknown action\n");
               break;
            }
         }
        else
         {
           System.out.print("Unknown action\n");
          }
        } while (input1 != 'Q' || line.length() != 1);
      }
     catch (IOException exception)
      {
        System.out.print("IO Exception\n");
      }
   }

  /** The method printMenu displays the menu to a user **/
  public static void printMenu()
   {
     System.out.print("Choice\t\tAction\n" +
                      "------\t\t------\n" +
                      "A\t\tAdd Athlete\n" +
                      "D\t\tCount Athletes for Medal Type\n" +
                      "E\t\tSearch for Athlete Name\n" +
                      "L\t\tList Athletes\n" +
                      "O\t\tSort by Athlete Names\n" +
                      "P\t\tSort by Medal Counts\n" +
                      "Q\t\tQuit\n" +
                      "R\t\tRemove by Athlete Name\n" +
                      "T\t\tClose AthleteManagement\n" +
                      "U\t\tWrite Text to File\n" +
                      "V\t\tRead Text from File\n" +
                      "W\t\tSerialize AthleteManagement to File\n" +
                      "X\t\tDeserialize AthleteManagement from File\n" +
                      "?\t\tDisplay Help\n\n");
  }
} // end of Assignment8 class

