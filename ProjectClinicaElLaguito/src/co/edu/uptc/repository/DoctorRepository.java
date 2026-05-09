package co.edu.uptc.repository;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.swing.JOptionPane;

import co.edu.uptc.domain.Doctor;
import co.edu.uptc.domain.Patient;

public class DoctorRepository {
	private Set<Doctor> doctors = new HashSet<Doctor>();
	
	public DoctorRepository() {
		super();
	}

	public DoctorRepository(Set<Doctor> doctors) {
		super();
		this.doctors = new HashSet<>();
	}
	
	public boolean addDoctor(Doctor doctor) {
		return this.doctors.add(doctor);
	}
	
	public void findAll(){
		StringBuilder sb = new StringBuilder("Pacientes:\n");
        for (Doctor elemento : doctors) {
            sb.append("• ").append(elemento.toString()).append("\n");
            JOptionPane.showMessageDialog(
            	null, sb.toString());
            }
	}
	
	public Doctor findDoctorById(Long medicalId) {
		return this.doctors.stream()
				.filter(d -> Objects.equals(d.getMedicalId(), medicalId) )
				.findFirst().orElse(null);
	}
	
	public void updateDoctor(Doctor newDoctor) {
		if (newDoctor == null || newDoctor.getMedicalId() == 0) {
		    return;
		}
		/* Eliminamos el registro actual */
		this.doctors.remove(newDoctor);
		/* Se agrega el nuevo producto */
		this.doctors.add(newDoctor);
	}
	
	public boolean delete(Long medicalId) {
		return this.doctors.removeIf(doctor -> 
		doctor.getMedicalId().equals(medicalId));
	}
	
}
