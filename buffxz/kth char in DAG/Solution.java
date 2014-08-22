import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String args[] ) throws Exception {
    	
    	// read data
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line);
        
        InputItem[] inputData = new InputItem[n];
        
        // build the init data
        for (int i = 0; i < n; i++) {
        	line = br.readLine();
        	String[] arr = line.split(" ");
        	inputData[i] = new InputItem(Integer.parseInt(arr[0]), Double.parseDouble(arr[1]), Double.parseDouble(arr[2]));
        }
        
        // seperate the data by starting time and ending time. And sort according to the time value;
        // The idea is that traver the data from the first one to the last one. There are two cases:
        // 1. meeting a starting node (a node with value of starting time), do nothing;
        // 2. meeting an ending node (a node with value of ending time), make the correponding value to be 1, which means that 
        //	  this interval is finished. Then calculate the sum from the next index to current ending index;
        // A quick data structure is to use segement tree to provide fast range query.
        
        ComputingItem[] data = new ComputingItem[2 * n];
        for (int i = 0; i < n; i++) {
        	InputItem curInputItem = inputData[i];
        	ComputingItem startingItem = new ComputingItem(curInputItem.id, true, curInputItem.start);
        	ComputingItem endingItem = new ComputingItem(curInputItem.id, false, curInputItem.end);
        	int pos = i * 2;
        	data[pos] = startingItem;
        	data[pos + 1] = endingItem;
        }
        Arrays.sort(data);
        
        // build segment tree
        int[] array = new int[2 * n];
        MySegmentTree segmentTree = new MySegmentTree();
        Node root = segmentTree.buildTree(array, 0, array.length - 1);
        
        // traverse
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); //from id to index
        ArrayList<ResItem> res = new ArrayList<>(2 * n);
        for (int i = 0; i < data.length; i++) {
        	ComputingItem cur = data[i];
        	if (cur.isStart) {
        		map.put(cur.id, i);
        	} else {
        		int index = map.get(cur.id);
        		segmentTree.updateValueAtIndex(root, index, array[index] + 1, array);
        		int score = segmentTree.getSum(root, index + 1, i);
        		res.add(new ResItem(cur.id, score));
        	}
        }
        
        Collections.sort(res);
        for (ResItem itr : res) {
        	System.out.println(itr.id + " " + itr.value);
        }
        
        
    }
    
    /** Data item for storaging the input data */
    private static class InputItem {
    	int id;
    	double start;
    	double end;
    	InputItem(int id, double start, double end) {
    		this.id = id;
    		this.start = start;
    		this.end = end;
    	}
    }
    
    /** Data item used to sort the time value and for further processing */
    private static class ComputingItem implements Comparable<ComputingItem> {
    	int id;
    	boolean isStart;
    	double value;
    	ComputingItem(int id, boolean isStart, double value) {
    		this.id = id;
    		this.isStart = isStart;
    		this.value = value;
    	}
    	
    	@Override
    	public int compareTo(ComputingItem other) {
    		return this.value > other.value ? 1 : this.value == other.value ? 0 : -1;
    	}
    }
    
    /** Result item for sorting by the value(score) */
    private static class ResItem implements Comparable<ResItem> {
    	int id;
    	int value;
    	ResItem(int id, int value) {
    		this.id = id;
    		this.value = value;
    	}
    	
    	@Override
    	public int compareTo(ResItem other) {
    		return this.value > other.value ? 1 : this.value < other.value ? -1 : this.id > other.id ? 1 : -1;
    	}
    }
    
    
    /**My segment tree*/
    /**
     * A segment tree data structure
     * @author zxu
     */

    private static class MySegmentTree {
    	
    	/** Build a segment tree from an array, with specifying the left and right index */
    	Node buildTree(int[] array, int left, int right) {
    	    if (left == right) {
    	        Node node = new Node(left, right, array[left]);
    	        return node;
    	    }
    	    int mid = (left + right) / 2;
    	    
    	    // build the left and right tree
    	    Node leftNode = buildTree(array, left, mid);
    	    Node rightNode = buildTree(array, mid + 1, right);
    	    
    	    Node root = new Node(leftNode.leftIndex, rightNode.rightIndex, leftNode.sum + rightNode.sum);
    	    root.leftNode = leftNode;
    	    root.rightNode = rightNode;
    	    return root;
    	}
    	
    	/** Get the sum from index left to index right, inclusively */
    	int getSum(Node root, int left, int right) {
    	    if (root.leftIndex >= left && root.rightIndex <= right) {
    	        return root.sum;
    	    }
    	    if (root.rightIndex < left || root.leftIndex > right) {
    	        return 0;
    	    }
    	    return getSum(root.leftNode, left, right) + getSum(root.rightNode, left, right);
    	}
    	
    	/**Update the value of the tree.*/
    	int updateValueAtIndex(Node root, int index, int newValue, int[] array) {
    	    int diff = 0;
    	    if(root.leftIndex == root.rightIndex && index == root.leftIndex) {
    	        diff = newValue - root.sum;
    	        root.sum = newValue;
    	        array[index] = newValue;
    	        return diff;
    	    }
    	    
    	    int mid = (root.leftIndex + root.rightIndex) / 2;
    	    if (index <= mid) {
    	        diff= updateValueAtIndex(root.leftNode, index, newValue, array);
    	    } else {
    	        diff= updateValueAtIndex(root.rightNode, index, newValue, array);
    	    }
    	    root.sum += diff;
    	    return diff;
    	}
    }
    
	/** A node structure for segment tree */
	public static class Node {
	    int leftIndex;
	    int rightIndex;
	    int sum;
	    Node leftNode;
	    Node rightNode;
	    
	    /** Constructor */
	    Node(int leftIndex, int rightIndex, int sum) {
	    	this.leftIndex = leftIndex;
	    	this.rightIndex = rightIndex;
	    	this.sum = sum;
	    }
	}

}