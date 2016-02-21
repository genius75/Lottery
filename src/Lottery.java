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
	
	static JFrame frame = new JFrame("�x�W�m��-�q���︹�p�{��v1.3.1");//�]�m�{�����D
    static JMenuBar menubar = new JMenuBar();//�s�W���C
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
    JMenu ChoiceGame,HowToPlay,FrameSize;//��涵��
	JButton start = new JButton(new ImageIcon(fs));//�s�W�A�]���s
	JMenuItem SL638,L649,L740,DC,tD,fD,HowPlay,Maker,Original,Ox2,Ox3;//���ﶵ
	JLabel jbl[]=new JLabel[3];//�s�W�@�ө��,�G�ө�r��Label
	ImageIcon icon[]=new ImageIcon[7];//�s�W��ϰ}�C(7�i)
	
	public Lottery(){
		ChoiceGame = new JMenu("��ܪ��k");
		FrameSize = new JMenu("����j�p");
		HowToPlay = new JMenu("����");
		SL638 = new JMenuItem("�¤O�m",KeyEvent.VK_1);
	    L649 = new JMenuItem("�j�ֳz",KeyEvent.VK_2);
	    L740 = new JMenuItem("�j�ֱm",KeyEvent.VK_3);
	    DC = new JMenuItem("���m539",KeyEvent.VK_4);
	    tD = new JMenuItem("3�P�m",KeyEvent.VK_5);
	    fD = new JMenuItem("4�P�m",KeyEvent.VK_6);
	    HowPlay = new JMenuItem("���k");
	    Maker = new JMenuItem("�@��");
	    Original = new JMenuItem("��l");
	    Ox2 = new JMenuItem("�A��");
	    Ox3 = new JMenuItem("�A��");
	    ChoiceGame.add(SL638);//38��6+8��1(SL638,green,red,1,7,12)
	    ChoiceGame.add(L649);//49��6(L649,yellow,red,2,8,12)
	    ChoiceGame.add(L740);//40��7(L740,watermelon,3,9)
	    ChoiceGame.add(DC);//39��5(DC,lemon,4,10)
	    ChoiceGame.add(tD);//(0~9��1)*3(tD,purple,5,11)
	    ChoiceGame.add(fD);//��(0~9��1)*4(fD,purple,6,11)
	    HowToPlay.add(HowPlay);
	    HowToPlay.add(Maker);
	    FrameSize.add(Original);
	    FrameSize.add(Ox2);
	    FrameSize.add(Ox3);	    
	    menubar.add(ChoiceGame);
	    menubar.add(FrameSize);
	    menubar.add(HowToPlay);
		jbl[0]=new JLabel(icon[0]);//��϶i�Ϯ�
		jbl[0].setBounds(5,24,79,27);//�]�m�Ϯذ_�l�y��
		add(jbl[0]);//�Ϯ�new�X��
		start.addActionListener(this);//�]�m"ť"�������s
		start.setBounds(420,12,50,50);//�]�m�]���s�j�p�P��m
		start.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(start);//show�X�A�]���s		
		jbl[1]=new JLabel();//���J�����Ϯ�
		jbl[1].setBounds(100,0,270,30);//�]�m�Ϯئ�m
		add(jbl[1]);//new�X�Ϯ�
		jbl[2]=new JLabel();//���J�����Ϯ�
		jbl[2].setBounds(370,0,45,30);//�]�m�Ϯئ�m
		add(jbl[2]);//new�X�Ϯ�
		for(i=0;i<=6;i++){
			icon[i]=new ImageIcon(Lottery.class.getResource("/images/i"+i+".gif"));//���J7�i��
		}
		jbl[0].setIcon(icon[0]);//�ﶵ�p��
		
		setLayout(null);//���ϥιw�]��X�覡
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
        		frame.setSize(width,height);//�]�m�D�����j�p
        		frame.setLocationRelativeTo(null);//�����m��
        		jbl[0].setBounds(5,24,79,27);//�]�m�Ϯذ_�l�y��
        		jbl[1].setBounds(100,0,270,30);
        		jbl[2].setBounds(370,0,45,30);
        		jbl[1].setFont(new Font("�s�ө���",1,12));
        		jbl[2].setFont(new Font("�s�ө���",1,12));
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
        		frame.setSize(width,height);//�]�m�D�����j�p
        		frame.setLocationRelativeTo(null);//�����m��
        		jbl[0].setBounds(5,65,79,27);//�]�m�Ϯذ_�l�y��
        		jbl[1].setBounds(100,0,540,60);
        		jbl[2].setBounds(640,0,90,60);
        		jbl[1].setFont(new Font("�s�ө���",1,24));
        		jbl[2].setFont(new Font("�s�ө���",1,24));
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
        		frame.setSize(width,height);//�]�m�D�����j�p
        		frame.setLocationRelativeTo(null);//�����m��
        		jbl[0].setBounds(5,95,79,27);//�]�m�Ϯذ_�l�y��
        		jbl[1].setBounds(100,0,810,90);
        		jbl[2].setBounds(910,0,135,90);
        		jbl[1].setFont(new Font("�s�ө���",1,36));
        		jbl[2].setFont(new Font("�s�ө���",1,36));
        		start.setBounds(1060,83,50,50);
            }
        });
	}
	
	public void cls(){//�M�ŵ����Ϯ�
		jbl[1].setText("");
		jbl[2].setText("");
		repaint();
	}
	public void SL638(){
		box=1;
		jbl[0].setIcon(icon[1]);//�ﶵ�p��
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
		jbl[1].setText("�z�w�w�w�w�w�w�w�w �@�� �w�w�w�w�w�w�w�w�{");
		jbl[2].setText(" �G ��");
	}
	public void L649(){
		box=2;
		jbl[0].setIcon(icon[2]);//�ﶵ�p��
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
		jbl[2].setText("�S�O��");		
	}
	public void L740(){
		box=3;
		jbl[0].setIcon(icon[3]);//�ﶵ�p��
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
		jbl[0].setIcon(icon[4]);//�ﶵ�p��
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
		jbl[0].setIcon(icon[5]);//�ﶵ�p��
		b=new Integer[3];
		num=new String[3];
		for(i=0;i<3;i++){
			b[i]=(int)(Math.random()*10);
			num[i]=" "+b[i].toString();
		}
	}
	public void fD(){
		box=6;
		jbl[0].setIcon(icon[6]);//�ﶵ�p��
		b=new Integer[4];
		num=new String[4];
		for(i=0;i<4;i++){
			b[i]=(int)(Math.random()*10);
			num[i]=" "+b[i].toString();
		}
	}
	public void none(){
		box=7;
		jbl[0].setIcon(icon[0]);//�ﶵ�p��;
	}
	public void runcase(){
		switch(box){//�P�_�]���@��
		  case bSL638:SL638();break;
		  case bL649:L649();break;
		  case bL740:L740();break;
		  case bDC:DC();break;
		  case btD:tD();break;
		  case bfD:fD();break;
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==start){//��"�o"���]
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
	
	public void paintComponent(Graphics g) {//�e��
		super.paintComponent(g);
		g.setFont(new Font(null, Font.BOLD, balltext));//�]�m�r��
		switch(box){//�P�_�]���@��
		  case bSL638:
			g.setColor(new Color(160,231,22));//�¤O�m���
			for(i=0;i<6;i++){
				g.fillOval(100+margin*i,marginTop,ballsize,ballsize);//�e�m�y
			}
			g.setColor(new Color(226,0,16));//����
			g.fillOval(100+margin*6,marginTop,ballsize,ballsize);//�e�m�y
			g.setColor(Color.BLACK);//�¦�(for�r)
			for(i=0;i<6;i++){
				g.drawString(num[i],textX+margin*i,textY);//�q����
			}
			g.setColor(Color.WHITE);//�զ�(for�r)
			g.drawString(SL638s,SPtextX,textY);//�q�G�ϼ���
			break;
		  case bL649:
			g.setColor(new Color(255,191,17));//�j�ֳz����
			for(i=0;i<6;i++){
				g.fillOval(100+margin*i,marginTop,ballsize,ballsize);//�e�m�y
			}
			g.setColor(new Color(226,0,16));//����
			g.fillOval(100+margin*6,marginTop,ballsize,ballsize);//�e�m�y
			g.setColor(Color.BLACK);//�¦�(for�r)
			for(i=0;i<6;i++){
				g.drawString(num[i],textX+margin*i,textY);//�q����
			}
			g.setColor(Color.WHITE);//�զ�(for�r)
			g.drawString(L649s,SPtextX,textY);//�q�S�O��
			break;
		  case bL740:
			g.setColor(new Color(251,94,112));//�j�ֱm�H����
			for(i=0;i<7;i++){
				g.fillOval(100+margin*i,marginTop,ballsize,ballsize);//�e�m�y
			}
			g.setColor(Color.BLACK);//�¦�(for�r)
			for(i=0;i<7;i++){
				g.drawString(num[i],textX+margin*i,textY);//�q����
			}
		    break;
		  case bDC:
			g.setColor(new Color(255,240,2));//���m539����
			for(i=0;i<5;i++){
				g.fillOval(100+margin*i,marginTop,ballsize,ballsize);//�e�m�y
			}
			g.setColor(Color.BLACK);//�¦�(for�r)
			for(i=0;i<5;i++){
				g.drawString(num[i],textX+margin*i,textY);//�q����
			}
			break;
		  case btD:
			g.setColor(new Color(230,164,255));//�P�m����
			for(i=0;i<3;i++){
				g.fillOval(100+margin*i,marginTop,ballsize,ballsize);//�e�m�y
			}
			g.setColor(Color.BLACK);//�¦�(for�r)
			for(i=0;i<3;i++){
				g.drawString(num[i],textX+margin*i,textY);//�q����
			}
			break;
		  case bfD:
			g.setColor(new Color(230,164,255));//�P�m����
			for(i=0;i<4;i++){
				g.fillOval(100+margin*i,marginTop,ballsize,ballsize);//�e�m�y
			}
			g.setColor(Color.BLACK);//�¦�(for�r)
			for(i=0;i<4;i++){
				g.drawString(num[i],textX+margin*i,textY);//�q����
			}
			break;
		  case 7:
			g.clearRect(100,25,315,41);
		}
	}
	public static void main(String[] args) {
		frame.addWindowListener(new AdapterDemo());//�]�m�{���������s
		frame.setJMenuBar(menubar);
		frame.getContentPane().add(new Lottery());//��ֳzPanel��iFrame
		frame.setSize(width,height);//�]�m�D�����j�p
		frame.setResizable(false);//���i�Y�����
		frame.setLocationRelativeTo(null);//�����m��
		frame.setIconImage(new ImageIcon(fs).getImage());//���m�����ϥ�
		frame.setVisible(true);//�i���D����
	}
}
class AdapterDemo extends WindowAdapter {//�����{������k
	public void windowClosing(WindowEvent e) {
		System.exit(0);		
	}
}