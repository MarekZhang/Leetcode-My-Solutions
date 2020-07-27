/**
 * 401. Binary Watch
Easy

574

982

Add to List

Share
A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.


For example, the above binary watch reads "3:25".

Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

Example:

Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
Note:
The order of output does not matter.
The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".
 */

class Solution {
    private int[] hoursAndMin = {1, 2, 4, 8, 1, 2, 4, 8, 16, 32};
    private List<String> res = new ArrayList<>();

    public List<String> readBinaryWatch(int num) {
        if(num == 0){
            res.add("0:00");
            return res;
        }

        timesCombination(0, 0, 0, num);

        return res;
        
    }

    private void timesCombination(int index, int hour, int minute, int num){
        if(num == 0){
            if(hour < 12 && minute < 60)
                res.add(concat(hour, minute));
        }
        for(int i = index; i < hoursAndMin.length; i++){
            if(i < 4)
                hour += hoursAndMin[i];
            else
                minute += hoursAndMin[i];
            timesCombination(i + 1, hour, minute, num - 1);
            if(i < 4)
                hour -= hoursAndMin[i];
            else
                minute -= hoursAndMin[i];
        }
    }

    private String concat (int hour, int minute){
        String hr = "";
        String min = "";
        hr += hour;
        if(minute < 10)
            min = min + "0" + minute;
        else
            min += minute;
        return hr + ":" + min;
    }
}
