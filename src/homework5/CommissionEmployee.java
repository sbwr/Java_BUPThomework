package work5;

//import java.util.* ;

public class CommissionEmployee extends Employee{
	//fields
	private double grossSales ;
	private double commissionRate ;
	//constructor
	public CommissionEmployee()
	{
		super() ;
		grossSales = 0 ;
		commissionRate = 0 ;
	}
	
	public CommissionEmployee(String first, String last, String number, double gross, double rate)
	{
		super(first, last, number) ;
		grossSales = gross ;
		commissionRate = rate ;
	}
	
	//methods
	public double earning()
	{
		return grossSales * commissionRate ;
	}
	
	public double getGrossSales()
	{
		return grossSales ;
	}
	
	public double getCommissionRate()
	{
		return commissionRate ;
	}
	
	public void setGrossSales(double gross)
	{
		grossSales = gross ;
	}
	
	public void setCommissionRate(double rate)
	{
		commissionRate = rate ;
	}
	
	public String toString()
	{
		return super.toString() + " grossSales:" + grossSales + " commissionRate:" + commissionRate ;
	}
}
