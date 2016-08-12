package at.ac.tuwien.big.momot.lang.ui.hover;

import com.google.inject.Inject;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.internal.text.html.HTMLPrinter;
import org.eclipse.jface.text.IRegion;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ui.editor.hover.html.XtextBrowserInformationControlInput;
import org.eclipse.xtext.xbase.ui.hover.XbaseHoverProvider;

@SuppressWarnings("restriction")
public class MOMoTHoverProvider extends XbaseHoverProvider {
   /** Utility mapping keywords and hovertext. */
   @Inject
   private MOMoTKeywordHovers keywordHovers;

   @Override
   protected XtextBrowserInformationControlInput getHoverInfo(final EObject obj, final IRegion region,
         final XtextBrowserInformationControlInput prev) {
      if(obj instanceof Keyword) {
         final String html = getHoverInfoAsHtml(obj);
         if(html != null) {
            final StringBuffer buffer = new StringBuffer(html);
            HTMLPrinter.insertPageProlog(buffer, 0, getStyleSheet());
            HTMLPrinter.addPageEpilog(buffer);
            return new XtextBrowserInformationControlInput(prev, obj, buffer.toString(), labelProvider);
         }
      }
      return super.getHoverInfo(obj, region, prev);
   }

   @Override
   protected String getHoverInfoAsHtml(final EObject o) {
      if(o instanceof Keyword) {
         return keywordHovers.hoverText((Keyword) o);
      }
      return super.getHoverInfoAsHtml(o);
   }
}
