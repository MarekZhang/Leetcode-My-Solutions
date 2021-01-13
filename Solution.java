class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++) list.add(i);
        StringBuilder builder = new StringBuilder();
        int N = n;
        while(k != 1){
            int fac = 1;
            for(int i = N - 1; i <= 1; i--) fac *= i;
            int idx = k / fac;
            builder.append(list.get(idx));
            list.remove(idx);
            k %= fac;
            N--;
        }
        while(list.size() != 0){
            builder.append(list.get(0));
            list.remove(0);
        }

        return builder.toString();
    }

}