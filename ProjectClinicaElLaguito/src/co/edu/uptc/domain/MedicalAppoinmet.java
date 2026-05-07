package co.edu.uptc.domain;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;


public class MedicalAppoinmet {
	private Long idMedicalAppoinmet;
	private LocalDateTime dateTimeAppoinmet;
	private Patient patient;
	private Doctor doctor;
	
	public MedicalAppoinmet(Long idMedicalAppoinmet, LocalDateTime dateTimeAppoinmet, Patient patient, Doctor doctor) {
		super();
		this.idMedicalAppoinmet = idMedicalAppoinmet;
		this.dateTimeAppoinmet = dateTimeAppoinmet;
		this.patient = patient;
		this.doctor = doctor;
	}
	
	public Long getIdMedicalAppoinmet() {
		return idMedicalAppoinmet;
	}
	public void setIdMedicalAppoinmet(Long idMedicalAppoinmet) {
		this.idMedicalAppoinmet = idMedicalAppoinmet;
	}
	public LocalDateTime getDateTimeAppoinmet() {
		return dateTimeAppoinmet;
	}
	public void setTimeAppoinmet(LocalDateTime dateTimeAppoinmet) {
		this.dateTimeAppoinmet = dateTimeAppoinmet;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idMedicalAppoinmet);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MedicalAppoinmet other = (MedicalAppoinmet) obj;
		return Objects.equals(idMedicalAppoinmet, other.idMedicalAppoinmet);
	} 	
	
	
	
}
