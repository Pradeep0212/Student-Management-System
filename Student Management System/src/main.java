import java.util.Scanner;
import java.util.ArrayList;

class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                addStudent(sc, students);
            } else if (choice == 2) {
                viewStudents(students);
            } else if (choice == 3) {
                searchStudent(sc, students);
            } else if (choice == 4) {
                updateStudent(sc, students);
            } else if (choice == 5) {
                deleteStudent(sc, students);
            } else if (choice == 6) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }

    // ---------------- ADD STUDENT ----------------
    static void addStudent(Scanner sc, ArrayList<Student> students) {

        Student s = new Student();

        System.out.print("Enter ID: ");
        s.id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        s.name = sc.nextLine();

        System.out.print("Enter Age: ");
        s.age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Course: ");
        s.course = sc.nextLine();

        students.add(s);
        System.out.println("Student added successfully!");
    }

    // ---------------- VIEW STUDENTS ----------------
    static void viewStudents(ArrayList<Student> students) {

        if (students.size() == 0) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n--- Student List ---");
        for (Student st : students) {
            System.out.println(
                "ID: " + st.id +
                ", Name: " + st.name +
                ", Age: " + st.age +
                ", Course: " + st.course
            );
        }
    }

    // ---------------- SEARCH STUDENT ----------------
    static void searchStudent(Scanner sc, ArrayList<Student> students) {

        System.out.print("Enter Student ID to search: ");
        int searchId = sc.nextInt();

        for (Student st : students) {
            if (st.id == searchId) {
                System.out.println(
                    "ID: " + st.id +
                    ", Name: " + st.name +
                    ", Age: " + st.age +
                    ", Course: " + st.course
                );
                return;
            }
        }

        System.out.println("Student not found!");
    }

    // ---------------- UPDATE STUDENT ----------------
    static void updateStudent(Scanner sc, ArrayList<Student> students) {

        System.out.print("Enter Student ID to update: ");
        int updateId = sc.nextInt();

        for (Student st : students) {
            if (st.id == updateId) {

                sc.nextLine();

                System.out.print("Enter new Name: ");
                st.name = sc.nextLine();

                System.out.print("Enter new Age: ");
                st.age = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter new Course: ");
                st.course = sc.nextLine();

                System.out.println("Student updated successfully!");
                return;
            }
        }

        System.out.println("Student not found!");
    }

    // ---------------- DELETE STUDENT ----------------
    static void deleteStudent(Scanner sc, ArrayList<Student> students) {

        System.out.print("Enter Student ID to delete: ");
        int deleteId = sc.nextInt();

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).id == deleteId) {
                students.remove(i);
                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student not found!");
    }
}
