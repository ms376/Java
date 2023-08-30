import java.net.*;
import java.io.*;

//채팅 클라이언트 프로그램입니다. 
//프로그램을 종료하려면 'bye'를 입력하십시오.

public class ChatClient {
	private String hostname;
	private int port;
	private String userName;

	public ChatClient(String hostname, int port) {
		this.hostname = hostname;
		this.port = port;
	}

	public void execute() {
		try {
			Socket socket = new Socket(hostname, port);

			System.out.println("서버에 연결되었습니다.");

			new ReadThread(socket, this).start();
			new WriteThread(socket, this).start();

		} catch (UnknownHostException ex) {
			System.out.println("서버를 찾지 못했습니다: " + ex.getMessage());
		} catch (IOException ex) {
			System.out.println("I/O 오류: " + ex.getMessage());
		}

	}

	void setUserName(String userName) {
		this.userName = userName;
	}

	String getUserName() {
		return this.userName;
	}


	public static void main(String[] args) {
		if (args.length < 2) return;

		String hostname = args[0];
		int port = Integer.parseInt(args[1]);

		ChatClient client = new ChatClient(hostname, port);
		client.execute();
	}
}