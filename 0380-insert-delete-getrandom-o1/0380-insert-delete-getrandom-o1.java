class RandomizedSet {
    private List<Integer> list;  //stores all elements -> allows random access , used for getRandom()
        private Map<Integer , Integer> map;  // maps each value -> its index in the array , to check if ana element exists and where it is
        private Random rand;

    public RandomizedSet() {//initialize 
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) { //append to array , record index in hashmap
        if(map.containsKey(val)){
            return false;
        }
        list.add(val); //add to end of list
        map.put(val , list.size()-1); //record index in map
        return true;
    }
    
    public boolean remove(int val) {   // find index of element in hashmap , swap , update hashmap for the swapped element , pop the last element , avoids costly shifting
        if(!map.containsKey(val)) return false;
        int idx = map.get(val);   //index of value
        int last = list.get(list.size()-1);  // last element

        //swapping with last element
        list.set(idx , last);  //(position , value) replaces the element at position with value

        
        map.put(last,idx);

        //removing last
        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }

    
    public int getRandom() {   
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */