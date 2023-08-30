package step07;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MyPhoneBook
{
	static Scanner sc = new Scanner(System.in);
	static Map<String, Phoneinfo> map = new HashMap<>();

	public static void showmenu()
	{
		System.out.println("[메뉴선택]");
		System.out.println("1. 전화번호 입력");
		System.out.println("2. 전화번호 조회");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 종료");
		System.out.print("선택 : ");
	}

	public static void addNumber()
	{
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("전화번호 : ");
		String phoneNumber = sc.nextLine();
		System.out.print("이메일 : ");
		String email = sc.nextLine();

		Phoneinfo pInfo;
		if (email != null)
		{
			pInfo = new Phoneinfo(name, phoneNumber, email);
		} else
		{
			pInfo = new Phoneinfo(name, phoneNumber);
		}
//		pInfo.showPhoneInfo();
		map.put(name, pInfo);
//		System.out.println("맵의 크기 : " + map.size());
	}

	public static void selNumber()
	{
		System.out.print("조회할 이름 : ");
		String name = sc.nextLine();
		try
		{
			Phoneinfo pInfo = map.get(name);
			pInfo.showPhoneInfo();
			
		} catch (Exception e)
		{
			System.out.println("저장되지 않은 이름입니다.");
		}
//		Set<String> ks = map.keySet();
//		for (String s : ks)
//			System.out.println(map.get(s).toString());
//		System.out.println("--------------------------");

	}

	public static void delNumber()
	{
		System.out.println("삭제할 이름 : ");
		String name = sc.nextLine();
		Phoneinfo pInfo = map.remove(name);
		if (pInfo != null)
		{
			System.out.println("삭제되었습니다.");
//			pInfo.showPhoneInfo()
		} else
		{
			System.out.println("해당 값이 없습니다.");
		}

	}

	public static void main(String[] args)
	{
		readInfo();
		int choice;
		while (true)
		{
			showmenu();
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice)
			{
			case 1:
				addNumber();
				break;
			case 2:
				selNumber();
				break;
			case 3:
				delNumber();
				break;
			case 4:
				saveInfo();
				System.out.println("프로그램을 종료합니다.");
				return;

			default:
				System.out.println("잘못입력하셨습니다.");
				break;
			}
		}

	}

	public static void saveInfo()
	{
		try (ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream("./bin/step07/Object.bin")))
		{
			Set<String> ks = map.keySet();
			for (String s : ks)
			{
				Phoneinfo pInfo = map.get(s);
				oo.writeObject(pInfo);
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	public static void readInfo()
	{
		try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream("./bin/step07/Object.bin")))
		{
			while (true)
			{
				Phoneinfo pInfo = (Phoneinfo) oi.readObject();
				if (pInfo == null)
					break;
				map.put(pInfo.name, pInfo);
			}
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
//			e.printStackTrace();
		}
	}

}
