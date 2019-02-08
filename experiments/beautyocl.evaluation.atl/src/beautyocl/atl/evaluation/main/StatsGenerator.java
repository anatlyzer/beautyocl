package beautyocl.atl.evaluation.main;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import beautyocl.atl.evaluation.raw.AbstractSimplificable;
import beautyocl.atl.evaluation.raw.BEData;
import beautyocl.atl.evaluation.raw.BEInvariant;
import beautyocl.atl.evaluation.raw.BEModuleElement;
import beautyocl.atl.evaluation.raw.BEProblem;
import beautyocl.atl.evaluation.raw.BEQuickfix;
import beautyocl.atl.evaluation.raw.BESimplification;
import beautyocl.atl.evaluation.raw.BETransformation;

public class StatsGenerator extends AbstractMain {

	public static void main(String[] args) throws Exception {
		
		if ( args.length < 1 ) {
			System.out.println("StatsGenerator file");
			return;
		}
			
		String fileName = args[0];
		
		Serializer serializer = new Persister();
		File source = new File(args[0]);

		BEData data = serializer.read(BEData.class, source);

		Map<String, List<BESimplification>> simplificationsByName = new HashMap<>();
		List<Integer> simplificationsPerExpression = new LinkedList<Integer>();
		List<Double> reductionsPerExpression = new LinkedList<Double>();
		int totalSimplifications = 0;
		int totalExpressions = 0;
		
		long totalOriginalNodes = 0;
		long totalSimplifiedNodes = 0;
		
		
		for (BETransformation t : data.getTransformations()) {
			for (BEProblem p : t.getProblems()) {
				
				for (BEQuickfix qfx : p.getQuickfixes()) {
					totalExpressions++;

					totalOriginalNodes += qfx.getOriginalNumNodes();
					totalSimplifiedNodes += qfx.getSimplifiedNumNodes();
					
					double reduction = (qfx.getOriginalNumNodes() - qfx.getSimplifiedNumNodes())/ (double) qfx.getOriginalNumNodes();
					reductionsPerExpression.add(reduction);
					
					for (BESimplification s : qfx.getSimplifications()) {
						simplificationsByName.putIfAbsent(s.getName(), new ArrayList<BESimplification>());
						simplificationsByName.get(s.getName()).add(s);
						totalSimplifications++;
					}
					
					simplificationsPerExpression.add(qfx.getSimplifications().size());				
				}
			}
			
			for (BEInvariant inv : t.getInvariants()) {
				totalExpressions++;

				totalOriginalNodes += inv.getOriginalNumNodes();
				totalSimplifiedNodes += inv.getSimplifiedNumNodes();
				
				double reduction = (inv.getOriginalNumNodes() - inv.getSimplifiedNumNodes())/ (double) inv.getOriginalNumNodes();
				reductionsPerExpression.add(reduction);

				
				for (BESimplification s : inv.getSimplifications()) {
					simplificationsByName.putIfAbsent(s.getName(), new ArrayList<BESimplification>());
					simplificationsByName.get(s.getName()).add(s);
					totalSimplifications++;
				}				
				
				simplificationsPerExpression.add(inv.getSimplifications().size());
			}

			for (BEModuleElement me : t.getModuleElements()) {
				totalExpressions++;

				totalOriginalNodes += me.getOriginalNumNodes();
				totalSimplifiedNodes += me.getSimplifiedNumNodes();
				
				double reduction = (me.getOriginalNumNodes() - me.getSimplifiedNumNodes())/ (double) me.getOriginalNumNodes();
				reductionsPerExpression.add(reduction);

				
				for (BESimplification s : me.getSimplifications()) {
					simplificationsByName.putIfAbsent(s.getName(), new ArrayList<BESimplification>());
					simplificationsByName.get(s.getName()).add(s);
					totalSimplifications++;
				}				
				
				simplificationsPerExpression.add(me.getSimplifications().size());
			}
			
		}
		
		for (String simp : simplificationsByName.keySet()) {
			List<BESimplification> simps = simplificationsByName.get(simp);
			double percentage = (((double) simps.size()) / totalSimplifications) * 100.0; 			
			String size = fixedLengthInt(simps.size(), 4);
			String perc = fixedLengthDouble(percentage, 2);
			String txt = fixedLengthString(simp, 18) + ": " + size + " - " + perc + "%";
			System.out.println(txt);		
		}
		
		Collections.sort(simplificationsPerExpression);
		int median =  simplificationsPerExpression.get(simplificationsPerExpression.size() / 2);
		Collections.sort(reductionsPerExpression);
		double medianSimp =  reductionsPerExpression.get(reductionsPerExpression.size() / 2);
		
		System.out.println("Simplifications: " + totalSimplifications);
		System.out.println("    Expressions: " + totalExpressions);
		System.out.println("            Avg: " + fixedLengthDouble(totalSimplifications / (double) totalExpressions, 2));
		System.out.println("         Median: " + median);
		System.out.println();
		System.out.println(" Original nodes: " + totalOriginalNodes);
		System.out.println("Simplifi. nodes: " + totalSimplifiedNodes);
		//System.out.println("Avg simp. nodes: " + fixedLengthDouble((totalOriginalNodes - totalSimplifiedNodes)/ (double) totalOriginalNodes, 2));
		System.out.println("Avg simp. nodes: " + fixedLengthDouble(reductionsPerExpression.stream().collect(Collectors.averagingDouble(d -> d)) * 100, 2));
		System.out.println("Median simp.nod: " + fixedLengthDouble(medianSimp * 100, 2));
		
	}

		
}
