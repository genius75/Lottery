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
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Maker extends JFrame {

	Color c;
	JPanel pan;
	JLabel maker,date;
	JButton fb,google;
	GridBagConstraints c1,c2,c3,c4;
	static URL fbpng= Lottery.class.getResource("/images/fb.png");
	static URL googlepng= Lottery.class.getResource("/images/google.png");
	
	public Maker(){
		this.setTitle("info");
		this.setSize(160,110);
		this.setLocationRelativeTo(null);//視窗置中(螢幕)
		this.setResizable(false);//不可縮放視窗
		c = new Color(0,0,255);//背影顏色隨便設任意值,只起占位作用
		pan = new JPanel();
		pan.setLayout(new GridBagLayout());//設定為格子式的版面
		c1 = new GridBagConstraints();
		c2 = new GridBagConstraints();
		c3 = new GridBagConstraints();
		c4 = new GridBagConstraints();
		
		c1.gridx = 0;
		c1.gridy = 0;
		c1.gridwidth = 1;
		c1.gridheight = 1;
		c1.insets = new Insets(8,0,1,1);
		c2.gridx = 1;
		c2.gridy = 0;
		c2.gridwidth = 1;
		c2.gridheight = 1;
		c2.insets = new Insets(8,0,1,1);
		c3.gridx = 2;
		c3.gridy = 0;
		c3.gridwidth = 1;
		c3.gridheight = 1;
		c3.insets = new Insets(8,0,1,1);
		c4.gridx = 0;
		c4.gridy = 1;
		c4.gridwidth = 3;
		c4.gridheight = 1;
		c4.insets = new Insets(3,1,1,1);
		
		maker = new JLabel();
		maker.setText("作者：");
		pan.add(maker,c1);
		
		fb = new JButton(new ImageIcon(fbpng));
		fb.setOpaque(false);//設置透明背影
		fb.setBackground(c);//必須設置否則不會出現透明背影
		fb.setBorder(BorderFactory.createEmptyBorder());//設置無邊框
		fb.setCursor(new Cursor(Cursor.HAND_CURSOR));
		goWebsite(fb);
		pan.add(fb,c2);

		google = new JButton(new ImageIcon(googlepng));
		google.setOpaque(false);//設置透明背影
		google.setBackground(c);//必須設置否則不會出現透明背影
		google.setBorder(BorderFactory.createEmptyBorder());//設置無邊框
		google.setCursor(new Cursor(Cursor.HAND_CURSOR));
		goWebsite(google);
		pan.add(google,c3);
		
		date=new JLabel();
		date.setText("發佈日期：2016.2.21");
		pan.add(date,c4);
		
		this.setContentPane(pan);
		this.setVisible(true);
	}
	
	private void goWebsite(JButton website) {
		website.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
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