package beautyocl.atl.evaluation.export;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;

import anatlyzer.experiments.export.Styler;
import beautyocl.atl.api.utils.BeautyATLUtils;
import beautyocl.atl.evaluation.raw.AbstractSimplificable;
import beautyocl.atl.evaluation.raw.BEData;
import beautyocl.atl.evaluation.raw.BEInvariant;
import beautyocl.atl.evaluation.raw.BEQuickfix;
import beautyocl.atl.evaluation.raw.BESimplification;

public class ExportToExcel {
	private BEData data;

	public ExportToExcel(BEData data) {
		this.data = data;
	}
		
	public void exportToExcel(IFolder folder, IFile experimentFile) throws IOException {

		Workbook wb = new HSSFWorkbook();
		
//		counting.toExcel(folder.getFile( experimentFile.getName().replace(".exp", "_byError.xlsx")).getLocation().toOSString() );
//		byKind.toExcel( folder.getFile( experimentFile.getName().replace(".exp", "_byKind.xlsx")).getLocation().toOSString());
//		bySeverity.toExcel( folder.getFile( experimentFile.getName().replace(".exp", "_bySeverity.xlsx")).getLocation().toOSString());
//
//		counting.toLatex( folder.getFile( experimentFile.getName().replace(".exp", "byError.tex")).getLocation().toOSString());
//		byKind.toLatex( folder.getFile( experimentFile.getName().replace(".exp", "_byKind.tex")).getLocation().toOSString());
//		bySeverity.toLatex( folder.getFile( experimentFile.getName().replace(".exp", "_bySeverity.tex")).getLocation().toOSString());		

//		List<TEProblem> allProblems = data.getAllTransformations().stream().flatMap(t -> t.getProblems().stream()).collect(Collectors.toList());	
		try {
			export(wb);

			String name = "simplification_summary" + ".xls";		
			File f = folder.getFile(name).getLocation().toFile();		
			wb.write(new FileOutputStream(f));
			System.out.println("Exported! " + name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		
		//MessageDialog.openInformation(null, "Finished", "Exported files to " + folder.getFullPath().toPortableString());
	}


	private void export(Workbook wb) throws IOException {
		Sheet sheet = wb.createSheet("Summary");
		Styler   st = new Styler(wb);

		List<String> names = BeautyATLUtils.getRepository().getTransformations().stream().map(t -> t.getName()).sorted().collect(Collectors.toList());
		
		List<AbstractSimplificable> list = data.getTransformations().stream().flatMap(t -> 
			Stream.concat(t.getProblems().stream().flatMap(p -> p.getQuickfixes().stream()), t.getInvariants().stream()).map(x -> (AbstractSimplificable) x) ).
			collect(Collectors.toList());

		int startRow = 2;
		int startCol = 1;

		st.cell(sheet, startRow, startCol + 0, "ExpId");
		st.cell(sheet, startRow, startCol + 1, "Origin");
		st.cell(sheet, startRow, startCol + 2, "SrcNumNodes");
		st.cell(sheet, startRow, startCol + 3, "SimNumNodes");
		st.cell(sheet, startRow, startCol + 4, "TotalSimpsApplied");
		
		for(int i = 0; i < names.size(); i++) {
			st.cell(sheet, startRow, startCol + 5 + i, names.get(i));
		}
		
		int lastCol = startCol + 5 + names.size() + 1;
		
		
		
		startRow++;
		for(int i = 0; i < list.size(); i++) {
			AbstractSimplificable simp = list.get(i);
						
			st.cell(sheet, startRow + i, startCol + 0, (long) simp.getExpId());
			st.cell(sheet, startRow + i, startCol + 1, getOrigin(simp));
			st.cell(sheet, startRow + i, startCol + 2, (long) simp.getOriginalNumNodes());
			st.cell(sheet, startRow + i, startCol + 3, (long) simp.getSimplifiedNumNodes());
			st.cell(sheet, startRow + i, startCol + 4, (long) simp.getSimplifications().size());

			long[] simpCount = new long[names.size()];
			
			for(BESimplification s : simp.getSimplifications()) {
				System.out.println("Registered: " + s.getName());
				int idx = names.indexOf(s.getName());
				if ( idx == -1 ) {
					st.cell(sheet, startRow + i, lastCol, "Not registered: " + s.getName());
				} else {
					simpCount[idx]++;
					st.cell(sheet, startRow + i, startCol + 5 + idx, simpCount[idx]);
				}
			}
		}

	}

	private String getOrigin(AbstractSimplificable simp) {
		if ( simp instanceof BEQuickfix ) {
			return "Qfx: " + ((BEQuickfix) simp).getName();
		} else if ( simp instanceof BEInvariant ) {
			return "Inv: " + ((BEInvariant) simp).getName();
		}
		return "<unknown>";
	}
}
