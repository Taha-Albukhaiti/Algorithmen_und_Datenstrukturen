package datastructures;

public class Stack {
    static int top;
    private static final int MAX_SIZE = 100;
    static int[] item = new int[MAX_SIZE];

    public Stack() {
        top = -1;
    }

    public static void push(int element) {
        if (top >= MAX_SIZE - 1) {
            System.out.println("Stack full on push");
            return;
        } else {
            top++;
            item[top] = element;
        }
    }

    static boolean isEmpty() {
        return top < 0;
    }

    public static void pop() {
        if (!isEmpty())
            top--;
        else System.out.println("Stack empty on pop");
    }

    public static void pop(int element) {
        if (!isEmpty())
            top--;
        else System.out.println("Stack empty on pop");
    }

    public static int getTop() {
        int index = 0;
        if (!isEmpty()) {
            index = item[top];
            return index;
        } else {
            return 0;
        }
    }

    public static void print() {
        System.out.print("[");
        for (int i = top; i >= 0; i--) {
            System.out.print(item[i] + " ");
        }
        System.out.print("]");
    }


    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(3);
        s.push(4);
        s.push(499);
        s.pop();

        int i = s.getTop();
        System.out.println(i);
        print();
    }
}
