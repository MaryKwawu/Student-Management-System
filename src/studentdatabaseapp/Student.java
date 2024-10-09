package studentdatabaseapp;

import java.util.Scanner;

public class Student {
    String firstName;
    String lastName;
    int studentGradeYear;
    String studentId;
    String[] studentCourses;
    int studentTuitionBalance;
    static int costOfCourse = 600;
    static int id = 2000;
   // String studentStatus;


    //constructor prompt user to enter student's name and year
    public Student () {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter student first name: ");
        this.firstName = scanner.nextLine();

        System.out.println("Enter student second name: ");
        this.lastName = scanner.nextLine();

        System.out.println("1 - Freshmen\n2 - for  Sophomore\n3 - Junior\n4 - Senior\nEnter student class level: ");
        this.studentGradeYear = scanner.nextInt();


        setStudentID();
        System.out.println(firstName + " " + lastName + " " + studentGradeYear + " " +studentId);
    }

    //Generate an id
    private void setStudentID() {
        //studentGradeYear + ID
        id++;
        this.studentId = studentGradeYear + " " + id;
    }

    //Enroll in courses
    //view the balance
    //pay tuition
    //show status
}
