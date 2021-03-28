package homework6;
//策略类的接口，用于向SaleLineItem屏蔽具体的策略类。
public interface _18210811_wurui_6_IPricingStrategy {
	public abstract double getSubTotal(_18210811_wurui_6_SaleLineItem m);
	public String getnumber();
	public String getname();
	public String gettype();
	public int getbooktype();
	public String getdiscount();
	public void setnumber(String s);
	public void setname(String s);
	public void settype(String s);
	public void setbooktype(int n);
	public void setdiscount(String s);
	public void add(_18210811_wurui_6_IPricingStrategy strategy);    
}