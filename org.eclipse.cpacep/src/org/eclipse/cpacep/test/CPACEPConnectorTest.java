package org.eclipse.cpacep.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import org.eclipse.cpacep.util.CPACEPConnector;
import org.eclipse.cpacep.util.FileHandler;
import org.junit.Before;
import org.junit.Test;

public class CPACEPConnectorTest {
	//String homePath = "/home/supun/Documents/cpachecker";
	//String homePath = "/home/supun/Documents/CPAchecker-1.7-unix";
	String homePath = "/home/travis/build/SupunArunoda/CPAChecker/cpachecker";
	StringBuilder sb;
	String lcSpecification;
	String lcConfiguration;
	String outputPathTest = "/tmp/test";
	String outputPathOriginal = "/tmp/original";

	@Before
	public void setup() {
		lcSpecification = "default";
		lcConfiguration = "default";
		sb = new StringBuilder();
		sb.append(homePath + File.separator + "scripts" + File.separator + "cpa.sh");
		sb.append(" -spec " + homePath + File.separator + "config" + File.separator + "specification" + File.separator + lcSpecification + ".spc");
		sb.append(" -config " + homePath + File.separator + "config" + File.separator + lcConfiguration + ".properties");
		sb.append(" " + homePath + File.separator + "doc" + File.separator + "examples" + File.separator + "example.c");
		sb.append(" -outputpath " + outputPathTest);
		sb.append(" -stats");
		CPACEPConnector.executeCommand(sb.toString());

	}

	@Test
	public void testStatistics() {

		String actualData = FileHandler.readFile(outputPathTest + File.separator + "Statistics.txt");
		String expectData = FileHandler.readFile(outputPathOriginal + File.separator + "Statistics.txt");
		assertEquals(expectData, actualData);

	}
}
