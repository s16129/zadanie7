package domain;

public enum Gender {
	Male,
	Female;
	
	public static Gender fromString(final String s) {
	    return Gender.valueOf(s);
	}
}
