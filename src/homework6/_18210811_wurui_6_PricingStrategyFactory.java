package homework6;
//策略工厂，根据书的类型返回对应的策略类，
//策略类将根据具体的优惠策略计算折扣后1个销售项目（SaleLineItem）的总价。
//要求：该策略工厂要设计成单子。1.构造器私有2.自己持有自身的一个静态引用3.对外面系统提供访问唯一实例的公共静态接口(方法).
public class _18210811_wurui_6_PricingStrategyFactory {
    /***设计为单子模式(饿汉式)
    //1 私有构造器。外部不能访问
    private _18210811_wurui_6_PricingStrategyFactory(){}
    //2 声明一个静态的自己的类 
    private static final _18210811_wurui_6_PricingStrategyFactory PSFactory = new _18210811_wurui_6_PricingStrategyFactory();
    //3 调用该类的方法
    public static _18210811_wurui_6_PricingStrategyFactory getInstance(){//返回唯一实例
        return PSFactory;
    }
    ***/

    //懒汉式
    private _18210811_wurui_6_PricingStrategyFactory(){}
    //默认不会实例化，什么时候用什么时候new
    private static _18210811_wurui_6_PricingStrategyFactory PSFactory=null;
    public static synchronized _18210811_wurui_6_PricingStrategyFactory getInstance(){
    if(PSFactory==null){
        PSFactory=new _18210811_wurui_6_PricingStrategyFactory();
        }
        return PSFactory;
    }
    

    //对连环画类图书提供每本7%的促销折扣；而对非教材类的计算机图书有3%的折扣；对其余书没有折扣。
    //修改、增减折扣只需要在此修改
    String TextBookDiscount = "1";
    String ComicDiscount = "7";
    String nonTextBookDiscount = "3";
	public double getItemTotal(final _18210811_wurui_6_SaleLineItem item){
        _18210811_wurui_6_IPricingStrategy strategy;
        //根据书的类型选择适当策略类
        switch (item.prodSpec.gettype()){//教材类0, 非教材类1， 连环画类2， 其他3
            case 0:
                strategy = new _18210811_wurui_6_FlatRateStrategy();
                strategy.setdiscount(TextBookDiscount);
                break;
            case 1:
                strategy = new _18210811_wurui_6_PercentageStrategy();
                strategy.setdiscount(nonTextBookDiscount);
                break;
            case 2:strategy = new _18210811_wurui_6_PercentageStrategy();
                strategy.setdiscount(ComicDiscount);
                break;
            case 3:
                strategy = new _18210811_wurui_6_NoDiscountStrategy();break;
            default:strategy = new _18210811_wurui_6_NoDiscountStrategy();break;
        }
        double itemtotal = (strategy.getSubTotal(item)) * item.number;
		return itemtotal;
    }
}
