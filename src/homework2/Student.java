/**作业2 异常处理**/
import java.io.IOException;
import java.util.Scanner;

class TestStudent{
    void InputStudent(Student student){
        try{
        student.studentNumber = student.getNumber();
        }
        catch(IOException ex){
            System.out.println("Illegal number format");
            System.exit(0);
        }
        student.studentName = student.getName();
        student.markForMaths = student.getMathsMark();
        student.markForEnglish = student.getEnglishMark();
        student.markForScience = student.getScienceMark();
        try{
            student.averageMark = student.calculateAverage();
        }
        catch(IOException ex){
            System.out.println("Illegal score format");
            System.exit(0);
        }
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
    String getNumber() throws IOException {
        studentNumber=input.next();
        char num[] = studentNumber.toCharArray();
        if(studentNumber.length() != 10 || num[0] != '2' || num[1] != '0'
        || num[2]<'0' || num[2]>'9' || num[3]<'0' || num[3]>'9'|| num[4]<'0' || num[4]>'9'
        || num[5]<'0' || num[5]>'9'|| num[6]<'0' || num[6]>'9'|| num[7]<'0' || num[7]>'9'
        || num[8]<'0' || num[8]>'9'|| num[9]<'0' || num[9]>'9'){
            throw new IOException("Illegal number format"); 
        }
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
    double calculateAverage() throws IOException{
        if( markForEnglish < 0 || markForEnglish > 100
         || markForMaths < 0 || markForMaths > 100
         || markForScience < 0 || markForScience > 100){
            throw new IOException("Illegal score format");
        }
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
