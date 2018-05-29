import os, praw

#   Opening prompt
print("This is a demo of this script on the first 10 posts on the first page of r/videos hot\n")

#   Stores the thread titles as a key and the url of the video link as the value
videoDict = {}

#   Used to number the video filenames based on index position in the dictionary
videoNumbering = 1

#   Initialization of PRAW API
reddit = praw.Reddit(client_id='p9pEn728dzxNBg',
                     client_secret='A4G5z9QNo6-GKdHHwJrNOVDAWgk', password='RippedTits84!',
                     user_agent='PrawTut', username='LanfuidRap')

#   Prompts the user for the amount of videos they'd like to download, this sets the numOfVideos variable to the desired number inputted by the user
numOfVideos = input("How many videos from r/videos would you like to download? ")

#   Initial that grabs the desired amount of posts from the r/videos subreddit according to the 'hot' listing
for submission in reddit.subreddit('videos').hot(limit=numOfVideos):
    #   Adds the thread title and video url to the dictionary
    if submission.url.startswith("https://www.youtube.com") or submission.url.startswith("https://youtu.be"):
        videoDict[submission.title] = submission.url
    else:
        continue

# #   Checks each url in the dictionary and removes any listings that aren't from YouTube
# for title, url in videoDict.items():
#     #   If the url starts with either possible YouTube address styles keep them, otherwise delete the dictionary item
#     if url.startswith("https://www.youtube.com") or url.startswith("https://youtu.be"):
#         continue
#     else:
#         del videoDict[title]

#   Iterate through the final dictionary and runs youtube-dl on each listing
for title, url in videoDict.items():
    #   Prints the current videos dictionary information
    print("The submission title is %s and it is located at %s\n" % (title, url))

    #   Parameters to run youtube-dl, setting the file name to video+position in dictionary and downlaods the best quality version of the particular video
    videoDl = "youtube-dl -o 'video" + str(videoNumbering) + "' -f bestvideo+bestaudio/best " + url
    #   Actual command call to youtube-dl
    os.system(videoDl)
    #   Increases the video numbering value
    videoNumbering += 1
