import java.util.*; 
import java.security.*; 
import java.io.*; 

//testing MD5 hash on file contents
//
public class MD5Hash
{
	public static void main(String[] args) throws NoSuchAlgorithmException
	{
		String s = "Cameron";
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(s.getBytes());
		byte[] b = md.digest(); 

		for(byte by: b)
		{
			System.out.println(by);
		}

		File file = new File("dummyfile.txt");
		FileInputStream fin = null;
		System.out.println("---------");
		try
		{
			fin = new FileInputStream(file);
			byte[] content = new byte[256];
			fin.read(content);
			for(byte byt: content)
			{
				String bt = new String(content);
				System.out.println(Integer.toHexString(byt & 0xFF).toString() + " "+bt);
			}
		}

		catch(FileNotFoundException e)
		{
			System.out.println("file not found");
		}

		catch(IOException i)
		{
			System.out.println("io");
		}

	}
}
