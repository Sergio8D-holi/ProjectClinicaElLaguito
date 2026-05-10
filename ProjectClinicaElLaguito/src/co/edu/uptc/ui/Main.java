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

public class Main {

	public static void main(String[] args) {
		PatientService patientService = new PatientService(new PatientRepository());
		DoctorService doctorService =  new DoctorService(new DoctorRepository());
		MedicalAppoimentService medicalAppoimentService = new MedicalAppoimentService(new MedicalAppoimentRepository());
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
						
						patientService.addPatient(new Patient(patientIdType, (long) idPatient,
								firstNamePatient, lastNamePatient, emailPatient, medicationHistory
								, priorityPatient));
						break;

					case 2: 
						JOptionPane.showMessageDialog(null, patientService.findPatientById((long) Integer.parseInt(
								JOptionPane.showInputDialog(null,
								"Ingrese el id del paciente", JOptionPane.INFORMATION_MESSAGE))));;
						break;
						
					case 3:
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
						
						patientService.updatePatient(patientService.findPatientById(idPatientUpdate));
						
						break;
						
					case 4:
						patientService.deletePatient((long) Integer.parseInt(
								JOptionPane.showInputDialog(null,
								"Ingrese el id del paciente", JOptionPane.INFORMATION_MESSAGE)));
					
					case 5:
						patientService.findAll();
						break;
						
					case 6:
						flagPatient = false;
						break;
					
					default:
						break;
					}
				}
				break;
			case 2:
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
					
						
						doctorService.addDoctor(new Doctor(doctorIdType, (long) idDoctor, 
								firstNameDoctor, lastNameDoctor, specialityDoctor, yearsOfExperience));
						break;
						
					case 2:
						JOptionPane.showMessageDialog(null,doctorService.findDoctorById((long) Integer.parseInt(JOptionPane.showInputDialog(null,
								"Ingrese el id del medico"))));;
						break;
						
					case 3:
						
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
						
						doctorService.updateDoctor(doctorUpdate);
						
						break;
						
					case 4:
						doctorService.deleteDoctor((long) Integer.parseInt(JOptionPane.showInputDialog(null,
								"Ingrese el id del medico")));
						break;
					
					case 5:
						
						doctorService.findAll();
						break;
						
					case 6:
						flagDoctor = false;
						break;
						
					default:
						throw new IllegalArgumentException("Unexpected value: " + operationDoctor);
					}
				}
				
			case 3:
				boolean flagMedicalAppoiment = true;
				
				while (flagMedicalAppoiment) {
					int operationMedicalAppoiment = Integer.parseInt(JOptionPane.showInputDialog(
				            null,
				            "[1] Crear cita" + "\n[2] Buscar cita"	+ 
				            "\n[3] Actualizar cita" + "\n[4] Eliminar cita" + "\n[5] Listar cita"+
				            "\n[6] Salir al menú principal",
				            String.format(" ------- MENU DE CITAS MEDICAS-------",
				            JOptionPane.INFORMATION_MESSAGE)));
					
					switch (operationMedicalAppoiment) {
					case 1:
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
						
						medicalAppoimentService.addMedicalAppoiment(new MedicalAppoinmet((long) idMedicalAppoiment,
								dateAppoiment, patientAux, doctorAux));
						break;

					case 2:
						JOptionPane.showMessageDialog(null, 
						medicalAppoimentService.findMedicalAppoinmetById((long) Integer.parseInt(
						JOptionPane.showInputDialog(null, "Ingrese "
						+ "el id de la cita medica",JOptionPane.INFORMATION_MESSAGE))));;
						break;
						
					case 3: 
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
						
						medicalAppoinmetUpdate.setTimeAppoinmet(dateUpdateAppoiment);
						
						medicalAppoimentService.updateMedicalAppoinmet(medicalAppoinmetUpdate);
						break;
						
					case 4:
						medicalAppoimentService.findAll();
						break;
						
					case 5:
						flagMedicalAppoiment = false;
						break;
					default:
						break;
					}
				}
			case 4:
				flag = false;
				break;
				
			default:
				throw new IllegalArgumentException("Unexpected value: " + numberCrud);
			}
		}
		
	}

}
