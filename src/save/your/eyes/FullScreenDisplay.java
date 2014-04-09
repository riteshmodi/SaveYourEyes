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
	private JButton out = new JButton("Out");
	private boolean isFullScreen = false;

	public FullScreenDisplay(GraphicsDevice device) {
		super(device.getDefaultConfiguration());
		this.device = device;
		setTitle("Display Mode Test");
		originalDM = device.getDisplayMode();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Make sure a DM is always selected in the list
		exit.addActionListener(this);
		out.addActionListener(this);
	}
	
	public void closeComponent(){
		device.setFullScreenWindow(null);
		dispose();
		//originalDM = null;
		//device = null;
	}
	
	public void initComponents(Container container) {
		setContentPane(container);
		
		container.setLayout(new BorderLayout());
		// Current DM
		JPanel topCommentPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		container.add(topCommentPanel, BorderLayout.NORTH);
		JLabel lookAwayComment = new JLabel("Please look at some target 20 feet away !! ");
		lookAwayComment.setFont(new Font("Serif", Font.BOLD, 50));
		topCommentPanel.add(lookAwayComment);
		
		// Exit
		JPanel modesPanel = new JPanel(new GridLayout(1, 2));
		container.add(modesPanel, BorderLayout.CENTER);
		
		JPanel exitPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		modesPanel.add(exitPanel);
		exitPanel.add(out);
		exitPanel.add(exit);
		
		JPanel bottomCommentPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		container.add(bottomCommentPanel, BorderLayout.PAGE_END);
		JLabel washEyesComment = new JLabel("Wash your Eyes !!");
		washEyesComment.setFont(new Font("Serif", Font.BOLD, 50));
		bottomCommentPanel.add(washEyesComment);
		
		
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
		if (source == out) {
			closeComponent();
		}
	}
	
	

}
