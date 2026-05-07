package co.edu.uptc.ui;

import java.util.LinkedHashSet;

import javax.swing.JOptionPane;

import co.edu.uptc.domain.Patient;
import co.edu.uptc.enums.IdentificationTypeEnum;
import co.edu.uptc.enums.PriorityEnum;
import co.edu.uptc.service.DoctorService;
import co.edu.uptc.service.MedicalAppoimentService;
import co.edu.uptc.service.PatientService;

public class Main {

	public static void main(String[] args) {
		PatientService patientService = new PatientService();
		DoctorService doctorService =  new DoctorService();
		MedicalAppoimentService medicalAppoimentService = new MedicalAppoimentService();
		boolean flag = true;
		while (flag) {
			int numberCrud = Integer.parseInt(JOptionPane.showInputDialog(
		            null, 
		            "CLINICA EL LAGUITO" + "\n"+ 
		            "[1] Crud de pacientes\n[2] Crud de medicos\n[3] Crud de citas medicas\n[4] Salir "
		            + "", 
		            "MENU PRINCIPAL", 
		            JOptionPane.INFORMATION_MESSAGE
		        ));
			switch (numberCrud) {
			case 1: {
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
				            "Ingrese el tipo de empleado" + "\n" + "1. Cedula de ciudadania" + "\n" + "2. Tarjeta de identidad" + 
				            "3. Cedula de extranjeria" + "4. Pasaporte",
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
				
					LinkedHashSet<String> medicationHistory;
					
					medicationHistory.add(JOptionPane.showInputDialog(
				            null, 
				            "Digite la medicacion del paciente: ", 
				            "Agregar registro de paciente", 
				            JOptionPane.INFORMATION_MESSAGE ));
							
					PriorityEnum priorityPatient = null;
					
					String optionPatientPriorityString = JOptionPane.showInputDialog(
				            null,
				            "Ingrese la prioridad del paciente" + "\n" + "1. Baja" + "\n" + "2. Media" + 
				            "3. Alta" + "4. Critica",
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
					patientService.findPatientById((long) Integer.parseInt(
							JOptionPane.showInputDialog(null,
							"Ingrese el id del paciente", JOptionPane.INFORMATION_MESSAGE)));
					break;
					
				case 3:
					IdentificationTypeEnum newPatientIdType = null;
					
					String optionNewPatientIdTypeString = JOptionPane.showInputDialog(
				            null,
				            "Ingrese el tipo de id" + "\n" + "1. Cedula de ciudadania" + "\n" + "2. Tarjeta de identidad" + 
				            "3. Cedula de extranjeria" + "4. Pasaporte",
				            "Agregar registro de paciente",
				            JOptionPane.INFORMATION_MESSAGE );
					
					int optionNewPatientIdType = Integer.parseInt(optionNewPatientIdTypeString);
					
					if (optionNewPatientIdType < 1 || optionNewPatientIdType > 4) {
						JOptionPane.showMessageDialog(null, "Valor invalido, el registro no se completo");
					}if (optionNewPatientIdType == 1) {
						newPatientIdType = IdentificationTypeEnum.CC;
					}if (optionNewPatientIdType == 2) {
						newPatientIdType = IdentificationTypeEnum.TI;
					}if (optionPatientIdType == 3) {
						newPatientIdType = IdentificationTypeEnum.CE;
					}if (optionNewPatientIdType == 4) {
						newPatientIdType = IdentificationTypeEnum.PA;
					}
					
					String idNewPatientString = JOptionPane.showInputDialog(
				            null,
				            "Digite el número de identificación del paciente : ",
				            "Agregar registro de paciente",
				            JOptionPane.INFORMATION_MESSAGE );

					int idNewPatient = Integer.parseInt(idNewPatientString);

					String firstNameNewPatient = JOptionPane.showInputDialog(
				            null, 
				            "Digite el primer nombre del paciente : ", 
				            "Agregar registro de paciente", 
				            JOptionPane.INFORMATION_MESSAGE );
					
					String lastNameNewPatient = JOptionPane.showInputDialog(
				            null, 
				            "Digite el apellido del paciente : ", 
				            "Agregar registro de paciente", 
				            JOptionPane.INFORMATION_MESSAGE );
					
					String emailNewPatient = JOptionPane.showInputDialog(
				            null, 
				            "Digite el email del cliente : ", 
				            "Agregar registro de cliente", 
				            JOptionPane.INFORMATION_MESSAGE );
				
					LinkedHashSet<String> newMedicationHistory;
					
					medicationHistory.add(JOptionPane.showInputDialog(
				            null, 
				            "Digite la medicacion del paciente: ", 
				            "Agregar registro de paciente", 
				            JOptionPane.INFORMATION_MESSAGE ));
							
					PriorityEnum priorityNewPatient = null;
					
					String optionNewPatientPriorityString = JOptionPane.showInputDialog(
				            null,
				            "Ingrese la prioridad del paciente" + "\n" + "1. Baja" + "\n" + "2. Media" + 
				            "3. Alta" + "4. Critica",
				            "Agregar registro de paciente",
				            JOptionPane.INFORMATION_MESSAGE );
							int optionNewPatientPrority = Integer.parseInt(optionNewPatientPriorityString);
					
					if (optionNewPatientPrority < 1 || optionNewPatientPrority > 4) {
						JOptionPane.showMessageDialog(null, "Valor invalido, el registro no se completo");
					}if (optionNewPatientPrority == 1) {
						priorityNewPatient = PriorityEnum.LOW;
					}if (optionNewPatientPrority == 2) {
						priorityNewPatient = PriorityEnum.MEDIUM;
					}if (optionNewPatientPrority == 3) {
						priorityNewPatient = PriorityEnum.HIGH;
					}if (optionNewPatientPrority == 4) {
						priorityNewPatient = PriorityEnum.CRITICAL;
					}
					
					patientService.updatePatient(new Patient(newPatientIdType, (long)idNewPatient, firstNamePatient,
							lastNameNewPatient, emailNewPatient, newMedicationHistory, priorityNewPatient));
				
				case 4:
					patientService.deletePatient((long) Integer.parseInt(
							JOptionPane.showInputDialog(null,
							"Ingrese el id del paciente", JOptionPane.INFORMATION_MESSAGE)));
				
				case 5:
					JOptionPane.showMessageDialog(null, patientService.findAll());;
				
				default:
					break;
				}
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + numberCrud);
			}
			int operacion = Integer.parseInt(JOptionPane.showInputDialog(
		            null,
		            "[1] Crear "+ this.nameEntity + "\n[2] Buscar " + this.nameEntity
					+ "\n[3] Actualizar " + this.nameEntity + "\n[4] Eliminar " + this.nameEntity +
					"\n[5] Salir al menú principal",
		            String.format(" ------- MENU DE %s -------", nameEntity.toUpperCase()),
		            JOptionPane.INFORMATION_MESSAGE
		        ));
		}
		
	}

}
