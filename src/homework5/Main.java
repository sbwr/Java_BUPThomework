package work5;

import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

public class Main extends JFrame implements ActionListener
{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	//菜单条组件
	private JMenuBar bar = new JMenuBar() ;
	
	//菜单组件：一级菜单：EmployeeInfoInput Search
	private JMenu EmInfoInput = new JMenu("EmployeeInfoInput") ;
	private JMenu Search = new JMenu("Search") ;
	
	//二级菜单：CommissionEmployee BasePlusEmployee AverageEarningSearch
	private JMenuItem ComEmployee = new JMenuItem("CommissionEmployee") ;
	private JMenuItem BasePlusEmployee = new JMenuItem("BasePlusCommisionEmployee") ;
	private JMenuItem AverEarningSearch = new JMenuItem("AverageEarningSearch") ;
	
	//文本框 输入fname lastName socialSecurityNumber grossSales commissionRate baseSalary
	private JLabel fname_Label = new JLabel("fnameName") ;
	private JTextField fnameName_Text = new JTextField(20) ;
	private JLabel lname_Label = new JLabel("lastName") ;
	private JTextField lname_Text = new JTextField(20) ;
	private JLabel SSNLabel = new JLabel("socialSecurityNumber") ;
	private JTextField SSNText = new JTextField(20) ;
	
	//对话框CommissionEmployee
	private JDialog ComEmployeeDialog = new JDialog(this, true) ;
	
	private JLabel CGrossSalesLabel = new JLabel("grossSales") ;
	private JTextField CGrossSalesText = new JTextField(20) ;
	
	private JLabel CComRateLabel = new JLabel("commissionRate(%)") ;
	private JTextField CComRateText = new JTextField(20) ;
	
	private JButton ComEmployeeOK = new JButton("OK") ;
	
	//BasePlusCommissonEmployee
	private JDialog BasePlusEmDialog = new JDialog(this, true) ;
	
	private JLabel BGSLabel = new JLabel("grossSales") ;
	private JTextField BGSText = new JTextField(20) ;
	
	private JLabel BComRateLabel = new JLabel("commissionRate(%)") ;
	private JTextField BComRateText = new JTextField(20) ;
	
	private JLabel BSLabel = new JLabel("BaseSalary") ;
	private JTextField BSText = new JTextField(20) ;
	
	private JButton BEmployeeOK = new JButton("OK") ;
	
	private JDialog Aver_Dialog = new JDialog(this, true) ;
	private JLabel AverLabel = new JLabel("") ;
	
	private JDialog Error_Dialog = new JDialog(this, true) ;
	private JLabel Error = new JLabel("Invalid input") ;
	
	private int total ; 
	private Employee[] em = new Employee[100] ;
	
	//constructor
	public Main()
	{
		total = 0 ;
		setLocation(400, 400) ;
		setTitle("Employee Information") ;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		setSize(300, 100) ;
		EmInfoInput.add(ComEmployee) ;
		EmInfoInput.add(BasePlusEmployee) ;
		
		Search.add(AverEarningSearch) ;
		
		//add JMenu to JMenuBar
		bar.add(EmInfoInput) ;
		bar.add(Search) ;
		
		//add JMenuBar to JFrame
		setJMenuBar(bar) ;
		
		//add listener to each JMenuItem 监听对象
		ComEmployee.addActionListener(this) ;
		BasePlusEmployee.addActionListener(this) ;
		AverEarningSearch.addActionListener(this) ;
		
		ComEmployeeOK.addActionListener(this);
		
		BEmployeeOK.addActionListener(this);
		
		//remove the highlighting around the button text
		BEmployeeOK.setFocusPainted(false);
		ComEmployeeOK.setFocusPainted(false);
		setVisible(true) ;
	}
	
	public void ComEmInput()
	{
		ComEmployeeDialog.setLocation(200, 200);
		ComEmployeeDialog.setTitle("CommissionEmployee");
		ComEmployeeDialog.setLayout(new GridLayout(0, 2));
		
		//添加输入框和按钮
		ComEmployeeDialog.add(fname_Label) ;
		ComEmployeeDialog.add(fnameName_Text) ;
		
		ComEmployeeDialog.add(lname_Label) ;
		ComEmployeeDialog.add(lname_Text) ;
		
		ComEmployeeDialog.add(SSNLabel) ;
		ComEmployeeDialog.add(SSNText) ;
		
		ComEmployeeDialog.add(CGrossSalesLabel) ;
		ComEmployeeDialog.add(CGrossSalesText) ;
		
		ComEmployeeDialog.add(CComRateLabel) ;
		ComEmployeeDialog.add(CComRateText) ;
		
		ComEmployeeDialog.add(ComEmployeeOK) ;
		ComEmployeeDialog.pack();
		
		fnameName_Text.setText("") ;
		lname_Text.setText("") ;
		SSNText.setText("") ;
		CGrossSalesText.setText("") ;
		CComRateText.setText("");
	}
	
	public void BasePlusEmInput()
	{
		BasePlusEmDialog.setLocation(200, 200);
		BasePlusEmDialog.setTitle("BasePlusCommissionEmployee");
		BasePlusEmDialog.setLayout(new GridLayout(0, 2));
		
		//添加输入框和按钮
		BasePlusEmDialog.add(fname_Label) ;
		BasePlusEmDialog.add(fnameName_Text) ;
		
		BasePlusEmDialog.add(lname_Label) ;
		BasePlusEmDialog.add(lname_Text) ;
		
		BasePlusEmDialog.add(SSNLabel) ;
		BasePlusEmDialog.add(SSNText) ;
		
		BasePlusEmDialog.add(BGSLabel) ;
		BasePlusEmDialog.add(BGSText) ;
		
		BasePlusEmDialog.add(BComRateLabel) ;
		BasePlusEmDialog.add(BComRateText) ;
		
		BasePlusEmDialog.add(BSLabel) ;
		BasePlusEmDialog.add(BSText) ;
		BasePlusEmDialog.add(BEmployeeOK) ;
		BasePlusEmDialog.pack();
		
		fnameName_Text.setText("") ;
		lname_Text.setText("") ;
		SSNText.setText("") ;
		BGSText.setText("") ;
		BComRateText.setText("");
		BSText.setText("");
	}
	//对话框，平均工资
	public void Aver()
	{
		Aver_Dialog.setTitle("AverageEarning");
		Aver_Dialog.add(AverLabel) ;
		Aver_Dialog.pack();
		Aver_Dialog.setSize(350, 100);
	}
	//对话框，输入错误
	public void Error()
	{
		Error_Dialog.setTitle("Error");
		Error_Dialog.add(Error) ;
		Error_Dialog.pack();
		Error_Dialog.setSize(350, 400);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == ComEmployee)
		{
			ComEmInput() ;
			ComEmployeeDialog.setVisible(true);
		}
		
		if (e.getSource() == BasePlusEmployee)
		{
			BasePlusEmInput() ;
			BasePlusEmDialog.setVisible(true);
		}
		//按下AverEarningSearch，计算并输出平均工资
		if (e.getSource() == AverEarningSearch)
		{
			Aver() ;
			double sum = 0.0 ;
			double average = 0.0 ;
			
			if (total != 0 )
			{
				for (int i = 0; i < total; i ++)
				{
					sum += em[i].earning() ;
				}
				average = (double)(sum / (double)total) ;
			}
			else
			{
				average = 0.0 ;
			}
			AverLabel.setText("The average earning is " + average);	
			Aver_Dialog.setVisible(true);
		}
		//按下OK，完成输入并隐藏窗口
		if (e.getSource() == ComEmployeeOK)
		{
			String fname = fnameName_Text.getText() ;
			String last = lname_Text.getText() ;
			String number = SSNText.getText() ;
			String grossSales = CGrossSalesText.getText() ;
			String comRate = CComRateText.getText() ;
			CommissionEmployee temp = new CommissionEmployee(fname, last, number, Double.parseDouble(grossSales), (Double.parseDouble(comRate)/100)) ;
			em[total] = temp ;
			total ++ ;
			ComEmployeeDialog.setVisible(false);
		}
		//按下OK，完成输入并隐藏窗口
		if (e.getSource() == BEmployeeOK)
		{
			String fname = fnameName_Text.getText() ;
			String last = lname_Text.getText() ;
			String number = SSNText.getText() ;
			String grossSales = BGSText.getText() ;
			String comRate = BComRateText.getText() ;
			String baseSalary = BSText.getText() ;
			BasePlusCommissionEmployee temp = new BasePlusCommissionEmployee(fname, last, number, Double.parseDouble(grossSales), (Double.parseDouble(comRate)/100), Double.parseDouble(baseSalary)) ;
			em[total] = temp ;
			total ++ ;
			BasePlusEmDialog.setVisible(false);
		}
		
	}
	
	public static void main(String[] args)
	{
		new Main() ;
	}
}
