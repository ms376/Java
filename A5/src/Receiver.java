import java.io.*;
import java.net.*;

public class Receiver extends Thread
{
	Socket socket;
	BufferedReader in = null;

	public Receiver(Socket socket)
	{
		this.socket = socket;

		try
		{
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		} catch (Exception e)
		{
			System.out.println("예외:" + e);
		}
	}
	@Override
	public void run()
	{
		while (in != null)
		{
			try
			{
//			} catch (Exception e)
//			{
//				System.out.println("예외2:"+e);
//			}
//		}
//		try
//		{
//			in.close();
				System.out.println("Thread Receive : " + in.readLine());
			} catch (java.net.SocketException ne)
			{
				break;
			} catch (Exception e)
			{
				System.out.println("예외:" + e);
			}
		}
		try
		{
			in.close();
		} catch (Exception e)
		{
			System.out.println("예외3:" + e);
		}

	}
}
