/**
 * 71. Simplify Path
Medium

787

1761

Add to List

Share
Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.

In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level.

Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.

 

Example 1:

Input: "/home/"
Output: "/home"
Explanation: Note that there is no trailing slash after the last directory name.
Example 2:

Input: "/../"
Output: "/"
Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
Example 3:

Input: "/home//foo/"
Output: "/home/foo"
Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
Example 4:

Input: "/a/./b/../../c/"
Output: "/c"
Example 5:

Input: "/a/../../b/../c//.//"
Output: "/c"
Example 6:

Input: "/a//b////c/d//././/.."
Output: "/a/b/c"
 */
import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        String[] strArr = path.split("/");
        Stack<String> dir = new Stack<>();

        for(int i = 0; i < strArr.length; i++) {
            if(!strArr[i].equals(".") && !strArr[i].equals("..") &&!strArr[i].equals(""))
                dir.push(strArr[i]);
            else if(strArr[i].equals("..")){
                if(!dir.isEmpty())
                    dir.pop();
            }
        }

        if(dir.isEmpty())
            return "/";

        StringBuilder builder = new StringBuilder();

        while(!dir.isEmpty()){
            builder.insert(0,dir.pop());
            builder.insert(0,"/");
        }

        path = builder.toString();

        return path;

    }

    public static void main(String[] args){
        String s = "/a//b////c/d//././/..";
        // String[] arr = s.split("/");
        // for(String str : arr){
        //     System.out.print("=" + str + "-");
        // }

        System.out.println(new Solution().simplifyPath(s));

    }
}