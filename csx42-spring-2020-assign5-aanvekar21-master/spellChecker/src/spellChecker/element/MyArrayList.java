package spellChecker.element;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import spellChecker.util.FileProcessor;
import spellChecker.visitor.Visitor;

public class MyArrayList implements Element {

	private static Element myArrayList = new MyArrayList();
	static ArrayList<Element> sentenceArrayLst = new ArrayList<Element>();

	/**
	 * Constructor for MyArraylist
	 */
	public MyArrayList() {

	}

	/**
	 * Static Class for builder which reads and trims the line Incoming from
	 * fileprocessor
	 * 
	 * @author akshay_anvekar
	 *
	 */
	public static class Builder {

		public Builder withFileProcessor(FileProcessor fileProcessor)
				throws IOException, NullPointerException, FileNotFoundException {
			// TODO Auto-generated method stub
			String[] sentenceList = fileProcessor.readLine().split("\\.");
			for (int i = 0; i < sentenceList.length; i++) {
				String trimmedWord = sentenceList[i].trim();
				String pattern = "[a-zA-Z\\.\\s]+";
				if (trimmedWord.matches(pattern)) {
					MyElement obj = new MyElement(trimmedWord);
					sentenceArrayLst.add(obj);
				}
				else{
					System.out.println("Please Enter the  Input file with valid characters");
				}
			}

			return new Builder();
		}

		public Element build() {
			return myArrayList;

		}
	}

	/**
	 * Accept method to accept the visitor
	 */
	@Override
	public void accept(Visitor visitor) throws FileNotFoundException, IOException {

		for (Element e : sentenceArrayLst) {

			((Element) e).accept(visitor);
		}

	}
	public String toString() {
		return "MyArrayList  obj =" + myArrayList;
	}

}
