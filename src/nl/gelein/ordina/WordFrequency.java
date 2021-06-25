package nl.gelein.ordina;

/**
 * Interface that describes a simple read-only data object which holds
 * info about the frequency of a specified word
 * @author Mees Gelein
 */
public interface WordFrequency {
	
	/**
	 * Returns the word that we are keeping track of
	 */
	String getWord();
	
	/**
	 * Returns the frequency of the word that we are keeping track of
	 */
	int getFrequency();
}
