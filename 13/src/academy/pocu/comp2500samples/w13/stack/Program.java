package academy.pocu.comp2500samples.w13.stack;

public class Program {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        while (!stack.isEmpty()) {
            int num = stack.pop();
            System.out.println(num);
        }

        System.out.println("-----------------");

        stack.push(1);
        stack.push(3);
        stack.push(6);

        stack.add(1, 2);
        stack.add(3, 4);

        stack.remove(0);
        stack.remove(3);

        for (int num : stack) {
            System.out.println(num);
        }
    }
}
