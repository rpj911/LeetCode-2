class Solution {
public:
    int candy(vector<int> &ratings) {
        int* candies = new int[ratings.size()];
        int prev = 0;
        
        for (int i = 0; i < ratings.size(); ++i) {
            if (i == 0 || ratings[i] > ratings[i - 1]) {
                candies[i] = prev + 1;
            } else if (ratings[i] == ratings[i - 1]) {
                candies[i] = 1;
            } else {
                candies[i] = prev - 1;
            }
            
            if (i == ratings.size() - 1 || (ratings[i + 1] >= ratings[i] && i > 0 && ratings[i - 1] >= ratings[i])) {
                int diff = 0;
                if (i > 0 && ratings[i] <= ratings[i - 1]) {
                    diff = 1 - candies[i];
                }
                int j = i;
                
                
                while (j > 0 &&  ratings[j - 1] > ratings[j]) {
                    candies[j] += diff;
                    j--;
                }
                
                if (diff > 0) candies[j] += diff;
            }
            
            prev = candies[i];
        }
        
        int sum = 0;
        
        for (int i = 0; i < ratings.size(); i++) {
            sum += candies[i];
        }
        
        return sum;
    }
};
