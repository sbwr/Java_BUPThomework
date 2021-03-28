package homework6;
//书的描述信息，包括书的isbn号、书名、单价和书的类型。
//书的类型包括：非教材类的计算机图书、教材类图书、连环画类图书、其他共4种。在本例中共有5种书（见后面描述），因此需要创建5个ProductSpecification对象。
//有写入和读取描述信息的功能。
public class _18210811_wurui_6_ProductSpecification {
	private String isbn;
	private double price;
	private String title;
	private int type;//教材类0, 非教材类计算机图书1， 连环画类2， 其他3
	public _18210811_wurui_6_ProductSpecification(String isbn,double price,String title,int type){
		this.isbn=isbn;
		this.price=price;
		this.title=title;
		this.type=type;
	}
	public _18210811_wurui_6_ProductSpecification(){
		isbn="";
		price=0;
		title="";
		type=0;
	}
	public void setisbn(String isbn){
        this.isbn=isbn;
    }
	public void setprice(double price){
        this.price=price;
    }
	public void settitle(String title){
        this.title=title;
    }
	public void settype(int type){
        this.type=type;
    }
	public String getisbn(){
        return isbn;
    }
	public double getprice(){
        return price;
    }
	public String gettitle(){
        return title;
    }
	public int gettype(){
        return type;
    }
}