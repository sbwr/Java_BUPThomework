package homework6;
import java.util.ArrayList;
//调用SaleLineItem依次销售
public class _18210811_wurui_6_Sale{
    ArrayList<_18210811_wurui_6_SaleLineItem> item = new ArrayList<_18210811_wurui_6_SaleLineItem>();
    int size;//总item数
    double price = 0;
    public _18210811_wurui_6_Sale(int size){
        this.size = size;
    }
    public double getTotal(){
		price=0;
        size=item.size();
        _18210811_wurui_6_PricingStrategyFactory strategy;
        strategy = _18210811_wurui_6_PricingStrategyFactory.getInstance();
        //调用策略工厂计算的每个销售项目的总价，求出最终的总价。
		for(int i=0;i<size;i++){
            price=price+strategy.getItemTotal(item.get(i));
            //System.out.println(price);
		}
		return price;
	}
}