# The Porfolio of Michael Pardi

#### This repository contains examples of programming projects and assignments I've worked on. 

#### The orgnaization is based around the langauge/development environment.

#### __*Overview:*__

| Catagory        | Description |
| ------------- |-------------|
| Arduino   | Projects that utilized the Arduino environment and microcontrollers|
| Java    | Projects using the Java Programming language    |
| Python | Projects using Python and a multitude of libraries   |
| Swift	| Projects using Swift to develop iOS apps|
| Web Development | Projects using NodeJS/Javascript/HTML/CSS	|

#### __*Instructions for running these projects:*__

##### Arduino:
- Includes a project I made that allows you to wind wire onto a spool using a footswitch, this was done to create solenoids for a larger pinball machine project.		
- Instructions:
	- `Just compile and upload to a Teensy or Arduino using Arduino IDE`

##### Java:
- Quiz Applet: A larger GUI project, using Swing to create a quiz applet. 
- Athlete Database (Console): A console application for adding and keeping track of athletes in a database.
- Athlete Medal Applet: A GUI version of the 'Athlete Database (Console)' program. Uses Swing for GUI widgets. 
- Instructions:
	- `Compile with Java`

##### Python:
- Password Cracker: An attempt to make a brute-force password guessing tool. Just for fun :). Displays in terminal only, tried to make it look hacker cool.
- phpMyFAQ Webscrape: Uses Python3. This is a program that uses BeautifulSoup to scrape data from phpMyFAQ sites. This specific example is aimed at an investor Q&A website that contains hundreds of questions and answers. This will get the data and then export it to a .csv file that can be opened in Excel.
- Reddit Video Downloader: Uses Python2. A program that allows a user to download the newest 'Hot' videos off of Reddits /r/videos subreddit. This program makes use of the PRAW library, which allows you to create a user instance and browse Reddit through Python scripts. Originally intended to be a bot, but became a testbed. Program also makes use of Youtube-DL, a command-line tool that allows users to download YouTube videos using CLI commands. 
- Instructions:
	- Password Cracker:
		- `python3 passwordCracker.py`
	- phpMyFAQ Webscrape(Python3) and Reddit Video Downloader(Python2):
		- `virtualenv project_name`
		- `pip3/pip install -r requirements.txt`
		- `python3/python project_name.py`

##### Swift:
- Lunar Lander Game: A recreation of the 80's classic 'Lunar Lander' style game. Uses SpriteKit and GameplayKit Swift Libraries. This game was created for macOS, and is not intended to be played on an iOS device.
- Note Taker: A simple iOS note taking app. Allows users to create and store notes, and attach pictures to those notes using the camera or built in library.
- Optical Character Recognition Demo: A demo that makes use of third-party OCR libraries to detect written text using the iPhone camera. It works to some success, but still needs a little tuning. Is a proof of concept.
- Receipt Organizer App: An app that allows user to persistently create and review receipt listings. Users can take photos of the receipt in question and mark the location of purchase using the Google Maps API.
- Stop Watch App: A simple stop watch app, allows users to keep track of a span of time.
- Time Demo: Just a test to see how the Swift timer library works.
- Word Scramble: An iOS game where the user is given a bunch of letter tiles, and they must put them together to create a word. Similar to 'Scrabble'. Number of points are based on word complexity, which is tied to number of letters. Uses a word database that is quite large, an attempt to contain as many words as possible. 
- Instructions:
	- `Open and build/run in XCode`
##### Web Development:
- Server Calculator: A simple number calculator. Allows users to take two numbers, and perform addition, subtraction, multiplication or division on them.
- Server Photo Editor: Uses HTML5 canvas filters to add effects and edit photos. Users can upload photos, which are stored in a MongoDB instance. 
- Server Resume (Bootstrap): A resume demo that uses Bootstrap to improve CSS styling.
- Server Resume (Stock): A resume demo that doesn't include Bootstrap, making use of a custom, but more basic styling framework.
- Instructions:
	- All these demos require NodeJS be installed.
	- Photo Editor:
		- This app requires a MongoDB instance named 'galleryDB' to be present'
		- `node server.js`
		- In a browser navigate to `http://localhost:8080`
	- Porfolio UI Website:
		- This is a submodule repository of a UI test site using Bootstrap and Pre-compositing to display my Resume/CV.
		- To visit, go to `https://mpardi.github.io`
	- Everything else:
		- `node server.js`
		- In a browser navigate to `http://localhost:8080`



