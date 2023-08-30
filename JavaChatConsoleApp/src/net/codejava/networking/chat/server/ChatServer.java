package net.codejava.networking.chat.server;

import java.io.*;
import java.net.*;
import java.util.*;


//채팅 서버 프로그램입니다.
//Ctrl + C를 눌러 프로그램을 종료합니다.

public class ChatServer{
	private int port;
	private Set<String> userNames = new HashSet<>();
	private Set<UserThread> userThreads = new HashSet<>();

public static void main(String[] args) {
		
		Socket socket = null;
		BufferedReader in = null;
		BufferedWriter out = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			// 1. 클라이언트 소켓 생성 및 서버 접속
			Socket clientSocket = new Socket("localhost", 9999);
			
			// 2. 네트워크 입출력 스트림 생성
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
			
			// 3. 서버로 데이터 전송 (클라이언트->서버)
			while(true) {
				System.out.print("보내기 >> ");
				String outMsg = sc.nextLine();
				
				if(outMsg.equalsIgnoreCase("bye")) {
					out.write(outMsg + "\n");
					out.flush();
					break;
				}
				
				// 정상 메시지의 경우
				out.write(outMsg + "\n");
				out.flush();
				
			// 4. 서버로부터 데이터 수신 (서버->클라이언트)	
				String inMsg = in.readLine();
				System.out.println("서버 >> " + inMsg);
				
			}
	
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 5. 접속 종료
			
			try {
				sc.close();
				out.close();
				in.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
		
	}

//	public ChatServer() {
//		try  {
//			@SuppressWarnings("resource")
//			ServerSocket ss = new ServerSocket(9999);
//			System.out.println("채팅 서버가 포트에서 수신 중입니다. " + port);
//
//			while (true) {
//				Socket socket = ss.accept();
//				System.out.println("새로운 사용자 연결되었습니다.");
//
//				UserThread newUser = new UserThread(socket, this);
//				userThreads.add(newUser);
//				newUser.start();
//
//			}
//
//		} catch (IOException ex) {
//			System.out.println("서버에러: " + ex.getMessage());
//			ex.printStackTrace();
//		}
//	}


	/**
	 * Delivers a message from one user to others (broadcasting)
	 */
	void broadcast(String message, UserThread excludeUser) {
		for (UserThread aUser : userThreads) {
			if (aUser != excludeUser) {
				aUser.sendMessage(message);
			}
		}
	}

	/**
	 * Stores username of the newly connected client.
	 */
	void addUserName(String userName) {
		userNames.add(userName);
	}

	/**
	 * When a client is disconneted, removes the associated username and UserThread
	 */
	void removeUser(String userName, UserThread aUser) {
		boolean removed = userNames.remove(userName);
		if (removed) {
			userThreads.remove(aUser);
			System.out.println("The user " + userName + " quitted");
		}
	}

	Set<String> getUserNames() {
		return this.userNames;
	}

	/**
	 * Returns true if there are other users connected (not count the currently connected user)
	 */
	boolean hasUsers() {
		return !this.userNames.isEmpty();
	}
}