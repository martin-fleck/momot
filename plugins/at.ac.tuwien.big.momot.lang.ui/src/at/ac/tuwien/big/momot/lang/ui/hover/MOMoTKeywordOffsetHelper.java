package at.ac.tuwien.big.momot.lang.ui.hover;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

public class MOMoTKeywordOffsetHelper {
   public Pair<EObject, IRegion> resolveKeywordAt(final XtextResource resource, final int offset) {
      final IParseResult parseResult = resource.getParseResult();
      if(parseResult != null) {
         ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset);
         if(leaf != null && leaf.isHidden() && leaf.getOffset() == offset) {
            leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset - 1);
         }
         if(leaf != null && leaf.getGrammarElement() instanceof Keyword) {
            final Keyword keyword = (Keyword) leaf.getGrammarElement();
            return Tuples.create((EObject) keyword, (IRegion) new Region(leaf.getOffset(), leaf.getLength()));
         }
      }
      return null;
   }
}
