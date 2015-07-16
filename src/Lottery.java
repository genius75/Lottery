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
	JButton how = new JButton("���k");//�s�W�������s
	static URL fs= Lottery.class.getResource("/images/lottery.png");	
	JButton start = new JButton(new ImageIcon(fs));//�s�W�A�]���s
	JLabel jbl[]=new JLabel[3];//�s�W�@�ө��,�G�ө�r��Label
	ImageIcon icon[]=new ImageIcon[7];//�s�W��ϰ}�C(7�i)
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
		Choice choice = new Choice();//�s�W�U�Ԧ����
		choice.addItemListener(this);//�]�m"ť"�ﶵ
		choice.add("�w�п�ܢw");//���ܿﶵ
		choice.add("�¤O�m");//38��6+8��1(SL638,green,red,1,7,12)
		choice.add("�j�ֳz");//49��6(L649,yellow,red,2,8,12)
		choice.add("�j�ֱm");//40��7(L740,watermelon,3,9)
		choice.add("���m539");//39��5(DC,lemon,4,10)
		choice.add("3�P�m");//(0~9��1)*3(tD,purple,5,11)
		choice.add("4�P�m");//��(0~9��1)*4(fD,purple,6,11)
		choice.setBounds(5,45,85,20);//�]�m����m
		add(choice);//show�X�U�Ԧ����
		jbl[0]=new JLabel(icon[0]);//��϶i�Ϯ�
		jbl[0].setBounds(5,10,79,27);//�]�m�Ϯذ_�l�y��
		add(jbl[0]);//�Ϯ�new�X��
		how.addActionListener(this);//�]�m"ť"�������s
		how.setBounds(415,2,60,20);//�]�m�������s�j�p�P��m
		how.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(how);//show�X�������s
		start.addActionListener(this);//�]�m"ť"�������s
		start.setBounds(420,23,50,50);//�]�m�������s�j�p�P��m
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
	}
	public void cls(){//�M�ŵ����Ϯ�
		jbl[1].setText("");
		jbl[2].setText("");
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
		for(i=0;SL638i.hasNext();i++){
			Integer integer = (Integer) SL638i.next();
			num[i]=integer.toString();
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
		for(i=0;L740i.hasNext();i++){
			Integer integer = (Integer) L740i.next();
			num[i]=integer.toString();
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
		for(i=0;DCi.hasNext();i++){
			Integer integer = (Integer) DCi.next();
			num[i]=integer.toString();
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
	public void itemStateChanged(ItemEvent e) {//�U�Ԧ����
		cls();
		repaint();
		Choice c = (Choice) e.getSource();
		if (c.getSelectedItem() == "�¤O�m") SL638();
		if (c.getSelectedItem() == "�j�ֳz") L649();
		if (c.getSelectedItem() == "�j�ֱm") L740();
		if (c.getSelectedItem() == "���m539") DC();
		if (c.getSelectedItem() == "3�P�m") tD();
		if (c.getSelectedItem() == "4�P�m") fD();
		if (c.getSelectedItem() == "�w�п�ܢw") none();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "���k") {
			JFrame HowToPlay=new HowToPlay();			
		}
		if (e.getSource()==start){//��"�o"���]
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

	public void paintComponent(Graphics g) {//�e��
		super.paintComponent(g);
		g.setFont(new Font(null, Font.BOLD, 24));//�]�m�r��
		switch(box){//�P�_�]���@��
		  case bSL638:
			g.setColor(new Color(160,231,22));//�¤O�m���
			for(i=0;i<6;i++){
				g.fillOval(100+45*i,25,41,41);//�e�m�y
			}
			g.setColor(new Color(226,0,16));//����
			g.fillOval(100+45*6,25,41,41);//�e�m�y
			g.setColor(Color.BLACK);//�¦�(for�r)
			for(i=0;i<6;i++){
				g.drawString(num[i],107+45*i,53);//�q����
			}
			g.setColor(Color.WHITE);//�զ�(for�r)
			g.drawString(SL638s,377,53);//�q�G�ϼ���
			break;
		  case bL649:
			g.setColor(new Color(255,191,17));//�j�ֳz����
			for(i=0;i<6;i++){
				g.fillOval(100+45*i,25,41,41);//�e�m�y
			}
			g.setColor(new Color(226,0,16));//����
			g.fillOval(100+45*6,25,41,41);//�e�m�y
			g.setColor(Color.BLACK);//�¦�(for�r)
			for(i=0;i<6;i++){
				g.drawString(num[i],107+45*i,53);//�q����
			}
			g.setColor(Color.WHITE);//�զ�(for�r)
			g.drawString(L649s,377,53);//�q�S�O��
			break;
		  case bL740:
			g.setColor(new Color(251,94,112));//�j�ֱm�H����
			for(i=0;i<7;i++){
				g.fillOval(100+45*i,25,41,41);//�e�m�y
			}
			g.setColor(Color.BLACK);//�¦�(for�r)
			for(i=0;i<7;i++){
				g.drawString(num[i],107+45*i,53);//�q����
			}
		    break;
		  case bDC:
			g.setColor(new Color(255,240,2));//���m539����
			for(i=0;i<5;i++){
				g.fillOval(100+45*i,25,41,41);//�e�m�y
			}
			g.setColor(Color.BLACK);//�¦�(for�r)
			for(i=0;i<5;i++){
				g.drawString(num[i],107+45*i,53);//�q����
			}
			break;
		  case btD:
			g.setColor(new Color(230,164,255));//�P�m����
			for(i=0;i<3;i++){
				g.fillOval(100+45*i,25,41,41);//�e�m�y
			}
			g.setColor(Color.BLACK);//�¦�(for�r)
			for(i=0;i<3;i++){
				g.drawString(num[i],107+45*i,53);//�q����
			}
			break;
		  case bfD:
			g.setColor(new Color(230,164,255));//�P�m����
			for(i=0;i<4;i++){
				g.fillOval(100+45*i,25,41,41);//�e�m�y
			}
			g.setColor(Color.BLACK);//�¦�(for�r)
			for(i=0;i<4;i++){
				g.drawString(num[i],107+45*i,53);//�q����
			}
			break;
		  case 7:
			g.clearRect(100,25,315,41);
		}
	}
	public static void main(String[] args) {		
		Lottery gogo=new Lottery();
		JFrame frame = new JFrame("�x�W�m��-�q���︹");//�]�m�{�����D
		frame.addWindowListener(new AdapterDemo());//�]�m�{���������s
		frame.getContentPane().add(gogo);//��ֳzPanel��iFrame
		frame.setSize(490,100);//�]�m�D�����j�p
		frame.setResizable(false);//���i�Y�����
		frame.setLocationRelativeTo(null);//�����m��
		frame.setIconImage(new ImageIcon(fs).getImage());//���m�����ϥ�
		frame.setVisible(true);//�i���D����
		gogo.requestFocusInWindow();
	}
}
class AdapterDemo extends WindowAdapter {//�����{������k
	public void windowClosing(WindowEvent e) {
		System.exit(0);		
	}
}