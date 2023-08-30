package step01;

public class MyPhoneBook
{

	public static void main(String[] args)
	{
		Phoneinfo pInfo1=new Phoneinfo("손오공", "010-1234-5678", "test@test.com");
		Phoneinfo pInfo2=new Phoneinfo("손우치", "010-4321-8765");
		pInfo1.showPhoneInfo();
		pInfo2.showPhoneInfo();
	
	}

}
