package co.edu.uptc.repository;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import co.edu.uptc.domain.Patient;

public class PatientRepository {
	private Set<Patient> patients;

	public PatientRepository(Set<Patient> patients) {
		super();
		this.patients = new HashSet<Patient>();
	}
	
	public boolean addProduct(Patient patient) {
		return this.patients.add(patient);
	}
	
	public Set<Patient> findAll(){
		return new HashSet<>(patients);
	}
	
	public Patient findProductById(int idPatient) {
		return this.patients.stream()
				.filter(p -> Objects.equals(p.getIdPatient(), idPatient) )
				.findFirst().orElse(null);
	}
	
	public void updateProduct(Patient newPatient) {
		if (newPatient == null || newPatient.getIdPatient() == 0) {
		    return;
		}
		/* Eliminamos el registro actual */
		this.patients.remove(newPatient);
		/* Se agrega el nuevo producto */
		this.patients.add(newPatient);
	}
	
	public boolean delete(Long idPatient) {
		return this.patients.removeIf(patient -> 
			patient.getIdPatient().equals(idPatient));
	}
	
	
}
