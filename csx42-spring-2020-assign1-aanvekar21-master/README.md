# CSX42: Assignment 1
## Name: Akshay Kumar Anvekar

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in wordPlay/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile wordPlay/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile wordPlay/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile wordPlay/src/build.xml run -Darg0="input.txt" -Darg1="output.txt" -Darg2="metrics.txt"

Note: Arguments accept the absolute path of the files.


-----------------------------------------------------------------------
## Description:

###### Assumption:
1. The primary assumption is expected the input file would be well formated with each sentence terminating with period and no sentence would be contain extra spaces.

2. The file path for input.txt, output.txt and metrices.txt is provided while passing the arguments

###### Data Structure:
1. Hash Map is used to store the most frequently occuring words in a text file as it stores in the form of key and value pair.
2. Arrays are used to store the words characters and sentences of the input text.
3. The time complexity of method is Longest word is O(n^2) and for Max frequency is O(n)

###### Code Flow:
The input is taken from Driver Class and the inputed text is then passed to FileProcessor Class.This inputed text is then passed to Metrics class which performs the metrics calculation and Sentence Handler class which performs reversing of string.

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: 06 Feb 2020


