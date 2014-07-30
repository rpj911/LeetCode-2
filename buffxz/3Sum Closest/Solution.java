public class Solution {
    public int threeSumClosest(int[] num, int target) {
        quickSort(num, 0, num.length - 1);
        
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < num.length - 2; i++) {
            int curSum = num[i];
            int left = i + 1;
            int right = num.length - 1;
            while (left < right) {
                int temp = num[left] + num[right];
                int sum = curSum + temp;
                if (Math.abs(target - sum) < min) {
                    min = Math.abs(target - sum);
                    res = sum;
                }
                
                if (temp > target - curSum) {
                    right--;
                } else if (temp < target - curSum) {
                    left++;
                } else {
                    return res;
                }
            }
        }                
        
        return res;
    }
    
    public void quickSort(int[] numbers, int left, int right) {
        int i = left;
        int j = right;
        int pivot = numbers[left + (right - left) / 2];
        while (i <= j) {
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
}