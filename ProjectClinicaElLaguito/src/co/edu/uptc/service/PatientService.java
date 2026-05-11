package co.edu.uptc.service;

import java.util.Objects;
import java.util.Set;

import co.edu.uptc.domain.Patient;
import co.edu.uptc.repository.PatientRepository;

/**
 * Nombre de la clase: PatientService
 *
 * <p>Clase encargada de validar el correcto registro de los pacientes</p>
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
public class PatientService {
	/**
	 * Atributo que determina el registro de los pacientes
	 */
	private PatientRepository patientRepository;

	
	/**
	 * Crea una nueva instancia de PatientService.
	 * Parámetro que determinael registro de los pacientes
	 */
	public PatientService() {
		super();
		this.patientRepository = new PatientRepository();
	}

	/**
	 * Crea una nueva instancia de PatientService.
	 *
	 * @param patientRepository Parámetro que determinael registro de los pacientes
	 */
	public PatientService(PatientRepository patientRepository) {
		super();
		this.patientRepository = new PatientRepository();
	}
	
	/**
	 * <b>Descripción: </b> Método encargado de agregar un paciente al lista <br>
	 * 
	 * @author SERGIO
	 *
	 * @param patient
	 * @return
	 * @return boolean
	 * @throws Exception [Condición en la que ocurre]
	 */
	public boolean addPatient(Patient patient) {
		return this.patientRepository.addPatient(patient);
	}
	
	/**
	 * <b>Descripción: </b> Método encargado de mostrar una lista de pacientes registrados <br>
	 * 
	 * @author SERGIO
	 *
	 * @return void
	 * @throws Exception [Condición en la que ocurre]
	 */
	public void findAll() {
		this.patientRepository.findAll();
	}
	
	/**
	 * <b>Descripción: </b> Método encargado de encontrar un paciente medinate su numero de identificacion 
	 * y validar que este paciente exista dentro de la base de datos<br>
	 * 
	 * @author SERGIO
	 *
	 * @param idPatient
	 * @return
	 * @return Patient
	 * @throws Exception [Condición en la que ocurre]
	 */
	public Patient findPatientById(Long idPatient) {
		if(Objects.isNull(idPatient)) {
			return null;
		}
		return this.patientRepository.findPatientById(idPatient);
	}
	
	/**
	 * <b>Descripción: </b> Método encargado de actualizar la informacion de un paciente y 
	 * validar que este exista <br>
	 * 
	 * @author SERGIO
	 *
	 * @param patient
	 * @return
	 * @return boolean
	 * @throws Exception [Condición en la que ocurre]
	 */
	public boolean updatePatient(Patient patient) {
		Patient oldPatient = this.patientRepository.findPatientById(patient.getIdPatient());
		if(!Objects.isNull(oldPatient)) {
			this.patientRepository.updatePatient(patient);
			return true;
		}
		return false;
	}
	
	/**
	 * <b>Descripción: </b> Método encargado de eliminar un paciente de la base de datos <br>
	 * 
	 * @author SERGIO
	 *
	 * @param idPatient
	 * @return
	 * @return boolean
	 * @throws Exception [Condición en la que ocurre]
	 */
	public boolean deletePatient(Long idPatient) {
		if(Objects.isNull(idPatient)) {
			return false;
		}
		return this.patientRepository.delete(idPatient);
	}
	
}
