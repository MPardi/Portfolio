import random
import sys
import time
import os
from decimal import Decimal

def main():
	welcomePrompt()
	
	targetArray, stringArray = inputPrompt()
	
	i = 0
	print("\n")
	
	startTime = cracker(i, stringArray, targetArray)
	
	results(stringArray, startTime)
	
def welcomePrompt():
	os.system('cls' if os.name == 'nt' else 'clear')

	columns = os.get_terminal_size().columns
	print("\n\n\n\n")
	print("***** PASSWORD CRACKER *****".center(columns))
	print("\n")
	
def inputPrompt():
	# *** Test Case *** #
	#targetArray = ["P", "a", "s", "s", "w", "o", "r", "d"]
	#stringArray = ["", "", "", "", "", "", "", ""]

	targetArray = input("Please enter a password: ")
	stringArray = [""] * len(targetArray)
	
	return targetArray, stringArray

def cracker(i, stringArray, targetArray):
	startTime = time.time()
	while i < len(targetArray):
		if stringArray[i] != targetArray[i]:
			stringArray[i]  = chr(random.randint(32, 126))

		if stringArray[i] == targetArray[i]:
			i += 1

		x = 0
		
		print("\r", end="")
		
		while x < len(stringArray):
			print(stringArray[x], end="", flush=True)
			x += 1
		time.sleep(.01)
		
	return startTime

def results(stringArray, startTime):
	print("\n\nThe password is: ", end="")
	print("".join(stringArray))
	print("The elasped time to complete the crack was: "+ str(round(time.time() - startTime, 2))+ " seconds")


if __name__ == "__main__":
    main()