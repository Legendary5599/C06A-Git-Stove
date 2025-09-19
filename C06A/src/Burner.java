/**
 * Burner class that is able to be switched between different settings which are defined in the setting
 * enumerated type: off, low, medium, and high. The temperature is updated to reflect what setting the burner is on
 * and the timer.
 * 
 * @author Samantha Murray
 * @author Ryan Clark
 * 
 * Date: 9/18/2025
 */
public class Burner {
	public enum Temperature {BLAZING, HOT, WARM, COLD};

	public static final int TIME_DURATION = 2;

	private Temperature myTemperature;
	private Setting mySetting;

	private int timer;

	public Burner() {
		myTemperature = Temperature.COLD;
		mySetting = Setting.OFF;
		timer = 0;
	}

	public void plusButton() {
		switch(mySetting) {
		case OFF:
			mySetting = Setting.LOW;
			break;

		case LOW:
			mySetting = Setting.MEDIUM;
			break;

		case MEDIUM:
			mySetting = Setting.HIGH;
			break;

		case HIGH:
			break;
		}
		timer = TIME_DURATION;
	}

	public void minusButton() {
		switch(mySetting) {
		case HIGH:
			mySetting = Setting.MEDIUM;
			break;

		case MEDIUM:
			mySetting = Setting.LOW;
			break;

		case LOW:
			mySetting = Setting.OFF;
			break;

		case OFF:
			break;
		}
		timer = TIME_DURATION;
	}

	public void updateTemperature() {
		if(timer > 0) {
			timer--;
		}
		switch(myTemperature) {
		case COLD:
			if(mySetting != Setting.OFF && timer == 0) {
				myTemperature = Temperature.WARM;
				if(mySetting != Setting.LOW) {
					timer = TIME_DURATION;
				}
			}
			break;
		case WARM:
			if((mySetting == Setting.MEDIUM || mySetting == Setting.HIGH) && timer == 0) {
				myTemperature = Temperature.HOT;
				if(mySetting == Setting.HIGH) {
					timer = TIME_DURATION;
				}
			}
			if(mySetting == Setting.OFF) {
				myTemperature = Temperature.COLD;
			}
			break;
		case HOT:
			if(mySetting == Setting.HIGH && timer == 0) {
				myTemperature = Temperature.BLAZING;
			}
			if((mySetting == Setting.LOW || mySetting == Setting.OFF) && timer == 0) {
				myTemperature = Temperature.WARM;
			}
			break;
		case BLAZING:
			if(mySetting != Setting.HIGH && timer == 0) {
				myTemperature = Temperature.HOT;
			}
			break;
		}	
	}

	public void display() {
		String message = "cooool";
		switch(myTemperature) {
		case COLD:
			break;
		case WARM:
			message = "warm";
			break;
		case HOT:
			message = "CAREFUL";
			break;
		case BLAZING:
			message = "VERY HOT! DON'T TOUCH";
			break;
		}
		System.out.println("[" + mySetting.toString() + "]....." + message);
		
	}

	public Temperature getTemperature() {
		return myTemperature;
	}

}
