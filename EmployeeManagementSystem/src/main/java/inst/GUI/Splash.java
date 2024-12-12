package inst.GUI;
import java.awt.Image;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import inst.login.Login;

public class Splash extends JFrame {
	public Splash() {

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("inst/icons/front (1).gif"));
		
		
		Image i2 = i1.getImage().getScaledInstance(1170, 650, Image.SCALE_DEFAULT);

		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 1170, 650);
		add(image);

		setSize(1170, 650);
		setLayout(null);
		setLocation(200, 100);
		setVisible(true);

		try {
			Thread.sleep(5000);
			setVisible(false);
			new Login();
			} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
}
