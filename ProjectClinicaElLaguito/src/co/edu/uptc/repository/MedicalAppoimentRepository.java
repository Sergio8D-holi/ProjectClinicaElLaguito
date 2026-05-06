package co.edu.uptc.repository;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import co.edu.uptc.domain.MedicalAppoinmet;

public class MedicalAppoimentRepository {
	private Set<MedicalAppoinmet> medicalAppoiments;
	
	public MedicalAppoimentRepository() {
		super();
	}

	public MedicalAppoimentRepository(Set<MedicalAppoinmet> medicalAppoiments) {
		super();
		this.medicalAppoiments = medicalAppoiments;
	}

	public boolean addMedicalAppoinmet(MedicalAppoinmet medicalAppoinmet) {
		return this.medicalAppoiments.add(medicalAppoinmet);
	}
	
	public Set<MedicalAppoinmet> findAll(){
		return new HashSet<>(medicalAppoiments);
	}
	
	public MedicalAppoinmet findMedicalAppoinmetById(Long idMedicalAppoinmet) {
		return this.medicalAppoiments.stream()
				.filter(d -> Objects.equals(d.getIdMedicalAppoinmet(), idMedicalAppoinmet) )
				.findFirst().orElse(null);
	}
	
	public void updateMedicalAppoinmet(MedicalAppoinmet newMedicalAppoinmet) {
		if (newMedicalAppoinmet == null || newMedicalAppoinmet.getIdMedicalAppoinmet() == 0) {
		    return;
		}
		/* Eliminamos el registro actual */
		this.medicalAppoiments.remove(newMedicalAppoinmet);
		/* Se agrega el nuevo producto */
		this.medicalAppoiments.add(newMedicalAppoinmet);
	}
	
	public boolean delete(Long idMedicalAppoinmet) {
		return this.medicalAppoiments.removeIf(medicalAppoiment-> 
			medicalAppoiment.getIdMedicalAppoinmet().equals(idMedicalAppoinmet));
	}
	
}
