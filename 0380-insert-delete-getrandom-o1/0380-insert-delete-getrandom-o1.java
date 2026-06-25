class RandomizedSet {
    private List<Integer> list;  //stores all elements -> allows random access
        private Map<Integer , Integer> map;  // maps each value -> its index in the array
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
        list.add(val);
        map.put(val , list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {   // find index of element in hashmap , swap , update hashmap for the swapped element , pop the last element , avoids costly shifting
        if(!map.containsKey(val)) return false;
        int idx = map.get(val);
        int last = list.get(list.size()-1);

        //swapping with last element
        list.set(idx , last);
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