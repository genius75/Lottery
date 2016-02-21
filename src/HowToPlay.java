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
		this.setTitle("台灣彩券-玩法說明");
		this.setSize(188,138);
		this.setLocationRelativeTo(null);//視窗置中(螢幕)
		this.setResizable(false);//不可縮放視窗
		cSL638 = new Color(160,231,22);//威力彩綠色
		cL649 = new Color(255,191,17);//大樂透黃色
		cL740 = new Color(251,94,112);//大福彩淡紅色
		cDC = new Color(255,240,2);//今彩539黃色
		ctfD = new Color(230,164,255);//星彩紫色
		pan = new JPanel();
		pan.setLayout(new GridBagLayout());//設定為格子式的版面
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
		
		SL638 = new JButton(" 威 力 彩");
		SL638.setBackground(cSL638);//設置背景色
		SL638.setCursor(new Cursor(Cursor.HAND_CURSOR));//出現小手
		pan.add(SL638,c1);
		goWebsite(SL638);
		
		L649 = new JButton("大 樂 透 ");
		L649.setBackground(cL649);//設置背景色
		L649.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pan.add(L649,c2);
		goWebsite(L649);
		
		L740 = new JButton(" 大 福 彩");
		L740.setBackground(cL740);//設置背景色
		L740.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pan.add(L740,c3);
		goWebsite(L740);
		
		DC = new JButton("今彩539");
		DC.setBackground(cDC);//設置背景色
		DC.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pan.add(DC,c4);
		goWebsite(DC);
		
		tD = new JButton(" ３ 星 彩");
		tD.setBackground(ctfD);//設置背景色
		tD.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pan.add(tD,c5);
		goWebsite(tD);
		
		fD = new JButton("４ 星 彩 ");
		fD.setBackground(ctfD);//設置背景色
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