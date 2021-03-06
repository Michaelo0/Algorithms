public class isBalanced {
    public static void main(String[] args) {

        String str = "(())";

        System.out.println(isBalanced(str));
    }

    static public boolean isBalanced(String str){
        int     i;
        int     top;
        int[]   stack;

        i = 0;
        top = 0;
        stack = new int[1024];
        if (!isSymmetric(str))
            return false;
        while(i < str.length()){
            if (str.charAt(i) == '(')
                stack[++top] = str.charAt(i);
            if (str.charAt(i) == ')')
                if (!match((char)stack[top--], str.charAt(i)))
                    return false;
            i++;
        }
        if (top == 0)
            return true;
        return false;
    }

    static public boolean isSymmetric(String str){
        int     i;

        i = 0;

        if (str.length() % 2 != 0)
            return false;
        while (i < str.length() / 2 ){
            if (str.charAt(i) == reverse(str.charAt(str.length() - 1 - i)))
                i++;
            else
                return false;
        }
        return true;
    }

    static public char reverse(char ch){
        char  c;

        if (ch == '(')
                c = ')';
        else
                c = '(';

        return c;
    }

    static boolean match(char c1, char c2){
        return (c1 == '(' && c2 == ')');
    }
}
