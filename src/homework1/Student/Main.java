package StudentSystem;

public class Main {
    public static void main(String[] args){
        TestStudent test = new TestStudent(); 
        Student student = new Student();
            test.InputStudent(student);
            System.out.println("Student Info:");
            test.PrintStudent(student);
        student.input.close();
    }
}
