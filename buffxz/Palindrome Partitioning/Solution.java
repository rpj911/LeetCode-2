public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        HashMap<String, ArrayList<ArrayList<String>>> map = new HashMap<String, ArrayList<ArrayList<String>>>();
        HashMap<String, Boolean> palindromeMap = new HashMap<String, Boolean>();
        return helper(s, map, palindromeMap);
    }
    
    public ArrayList<ArrayList<String>> helper(String s, HashMap<String, ArrayList<ArrayList<String>>> map, HashMap<String, Boolean> palindromeMap) {
        if (map.get(s) != null) {
            return map.get(s);
        }
        
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        for (int i = 1; i <= s.length(); i++) {
            String temp = s.substring(0, i);
            boolean flag;
            if (palindromeMap.get(s) != null) {
                flag = palindromeMap.get(s);
            } else {
                flag = isPalindrome(temp);
            }
            palindromeMap.put(temp, flag);
            
            if (flag) {
                if (i == s.length()) {
                    ArrayList<String> tempRes = new ArrayList<String>();
                    tempRes.add(temp);
                    result.add(tempRes);
                } else {
                    String behind = s.substring(i, s.length());
                    ArrayList<ArrayList<String>> subRes;
                    if (map.get(behind) != null) {
                        subRes = map.get(behind);
                    } else {
                        subRes = helper(behind, map, palindromeMap);
                    }
                    
                    for (ArrayList<String> itrSubRes : subRes) {
                        ArrayList<String> tempList = new ArrayList<String>();
                        tempList.addAll(itrSubRes);
                        tempList.add(0, temp);
                        result.add(tempList);
                    }
                }
            }
        }
        
        map.put(s, result);
        return result;
    }
    
    public boolean isPalindrome(String s) {
        int left = 0; 
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}                                                                                           