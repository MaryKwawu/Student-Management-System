package studentdatabaseapp;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Student {
    String firstName;
    String lastName;
    int studentGradeYear;
    String studentID;
    String[] studentCourses;
    int studentTuitionBalance;
    static final int costOfCourse = 600;
    static int idCounter = 2000;

    // Constructor prompt user to enter student's name and year
    public Student () {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter student first name: ");
        this.firstName = scanner.nextLine().trim();

        System.out.println("Enter student last name: ");
        this.lastName = scanner.nextLine().trim();

        System.out.println("1 - Freshmen\n2 - Sophomore\n3 - Junior\n4 - Senior\nEnter student class level: ");
        this.studentGradeYear = scanner.nextInt();
        scanner.nextLine(); // Consume the newline left-over

        setStudentID();

        // Initialize studentCourses
        studentCourses = new String[0];
    }

    // Generate an ID
    private void setStudentID() {
        idCounter++;
        this.studentID = studentGradeYear + " " + idCounter;
    }

    // Enroll in courses
    public void enroll(){
        Scanner scanner = new Scanner(System.in);
        boolean continueEnrolling = true;

        while (continueEnrolling) {
            System.out.print("Enter course to enroll (Q to quit): ");
            String course = scanner.nextLine().trim();

            if(course.equalsIgnoreCase("Q")) {
                continueEnrolling = false;
            } else {
                String[] tempArray = new String[studentCourses.length + 1];

                // Copy existing courses to tempArray
                System.arraycopy(studentCourses, 0, tempArray, 0, studentCourses.length);

                // Add the new course to the end of tempArray
                tempArray[tempArray.length - 1] = course;

                // Update studentCourses with the new array
                studentCourses = tempArray;
                studentTuitionBalance += costOfCourse;
            }
        }

        // Print enrolled courses on separate lines
        if (studentCourses != null && studentCourses.length > 0) {
            for (int i = 0; i < studentCourses.length; i++) {
                if (studentCourses[i] != null && !studentCourses[i].isEmpty()) {
                    System.out.println(studentCourses[i]);
                }
            }
        }
    }


    //view balance
    public void viewBalance(){
        System.out.println("Your balance is: $" + studentTuitionBalance);
    }


    //pay tuition
    public void payTuition(){
        viewBalance();
        System.out.print("Enter your payment: $");
        Scanner scanner = new Scanner(System.in);
        int payment = scanner.nextInt();
        studentTuitionBalance = studentTuitionBalance - payment;
        System.out.println("Thank you for your payment of $" + payment);
        viewBalance();
    }


    //show status
    public String toString(){
        return "Name: " + firstName + " " + lastName +"\nGrade Level: " + studentGradeYear + "\nStudent ID: " + studentID +  "\nCourses Enrolled: "  + (Arrays.toString(studentCourses)) + "\nBalance: $" + studentTuitionBalance;
    }
}
