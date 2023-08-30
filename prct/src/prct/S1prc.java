package prct;

import java.io.IOException;

public class S1prc

//	하나의 문자를 입력받아 숫자인지 여부를 판단하는 프로그램을 삼항연산자를 이용하여
//	구현하시오.
//	(System.in.read()를 사용하세요)

{
	public static void main(String[] args) throws IOException
	{
		System.out.println("입력");
		int a = System.in.read();
		if (a>='0'&&a<='9')
		{
			System.out.println("숫");
		} else
		{
			System.out.println("문");
		}
	}
}
