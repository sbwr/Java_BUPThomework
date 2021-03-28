package work5;

public class BasePlusCommissionEmployee extends CommissionEmployee{
	//fields
	private double baseSalary ;
	
	//constructor
	public BasePlusCommissionEmployee()
	{
		super() ;
		baseSalary = 0 ;
	}
	
	public BasePlusCommissionEmployee(String first, String last, String number, double gross, double rate, double salary)
	{
		super(first, last, number, gross, rate) ;
		baseSalary = 0 ;
	}
	
	//methods
	public double earning()
	{
		return getGrossSales() * getCommissionRate() + baseSalary ;
	}
	
	public double getBaseSalary()
	{
		return baseSalary ;
	}
	
	public void setBaseSalary(double salary)
	{
		baseSalary = salary ;
	}
	
	public String toString()
	{
		return super.toString() + " baseSalary:" + baseSalary ;
	}
}
