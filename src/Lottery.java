import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Lottery extends JPanel implements ActionListener,ItemListener,KeyListener{
	JButton how = new JButton("玩法");//新增說明按鈕
	static URL fs= Lottery.class.getResource("/images/lottery.png");	
	JButton start = new JButton(new ImageIcon(fs));//新增再跑按鈕
	JLabel jbl[]=new JLabel[3];//新增一個放圖,二個放字的Label
	ImageIcon icon[]=new ImageIcon[7];//新增放圖陣列(7張)
	public static String num[],SL638s,L649s;
	public static Integer b[];
	public static int box,key,i=0;
	public static final int bSL638=1;
	public static final int bL649=2;
	public static final int bL740=3;
	public static final int bDC=4;
	public static final int btD=5;
	public static final int bfD=6;
	public Lottery(){		
		Choice choice = new Choice();//新增下拉式選單
		choice.addItemListener(this);//設置"聽"選項
		choice.add("─請選擇─");//提示選項
		choice.add("威力彩");//38選6+8選1(SL638,green,red,1,7,12)
		choice.add("大樂透");//49選6(L649,yellow,red,2,8,12)
		choice.add("大福彩");//40選7(L740,watermelon,3,9)
		choice.add("今彩539");//39選5(DC,lemon,4,10)
		choice.add("3星彩");//(0~9選1)*3(tD,purple,5,11)
		choice.add("4星彩");//選(0~9選1)*4(fD,purple,6,11)
		choice.setBounds(5,45,85,20);//設置選單位置
		add(choice);//show出下拉式選單
		jbl[0]=new JLabel(icon[0]);//放圖進圖框
		jbl[0].setBounds(5,10,79,27);//設置圖框起始座標
		add(jbl[0]);//圖框new出來
		how.addActionListener(this);//設置"聽"說明按鈕
		how.setBounds(415,2,60,20);//設置說明按鈕大小與位置
		how.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(how);//show出說明按鈕
		start.addActionListener(this);//設置"聽"說明按鈕
		start.setBounds(420,23,50,50);//設置說明按鈕大小與位置
		start.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(start);//show出再跑按鈕		
		jbl[1]=new JLabel();//載入註明圖框
		jbl[1].setBounds(100,0,270,30);//設置圖框位置
		add(jbl[1]);//new出圖框
		jbl[2]=new JLabel();//載入註明圖框
		jbl[2].setBounds(370,0,45,30);//設置圖框位置
		add(jbl[2]);//new出圖框
		for(i=0;i<=6;i++){
			icon[i]=new ImageIcon(Lottery.class.getResource("/images/i"+i+".gif"));//載入7張圖
		}
		jbl[0].setIcon(icon[0]);//選項小圖
		setLayout(null);//不使用預設輸出方式
		setBackground(Color.white);
		addKeyListener(this);
	}
	public void cls(){//清空註明圖框
		jbl[1].setText("");
		jbl[2].setText("");
	}
	public void SL638(){
		box=1;
		jbl[0].setIcon(icon[1]);//選項小圖
		Set SL638a= new HashSet();
		while (SL638a.size() < 6) {
			SL638a.add((int)(Math.random()*38+1));
		}
		Iterator SL638i=SL638a.iterator();
		num=new String[6];
		for(i=0;SL638i.hasNext();i++){
			Integer integer = (Integer) SL638i.next();
			num[i]=integer.toString();
			if(num[i].length()==1)
				num[i]=" "+num[i];
		}
		Integer SL638b=(int)(Math.random()*8+1);
		SL638s=" "+SL638b.toString();
		jbl[1].setText("┌──────── 一區 ────────┐");
		jbl[2].setText(" 二 區");		
	}
	public void L649(){
		box=2;
		jbl[0].setIcon(icon[2]);//選項小圖
		Set L649=new HashSet();
		while (L649.size() < 6) {
			L649.add((int)(Math.random()*49+1));
		}
		Iterator L649i=L649.iterator();
		num=new String[6];
		for(i=0;L649i.hasNext();i++){
			Integer integer = (Integer) L649i.next();
			num[i]=integer.toString();
			if(num[i].length()==1)
				num[i]=" "+num[i];
		}
		Integer L649b=(int)(Math.random()*49+1);
		if(L649b<10)
		L649s=" "+L649b.toString();
		else
		L649s=L649b.toString();
		jbl[2].setText("特別號");		
	}
	public void L740(){
		box=3;
		jbl[0].setIcon(icon[3]);//選項小圖
		Set L740=new HashSet();
		while (L740.size() < 7) {
			L740.add((int)(Math.random()*40+1));
		}
		Iterator L740i=L740.iterator();
		num=new String[7];
		for(i=0;L740i.hasNext();i++){
			Integer integer = (Integer) L740i.next();
			num[i]=integer.toString();
			if(num[i].length()==1)
				num[i]=" "+num[i];
		}
	}
	public void DC(){
		box=4;
		jbl[0].setIcon(icon[4]);//選項小圖
		Set DC=new HashSet();
		while (DC.size() < 5) {
			DC.add((int)(Math.random()*39+1));
		}		
		Iterator DCi=DC.iterator();
		num=new String[5];
		for(i=0;DCi.hasNext();i++){
			Integer integer = (Integer) DCi.next();
			num[i]=integer.toString();
			if(num[i].length()==1)
				num[i]=" "+num[i];
		}
	}
	public void tD(){
		box=5;
		jbl[0].setIcon(icon[5]);//選項小圖
		b=new Integer[3];
		num=new String[3];
		for(i=0;i<3;i++){
			b[i]=(int)(Math.random()*10);
			num[i]=" "+b[i].toString();
		}
	}
	public void fD(){
		box=6;
		jbl[0].setIcon(icon[6]);//選項小圖
		b=new Integer[4];
		num=new String[4];
		for(i=0;i<4;i++){
			b[i]=(int)(Math.random()*10);
			num[i]=" "+b[i].toString();
		}
	}
	public void none(){
		box=7;
		jbl[0].setIcon(icon[0]);//選項小圖;
	}
	public void runcase(){
		switch(box){//判斷跑哪一組
		  case bSL638:SL638();break;
		  case bL649:L649();break;
		  case bL740:L740();break;
		  case bDC:DC();break;
		  case btD:tD();break;
		  case bfD:fD();break;
		}
	}
	public void itemStateChanged(ItemEvent e) {//下拉式選單
		cls();
		repaint();
		Choice c = (Choice) e.getSource();
		if (c.getSelectedItem() == "威力彩") SL638();
		if (c.getSelectedItem() == "大樂透") L649();
		if (c.getSelectedItem() == "大福彩") L740();
		if (c.getSelectedItem() == "今彩539") DC();
		if (c.getSelectedItem() == "3星彩") tD();
		if (c.getSelectedItem() == "4星彩") fD();
		if (c.getSelectedItem() == "─請選擇─") none();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "玩法") {
			JFrame HowToPlay=new HowToPlay();			
		}
		if (e.getSource()==start){//按"發"重跑
			repaint();
			runcase();
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
//		key = e.getKeyChar();
//		System.out.println(key);
//		if(key==KeyEvent.VK_ENTER) runcase();
//		if(key == 10) runcase();
	}
	@Override
	public void keyPressed(KeyEvent e) {
		runcase();
	}
	@Override
	public void keyReleased(KeyEvent ek){}

	public void paintComponent(Graphics g) {//畫圖
		super.paintComponent(g);
		g.setFont(new Font(null, Font.BOLD, 24));//設置字體
		switch(box){//判斷跑哪一組
		  case bSL638:
			g.setColor(new Color(160,231,22));//威力彩綠色
			for(i=0;i<6;i++){
				g.fillOval(100+45*i,25,41,41);//畫彩球
			}
			g.setColor(new Color(226,0,16));//紅色
			g.fillOval(100+45*6,25,41,41);//畫彩球
			g.setColor(Color.BLACK);//黑色(for字)
			for(i=0;i<6;i++){
				g.drawString(num[i],107+45*i,53);//秀獎號
			}
			g.setColor(Color.WHITE);//白色(for字)
			g.drawString(SL638s,377,53);//秀二區獎號
			break;
		  case bL649:
			g.setColor(new Color(255,191,17));//大樂透黃色
			for(i=0;i<6;i++){
				g.fillOval(100+45*i,25,41,41);//畫彩球
			}
			g.setColor(new Color(226,0,16));//紅色
			g.fillOval(100+45*6,25,41,41);//畫彩球
			g.setColor(Color.BLACK);//黑色(for字)
			for(i=0;i<6;i++){
				g.drawString(num[i],107+45*i,53);//秀獎號
			}
			g.setColor(Color.WHITE);//白色(for字)
			g.drawString(L649s,377,53);//秀特別號
			break;
		  case bL740:
			g.setColor(new Color(251,94,112));//大福彩淡紅色
			for(i=0;i<7;i++){
				g.fillOval(100+45*i,25,41,41);//畫彩球
			}
			g.setColor(Color.BLACK);//黑色(for字)
			for(i=0;i<7;i++){
				g.drawString(num[i],107+45*i,53);//秀獎號
			}
		    break;
		  case bDC:
			g.setColor(new Color(255,240,2));//今彩539黃色
			for(i=0;i<5;i++){
				g.fillOval(100+45*i,25,41,41);//畫彩球
			}
			g.setColor(Color.BLACK);//黑色(for字)
			for(i=0;i<5;i++){
				g.drawString(num[i],107+45*i,53);//秀獎號
			}
			break;
		  case btD:
			g.setColor(new Color(230,164,255));//星彩紫色
			for(i=0;i<3;i++){
				g.fillOval(100+45*i,25,41,41);//畫彩球
			}
			g.setColor(Color.BLACK);//黑色(for字)
			for(i=0;i<3;i++){
				g.drawString(num[i],107+45*i,53);//秀獎號
			}
			break;
		  case bfD:
			g.setColor(new Color(230,164,255));//星彩紫色
			for(i=0;i<4;i++){
				g.fillOval(100+45*i,25,41,41);//畫彩球
			}
			g.setColor(Color.BLACK);//黑色(for字)
			for(i=0;i<4;i++){
				g.drawString(num[i],107+45*i,53);//秀獎號
			}
			break;
		  case 7:
			g.clearRect(100,25,315,41);
		}
	}
	public static void main(String[] args) {		
		Lottery gogo=new Lottery();
		JFrame frame = new JFrame("台灣彩卷-電腦選號");//設置程式標題
		frame.addWindowListener(new AdapterDemo());//設置程式關閉按鈕
		frame.getContentPane().add(gogo);//把樂透Panel放進Frame
		frame.setSize(490,100);//設置主視窗大小
		frame.setResizable(false);//不可縮放視窗
		frame.setLocationRelativeTo(null);//視窗置中
		frame.setIconImage(new ImageIcon(fs).getImage());//重置視窗圖示
		frame.setVisible(true);//可見主視窗
		gogo.requestFocusInWindow();
	}
}
class AdapterDemo extends WindowAdapter {//結束程式的方法
	public void windowClosing(WindowEvent e) {
		System.exit(0);		
	}
}