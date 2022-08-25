package nguyenquangtoan_20080701_demo2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

public class demotuan2 extends JFrame implements ActionListener{
	private JButton buttonG;
	private JButton buttonX;
	private JButton buttonT;
	private JRadioButton btc;
	private JRadioButton btt;
	private JRadioButton btx;
	private JRadioButton btch;
	private JTextField jta;
	private JTextField jtb;
	private JTextField jtKQ;
	public demotuan2() {
		setTitle("Cộng-Trừ-Nhân-Chia1");
		setSize(450,450);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Gui();
	}
	public void Gui(){
		JPanel jPanelN = new JPanel();
		JLabel jlb = new JLabel("Cộng Trừ Nhân Chia111");
		jlb.setForeground(Color.blue);
		jlb.setFont(new Font("Arial",Font.BOLD,20));
		add(jPanelN, BorderLayout.NORTH);
		jPanelN.add(jlb);
		JPanel jPanelE = new JPanel();
		jPanelE.setLayout(new GridBagLayout());
		buttonG = new JButton("Giải");
		buttonG.setMnemonic(KeyEvent.VK_G);
		buttonX = new JButton("Xoá");
		buttonX.setMnemonic(KeyEvent.VK_X);
		 buttonT = new JButton("Thoát");
		buttonT.setMnemonic(KeyEvent.VK_T);
		jPanelE.setPreferredSize(new Dimension(100,0));
		jPanelE.setLayout(null);
		jPanelE.add(buttonG);
		jPanelE.add(buttonX);
		jPanelE.add(buttonT);
		jPanelE.setBorder(BorderFactory.createTitledBorder("Chọn Tác Vụ"));
		buttonG.setBounds(10,20,80,30);
		buttonT.setBounds(10,75,80,30);
		buttonX.setBounds(10,130,80,30);
		jPanelE.setBackground(Color.LIGHT_GRAY);
		add(jPanelE, BorderLayout.WEST);
		JPanel jPanelCT = new JPanel();
		jPanelCT.setLayout(null);
		add(jPanelCT, BorderLayout.CENTER);
		JLabel lba = new JLabel("Nhập a:");
		JLabel lbb = new JLabel("Nhập b:");
		JLabel lbKQ = new JLabel("Kết Quả:");
		jPanelCT.setBorder(BorderFactory.createTitledBorder("Tính toán"));
		lba.setBounds(40,30,100,20);
		lbb.setBounds(40,50,100,30);
		lbKQ.setBounds(40,300,100,30);
		jPanelCT.add(lba);
		jPanelCT.add(lbb);
		jPanelCT.add(lbKQ);
		jta = new JTextField();
		jtb = new JTextField();
		jtKQ = new JTextField();
		jPanelCT.add(jta);
		jPanelCT.add(jtb);
		jPanelCT.add(jtKQ);
		//jPanelCT.setBorder(BorderFactory.createTitledBorder(""));
		jta.setBounds(90,20,200,33);
		jtb.setBounds(90,50,200,33);
		jtKQ.setBounds(90,300,200,30);
		jtKQ.setEditable(false);
		buttonG.addActionListener(this);
		buttonX.addActionListener(this);
		buttonT.addActionListener(this);
		JPanel jPanelctct = new JPanel();
		btc = new JRadioButton("Cộng");
		btt = new JRadioButton("Trừ");
		btx = new JRadioButton("Nhân");
		btch = new JRadioButton("Chia");
		jPanelctct.setLayout(new GridLayout(2,2));
		jPanelctct.setBorder(BorderFactory.createTitledBorder("Phép Tính"));
		jPanelctct.setBounds(10,90,200,200);
		ButtonGroup btg = new ButtonGroup();
		btg.add(btc);
		btg.add(btt);
		btg.add(btx);
		btg.add(btch);
		btc.setSelected(true);
		jPanelctct.add(btc);
		jPanelctct.add(btt);
		jPanelctct.add(btx);
		jPanelctct.add(btch);
		jPanelCT.add(jPanelctct);		
		
		
		
	}
	public static void main(String[] args) {
		new demotuan2().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(buttonT)) {
			System.exit(0);
		} else if(o.equals(buttonX)) {
			jta.setText("");
			jtb.setText("");
			jtKQ.setText("");
			btc.setSelected(true);
			jta.requestFocus();
		}
		else {
			int a = Integer.parseInt(jta.getText());
			int b = Integer.parseInt(jtb.getText());
			double kq = 0.0;
			if (btc.isSelected()) {
				kq = a + b;
			} else if(btt.isSelected()){
				kq = a - b;
			}
			else if(btx.isSelected()){
				kq = a * b;
			}
			else if(btch.isSelected()){
				if (b!=0) {
					kq = a / b;
				}
				else {
					jtb.requestFocus();
				}
			}
			jtKQ.setText(kq + "");
		}
	}
}
