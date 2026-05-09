package co.edu.uptc.service;

import java.util.Objects;
import java.util.Set;

import co.edu.uptc.domain.Doctor;
import co.edu.uptc.repository.DoctorRepository;

public class DoctorService {
	private DoctorRepository doctorRepository;

	public DoctorService() {
		super();
		this.doctorRepository = new DoctorRepository();
	}

	public DoctorService(DoctorRepository doctorRepository) {
		super();
		this.doctorRepository = new DoctorRepository();
	}
	
	public boolean addDoctor(Doctor doctor) {
		return this.doctorRepository.addDoctor(doctor);
	}
	
	public void findAll() {
		this.doctorRepository.findAll();
	}
	
	public Doctor findDoctorById(Long medicalId) {
		if(Objects.isNull(medicalId)) {
			return null;
		}
		return this.doctorRepository.findDoctorById(medicalId);
	}
	
	public boolean updateDoctor(Doctor doctor) {
		Doctor oldDoctor = this.doctorRepository.findDoctorById(doctor.getMedicalId());
		if(!Objects.isNull(oldDoctor)) {
			this.doctorRepository.updateDoctor(doctor);
			return true;
		}
		return false;
	}
	
	public boolean deleteDoctor(Long medicalId) {
		if(Objects.isNull(medicalId)) {
			return false;
		}
		return this.doctorRepository.delete(medicalId);
	}
	
}
