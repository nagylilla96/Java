package lab;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Disease implements Comparable<Disease>{
	Severity severity;
	String name;

	public Disease(String name, Severity severity) {
		this.name = name;
		this.severity = severity;
        System.out.println(name + " " + severity);
    }

	boolean cure() {
		Random rand = new Random();
		switch (severity) {
			case LOW:
				if (rand.nextInt(4) == 0) {
					return true;
				}
				else {
					return false;
				}
			case MEDIUM:
				if (rand.nextInt(2) == 0) {
					return true;
				}
				else {
					return false;
				}
			case HIGH:
				if (rand.nextInt(4) == 0) {
					return false;
				}
				else {
					return true;
				}
			default:
				break;
		}
		return false;
	}

	String getName() {
	    return this.name;
    }

	@Override
	public int compareTo(@NotNull Disease o) {
		return o.getName().compareTo(this.name);
	}
}
