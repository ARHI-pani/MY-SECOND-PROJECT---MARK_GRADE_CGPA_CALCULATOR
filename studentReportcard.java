package myprojects;
import java.util.*;
public class studentReportcard {
    static final int pass_mark = 35;
    static final int total_mark = 100;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("=====STUDENT DETAILS=====");

        System.out.println("Enter the name of the student:- ");
        String NAME = sc.next();

        System.out.println("Enter the branch of the student:- ");
        String BRANCH = sc.next(); 

        System.out.println("Enter the roll.no of the student:- ");
        long roll = sc.nextInt();
        
        System.out.println("Enter the semester:- ");
        int sem = sc.nextInt();

        
        String[] subjects = getsubjectbysemester(sem);

        if(subjects == null){
         System.out.println("invelid semester. subjects are added only for 1st and 2nd semester");
         sc.close();
         return;
        }
        double total_scored = 0;
        boolean isPass = true;
        
        System.out.println();
        System.out.println("Enter marks out of " + total_mark + " for each subject:");

       for (int i = 0; i < subjects.length; i++) {
    String subject = subjects[i];

    System.out.print(subject + ": ");
    double marks = sc.nextDouble();

    total_scored += marks;

    if (marks < 35) {
        isPass = false;
    }
}   
    double FULL_MARK = subjects.length * total_mark;
    double percentage = (total_scored / FULL_MARK) * 100;
    double cgpa = (percentage + 5) / 10;
    String grade;
      if (isPass) {
    grade = calculateGrade(percentage);
} else {
    grade = "F";
}


        System.out.println();
        System.out.println("=====FINAL REPORT CARD=====");
        System.out.println("Name: " + NAME);
        System.out.println("Branch: " + BRANCH);
        System.out.println("Roll No: " + roll);
        System.out.println("Semester: " + sem);
        System.out.println("Total Scored: " + total_scored + " / " + FULL_MARK );
        System.out.println("Total percentage: " + percentage); 
        System.out.println("cgpa: " + cgpa);
        System.out.println("Grade: " + grade);
        if (isPass) {
    System.out.println("Result     : PASS");
} else {
    System.out.println("Result     : FAIL");
    System.out.println("Reason     : One or more subjects have marks below " + pass_mark + ".");
}

        sc.close();
    }

    static String calculateGrade(double percentage) {
        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B+";
        } else if (percentage >= 60) {
            return "B";
        } else if (percentage >= 50) {
            return "C";
        } else if (percentage >= 40) {
            return "D";
        } else {
            return "F";
        }
    }

    static String[] getsubjectbysemester(int sem) {
        switch (sem) {
            case 1:
                return new String[] {"Mathematics I", "engg. mecanics", "Chemistry", "basic civil engg", "basic elctronics" , "UHV"};
            case 2:
                return new String[] {"Mathematics II", "c & Data Structures", "basic manufactruing process", "basic electrical engg.", "ETW"};
            default:
                return null;
        }
    }
}