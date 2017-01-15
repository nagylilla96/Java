package lab;
import com.intellij.openapi.diff.impl.patch.PatchEP;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Patient extends Person implements Comparable<Patient>{

    Set<Disease> diseases = new TreeSet<>();
    Integer nrOfDiseases = 0;

    public Patient(String name, int ID) throws InvalidDataException{
        super(name, ID);
        System.out.println(name + " " + ID);

    }

    public Patient() throws InvalidDataException {
        super();
        // TODO Auto-generated constructor stub
    }

    void addDisease(Disease disease) {
        diseases.add(disease);
        nrOfDiseases = diseases.size();
    }

    boolean isCured(Disease disease) {
        if (diseases.contains(disease)) {
            return disease.cure();
        }
        return false;
    }

    Set<Disease> getDiseases() {
        return this.diseases;
    }
    int removeDisease(Disease disease) {
        if (isCured(disease)) {
            if (diseases.remove(disease)){
                System.out.println("Disease removed: " + disease.getName());
                return 1;
            }
            System.out.println("Disease not removed " + disease.getName());
            return 0;
        }
        return 0;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    Integer getNrOfDiseases() {
        return this.nrOfDiseases;
    }

    @Override
    public int compareTo(@NotNull Patient o) {
        return o.getName().compareTo(this.getName());
    }

    @Override
    public boolean equals(Object obj) {
        return name.equals(((Patient) obj).getName());
    }
}
