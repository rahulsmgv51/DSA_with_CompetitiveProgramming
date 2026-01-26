package HashMaps;

import java.util.HashMap;

public class FreqCountOfElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 4, 5};
        HashMap<Integer, Integer> frequencyMap = getFrequency(arr);
        System.out.println("Frequency of elements is: " + frequencyMap);
    }

    private static HashMap<Integer, Integer> getFrequency(int[] arr) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        return freqMap;
    }
}
