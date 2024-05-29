package Stacks;

public class TestStack {
    public static void main(String[] args){
        StackList<Integer> newStack = new StackList<Integer>();
        newStack.push(5);
        newStack.push(4);
        int x = newStack.peek();
    }
}
