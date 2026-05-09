package co.edu.uptc.enums;

public enum IdentificationTypeEnum {
	CC ("Cédula de ciudadanía"), TI ("Tarjeta de identidad"),
	CE ("Cédula de extranjería"), PA ("Pasaporte");

	private final String description;

	private IdentificationTypeEnum(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
					
}
