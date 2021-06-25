package nl.gelein.ordina;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

/**
 * A simple test case for the Ordina interview, requiring string manipulation.
 * @author Mees Gelein
 */
public final class OrdinaCase implements WordFrequencyAnalyzer{

	/**
	 * Entry point of the code, parsing command line parameters
	 * @param args	the command line parameters given to the program
	 */
	public static void main(String[] args) {
		//Generally not used, previously used during development to test some things, but now the tests show everything works
	}
	
	/**
	 * Creates Map of words and their respective counts for the given input text.
	 * @param text	a given input string, consisting of words([a-zA-Z]) delimited by all other characters.
	 * @return a map with the word statistics for each word (and thus their frequency) in the text.
	 */
	private Map<String, Integer> calculateTextStatistics(String text){
		//If there is no text, return an empty map.
		if(text.length() < 1) {
			//Alternatively you could throw an error, this depends on use-case and requirements.
			return new HashMap<String, Integer>();
		}
		
		//Split text into lowercase word array
		String[] words = text.toLowerCase().split("[^a-z]");	
		
		//Count every unique word
		HashMap<String, Integer> wordStats = new HashMap<String, Integer>();
		for(String word: words) {
			if(wordStats.containsKey(word)) {
				int oldFrequency = wordStats.get(word);
				wordStats.put(word, oldFrequency + 1);
			}else {
				wordStats.put(word, 1);
			}
		}
		return wordStats;
	}
	
	/**
	 * Returns a list with WordFrequency objects, ordered by their occurence rate.
	 * @param text a given input string.
	 * @return	a list of WordFrequency objects in order from most common to most rare.
	 */
	private List<WordFrequency> calculateOrderedTextStatistics(String text){
		Map<String, Integer> wordStats = calculateTextStatistics(text);
		
		//Converts the wordstats hashmap into a list of WordInfo objects
		Vector<WordFrequency> wordInfoList = new Vector<WordFrequency>();
		Set<String> uniqueWords = wordStats.keySet();
		for(String uniqueWord: uniqueWords) {
			wordInfoList.add(new WordInfo(uniqueWord, wordStats.get(uniqueWord)));
		}
		
		//Sorts the list and returns it
		Collections.sort(wordInfoList, new Comparator<WordFrequency>() {
			/**
			 * @param wordFrequencyA the first WordFrequency object to compare
			 * @param wordFrequencyB the second WordFrequency object to compare
			 */
			public int compare(WordFrequency wordFrequencyA, WordFrequency wordFrequencyB) {
				int diff = wordFrequencyB.getFrequency() - wordFrequencyA.getFrequency();
				if (diff != 0) {
					return diff;
				}else {
					return wordFrequencyA.getWord().compareTo(wordFrequencyB.getWord());
				}
			}
			
		});
		return wordInfoList;
	}

	@Override
	public int calculateHighestFrequency(String text) {
		List<WordFrequency> wordStats = calculateOrderedTextStatistics(text);
		
		//Prevent 0-length strings messing things up
		if(wordStats.size() > 0) {
			WordFrequency mostCommonWord = wordStats.get(0);
			return mostCommonWord.getFrequency();
		}else {
			//Alternatively, throw an exception here
			return 0;
		}
	}

	@Override
	public int calculateFrequencyForWord(String text, String word) {
		//If no word is given, return that you can't find it
		if(word.length() < 1) {
			//Alternatively this could throw a useful exception
			return 0;
		}
		
		Map<String, Integer> wordStats = calculateTextStatistics(text);
		if(wordStats.containsKey(word.toLowerCase())) {
			return wordStats.get(word.toLowerCase());
		}else {
			return 0;
		}
	}

	@Override
	public List<WordFrequency> calculateMostFrequentNWords(String text, int n) {
		List<WordFrequency> allOrderedWords = calculateOrderedTextStatistics(text);
		
		//An N value larger than the amount of words returns all words.
		if(n >= allOrderedWords.size()) { 
			//Alternatively, throw an error. This is dependant on the behaviour you want.
			n = allOrderedWords.size();
		}
		
		return allOrderedWords.subList(0, n);
	}

}
