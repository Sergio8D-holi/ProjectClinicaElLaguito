package co.edu.uptc.service;

import java.util.Objects;
import java.util.Set;

import co.edu.uptc.domain.MedicalAppoinmet;
import co.edu.uptc.repository.MedicalAppoimentRepository;

/**
 * Nombre de la clase: MedicalAppoimentService
 *
 * <p>Clase que se encarga de validar el correcto registro de la citas medicas </p>
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
public class MedicalAppoimentService {
	/**
	 * Atributo que determina el registro de las citas medicas
	 */
	private MedicalAppoimentRepository medicalAppoimentRepository;

	
	/**
	 * Crea una nueva instancia de MedicalAppoimentService.
	 * Parámetro que determina el registro de las citas medicas
	 */
	public MedicalAppoimentService() {
		super();
		this.medicalAppoimentRepository = new MedicalAppoimentRepository();
	}

	/**
	 * Crea una nueva instancia de MedicalAppoimentService.
	 *
	 * @param medicalAppoimentRepository Parámetro que determina el registronde las citas medicas
	 */
	public MedicalAppoimentService(MedicalAppoimentRepository medicalAppoimentRepository) {
		super();
		this.medicalAppoimentRepository = new MedicalAppoimentRepository();
	}
	
	/**
	 * <b>Descripción: </b> Método encargado de agregar una nueva cita medica <br>
	 * 
	 * @author SERGIO
	 *
	 * @param medicalAppoiment
	 * @return
	 * @return boolean
	 * @throws Exception [Condición en la que ocurre]
	 */
	public boolean addMedicalAppoiment(MedicalAppoinmet medicalAppoiment) {
		return this.medicalAppoimentRepository.addMedicalAppoinmet(medicalAppoiment);
	}
	
	/**
	 * <b>Descripción: </b> Método encargado de mostrar el regitro de las citas medicas <br>
	 * 
	 * @author SERGIO
	 *
	 * @return void
	 * @throws Exception [Condición en la que ocurre]
	 */
	public void findAll() {
		this.medicalAppoimentRepository.findAll();
	}
	
	/**
	 * <b>Descripción: </b> Método encargado de encontrar una cita medica por su numero de identificacion y validar que exista en la base de datos <br>
	 * 
	 * @author SERGIO
	 *
	 * @param idMedicalAppoinmet
	 * @return
	 * @return MedicalAppoinmet
	 * @throws Exception [Condición en la que ocurre]
	 */
	public MedicalAppoinmet findMedicalAppoinmetById(Long idMedicalAppoinmet) {
		if(Objects.isNull(idMedicalAppoinmet)) {
			return null;
		}
		return this.medicalAppoimentRepository.findMedicalAppoinmetById(idMedicalAppoinmet);
	}
	
	/**
	 * <b>Descripción: </b> Método encargado de actualizar la informacion de la cita medica y validar que exista en la base de datos <br>
	 * 
	 * @author SERGIO
	 *
	 * @param medicalAppoinmet
	 * @return
	 * @return boolean
	 * @throws Exception [Condición en la que ocurre]
	 */
	public boolean updateMedicalAppoinmet(MedicalAppoinmet medicalAppoinmet) {
		MedicalAppoinmet oldMedicalAppoinmet = this.medicalAppoimentRepository.findMedicalAppoinmetById(medicalAppoinmet.getIdMedicalAppoinmet());
		if(!Objects.isNull(oldMedicalAppoinmet)) {
			this.medicalAppoimentRepository.updateMedicalAppoinmet(medicalAppoinmet);
			return true;
		}
		return false;
	}
	
	/**
	 * <b>Descripción: </b> Método encargado de eliminar una cita medica y validar que exista en la base de datos <br>
	 * 
	 * @author SERGIO
	 *
	 * @param idMedicalAppoinmet
	 * @return
	 * @return boolean
	 * @throws Exception [Condición en la que ocurre]
	 */
	public boolean deleteMedicalAppoinmet(Long idMedicalAppoinmet) {
		if(Objects.isNull(idMedicalAppoinmet)) {
			return false;
		}
		return this.medicalAppoimentRepository.delete(idMedicalAppoinmet);
	}
}
