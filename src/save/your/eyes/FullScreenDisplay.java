package save.your.eyes;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.DisplayMode;
import java.awt.FlowLayout;
import java.awt.GraphicsDevice;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FullScreenDisplay extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GraphicsDevice device;
	private DisplayMode originalDM;
	private JButton exit = new JButton("Exit");
	private boolean isFullScreen = false;

	public FullScreenDisplay(GraphicsDevice device) {
		super(device.getDefaultConfiguration());
		this.device = device;
		setTitle("Display Mode Test");
		originalDM = device.getDisplayMode();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Make sure a DM is always selected in the list
		exit.addActionListener(this);
	}
	
	public void closeComponent(){
		device.setFullScreenWindow(null);
	}
	
	public void initComponents(Container c) {
		setContentPane(c);
		c.setLayout(new BorderLayout());
		// Current DM
		JPanel currentPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		c.add(currentPanel, BorderLayout.NORTH);
		JLabel current = new JLabel("Current Display Mode : ");
		currentPanel.add(current);
		
		// Exit
		JPanel modesPanel = new JPanel(new GridLayout(1, 2));
		c.add(modesPanel, BorderLayout.CENTER);
		JPanel controlsPanelA = new JPanel(new BorderLayout());
		modesPanel.add(controlsPanelA);
		JPanel controlsPanelB = new JPanel(new GridLayout(2, 1));
		controlsPanelA.add(controlsPanelB, BorderLayout.NORTH);
		JPanel exitPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		controlsPanelB.add(exitPanel);
		exitPanel.add(exit);
		
	}
	public void begin() {
		isFullScreen = device.isFullScreenSupported();
		setUndecorated(isFullScreen);
		setResizable(!isFullScreen);
		if (isFullScreen) {
			// Full-screen mode
			device.setFullScreenWindow(this);
			validate();
		} else {
			// Windowed mode
			pack();
			setVisible(true);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		Object source = ev.getSource();
		if (source == exit) {
			device.setDisplayMode(originalDM);
			System.exit(0);
		}
	}
	
	

}
