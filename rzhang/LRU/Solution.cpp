class LRUCache{
    
    struct entry {
        int key;
        int val;
        entry(int k, int v):key(k),val(v){}
    };
    
    list<entry>* values;
    unordered_map<int, list<entry>::iterator>* map;
    
    int size;
    int cap;
public:
    LRUCache(int capacity) {
        values = new list<entry>();
        map = new unordered_map<int, list<entry>::iterator>();
        size = 0;
        cap = capacity;
    }
    
    int get(int key) {
        if (!map->count(key))
            return -1;
        
        list<entry>::iterator it = (*map)[key];
        entry val = *it;
        values->erase(it);
        values->push_front(val);
        (*map)[key] = values->begin();
        
        return val.val;
    }
    
    void set(int key, int value) {
        if (!map->count(key)) {
            if (size >= cap) {
                entry temp = values->back();
                map->erase(temp.key);
                values->pop_back();
            } else {
                size++;
            }
            values->push_front(entry(key,value));
        } else {
            list<entry>::iterator it = (*map)[key];
            entry val = *it;
            values->erase(it);
            val.val = value;
            values->push_front(val);
        }
        
        (*map)[key] = values->begin();
    }
};
