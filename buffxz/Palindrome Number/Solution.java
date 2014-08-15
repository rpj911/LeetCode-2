public class Solution {
 public boolean isPalindrome(int x) {  
   if (x < 0) return false;  
   // make a reverse  
   long rev = 0, origin = x;  
   while (x > 0) {  
     rev = x%10 + rev*10;  
     x /= 10;  
   }  
   return (origin == rev);  
 }  
}