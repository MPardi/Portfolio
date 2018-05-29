import requests, html5lib, csv, time, sys
from bs4 import BeautifulSoup


# Initial URL to main site domain
URL = "http://cleverinvestorvault.com/"


alphabetSiteLinks = []                                              # Holds links to pages listed at bottom (A-Z)
questionLinks = []                                                  # Holds links to invidual question pages
catLinks = []                                                       # Holds faq catagorie links
faqPagesLinks = []                                                  # Holds the links for each faq catagories pages
faqQuestionLinks = []                                               # Holds the links to each faq question

questionsAndAnswers = []                                            # Holds the question and answers from question and faq pages

def main():
    print("*** Starting webscrape of http://cleverinvestorvault.com ***".center(25))
    
    time.sleep(1)

    print()
    print("STARTING FAQ DIRECTORY SCRAPE: ")

    faqScrape()

    print()
    print("FAQ QUESIIONS SUCCESSFULLY SCRAPED", end = '', flush = True)
    time.sleep(1)
    print("------> MOVING ONTO MAIN QUESTION CONTENT SCRAPE: ")

    mainScrape()

    print()
    print("MAIN QUESTION CONTENT HAS BEEN SUCCESSFULLY SCRAPED")
    time.sleep(1)
    print()
    print("NOW WRITING TO A CSV FILE --> ", end = '')

    spinner = spinning_cursor()
    for _ in range(50):
        sys.stdout.write(next(spinner))
        sys.stdout.flush()
        time.sleep(0.1)
        sys.stdout.write('\b')

    makeFile()

    print()
    print("*** SITE HAS BEEN SUCCESSFULLY SCRAPED ***")

    time.sleep(2)

def faqScrape():
    # Web request declaration to get url source
    r = requests.get(URL)

    # Instantiation of a BeautifulSoup object to scrape/parse using html5lib
    page = BeautifulSoup(r.content, 'html5lib')

    sidebar = page.find('ul', attrs = {'class':'nav-list'})

    faqPage = sidebar.find('a')['href']

    r2 = requests.get(URL+faqPage)

    allCatagoriesPage = BeautifulSoup(r2.content, 'html5lib')

    faqContent = allCatagoriesPage.find('div', attrs = {'class':'tab-pane'})

    for entry in faqContent.findAll('a'):
        if (not entry['title'] == "Clever Products and Services") and (not entry['title'] == "M5 Marketing System"):
            catLink = {}
            catLink['link'] = entry['href']
            catLink['numQuestions'] = getNumFromString(entry.find_next_sibling('span').getText())
            catLinks.append(catLink)

    for link in catLinks:
        r2 = requests.get(URL+link['link'])
        i = 1

        # for thing in range(1, link['numQuestions']):
        while i <= (link['numQuestions']/10)+1:
            faqPage = BeautifulSoup(r2.content, 'html5lib')
            directLinks = faqPage.find('ul', attrs = {'class':'phpmyfaq_ul'})

            for entry in directLinks.findAll('a'):
                faqQuestionLinks.append(entry['href'])

            if i <= (link['numQuestions']/10):
                pagination = faqPage.find('div', attrs = {'class':'pagination'})
                currentPage = pagination.find('li', attrs = {'class':'active'})
                nextPageParent = currentPage.find_next_sibling()

                nextPageLink = nextPageParent.find('a')['href']

                r2 = requests.get(URL+nextPageLink)

            i += 1

    sys.stdout.write('\x1b[1A')
    sys.stdout.write('\x1b[2K')
    print("FAQ DIRECTORY SCRAPE COMPLETE ", end = '', flush = True)
    time.sleep(1)
    print("------> MOVING ONTO INDIVIDUAL FAQ QUESTIONS:")

    for link in faqQuestionLinks:
        r2 = requests.get(URL+link)
        faqPage = BeautifulSoup(r2.content, 'html5lib')

        print("Current Question link: " + (URL+link))
        sys.stdout.write('\x1b[1A')
        sys.stdout.write('\x1b[2K')

        faqQuestionAnswer = {}

        faqHeader = faqPage.find('div', attrs = {'id':'mainContent'})

        faqQuestionAnswer['question'] = faqHeader.find('h2').getText()

        faqArticle = faqPage.find('article', attrs = {'class':'answer'})

        if faqArticle.find('p') is not None:
            faqQuestionAnswer['answer'] = faqArticle.find('p').getText()

        questionsAndAnswers.append(faqQuestionAnswer)

def mainScrape():
    # Web request declaration to get url source
    r = requests.get(URL)

    # Instantiation of a BeautifulSoup object to scrape/parse using html5lib
    page = BeautifulSoup(r.content, 'html5lib')

    # Finds the first and stores entire div tag of class 'span12'
    table = page.find('div', attrs = {'class':'span12'})

    # Finds all a tags in the 'span12' div 
    for row in table.findAll('a'):
        alphabetSiteLink = row['href']                                 # Stores the href attribute of a
        alphabetSiteLinks.append(alphabetSiteLink)                     # Adds object to alphabetSiteLink array

    # Goes through the hrefs from the previous for loop
    for link in alphabetSiteLinks:
        r = requests.get(URL+link)                                     # Web request to new url 
        page = BeautifulSoup(r.content, 'html5lib')                    # Updates content to new request

        table = page.find('div', attrs = {'id':'mainContent'})         # Finds and stores a div tag of class 'mainContent'  

        row = table.find('ul', attrs = {'class':''})                   # Finds and stores a ul tag that has no class attribute

        # Checks to see if something was actually scraped, to avoid errors
        if row != None:
            for entry in row.findAll('a'):                             #  Finds all a tags in the row object
                questionLink = entry['href']                           #  Scrapes the href attribute of each a tag
                questionLinks.append(questionLink)                     #  Adds this object to the questionLinks array

    for link in questionLinks:
        r = requests.get(URL+link)                                     # Web request to new url 
        page = BeautifulSoup(r.content, 'html5lib')                    # Updates content to new request

        print("Current Question link: " + (URL+link))
        sys.stdout.write('\x1b[1A')
        sys.stdout.write('\x1b[2K')

        questionAnswer = {}                                            # Creates a new dictionary object

        header = page.find('div', attrs = {'id':'mainContent'})        # Finds a div tag of class 'mainContent'

        questionAnswer['question'] = header.find('h2').getText()       # Adds the first h2 tags text to the dictionary 

        article = page.find('article', attrs = {'class':'answer'})     # Finds article tag of class 'answer'

        if article.find('p') is not None:
            questionAnswer['answer'] = article.find('p').getText()     # If a p tag is found then add its text to the dictionary

        questionsAndAnswers.append(questionAnswer)                      # Add questionAnswer dictionary to questionsAndAnswers array

def makeFile():
    filename = 'investorQA.csv'

    # Open file stream to allow creation of file using a dictionary.
    with open(filename, 'w') as f:
        w = csv.DictWriter(f,['question', 'answer'])                   # Initialize a dictwriter 
        w.writeheader()                                                # Writes w to the writeheader                        
        for questionAnswer in questionsAndAnswers:                      # For every dictionary in the array 
            w.writerow(questionAnswer)                                 # write the current dictionary to the file

def getNumFromString(string):  
    # Create empty string to store numbers as a string  
    num = ''  
    # Loop through characters in the string  
    for i in string:  
        # If one of the characters is a number, add it to the empty string  
        if i in '1234567890':  
            num+=i  
    # Convert the string of numbers to an integer  
    integer = int(num)  
    return integer  

def spinning_cursor():
    while True:
        for cursor in '|/-\\':
            yield cursor


if __name__== "__main__":
    main()

	
	

