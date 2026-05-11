package co.edu.uptc.repository;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.swing.JOptionPane;

import co.edu.uptc.domain.Doctor;
import co.edu.uptc.domain.Patient;

/**
 * Nombre de la clase: DoctorRepository
 *
 * <p>Clase que se encarga de llevar registro de los medicos</p>
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
public class DoctorRepository {
	/**
	 * Atributo que determina una lista de medicos
	 */
	private Set<Doctor> doctors = new HashSet<Doctor>();
	
	/**
	 * Crea una nueva instancia de DoctorRepository.
	 * Parámetro que determina
	 */
	public DoctorRepository() {
		super();
	}

	/**
	 * Crea una nueva instancia de DoctorRepository.
	 *
	 * @param doctors Parámetro que determina una lista de medicos
	 */
	public DoctorRepository(Set<Doctor> doctors) {
		super();
		this.doctors = new HashSet<>();
	}
	
	/**
	 * <b>Descripción: </b> Método encargado de agregar un nuevo medico <br>
	 * 
	 * @author SERGIO
	 *
	 * @param doctor
	 * @return
	 * @return boolean
	 * @throws Exception [Condición en la que ocurre]
	 */
	public boolean addDoctor(Doctor doctor) {
		return this.doctors.add(doctor);
	}
	
	/**
	 * <b>Descripción: </b> Método encargado de mostrar la lista de los medicos <br>
	 * 
	 * @author SERGIO
	 *
	 * @return void
	 * @throws Exception [Condición en la que ocurre]
	 */
	public void findAll(){
		StringBuilder sb = new StringBuilder("Pacientes:\n");
        for (Doctor elemento : doctors) {
            sb.append("• ").append(elemento.toString()).append("\n");
            JOptionPane.showMessageDialog(
            	null, sb.toString());
            }
	}
	
	/**
	 * <b>Descripción: </b> Método encargado de encontrar un medico por su numero de identificacion <br>
	 * 
	 * @author SERGIO
	 *
	 * @param medicalId
	 * @return
	 * @return Doctor
	 * @throws Exception [Condición en la que ocurre]
	 */
	public Doctor findDoctorById(Long medicalId) {
		return this.doctors.stream()
				.filter(d -> Objects.equals(d.getMedicalId(), medicalId) )
				.findFirst().orElse(null);
	}
	
	/**
	 * <b>Descripción: </b> Método encargado de actualizar la informacion del medicos <br>
	 * 
	 * @author SERGIO
	 *
	 * @param newDoctor
	 * @return void
	 * @throws Exception [Condición en la que ocurre]
	 */
	public void updateDoctor(Doctor newDoctor) {
		if (newDoctor == null || newDoctor.getMedicalId() == 0) {
		    return;
		}
		/* Eliminamos el registro actual */
		this.doctors.remove(newDoctor);
		/* Se agrega el nuevo producto */
		this.doctors.add(newDoctor);
	}
	
	/**
	 * <b>Descripción: </b> Método encargado de eliminar a un medico <br>
	 * 
	 * @author SERGIO
	 *
	 * @param medicalId
	 * @return
	 * @return boolean
	 * @throws Exception [Condición en la que ocurre]
	 */
	public boolean delete(Long medicalId) {
		return this.doctors.removeIf(doctor -> 
		doctor.getMedicalId().equals(medicalId));
	}
	
}
