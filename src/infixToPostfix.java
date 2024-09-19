import java.util.Stack;

public class infixToPostfix {
    public static String infixToPostfix(String exp) {
        // Your code here
        int n = exp.length();
        String res="";
        Stack<Character> s=new Stack<>();

        for(int i=0;i<n;i++){
            char ch=exp.charAt(i);
            if((ch>='A' && ch<='Z') ||
                    (ch>='a' && ch<='z') ||
                    (ch>='0' && ch<='9')) res+=ch;

            else if(ch=='(') s.push(ch);
            else if(ch==')'){
                while(!s.isEmpty() && s.peek()!='('){
                    res+=s.pop();
                }
                s.pop();
            }

            else{
                while(!s.isEmpty() && priority(ch)<=priority(s.peek())){
                    res+=s.pop();
                }
                s.push(ch);
            }
        }

        while (!s.isEmpty()) {
            if (s.peek() == '(')
                return "Invalid Expression";
            res += s.pop();
        }

        return res;
    }
    private static int priority(char ch){
        if(ch=='^') return 3;
        else if(ch=='*' || ch=='/') return 2;
        else if(ch=='+' || ch=='-') return 1;
        return -1;
    }

    public static void main(String[] args) {
        String s="a+b*(c^d-e)^(f+g*h)-i";
        String ans=infixToPostfix(s);
        System.out.println(ans);
    }
}
