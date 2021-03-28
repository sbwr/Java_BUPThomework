import java.util.Scanner;

class TestStudent{
    void InputStudent(Student student){
        student.studentNumber = student.getNumber();
        student.studentName = student.getName();
        student.markForMaths = student.getMathsMark();
        student.markForEnglish = student.getEnglishMark();
        student.markForScience = student.getScienceMark();
        student.averageMark = student.calculateAverage();
    }
    void PrintStudent(Student student){
        System.out.println("Number:"+ student.studentNumber);
        System.out.println("Name:" + student.studentName);
        System.out.println("Math:" + student.markForMaths);
        System.out.println("English:" + student.markForEnglish);
        System.out.println("Science:" + student.markForScience);
        System.out.println("Ave:" + String.format("%.2f", student.averageMark));
    }
}

public class Student {
    Student(){};
    Student(String number, String name){
    };
    String studentNumber= null;
    String studentName = null;
    int markForMaths=-1;
    int markForEnglish=-1;
    int markForScience=-1;
    double averageMark=-1;
    Scanner input=new Scanner(System.in);
    String getNumber(){
        studentNumber=input.next();
        return studentNumber;
    };
    String getName(){
        return input.next();
    };
    int getMathsMark(){
        return input.nextInt();
    }
    int getEnglishMark(){
        return input.nextInt();
    }
    int getScienceMark(){
        return input.nextInt();
    }
    double calculateAverage(){
        return (markForEnglish + markForMaths + markForScience)/3.0;
    }

    public static void main(String[] args){
        TestStudent test = new TestStudent(); 
        Student student = new Student();
        test.InputStudent(student);
        System.out.println("Student Info:");
        test.PrintStudent(student);
        student.input.close();
    }
}
