import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HowToPlay extends JFrame {
	private JPanel pan;
	private JLabel SL638,L649,L740,DC,tD,fD,fb,google,date;

	public HowToPlay() {
		this.setTitle("台灣彩卷-玩法說明");
		this.setSize(410,200);
		this.setLocationRelativeTo(null);//視窗置中(螢幕)
		pan = new JPanel();
		
		SL638 = new JLabel();
		SL638.setText("<html>威力彩：<a href=\"\">http://www.taiwanlottery.com.tw/SuperLotto638/index.asp</a></html>");
		SL638.setCursor(new Cursor(Cursor.HAND_CURSOR));//出現小手
		pan.add(SL638);
		goWebsite(SL638);
		
		L649 = new JLabel();
		L649.setText("<html>大樂透：<a href=\"\">http://www.taiwanlottery.com.tw/Lotto649/index.asp</a></html>");
		L649.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pan.add(L649);
		goWebsite(L649);
		
		L740 = new JLabel();
		L740.setText("<html>大福彩：<a href=\"\">http://www.taiwanlottery.com.tw/Lotto740/index.asp</a></html>");
		L740.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pan.add(L740);
		goWebsite(L740);
		
		DC = new JLabel();
		DC.setText("<html>今彩539：<a href=\"\">http://www.taiwanlottery.com.tw/DailyCash/index.asp</a></html>");
		DC.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pan.add(DC);
		goWebsite(DC);
		
		tD = new JLabel();
		tD.setText("<html>3星彩：<a href=\"\">http://www.taiwanlottery.com.tw/3D/index.asp</a></html>");
		tD.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pan.add(tD);
		goWebsite(tD);
		
		fD = new JLabel();
		fD.setText("<html>4星彩：<a href=\"\">http://www.taiwanlottery.com.tw/4D/index.asp</a></html>");
		fD.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pan.add(fD);
		goWebsite(fD);
		
		fb = new JLabel();
		fb.setText("作者：facebook");
		fb.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pan.add(fb);
		goWebsite(fb);
		
		google = new JLabel();
		google.setText("、google+");
		google.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pan.add(google);
		goWebsite(google);
		
		date=new JLabel();
		date.setText("　　發佈日期：2015.7.24");
		pan.add(date);
		
		this.setContentPane(pan);
		this.setVisible(true);
	}

	private void goWebsite(JLabel website) {
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
					if (e.getSource()==fb)
						Desktop.getDesktop().browse(new URI("https://www.facebook.com/ronald75"));
					if (e.getSource()==google)
						Desktop.getDesktop().browse(new URI("https://plus.google.com/110843310450228274881/posts"));
				} catch (URISyntaxException | IOException ex) {
					// It looks like there's a problem
				}
			}
		});
	}
}