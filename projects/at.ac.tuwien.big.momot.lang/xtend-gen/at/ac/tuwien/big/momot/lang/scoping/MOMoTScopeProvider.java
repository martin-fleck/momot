package at.ac.tuwien.big.momot.lang.scoping;

import java.util.List;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.xbase.scoping.XImportSectionNamespaceScopeProvider;

@SuppressWarnings("all")
public class MOMoTScopeProvider extends XImportSectionNamespaceScopeProvider {
  public final static QualifiedName MOEA_FRAMEWORK = QualifiedName.create("org", "moeaframework");
  
  public final static QualifiedName MOEA = QualifiedName.create("at", "ac", "tuwien", "big", "moea");
  
  public final static QualifiedName MOMOT = QualifiedName.create("at", "ac", "tuwien", "big", "momot");
  
  @Override
  protected List<ImportNormalizer> getImplicitImports(final boolean ignoreCase) {
    final List<ImportNormalizer> imports = super.getImplicitImports(ignoreCase);
    ImportNormalizer _doCreateImportNormalizer = this.doCreateImportNormalizer(MOMoTScopeProvider.MOEA_FRAMEWORK, true, false);
    imports.add(_doCreateImportNormalizer);
    ImportNormalizer _doCreateImportNormalizer_1 = this.doCreateImportNormalizer(MOMoTScopeProvider.MOEA, true, false);
    imports.add(_doCreateImportNormalizer_1);
    ImportNormalizer _doCreateImportNormalizer_2 = this.doCreateImportNormalizer(MOMoTScopeProvider.MOMOT, true, false);
    imports.add(_doCreateImportNormalizer_2);
    return imports;
  }
}
