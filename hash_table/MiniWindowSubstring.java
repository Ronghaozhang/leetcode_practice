class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c: s.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c, 0);
            }
        }
        
        for(Character c: t.toCharArray()){
            if(!map.containsKey(c)){return "";}
            map.put(c, map.get(c) + 1);
        }
        int start = 0, end = 0, minStart = 0, length = Integer.MAX_VALUE, counter = t.length();
        while(end < s.length()){
            char c = s.charAt(end);
            if(map.get(c) > 0){counter--;}
            map.put(c, map.get(c)-1);
            
            while(counter == 0){
                if(end - start < length){length = end-start; minStart = start;}
                char tmp = s.charAt(start);
                map.put(tmp, map.get(tmp)+1);
                if(map.get(tmp) > 0){counter++;}
                start++;
            }
            end++;
        }if(length != Integer.MAX_VALUE){return s.substring(minStart, minStart+length+1);}
        return "";
    }
}