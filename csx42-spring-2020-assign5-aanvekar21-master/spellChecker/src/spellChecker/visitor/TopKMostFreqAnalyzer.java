package spellChecker.visitor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import spellChecker.element.MyElement;
import spellChecker.results.Results;

public class TopKMostFreqAnalyzer implements Visitor {

	private int size;
	private Results topKFreqWordsResults;

	public TopKMostFreqAnalyzer(int k, Results inTopKFreqWordsResults) {
		topKFreqWordsResults = inTopKFreqWordsResults;
		size = k;

	}
	/**
	 * This method check the most frequent word appeared
	 */
	@Override
	public void visit(MyElement myElement) throws NullPointerException, IOException {
		
		Map<String, Integer> wordCountMap = new HashMap<String, Integer>();

		String wordList[] = myElement.getWordList();
		for (String word : wordList) {
			wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
		}
		PriorityQueue<String> heap = new PriorityQueue<String>(
				(w1, w2) -> wordCountMap.get(w1).equals(wordCountMap.get(w2)) ? w2.compareTo(w1)
						: wordCountMap.get(w1) - wordCountMap.get(w2));

		for (String word : wordCountMap.keySet()) {
			heap.offer(word);
			if (heap.size() > size)
				heap.poll();
		}

		List<String> ans = new ArrayList();
		while (!heap.isEmpty()) {
			ans.add(heap.poll());
			Collections.sort(ans);
		}

		topKFreqWordsResults.storeResults(ans.toString());
		
		

	}
	public String toString() {
		return "topKFreqWordsResults  obj =" + topKFreqWordsResults;
	}

}
