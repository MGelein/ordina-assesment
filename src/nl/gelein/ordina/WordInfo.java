package nl.gelein.ordina;

/**
 * This is a simple data holder, providing a read-only interface for word info statistics
 * @author Mees Gelein
 */
public class WordInfo implements WordFrequency{
	
	/**
	 * The word this object is associated with
	 */
	private String word;
	/** 
	 * Amount of times this word was counted
	 */
	private int frequency = 0;
	
	/**
	 * Creates a new WordInfo Object that will keep track of the frequency of the associated word
	 * @param word the string that we're keeping track of
	 * @param frequency the amount of times that word was encountered
	 */
	public WordInfo(String word, int frequency) {
		this.word = word;
		this.frequency = frequency;
	}

	/**
	 * Returns the word that is associated with this WordInfo object
	 * @return the word that belongs to this object
	 */
	public String getWord() {
		return word;
	}

	/**
	 * Returns the associated frequency of this word
	 * @return amount of times this word has been counted
	 */
	public int getFrequency() {
		return frequency;
	}

}
