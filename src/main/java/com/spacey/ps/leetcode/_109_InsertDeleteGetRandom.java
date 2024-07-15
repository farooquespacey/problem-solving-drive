package com.spacey.ps.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class _109_InsertDeleteGetRandom {
    static class RandomizedSet {
        private ArrayList<Integer> list;
        private Map<Integer, Integer> map;

        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>();
        }

        public boolean search(int val) {
            return map.containsKey(val);
        }

        public boolean insert(int val) {
            if (search(val)) return false;

            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            if (!search(val)) return false;

            int index = map.get(val);
            // replace val with lastItem in the list
            list.set(index, list.get(list.size() - 1));
            // update that in the map to reflect latest index for lastItem
            map.put(list.get(index), index);
            // remove the lastItem from the list since that's placed in the replacee index in the first step
            list.remove(list.size() - 1);
            // remove val from the map
            map.remove(val);

            return true;
        }

        public int getRandom() {
            Random rand = new Random();
            return list.get(rand.nextInt(list.size()));
        }
    }

    public static void main(String[] args) {
//        Your RandomizedSet object will be instantiated and called as such:
        RandomizedSet obj = new RandomizedSet();
        boolean param_1 = obj.insert(1);
        boolean param_1_1 = obj.insert(2);
        boolean param_2 = obj.remove(2);
        int param_3 = obj.getRandom();
        System.out.println(param_3);
    }
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
