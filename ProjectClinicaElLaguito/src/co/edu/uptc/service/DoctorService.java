package co.edu.uptc.service;

import java.util.Objects;
import java.util.Set;

import co.edu.uptc.domain.Doctor;
import co.edu.uptc.repository.DoctorRepository;

/**
 * Nombre de la clase: DoctorService
 *
 * <p>Clase que se encarga de de validar el correcto registro de los medicos </p>
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
public class DoctorService {
	/**
	 * Atributo que determina el registro de los medicos
	 */
	private DoctorRepository doctorRepository;

	/**
	 * Crea una nueva instancia de DoctorService.
	 * Parámetro que determina el registro de los medicos
	 */
	public DoctorService() {
		super();
		this.doctorRepository = new DoctorRepository();
	}

	/**
	 * Crea una nueva instancia de DoctorService.
	 *
	 * @param doctorRepository Parámetro que determina le registro de los medicos
	 */
	public DoctorService(DoctorRepository doctorRepository) {
		super();
		this.doctorRepository = new DoctorRepository();
	}
	
	/**
	 * <b>Descripción: </b> Método encargado de agregar a los medicos <br>
	 * 
	 * @author SERGIO
	 *
	 * @param doctor
	 * @return
	 * @return boolean
	 * @throws Exception [Condición en la que ocurre]
	 */
	public boolean addDoctor(Doctor doctor) {
		return this.doctorRepository.addDoctor(doctor);
	}
	
	/**
	 * <b>Descripción: </b> Método encargado de mostra a los medicos registrados <br>
	 * 
	 * @author SERGIO
	 *
	 * @return void
	 * @throws Exception [Condición en la que ocurre]
	 */
	public void findAll() {
		this.doctorRepository.findAll();
	}
	
	/**
	 * <b>Descripción: </b> Método encargado de encontrar unmedico mediante su numero de identificacion 
	 * y validar su existencia dentro de la base de datos <br>
	 * 
	 * @author SERGIO
	 *
	 * @param medicalId
	 * @return
	 * @return Doctor
	 * @throws Exception [Condición en la que ocurre]
	 */
	public Doctor findDoctorById(Long medicalId) {
		if(Objects.isNull(medicalId)) {
			return null;
		}
		return this.doctorRepository.findDoctorById(medicalId);
	}
	
	/**
	 * <b>Descripción: </b> Método encargado de actualizar la informacion de un medico 
	 * y validar su existencia dentro de la base datos <br>
	 * 
	 * @author SERGIO
	 *
	 * @param doctor
	 * @return
	 * @return boolean
	 * @throws Exception [Condición en la que ocurre]
	 */
	public boolean updateDoctor(Doctor doctor) {
		Doctor oldDoctor = this.doctorRepository.findDoctorById(doctor.getMedicalId());
		if(!Objects.isNull(oldDoctor)) {
			this.doctorRepository.updateDoctor(doctor);
			return true;
		}
		return false;
	}
	
	/**
	 * <b>Descripción: </b> Método encargado de eliminar un medico y validar su existencia dentro de la base de datos  <br>
	 * 
	 * @author SERGIO
	 *
	 * @param medicalId
	 * @return
	 * @return boolean
	 * @throws Exception [Condición en la que ocurre]
	 */
	public boolean deleteDoctor(Long medicalId) {
		if(Objects.isNull(medicalId)) {
			return false;
		}
		return this.doctorRepository.delete(medicalId);
	}
	
}
