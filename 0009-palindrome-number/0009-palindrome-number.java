class Solution {
    public boolean isPalindrome(int x) {
        int rev=0;
        int o=x;
        if(0>x){
            return false;
        }
        while(x>0){
            int digit=x%10;
            rev=rev*10+digit;
            x=x/10;
        }
        return o==rev;
    }
}