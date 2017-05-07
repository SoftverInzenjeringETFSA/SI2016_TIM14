package models.enums;

public enum Gender {
	MALE(0),
	FEMALE(1);
	
	private final int gender;
	
	Gender(int genderInt) {
		this.gender = genderInt;
	}
	
	public int gender() { return this.gender; }
	
	public static Gender fromInt(int x) {
		switch (x) {
			case 0:
				return Gender.MALE;
			case 1:
				return Gender.FEMALE;
			default: return null;
		}
	}
}