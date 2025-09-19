
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
