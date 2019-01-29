package beautyocl.atl.evaluation.main;

import java.io.File;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import beautyocl.atl.evaluation.raw.AbstractSimplificable;
import beautyocl.atl.evaluation.raw.BECorrectnessData;
import beautyocl.atl.evaluation.raw.BECorrectnessExecution;
import beautyocl.atl.evaluation.raw.BEData;
import beautyocl.atl.evaluation.raw.BEInvariant;
import beautyocl.atl.evaluation.raw.BEProblem;
import beautyocl.atl.evaluation.raw.BEQuickfix;
import beautyocl.atl.evaluation.raw.BESimplification;
import beautyocl.atl.evaluation.raw.BETransformation;

public class CorrectnessReaderMain extends AbstractMain {

	public static void main(String[] args) throws Exception {
		new CorrectnessReaderMain().run(args);
	}

	public void run(String[] args) throws Exception {
		if ( args.length < 2 ) {
			System.out.println("CorrectnessReaderMain fileCorrectness fileExperiment");
			return;
		}
			
		Serializer serializer = new Persister();
		
		BECorrectnessData cData = serializer.read(BECorrectnessData.class, new File(args[0]));
		BEData eData = serializer.read(BEData.class, new File(args[1]));
		
		int total = 0;
		int correct = 0;
		int invalid = 0;
		int notValidated = 0;
		int timeout = 0;
		
		List<Long> solvingTimes = new ArrayList<>();
		
		List<AbstractSimplificable> invalids = new ArrayList<>();
		
		for (BECorrectnessExecution execution : cData.getExecutions()) {
			
			AbstractSimplificable simplificable = findSimplificable(eData, execution.getExpId());
			if ( simplificable == null ) {
				System.out.println("Can't find expId " + execution.getExpId());
				continue;
			}
		
			if ( execution.getStatus().equals("correct") ) {
				correct++;
				solvingTimes.add(execution.getSolvingTimeNanos());				
			} else if ( execution.getStatus().equals("invalid") ) {
				invalid++;
				invalids.add(simplificable);
				solvingTimes.add(execution.getSolvingTimeNanos());				
			} else if ( execution.getStatus().equals("validation-failure") ) {
				notValidated++;
			}  else if ( execution.getStatus().equals("timeout") ) {
				timeout++;
			}
			
			total++;
		}
		
		// TODO: Check which ones are due to syntatic failures in the generated code
		
		System.out.println("  Total: " + total);
		System.out.println("Correct: " + correct);
		System.out.println("Invalid: " + invalid);
		System.out.println("Timeout: " + timeout);
		System.out.println("Failure: " + notValidated);
		
		System.out.println();
		DoubleSummaryStatistics summary = solvingTimes.stream().collect(Collectors.summarizingDouble(x -> x * 1e-9));
		System.out.println("Average solving time: " + summary.getAverage());
		System.out.println("    Max solving time: " + summary.getMax());
		System.out.println("    Min solving time: " + summary.getMin());
		System.out.println("   Mean solving time: " + solvingTimes.get(solvingTimes.size() / 2) * 1e-9);
		
		
		System.out.println();
		System.out.println("Invalid list");
		
		for (AbstractSimplificable s : invalids) {
			System.out.println(" * " + s.getExpId() + " - ");

			Set<String> sets = s.getSimplifications().stream().map(simp -> simp.getName()).collect(Collectors.toSet());

			System.out.println("   - " + sets.stream().collect(Collectors.joining(", ")));	
		}
		
	}
}
