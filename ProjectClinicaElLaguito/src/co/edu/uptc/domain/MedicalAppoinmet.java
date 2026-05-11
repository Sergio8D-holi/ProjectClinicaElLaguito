package co.edu.uptc.domain;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;


/**
 * Nombre de la clase: MedicalAppoinmet
 *
 * <p>Clase del modelo que representa la 
 * informacion de la cita medica</p>
 *
 * <p><b>Responsabilidades:</b></p>
 * <ul>
 *   <li>[Responsabilidad 1]</li>
 *   <li>[Responsabilidad 2]</li>
 * </ul>
 *
 * <p><b>Notas:</b></p>
 * <ul>
 *   <li>[Consideraciones importantes]</li>
 * </ul>
 *
 * @author SERGIO
 * @version 1.0
 * @since May 10, 2026
 */
public class MedicalAppoinmet {

	/**
	 * Atributo que determina el numero de identificacion de la cita
	 */
	private Long idMedicalAppoinmet;
	/**
	 * Atributo que determina la fecha y la hora de la cita
	 */
	private LocalDateTime dateTimeAppoinmet;
	/**
	 * Atributo que determina el paciente que tomara la cita
	 */
	private Patient patient;
	/**
	 * Atributo que determina el doctor que atendera la cita
	 */
	private Doctor doctor;
	
	/**
	 * Crea una nueva instancia de MedicalAppoinmet.
	 *
	 * @param idMedicalAppoinmet
	 * @param dateTimeAppoinmet
	 * @param patient
	 * @param doctor Parámetro que determina
	 */
	public MedicalAppoinmet(Long idMedicalAppoinmet, LocalDateTime dateTimeAppoinmet, Patient patient, Doctor doctor) {
		super();
		this.idMedicalAppoinmet = idMedicalAppoinmet;
		this.dateTimeAppoinmet = dateTimeAppoinmet;
		this.patient = patient;
		this.doctor = doctor;
	}
	
	

	/**
	 * Método encargado de retornar el valor de idMedicalAppoinmet.
	 *
	 * @return valor de idMedicalAppoinmet
	 */
	public Long getIdMedicalAppoinmet() {
		return idMedicalAppoinmet;
	}



	/**
	 * Método encargado de establecer el valor de idMedicalAppoinmet.
	 *
	 * @param idMedicalAppoinmet nuevo valor de idMedicalAppoinmet
	 */
	public void setIdMedicalAppoinmet(Long idMedicalAppoinmet) {
		this.idMedicalAppoinmet = idMedicalAppoinmet;
	}



	/**
	 * Método encargado de retornar el valor de dateTimeAppoinmet.
	 *
	 * @return valor de dateTimeAppoinmet
	 */
	public LocalDateTime getDateTimeAppoinmet() {
		return dateTimeAppoinmet;
	}



	/**
	 * Método encargado de establecer el valor de dateTimeAppoinmet.
	 *
	 * @param dateTimeAppoinmet nuevo valor de dateTimeAppoinmet
	 */
	public void setDateTimeAppoinmet(LocalDateTime dateTimeAppoinmet) {
		this.dateTimeAppoinmet = dateTimeAppoinmet;
	}



	/**
	 * Método encargado de retornar el valor de patient.
	 *
	 * @return valor de patient
	 */
	public Patient getPatient() {
		return patient;
	}



	/**
	 * Método encargado de establecer el valor de patient.
	 *
	 * @param patient nuevo valor de patient
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}



	/**
	 * Método encargado de retornar el valor de doctor.
	 *
	 * @return valor de doctor
	 */
	public Doctor getDoctor() {
		return doctor;
	}



	/**
	 * Método encargado de establecer el valor de doctor.
	 *
	 * @param doctor nuevo valor de doctor
	 */
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.idMedicalAppoinmet, this.dateTimeAppoinmet, this.patient.getPriority());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MedicalAppoinmet other = (MedicalAppoinmet) obj;
		return Objects.equals(this.idMedicalAppoinmet, other.idMedicalAppoinmet);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "MedicalAppoinmet [idMedicalAppoinmet=" + idMedicalAppoinmet + ", dateTimeAppoinmet=" + dateTimeAppoinmet
				+ ", patient=" + patient.toString() + ", doctor=" + doctor.toString() + "]";
	} 	
	
	
	
}
