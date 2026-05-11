package co.edu.uptc.domain;

import java.util.LinkedHashSet;
import java.util.Objects;

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
	  email
	  medicationHistory
	  priority
*/
	
	/**Atributo que determina el tipo de identificacion del paciente**/
	private IdentificationTypeEnum identificationType;
	
	/**Atributo que determina el numero de identificacion del paciente**/
	private Long idPatient;
	
	/**Atributo que determina el primer nombre del paciente**/
	private String firstName;
	
	private String email;
	
	/**Atributo que determina el apellido del paciente**/
	private String lastName;
	
	/**Atributo que determina el historial de medicacion del paciente**/
	private LinkedHashSet<String> medicationHistory;
	
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
	public Patient(IdentificationTypeEnum identificationType, Long idPatient, String firstName, String email,
			String lastName, LinkedHashSet<String> medicationHistory, PriorityEnum priority) {
		super();
		this.identificationType = identificationType;
		this.idPatient = idPatient;
		this.firstName = firstName;
		this.email = email;
		this.lastName = lastName;
		this.medicationHistory = medicationHistory;
		this.priority = priority;
	}

	

	/**
	 * Método encargado de retornar el valor de identificationType.
	 *
	 * @return valor de identificationType
	 */
	public IdentificationTypeEnum getIdentificationType() {
		return identificationType;
	}

	/**
	 * Método encargado de establecer el valor de identificationType.
	 *
	 * @param identificationType nuevo valor de identificationType
	 */
	public void setIdentificationType(IdentificationTypeEnum identificationType) {
		this.identificationType = identificationType;
	}

	/**
	 * Método encargado de retornar el valor de idPatient.
	 *
	 * @return valor de idPatient
	 */
	public Long getIdPatient() {
		return idPatient;
	}

	/**
	 * Método encargado de establecer el valor de idPatient.
	 *
	 * @param idPatient nuevo valor de idPatient
	 */
	public void setIdPatient(Long idPatient) {
		this.idPatient = idPatient;
	}

	/**
	 * Método encargado de retornar el valor de firstName.
	 *
	 * @return valor de firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Método encargado de establecer el valor de firstName.
	 *
	 * @param firstName nuevo valor de firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Método encargado de retornar el valor de email.
	 *
	 * @return valor de email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Método encargado de establecer el valor de email.
	 *
	 * @param email nuevo valor de email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Método encargado de retornar el valor de lastName.
	 *
	 * @return valor de lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Método encargado de establecer el valor de lastName.
	 *
	 * @param lastName nuevo valor de lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Método encargado de retornar el valor de medicationHistory.
	 *
	 * @return valor de medicationHistory
	 */
	public LinkedHashSet<String> getMedicationHistory() {
		return medicationHistory;
	}

	/**
	 * Método encargado de establecer el valor de medicationHistory.
	 *
	 * @param medicationHistory nuevo valor de medicationHistory
	 */
	public void setMedicationHistory(LinkedHashSet<String> medicationHistory) {
		this.medicationHistory = medicationHistory;
	}

	/**
	 * Método encargado de retornar el valor de priority.
	 *
	 * @return valor de priority
	 */
	public PriorityEnum getPriority() {
		return priority;
	}

	/**
	 * Método encargado de establecer el valor de priority.
	 *
	 * @param priority nuevo valor de priority
	 */
	public void setPriority(PriorityEnum priority) {
		this.priority = priority;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.idPatient, this.priority);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient auxPatient = (Patient) obj;
		return this.email.equals(auxPatient.email) && this.idPatient.equals(auxPatient.idPatient)
				&& identificationType == auxPatient.identificationType;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Patient [identificationType=" + identificationType.getDescription() + ", idPatient=" + idPatient + ", firstName="
				+ firstName + ", email=" + email + ", lastName=" + lastName + ", medicationHistory=" + medicationHistory
				+ ", priority=" + priority + "]";
	}
	
	
	
}
