
public class DataType {
	byte byteField;
	short shortField;
	int intField;
	long longField;
	float floatField;
	double doubleField;
	boolean booleanField;
	char charField;
	String stringField;
	int[] arrayField;
	
	public void printInfo() {
		System.out.println("byte : " + byteField);
		System.out.println("short : " + shortField);
		System.out.println("int : " + intField);
		System.out.println("long : " + longField);
		System.out.println("float : " + floatField);
		System.out.println("double : " + doubleField);
		System.out.println("bytboolean : " + booleanField);
		System.out.println("char : " + charField);
		System.out.println("string : " + stringField);
		System.out.println("array : " + arrayField);
	}
}
