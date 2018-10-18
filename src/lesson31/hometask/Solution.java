package lesson31.hometask;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Valik on 17.10.2018.
 */
public class Solution {
    public static Map<Character, Integer> countSymbols(String text) {
        if(text.isEmpty())
            return null;

        Map<Character, Integer> map = new HashMap<>();
        char[] chars = text.toCharArray();
        int count;

        for (int i = 0; i < chars.length; i++) {
            count = 0;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j])
                    count++;
            }
            if (!map.containsKey(chars[i]))
                map.put(chars[i], count);
        }

        return map;
    }

    public static Map<String, Integer> words(String text) {
        Map<String, Integer> map = new HashMap<>();
        String[] strings = text.split(" ");
        int count;

        for(int i = 0; i < strings.length; i++){
            count = 0;
            for(int j = i + 1; j < strings.length; j++){
                if(strings[i].equals(strings[j]))
                    count++;
            }
            if (!map.containsKey(strings[i]))
                map.put(strings[i], count);
        }
        return map;
    }
}
