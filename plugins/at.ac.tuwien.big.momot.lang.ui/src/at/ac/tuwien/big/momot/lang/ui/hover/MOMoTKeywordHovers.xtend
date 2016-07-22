package at.ac.tuwien.big.momot.lang.ui.hover;

import com.google.inject.Inject
import at.ac.tuwien.big.momot.lang.services.MOMoTGrammarAccess
import org.eclipse.xtext.Keyword

public class MOMoTKeywordHovers {
	@Inject MOMoTGrammarAccess ga;
	
    def hoverText(Keyword k) {
        val result = switch (k) {
      		// proof of concept
       		// TODO: Add more concepts
            case ga.indicatorArrayAccess.hypervolumeHypervolumeKeyword_2_0_0: '''
					<p>Hypervolume is a common indicator used when comparing different search-based algorithm 
					as it can can capture both the convergence and the diversity of the solutions.
					Hypervolume corresponds to the proportion of the objective space that is dominated by the 
					Pareto front approximation returned by an algorithm delimited by a reference point.</p>
					<p>The larger the Hypervolume, the better an algorithm performs.</p>
            '''
            case ga.indicatorArrayAccess.invertedGenerationalDistanceInvertedGenerationalDistanceKeyword_2_2_0: '''
					<p>Inverted Generational Distance is a convergence measure that corresponds to the average Euclidean distance 
					between the Pareto front approximation produced by the algorithm and the reference front.
					We can calculate the distance between these two fronts in an <emph>M</emph>-objective space as the average 
					<emph>M</emph>-dimensional Euclidean distance between each solution in the approximation and its nearest neighbor 
					in the reference front.</p>
					<p>Better convergence is indicated by lower values.</p>
            '''
        }
        result.toString;
    }
}
