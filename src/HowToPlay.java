import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HowToPlay extends JFrame {

	Color cSL638,cL649,cL740,cDC,ctfD;
	JPanel pan;
	JButton SL638,L649,L740,DC,tD,fD;
	GridBagConstraints c1,c2,c3,c4,c5,c6;

	public HowToPlay() {
		this.setTitle("�x�W�m��-���k����");
		this.setSize(188,138);
		this.setLocationRelativeTo(null);//�����m��(�ù�)
		this.setResizable(false);//���i�Y�����
		cSL638 = new Color(160,231,22);//�¤O�m���
		cL649 = new Color(255,191,17);//�j�ֳz����
		cL740 = new Color(251,94,112);//�j�ֱm�H����
		cDC = new Color(255,240,2);//���m539����
		ctfD = new Color(230,164,255);//�P�m����
		pan = new JPanel();
		pan.setLayout(new GridBagLayout());//�]�w����l��������
		c1 = new GridBagConstraints();
		c2 = new GridBagConstraints();
		c3 = new GridBagConstraints();
		c4 = new GridBagConstraints();
		c5 = new GridBagConstraints();
		c6 = new GridBagConstraints();
		
		c1.gridx = 0;
		c1.gridy = 0;
		c1.gridwidth = 1;
		c1.gridheight = 1;
		c1.insets = new Insets(3,3,3,3);
		c2.gridx = 1;
		c2.gridy = 0;
		c2.gridwidth = 1;
		c2.gridheight = 1;
		c2.insets = new Insets(3,3,3,3);
		c3.gridx = 0;
		c3.gridy = 1;
		c3.gridwidth = 1;
		c3.gridheight = 1;
		c3.insets = new Insets(3,3,3,3);
		c4.gridx = 1;
		c4.gridy = 1;
		c4.gridwidth = 1;
		c4.gridheight = 1;
		c4.insets = new Insets(3,3,3,3);
		c5.gridx = 0;
		c5.gridy = 2;
		c5.gridwidth = 1;
		c5.gridheight = 1;
		c5.insets = new Insets(3,3,3,3);
		c6.gridx = 1;
		c6.gridy = 2;
		c6.gridwidth = 1;
		c6.gridheight = 1;
		c6.insets = new Insets(3,3,3,3);
		
		SL638 = new JButton(" �� �O �m");
		SL638.setBackground(cSL638);//�]�m�I����
		SL638.setCursor(new Cursor(Cursor.HAND_CURSOR));//�X�{�p��
		pan.add(SL638,c1);
		goWebsite(SL638);
		
		L649 = new JButton("�j �� �z ");
		L649.setBackground(cL649);//�]�m�I����
		L649.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pan.add(L649,c2);
		goWebsite(L649);
		
		L740 = new JButton(" �j �� �m");
		L740.setBackground(cL740);//�]�m�I����
		L740.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pan.add(L740,c3);
		goWebsite(L740);
		
		DC = new JButton("���m539");
		DC.setBackground(cDC);//�]�m�I����
		DC.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pan.add(DC,c4);
		goWebsite(DC);
		
		tD = new JButton(" �� �P �m");
		tD.setBackground(ctfD);//�]�m�I����
		tD.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pan.add(tD,c5);
		goWebsite(tD);
		
		fD = new JButton("�� �P �m ");
		fD.setBackground(ctfD);//�]�m�I����
		fD.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pan.add(fD,c6);
		goWebsite(fD);
		
		this.setContentPane(pan);
		this.setVisible(true);
	}

	private void goWebsite(JButton website) {
		website.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (e.getSource()==SL638)
						Desktop.getDesktop().browse(new URI("http://www.taiwanlottery.com.tw/SuperLotto638/index.asp"));
					if (e.getSource()==L649)
						Desktop.getDesktop().browse(new URI("http://www.taiwanlottery.com.tw/Lotto649/index.asp"));
					if (e.getSource()==L740)
						Desktop.getDesktop().browse(new URI("http://www.taiwanlottery.com.tw/Lotto740/index.asp"));
					if (e.getSource()==DC)
						Desktop.getDesktop().browse(new URI("http://www.taiwanlottery.com.tw/DailyCash/index.asp"));
					if (e.getSource()==tD)
						Desktop.getDesktop().browse(new URI("http://www.taiwanlottery.com.tw/3D/index.asp"));
					if (e.getSource()==fD)
						Desktop.getDesktop().browse(new URI("http://www.taiwanlottery.com.tw/4D/index.asp"));
				} catch (URISyntaxException | IOException ex) {
					// It looks like there's a problem
				}
			}
		});
	}
}