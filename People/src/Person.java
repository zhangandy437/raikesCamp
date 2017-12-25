
public class Person {

	private static int age;
	private String firstName;
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public static void setAge(int age) {
		Person.age = age;
	}

	public static int getAge() {
		return Person.age;
	}
	public void tell() {
		System.out.println("Age: " + Person.age + "\nFirstName: " + this.firstName + "\nLastName:" + this.lastName);
	}
}
