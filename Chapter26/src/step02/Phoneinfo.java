package step02;

public class Phoneinfo
{
	String name;
	String phoneNumber;
	String email;

	public Phoneinfo(String name, String phoneNumber) // 생성자
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public Phoneinfo(String name, String phoneNumber, String email)
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	public void showPhoneInfo()
	{
		System.out.println("Name : "+name);
		System.out.println("PhoneNumber : "+phoneNumber);
		if (email != null)
			System.out.println("Email : "+email);
		System.out.println("--------------------------------");
	}
}
