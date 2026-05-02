package co.edu.uptc.domain;

import java.util.List;

import co.edu.uptc.enums.IdentificationTypeEnum;
import co.edu.uptc.enums.PriorityEnum;

/**<b> Descripcion: </b> Clase del modelo que representa la 
 * informacion del paciente <br>
 * 
 * @author Sergio8D
*/

public class Patient {
	/*identificationType
	  idPatient
	  firstName
	  lastName
	  medicationHistory
	  priority
*/
	
	/**Atributo que determina el tipo de identificacion del paciente**/
	private IdentificationTypeEnum identificationType;
	
	/**Atributo que determina el numero de identificacion del paciente**/
	private int idPatient;
	
	/**Atributo que determina el primer nombre del paciente**/
	private String firstName;
	
	/**Atributo que determina el apellido del paciente**/
	private String lastName;
	
	/**Atributo que determina el historial de medicacion del paciente**/
	private List<String> medicationHistory;
	
	/**Atributo que determina la prioridad de atencion del paciente**/
	private PriorityEnum priority;
	
	
	/**<b>Descripcion: </b> Contructor de la clase <br>
	 * */
	public Patient() {
		super();
	}

	/**<b>Descripcion: </b> COntructor de la clase <br>
	 * @param identificationType Parametro que determina el tipo de identificacion del paciente
	 * @param idPatient Parametro que determina el numero de identificacion del paciente
	 * @param firstName Parametro que determina el primer nombre del paciente
	 * @param lastName Parametro que determina el apellido del paciente
	 * @param medicationHistory Parametro que determina el historial de medicacion del paciente
	 * @param priority Parametro que determina la prioridad de atencion del paciente
	 * */
	public Patient(IdentificationTypeEnum identificationType, int idPatient, String firstName, String lastName,
			List<String> medicationHistory, PriorityEnum priority) {
		super();
		this.identificationType = identificationType;
		this.idPatient = idPatient;
		this.firstName = firstName;
		this.lastName = lastName;
		this.medicationHistory = medicationHistory;
		this.priority = priority;
	}

	/**<b>Descripcion: </b> Retorna el valor del tipo de identificacion
	 * @return identificationType retorna el tipo de identificaion del paciente
	 * */
	public IdentificationTypeEnum getIdentificationType() {
		return identificationType;
	}

	/**<b>Descripcion: </b> Retorna el valor del tipo de identificacion del paciente
	 * @param identificationType Representa el nuevo tipo de identificacion del paciente
	 * */
	public void setIdentificationType(IdentificationTypeEnum identificationType) {
		this.identificationType = identificationType;
	}

	/**<b>Descripcion: </b> Retorna el valor de la identificacion
	 * @return idPatient retorna la identificacion del paciente
	 * */
	public int getIdPatient() {
		return idPatient;
	}

	/**<b>Descripcion: </b> Retorna el valor de la identificacion
	 * @param idPatient Representa la nueva identificacicon del paciente
	 * */
	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}

	/**<b>Descripcion: </b> Retorna el valor del Primer nombre
	 * @return firstName retorna el primer nombre del paciente
	 * */
	public String getFirstName() {
		return firstName;
	}

	/**<b>Descripcion: </b> Retorna el valor del primer nombre
	 * @param firstName Representa el nuevo primer nombre del paciente
	 * */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**<b>Descripcion: </b> Retorna el valor del apellido
	 * @return lastName retorna el apellido del paciente
	 * */
	public String getLastName() {
		return lastName;
	}

	/**<b>Descripcion: </b> Retorna el valor del apellido
	 * @param lastName Representa el nuevo apellido del paciente
	 * */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**<b>Descripcion: </b> Retorna el valor del historial de medicacion
	 * @return medicationHistory retorna historial de medicacion del paciente
	 * */
	public List<String> getMedicationHistory() {
		return medicationHistory;
	}

	/**<b>Descripcion: </b> Retorna el valor del historial de medicacion
	 * @param medicationHistory Representa el nuevo historial de medicacion del paciente
	 * */
	public void setMedicationHistory(List<String> medicationHistory) {
		this.medicationHistory = medicationHistory;
	}

	/**<b>Descripcion: </b> Retorna el valor de la prioridad
	 * @return priority retorna la prioridad del paciente
	 * */
	public PriorityEnum getPriority() {
		return priority;
	}

	/**<b>Descripcion: </b> Retorna el valor del ID
	 * @param priority Representa la nueva prioridad del paciente
	 * */
	public void setPriority(PriorityEnum priority) {
		this.priority = priority;
	}
}
