package co.edu.uptc.service;

import java.util.Objects;
import java.util.Set;

import co.edu.uptc.domain.Patient;
import co.edu.uptc.repository.PatientRepository;

public class PatientService {
	private PatientRepository patientRepository;

	
	public PatientService() {
		super();
		this.patientRepository = new PatientRepository();
	}

	public PatientService(PatientRepository patientRepository) {
		super();
		this.patientRepository = new PatientRepository();
	}
	
	public boolean addPatient(Patient patient) {
		return this.patientRepository.addPatient(patient);
	}
	
	public Set<Patient> findAll() {
		return this.patientRepository.findAll();
	}
	
	public Patient findPatientById(Long idPatient) {
		if(Objects.isNull(idPatient)) {
			return null;
		}
		return this.patientRepository.findPatientById(idPatient);
	}
	
	public boolean updatePatient(Patient patient) {
		Patient oldPatient = this.patientRepository.findPatientById(patient.getIdPatient());
		if(!Objects.isNull(oldPatient)) {
			this.patientRepository.updatePatient(patient);
			return true;
		}
		return false;
	}
	
	public boolean deletePatient(Long idPatient) {
		if(Objects.isNull(idPatient)) {
			return false;
		}
		return this.patientRepository.delete(idPatient);
	}
	
}
