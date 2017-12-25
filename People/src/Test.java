
public class Test {
	public static void main(String[] args){
		Person person = new Person();
		person.setFirstName("Stupid");
		person.setLastName("Dumb Dumb");
		changeName(person);
		System.out.println(person.getFirstName());
		int age = 27;
		changeAge(age);
		System.out.println(age);
	}
	
	private static void changeName(Person human){
		human.setFirstName("Orange");
	}
	
	private static void changeAge(int x){
		x = 15;
	}
}
