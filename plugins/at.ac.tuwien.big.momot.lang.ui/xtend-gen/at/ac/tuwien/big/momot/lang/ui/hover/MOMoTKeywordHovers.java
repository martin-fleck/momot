package at.ac.tuwien.big.momot.lang.ui.hover;

import at.ac.tuwien.big.momot.lang.services.MOMoTGrammarAccess;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Keyword;

@SuppressWarnings("all")
public class MOMoTKeywordHovers {
  @Inject
  private MOMoTGrammarAccess ga;
  
  public String hoverText(final Keyword k) {
    String _xblockexpression = null;
    {
      String _switchResult = null;
      boolean _matched = false;
      Keyword _hypervolumeHypervolumeKeyword_2_0_0 = this.ga.getIndicatorArrayAccess().getHypervolumeHypervolumeKeyword_2_0_0();
      if (Objects.equal(k, _hypervolumeHypervolumeKeyword_2_0_0)) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("<p>Hypervolume is a common indicator used when comparing different search-based algorithm ");
        _builder.newLine();
        _builder.append("as it can can capture both the convergence and the diversity of the solutions.");
        _builder.newLine();
        _builder.append("Hypervolume corresponds to the proportion of the objective space that is dominated by the ");
        _builder.newLine();
        _builder.append("Pareto front approximation returned by an algorithm delimited by a reference point.</p>");
        _builder.newLine();
        _builder.append("<p>The larger the Hypervolume, the better an algorithm performs.</p>");
        _builder.newLine();
        _switchResult = _builder.toString();
      }
      if (!_matched) {
        Keyword _invertedGenerationalDistanceInvertedGenerationalDistanceKeyword_2_2_0 = this.ga.getIndicatorArrayAccess().getInvertedGenerationalDistanceInvertedGenerationalDistanceKeyword_2_2_0();
        if (Objects.equal(k, _invertedGenerationalDistanceInvertedGenerationalDistanceKeyword_2_2_0)) {
          _matched=true;
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("<p>Inverted Generational Distance is a convergence measure that corresponds to the average Euclidean distance ");
          _builder_1.newLine();
          _builder_1.append("between the Pareto front approximation produced by the algorithm and the reference front.");
          _builder_1.newLine();
          _builder_1.append("We can calculate the distance between these two fronts in an <emph>M</emph>-objective space as the average ");
          _builder_1.newLine();
          _builder_1.append("<emph>M</emph>-dimensional Euclidean distance between each solution in the approximation and its nearest neighbor ");
          _builder_1.newLine();
          _builder_1.append("in the reference front.</p>");
          _builder_1.newLine();
          _builder_1.append("<p>Better convergence is indicated by lower values.</p>");
          _builder_1.newLine();
          _switchResult = _builder_1.toString();
        }
      }
      final String result = _switchResult;
      _xblockexpression = result.toString();
    }
    return _xblockexpression;
  }
}
