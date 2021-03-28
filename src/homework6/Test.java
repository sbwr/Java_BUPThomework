package homework6;
import java.util.Scanner;
//import java.util.ArrayList;

public class Test {
    static public void main(String arg[]){
        //测试PricingStrategyFactory是成功设计为单子模式：
        //_18210811_wurui_6_PricingStrategyFactory f1 = new _18210811_wurui_6_PricingStrategyFactory();
        _18210811_wurui_6_ProductSpecification book1, book2, book3, book4, book5;
        String input_tmp;
        Scanner in = new Scanner(System.in);
        System.out.println("请依次输入《UML与模式应用》、《Java与模式》、《HeadFirst设计模式》、\n《爱丽丝历险记》、《煲汤大全》所需件数（用空格分隔）...");
        input_tmp = in.nextLine();
        String[] input = input_tmp.split(" ");
        book1 = new _18210811_wurui_6_ProductSpecification("01", 18, "UML与模式应用", 0);//教材类0,   
        book2 = new _18210811_wurui_6_ProductSpecification("02", 34, "Java与模式", 1);//非教材类计算机图书1，
        book3 = new _18210811_wurui_6_ProductSpecification("03", 58, "HeadFirst设计模式", 1);//非教材类计算机图书1，
        book4 = new _18210811_wurui_6_ProductSpecification("04", 30, "爱丽丝历险记", 2);//连环画类2，
        book5 = new _18210811_wurui_6_ProductSpecification("05", 20, "煲汤大全", 3);//其他3
        //购买图书
        _18210811_wurui_6_SaleLineItem item1, item2, item3, item4, item5;
        item1 = new _18210811_wurui_6_SaleLineItem(Integer.parseInt(input[0]), book1);//2
        item2 = new _18210811_wurui_6_SaleLineItem(Integer.parseInt(input[1]), book2);//2
        item3 = new _18210811_wurui_6_SaleLineItem(Integer.parseInt(input[2]), book3);//1
        item4 = new _18210811_wurui_6_SaleLineItem(Integer.parseInt(input[3]), book4);//3
        item5 = new _18210811_wurui_6_SaleLineItem(Integer.parseInt(input[4]), book5);//1
        System.out.println("Books in your shoppingcart---");
        item1.show();
        item2.show();
        item3.show();
        item4.show();
        item5.show();
        System.out.println("Press \"y\" to get total price---");
        String tmp = in.nextLine();
        if(tmp.equals("y")){
            _18210811_wurui_6_Sale sale = new _18210811_wurui_6_Sale(5);
            sale.item.add(0,item1);
            sale.item.add(1,item2);
            sale.item.add(2,item3);
            sale.item.add(3,item4);
            sale.item.add(4,item5);
            double total = sale.getTotal();
            System.out.println("total price: "+ total);
        }
        System.out.println("end of shopping...");
        in.close();
    }
}