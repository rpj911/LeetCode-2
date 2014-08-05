public class Solution {
 public int searchInsert(int[] A, int target) {  
   int low = 0, high = A.length - 1;  
   while (low <= high) {  
     int mid = (low + high) / 2;  
     if (A[mid] == target) return mid;  
     if (A[mid] < target) {  
       low = mid + 1;  
     } else {  
       high = mid - 1;  
     }  
   }  
   return low;  
 }  
}