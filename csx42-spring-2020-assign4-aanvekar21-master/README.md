# CSX42: Assignment 4
## Name: Akshay Kumar Anvekar


-----------------------------------------------------------------------
## Inputs

input.txt - provide absolute input filepath
availableItems.txt - provide absolute available Items filepath
Window Size is 0 or greater
output.txt - provide absolute output filepath

----------------------------------------------------------------------
Following are the commands and the instructions to run ANT on your project.

Note: build.xml is present in statePattern/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile statePattern/src/build.xml clean

Description: It cleans up all the .class files that were generated when you compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile statePattern/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile statePattern/src/build.xml run -DinputFile="input.txt" -DavailableItemsFile="availableItems.txt" -DrunningAverageWindowSize=2 -DoutputFile="output.txt"


Arguments accept the absolute path of the files.
-----------------------------------------------------------------------
## Description:

1. Assumptions:
- The input file is well formated and as per the description of Assignment.


2. Data structures:

- I have used Hash Map to store the Available items data in the form of Key as its item category and value as the item name.
     Eg: basic:householdItem
    "basic" is the key and "householdItem" is the value.


3. Compiling: Follow the instruction as mentioned above.

4. Run: Follow the instructions as mentioned above.


5. External materials: 
- www.baeldung.com

--------------------------------------------------------------------------------
## Academic Honesty statement:
"We have done this assignment completely on our own. We have not copied it, nor have we given our solution to anyone else. We understand that if we are involved in plagiarism or cheating an official form will be submitted to the Academic Honesty Committee of the Watson School to determine the action that needs to be taken."

Date: 20/04/2020
