
public class BasicStaff {
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void quickSort(int[] arr, int left, int right) {
    	int i = left;
    	int j = right;
		int pivot = arr[left + (right - left) / 2];
		while (i < j) {
			while(arr[i] < pivot) i++;
			while(arr[j] > pivot) j--;
			if (i <= j) {
				swap(arr, i, j);
				i++;
				j--;
			}
		}
		
		if (j > left) {
			quickSort(arr, left, j);
		}
		
		if (i < right) {
			quickSort(arr, i, right);
		}
	}
    
    public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
    
    public static void mergeSort(int[] arr) {
    	int[] aux = new int[arr.length];
    	mergeSort(arr, aux, 0, arr.length - 1);
    }
    
    public static void mergeSort(int[] arr, int[] aux, int left, int right) {
		if (right <= left) return;
		int mid = left + (right - left) / 2;
		mergeSort(arr, aux, left, mid);
		mergeSort(arr, aux, mid + 1, right);
		merge(arr, aux, left, mid, right);
	}
    
    public static void merge(int[] arr, int[] aux, int left, int mid, int right) {
    	for (int i = left; i <= right; i++) {
    		aux[i] = arr[i];
    	}
    	
    	int k = left;
    	int i = left;
    	int j = mid + 1;
    	while (i <= mid && j <= right) {
    		if (aux[i] < aux[j]) {
    			arr[k++] = aux[i++];
    		} else {
    			arr[k++] = aux[j++];
    		}
    	}
    	
    	while (i <= mid) {
    		arr[k++] = aux[i++];
    	}
    	
    	while (j <= right) {
    		arr[k++] = aux[j++];
    	}
    }
    
    public static void main(String[] args) {
		int[] arr = {3, 1, 4, 5, 2, 1, 1, 0};
//		quickSort(arr, 0, arr.length - 1);
		mergeSort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
