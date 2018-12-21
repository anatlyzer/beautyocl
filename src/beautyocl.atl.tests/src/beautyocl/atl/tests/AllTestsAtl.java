package beautyocl.atl.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	TestIfElse.class, 
	TestInteger.class, 
	TestKindOf.class, 
	TestLet.class, 
	TestUnshortCircuit.class })
public class AllTestsAtl {

}
