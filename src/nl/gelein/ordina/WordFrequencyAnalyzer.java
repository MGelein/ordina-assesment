package nl.gelein.ordina;

import java.util.List;

/**
 * The interface that the main class for the technical assesment for Ordina
 * has to implement.
 * @author Mees Gelein
 */
public interface WordFrequencyAnalyzer {
	
	/**
	 * Returns the frequency of the word [a-zA-Z] with the highest frequency in the input text.
	 * @param text The input text, a string of words delimited by any non-alphabetic characters.
	 * @return the frequency of the most common word
	 */
	int calculateHighestFrequency(String text);
	
	/**
	 * Calculates the frequency of a given word in the provided text.
	 * @param text The input text that we are analyzing for the word.
	 * @param word The word that we are counting in the input text.
	 * @return the frequency of the specified word
	 */
	int calculateFrequencyForWord(String text, String word);
	
	/**
	 * Analyses the input text for the N most common words.
	 * @param text the input text that we are analyzing.
	 * @param n    the amount of most common words we have to return.
	 * @return a list of the N most common words
	 */
	List<WordFrequency> calculateMostFrequentNWords(String text, int n);
}
