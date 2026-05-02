package co.edu.uptc.domain;

import co.edu.uptc.enums.IdentificationTypeEnum;

/**<b> Descripcion: </b> Clase del modelo que representa la 
 * informacion del mwdico <br>
 * 
 * @author Sergio8D
*/
public class Doctor {
	/*identificationType
	  medicalId
	  firstName
	  lastName
	  specialty
	  yearsOfExperience
	  
*/
	
	/**Atributo que determina el tipo de identificacion del medico**/
	private IdentificationTypeEnum identificationType;
	
	/**Atributo que determina el numero de identificacion del medico**/
	private int medicalId;
	
	/**Atributo que determina el primer nombre del medico**/
	private String firstName;
	
	/**Atributo que determina el apellido del medico**/
	private String lastName;
	
	/**Atributo que determina la especialidad del medico**/
	private String specialty;
	
	/**Atributo que determina los años de experiencia del medico**/
	private int yearsOfExperience;
	
	/**<b>Descripcion: </b> Constructor de la clase <br>
	 * */
	public Doctor() {
		super();
	}

	/**<b>Descripcion: </b> Constructor de la clase <br>
	 * @param identificaionType Parametro que determina el tipo de identificacion del medico
	 * @param medicalId Parametro que determina el numero de identificacion del medico
	 * @param firstName Parametro que determina el primer nombre del medico
	 * @param lastName Parametro que determina el apellido del medico
	 * @param speciality Parametro que determina la especialidad del medico
	 * @param yearsOfExperience Parametro que determina los años de experiencia del medico
	 * */
	public Doctor(IdentificationTypeEnum identificationType, int medicalId, String firstName, String lastName,
			String specialty, int yearsOfExperience) {
		super();
		this.identificationType = identificationType;
		this.medicalId = medicalId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.specialty = specialty;
		this.yearsOfExperience = yearsOfExperience;
	}

	/**<b>Descripcion: </b> Retorna el valor del tipo de identificacion
	 * @return identificationType retorna el tipo de identificacion del medico
	 * */
	public IdentificationTypeEnum getIdentificationType() {
		return identificationType;
	}

	/**<b>Descripcion: </b> Retorna el valor del tipo de identificacion
	 * @param identificationType Representa el nuevo tipo de identificacion del medico
	 * */
	public void setIdentificationType(IdentificationTypeEnum identificationType) {
		this.identificationType = identificationType;
	}

	/**<b>Descripcion: </b> Retorna el valor del numero de identificacion
	 * @return medicalId retorna el numero de identificacion del medico
	 * */
	public int getMedicalId() {
		return medicalId;
	}

	/**<b>Descripcion: </b> Retorna el valor del numero de identificacion
	 * @param medicalId Representa el nuevo numero de identificacion del medico
	 * */
	public void setMedicalId(int medicalId) {
		this.medicalId = medicalId;
	}

	/**<b>Descripcion: </b> Retorna el valor del primer nombre
	 * @return firstName retorna el primer nombre del medico
	 * */
	public String getFirstName() {
		return firstName;
	}

	/**<b>Descripcion: </b> Retorna el valor del primer nombre
	 * @param firstName Representa el nuevo primer nombre del medico
	 * */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**<b>Descripcion: </b> Retorna el valor del apellido
	 * @return lastName retorna el apellido del medico
	 * */
	public String getLastName() {
		return lastName;
	}

	/**<b>Descripcion: </b> Retorna el valor del apellido
	 * @param lastName Representa el nuevo apellido del medico
	 * */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**<b>Descripcion: </b> Retorna el valor de la especialidad
	 * @return speciality retorna la especialidad del medico
	 * */
	public String getSpecialty() {
		return specialty;
	}

	/**<b>Descripcion: </b> Retorna el valor de la especialidad
	 * @param specialty Representa la nueva especialidad del medico
	 * */
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	/**<b>Descripcion: </b> Retorna el valor de los años de experiencia
	 * @return yearsOfExperience retorna los años de experiencia del medico
	 * */
	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	/**<b>Descripcion: </b> Retorna el valor de los años de experiencia
	 * @param yearsOfExperience Representa los nuevo años de experiencia del medico
	 * */
	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	
	
}	
