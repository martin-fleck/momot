package at.ac.tuwien.big.momot.lang.ui.hover;

import com.google.inject.Inject;

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

@SuppressWarnings("restriction")
public class MOMoTDispatchingTextHover extends XbaseDispatchingEObjectTextHover {
   @Inject
   private MOMoTKeywordOffsetHelper keywordAtOffsetHelper;
   @Inject
   private IEObjectHoverProvider hoverProvider;
   private IInformationControlCreatorProvider lastCreatorProvider = null;

   @Override
   public IInformationControlCreator getHoverControlCreator() {
      return this.lastCreatorProvider == null ? super.getHoverControlCreator()
            : lastCreatorProvider.getHoverControlCreator();
   }

   @Override
   public Object getHoverInfo(final EObject first, final ITextViewer textViewer, final IRegion hoverRegion) {
      if(first instanceof Keyword) {
         lastCreatorProvider = hoverProvider.getHoverInfo(first, textViewer, hoverRegion);
         return lastCreatorProvider == null ? null : lastCreatorProvider.getInfo();
      }
      lastCreatorProvider = null;
      return super.getHoverInfo(first, textViewer, hoverRegion);
   }

   @Override
   protected Pair<EObject, IRegion> getXtextElementAt(final XtextResource resource, final int offset) {
      final Pair<EObject, IRegion> elementResult = super.getXtextElementAt(resource, offset);
      final Pair<EObject, IRegion> keywordResult = keywordAtOffsetHelper.resolveKeywordAt(resource, offset);
      if(keywordResult == null) {
         return elementResult;
      }
      return keywordResult; // keyword over element in hover
   }
}
