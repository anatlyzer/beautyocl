package beautyocl.actions;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

public class CustomCopier extends EcoreUtil.Copier {

	protected Set<String> ignoredReferences = new HashSet<>();
	
	public CustomCopier(EObject root) {
		this.root = root;
	}
	
	public CustomCopier withIgnoredReferences(Collection<String> names) {
		ignoredReferences.addAll(names);
		return this;
	}
	
	@Override
	protected void copyContainment(EReference eReference, EObject eObject, EObject copyEObject) {
		if ( ignoredReferences.contains(eReference.getName() ))
			return;
		
		super.copyContainment(eReference, eObject, copyEObject);
	}

	public EObject copyFull() {
		EObject r = this.copy(root);
		this.copyReferences();
		return r;
	}

	
	// From ATL Copier, to have cross-references copied right
	private EObject root;
	
	protected void copyReference(EReference eReference, EObject eObject, EObject copyEObject) {
		// super.copyReference(eReference, eObject, copyEObject);
		copyReference_orginal_modified(eReference, eObject, copyEObject);

		if (eObject.eIsSet(eReference)) {
			if (eReference.isMany()) {
			} else {
				Object referencedEObject = eObject.eGet(eReference,
						resolveProxies);
				if (referencedEObject == null) {
				} else {
					Object copyReferencedEObject = get(referencedEObject);
					if (copyReferencedEObject == null) {
						if (useOriginalReferences
								&& eReference.getEOpposite() == null) {
						}
						// added to make a cross-reference to objects
						// outside the copy
						else {
							boolean isContained = EcoreUtil.isAncestor(root,
									(EObject) referencedEObject);
							if (useOriginalReferences && !isContained) {
								copyEObject.eSet(eReference, referencedEObject);
							}
						}
					} else {
					}
				}
			}
		}	
	}

	// A modification is needed...
    protected void copyReference_orginal_modified(EReference eReference, EObject eObject, EObject copyEObject)
    {
      if (eObject.eIsSet(eReference))
      {
        EStructuralFeature.Setting setting = getTarget(eReference, eObject, copyEObject);
        if (setting != null)
        {
          Object value = eObject.eGet(eReference, resolveProxies);
          if (eReference.isMany())
          {
            @SuppressWarnings("unchecked") InternalEList<EObject> source = (InternalEList<EObject>)value;
            @SuppressWarnings("unchecked") InternalEList<EObject> target = (InternalEList<EObject>)setting;
            
            
            // This is the modification
            if ( source == target ) 
            	return;
            
            if (source.isEmpty())
            {
              target.clear();
            }
            else
            {
              boolean isBidirectional = eReference.getEOpposite() != null;
              int index = 0;
              for (Iterator<EObject> k = resolveProxies ? source.iterator() : source.basicIterator(); k.hasNext();)
              {
                EObject referencedEObject = k.next();
                EObject copyReferencedEObject = get(referencedEObject);
                if (copyReferencedEObject == null)
                {
                  if (useOriginalReferences && !isBidirectional)
                  {
                    target.addUnique(index, referencedEObject);
                    ++index;
                  }
                }
                else
                {
                  if (isBidirectional)
                  {
                    int position = target.indexOf(copyReferencedEObject);
                    if (position == -1)
                    {
                      target.addUnique(index, copyReferencedEObject);
                    }
                    else if (index != position)
                    {
                      target.move(index, copyReferencedEObject);
                    }
                  }
                  else
                  {
                    target.addUnique(index, copyReferencedEObject);
                  }
                  ++index;
                }
              }
            }
          }
          else
          {
            if (value == null)
            {
              setting.set(null);
            }
            else
            {
              Object copyReferencedEObject = get(value);
              if (copyReferencedEObject == null)
              {
                if (useOriginalReferences && eReference.getEOpposite() == null)
                {
                  setting.set(value);
                }
              }
              else
              {
                setting.set(copyReferencedEObject);
              }
            }
          }
        }
      }
    }
	
	/**
	 * Modification of the original copy
	 */
    public EObject copy(EObject eObject)
    {
      if (eObject == null)
      {
        return null;
      }
      else
      {
        EObject copyEObject = createCopy(eObject);
        if (copyEObject != null)
        {
          copyPerformed(eObject, copyEObject);
          put(eObject, copyEObject);
          EClass eClass = eObject.eClass();
          for (int i = 0, size = eClass.getFeatureCount(); i < size; ++i)
          {
            EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(i);
            if (eStructuralFeature.isChangeable() && !eStructuralFeature.isDerived())
            {
              if (eStructuralFeature instanceof EAttribute)
              {
                copyAttribute((EAttribute)eStructuralFeature, eObject, copyEObject);
              }
              else
              {
                EReference eReference = (EReference)eStructuralFeature;
                if (eReference.isContainment())
                {
                  copyContainment(eReference, eObject, copyEObject);
                } 
                // Added to handle the copy of some non-containment references                
                else {
                  //copyNonContainment(eReference, eObject, copyEObject);
                }
              }
            }
          }

          copyProxyURI(eObject, copyEObject);
        }

        return copyEObject;
      }
    }

    protected void copyPerformed(EObject src, EObject copy) {
		// Call back method to be implemented by subclasses
	}
	
	
}
