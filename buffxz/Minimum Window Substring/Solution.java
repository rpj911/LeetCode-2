public class Solution {
	 public static String minWindow(String S, String T) {  
	     if (S.length() < T.length()) return "";
	     
		 int[] count = new int[200];
		 int[] cur = new int[200];
		 for (int i = 0; i < T.length(); i++) {
			 count[T.charAt(i)]++;
		 }
		 
		 //
		 int min = Integer.MAX_VALUE;
		 int index = 0;
		 for (int i = 0, j = 0; i < S.length(); i++) {
			 for (; j < S.length(); j++) {
				 char c = S.charAt(j);
				 if (count[c] == 0) continue;
				 cur[c]++;
				 if (valid(count, cur)) {
					 int length = j - i + 1;
					 if (length < min) {
						 min = length;
						 index = i;
					 }
					 cur[c]--;
					 break;
				 }
			 }
			 if (count[S.charAt(i)] != 0) cur[S.charAt(i)]--;
		 }
		 return min == Integer.MAX_VALUE ? "" : S.substring(index, index + min);
	 }
	 
	 public static boolean valid(int[] count, int[] cur) {
		 for (int i = 0; i < count.length; i++) {
			 if (cur[i] < count[i]) return false;
		 }
		 return true;
	 }
}