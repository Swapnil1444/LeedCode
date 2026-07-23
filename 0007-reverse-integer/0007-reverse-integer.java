class Solution {
    public int reverse(int x) {
        boolean isNagative=x<0;
        if(isNagative){
            x=-x;
        }
        int rev=0;
        while(x!=0){
            int digit =x%10;
            x /=10;

           // Check overflow
            if (rev > Integer.MAX_VALUE / 10 ||
                (rev == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }

            // Check underflow
            if (rev < Integer.MIN_VALUE / 10 ||
                (rev == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            rev=rev*10+digit;
        }
        if(isNagative){
            rev=-rev;
        }
        return rev;
    }
}