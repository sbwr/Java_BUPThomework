package homework6;
//无折扣
public class _18210811_wurui_6_NoDiscountStrategy implements _18210811_wurui_6_IPricingStrategy{//无优惠
    String number;
	String name;
	String type;
	int booktype;
	String discount;
	public double getSubTotal(_18210811_wurui_6_SaleLineItem m){
		return m.prodSpec.getprice();
	}
	public String getnumber(){return number;}
	public String getname(){return name;}
	public String gettype(){return type;}
	public int getbooktype(){return booktype;}
	public String getdiscount(){return discount;}
	public void setnumber(String s){number=s;}
	public void setname(String s){name=s;}
	public void settype(String s){type=s;}
	public void setbooktype(int n){booktype=n;}
	public void setdiscount(String s){discount=s;}
	public void add(_18210811_wurui_6_IPricingStrategy strategy){}
}