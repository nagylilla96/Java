package lab;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Doctor extends Person implements Comparable<Doctor>{
	
	Integer nrOfDiseasesCured = 0;
	
	public Doctor(String name, int ID) throws InvalidDataException {
		super(name, ID);
		nrOfDiseasesCured = 0;
		// TODO Auto-generated constructor stub
	}
	
	public Doctor() throws InvalidDataException {
		super();
		nrOfDiseasesCured = 0;
	}

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    void tryToCure(Patient patient) {
		Random rand = new Random();
		int nrOfDiseasesCuring = rand.nextInt(patient.diseases.size() + 1);
		int i = 0;
		while (patient.diseases.iterator().hasNext() && i < nrOfDiseasesCuring) {
			Disease disease = patient.diseases.iterator().next();
			 if (disease.cure()) {
				if (patient.removeDisease(disease) == 1) {
                    nrOfDiseasesCured ++;
                }
			 }
			 i++;
		}
	}

	Integer getNrOfDiseasesCured() {
	    return this.nrOfDiseasesCured;
    }

    @Override
    public int compareTo(@NotNull Doctor o) {
        return o.getName().compareTo(this.getName());
    }

    @Override
    public boolean equals(Object obj) {
        return name.equals(((Doctor) obj).getName());
    }
}
