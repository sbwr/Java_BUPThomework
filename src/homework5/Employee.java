package work5;

//import java.util.* ;

public abstract class Employee {
	//abstract functions
	public abstract double earning() ;
	//fields
	private String firstName ;
	private String lastName ;
	private String socialSecurityNumber ;
	
	//constructor
	public Employee()
	{
		firstName = "" ;
		lastName = "" ;
		socialSecurityNumber = "" ;
	} 
	
	public Employee(String first, String last, String number)
	{
		firstName = first ;
		lastName = last ;
		socialSecurityNumber = number ;
	}
	
	//methods
	public String getFirstName()
	{
		return firstName ;
	}
	
	public String getLastName()
	{
		return lastName ;
	}
	
	public String getSocialSecurityNumber()
	{
		return socialSecurityNumber ;
	}
	
	public void setFirstName(String first)
	{
		firstName = first ;
	}
	
	public void setLastName(String last)
	{
		lastName = last ;
	}
	
	public String toString()
	{
		return ("firstName:" + firstName + " lastName:" + lastName + " socialSecurityNumber:" + socialSecurityNumber) ;
	}
}

