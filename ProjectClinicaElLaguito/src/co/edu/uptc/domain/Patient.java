package co.edu.uptc.domain;

import java.util.List;

import co.edu.uptc.enums.IdentificationTypeEnum;
import co.edu.uptc.enums.PriorityEnum;

public class Patient {
	private IdentificationTypeEnum identificationType;
	private int idPatient;
	private String firstName;
	private String lastName;
	private List<String> medicationHistory;
	private PriorityEnum priority;
	
	public Patient(IdentificationTypeEnum identificationType, int idPatient, String firstName, String lastName,
			List<String> medicationHistory, PriorityEnum priority) {
		super();
		this.identificationType = identificationType;
		this.idPatient = idPatient;
		this.firstName = firstName;
		this.lastName = lastName;
		this.medicationHistory = medicationHistory;
		this.priority = priority;
	}

	public IdentificationTypeEnum getIdentificationType() {
		return identificationType;
	}

	public void setIdentificationType(IdentificationTypeEnum identificationType) {
		this.identificationType = identificationType;
	}

	public int getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<String> getMedicationHistory() {
		return medicationHistory;
	}

	public void setMedicationHistory(List<String> medicationHistory) {
		this.medicationHistory = medicationHistory;
	}

	public PriorityEnum getPriority() {
		return priority;
	}

	public void setPriority(PriorityEnum priority) {
		this.priority = priority;
	}
}
