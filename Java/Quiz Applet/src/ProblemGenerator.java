package project04;

import java.util.Random;

public class ProblemGenerator {
	// Spencer Duchene
	// This class can be used by calling the wanted problem generator then
	// calling getProblemSolution(); and
	// getFakeSolution 1-3
	// This will generate problems for students to answer in the tutor
	private String problemSolution;

	private String falseSolutionOne, falseSolutionTwo, falseSolutionThree;

	// Problem Solutions will be handled as Strings
	public String functionCombiner() {
		// This will create a problem containing two functions that can be
		// combined
		// since we arent solving for x we dont need to define it, all we define
		// are variables that will be combined
		// xMultiples will be added together as will numerals, the solution will
		// look like this:
		// xMultiple * x + numeral
		Random changing = new Random();
		int xMultipleOne = changing.nextInt(15);
		int xMultipleTwo = changing.nextInt(15);
		int multipleAnswer = xMultipleOne + xMultipleTwo;
		int numeralOne = changing.nextInt(15);
		int numeralTwo = changing.nextInt(15);
		int numeralAnswer = numeralOne + numeralTwo;

		// Generate Problem
		String problem = ("<html>" + "Please Combine the Following functions:  f(x) = " + xMultipleOne + "x + "
				+ numeralOne + "\n g(x) = " + xMultipleTwo + "x + " + numeralTwo + "</html>");

		// Generate Solution
		problemSolution = ("x = " + multipleAnswer + " Constant = " + numeralAnswer);

		// Generate False Solutions
		falseSolutionOne = ("x = " + numeralOne + " Constant = " + xMultipleOne);
		falseSolutionTwo = ("x = " + xMultipleTwo + " Constant = " + numeralAnswer);
		falseSolutionThree = ("x = " + xMultipleOne + " Constant = " + numeralAnswer);
		return problem;
	}

	// Subtract
	public String functionCombinerSubtract() {
		// This will create a problem containing two functions that can be
		// combined
		// since we arent solving for x we dont need to define it, all we define
		// are variables that will be combined
		// xMultiples will be added together as will numerals, the solution will
		// look like this:
		// xMultiple * x + numeral
		Random changing = new Random();
		int xMultipleOne = changing.nextInt(15);
		int xMultipleTwo = changing.nextInt(15);
		int multipleAnswer = xMultipleOne - xMultipleTwo;
		int numeralOne = changing.nextInt(15);
		int numeralTwo = changing.nextInt(15);
		int numeralAnswer = numeralOne - numeralTwo;

		// Generate Problem
		String problem = ("<html>" + "Please Subtract the following functions:  f(x) = " + xMultipleOne + "x + "
				+ numeralOne + "\n g(x) = " + xMultipleTwo + "x + " + numeralTwo + "</html>");

		// Generate Solution
		problemSolution = ("x = " + multipleAnswer + "Constant = " + numeralAnswer);

		// Generate False Solutions
		falseSolutionOne = ("x = " + numeralOne + "Constant = " + xMultipleOne);
		falseSolutionTwo = ("x = " + xMultipleTwo + "Constant = " + numeralAnswer);
		falseSolutionThree = ("x = " + xMultipleOne + "Constant = " + numeralAnswer);
		return problem;
	}

	public String functionCombineMultiply() {
		// This will create a problem containing two functions that can be
		// combined
		// since we arent solving for x we dont need to define it, all we define
		// are variables that will be combined
		// xMultiples will be added together as will numerals, the solution will
		// look like this:
		// xMultiple * x + numeral
		Random changing = new Random();
		int xMultipleOne = changing.nextInt(15);
		int xMultipleTwo = changing.nextInt(15);
		int multipleAnswerSquared = xMultipleOne * xMultipleTwo;
		int numeralOne = changing.nextInt(15);
		int numeralTwo = changing.nextInt(15);
		int numeralAnswer = numeralOne * numeralTwo;
		int multipleAnswer = (xMultipleOne * numeralTwo) + (xMultipleTwo * numeralOne);

		// Generate Problem
		String problem = ("<html>" + "Please Multiply the Following functions:  f(x) = " + xMultipleOne + "x + "
				+ numeralOne + "\n g(x) = " + xMultipleTwo + "x + " + numeralTwo + "</html>");

		// Generate Solution
		problemSolution = ("x^2 = " + multipleAnswerSquared + " x = " + multipleAnswer + " Constant = "
				+ numeralAnswer);

		// Generate False Solutions
		falseSolutionOne = ("x^2 = " + multipleAnswer + " x = " + numeralAnswer + " Constant = " + numeralAnswer);
		falseSolutionTwo = ("x^2 = " + multipleAnswerSquared + " x = " + numeralOne + " Constant = " + multipleAnswer);
		falseSolutionThree = ("x^2 = " + numeralAnswer + " x = " + multipleAnswer + " Constant = " + numeralTwo);
		return problem;
	}

	// LESSON 2 STRINGS
	public String EliminationMethod() {
		// Data here is used to create the formula
		Random changing = new Random();
		int xVariable = changing.nextInt(6);
		int yVariable = changing.nextInt(8);
		int xMultipleOne = changing.nextInt(15);
		int xMultipleTwo = changing.nextInt(15);
		int yMultipleOne = changing.nextInt(15);
		int yMultipleTwo = changing.nextInt(15);
		int firstFormulaSolution = (xMultipleOne * xVariable) + (yMultipleOne * yVariable);
		int secondFormulaSolution = (xMultipleTwo * xVariable) + (yMultipleTwo * yVariable);

		String problem = (xMultipleOne + "x + " + yMultipleOne + "y = " + firstFormulaSolution + "\n" + xMultipleTwo
				+ "x + " + yMultipleTwo + "y = " + secondFormulaSolution);

		problemSolution = ("y = " + yVariable + " x = " + xVariable);

		falseSolutionOne = ("y = " + (yVariable - 2) + " x = " + xVariable);
		falseSolutionTwo = ("y = " + 15 + " x = " + xVariable);
		falseSolutionThree = ("y = " + yVariable + " x = " + (xVariable + 3));
		return problem;
	}

	// LESSON 3 STRINGS
	// make one of 3 static matrices appear via rng
	public String dimensionOfMatrix() {
		Random matrixGen = new Random();

		int rowOneColumn0ne = matrixGen.nextInt(15);
		int rowOneColumnTwo = matrixGen.nextInt(15);
		int rowOneColumnThree = matrixGen.nextInt(15);
		int rowOneColumnFour = matrixGen.nextInt(15);

		int rowTwoColumnOne = matrixGen.nextInt(15);
		int rowTwoColumnTwo = matrixGen.nextInt(15);
		int rowTwoColumnThree = matrixGen.nextInt(15);
		int rowTwoColumnFour = matrixGen.nextInt(15);

		int rowThreeColumnOne = matrixGen.nextInt(15);
		int rowThreeColumnTwo = matrixGen.nextInt(15);
		int rowThreeColumnThree = matrixGen.nextInt(15);
		int rowThreeColumnFour = matrixGen.nextInt(15);

		// this number is used to determine whether the student gets the 2x2,
		// 2x3, or 4x2
		int matrixDecider = matrixGen.nextInt(3);
		String problem;

		switch (matrixDecider) {
		case 1:
			// 2x2
			problem = ("What are the dimensions of the following Matrix? \n" + rowOneColumn0ne + " " + rowOneColumnTwo
					+ "\n" + rowTwoColumnOne + " " + rowTwoColumnTwo);
			problemSolution = "2 x 2";
			falseSolutionOne = "2 x 3";
			falseSolutionTwo = "3 x 2";
			falseSolutionThree = "1 x 1";
			break;
		case 2:
			// 2x3
			problem = ("What are the dimensions of the following Matrix? \n" + rowOneColumn0ne + " " + rowOneColumnTwo
					+ " " + rowOneColumnThree + "\n" + rowTwoColumnOne + " " + rowTwoColumnTwo + " "
					+ rowTwoColumnThree);
			problemSolution = "2 x 3";
			falseSolutionOne = "1 x 2";
			falseSolutionTwo = "3 x 2";
			falseSolutionThree = "2 x 1";
			break;
		case 3:
			// 3x4
			problem = ("What are the dimensions of the following Matrix? \n" + rowOneColumn0ne + " " + rowOneColumnTwo
					+ " " + rowOneColumnThree + " " + rowOneColumnFour + "\n" + rowTwoColumnOne + " " + rowTwoColumnTwo
					+ " " + rowTwoColumnThree + " " + rowTwoColumnFour + "\n" + rowThreeColumnOne + " "
					+ rowThreeColumnTwo + " " + rowThreeColumnThree + " " + rowThreeColumnFour);
			problemSolution = "3 x 4";
			falseSolutionOne = "2 x 3";
			falseSolutionTwo = "3 x 2";
			falseSolutionThree = "1 x 2";
			break;
		default:
			// return 2x2
			problem = ("What are the dimensions of the following Matrix? \n" + rowOneColumn0ne + " " + rowOneColumnTwo
					+ "\n" + rowTwoColumnOne + " " + rowTwoColumnTwo);
			problemSolution = "2 x 2";
			falseSolutionOne = "2 x 3";
			falseSolutionTwo = "3 x 2";
			falseSolutionThree = "1 x 1";
			break;
		}

		return problem;

	}

	// create a 3x3 Matrix and place the value to find in one of those spots
	// randomly
	public String positionInMatrix() {

		Random positionSelector = new Random();
		int setPositionInMatrix = positionSelector.nextInt(9);
		String problem;
		int rowOneColumn0ne = 1;
		int rowOneColumnTwo = 9;
		int rowOneColumnThree = 3;
		int rowTwoColumn0ne = 4;
		int rowTwoColumnTwo = 7;
		int rowTwoColumnThree = 3;
		int rowThreeColumn0ne = 8;
		int rowThreeColumnTwo = 6;
		int rowThreeColumnThree = 2;

		switch (setPositionInMatrix) {
		case 1:
			rowOneColumn0ne = 5;
			problemSolution = ("1,1");
			falseSolutionOne = ("0,1");
			falseSolutionTwo = ("2,3");
			falseSolutionThree = ("4,1");
			break;
		case 2:
			rowOneColumnTwo = 5;
			problemSolution = ("1,2");
			falseSolutionOne = ("0,1");
			falseSolutionTwo = ("2,3");
			falseSolutionThree = ("4,1");
			break;
		case 3:
			rowOneColumnThree = 5;
			problemSolution = ("1,3");
			falseSolutionOne = ("0,1");
			falseSolutionTwo = ("2,3");
			falseSolutionThree = ("4,1");
			break;
		case 4:
			rowTwoColumn0ne = 5;
			problemSolution = ("2,1");
			falseSolutionOne = ("0,1");
			falseSolutionTwo = ("2,3");
			falseSolutionThree = ("4,1");
			break;
		case 5:
			rowTwoColumnTwo = 5;
			problemSolution = ("2,2");
			falseSolutionOne = ("0,1");
			falseSolutionTwo = ("2,3");
			falseSolutionThree = ("4,1");
			break;
		case 6:
			rowTwoColumnThree = 5;
			problemSolution = ("2,3");
			falseSolutionOne = ("0,1");
			falseSolutionTwo = ("2,3");
			falseSolutionThree = ("4,1");
			break;
		case 7:
			rowThreeColumn0ne = 5;
			problemSolution = ("3,1");
			falseSolutionOne = ("0,1");
			falseSolutionTwo = ("2,3");
			falseSolutionThree = ("4,1");
			break;
		case 8:
			rowThreeColumnTwo = 5;
			problemSolution = ("3,2");
			falseSolutionOne = ("0,1");
			falseSolutionTwo = ("2,3");
			falseSolutionThree = ("4,1");
			break;
		case 9:
			rowThreeColumnThree = 5;
			problemSolution = ("3,3");
			falseSolutionOne = ("0,1");
			falseSolutionTwo = ("2,3");
			falseSolutionThree = ("4,1");
			break;

		}
		problem = ("At what position in the matrix is 5\n" + rowOneColumn0ne + " " + rowOneColumnTwo + " "
				+ rowOneColumnThree + "\n" + rowTwoColumn0ne + " " + rowTwoColumnTwo + " " + rowTwoColumnThree + "\n"
				+ rowThreeColumn0ne + " " + rowThreeColumnTwo + " " + rowThreeColumnThree);
		return problem;
	}

	// LESSON 4 STRINGS
	public String addMatrix() {

		Random matrixCreator = new Random();
		// left matrix number generation
		int leftMatrixOneOne = matrixCreator.nextInt(15);
		int leftMatrixOneTwo = matrixCreator.nextInt(15);
		int leftMatrixTwoOne = matrixCreator.nextInt(15);
		int leftMatrixTwoTwo = matrixCreator.nextInt(15);
		// right matrix number generation
		int rightMatrixOneOne = matrixCreator.nextInt(15);
		int rightMatrixOneTwo = matrixCreator.nextInt(15);
		int rightMatrixTwoOne = matrixCreator.nextInt(15);
		int rightMatrixTwoTwo = matrixCreator.nextInt(15);
		// solution matrix determiners
		int solutionOneOne = leftMatrixOneOne + rightMatrixOneOne;
		int solutionOneTwo = leftMatrixOneTwo + rightMatrixOneTwo;
		int solutionTwoOne = leftMatrixTwoOne + rightMatrixTwoOne;
		int solutionTwoTwo = leftMatrixTwoTwo + rightMatrixTwoTwo;

		String problem = ("Please add the two Matrixes together \n" + "|||" + leftMatrixOneOne + " " + leftMatrixOneTwo
				+ " ||| " + rightMatrixOneOne + " " + rightMatrixOneTwo + "\n" + "|||" + leftMatrixTwoOne + " "
				+ leftMatrixTwoTwo + " ||| " + rightMatrixTwoOne + " " + rightMatrixTwoTwo);
		problemSolution = ("|||" + solutionOneOne + " " + solutionOneTwo + "|||\n" + "|||" + solutionTwoOne + " "
				+ solutionTwoTwo + "|||");

		falseSolutionOne = ("|||" + (solutionOneOne + 2) + " " + solutionOneTwo + "|||\n" + "|||" + solutionTwoOne + " "
				+ (solutionTwoTwo - 4) + "|||");
		falseSolutionTwo = ("|||" + (solutionOneOne + 6) + " " + solutionOneTwo + "|||\n" + "|||" + solutionTwoOne + " "
				+ (solutionTwoTwo - 1) + "|||");
		falseSolutionThree = ("|||" + (solutionOneOne + 1) + " " + solutionOneTwo + "|||\n" + "|||" + solutionTwoOne
				+ " " + (solutionTwoTwo - 8) + "|||");

		return problem;
	}

	// subtract two matricies from each other
	public String subtractMatrix() {
		Random matrixCreator = new Random();
		// left matrix number generation
		int leftMatrixOneOne = matrixCreator.nextInt(15);
		int leftMatrixOneTwo = matrixCreator.nextInt(15);
		int leftMatrixTwoOne = matrixCreator.nextInt(15);
		int leftMatrixTwoTwo = matrixCreator.nextInt(15);
		// right matrix number generation
		int rightMatrixOneOne = matrixCreator.nextInt(15);
		int rightMatrixOneTwo = matrixCreator.nextInt(15);
		int rightMatrixTwoOne = matrixCreator.nextInt(15);
		int rightMatrixTwoTwo = matrixCreator.nextInt(15);
		// solution matrix determiners
		int solutionOneOne = leftMatrixOneOne - rightMatrixOneOne;
		int solutionOneTwo = leftMatrixOneTwo - rightMatrixOneTwo;
		int solutionTwoOne = leftMatrixTwoOne - rightMatrixTwoOne;
		int solutionTwoTwo = leftMatrixTwoTwo - rightMatrixTwoTwo;

		String problem = ("Please add the two Matrixes together \n" + "|||" + leftMatrixOneOne + " " + leftMatrixOneTwo
				+ " ||| " + rightMatrixOneOne + " " + rightMatrixOneTwo + "\n" + "|||" + leftMatrixTwoOne + " "
				+ leftMatrixTwoTwo + " ||| " + rightMatrixTwoOne + " " + rightMatrixTwoTwo);
		problemSolution = ("|||" + solutionOneOne + " " + solutionOneTwo + "|||\n" + "|||" + solutionTwoOne + " "
				+ solutionTwoTwo + "|||");

		falseSolutionOne = ("|||" + (solutionOneOne + 4) + " " + solutionOneTwo + "|||\n" + "|||" + solutionTwoOne + " "
				+ (solutionTwoTwo - 1) + "|||");
		falseSolutionTwo = ("|||" + (solutionOneOne + 3) + " " + solutionOneTwo + "|||\n" + "|||" + solutionTwoOne + " "
				+ (solutionTwoTwo - 9) + "|||");
		falseSolutionThree = ("|||" + (solutionOneOne + 1) + " " + solutionOneTwo + "|||\n" + "|||" + solutionTwoOne
				+ " " + (solutionTwoTwo - 2) + "|||");

		return problem;
	}

	// LESSON 5 STRINGS
	// multiply a matrix by a matrix
	public String multiplyMatrix() {
		Random matrixCreator = new Random();
		// left matrix number generation
		int leftMatrixOneOne = matrixCreator.nextInt(15);
		int leftMatrixOneTwo = matrixCreator.nextInt(15);
		int leftMatrixTwoOne = matrixCreator.nextInt(15);
		int leftMatrixTwoTwo = matrixCreator.nextInt(15);
		// right matrix number generation
		int rightMatrixOneOne = matrixCreator.nextInt(15);
		int rightMatrixOneTwo = matrixCreator.nextInt(15);
		int rightMatrixTwoOne = matrixCreator.nextInt(15);
		int rightMatrixTwoTwo = matrixCreator.nextInt(15);
		// solution matrix determiners
		int solutionOneOne = leftMatrixOneOne * rightMatrixOneOne;
		int solutionOneTwo = leftMatrixOneTwo * rightMatrixOneTwo;
		int solutionTwoOne = leftMatrixTwoOne * rightMatrixTwoOne;
		int solutionTwoTwo = leftMatrixTwoTwo * rightMatrixTwoTwo;

		String problem = ("Please Multiply the two Matrixes together \n" + "|||" + leftMatrixOneOne + " "
				+ leftMatrixOneTwo + " ||| " + rightMatrixOneOne + " " + rightMatrixOneTwo + "\n" + "|||"
				+ leftMatrixTwoOne + " " + leftMatrixTwoTwo + " ||| " + rightMatrixTwoOne + " " + rightMatrixTwoTwo);
		problemSolution = ("|||" + solutionOneOne + " " + solutionOneTwo + "|||\n" + "|||" + solutionTwoOne + " "
				+ solutionTwoTwo + "|||");

		falseSolutionOne = ("|||" + (solutionOneOne * 2) + " " + solutionOneTwo + "|||\n" + "|||" + solutionTwoOne + " "
				+ (solutionTwoTwo - 4) + "|||");
		falseSolutionTwo = ("|||" + (solutionOneOne * 6) + " " + solutionOneTwo + "|||\n" + "|||" + solutionTwoOne + " "
				+ (solutionTwoTwo - 3) + "|||");
		falseSolutionThree = ("|||" + (solutionOneOne + 1) + " " + solutionOneTwo + "|||\n" + "|||" + solutionTwoOne
				+ " " + (solutionTwoTwo - 8) + "|||");

		return problem;
	}

	// divide a matrix by a matrix
	public String divideMatrix() {
		Random matrixCreator = new Random();
		// right matrix number generation
		int rightMatrixOneOne = matrixCreator.nextInt(15);
		int rightMatrixOneTwo = matrixCreator.nextInt(15);
		int rightMatrixTwoOne = matrixCreator.nextInt(15);
		int rightMatrixTwoTwo = matrixCreator.nextInt(15);
		// left matrix number generation
		int leftMatrixOneOne = matrixCreator.nextInt(15) * rightMatrixOneOne;
		int leftMatrixOneTwo = matrixCreator.nextInt(15) * rightMatrixOneTwo;
		int leftMatrixTwoOne = matrixCreator.nextInt(15) * rightMatrixTwoOne;
		int leftMatrixTwoTwo = matrixCreator.nextInt(15) * rightMatrixTwoTwo;
		// solution matrix determiners
		int solutionOneOne = leftMatrixOneOne / rightMatrixOneOne;
		int solutionOneTwo = leftMatrixOneTwo / rightMatrixOneTwo;
		int solutionTwoOne = leftMatrixTwoOne / rightMatrixTwoOne;
		int solutionTwoTwo = leftMatrixTwoTwo / rightMatrixTwoTwo;

		String problem = ("Please Divide the two Matrices by each other \n" + "|||" + leftMatrixOneOne + " "
				+ leftMatrixOneTwo + " ||| " + rightMatrixOneOne + " " + rightMatrixOneTwo + "\n" + "|||"
				+ leftMatrixTwoOne + " " + leftMatrixTwoTwo + " ||| " + rightMatrixTwoOne + " " + rightMatrixTwoTwo);
		problemSolution = ("|||" + solutionOneOne + " " + solutionOneTwo + "|||\n" + "|||" + solutionTwoOne + " "
				+ solutionTwoTwo + "|||");

		falseSolutionOne = ("|||" + (solutionOneOne * 2) + " " + solutionOneTwo + "|||\n" + "|||" + solutionTwoOne + " "
				+ (solutionTwoTwo - 4) + "|||");
		falseSolutionTwo = ("|||" + (solutionOneOne * 6) + " " + solutionOneTwo + "|||\n" + "|||" + solutionTwoOne + " "
				+ (solutionTwoTwo - 3) + "|||");
		falseSolutionThree = ("|||" + (solutionOneOne + 1) + " " + solutionOneTwo + "|||\n" + "|||" + solutionTwoOne
				+ " " + (solutionTwoTwo - 8) + "|||");

		return problem;
	}

	// LESSON 6 STRINGS
	// multiply a matrix by a number
	public String multiplyMatrixScalar() {
		Random matrixCreator = new Random();
		// left matrix number generation
		int multiplier = matrixCreator.nextInt(5);
		int leftMatrixOneOne = matrixCreator.nextInt(15);
		int leftMatrixOneTwo = matrixCreator.nextInt(15);
		int leftMatrixTwoOne = matrixCreator.nextInt(15);
		int leftMatrixTwoTwo = matrixCreator.nextInt(15);

		// solution matrix determiners
		int solutionOneOne = leftMatrixOneOne * multiplier;
		int solutionOneTwo = leftMatrixOneTwo * multiplier;
		int solutionTwoOne = leftMatrixTwoOne * multiplier;
		int solutionTwoTwo = leftMatrixTwoTwo * multiplier;

		String problem = ("Please multiply the Matrix by " + multiplier + "\n" + "|||" + leftMatrixOneOne + " "
				+ leftMatrixOneTwo + " ||| \n" + "|||" + leftMatrixTwoOne + " " + leftMatrixTwoTwo + " ||| ");
		problemSolution = ("|||" + solutionOneOne + " " + solutionOneTwo + "|||\n" + "|||" + solutionTwoOne + " "
				+ solutionTwoTwo + "|||");

		falseSolutionOne = ("|||" + (solutionOneOne + 5) + " " + solutionOneTwo + "|||\n" + "|||" + solutionTwoOne + " "
				+ (solutionTwoTwo - 2) + "|||");
		falseSolutionTwo = ("|||" + (solutionOneOne + 3) + " " + solutionOneTwo + "|||\n" + "|||" + solutionTwoOne + " "
				+ (solutionTwoTwo - 9) + "|||");
		falseSolutionThree = ("|||" + (solutionOneOne + 1) + " " + solutionOneTwo + "|||\n" + "|||" + solutionTwoOne
				+ " " + solutionTwoTwo + "|||");

		return problem;
	}

	// divide a matrix by a number
	public String divideMatrixScalar() {
		Random matrixCreator = new Random();
		// left matrix number generation
		int multiplier = matrixCreator.nextInt(5);
		int leftMatrixOneOne = matrixCreator.nextInt(15) * multiplier;
		int leftMatrixOneTwo = matrixCreator.nextInt(15) * multiplier;
		int leftMatrixTwoOne = matrixCreator.nextInt(15) * multiplier;
		int leftMatrixTwoTwo = matrixCreator.nextInt(15) * multiplier;

		// solution matrix determiners
		int solutionOneOne = leftMatrixOneOne / multiplier;
		int solutionOneTwo = leftMatrixOneTwo / multiplier;
		int solutionTwoOne = leftMatrixTwoOne / multiplier;
		int solutionTwoTwo = leftMatrixTwoTwo / multiplier;

		String problem = ("Please divide the Matrix by " + multiplier + "\n" + "|||" + leftMatrixOneOne + " "
				+ leftMatrixOneTwo + " ||| \n" + "|||" + leftMatrixTwoOne + " " + leftMatrixTwoTwo + " ||| ");
		problemSolution = ("|||" + solutionOneOne + " " + solutionOneTwo + "|||\n" + "|||" + solutionTwoOne + " "
				+ solutionTwoTwo + "|||");

		falseSolutionOne = ("|||" + (solutionOneOne * 3) + " " + solutionOneTwo + "|||\n" + "|||" + solutionTwoOne + " "
				+ (solutionTwoTwo - 2) + "|||");
		falseSolutionTwo = ("|||" + (solutionOneOne + 3) + " " + solutionOneTwo + "|||\n" + "|||" + solutionTwoOne + " "
				+ (solutionTwoTwo * 9) + "|||");
		falseSolutionThree = ("|||" + (solutionOneOne + 1) + " " + solutionOneTwo + "|||\n" + "|||" + solutionTwoOne
				+ " " + solutionTwoTwo + "|||");

		return problem;
	}

	// GETTERS
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
