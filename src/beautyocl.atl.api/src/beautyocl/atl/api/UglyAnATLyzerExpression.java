package beautyocl.atl.api;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import anatlyzer.atl.analyser.IAnalyserResult;
import anatlyzer.atl.model.ATLModel;
import beautyocl.api.common.UglyExpression;

/**
 * This is a wrapper for OCL expressions represented with the
 * AnATLyzer AST.
 * 
 * @author jesus
 */
public class UglyAnATLyzerExpression implements UglyExpression {

	private EObject obj;
	private IAnalyserResult result;

	public UglyAnATLyzerExpression(IAnalyserResult r, EObject obj) {
		this.result = r;
		this.obj = obj;
	}
	
	@Override
	public Resource getResource() {
		if ( obj != null ) {
			return obj.eResource();			
		}
		return result.getATLModel().getResource();
	}
	
	public EObject getScope() {
		return obj;
	}

	@Override
	public EObject getRoot() {
		return obj;
	}

	@Override
	public void setRoot(EObject root) {
		if ( root == null ) throw new IllegalArgumentException();
		this.obj = root;
	}

	@Override
	public Resource getEcoreTypesResource() {
		List<EObject> roots = result.getNamespaces().getMetamodels().stream().flatMap(m -> m.getResource().getContents().stream()).collect(Collectors.toList());
		
		return new Resource() {

			@Override
			public EList<Adapter> eAdapters() {
				throw new UnsupportedOperationException();
			}

			@Override
			public boolean eDeliver() {
				throw new UnsupportedOperationException();
			}

			@Override
			public void eSetDeliver(boolean deliver) {
				throw new UnsupportedOperationException();
			}

			@Override
			public void eNotify(Notification notification) {
				throw new UnsupportedOperationException();
			}

			@Override
			public ResourceSet getResourceSet() {
				throw new UnsupportedOperationException();
			}

			@Override
			public URI getURI() {
				throw new UnsupportedOperationException();
			}

			@Override
			public void setURI(URI uri) {
				throw new UnsupportedOperationException();	
			}

			@Override
			public long getTimeStamp() {
				throw new UnsupportedOperationException();
			}

			@Override
			public void setTimeStamp(long timeStamp) {
				throw new UnsupportedOperationException();
			}

			@Override
			public EList<EObject> getContents() {
				return new BasicEList<EObject>(roots);
			}

			@Override
			public TreeIterator<EObject> getAllContents() {
				return EcoreUtil.getAllContents(roots);
			}

			@Override
			public String getURIFragment(EObject eObject) {
				throw new UnsupportedOperationException();
			}

			@Override
			public EObject getEObject(String uriFragment) {
				throw new UnsupportedOperationException();
			}

			@Override
			public void save(Map<?, ?> options) throws IOException {
				throw new UnsupportedOperationException();
			}

			@Override
			public void load(Map<?, ?> options) throws IOException {
				throw new UnsupportedOperationException();
			}

			@Override
			public void save(OutputStream outputStream, Map<?, ?> options) throws IOException {
				throw new UnsupportedOperationException();				
			}

			@Override
			public void load(InputStream inputStream, Map<?, ?> options) throws IOException {
				throw new UnsupportedOperationException();
			}

			@Override
			public boolean isTrackingModification() {
				throw new UnsupportedOperationException();
			}

			@Override
			public void setTrackingModification(boolean isTrackingModification) {
				throw new UnsupportedOperationException();
			}

			@Override
			public boolean isModified() {
				throw new UnsupportedOperationException();
			}

			@Override
			public void setModified(boolean isModified) {
				throw new UnsupportedOperationException();
			}

			@Override
			public boolean isLoaded() {
				throw new UnsupportedOperationException();
			}

			@Override
			public void unload() {
				throw new UnsupportedOperationException();	
			}

			@Override
			public void delete(Map<?, ?> options) throws IOException {
				throw new UnsupportedOperationException();
			}

			@Override
			public EList<Diagnostic> getErrors() {
				throw new UnsupportedOperationException();
			}

			@Override
			public EList<Diagnostic> getWarnings() {
				throw new UnsupportedOperationException();
			}
			
		};
		// Create a wrapping resource!
		// return result.getNamespaces().getMetamodels().get(0).getResource();
		
		// return new ResourceImpl(); 
		// TODO: Should gather the types somehow...
	}
	
}
