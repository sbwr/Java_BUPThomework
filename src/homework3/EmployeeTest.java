import java.util.Scanner;

abstract class Employee
{
	String firstName;
    String lastName;
	String socialSecurityNumber;
    int type;
	public Employee(int type, String firstName, String lastName, String socialSecurityNumber){
		this.type = type;
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
	}
	public String getfirstName(){
		return firstName;
	}
	public void setfirstName(String firstName){
		this.firstName = firstName;
	}
	public String getlastName(){
		return lastName;
	}
	public void setlastName(String lastName){
		this.lastName = lastName;
	}
	public String getsocialSecurityNumber(){
		return socialSecurityNumber;
	}
    public abstract void earning();    //抽象方法在继承时实现
    //返回标准输出格式的字符串
    public String toString(){
    	return "firstName:" + firstName +
                "; lastName:" + lastName +
                "; socialSecurityNumber:" + socialSecurityNumber +
                "; earning:" ;
    }
}

class SalariedEmployee extends Employee{ //佣金雇员 salary=grossSales*commissionRate
	double weeklySalary;    //周薪
	public SalariedEmployee(int type, String firstName, String lastName, String socialSecurityNumber, double weeklySalary){
		super(type, firstName, lastName, socialSecurityNumber);  //调用父类成员
		this.weeklySalary = weeklySalary;
	}
	public void earning(){  //计算薪水
		System.out.println(super.toString() + String.format("%.2f", weeklySalary* 4));
	}
}

class HourlyEmployee extends Employee{  //小时工 salary=每小时工钱wage*hours
	double wage, hours;
	public HourlyEmployee(int type, String firstName, String lastName, String socialSecurityNumber, double wage, double hours){
		super(type, firstName, lastName, socialSecurityNumber);
		this.wage = wage;
		this.hours = hours;
	}
	public void earning(){
		System.out.println(super.toString() + String.format("%.2f", wage * hours));
	}
}
class CommisionEmployee extends Employee{   //佣金员工 salary=销售额grossSales*提成commissionRate
	double grossSales, commissionRate;
	public CommisionEmployee(int type, String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate){
		super(type, firstName, lastName, socialSecurityNumber);
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
	}
	public void earning(){
		System.out.println(super.toString() + String.format("%.2f", grossSales*commissionRate));
	}
}
class BasePlusCommisionEmployee extends CommisionEmployee{  //salary = 基本工资baseSalary + grossSales*commissionRate
	double baseSalary;
    public BasePlusCommisionEmployee(int type, String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate, double baseSalary){
		super(type, firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
		this.baseSalary = baseSalary;
	}
	public void earning(){
		System.out.println(super.toString() + String.format("%.2f",grossSales*commissionRate + baseSalary));
	}
}


public class EmployeeTest{
	public static void main(String args[]){
		String input_tmp;
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			input_tmp = in.nextLine();
			String[] input = input_tmp.split(" ");
			String type = input[0];
			int command = Integer.parseInt(type);
            double input4 = Double.parseDouble(input[4]);
            switch (command){
                case 0:
                    SalariedEmployee salariedEm = new SalariedEmployee(command, input[1], input[2], input[3], input4);
                    salariedEm.earning();
                break;
                case 1:
                    double hours = Double.parseDouble(input[5]);
				    HourlyEmployee HourlyEm = new HourlyEmployee(command, input[1], input[2], input[3], input4, hours);
                    HourlyEm.earning();
                break;
                case 2:
                    double commissionRate = Double.parseDouble(input[5]);
				    CommisionEmployee CommisionEm = new CommisionEmployee(command, input[1], input[2], input[3], input4, commissionRate);
				    CommisionEm.earning();
                break;
                case 3:
                    double commissionRate2 = Double.parseDouble(input[5]);
				    double baseSalary = Double.parseDouble(input[6]);
					BasePlusCommisionEmployee BasePCommisionEm = 
						new BasePlusCommisionEmployee(command, input[1], input[2], input[3], input4, commissionRate2, baseSalary);
				    BasePCommisionEm.earning();
                break;
            }
        }
        in.close();
	}
}
