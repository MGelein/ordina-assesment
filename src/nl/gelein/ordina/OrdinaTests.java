package nl.gelein.ordina;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Handles all the Unit testing using JUnit 5 for the Ordina test case
 * @author Mees Gelein
 */
class OrdinaTests {

	@Test
	void testWordFrequency() {
		String word = "word";
		int frequency = 1;
		WordFrequency wordFrequency = new WordInfo(word, frequency);
		
		assertEquals(wordFrequency.getFrequency(), frequency);
		assertTrue(wordFrequency.getWord().equals(word));
	}
	
	@Test
	void testHighestFrequency() {
		String textThe = "The person that gave the best answer of the world.";
		String textEmpty = "";
		
		OrdinaCase ordinaCase = new OrdinaCase();
		assertEquals(3, ordinaCase.calculateHighestFrequency(textThe));
		assertEquals(0, ordinaCase.calculateHighestFrequency(textEmpty));
	}
	
	@Test
	void testFrequencyForWord() {
		String text = "The person that gave the best answer of the world.";
		String textEmpty = "";
		
		OrdinaCase ordinaCase = new OrdinaCase();
		assertEquals(3, ordinaCase.calculateFrequencyForWord(text, "the"));
		assertEquals(3, ordinaCase.calculateFrequencyForWord(text, "The"));
		assertEquals(0, ordinaCase.calculateFrequencyForWord(text, "he"));
		assertEquals(1, ordinaCase.calculateFrequencyForWord(text, "answer"));
		
		assertEquals(0, ordinaCase.calculateFrequencyForWord(textEmpty, "the"));
	}
	
	@Test
	void testMostFrequentNWords() {
		String text = "The sun shines over the lake.";
		
		OrdinaCase ordinaCase = new OrdinaCase();
		List<WordFrequency> mostFrequentNWords = ordinaCase.calculateMostFrequentNWords(text, 3);
		assertEquals(3, mostFrequentNWords.size());
		
		WordFrequency firstItem = mostFrequentNWords.get(0);
		assertEquals(2, firstItem.getFrequency());
		assertTrue(firstItem.getWord().equals("the"));
		
		WordFrequency secondItem = mostFrequentNWords.get(1);
		assertEquals(1, secondItem.getFrequency());
		assertTrue(secondItem.getWord().equals("lake"));
		
		WordFrequency thirdItem = mostFrequentNWords.get(2);
		assertEquals(1, thirdItem.getFrequency());
		assertTrue(thirdItem.getWord().equals("over"));
	}

}
