package beautyocl.atl.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import anatlyzer.atl.tests.api.AtlLoader.LoadException;
import anatlyzer.atl.util.ATLSerializer;
import anatlyzer.atl.util.ATLUtils;
import beautyocl.actions.IExecutionTracer;
import beautyocl.api.common.Beautyfier;
import beautyocl.api.common.TransformationRepository;
import beautyocl.atl.api.UglyAnATLyzerExpression;
import beautyocl.atl.api.utils.BeautyATLUtils;
@RunWith(Parameterized.class)
public class TestCombinations extends Tester {
	
	@Parameter
	public File sourceFile;
	
	@Parameters(name="{0}")
	public static Iterable<? extends Object> data() throws IOException {
		return Files.list(Paths.get("files/combinations")).map(p -> p.toFile()).collect(Collectors.toList());
	}

	
	@Test
	public void testCombinations() throws LoadException {	
		TransformationRepository rep = new TransformationRepository();
		rep.add(BeautyATLUtils.SIMP_IF_FUSION);
		rep.add(BeautyATLUtils.SIMP_KIND_OF_TRUE);
		
		doTest(rep, sourceFile);	
	}
	
}

