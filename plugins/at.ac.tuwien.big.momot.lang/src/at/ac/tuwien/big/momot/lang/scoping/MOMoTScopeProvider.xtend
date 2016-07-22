package at.ac.tuwien.big.momot.lang.scoping

import org.eclipse.xtext.xbase.scoping.XImportSectionNamespaceScopeProvider
import org.eclipse.xtext.naming.QualifiedName

class MOMoTScopeProvider extends XImportSectionNamespaceScopeProvider {
   public static final QualifiedName MOEA_FRAMEWORK = QualifiedName.create("org", "moeaframework");
   public static final QualifiedName MOEA = QualifiedName.create("at","ac", "tuwien", "big", "moea");
   public static final QualifiedName MOMOT = QualifiedName.create("at","ac", "tuwien", "big", "momot");
   
   override protected getImplicitImports(boolean ignoreCase) {
      val imports = super.getImplicitImports(ignoreCase)
      imports.add(doCreateImportNormalizer(MOEA_FRAMEWORK, true, false))
      imports.add(doCreateImportNormalizer(MOEA, true, false))
      imports.add(doCreateImportNormalizer(MOMOT, true, false))
      return imports
   }
}
