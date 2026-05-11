package co.edu.uptc.repository;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.swing.JOptionPane;

import co.edu.uptc.domain.Patient;

/**
 * Nombre de la clase: PatientRepository
 *
 * <p>Clase que encarga de llevar registro de los pacientes</p>
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
public class PatientRepository {
	/**
	 * Atributo que determina una lista de pacientes
	 */
	private Set<Patient> patients = new HashSet<Patient>();
	
	/**
	 * Crea una nueva instancia de PatientRepository.
	 * Parámetro que determina
	 */
	public PatientRepository() {
		super();
	}

	/**
	 * Crea una nueva instancia de PatientRepository.
	 *
	 * @param patients Parámetro que determina los pacientes
	 */
	public PatientRepository(Set<Patient> patients) {
		super();
		this.patients = new HashSet<Patient>();
	}
	
	/**
	 * <b>Descripción: </b> Método encargado de agregar pacientes la registro <br>
	 * 
	 * @author SERGIO
	 *
	 * @param patient
	 * @return
	 * @return boolean
	 * @throws Exception [Condición en la que ocurre]
	 */
	public boolean addPatient(Patient patient) {
		return this.patients.add(patient);
	}
	
	/**
	 * <b>Descripción: </b> Método encargado de mostar la lista de pacientes <br>
	 * 
	 * @author SERGIO
	 *
	 * @return void
	 * @throws Exception [Condición en la que ocurre]
	 */
	public void findAll(){
		StringBuilder sb = new StringBuilder("Pacientes:\n");
        for (Patient elemento : patients) {
            sb.append("• ").append(elemento.toString()).append("\n");
            JOptionPane.showMessageDialog(
            	null, sb.toString());
        }
        
	}
	
	/**
	 * <b>Descripción: </b> Método encargado de encontrar un paciente por su numero de identificacion <br>
	 * 
	 * @author SERGIO
	 *
	 * @param idPatient
	 * @return
	 * @return Patient
	 * @throws Exception [Condición en la que ocurre]
	 */
	public Patient findPatientById(Long idPatient) {
		return this.patients.stream()
				.filter(p -> Objects.equals(p.getIdPatient(), idPatient) )
				.findFirst().orElse(null);
	}
	
	/**
	 * <b>Descripción: </b> Método encargado de actualizar la inforcion de un paciente <br>
	 * 
	 * @author SERGIO
	 *
	 * @param newPatient
	 * @return void
	 * @throws Exception [Condición en la que ocurre]
	 */
	public void updatePatient(Patient newPatient) {
		if (newPatient == null || newPatient.getIdPatient() == 0) {
		    return;
		}
		/* Eliminamos el registro actual */
		this.patients.remove(newPatient);
		/* Se agrega el nuevo producto */
		this.patients.add(newPatient);
	}
	
	/**
	 * <b>Descripción: </b> Método encargado de elimminar del registro a un paciente <br>
	 * 
	 * @author SERGIO
	 *
	 * @param idPatient
	 * @return
	 * @return boolean
	 * @throws Exception [Condición en la que ocurre]
	 */
	public boolean delete(Long idPatient) {
		return this.patients.removeIf(patient -> 
			patient.getIdPatient().equals(idPatient));
	}
	
	
}
