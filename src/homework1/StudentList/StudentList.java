package StudentList;
import java.text.DecimalFormat;
import java.util.Scanner;

class student{
    String student_number;
    String student_name;
    int math;
    int english;
    int science;
    double average;
    DecimalFormat df=new DecimalFormat("#.00");
    student(String student_number,String student_name,int math,int english,int science)
    {
        this.student_number=student_number;
        this.student_name=student_name;
        this.math=math;
        this.english=english;
        this.science= science;
        average= (math+english+science)/3.0;//1 2011211301 LiHang 88 79 90
    }
 
 
 
    public String get_out() {
        return ("Number:"+this.student_number+"\nName:"+this.student_name+"\nMath:"+this.math+"\nEnglish:"+this.english+"\nScience:"+this.science+"\nAve:"+df.format(average));
    }
}
 
class StudentList{
    student[]list;
    int total=0;
    StudentList(int lenth)
    {
        list=new student[lenth];
    }
    boolean add(student stu)
    {
        if(total>list.length)
        {
            return false;
        }
        else
        {
            list[total]=new student(stu.student_number,stu.student_name,stu.math,stu.english,stu.science);
            total++;
            return true;
        }
    }
    boolean remove(int no)
    {
        if(no>total)
        {
            return false;
        }
        else {
            for(int j=no;j<total-1;j++)
            {
                list[j]=list[j+1];
            }
            total--;
            return true;
        }
    }
    boolean remove(String number)
    {
        if(!isEmpty())
        {
            for(int i=0;i<total;i++)
            {
                if(list[i].student_number==number)
                {
                    for(int j=i;j<total-1;j++)
                    {
                        list[j]=list[j+1];
                     }
                total--;
                return true;
                }
             }
        }
        return false;
    }
    boolean isEmpty()
    {
        if(total==0)return true;
        return false;
    }
    void show()
    {
        for(int i=0;i<total;i++)
        {
            System.out.println(list[i].get_out());
        }
    }
    student getitem(int no)
    {
        if(no>=total)return null;
        return list[no];
    }
    student getitem(String number)
    {
        for(int i=0;i<total;i++)
        {
            if(list[i].student_number==number)
            {
                return list[i];
            }
        }
        return null;
    }
}
 
class StudentListTest {
    public static  void main(String []args)
    {
        StudentList list1 = new StudentList(100);
        String line;
        Scanner in = new Scanner( System.in);
        while(in.hasNext())//检测每次输入
        {
            line=in.nextLine();
            String s1[]=line.split(" ");
            String s2=s1[0];
            int command=Integer.parseInt(s2);
            if(command==1)//增加1个学生
            {
               String student__number =s1[1];
               String student__name = s1[2];
               int  markForMaths =Integer.parseInt(s1[3]);
               int  markForEnglish=Integer.parseInt(s1[4]);
               int  markForScience=Integer.parseInt(s1[5]);
               student stu=new student(student__number,student__name,markForMaths,markForEnglish,markForScience);
               if(list1.add(stu))
               {
                   System.out.println(list1.total+" Students at the moment as described below:");
                   list1.show();
               }
            }
 
            else if (command==2)//根据学号删除学生
            {
               String delete_student_number=s1[1];
               if(list1.remove(delete_student_number))
               {
                   System.out.println("Remove successfully");
                   System.out.println(list1.total+" Students at the moment as described below:");
                   list1.show();
               }
               else
               {
                   System.out.println("No such student");
               }
            }
            else if(command==3)//根据位置删除学生
            {
 
                    int temp=Integer.parseInt(s1[1]);
                    if(list1.remove(temp-1))
                    {
                        //syso
                        System.out.println("Remove successfully");
                        System.out.println(list1.total+" Students at the moment as described below:");
                        list1.show();
                    }
                    else {
                        System.out.println("No such student");//spellchecked inspe
 
                }
            }
            else if(command==4)//判断是否为空
            {
                if(list1.isEmpty())
                {
                    System.out.println("为空");
                }
                else {
                    {
                        System.out.println("不为空");
                    }
                }
            }
            if(command==5)//按照序号
            {
                int temp=Integer.parseInt(s1[1]);
                if(list1.getitem(temp-1)!=null)
                {
                    System.out.println("Student Info:\n"+list1.list[temp-1].get_out());
                }
                else
                {
                    System.out.println("No such student");
                }
            }
            else if(command==6)//按照学号查找
            {
 
                    if(list1.getitem(s1[1])!=null)
                    {
                        System.out.println("Student Info:\n"+list1.getitem(s1[1]).get_out());
                    }
                    else System.out.println("No such student");
 
 
            }
            else if(command==7)
            {
                list1.show();
            }
            else if(command==8)
            {
                System.exit(0);
                in.close();
            }
 
        }
 
    }
}