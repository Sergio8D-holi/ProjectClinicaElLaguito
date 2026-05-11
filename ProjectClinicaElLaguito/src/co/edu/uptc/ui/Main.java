package co.edu.uptc.ui;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;

import javax.swing.JOptionPane;

import co.edu.uptc.domain.Doctor;
import co.edu.uptc.domain.MedicalAppoinmet;
import co.edu.uptc.domain.Patient;
import co.edu.uptc.enums.IdentificationTypeEnum;
import co.edu.uptc.enums.PriorityEnum;
import co.edu.uptc.repository.DoctorRepository;
import co.edu.uptc.repository.MedicalAppoimentRepository;
import co.edu.uptc.repository.PatientRepository;
import co.edu.uptc.service.DoctorService;
import co.edu.uptc.service.MedicalAppoimentService;
import co.edu.uptc.service.PatientService;

/**
 * Nombre de la clase: Main
 *
 * <p>Calse que encarga de ejeccutar todo el programa </p>
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
public class Main {

	public static void main(String[] args) {
		/*Se crean las instancias de los pacientes, medicos y citas medicas*/
		PatientService patientService = new PatientService(new PatientRepository());
		DoctorService doctorService =  new DoctorService(new DoctorRepository());
		MedicalAppoimentService medicalAppoimentService = new MedicalAppoimentService(new MedicalAppoimentRepository());
		
		/*Menu del programa*/
		boolean flag = true;
		while (flag) {
			int numberCrud = Integer.parseInt(JOptionPane.showInputDialog(
		            null, 
		            "CLINICA EL LAGUITO" + "\n"+ 
		            "[1] Crud de pacientes\n[2] Crud de medicos\n[3] "
		            + "Crud de citas medicas\n[4] Salir "
		            + "", 
		            "MENU PRINCIPAL", 
		            JOptionPane.INFORMATION_MESSAGE
		        ));
			switch (numberCrud) {
			case 1: 
				
				/*Menu de las operaciones para los pacientes*/
				
				boolean flagPatient= true;
				
				while (flagPatient) {
				
					int operationPatient = Integer.parseInt(JOptionPane.showInputDialog(
				            null,
				            "[1] Crear paciente" + "\n[2] Buscar paciente"	+ 
				            "\n[3] Actualizar paciente" + "\n[4] Eliminar paciente" + "\n[5] Listar pacientes"+
				            "\n[6] Salir al menú principal",
				            String.format(" ------- MENU DE PACIENTES -------",
				            JOptionPane.INFORMATION_MESSAGE)));
					switch (operationPatient) {
					
					case 1:
						
						/*Operacion para crear un paciente*/
						IdentificationTypeEnum patientIdType = null;
						
						String optionPatientIdTypeString = JOptionPane.showInputDialog(
					            null,
					            "Ingrese el tipo de id del paciente" + "\n" + "1. Cedula de ciudadania" + "\n" + "2. Tarjeta de identidad" + 
					            "\n 3. Cedula de extranjeria" + "\n 4. Pasaporte",
					            "Agregar registro de paciente",
					            JOptionPane.INFORMATION_MESSAGE );
						
						int optionPatientIdType = Integer.parseInt(optionPatientIdTypeString);
						
						if (optionPatientIdType < 1 || optionPatientIdType > 4) {
							JOptionPane.showMessageDialog(null, "Valor invalido, el registro no se completo");
						}if (optionPatientIdType == 1) {
							patientIdType = IdentificationTypeEnum.CC;
						}if (optionPatientIdType == 2) {
							patientIdType = IdentificationTypeEnum.TI;
						}if (optionPatientIdType == 3) {
							patientIdType = IdentificationTypeEnum.CE;
						}if (optionPatientIdType == 4) {
							patientIdType = IdentificationTypeEnum.PA;
						}
						
						String idPatientString = JOptionPane.showInputDialog(
					            null,
					            "Digite el número de identificación del paciente : ",
					            "Agregar registro de paciente",
					            JOptionPane.INFORMATION_MESSAGE );

						int idPatient = Integer.parseInt(idPatientString);

						String firstNamePatient = JOptionPane.showInputDialog(
					            null, 
					            "Digite el primer nombre del paciente : ", 
					            "Agregar registro de paciente", 
					            JOptionPane.INFORMATION_MESSAGE );
						
						String lastNamePatient = JOptionPane.showInputDialog(
					            null, 
					            "Digite el apellido del paciente : ", 
					            "Agregar registro de paciente", 
					            JOptionPane.INFORMATION_MESSAGE );
						
						String emailPatient = JOptionPane.showInputDialog(
					            null, 
					            "Digite el email del cliente : ", 
					            "Agregar registro de cliente", 
					            JOptionPane.INFORMATION_MESSAGE );
					
						LinkedHashSet<String> medicationHistory = new LinkedHashSet<String>();
						
						medicationHistory.add(JOptionPane.showInputDialog(
					            null, 
					            "Digite la medicacion del paciente: ", 
					            "Agregar registro de paciente", 
					            JOptionPane.INFORMATION_MESSAGE ));
								
						PriorityEnum priorityPatient = null;
						
						String optionPatientPriorityString = JOptionPane.showInputDialog(
					            null,
					            "Ingrese la prioridad del paciente" + "\n" + "1. Baja" + "\n" + "2. Media" + 
					            "\n 3. Alta" + "\n 4. Critica",
					            "Agregar registro de paciente",
					            JOptionPane.INFORMATION_MESSAGE );
								int optionPatientPrority = Integer.parseInt(optionPatientPriorityString);
						
						if (optionPatientPrority < 1 || optionPatientPrority > 4) {
							JOptionPane.showMessageDialog(null, "Valor invalido, el registro no se completo");
						}if (optionPatientPrority == 1) {
							priorityPatient = PriorityEnum.LOW;
						}if (optionPatientPrority == 2) {
							priorityPatient = PriorityEnum.MEDIUM;
						}if (optionPatientPrority == 3) {
							priorityPatient = PriorityEnum.HIGH;
						}if (optionPatientPrority == 4) {
							priorityPatient = PriorityEnum.CRITICAL;
						}
						
						/*Se agrega el paciente al registro*/
						patientService.addPatient(new Patient(patientIdType, (long) idPatient,
								firstNamePatient, lastNamePatient, emailPatient, medicationHistory
								, priorityPatient));
						break;

					case 2: 
						
						/*Operacion para encontrar al paciente por id*/
						JOptionPane.showMessageDialog(null, patientService.findPatientById((long) Integer.parseInt(
								JOptionPane.showInputDialog(null,
								"Ingrese el id del paciente", JOptionPane.INFORMATION_MESSAGE))));;
						break;
						
					case 3:
						
						/*Opercion para obtener la nueva informacion del paciente*/
						String idPatientUpdateString = JOptionPane.showInputDialog(
					            null,
					            "Digite el número de identificación del paciente : ",
					            "Agregar registro de paciente",
					            JOptionPane.INFORMATION_MESSAGE );
						
						Long idPatientUpdate = (long) Integer.parseInt(idPatientUpdateString);

						Patient patientUpdate = patientService.findPatientById(idPatientUpdate);
						
						String firstNameUpdatePatient = JOptionPane.showInputDialog(
					            null, 
					            "Digite el primer nombre del paciente : ", 
					            "Agregar registro de paciente", 
					            JOptionPane.INFORMATION_MESSAGE );
						
						patientUpdate.setFirstName(firstNameUpdatePatient);
						
						String lastNameUpdatePatient = JOptionPane.showInputDialog(
					            null, 
					            "Digite el apellido del paciente : ", 
					            "Agregar registro de paciente", 
					            JOptionPane.INFORMATION_MESSAGE );
						
						patientUpdate.setLastName(lastNameUpdatePatient);
						
						String emailUpdatePatient = JOptionPane.showInputDialog(
					            null, 
					            "Digite el email del cliente : ", 
					            "Agregar registro de cliente", 
					            JOptionPane.INFORMATION_MESSAGE );
						
						patientUpdate.setEmail(emailUpdatePatient);
						
						patientUpdate.getMedicationHistory().add(JOptionPane.showInputDialog(
					            null, 
					            "Digite la medicacion del paciente: ", 
					            "Agregar registro de paciente", 
					            JOptionPane.INFORMATION_MESSAGE ));
								
						String optionUpdatePatientPriorityString = JOptionPane.showInputDialog(
					            null,
					            "Ingrese la prioridad del paciente" + "\n" + "1. Baja" + "\n" + "2. Media" + 
					            "\n 3. Alta" + "\n 4. Critica",
					            "Agregar registro de paciente",
					            JOptionPane.INFORMATION_MESSAGE );
								int optionUpdatePatientPrority = Integer.parseInt(optionUpdatePatientPriorityString);
						
						if (optionUpdatePatientPrority < 1 || optionUpdatePatientPrority > 4) {
							JOptionPane.showMessageDialog(null, "Valor invalido, el registro no se completo");
						}if (optionUpdatePatientPrority == 1) {
							patientUpdate.setPriority(PriorityEnum.LOW);
						}if (optionUpdatePatientPrority == 2) {
							patientUpdate.setPriority(PriorityEnum.MEDIUM);
						}if (optionUpdatePatientPrority == 3) {
							patientUpdate.setPriority(PriorityEnum.HIGH);
						}if (optionUpdatePatientPrority == 4) {
							patientUpdate.setPriority(PriorityEnum.CRITICAL);
						}
						
						/*Operacion para actualizar el paciente en el registro*/
						patientService.updatePatient(patientService.findPatientById(idPatientUpdate));
						
						break;
						
					case 4:
						
						/*Operacion para eliminar al paciente*/
						patientService.deletePatient((long) Integer.parseInt(
								JOptionPane.showInputDialog(null,
								"Ingrese el id del paciente", JOptionPane.INFORMATION_MESSAGE)));
					
					case 5:
						
						/*Operacion para mostrar los pacientes registrados*/
						patientService.findAll();
						break;
						
					case 6:
						
						/*Operacion para salir del menu de pacientes y volver al menu inicial*/
						flagPatient = false;
						break;
					
					default:
						break;
					}
				}
				break;
			case 2:
				
				/*Menu de las operaciones de los medicos*/
				boolean flagDoctor = true;
				while (flagDoctor) {
					int operationDoctor = Integer.parseInt(JOptionPane.showInputDialog(
				            null,
				            "[1] Crear medico" + "\n[2] Buscar medico"	+ 
				            "\n[3] Actualizar medico" + "\n[4] Eliminar medico" + "\n[5] Listar medico"+
				            "\n[6] Salir al menú principal",
				            String.format(" ------- MENU DE MEDICOS -------",
				            JOptionPane.INFORMATION_MESSAGE)));
					
					switch (operationDoctor) {
					case 1:

						/*Operacion para crear el nuevo medico*/
						IdentificationTypeEnum doctorIdType = null;
						
						String optionDoctorIdTypeString = JOptionPane.showInputDialog(
					            null,
					            "Ingrese el tipo de id del medico" + "\n" + "1. Cedula de ciudadania" + "\n" + "2. Tarjeta de identidad" + 
					            "3. Cedula de extranjeria" + "4. Pasaporte",
					            "Agregar registro de paciente",
					            JOptionPane.INFORMATION_MESSAGE );
						
						int optionDoctorIdType = Integer.parseInt(optionDoctorIdTypeString);
						
						if (optionDoctorIdType < 1 || optionDoctorIdType > 4) {
							JOptionPane.showMessageDialog(null, "Valor invalido, el registro no se completo");
						}if (optionDoctorIdType == 1) {
							doctorIdType = IdentificationTypeEnum.CC;
						}if (optionDoctorIdType == 2) {
							doctorIdType = IdentificationTypeEnum.TI;
						}if (optionDoctorIdType == 3) {
							doctorIdType = IdentificationTypeEnum.CE;
						}if (optionDoctorIdType == 4) {
							doctorIdType = IdentificationTypeEnum.PA;
						}
						
						String idDoctorString = JOptionPane.showInputDialog(
					            null,
					            "Digite el número de identificación del medico : ",
					            "Agregar registro de paciente",
					            JOptionPane.INFORMATION_MESSAGE );

						int idDoctor = Integer.parseInt(idDoctorString);

						String firstNameDoctor = JOptionPane.showInputDialog(
					            null, 
					            "Digite el primer nombre del medico: ", 
					            "Agregar registro de medico", 
					            JOptionPane.INFORMATION_MESSAGE );
						
						String lastNameDoctor = JOptionPane.showInputDialog(
					            null, 
					            "Digite el apellido del medico : ", 
					            "Agregar registro de medico", 
					            JOptionPane.INFORMATION_MESSAGE );

						String specialityDoctor = JOptionPane.showInputDialog(
					            null, 
					            "Digite la especialidad del medico: ", 
					            "Agregar registro de medico", 
					            JOptionPane.INFORMATION_MESSAGE );
						
						int yearsOfExperience = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese "
								+ "los años de experiencia del medico",
								"Agregar registro del medico"));
					
						/*Operacion para agregar al nuevo paciente*/
						doctorService.addDoctor(new Doctor(doctorIdType, (long) idDoctor, 
								firstNameDoctor, lastNameDoctor, specialityDoctor, yearsOfExperience));
						break;
						
					case 2:
						
						/*Operacion para mostar el doctor encpntrado por su id*/
						JOptionPane.showMessageDialog(null,doctorService.findDoctorById((long) Integer.parseInt(JOptionPane.showInputDialog(null,
								"Ingrese el id del medico"))));;
						break;
						
					case 3:
						 /*Operacion para obtener la nueva informacion del medico ya registrado*/
						String idDoctorUpdateString = JOptionPane.showInputDialog(
					            null,
					            "Digite el número de identificación del paciente : ",
					            "Agregar registro de paciente",
					            JOptionPane.INFORMATION_MESSAGE );
						
						Long idDoctorUpdate = (long) Integer.parseInt(idDoctorUpdateString);

						Doctor doctorUpdate = doctorService.findDoctorById(idDoctorUpdate);
						
						String firstNameUpdateDoctor = JOptionPane.showInputDialog(
					            null, 
					            "Digite el primer nombre del paciente : ", 
					            "Agregar registro de paciente", 
					            JOptionPane.INFORMATION_MESSAGE );
						
						doctorUpdate.setFirstName(firstNameUpdateDoctor);
						
						String lastNameUpdateDoctor = JOptionPane.showInputDialog(
					            null, 
					            "Digite el apellido del paciente : ", 
					            "Agregar registro de paciente", 
					            JOptionPane.INFORMATION_MESSAGE );
						
						doctorUpdate.setLastName(lastNameUpdateDoctor);
						
						String specialityUpdateDoctor = JOptionPane.showInputDialog(
					            null, 
					            "Digite el email del cliente : ", 
					            "Agregar registro de cliente", 
					            JOptionPane.INFORMATION_MESSAGE );
						
						doctorUpdate.setSpecialty(specialityUpdateDoctor);
						
						String yearsOfExperienceDoctorUpdateString = JOptionPane.showInputDialog(
					            null,
					            "Digite el número de identificación del paciente : ",
					            "Agregar registro de paciente",
					            JOptionPane.INFORMATION_MESSAGE );
						
						int yearsOfExpDoctorUpdate = Integer.parseInt(yearsOfExperienceDoctorUpdateString);
						
						doctorUpdate.setYearsOfExperience(yearsOfExpDoctorUpdate);
						
						/*se actualiza la informacion del medico en el registro*/
						doctorService.updateDoctor(doctorUpdate);
						
						break;
						
					case 4:
						
						/*Operacion para eliminar el medico*/
						doctorService.deleteDoctor((long) Integer.parseInt(JOptionPane.showInputDialog(null,
								"Ingrese el id del medico")));
						break;
					
					case 5:
						
						/*Mostrar los medicos ya registrados*/
						doctorService.findAll();
						break;
						
					case 6:
						
						/*Operacion para salir del menu de los medicos y volver al menu inicial*/
						flagDoctor = false;
						break;
						
					default:
						throw new IllegalArgumentException("Unexpected value: " + operationDoctor);
					}
				}
				
			case 3:
				
				/*Menu de las operaciones de las citas medicas*/
				boolean flagMedicalAppoiment = true;
				
				while (flagMedicalAppoiment) {
					int operationMedicalAppoiment = Integer.parseInt(JOptionPane.showInputDialog(
				            null,
				            "[1] Crear cita" + "\n[2] Buscar cita"	+ 
				            "\n[3] Actualizar cita" + "\n[4] Listar citas" + "\n[5] Eliminar cita"+
				            "\n[6] Salir al menú principal",
				            String.format(" ------- MENU DE CITAS MEDICAS-------",
				            JOptionPane.INFORMATION_MESSAGE)));
					
					switch (operationMedicalAppoiment) {
					case 1:
						
						/*Operacion para crear la cita medica*/
						int idMedicalAppoiment = Integer.parseInt(JOptionPane.showInputDialog(
					            null,
					            "Digite el número de identificación de la cita medica : ",
					            "Agregar registro de cita",
					            JOptionPane.INFORMATION_MESSAGE ));
						
						patientService.findAll();
						
						Patient patientAux =patientService.findPatientById((long) Integer.parseInt(JOptionPane.showInputDialog(null,
								"Ingrese el id del paciente que desea asignar a la cita",
								JOptionPane.INFORMATION_MESSAGE)));
						
						doctorService.findAll();
						
						Doctor doctorAux = doctorService.findDoctorById((long) Integer.parseInt(JOptionPane.showInputDialog(null,
								"Ingrese el id del medico que desea asignar a la cita",
								JOptionPane.INFORMATION_MESSAGE)));
						
						int month = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el mes "
								+ "de la cita medica",JOptionPane.INFORMATION_MESSAGE));
						
						int day = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dia "
								+ "de la cita medica",JOptionPane.INFORMATION_MESSAGE));
						
						int hour = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el hora "
								+ "de la cita medica",JOptionPane.INFORMATION_MESSAGE));
						
						int minutes = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese los minutos "
								+ "de la cita medica",JOptionPane.INFORMATION_MESSAGE));
						
						LocalDateTime dateAppoiment = LocalDateTime.of(2026, month, day, hour, minutes);
						
						/*Operacion para agregar la cita medica al registro*/
						medicalAppoimentService.addMedicalAppoiment(new MedicalAppoinmet((long) idMedicalAppoiment,
								dateAppoiment, patientAux, doctorAux));
						break;

					case 2:
						
						/*Operacion para encontrar una cita medica ya registrada*/
						JOptionPane.showMessageDialog(null, 
						medicalAppoimentService.findMedicalAppoinmetById((long) Integer.parseInt(
						JOptionPane.showInputDialog(null, "Ingrese "
						+ "el id de la cita medica",JOptionPane.INFORMATION_MESSAGE))));;
						break;
						
					case 3: 
						
						/*Operacion para obtener la nueva informacion de la cita medica ya registrada*/
						Long idUpdateMedicalAppoiment = (long) Integer.parseInt(JOptionPane.showInputDialog(
					            null,
					            "Digite el número de identificación de la cita medica : ",
					            "Agregar registro de cita",
					            JOptionPane.INFORMATION_MESSAGE ));
						
						MedicalAppoinmet medicalAppoinmetUpdate = medicalAppoimentService.findMedicalAppoinmetById(idUpdateMedicalAppoiment);
						
						patientService.findAll();
						
						medicalAppoinmetUpdate.setPatient(patientService.findPatientById((long) Integer.parseInt(JOptionPane.showInputDialog(null,
								"Ingrese el id del paciente que desea asignar a la cita",
								JOptionPane.INFORMATION_MESSAGE))));
						
						doctorService.findAll();
						
						medicalAppoinmetUpdate.setDoctor(doctorService.findDoctorById((long) Integer.parseInt(JOptionPane.showInputDialog(null,
								"Ingrese el id del medico que desea asignar a la cita",
								JOptionPane.INFORMATION_MESSAGE))));
						
						int monthUpdate = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el mes "
								+ "de la cita medica",JOptionPane.INFORMATION_MESSAGE));
						
						int dayUpdate = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dia "
								+ "de la cita medica",JOptionPane.INFORMATION_MESSAGE));
						
						int hourUpdate = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el hora "
								+ "de la cita medica",JOptionPane.INFORMATION_MESSAGE));
						
						int minutesUpdate = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese los minutos "
								+ "de la cita medica",JOptionPane.INFORMATION_MESSAGE));
						
						LocalDateTime dateUpdateAppoiment = LocalDateTime.of(2026, monthUpdate, dayUpdate, hourUpdate, minutesUpdate);
						
						medicalAppoinmetUpdate.setDateTimeAppoinmet(dateUpdateAppoiment);
						
						/*Operacion para actualizar la informacion de la cita medica en el registro*/
						medicalAppoimentService.updateMedicalAppoinmet(medicalAppoinmetUpdate);
						break;
						
					case 4:
						
						/*Operacion para mostrar las citas medicas registradas*/
						medicalAppoimentService.findAll();
						break;
						
					case 5:
						
						/*Operacion para eliminar la cita medica*/
						medicalAppoimentService.deleteMedicalAppoinmet((long)Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese El numero de id de la cita medica que desea eliminar")));
						break;
						
					case 6:
						/*Operacion para cerrar el menu de citas medicas y volver al menu inicial*/
						flagMedicalAppoiment = false;
						break; 
						
					default:
						break;
					}
				}
			case 4:
				
				/*Operacon para cerrar el programa*/
				flag = false;
				break;
				
			default:
				throw new IllegalArgumentException("Unexpected value: " + numberCrud);
			}
		}
		
	}

}
