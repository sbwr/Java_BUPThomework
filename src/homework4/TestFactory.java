import java.util.*;

class Employee{
	int type;
	String firstname, lastname, socialnumber;
	double weeklySalary, wage, grossSales, hours;
	double commissionrate, basesalary, earning;
	
	Employee(int type, String firstname, String lastname, String socialnumber){
		this.type = type;
		this.firstname = firstname;
		this.lastname = lastname;
		this.socialnumber = socialnumber;
	}
	double earning(int type, double a, double b, double c){
		if(type == 0){
			this.weeklySalary = a;
			earning =  weeklySalary * 4.00;
		}
		if(type == 1 ){
			this.wage = a;
			this.hours = b;
			earning = wage * hours;
		}
		if(type == 2){
			this.commissionrate = a;
			this.grossSales = b;
			earning = commissionrate * grossSales;
		}
		if(type == 3){
			this.commissionrate = a;
			this.grossSales = b;
			this.basesalary = c;
			earning =  commissionrate * grossSales + basesalary;
		}
		return earning;
	}
	public String toString(){
        return "firstName:" + firstname +
                "; lastName:" + lastname +
                "; socialSecurityNumber:" + socialnumber +
                "; earning:" + String.format("%.2f", earning);
	}
}

class Factory{
	private HashMap<String, Employee>employees = new HashMap<>();
	//	初始化哈希图
	void initEmployees(List<String> es){
		//Integer.valueOf() 转换为Integer类型， .intValue() 转换为int类型。
		Employee x = new Employee(Integer.valueOf(es.get(1)).intValue(), es.get(2), es.get(3), es.get(4));
        x.earning(Integer.valueOf(es.get(1)).intValue(), Double.valueOf(es.get(5)).doubleValue(),
                  Double.valueOf(es.get(6)).doubleValue(), Double.valueOf(es.get(7)).doubleValue());
        employees.put(es.get(4), x);
	}
	Employee searchEmployee(String empSecNum){//按号查找，返回key
		//.keyset()方法将employees中所有的key值存入keyset中
		Set<String> keyset = employees.keySet();
		//用迭代器遍历集合keyset。
		Iterator<String> it = keyset.iterator();
		while(it.hasNext()){//遍历查找
			String key = it.next();
			if(empSecNum.equals(key)){//找到该号码
                return employees.get(key);//返回找到的对象
			}
		}
			return null;
	}
	void getEmployee(String empSecNum){
		Employee tmp = searchEmployee(empSecNum);
		if(tmp == null){
			System.out.println("get: employee not found.");
		}
		else{
			System.out.println(tmp);
		}
	}
	void deleteEmployee(String empSecNum)
	{
		Employee tmp = searchEmployee(empSecNum);
		if(tmp == null){
			System.out.println("delete: employee not found.");
		}
		else{
			employees.remove(empSecNum);
			System.out.println(tmp);
		}
	}
	Employee addEmployee(Employee stu)
	{
		Employee tmp = searchEmployee(stu.socialnumber);
		if(tmp == null){ //不存在相同的key/社保号，添加该员工
			employees.put(stu.socialnumber, stu);
			System.out.println(stu);
            return stu;
		}
		//若存在相同的社保号，输出“已存在”
		System.out.println("add: employee exists.");
        return null;
	}
	Employee updateEmployee(String empSecNum ,Employee emp)
	{
		Employee tmp = searchEmployee(empSecNum);
		if(tmp == null){//未找到该员工	
			System.out.println("update: employee not found.");
            return null;
		}
		//找到了该社保好的员工，更新
		employees.put(empSecNum,emp);
        System.out.println(emp);
		return emp;
	}
	void printEmployees(){
		//强for循环
		for (String num : employees.keySet()){
            System.out.println(employees.get(num).toString());
	    }
	}
}

public class TestFactory {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		Factory factory = new Factory();
		while(in.hasNext()){
			//题目要求initEmployees(List es)方法的参数是列表
			List<String> es = new ArrayList<String>();
			String text = in.nextLine();
			String[] str = text.split(" ");
			for (int i = 0; i <8; i++){
	                if (i < str.length)
	                    es.add(str[i]);
	                else
	                    es.add("0");
			}
			//识别需要执行的功能
	        if (str[0].equals("init")){
	            if (str[1].equals("-1")) continue;
	            else factory.initEmployees(es);
	        }
	        else if(str[0].equals("get")){
	        	factory.getEmployee(str[1]);
	        }
		    else if(str[0].equals("add")){
		        Employee stu = new Employee(Integer.valueOf(es.get(1)).intValue(), es.get(2), es.get(3), es.get(4));
		        stu.earning(Integer.valueOf(es.get(1)).intValue(), Double.valueOf(es.get(5)).doubleValue(), Double.valueOf(es.get(6)).doubleValue(), Double.valueOf(es.get(7)).doubleValue());
		        factory.addEmployee(stu);	 
			}
			else if(str[0].equals("update")){
		        Employee emp = new Employee(Integer.valueOf(es.get(1)).intValue(), es.get(2), es.get(3), es.get(4));
		        emp.earning(Integer.valueOf(es.get(1)).intValue(), Double.valueOf(es.get(5)).doubleValue(), Double.valueOf(es.get(6)).doubleValue(), Double.valueOf(es.get(7)).doubleValue());
		        factory.updateEmployee(emp.socialnumber, emp);
		    }
		    else if(str[0].contentEquals("delete")){
				factory.deleteEmployee(es.get(1));
		    }
			else if(str[0].contentEquals("print")){
				factory.printEmployees();
		    }
        }
        in.close();  
	 }
}
