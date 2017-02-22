public class KMP {

	public static void main (String[] args) {
		char[] pattern = {'a', 'b', 'c', 'd', 'a', 'b', 'c', 'a'};
		int[] precomputedTable = makeTable(pattern);
		for(int i : precomputedTable) {
			System.out.printf("%d ", i);
		}
		System.out.println();
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

	


}