import java.util.Scanner;

public class Marks {
    static Scanner sc = new Scanner(System.in);
    static int[][] marks;
    static int n;

    public static void main(String[] args) {
        System.out.print("Enter number of students: ");
        n = sc.nextInt();
        marks = new int[n + 1][3];

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("add [studentID]");
            System.out.println("update [studentID] [subjectID]");
            System.out.println("average [studentID]");
            System.out.println("average_s [subjectID]");
            System.out.println("total [studentID]");
            System.out.println("grades");
            System.out.println("exit");
            System.out.print("Enter command: ");

            String command = sc.next();

            if (command.equals("add")) {
                int id = sc.nextInt();
                add(id);
            } else if (command.equals("update")) {
                int id = sc.nextInt();
                int subjectID = sc.nextInt();
                update(id, subjectID);
            } else if (command.equals("average")) {
                int id = sc.nextInt();
                average(id);
            } else if (command.equals("average_s")) {
                int subjectID = sc.nextInt();
                averageSubject(subjectID);
            } else if (command.equals("total")) {
                int id = sc.nextInt();
                total(id);
            } else if (command.equals("grades")) {
                grades();
            } else if (command.equals("exit")) {
                System.out.println("Exiting program.");
                break;
            } else {
                System.out.println("Invalid command.");
            }
        }
    }

    static void add(int id) {
        if (id < 1 || id > n) {
            System.out.println("Invalid student ID.");
            return;
        }
        System.out.print("Enter Mathematics marks: ");
        marks[id][0] = sc.nextInt();
        System.out.print("Enter Chemistry marks: ");
        marks[id][1] = sc.nextInt();
        System.out.print("Enter Physics marks: ");
        marks[id][2] = sc.nextInt();
        System.out.println("Marks added for student " + id);
    }

    static void update(int id, int subjectID) {
        if (id < 1 || id > n || subjectID < 1 || subjectID > 3) {
            System.out.println("Invalid IDs.");
            return;
        }
        System.out.print("Enter new mark: ");
        marks[id][subjectID - 1] = sc.nextInt();
        System.out.println("Mark updated.");
    }

    static void average(int id) {
        if (id < 1 || id > n) {
            System.out.println("Invalid student ID.");
            return;
        }
        double avg = (marks[id][0] + marks[id][1] + marks[id][2]) / 3.0;
        System.out.printf("Average marks for student %d: %.2f\n", id, avg);
    }

    static void averageSubject(int subjectID) {
        if (subjectID < 1 || subjectID > 3) {
            System.out.println("Invalid subject ID.");
            return;
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += marks[i][subjectID - 1];
        }
        System.out.printf("Average for subject %d: %.2f\n", subjectID, sum / (double) n);
    }

    static void total(int id) {
        if (id < 1 || id > n) {
            System.out.println("Invalid student ID.");
            return;
        }
        int total = marks[id][0] + marks[id][1] + marks[id][2];
        System.out.println("Total marks for student " + id + ": " + total);
    }

    static void grades() {
        System.out.println("StudentID\tMath\tGrade\tChem\tGrade\tPhys\tGrade");
        for (int i = 1; i <= n; i++) {
            System.out.print(i + "\t\t");
            for (int j = 0; j < 3; j++) {
                int score = marks[i][j];
                System.out.print(score + "\t" + grade(score) + "\t");
            }
            System.out.println();
        }
    }

    static String grade(int score) {
        if (score >= 90) return "Grade A";
        else if (score >= 80) return "Grade B";
        else if (score >= 70) return "Grade C";
        else if (score >= 60) return "Grade D";
        else return "Fail";
    }
}
