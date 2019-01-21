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
public class TestBuiltinOperations extends Tester {
	
	@Parameter
	public File sourceFile;
	
	@Parameters(name="{0}")
	public static Iterable<? extends Object> data() throws IOException {
		return Files.list(Paths.get("files/builtin")).map(p -> p.toFile()).collect(Collectors.toList());
	}

	
	@Test
	public void testOperands() throws LoadException {	
		TransformationRepository rep = new TransformationRepository();
		rep.add(BeautyATLUtils.SIMP_BUILT_IN_OPERATIONS);
		
		doTest(rep, sourceFile);	
	}
	

//	@Test
//	public void test_EqualitySequence_Interleaved() throws LoadException {	
//		TransformationRepository rep = new TransformationRepository();
//		// rep.addEMFTVM("beautyocl.simplifications.integer.atl");
//		//rep.add(BeautyATLUtils.SIMP_IF_ELSE);
//		//rep.add(BeautyATLUtils.SIMP_KIND_OF_TRUE);
//		//rep.add(BeautyATLUtils.SIMP_UNSHORT_CIRCUIT);
//		rep.add(BeautyATLUtils.SIMP_EQUALITY_SEQUENCE);
//		
//		
//		// TODO: Simplify true and XX
//		
//		UglyAnATLyzerExpression exp = loadExpressionXML("files/unshort/unshort_xml_interleaved.atl");
//
//		String before = ATLSerializer.serialize(exp.getRoot());		
//			Beautyfier beauty = new Beautyfier(rep, IExecutionTracer.NULL);
//			beauty.applyAll(exp);
//		String after = ATLSerializer.serialize(exp.getRoot());
//		assertNotEquals(before, after);
//				
//		System.out.println("Before: " + before);
//		System.out.println("After: " + after);
//	}

	
	/*
	@Test
	public void testEqualitySequence() throws LoadException {	
		String trafo = "files/operands/equality_sequence.atl";
		TransformationRepository rep = new TransformationRepository();
		rep.add(BeautyATLUtils.SIMP_EQUALITY_SEQUENCE);
		
		UglyAnATLyzerExpression exp = loadExpression(trafo);
		
		String before = ATLSerializer.serialize(exp.getRoot());		
			Beautyfier beauty = new Beautyfier(rep, IExecutionTracer.NULL);
			beauty.applyAll(exp);
		String after = ATLSerializer.serialize(exp.getRoot());
		assertNotEquals(before, after);
			
		System.out.println("Before: " + before);
		System.out.println("After: " + after);
	}

	@Test
	public void testEqualitySequenceAnd() throws LoadException {	
		String trafo = "files/operands/equality_sequence_and.atl";
		TransformationRepository rep = new TransformationRepository();
		rep.add(BeautyATLUtils.SIMP_EQUALITY_SEQUENCE);
		
		UglyAnATLyzerExpression exp = loadExpression(trafo);
		
		String before = ATLSerializer.serialize(exp.getRoot());		
			Beautyfier beauty = new Beautyfier(rep, IExecutionTracer.NULL);
			beauty.applyAll(exp);
		String after = ATLSerializer.serialize(exp.getRoot());
		assertNotEquals(before, after);
			
		System.out.println("Before: " + before);
		System.out.println("After: " + after);
	}


	@Test
	public void testEqualitySequenceAnd_NoChange() throws LoadException {	
		String trafo = "files/operands/equality_sequence_and_no_change.atl";
		TransformationRepository rep = new TransformationRepository();
		rep.add(BeautyATLUtils.SIMP_EQUALITY_SEQUENCE);
		
		UglyAnATLyzerExpression exp = loadExpression(trafo);
		
		String before = ATLSerializer.serialize(exp.getRoot());		
			Beautyfier beauty = new Beautyfier(rep, IExecutionTracer.NULL);
			beauty.applyAll(exp);
		String after = ATLSerializer.serialize(exp.getRoot());

		System.out.println("Before: " + before);
		System.out.println("After: " + after);

		// In this case we don't want to have the simplification triggered
		assertEquals(before, after);
			
	}
	*/
}

