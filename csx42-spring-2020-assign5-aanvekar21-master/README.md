# CSX42: Assignment 5
## Name: Akshay Kumar Anvekar
### aanveka2@binghamto.edu (B00813848)

-----------------------------------------------------------------------
## Inputs
input.txt - provide absolute input filepath acceptableWords.txt - provide absolute acceptableWords filepath Window Size is  greaterthan 0 spellCheckOutput.txt - provide absolute output filepath topKOutput.txt - provide absolute output filepath



----------------------------------------------------------------------


-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile spellChecker/src/build.xml clean

Description: It cleans up all the .class files that were generated when you compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile spellChecker/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile spellChecker/src/build.xml run -DinputFile="input.txt" -DacceptableWords="acceptableWords.txt" -DsizeOfFreqWords="2" -DtopKoutputFile="topKOutput.txt" -DspellCheckerOutputFile="spellCheckOutput.txt"

 #### Arguments accept the absolute path of the files.
-----------------------------------------------------------------------
## Description:

1. Assumptions:
The input file is well formated and as per the description of Assignment.There would be repetation of missplet words if there are more than one occurence of missplet words in input.txt

2. Data structures:
Used Priority queue for implementing the TopKElements also made us of Map, Array List for various purpose of storing and iterating.

3. Compiling: Follow the instruction as mentioned above.

4. Run:Follow the instructions as mentioned above.


5. External materials: 
Leetcode, GeeksforGeeks,www.baeldung.com

#### I have used my leftover 1 day of Slack days alloted by professor. I hope I donot get penalty for submiting in 3rd May 2020.

--------------------------------------------------------------------------------
## Academic Honesty statement:
"We have done this assignment completely on our own. We have not copied it, nor have we given our solution to anyone else. We understand that if we are involved in plagiarism or cheating an official form will be submitted to the Academic Honesty Committee of the Watson School to determine the action that needs to be taken."

Date: 03-05-2020
