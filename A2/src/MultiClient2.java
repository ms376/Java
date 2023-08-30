import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MultiClient2
{

	public static void main(String[] args) throws UnknownHostException, IOException
	{
		System.out.println("이름을 입력해주세요.");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		try
		{
			String ServerIP = "localhost";
			if (args.length > 0)
				ServerIP = args[0];
			Socket socket = new Socket(ServerIP, 9999);
			System.out.println("서버와 연결이 되었습니다......");
			Thread receiver = new Receiver(socket);
			receiver.start();
			
			Thread sender = new Sender(socket, name);
			sender.start();
		} catch (Exception e)
		{
			System.out.println("예외[MultiClient class]:" + e);
		}

	}

}
