import java.util.Random;
import java.util.Scanner;

//일명 : QuUpDownGame.java
//
//게임설명 : 업다운게임을 메소드를 이용해 구현한다.
//컴퓨터는 1~100사이의 숫자 하나를 생성한다.
//총 시도횟수는 7번을 부여한다.
//사용자는 7번의 시도안에 숫자를 맞춰야 한다.
//사용자가 숫자를 입력했을때 컴퓨터는 높은지/낮은지 알려준다.
//7번안에 맞추면 성공, 맞추지 못하면 실패라고 출력한다.
//성공/실패 후 계속 할지를 물어보고 1이면 게임 재시작, 0이면 프로그램을 종료한다.
//함수를 사용하여 구현한다.
//무한루프에 빠지게 된다면 scan.nextLine()을 활용하여 버퍼에 남아있는 Enter키를 제거해주도록 하자.

public class QuUpDownGame
{

	public static void main(String[] args)
	{
		Random random = new Random();
		Scanner scan = new Scanner(System.in);
		int restart;
		boolean forEnd = false;
		// 무한루프안에서 사용자가 7번 안에 맞추는지.
		while (true)
		{
//			 난수생성 1~100 사이에 난수를 생성한다.
			int computerNum = random.nextInt(1000) % 100 + 1;
//			System.out.println(computerNum); // 답확인용
			// 총 7번 반복.
			for (int i = 1; i <= 7; i++)
			{
				// 사용자 입력
				System.out.println("1~100 사이 숫자 입력");
				int userNum = scan.nextInt();
				// 성공 실패
				if (userNum < computerNum)
				{
					// 내가 입력한 숫자가 높다면.
					System.out.println("숫자보다 높다");
				} else if (userNum > computerNum)
				{
					// 내가 입력한 숫자가 낮다면.
					System.out.println("숫자보다 낮다");
				} else
				{
					System.out.println("이걸맞추네");
					System.out.println(i + " 번 안에 성공!");
					System.out.println("=================================");
					// 사용자가 숫자를 맞추었을 때만 true로 변경한다.
					forEnd = true;
					// for 문 탈출
					break;
				}
			} // 재시작 for
				// false를 유치하고 있다면 맞추지 못한 경우이므로 실패처리
			if (forEnd == false)
			{
				System.out.println("실패했어 잘좀 해봐.");
			}
			while (true)
			{
				// 1과 0을 입력하지 않으면 계속 재입력을 요구한다.
				System.out.println("---------------------------------");
				System.out.println("게임 재시작 (1) / 종료 (0)");
				System.out.println("---------------------------------");
				System.out.print("또 할래?");
				restart = scan.nextInt();
				// 0과 1일 입력 되었을 때는 탈출
				try
				{
					if (restart == 0)
					{
						System.out.println("게임종료.");
						break;
					} else if (restart == 1)
					{
						System.out.println("ㄱㄱ");
						break;
					}
				} catch (Exception e)
				{
					System.out.println("잘못 입력되었습니다.");
				}
			}

		}
	}
}
