package org.example.SlidingWindowand2Pointers;

public class ConsecutiveChars {
    public static void main(String[] args) {
        String s = "aaabbbbccdefeeeeeeee";
        System.out.println(maxPower(s));
    }
    public static int maxPower(String s) {
        int power=0;
        int r = 1;
        int l = 0;
        while(r < s.length()){
            if(s.toLowerCase().charAt(l) != s.toLowerCase().charAt(r)){
                l=r;
            }
            power = Math.max(power,(r-l+1));
            r++;
        }
        return (s.length()<2) ? s.length() : power;
    }
}
