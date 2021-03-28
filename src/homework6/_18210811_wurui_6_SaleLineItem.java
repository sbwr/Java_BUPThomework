package homework6;
//代表一个销售项目。1次销售会对应多个销售项目。如顾客总共购买了2本《UML与模式应用》，3本《Java与模式》，
//则对应需要创建两个SaleLineItem对象，
//1个对应的是2本《UML与模式应用》的购买，1个对应的是3本《Java与模式》的购买。
public class _18210811_wurui_6_SaleLineItem {
    int number;
    _18210811_wurui_6_ProductSpecification prodSpec;
    public int getNumber() {//件数
        return number;
    }
    public _18210811_wurui_6_SaleLineItem(int number, _18210811_wurui_6_ProductSpecification book){//初始化时输入本数和书
        this.number = number;
        this.prodSpec = book;
    }
    public void show(){
        System.out.println("isbn: "+prodSpec.getisbn());
        System.out.println("title: "+prodSpec.gettitle());
        System.out.println("type: "+prodSpec.gettype());
        System.out.println("price: "+prodSpec.getprice());
        System.out.println();
    }
}