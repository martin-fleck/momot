package at.ac.tuwien.big.momot.lang.ui.hover;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider.IInformationControlCreatorProvider;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.xbase.ui.hover.XbaseDispatchingEObjectTextHover;

import com.google.inject.Inject;

public class MOMoTDispatchingTextHover extends XbaseDispatchingEObjectTextHover {
	@Inject MOMoTKeywordOffsetHelper keywordAtOffsetHelper;
    @Inject IEObjectHoverProvider hoverProvider;
    IInformationControlCreatorProvider lastCreatorProvider = null;
	 
	    @Override
	    public Object getHoverInfo(EObject first, ITextViewer textViewer, IRegion hoverRegion) {
	        if (first instanceof Keyword) {
	            lastCreatorProvider = hoverProvider.getHoverInfo(first, textViewer, hoverRegion);
	            return lastCreatorProvider == null ? null : lastCreatorProvider.getInfo();
	        }
	        lastCreatorProvider = null;
	        return super.getHoverInfo(first, textViewer, hoverRegion);
	    }
	 
	    @Override
	    public IInformationControlCreator getHoverControlCreator() {
	        return this.lastCreatorProvider == null ? super.getHoverControlCreator() : lastCreatorProvider.getHoverControlCreator();
	    }
	 
	    @Override
	    protected Pair<EObject, IRegion> getXtextElementAt(XtextResource resource, final int offset) {
	        Pair<EObject, IRegion> elementResult = super.getXtextElementAt(resource, offset);
	        Pair<EObject, IRegion> keywordResult = keywordAtOffsetHelper.resolveKeywordAt(resource, offset);
	        if (keywordResult == null) 
	        	return elementResult; 	        
	        return keywordResult; // keyword over element in hover
	    }
}
