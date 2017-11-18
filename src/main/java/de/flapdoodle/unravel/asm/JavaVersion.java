package de.flapdoodle.unravel.asm;

import de.flapdoodle.checks.Preconditions;

public enum JavaVersion {
  V1_1(3 << 16 | 45),
  V1_2(0 << 16 | 46),
  V1_3(0 << 16 | 47),
  V1_4(0 << 16 | 48),
  V1_5(0 << 16 | 49),
  V1_6(0 << 16 | 50),
  V1_7(0 << 16 | 51),
  V1_8(0 << 16 | 52),
  V9(0 << 16 | 53);
  
	private final int value;

  private JavaVersion(int value) {
		this.value = value;
	}
  
  public static JavaVersion of(int value) {
  	for (JavaVersion v : JavaVersion.values()) {
  		if (v.value==value) {
  			return v;
  		}
  	}
  	
  	return Preconditions.checkNotNull(null, "could not find version for %s", value);
  }
}
