package Project03;
import java.util.Random;


public class ProblemGenerator {
    //Spencer Duchene
    // This class can be used by calling the wanted problem generator then calling getProblemSolution(); and
    // getFakeSolution 1-3
    //This will generate problems for students to answer in the tutor
    private String problemSolution;

    private String falseSolutionOne, falseSolutionTwo,falseSolutionThree;

    //Problem Solutions will be handled as Strings
    public String functionCombiner(){
        //This will create a problem containing two functions that can be combined
        //since we arent solving for x we dont need to define it, all we define are variables that will be combined
        //xMultiples will be added together as will numerals, the solution will look like this:
        // xMultiple * x + numeral
        Random changing = new Random();
        int xMultipleOne = changing.nextInt(15);
        int xMultipleTwo = changing.nextInt(15);
        int multipleAnswer = xMultipleOne + xMultipleTwo;
        int numeralOne = changing.nextInt(15);
        int numeralTwo = changing.nextInt(15);
        int numeralAnswer = numeralOne + numeralTwo;

        //Generate Problem
        String problem = ("<html>" + "Please Combine the Following functions:  f(x) = " + xMultipleOne + "x + " + numeralOne +
                "\n g(x) = " + xMultipleTwo + "x + " + numeralTwo + "</html>");

        //Generate Solution
        problemSolution = ("x = " + multipleAnswer + " Constant = " + numeralAnswer);

        //Generate False Solutions
        falseSolutionOne = ("x = " + numeralOne + " Constant = " + xMultipleOne);
        falseSolutionTwo = ("x = " + xMultipleTwo + " Constant = " + numeralAnswer);
        falseSolutionThree = ("x = " + xMultipleOne + " Constant = " + numeralAnswer);
        return problem;
}
    //Subtract
    public String functionCombinerSubtract(){
        //This will create a problem containing two functions that can be combined
        //since we arent solving for x we dont need to define it, all we define are variables that will be combined
        //xMultiples will be added together as will numerals, the solution will look like this:
        // xMultiple * x + numeral
        Random changing = new Random();
        int xMultipleOne = changing.nextInt(15);
        int xMultipleTwo = changing.nextInt(15);
        int multipleAnswer = xMultipleOne - xMultipleTwo;
        int numeralOne = changing.nextInt(15);
        int numeralTwo = changing.nextInt(15);
        int numeralAnswer = numeralOne - numeralTwo;

        //Generate Problem
        String problem = ("<html>"+"Please Subtract the following functions:  f(x) = " + xMultipleOne + "x + " + numeralOne +
                "\n g(x) = " + xMultipleTwo + "x + " + numeralTwo + "</html>");

        //Generate Solution
        problemSolution = ("x = " + multipleAnswer + "Constant = " + numeralAnswer);

        //Generate False Solutions
        falseSolutionOne = ("x = " + numeralOne + "Constant = " + xMultipleOne);
        falseSolutionTwo = ("x = " + xMultipleTwo + "Constant = " + numeralAnswer);
        falseSolutionThree = ("x = " + xMultipleOne + "Constant = " + numeralAnswer);
        return problem;
    }

    public String functionCombineMultiply(){
        //This will create a problem containing two functions that can be combined
        //since we arent solving for x we dont need to define it, all we define are variables that will be combined
        //xMultiples will be added together as will numerals, the solution will look like this:
        // xMultiple * x + numeral
        Random changing = new Random();
        int xMultipleOne = changing.nextInt(15);
        int xMultipleTwo = changing.nextInt(15);
        int multipleAnswerSquared = xMultipleOne * xMultipleTwo;
        int numeralOne = changing.nextInt(15);
        int numeralTwo = changing.nextInt(15);
        int numeralAnswer = numeralOne * numeralTwo;
        int multipleAnswer = (xMultipleOne* numeralTwo ) +(xMultipleTwo * numeralOne);

        //Generate Problem
        String problem = ("<html>" + "Please Multiply the Following functions:  f(x) = " + xMultipleOne + "x + " + numeralOne +
                "\n g(x) = " + xMultipleTwo + "x + " + numeralTwo + "</html>");

        //Generate Solution
        problemSolution = ("x^2 = " + multipleAnswerSquared + " x = " + multipleAnswer + " Constant = " + numeralAnswer);

        //Generate False Solutions
        falseSolutionOne = ("x^2 = " + multipleAnswer + " x = " + numeralAnswer + " Constant = " + numeralAnswer);
        falseSolutionTwo = ("x^2 = " + multipleAnswerSquared + " x = " + numeralOne + " Constant = " + multipleAnswer);
        falseSolutionThree = ("x^2 = " + numeralAnswer + " x = " + multipleAnswer + " Constant = " + numeralTwo);
        return problem;
    }




    //GETTERS
    public String getProblemSolution() {
        return problemSolution;
    }

    public String getFalseSolutionOne() {
        return falseSolutionOne;
    }

    public String getFalseSolutionTwo() {
        return falseSolutionTwo;
    }

    public String getFalseSolutionThree() {
        return falseSolutionThree;
    }
}
