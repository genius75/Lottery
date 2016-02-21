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
		this.setLocationRelativeTo(null);//�����m��(�ù�)
		this.setResizable(false);//���i�Y�����
		c = new Color(0,0,255);//�I�v�C���H�K�]���N��,�u�_�e��@��
		pan = new JPanel();
		pan.setLayout(new GridBagLayout());//�]�w����l��������
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
		maker.setText("�@�̡G");
		pan.add(maker,c1);
		
		fb = new JButton(new ImageIcon(fbpng));
		fb.setOpaque(false);//�]�m�z���I�v
		fb.setBackground(c);//�����]�m�_�h���|�X�{�z���I�v
		fb.setBorder(BorderFactory.createEmptyBorder());//�]�m�L���
		fb.setCursor(new Cursor(Cursor.HAND_CURSOR));
		goWebsite(fb);
		pan.add(fb,c2);

		google = new JButton(new ImageIcon(googlepng));
		google.setOpaque(false);//�]�m�z���I�v
		google.setBackground(c);//�����]�m�_�h���|�X�{�z���I�v
		google.setBorder(BorderFactory.createEmptyBorder());//�]�m�L���
		google.setCursor(new Cursor(Cursor.HAND_CURSOR));
		goWebsite(google);
		pan.add(google,c3);
		
		date=new JLabel();
		date.setText("�o�G����G2016.2.21");
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