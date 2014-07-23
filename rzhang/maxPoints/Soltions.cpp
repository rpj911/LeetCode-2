/**
 *  * Definition for a point.
 *   * struct Point {
 *    *     int x;
 *     *     int y;
 *      *     Point() : x(0), y(0) {}
 *       *     Point(int a, int b) : x(a), y(b) {}
 *        * };
 *         */
class Solution {
public:
    int maxPoints(vector<Point> &points) {
        int size = points.size();
        if (size == 0) {
            return 0;
        }
        
        unordered_map<float, int> stat;
        
        int max = 0;
        
        for (int i = 0; i < size; i++) {
            stat.clear();
            int duplicate = 1;
            for (int j = i + 1; j < size; j++) {

                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    duplicate++;
                    continue;
                }
                if (points[j].x == points[i].x) {
                    stat[INT_MAX]++;
                    continue;
                }
                float key = (float)(points[j].y - points[i].y)/(points[j].x - points[i].x);
                stat[key]++;
            }
            
            if (stat.size() == 0 && duplicate > max) {
                    max = duplicate;
            }
            
            for (unordered_map<float,int>::iterator it = stat.begin(); it != stat.end(); it++) {
                if (it->second + duplicate > max) {
                    max = it->second + duplicate;
                }
            }
        }
        
        return max;
    }
};
