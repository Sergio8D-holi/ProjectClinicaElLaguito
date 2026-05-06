package co.edu.uptc.service;

import java.util.Objects;
import java.util.Set;

import co.edu.uptc.domain.MedicalAppoinmet;
import co.edu.uptc.repository.MedicalAppoimentRepository;

public class MedicalAppoimentService {
	private MedicalAppoimentRepository medicalAppoimentRepository;

	public MedicalAppoimentService(MedicalAppoimentRepository medicalAppoimentRepository) {
		super();
		this.medicalAppoimentRepository = new MedicalAppoimentRepository();
	}
	
	public boolean addMedicalAppoiment(MedicalAppoinmet medicalAppoiment) {
		return this.medicalAppoimentRepository.addMedicalAppoinmet(medicalAppoiment);
	}
	
	public Set<MedicalAppoinmet> findAll() {
		return this.medicalAppoimentRepository.findAll();
	}
	
	public MedicalAppoinmet findMedicalAppoinmetById(Long idMedicalAppoinmet) {
		if(Objects.isNull(idMedicalAppoinmet)) {
			return null;
		}
		return this.medicalAppoimentRepository.findMedicalAppoinmetById(idMedicalAppoinmet);
	}
	
	public boolean updateMedicalAppoinmet(MedicalAppoinmet medicalAppoinmet) {
		MedicalAppoinmet oldMedicalAppoinmet = this.medicalAppoimentRepository.findMedicalAppoinmetById(medicalAppoinmet.getIdMedicalAppoinmet());
		if(!Objects.isNull(oldMedicalAppoinmet)) {
			this.medicalAppoimentRepository.updateMedicalAppoinmet(medicalAppoinmet);
			return true;
		}
		return false;
	}
	
	public boolean deleteMedicalAppoinmet(Long idMedicalAppoinmet) {
		if(Objects.isNull(idMedicalAppoinmet)) {
			return false;
		}
		return this.medicalAppoimentRepository.delete(idMedicalAppoinmet);
	}
}
