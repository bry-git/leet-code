import java.util.HashMap;

/**
 * roman numerals are written largest to smallest from left to right,
 * EXCEPT "IV" (4), "IVX" (9), "XL" (40), "XLC" (90), "CD" (400), and "CDM" (900)
*/

/**
 * Details
 * Runtime: 10 ms, faster than 51.51% of Java online submissions for Roman to Integer.
 * Memory Usage: 46.6 MB, less than 37.45% of Java online submissions for Roman to Integer.
 * */


public class Solution {
    public static int romanToInt(String s) {  // example s = "MCMXCIV"
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = map.get(s.charAt(s.length()-1)); // length is 7, so get last numeral ('V') at index 6/6 // result = 1

        //walk through the roman numeral backwards to cover the case that "IV" = 4 etc

        for(int i = s.length() - 2; i >= 0; i--) {  // moves through "MCMXCIV" from right to left like 'I' -> 'C' -> 'X' etc

            if(map.get(s.charAt(i)) < map.get(s.charAt(i +1))) { //if ({'I' : 1} is less than {'V' : 5}) then we have a 4 or 9 situation
                result-=map.get(s.charAt(i)); // on first loop, 'I':1 is less than 'V':5 so we go here and result goes from 5 -> (5 - 'I':1)
            } else {
                result+=map.get(s.charAt(i)); //on second loop, 'C':100 is greater than 'I':1 so result goes from 4 -> (4 + 'C':100)
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("MCMXCIV = " + romanToInt("MCMXCIV")); // should be 1994
        System.out.println("LVIII = " + romanToInt("LVIII")); // should be
    }
}
