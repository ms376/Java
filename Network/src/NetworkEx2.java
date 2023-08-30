import java.net.*;

public class NetworkEx2
{
	public static void main(String[] args)
	{
		URL url = null;
		String address = "http://www.enjoypuzzle.com:80/" + "board/bbsview/nemonotice/260/1#1";
		try
		{
			url = new URL(address);
			URLConnection conn = url.openConnection();

			System.out.println("conn.toString(): " + conn);
			// getAlloewUserInteraction 사용자 상호작용) 의 허용여부를 반환
			System.out.println("getAlloewUserInteraction():" + conn.getAllowUserInteraction());
			// getConnectTimeout 연결 종료시간을 천분의 일초로 반환
			System.out.println("getConnectTimeout():" + conn.getConnectTimeout());
			// getContent content객체를 반환한다.
			System.out.println("getContent():" + conn.getContent());
			// getContentEncoding content의 인코딩을 반환한다.
			System.out.println("getContentEncoding():" + conn.getContentEncoding());
			// getContentLength content의 크기를 반환
			System.out.println("getContentLength():" + conn.getContentLength());
			// getContentType content의 type을 반환.
			System.out.println("getContentType():" + conn.getContentType());
			// getDate 헤더(header)의 date필드의 값을 반환한다.
			System.out.println("getDate():" + conn.getDate());
			// getDefaultUseCaches userCache의 디폴트값을 얻는다.
			System.out.println("getDefaultUseCaches():" + conn.getDefaultUseCaches());
			// getDoInput doinput 필드값을 얻는다
			System.out.println("getDoInput():" + conn.getDoInput());
			// getDoOutput doQutput 필드값을 얻는다
			System.out.println("getDoOutput():" + conn.getDoOutput());
			// getExpiration 자원(URL)의 만료일자를 얻는다.(천분의 일초단위)
			System.out.println("getExpiration():" + conn.getExpiration());
			// getHeaderFields (int n) 혜더의 n번째 필드를 읽어온다.
			// getHeaderFields (String name) 혜더의 n번째 필드를 읽어온다.
			System.out.println("getHeaderFields():" + conn.getHeaderFields());
			// getIfModifiedSince(변경여부) 필드의 값을반환.
			System.out.println("getIfModifiedSince():" + conn.getIfModifiedSince());
			// getLastModified 최종 변경일 필드의 값을 반환.
			System.out.println("getLastModified():" + conn.getLastModified());
			// getReadTimeout 읽기 제한시간의 값을 반환한다.
			System.out.println("getReadTimeout():" + conn.getReadTimeout());
			// getURL URLConnection의 URL을 반환한다.
			System.out.println("getURL():" + conn.getURL());
			// getUseCaches cache의 사용여부를 반환한다.
			System.out.println("getUseCaches():" + conn.getUseCaches());

		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
