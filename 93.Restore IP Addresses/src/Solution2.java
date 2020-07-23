import java.util.*;
public class Solution2 {
    private List<String> res = new ArrayList<String>();

    public List<String> restoreIpAddresses(String s) {

        LinkedList<Integer> ip = new LinkedList<Integer>();
        findValidIp(s, 0, ip);

        return res;
    }

    private void findValidIp(String s, int index, LinkedList<Integer> ip) {
        if(index == s.length()){
            if(ip.size()==4)
                res.add(validIp(ip));
            return;
        }

        if(index == 0){ 
            ip.addLast(s.charAt(0) - '0');
            findValidIp(s, index + 1, ip);
        }else{
            int last = ip.getLast();
            int element = last * 10 + (s.charAt(index) - '0');
            if(element >= 255 && last != 0){
                ip.removeLast();
                ip.addLast(element);
                findValidIp(s, index + 1, ip);
                int lastVal = ip.removeLast();
                ip.addLast(lastVal / 10);
            }

            if(ip.size() < 4){
                ip.addLast(s.charAt(index) - '0');
                findValidIp(s, index + 1, ip);
                ip.removeLast();
            }
        }
    }

    private String validIp(List<Integer> ip) {
        String str = "" + ip.get(0);
        for(int i = 1; i < ip.size(); i++)
            str += "." + ip.get(i);
        return str;
    }
    
}