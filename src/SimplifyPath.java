import java.util.Stack;

public class SimplifyPath {

    static String simplifyPath(String string) {
        String result = "";
        String[] s = string.split("/");
        Stack<String> stack = new Stack<>();

        for (String str : s)
            if (str.equals("."))
                continue;
            else if (str.equals("..") && !stack.isEmpty())
                stack.pop();
            else
                stack.push(str);

        for (String str : stack)
            result += "/" + str;

        return result;
    }
}
