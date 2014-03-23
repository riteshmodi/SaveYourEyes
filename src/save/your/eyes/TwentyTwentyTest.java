package save.your.eyes;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TwentyTwentyTest {
	private static final ScheduledExecutorService scheduler =  Executors.newScheduledThreadPool(1);
	//private static final TimerTask timerTask = new TwentyTwentyTimerTask();

	public static void main(String[] args) {
		TimerTask timerTask = new TwentyTwentyTimerTask();
		scheduler.scheduleAtFixedRate(timerTask, 0, 25, TimeUnit.MINUTES);
        System.out.println("TimerTask started");
	}

}
