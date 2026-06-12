interface FunInterface {
    int[] alpha = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    public void fizzBuzz();
}
public class FunInterfaceDemo {
    public static void main(String[] args) {
        // Functional Interface: interface with max 1 abstract method
        FunInterface funInterface = () -> {
            for (int i : FunInterface.alpha) {
                if (i % 3 == 0 && i % 5 == 0) System.out.println("FizzBuzz");
                else if (i % 3 == 0) System.out.println("Fizz");
                else if (i % 5 == 0) System.out.println("Buzz");
                elseSystem.out.println(i);
            }
        };
        funInterface.fizzBuzz();
    }
}
