package d.datalog;

import java.io.File;

import com.declarativa.interprolog.*;
//refer to: https://github.com/sepehram/retro-security-openmrs/blob/master/retrosecurity/api/src/main/java/com/declarativa/interprolog/examples/HelloWorld.java
public class Demo {

	public static void main(String[] args) {

		XSBSubprocessEngine engine = new XSBSubprocessEngine(
				"D:\\XSB\\bin\\xsb64.bat");
		if (engine
				.deterministicGoal("javaMessage('java.lang.System'-out,println(string('Hello from Prolog, Java world!')))"))
			System.out.println("This goal succeeded");
		File f = new File("D:\\XSB\\prolog-commons\\p.P");
		engine.consultAbsolute(f);
		String RVars = "[TM]";
		Object[] c = null;
		SolutionIterator e = engine.goal("p(1,X),buildTermModel(X,TM)", "[TM]");
		while (e.hasNext()) {
			c = e.next();
			System.out.println(c[0]);
		}

		engine.shutdown();

	}
}
