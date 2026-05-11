package co.edu.uptc.repository;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.swing.JOptionPane;

import co.edu.uptc.domain.MedicalAppoinmet;
import co.edu.uptc.domain.Patient;

/**
 * Nombre de la clase: MedicalAppoimentRepository
 *
 * <p>Clase encarga de llevar el registro de las citas medicas</p>
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
public class MedicalAppoimentRepository {
	/**
	 * Atributo que determina el registro de las citas medicas 
	 */
	private Set<MedicalAppoinmet> medicalAppoiments = new HashSet<MedicalAppoinmet>();
	
	/**
	 * Crea una nueva instancia de MedicalAppoimentRepository.
	 * Parámetro que determina
	 */
	public MedicalAppoimentRepository() {
		super();
	}

	/**
	 * Crea una nueva instancia de MedicalAppoimentRepository.
	 *
	 * @param medicalAppoiments Parámetro que determina el registro de las citas medicas
	 */
	public MedicalAppoimentRepository(Set<MedicalAppoinmet> medicalAppoiments) {
		super();
		this.medicalAppoiments = new HashSet<>();
	}

	/**
	 * <b>Descripción: </b> Método encargado de agregar una nueva cita medica <br>
	 * 
	 * @author SERGIO
	 *
	 * @param medicalAppoinmet
	 * @return
	 * @return boolean
	 * @throws Exception [Condición en la que ocurre]
	 */
	public boolean addMedicalAppoinmet(MedicalAppoinmet medicalAppoinmet) {
		return this.medicalAppoiments.add(medicalAppoinmet);
	}
	
	/**
	 * <b>Descripción: </b> Método encargado de mostar las citas medicas creadas <br>
	 * 
	 * @author SERGIO
	 *
	 * @return void
	 * @throws Exception [Condición en la que ocurre]
	 */
	public void findAll(){
		StringBuilder sb = new StringBuilder("Citas medicas:\n");
        for (MedicalAppoinmet elemento : medicalAppoiments) {
            sb.append("• ").append(elemento.toString()).append("\n");
            JOptionPane.showMessageDialog(
            	null, sb.toString());
            }
	}
	
	/**
	 * <b>Descripción: </b> Método encargado de encontrar una cita medica mediante su numero de idenficacion <br>
	 * 
	 * @author SERGIO
	 *
	 * @param idMedicalAppoinmet
	 * @return
	 * @return MedicalAppoinmet
	 * @throws Exception [Condición en la que ocurre]
	 */
	public MedicalAppoinmet findMedicalAppoinmetById(Long idMedicalAppoinmet) {
		return this.medicalAppoiments.stream()
				.filter(d -> Objects.equals(d.getIdMedicalAppoinmet(), idMedicalAppoinmet) )
				.findFirst().orElse(null);
	}
	
	/**
	 * <b>Descripción: </b> Método encargado de actualizar la informacion de una cita medica <br>
	 * 
	 * @author SERGIO
	 *
	 * @param newMedicalAppoinmet
	 * @return void
	 * @throws Exception [Condición en la que ocurre]
	 */
	public void updateMedicalAppoinmet(MedicalAppoinmet newMedicalAppoinmet) {
		if (newMedicalAppoinmet == null || newMedicalAppoinmet.getIdMedicalAppoinmet() == 0) {
		    return;
		}
		/* Eliminamos el registro actual */
		this.medicalAppoiments.remove(newMedicalAppoinmet);
		/* Se agrega el nuevo producto */
		this.medicalAppoiments.add(newMedicalAppoinmet);
	}
	
	/**
	 * <b>Descripción: </b> Método encargado de eliminar una cita medica <br>
	 * 
	 * @author SERGIO
	 *
	 * @param idMedicalAppoinmet
	 * @return
	 * @return boolean
	 * @throws Exception [Condición en la que ocurre]
	 */
	public boolean delete(Long idMedicalAppoinmet) {
		return this.medicalAppoiments.removeIf(medicalAppoiment-> 
			medicalAppoiment.getIdMedicalAppoinmet().equals(idMedicalAppoinmet));
	}
	
}
