package lab;

import org.jetbrains.annotations.NotNull;

public class Person{
	int ID;
	String name;	
	
	public Person(String name, int iD) throws InvalidDataException{
		super();
		if (iD >= 1000000 && iD <= 9999999) {
			ID = iD;
		}
		else {
			throw new InvalidDataException("7 characters long");
		}
		if (name.length() >= 6) {
			this.name = name;
		}
		else {
			throw new InvalidDataException("less than 6 characters long");
		}
	}
	
	public Person() throws InvalidDataException{
		this(null, 0);
	}

	public int getID() {
		return ID;
	}

	public String getName() {
		return name;
	}


}
