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

	}

	public void display() {
		System.out.println("[" + mySetting.toString() + "]....." + myTemperature);
	}

	public Temperature getTemperature() {
		return myTemperature;
	}

}
