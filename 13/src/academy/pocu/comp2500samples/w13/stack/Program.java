package academy.pocu.comp2500samples.w13.stack;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack();

        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);

        while (!stack.isEmpty()) {
            int num = stack.remove(0);
            System.out.println(num);
        }

        System.out.println("-----------------");

        ArrayList<Integer> list = new ArrayList<>();

        addInOrder(list, 10);
        addInOrder(list, 2);
        addInOrder(list, 5);

        for (int num : list) {
            System.out.println(num);
        }

        System.out.println("-----------------");

        addInOrder(stack, 10);
        addInOrder(stack, 2);
        addInOrder(stack, 5);

        for (int num : stack) {
            System.out.println(num);
        }
    }

    private static void addInOrder(ArrayList<Integer> list, int num) {
        int i;

        for (i = 0; i < list.size(); ++i) {
            if (list.get(i) > num) {
                break;
            }
        }

        list.add(i, num);
    }
}
