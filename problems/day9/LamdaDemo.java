import java.util.List;

class Student{
    String name;
    int age;
    List<Integer> marks;

    public Student(String name, int age, List<Integer> marks) {
        this.name = name;
        this.age = age;
        this.marks = marks;
    }
}
public class LamdaDemo {
    static List<Student> students;
    static {
        students = List.of(
            new Student("Alice", 20, List.of(85, 90, 78)),
            new Student("Bob", 22, List.of(75, 80, 82)),
            new Student("Charlie", 19, List.of(92, 88, 95))
        );
    }
    public static void main(String[] args) {
        // Lamda Expression: () -> {code}
        
        // without lamda expression
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.name.compareTo(s2.name);
            }
        });
        System.out.println(students);
        // with lamda expression
        Collections.sort(students, (s1, s2) -> s2.name.compareTo(s1.name));
        System.out.println(students);
    }
}
