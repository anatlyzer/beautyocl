package beautyocl.atl.tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import anatlyzer.atl.tests.api.AtlLoader.LoadException;
import beautyocl.api.common.TransformationRepository;
import beautyocl.atl.api.utils.BeautyATLUtils;
@RunWith(Parameterized.class)
public class TestOperators extends Tester {
	
	@Parameter
	public File sourceFile;
	
	@Parameters(name="{0}")
	public static Iterable<? extends Object> data() throws IOException {
		return Files.list(Paths.get("files/operators")).map(p -> p.toFile()).collect(Collectors.toList());
	}

	
	@Test
	public void testOperators() throws LoadException {	
		TransformationRepository rep = new TransformationRepository();
		rep.add(BeautyATLUtils.SIMP_IDENTITY_ELEMENT);
		
		doTest(rep, sourceFile);	
	}
	
}

