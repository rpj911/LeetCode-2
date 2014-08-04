public class Solution {
    public int singleNumber(int[] A) {
        int temp = 0;
        
        for (int i = 0; i < A.length; i++) {
            temp = temp ^ A[i];
        }
        
        return temp;
    }
}