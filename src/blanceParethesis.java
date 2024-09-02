import java.util.Stack;
public class blanceParethesis {
    static int minInsertions(String s) {
        Stack<Character> stack=new Stack<Character>();
        char[] c=s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(i==s.length()-1){
                stack.push(c[i]);
            }
            else if(c[i]==')' && s.charAt(i+1)==')'){
                if(!stack.isEmpty() && stack.peek()=='('){
                    stack.pop();
                    i=i+1;
                }
                else{
                    stack.push(c[i]);
                }
            }
            else stack.push(c[i]);
        }
        return stack.size();
    }
    public static void main(String[] args) {
        String s="(()))";
        int count=minInsertions(s);
        System.out.println(count);
    }
}
