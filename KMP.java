public class KMP {

	public static void main (String[] args) {
		String textString = "abxabcabcaby";
		String patternString = "abcaby";
		char[] text = textString.toCharArray();
		char[] pattern = patternString.toCharArray();
		int[] precomputedTable = makeTable(pattern);
		for(int i : precomputedTable) {
			System.out.printf("%d ", i);
		}
		System.out.println();

		System.out.println(findString(text, pattern));
	}

	public static int[] makeTable(char[] pattern) {
		int length = pattern.length;
		int[] table = new int[length];
		int index = 0;

		for (int i = 1; i < length;) {
			if (pattern[index] == pattern[i]) {
				table[i] = index + 1;
				i++;
				index++;
			} else if (index == 0) {
				table[i] = 0;
				i++;
			} else {
				index = table[index - 1];
			}
		}
		return table;
	}

	public static int findString(char[] text, char[] pattern) {
		int[] table = makeTable(pattern);
		int textIndex = 0;
		int patternIndex = 0;

		while (textIndex < text.length && patternIndex < pattern.length) {
			if (text[textIndex] == pattern[patternIndex]) {
				textIndex++;
				patternIndex++;
			} else if (patternIndex != 0) 
				patternIndex = table[patternIndex - 1];
			else
				textIndex++;
		}

		return patternIndex == pattern.length ? textIndex - patternIndex : -1;
	}


}