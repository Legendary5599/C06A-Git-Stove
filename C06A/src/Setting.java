/**
 * Setting enumerated type for burner which has off, low, medium, and high settings.
 * 
 * @author Samantha Murray
 * @author Ryan Clark
 * 
 * Date: 9/18/2025
 */
public enum Setting {
	OFF("---"), LOW("--+"), MEDIUM("-++"), HIGH("+++");
	private String value;
	
	Setting(String aValue){
		value=aValue;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
