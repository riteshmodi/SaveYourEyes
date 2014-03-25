package save.your.eyes;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TwentyTwentyTest {
	private static final ScheduledExecutorService scheduler =  Executors.newScheduledThreadPool(1);
	//private static final TimerTask timerTask = new TwentyTwentyTimerTask();

	public static void main(String[] args) {
		int timePeriodInMinutes = 25,initialDelay = 0;
		if(args.length>0){
			timePeriodInMinutes = Integer.parseInt(args[0]);
		}
		TimerTask timerTask = new TwentyTwentyTimerTask();
		scheduler.scheduleAtFixedRate(timerTask, initialDelay, timePeriodInMinutes, TimeUnit.MINUTES);
        	System.out.println("TimerTask started");
	}

}
