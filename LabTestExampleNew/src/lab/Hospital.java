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
	
	Patient addPatient(Patient patient) {
		patients.add(patient);
		return patient;
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
	
	String listPatients(){
		List<Patient> sortedList = new ArrayList(patients);
		String string = "";
		sortedList.sort(new PatientComp());
		for (Patient i : sortedList) {
		    string = string + "<br>" + i.getName() + " " + i.getID();
			for(Disease j: i.getDiseases())
                    string = string + " " + j.name;
		}
        string = "<html><body>" + string + "</body></html>";
        return string;
	}
	
	String listDoctors() {
		List<Doctor> sortedList = new ArrayList(doctors);
		sortedList.sort(new DoctorComp());
		String string = "";
		System.out.println(doctors.size());
		for (Doctor i : sortedList) {
			string = string + i.getName() + " " + i.getID() + " " + i.getNrOfDiseasesCured() + "<br>";
		}
		string = "<html><body>" + string + "</body></html>";
		return string;
	}
	
	String statistics() {
		int nrOfSickPatients = 0;
		int nrOfDiseasesNotCured = 0;
		String string = "";
		for (Patient i : patients) {
			if (i.diseases.size() != 0) {
				nrOfSickPatients ++;
				nrOfDiseasesNotCured += i.diseases.size();
			}
		}
		string += "<html><body><br>Statistics: sick patients: " + nrOfSickPatients + " diseases not cured: " + nrOfDiseasesNotCured + "</body></html>";
		return string;
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