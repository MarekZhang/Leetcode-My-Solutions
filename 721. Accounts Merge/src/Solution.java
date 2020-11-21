class Solution {
    private class UF{
        int sz[];
        int id[];
        public UF(){
            sz = new int[10000];
            id = new int[10000];
            for(int i = 0; i< 10000; i++){
                sz[i] = 1;
                id[i] = i;
            }
        }
        
        public boolean isConnected(int id1, int id2){ return find(id1) == find(id2); }
        public int find(int val){
            while(id[val] != val) val = id[val];
            return val;
        }
        public void connect(int id1, int id2){
            int p = find(id1);
            int q = find(id2);
            if(p == q) return;
            if(sz[p] > sz[q]){
                id[q] = p;
                sz[p] += sz[q];
            }else{
                id[p] = q;
                sz[q] += sz[p];
            }
        }
    }
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UF uf = new UF();
        Map<String, String> emailToName = new HashMap<>();
        Map<String, Integer> emailToId = new HashMap<>();
        int id = 0;
        for(List<String> account : accounts){
            String name = account.get(0);
            for(int i = 1; i < account.size(); i++){
                String email = account.get(i);
                emailToName.put(email, name);
                if(!emailToId.containsKey(email))
                    emailToId.put(email, id++);
                uf.connect(emailToId.get(account.get(1)), emailToId.get(email));
            }
        }
        
        Map<Integer, List<String>> idToEmails = new HashMap<>();
        for(String mail : emailToName.keySet()){
            int group = uf.find(emailToId.get(mail));
            idToEmails.computeIfAbsent(group, (list) -> new ArrayList<>()).add(mail);
        }
        
        for(List<String> list : idToEmails.values()){
            Collections.sort(list);
            String user = emailToName.get(list.get(0));
            list.add(0, user);
        }
        
        List<List<String>> res = new ArrayList(idToEmails.values());
        
        return res;
    }
}