package co.edu.uptc.domain;

import java.time.LocalTime;


public class MedicalAppoinmet {
	private int idMedicalAppoinmet;
	private LocalTime timeAppoinmet;
	private Patient patient;
	private Doctor doctor;
	
	public MedicalAppoinmet(int idMedicalAppoinmet, LocalTime timeAppoinmet, Patient patient, Doctor doctor) {
		super();
		this.idMedicalAppoinmet = idMedicalAppoinmet;
		this.timeAppoinmet = timeAppoinmet;
		this.patient = patient;
		this.doctor = doctor;
	}
	
	public int getIdMedicalAppoinmet() {
		return idMedicalAppoinmet;
	}
	public void setIdMedicalAppoinmet(int idMedicalAppoinmet) {
		this.idMedicalAppoinmet = idMedicalAppoinmet;
	}
	public LocalTime getTimeAppoinmet() {
		return timeAppoinmet;
	}
	public void setTimeAppoinmet(LocalTime timeAppoinmet) {
		this.timeAppoinmet = timeAppoinmet;
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
}
