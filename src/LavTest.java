
import org.junit.runner.JUnitCore;

import org.junit.runner.Result;

import org.junit.runner.notification.Failure;

public class LavTest {
	
public static void main(String[] argv)
	{
	System.out.println("ert");
	Result result=JUnitCore.runClasses(TestClass.class);
	System.out.println(result.wasSuccessful());
	}
}
