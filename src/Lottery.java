import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

public class Lottery extends JPanel implements ActionListener,KeyListener{
	
	static JFrame frame = new JFrame("台灣彩券-電腦選號小程式v1.3.1");//設置程式標題
    static JMenuBar menubar = new JMenuBar();//新增選單列
	static URL fs= Lottery.class.getResource("/images/lottery.png");
	static Integer b[],c[];
	static String num[],SL638s,L649s;	
	static int box,key,i=0,width=490,height=130,balltext=24,ballsize=41
			,margin=45,marginTop=25,SPtextX=378,textX=108,textY=54;
	static final int bSL638=1;
	static final int bL649=2;
	static final int bL740=3;
	static final int bDC=4;
	static final int btD=5;
	static final int bfD=6;
    JMenu ChoiceGame,HowToPlay,FrameSize;//選單項目
	JButton start = new JButton(new ImageIcon(fs));//新增再跑按鈕
	JMenuItem SL638,L649,L740,DC,tD,fD,HowPlay,Maker,Original,Ox2,Ox3;//選單選項
	JLabel jbl[]=new JLabel[3];//新增一個放圖,二個放字的Label
	ImageIcon icon[]=new ImageIcon[7];//新增放圖陣列(7張)
	
	public Lottery(){
		ChoiceGame = new JMenu("選擇玩法");
		FrameSize = new JMenu("整體大小");
		HowToPlay = new JMenu("說明");
		SL638 = new JMenuItem("威力彩",KeyEvent.VK_1);
	    L649 = new JMenuItem("大樂透",KeyEvent.VK_2);
	    L740 = new JMenuItem("大福彩",KeyEvent.VK_3);
	    DC = new JMenuItem("今彩539",KeyEvent.VK_4);
	    tD = new JMenuItem("3星彩",KeyEvent.VK_5);
	    fD = new JMenuItem("4星彩",KeyEvent.VK_6);
	    HowPlay = new JMenuItem("玩法");
	    Maker = new JMenuItem("作者");
	    Original = new JMenuItem("原始");
	    Ox2 = new JMenuItem("ｘ２");
	    Ox3 = new JMenuItem("ｘ３");
	    ChoiceGame.add(SL638);//38選6+8選1(SL638,green,red,1,7,12)
	    ChoiceGame.add(L649);//49選6(L649,yellow,red,2,8,12)
	    ChoiceGame.add(L740);//40選7(L740,watermelon,3,9)
	    ChoiceGame.add(DC);//39選5(DC,lemon,4,10)
	    ChoiceGame.add(tD);//(0~9選1)*3(tD,purple,5,11)
	    ChoiceGame.add(fD);//選(0~9選1)*4(fD,purple,6,11)
	    HowToPlay.add(HowPlay);
	    HowToPlay.add(Maker);
	    FrameSize.add(Original);
	    FrameSize.add(Ox2);
	    FrameSize.add(Ox3);	    
	    menubar.add(ChoiceGame);
	    menubar.add(FrameSize);
	    menubar.add(HowToPlay);
		jbl[0]=new JLabel(icon[0]);//放圖進圖框
		jbl[0].setBounds(5,24,79,27);//設置圖框起始座標
		add(jbl[0]);//圖框new出來
		start.addActionListener(this);//設置"聽"說明按鈕
		start.setBounds(420,12,50,50);//設置跑按鈕大小與位置
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
		
		SL638.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	cls();
            	SL638();
            }
        });
	    L649.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	cls();
            	L649();
            }
        });
	    L740.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	cls();
            	L740();
            }
        });
	    DC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	cls();
            	DC();
            }
        });
	    tD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	cls();
            	tD();
            }
        });
	    fD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	cls();
            	fD();
            }
        });
	    HowPlay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JFrame HowToPlay = new HowToPlay();
            }
        });
	    Maker.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JFrame Maker = new Maker();
            }
        });
	    Original.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	width = 490;
            	height = 130;
            	balltext = 24;
            	ballsize = 41;
            	marginTop = 25;
            	margin = 45;
            	SPtextX = 378;
            	textX = 108;
            	textY = 54;
        		frame.setSize(width,height);//設置主視窗大小
        		frame.setLocationRelativeTo(null);//視窗置中
        		jbl[0].setBounds(5,24,79,27);//設置圖框起始座標
        		jbl[1].setBounds(100,0,270,30);
        		jbl[2].setBounds(370,0,45,30);
        		jbl[1].setFont(new Font("新細明體",1,12));
        		jbl[2].setFont(new Font("新細明體",1,12));
        		start.setBounds(420,12,50,50);
            }
        });
	    Ox2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	width = 810;
            	height = 184;
            	balltext = 36;
            	ballsize = 65;
            	marginTop = 50;
            	margin = 90;
            	SPtextX = 652;
            	textX = 112;
            	textY = 96;
        		frame.setSize(width,height);//設置主視窗大小
        		frame.setLocationRelativeTo(null);//視窗置中
        		jbl[0].setBounds(5,65,79,27);//設置圖框起始座標
        		jbl[1].setBounds(100,0,540,60);
        		jbl[2].setBounds(640,0,90,60);
        		jbl[1].setFont(new Font("新細明體",1,24));
        		jbl[2].setFont(new Font("新細明體",1,24));
        		start.setBounds(740,53,50,50);
            }
        });
	    Ox3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	width = 1130;
            	height = 238;
            	balltext = 48;
            	ballsize = 89;
            	marginTop = 75;
            	margin = 135;
            	SPtextX = 928;
            	textX = 118;
            	textY = 138;
        		frame.setSize(width,height);//設置主視窗大小
        		frame.setLocationRelativeTo(null);//視窗置中
        		jbl[0].setBounds(5,95,79,27);//設置圖框起始座標
        		jbl[1].setBounds(100,0,810,90);
        		jbl[2].setBounds(910,0,135,90);
        		jbl[1].setFont(new Font("新細明體",1,36));
        		jbl[2].setFont(new Font("新細明體",1,36));
        		start.setBounds(1060,83,50,50);
            }
        });
	}
	
	public void cls(){//清空註明圖框
		jbl[1].setText("");
		jbl[2].setText("");
		repaint();
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
		b=new Integer[6];
		for(i=0;SL638i.hasNext();i++){
			b[i]=(Integer) SL638i.next();			
		}
		Arrays.sort(b);
		for(i=0;i<6;i++){
			num[i]=b[i].toString();
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
		while (L649.size() < 7) {
			L649.add((int)(Math.random()*49+1));
		}
		Iterator L649i=L649.iterator();
		num=new String[6];
		b=new Integer[6];
		c=new Integer[7];
		for(i=0;L649i.hasNext();i++){
			c[i] = (Integer) L649i.next();
		}
		Integer L649b=c[6];
		for(i=0;i<6;i++){
			b[i] = c[i];
		}
		Arrays.sort(b);
		for(i=0;i<6;i++){
			num[i]=b[i].toString();
			if(num[i].length()==1)
				num[i]=" "+num[i];
		}
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
		b=new Integer[7];
		for(i=0;L740i.hasNext();i++){
			b[i] = (Integer) L740i.next();
		}
		Arrays.sort(b);
		for(i=0;i<7;i++){
			num[i]=b[i].toString();
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
		b=new Integer[5];
		for(i=0;DCi.hasNext();i++){
			b[i] = (Integer) DCi.next();
		}
		Arrays.sort(b);
		for(i=0;i<5;i++){
			num[i]=b[i].toString();
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

	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==start){//按"發"重跑
			repaint();
			runcase();
		}	
	}
	
	public void keyTyped(KeyEvent e) {
//		key = e.getKeyChar();
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
		g.setFont(new Font(null, Font.BOLD, balltext));//設置字體
		switch(box){//判斷跑哪一組
		  case bSL638:
			g.setColor(new Color(160,231,22));//威力彩綠色
			for(i=0;i<6;i++){
				g.fillOval(100+margin*i,marginTop,ballsize,ballsize);//畫彩球
			}
			g.setColor(new Color(226,0,16));//紅色
			g.fillOval(100+margin*6,marginTop,ballsize,ballsize);//畫彩球
			g.setColor(Color.BLACK);//黑色(for字)
			for(i=0;i<6;i++){
				g.drawString(num[i],textX+margin*i,textY);//秀獎號
			}
			g.setColor(Color.WHITE);//白色(for字)
			g.drawString(SL638s,SPtextX,textY);//秀二區獎號
			break;
		  case bL649:
			g.setColor(new Color(255,191,17));//大樂透黃色
			for(i=0;i<6;i++){
				g.fillOval(100+margin*i,marginTop,ballsize,ballsize);//畫彩球
			}
			g.setColor(new Color(226,0,16));//紅色
			g.fillOval(100+margin*6,marginTop,ballsize,ballsize);//畫彩球
			g.setColor(Color.BLACK);//黑色(for字)
			for(i=0;i<6;i++){
				g.drawString(num[i],textX+margin*i,textY);//秀獎號
			}
			g.setColor(Color.WHITE);//白色(for字)
			g.drawString(L649s,SPtextX,textY);//秀特別號
			break;
		  case bL740:
			g.setColor(new Color(251,94,112));//大福彩淡紅色
			for(i=0;i<7;i++){
				g.fillOval(100+margin*i,marginTop,ballsize,ballsize);//畫彩球
			}
			g.setColor(Color.BLACK);//黑色(for字)
			for(i=0;i<7;i++){
				g.drawString(num[i],textX+margin*i,textY);//秀獎號
			}
		    break;
		  case bDC:
			g.setColor(new Color(255,240,2));//今彩539黃色
			for(i=0;i<5;i++){
				g.fillOval(100+margin*i,marginTop,ballsize,ballsize);//畫彩球
			}
			g.setColor(Color.BLACK);//黑色(for字)
			for(i=0;i<5;i++){
				g.drawString(num[i],textX+margin*i,textY);//秀獎號
			}
			break;
		  case btD:
			g.setColor(new Color(230,164,255));//星彩紫色
			for(i=0;i<3;i++){
				g.fillOval(100+margin*i,marginTop,ballsize,ballsize);//畫彩球
			}
			g.setColor(Color.BLACK);//黑色(for字)
			for(i=0;i<3;i++){
				g.drawString(num[i],textX+margin*i,textY);//秀獎號
			}
			break;
		  case bfD:
			g.setColor(new Color(230,164,255));//星彩紫色
			for(i=0;i<4;i++){
				g.fillOval(100+margin*i,marginTop,ballsize,ballsize);//畫彩球
			}
			g.setColor(Color.BLACK);//黑色(for字)
			for(i=0;i<4;i++){
				g.drawString(num[i],textX+margin*i,textY);//秀獎號
			}
			break;
		  case 7:
			g.clearRect(100,25,315,41);
		}
	}
	public static void main(String[] args) {
		frame.addWindowListener(new AdapterDemo());//設置程式關閉按鈕
		frame.setJMenuBar(menubar);
		frame.getContentPane().add(new Lottery());//把樂透Panel放進Frame
		frame.setSize(width,height);//設置主視窗大小
		frame.setResizable(false);//不可縮放視窗
		frame.setLocationRelativeTo(null);//視窗置中
		frame.setIconImage(new ImageIcon(fs).getImage());//重置視窗圖示
		frame.setVisible(true);//可見主視窗
	}
}
class AdapterDemo extends WindowAdapter {//結束程式的方法
	public void windowClosing(WindowEvent e) {
		System.exit(0);		
	}
}