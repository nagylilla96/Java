package lab;

import javax.print.Doc;
import java.util.*;

public class Hospital{
	Set<Doctor> doctors = new TreeSet<>();
	Set<Patient> patients = new TreeSet<>();
	
	public Hospital() {
		super();
	}
	
	void addDoctor(Doctor doctor) throws InvalidDataException {
		doctors.add(doctor);
		System.out.println(doctor.getName() + " " + doctor.getID());
	}
	
	void addPatient(Patient patient) {
		patients.add(patient);
	}

	Patient returnPatient(String name) {
		for (Patient i: patients) {
			if (i.getName().equals(name)) {
				return i;
			}
		}
		return null;
	}

	void startHealing() {
		for (Doctor i : doctors) {
			for (Patient j : patients) {
			i.tryToCure(j);
			}
		}		
	}
	
	void listPatients(){
		List<Patient> sortedList = new ArrayList(patients);
		sortedList.sort(new PatientComp());
		for (Patient i : sortedList) {
			System.out.println(i.getName() + " " + i.getID());
			for(Disease j: i.getDiseases())
				System.out.println(" " + j.name);
		}
	}
	
	void listDoctors() {
		List<Doctor> sortedList = new ArrayList(doctors);
		sortedList.sort(new DoctorComp());
		System.out.println(doctors.size());
		for (Doctor i : sortedList) {
			System.out.println(i.getName() + " " + i.getID() + " " + i.getNrOfDiseasesCured());
		}
	}
	
	void statistics() {
		int nrOfSickPatients = 0;
		int nrOfDiseasesNotCured = 0;
		for (Patient i : patients) {
			if (i.diseases.size() != 0) {
				nrOfSickPatients ++;
				nrOfDiseasesNotCured += i.diseases.size();
			}
		}
		System.out.println("Statistics: sick patients: " + nrOfSickPatients + " diseases not cured: " + nrOfDiseasesNotCured);
	}
}

class DoctorComp implements Comparator<Doctor>{

	@Override
	public int compare(Doctor o1, Doctor o2) {
		return o1.getNrOfDiseasesCured().compareTo(o2.getNrOfDiseasesCured());
	}
}

class PatientComp implements Comparator<Patient> {

	@Override
	public int compare(Patient o1, Patient o2) {
		return o1.getNrOfDiseases().compareTo(o2.getNrOfDiseases());
	}
}