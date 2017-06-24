import java.io.*;
import java.math.*;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Random;

public class SavePaintInfo {

	public static void main (String[] st)
	{
		try
		{
		new SavePaintInfo().SavePaintInfo();
		new SavePaintInfo().LoadPaintInfo();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	public void SavePaintInfo() throws FileNotFoundException, IOException
	{
		System.out.println("Data are being stored");
		System.out.println("Frederik Larsen");;
		FileOutputStream aFileStream=new FileOutputStream("C:\\coderevdr\\paintInf.txt");
		for (int nb=0; nb<10000; nb++)
		{
		aFileStream.write("Pixel X: ".getBytes());
		aFileStream.write(Integer.toString(new Random().nextInt(1024)).getBytes());
		aFileStream.write(" Y: ".getBytes());
		aFileStream.write(Integer.toString(new Random().nextInt(1024)).getBytes());
		aFileStream.write(" C: ".getBytes());
		aFileStream.write(Integer.toString(new Random().nextInt(2)).getBytes());
		aFileStream.write(";!".getBytes());
		}
		aFileStream.close();
	}
	public ArrayList<Pixel> LoadPaintInfo() throws FileNotFoundException, IOException
	{
	//	FileInputStream aFileStream=new FileInputStream("C:\\coderevdr\\paintInf.txt");
		FileReader et=new FileReader("C:\\coderevdr\\paintInf.txt");
		BufferedReader buf=new BufferedReader(et);
		StringBuffer enStringBuffer=new StringBuffer();
		int st3;
		while ((st3=buf.read())!=-1)
		{
			enStringBuffer.append((char)st3);
		}
		String ret=enStringBuffer.toString();
		//System.out.println(ret);
		et.close();
		System.out.println("---------------------------");
		String[] alle=ret.split("!");
		ArrayList<Pixel> returList=new ArrayList<Pixel>();
		for (int nb=0; nb < alle.length; nb++)
		{
			returList.add(hentInfoFra(alle[nb]));
		}
		return returList;
	}
	
	private Pixel hentInfoFra(String yes)
	{
		int x=Integer.parseInt(yes.substring(yes.indexOf("X: ")+3, yes.indexOf(" Y:")));
		int y=Integer.parseInt(yes.substring(yes.indexOf("Y: ")+3, yes.indexOf(" C:")));
		int c=Integer.parseInt(yes.substring(yes.indexOf("C: ")+3, yes.indexOf(";")));
		return new Pixel(x, y, c);
		//return null;
	}
	
}
