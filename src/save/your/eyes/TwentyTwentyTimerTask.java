package save.your.eyes;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.TimerTask;


public class TwentyTwentyTimerTask extends TimerTask{
	
	//private final GraphicsDevice graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	//private final FullScreenDisplay fullScreenDisplay = new FullScreenDisplay(graphicsDevice);
	
	@Override
	public void run() {
		unitOfTask(20);
	}
	
	private void unitOfTask(long delayPeriodInSeconds) {
		GraphicsDevice graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		FullScreenDisplay fullScreenDisplay = new FullScreenDisplay(graphicsDevice);
		fullScreenDisplay.initComponents(fullScreenDisplay.getContentPane());
		fullScreenDisplay.begin();
		try {
			Thread.sleep(delayPeriodInSeconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		fullScreenDisplay.closeComponent();
		fullScreenDisplay = null;
		graphicsDevice = null;
	}
	

}
