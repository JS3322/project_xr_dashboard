package kr.cleancode.dashboard.manager.util;

public class ThreadSleep {

	public static final void sleep(final int milliSecond){
		try {
			Thread.sleep(milliSecond);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
	}
}
