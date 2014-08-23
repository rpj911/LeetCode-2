import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HuluSolution {
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line);
        
        // get the input 
        String[] input = new String[n];
        for (int i = 0; i < n; i++) {
        	input[i] = br.readLine();
        }
        
        for (int i = 0; i < n; i++) {
        	String curInput = input[i];
        	String[] curStrings = curInput.split("--");
        	
        	Map<String, List<String>> children = new HashMap<String, List<String>>();
        	Map<String, Item> nameToItem = new HashMap<String, Item>();
        	
        	for (int j = 0; j < curStrings.length; j++) {
        		String[] items = curStrings[j].split(",");
        		//
        		String name = items[0];
        		String boss = items[1];
        		String title = items[2];
        		int year = Integer.parseInt(items[3]);
        		Item curItem = new Item(name, title, year);
        		
        		// updata map
        		if (children.containsKey(boss)) {
        			children.get(boss).add(name);
        		} else {
        			List<String> childList = new ArrayList<String>();
        			childList.add(name);
        			children.put(boss, childList);
        		}
        		nameToItem.put(name, curItem);
        	}
        	
        	for (String itrString : children.keySet()) {
        		List<String> tempList = children.get(itrString);
        		Collections.sort(tempList);
        	}
        	
        	Item ceoItem = nameToItem.get(children.get("NULL").get(0));
        	System.out.println("Case #" + (i+1));
        	dfsPrint(ceoItem, children, nameToItem, 0);
        }
        
	}
	
	/** The dfs help function to print the res */
	private static void dfsPrint(Item item, Map<String, List<String>> children, Map<String, Item> nameToItem, int level) {
		StringBuilder sb = new StringBuilder();
		int k = level;
		while (k > 0) {
			sb.append('-');
			k--;
		}
		System.out.println(sb.toString() + item.name + " (" + item.title + ") " + item.year);
		
		if (children.containsKey(item.name)) {
			List<String> links = children.get(item.name);
			for (String itr : links) {
				Item curItem = nameToItem.get(itr);
				dfsPrint(curItem, children, nameToItem, level+ 1);
			}
		}
	}
	
	/** Data Item */
	private static class Item {
		String name;
		String title;
		int year;
		Item(String name, String title, int year) {
			this.name = name;
			this.title = title;
			this.year = year;
		}
	}
	
}