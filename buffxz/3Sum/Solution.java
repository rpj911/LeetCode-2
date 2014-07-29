public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num.length == 0) return result;
        // sort
        int left = 0;
        int right = num.length - 1;
        quickSort(num, left, right);
        
        for (int i = 0; i < right - 1; i++) {
            if (i > 0 && num[i] == num[i - 1]) continue;
            int cur = num[i];
            int target = 0 - cur;
            int low = i + 1;
            int high = right;
            
            while (low < high) {
                int sum = num[low] + num[high];
                if (sum == target) {
                    List<Integer> subRes = new ArrayList<Integer>();
                    subRes.add(cur);
                    subRes.add(num[low]);
                    subRes.add(num[high]);
                    result.add(subRes);
                    while (low < high &&  num[low + 1] == num[low]) {
                        low++;
                    }
                    low++;
                } else if (sum < target) {
                    while (low < high && num[low + 1] == num[low]) {
                        low++;
                    }
                    low++;
                } else {
                    while (low < high &&  num[high - 1] == num[high]) {
                        high--;
                    }
                    high--;
                }
            }
        }
        
        return result;
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