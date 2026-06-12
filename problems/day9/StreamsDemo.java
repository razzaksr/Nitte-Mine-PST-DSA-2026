import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Employee {
    String name; int salary;
    Employee(String n, int s){ name=n; salary=s; }
    public String getName(){ return name; }
    public int getSalary(){ return salary; }
    @Override
    public String toString(){ return name + ": " + salary; }
}

public class StreamsDemo {
    // leet code 977. Squares of a Sorted Array
    public int[] sortedSquares(int[] nums) {
        return Arrays.stream(nums)
                     .map(n -> n*n)
                     .sorted()
                     .toArray();
    }
    // leet code 2942. Find Words Containing Given Character
    public List<Integer> findWordsContaining(String[] words, char x) {
        return IntStream.range(0, words.length)
                        .filter(i -> words[i].indexOf(x) != -1)
                        .boxed()
                        .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        StreamsDemo demo = new StreamsDemo();
        int[] nums = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(demo.sortedSquares(nums))); 
        // Output: [0, 1, 9, 16, 100]

        String[] words = {"hello", "world", "java", "stream"};
        char x = 'a';
        System.out.println(demo.findWordsContaining(words, x)); // Output: [2, 3]
        List<Employee> employees = Arrays.asList(
            new Employee("Alice",5000),
            new Employee("Bob",7000),
            new Employee("Charlie",6000)
        );

        // Filter high earners
        List<Employee> highEarners = employees.stream()
                                            .filter(e -> e.getSalary() > 6000)
                                            .collect(Collectors.toList());

        // Extract names only
        List<String> namesList = employees.stream()
                                        .map(Employee::getName)
                                        .collect(Collectors.toList());
        System.out.println(highEarners);
        System.out.println(namesList);
        Map<Integer, Long> salaryCount = employees.stream()
            .collect(Collectors.groupingBy(Employee::getSalary, Collectors.counting()));
        System.out.println(salaryCount); // {5000=1, 6000=1, 7000=1}
    }
}
