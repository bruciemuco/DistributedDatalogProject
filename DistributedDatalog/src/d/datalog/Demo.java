package d.datalog;

import java.io.File;

import com.declarativa.interprolog.*;

public class Demo {

	public static void main(String[] args){
		
		XSBSubprocessEngine engine = new XSBSubprocessEngine("D:\\XSB\\bin\\xsb64.bat");
		if (engine.deterministicGoal("javaMessage('java.lang.System'-out,println(string('Hello from Prolog, Java world!')))"))
			System.out.println("This goal succeeded");
		File f = new File("D:\\XSB\\prolog-commons\\p.P");
		engine.consultAbsolute(f );
		String RVars = null;
		Object[] c = null;
		c = engine.deterministicGoal("p(1,X)", RVars);
		System.out.println(c[0]);
		SolutionIterator e = engine.goal("p(1,X)", RVars);
		String x = e.toString();
		
		
		engine.shutdown();
		
		
		
	}
}
