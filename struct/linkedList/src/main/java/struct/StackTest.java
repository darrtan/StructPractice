package struct;
import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.add("11111111111");
        stack.add("22222222222");
        stack.add("33333333333");

        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }
}
