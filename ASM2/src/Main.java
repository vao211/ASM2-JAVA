import java.util.*;
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.print("\n" + "0: View \n" + "1: Add Student \n" + "2: Remove Student \n"
                    + "3: Sort by Grade \n" + "4: Search Student\n" + "5: Search Grade \n" + "6: Exit \n");
            System.out.print("\nEnter: ");
            int input = scanner.nextInt();
            if (input == 0) {
                printStudent();
            } else if (input == 1) {
                System.out.println("\nNumber of student: ");
                int num = scanner.nextInt();
                for (int i = 0; i < num; i++) {
                    addStudent();
                }
                System.out.println("\n" + "Add " + num + " students successfully!");
            } else if (input == 2) {
                System.out.println("Number of student: ");
                int num = scanner.nextInt();
                for (int i = 0; i < num; i++) {
                    removeStudent();
                }
            } else if (input == 3) {
                sortByGrade();
            } else if (input == 4) {
                searchStudent();
            } else if (input == 5) {
                searchGrade();
            } else if (input == 6) {
                System.out.println("Exit Program.");
                break;
            }
        }
    }

    public static void addStudent() {
        scanner.nextLine();
        System.out.print("\n" + "Enter Student Code: ");
        String code = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        System.out.print("Enter Gender(0 for Male/1 for Female): ");
        int gender = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Student's Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Student's Grade: ");
        Double grade = scanner.nextDouble();

        Student student = new Student(code, name, age, gender, address, grade);
        studentList.add(student);

    }

    public static void removeStudent() {
        scanner.nextLine();
        Iterator<Student> iterator = studentList.iterator();
        System.out.print("\nEnter the Student Code to remove: ");
        String code = scanner.nextLine();
        boolean removed = false;

        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getCode().equals(code)) {
                iterator.remove();
                removed = true;
                break;
            }
        }

        if (removed) {
            System.out.println("\nStudent with code " + code + " has been removed.");
        } else {
            System.out.println("\nNo student found with code " + code);
        }

    }

    public static void sortByGrade() {
        Comparator<Student> compare = (s1, s2) -> s2.getGrade().compareTo(s1.getGrade());
        Collections.sort(studentList, compare);
        printStudent();
    }

    public static void searchStudent() {
        scanner.nextLine();
        Iterator<Student> iterator = studentList.iterator();
        List<Student> foundStudent = new ArrayList<>();
        System.out.print("\nEnter the Student Code/Name to search: ");
        String search = scanner.nextLine();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getCode().equals(search)) {
                foundStudent.add(student);
            }
        }
        if (foundStudent.isEmpty()) {
            System.out.println("\nNo student found!");
        }
        else {
            for (Student s : foundStudent) {
                System.out.println(s.StudentToString());
            }
        }
    }
    public static void searchGrade() {
        scanner.nextLine();
        Iterator<Student> iterator = studentList.iterator();
        List<Student> foundStudent = new ArrayList<>();
        System.out.print("\nEnter the Grade to search: ");
        Double search = scanner.nextDouble();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getGrade().equals(search)) {
                foundStudent.add(student);
            }
                        } 
            else if (student.getGrade() > search) {
                foundStudent.add(student);
            }
        }
        if (foundStudent.isEmpty()) {
            System.out.println("\nNo student found!");
        }
        else {
            for (Student s : foundStudent) {
                System.out.println(s.StudentToString());
            }
        }
    }


    public static void printStudent() {
        for (Student s : studentList) {
            System.out.println(s.StudentToString());
        }
    }
}



