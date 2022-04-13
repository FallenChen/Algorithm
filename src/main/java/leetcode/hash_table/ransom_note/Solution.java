package leetcode.hash_table.ransom_note;

public class Solution {
	
	/**
	 * Given two stings ransomNote and magazine, return true if ransomNote can be constructed from magazine and false otherwise.
	 * Each letter in magazine can only be used once in ransomNote.
	 * 
	 * Input: ransomNote = "a", magazine = "b"
	 * Output: false
	 * 
	 * Input: ransomNote = "aa", magazine = "ab"
	 * Output: false
	 * 
	 * Input: ransomNote = "aa", magazine = "aab"
	 * Output: true
	 * 
	 * @param ransomNote
	 * @param magazine
	 * @return
	 */
	public boolean canConstruct(String ransomNote, String magazine) {
		int[] map = new int[26];
		for (char c : magazine.toCharArray()) {
			map[c - 'a']++;
		}
		for (char c : ransomNote.toCharArray()) {
			if (--map[c - 'a'] < 0) {
				return false;
			}
		}
		return true;
	}
}
