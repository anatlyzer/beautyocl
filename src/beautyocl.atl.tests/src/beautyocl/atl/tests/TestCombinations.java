package beautyocl.atl.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import anatlyzer.atl.tests.api.AtlLoader.LoadException;
import anatlyzer.atl.util.ATLSerializer;
import anatlyzer.atl.util.ATLUtils;
import beautyocl.actions.IExecutionTracer;
import beautyocl.actions.MatchPhase.Match;
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
	
	@Test
	public void testCombinations_if_fusion_equality_sequence() throws LoadException {	
		TransformationRepository rep = new TransformationRepository();
		rep.add(BeautyATLUtils.SIMP_IF_FUSION);
		rep.add(BeautyATLUtils.SIMP_BOOLEANS);
		rep.add(BeautyATLUtils.SIMP_EQUALITY_SEQUENCE);
		
		doTest(rep, sourceFile);	
	}
	

	@Test
	public void testCombinatios_Unshort() throws LoadException {	
		TransformationRepository rep = new TransformationRepository();
		rep.add(BeautyATLUtils.SIMP_KIND_OF_TRUE);
		rep.add(BeautyATLUtils.SIMP_IF_ELSE);
		rep.add(BeautyATLUtils.SIMP_UNSHORT_CIRCUIT);
		rep.add(BeautyATLUtils.SIMP_EQUALITY_SEQUENCE);
		
		doTest(rep, new File("files/combinations/equality_sequence_unshort_xml.atl"), new IExecutionTracer() {

			@Override
			public void preApply(Match m, EObject original) {
				System.out.println("Action source: " + m.getAction().getSource());
				
				String exp = ATLSerializer.serialize(original);
				System.out.println("Before " + m.getTransformationName() + "\n" + exp);
			}

			@Override
			public void postApply(Match m, EObject transformed) {
				String exp = ATLSerializer.serialize(transformed);
				System.out.println("After " + m.getTransformationName() + "\n" + exp);					
			}

			@Override
			public boolean onError(Match m, Throwable t) {
				t.printStackTrace();
				// TODO Auto-generated method stub
				return false;
			}
			
		});	
	}

}

