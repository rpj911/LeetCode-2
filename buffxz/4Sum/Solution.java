public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int len = num.length;
        if (len == 0) return result;
        quickSort(num, 0, len - 1);
        
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && num[i] == num[i -1]) continue;
            int levelOne = num[i];
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && num[j] == num[j -1]) continue;
                int levelTwo = num[j];
                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    int sum = levelOne + levelTwo + num[left] + num[right];
                    if (sum == target) {
                        result.add(makeList(num[i], num[j], num[left], num[right]));
                        while (left < right && num[left + 1] == num[left]) left++;
                        left++;
                        while (left < right && num[right - 1] == num[right]) right--;
                        right--;
                    } else if (sum < target) {
                        while (left < right && num[left + 1] == num[left]) left++;
                        left++;
                    } else {
                        while (left < right && num[right - 1] == num[right]) right--;
                        right--;
                    }
                }
            }
        }
        
        return result;
    }
    
    public void quickSort(int[] numbers, int left, int right) {
        int i = left;
        int j = right;
        int pivot = numbers[left + (right - left) / 2];
        while (i < j) {
            while (numbers[i] < pivot) i++;
            while (numbers[j] > pivot) j--;
            
            if (i <= j) {
                swap(numbers, i, j);
                i++;
                j--;
            }
        }
        if (i < right) {
            quickSort(numbers, i, right);
        }
        if (j > left) {
            quickSort(numbers, left, j);
        }
    }
    
    public void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
    
    public List<Integer> makeList(int a, int b, int c, int d) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(a);
        result.add(b);
        result.add(c);
        result.add(d);
        return result;
    }
}