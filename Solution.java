class Solution {
    public boolean closeStrings(String word1, String word2) {
        int N1 = word1.length();        
        int N2 = word2.length();
        if(N1 != N2) return false;
        int[] cnt1 = new int[128];
        int[] cnt2 = new int[128];
        for(int i = 0; i < cnt1.length; i++){
            cnt1[word1.charAt(i) - 'a']++; 
            cnt2[word2.charAt(i) - 'a']++; 
        }

        int[] pe1 = new int[N1];
        int[] pe2 = new int[N2];
        
        int idx = 0;
        for(int i = 0; i < N1; i++){
            if(cnt1[i] != 0 || cnt2[i] != 0){
                if(cnt1[i] == 0 || cnt2[i] == 0) return false;
                pe1[idx++] = cnt1[i];
                pe2[idx++] = cnt2[i];
            }
        }

        Arrays.sort(pe1);
        Arrays.sort(pe2);

        for(int i = 0; i < N1; i++)
            if(pe1[i] != pe2[i]) return false;

        return ture;
    }
}