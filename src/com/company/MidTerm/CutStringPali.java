package com.company.MidTerm;


public class CutStringPali {
    public int cutString(String input) {
        if(input==null||input.length()<=1){
            return 0;
        }
        int[] M=new int[input.length()];
        char[] n=input.toCharArray();
        M[0]=0;
        for (int i = 1; i < input.length(); i++) {
            if(isPali(n,0,i)){
                M[i]=0;
            }
            else{
                M[i]=i;
                for(int j=0;j<i;j++){
                    if(isPali(n,j+1,i)){
                        M[i]=Math.min(M[i],M[j]+1);
                    }
                }

            }
        }
        return M[n.length-1];
    }

    private boolean isPali(char[] n, int left, int right) {
        while(left<right){
            if(n[left]!=n[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

