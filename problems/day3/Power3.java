package problems.day3;

public class Power3 {
    public boolean isPowerOfThree(int n) {
        // Base cases
        if (n == 1) return true;       // 3^0 = 1
        if (n <= 0 || n % 3 != 0) return false;

        // Recursive step
        return isPowerOfThree(n / 3);
    }

    public static void main(String[] args) {
        Power3 solver = new Power3();
        System.out.println(solver.isPowerOfThree(27)); // true
        System.out.println(solver.isPowerOfThree(28)); // false
        System.out.println(solver.isPowerOfThree(1));  // true
    }
}
