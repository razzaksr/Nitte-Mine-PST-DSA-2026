import java.util.*;
import java.util.stream.*;
public class MethodRefDemo {
    // leet code 451. Sort Characters By Frequency
    public String frequencySort(String s) {
        Map<Character, Long> freq = s.chars()
                                     .mapToObj(c -> (char)c)
                                     .collect(Collectors.groupingBy(
                                         c -> c, Collectors.counting()));
        return freq.entrySet().stream()
                   .sorted(Map.Entry.<Character,Long>comparingByValue().reversed())
                   .map(e -> String.valueOf(e.getKey()).repeat(e.getValue().intValue()))
                   .collect(Collectors.joining());
    }
    // leet code 49. Group Anagrams
    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(
            Arrays.stream(strs)
                  .collect(Collectors.groupingBy(s -> {
                      char[] arr = s.toCharArray();
                      Arrays.sort(arr);
                      return new String(arr);
                  }))
                  .values()
        );
    }
    public static void main(String[] args) {
        MethodRefDemo demo = new MethodRefDemo();
        String s = "tree";
        System.out.println(demo.frequencySort(s)); // Output: "eert" or "eetr"

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(demo.groupAnagrams(strs)); 
        // Output: [["bat"], ["nat","tan"], ["ate","eat","tea"]]


        List<String> names = Arrays.asList("Alice","Bob","Charlie");

        // Using lambda
        names.forEach(n -> System.out.println(n));

        // Using method reference
        names.forEach(System.out::println);

        List<String> words = Arrays.asList("apple","banana","cherry");

        // Sort using lambda
        words.sort((a,b) -> a.compareToIgnoreCase(b));

        // Sort using method reference
        words.sort(String::compareToIgnoreCase,-1);

        System.out.println(words); // [apple, banana, cherry]

        List<Employee> employees = Arrays.asList(
            new Employee("Alice",5000),
            new Employee("Bob",7000),
            new Employee("Charlie",6000)
        );
        employees.sort(Comparator.comparing(Employee::getSalary));
        employees.forEach(System.out::println);
        employees.stream().map(Employee::getName).forEach(System.out::println);
    }
}
