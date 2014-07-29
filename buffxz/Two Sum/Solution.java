public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int[] index = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            index[i] = i + 1;
        }
        
        quickSort(numbers, index, 0, numbers.length - 1);
        int left = 0;
        int right = numbers.length - 1;
        
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                result[0] = Math.min(index[left], index[right]);
                result[1] = Math.max(index[left], index[right]);
                return result;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        
        return result;
    }
    
    public void quickSort(int[] numbers, int[] index, int left, int right) {
        int i = left;
        int j = right;
        int pivot = numbers[left + (right - left) / 2];
        while (i <= j) {
            while (numbers[i] < pivot) i++;
            while (numbers[j] > pivot) j--;
            
            if (i <= j) {
                swap(numbers, index, i, j);
                i++;
                j--;
            }
        }
        if (i < right) {
            quickSort(numbers, index, i, right);
        }
        if (j > left) {
            quickSort(numbers, index, left, j);
        }
    }
    
    public void swap(int[] numbers, int[] index, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
        
        int tempIndex = index[i];
        index[i] = index[j];
        index[j] = tempIndex;
    }
}