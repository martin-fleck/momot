package at.ac.tuwien.big.moea.experiment.analyzer.kneepoint;

import at.ac.tuwien.big.moea.util.MathUtil;

import java.util.Arrays;
import java.util.Comparator;

import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.Solution;
import org.moeaframework.core.comparator.LexicographicalComparator;

/**
 * This class is adapted from the Fitness calculation class of
 * jMetalPlus: An enhanced version of the jMetal framework by marlonso
 * https://sourceforge.net/projects/jmetalbymarlonso/
 * <p>
 * This class is dedicated to encapsulating fitness calculation functions. The
 * intention behind is that all relevant fitness calculation schemes can be
 * found in one central class. This way we can avoid duplication of coding
 * efforts. Maintenance will also be easier.
 * <p>
 * All fitness values calculated in this class are to be minimized.
 *
 * @author Marlon
 */
public class Fitness {
   private static final double BULGE_FITNESS_EPS = 10E-6;

   private static final double ANGLE_270 = 270.0;

   public static final String KEY_PROPER_UTILITY = "momot_proper_utility";

   public static final String KEY_FITNESS = "momot_fitness";

   public static final String KEY_PROPER_UTILITY_FITNESS = "momot_proper_utility_fitness";
   public static final String KEY_MINMAX_TRADEOFF_FITNESS = "momot_minmaxTradeoff_fitness";
   public static final String KEY_UTILITY_KNEE_FITNESS_2D = "momot_utilityKneeFitness2D";
   public static final String KEY_UTILITY_KNEE_FITNESS_HIGHER_DIMENSIONS = "momot_utilityKneeFitness2D";
   public static final String KEY_BEND_ANGLE_FITNESS = "momot_bendAngleFitness";
   public static final String KEY_OBJECTIVE_SUM_FITNESS = "momot_objectiveSumFitness";
   public static final String KEY_ANGLE_FITNESS = "momot_angleFitness";
   public static final String KEY_EGALITARIAN_FITNESS = "momot_egalitarian_fitness";
   public static final String KEY_MAXMIN_FITNESS = "momot_maxmin_fitness";
   public static final String KEY_CHEBYSHEV_FITNESS = "momot_chebyshev_fitness";
   public static final String KEY_BULGE_FITNESS = "momot_bulge_fitness";
   public static final String KEY_NASH_FITNESS = "momot_nash_fitness";
   public static final String KEY_COBB_DOUGLAS_FITNESS = "momot_cobb_douglas_fitness";
   public static final String KEY_WEIGHTED_SUM_FITNESS = "momot_weighted_sum_fitness";
   public static final String KEY_PNORM_FITNESS = "momot_pnorm_fitness";

   public static void assignFitness(final NondominatedPopulation population) {
      final Fitness fitness = new Fitness(population);
      fitness.objectiveSumFitness();
      fitness.egalitarianFitness();
      fitness.chebyshevFitness();
      fitness.cobbDouglasFitness();
      fitness.nashFitness();
      fitness.properUtility();
      fitness.pNormFitness(2.0);
   }

   public static void assignFitness(final NondominatedPopulation population, final double[] weights) {
      assignFitness(population);
      final Fitness fitness = new Fitness(population);
      fitness.weightedSumFitness(weights);
      fitness.maxMinFitness(weights);
      fitness.chebyshevFitness2(weights);
      fitness.cobbDouglasFitness(weights);
   }

   public static void assignFitness(final NondominatedPopulation population, final double[] weights,
         final double[] referencePoint) {
      assignFitness(population, weights);
      final Fitness fitness = new Fitness(population);
      fitness.chebyshevFitness(referencePoint, weights);
      fitness.nashFitness(referencePoint);
   }

   /**
    * The {@link NondominatedPopulation} for which fitness values are calculated.
    */
   private final NondominatedPopulation nondominatedPopulation;

   /**
    * The number of objectives of the underlying optimization problem.
    * We assume that all solutions stem from the same problem.
    */
   private int nObj;

   /**
    * Standard constructor
    *
    * @param nondominatedPopulation
    *           The {@link NondominatedPopulation} for which all subsequent fitness
    *           calculations will be performed.
    */
   public Fitness(final NondominatedPopulation nondominatedPopulation) {
      this.nondominatedPopulation = nondominatedPopulation;
      if(!nondominatedPopulation.isEmpty()) {
         this.nObj = nondominatedPopulation.get(0).getObjectives().length;
      }
   }

   /**
    *
    * @param extremePoints
    */
   public void angleFitness(final double[][] extremePoints) {
      final int nExt = extremePoints.length;

      for(final Solution s : nondominatedPopulation) {
         final double[] angles = new double[nExt];
         final double[][] difference = new double[nExt][nExt];
         for(int i = 0; i < nExt; i++) {
            for(int j = 0; j < nExt; j++) {
               difference[i][j] = extremePoints[i][j] - s.getObjective(j);
            }
            double myNumerator = 0;
            double myDenominator = 0;
            for(int j = 0; j < nExt; j++) {
               if(i != j) {
                  myNumerator = myNumerator + Math.pow(difference[i][j], 2);
               } else {
                  myDenominator = difference[i][j];
               }
            }
            try {
               angles[i] = Math.atan(Math.sqrt(myNumerator) / myDenominator);
               if(Double.isInfinite(angles[i])) {
                  angles[i] = Double.MAX_VALUE;
               }
            } catch(final ArithmeticException e) {
               angles[i] = Double.MAX_VALUE;
            }
         }
         setFitness(s, MathUtil.max(angles), KEY_ANGLE_FITNESS);
      }
   }

   private double bendAngle(final Solution leftNeighbor, final Solution solution, final Solution rightNeighbor) {
      return ANGLE_270 - getLeftBendAngle(solution, leftNeighbor) - getRightBendAngle(solution, rightNeighbor);
   }

   /**
    * Calculates the bend angles of
    */
   public void bendAngleFitness() {
      if(nondominatedPopulation.isEmpty()) {
         return;
      }
      if(nObj > 2) {
         throw new RuntimeException("Bend-angle can only be calculated for two-dimensional problems");
      }

      nondominatedPopulation.sort(new LexicographicalComparator());

      final int size = nondominatedPopulation.size();
      final double[] alpha = new double[size];
      final double[] beta = new double[size];
      final double[] gamma = new double[size];
      final double[] delta = new double[size];

      // Handle the first and last two solution separately
      alpha[0] = ANGLE_270 - getRightBendAngle(nondominatedPopulation.get(0), nondominatedPopulation.get(1));
      beta[0] = alpha[0];
      gamma[0] = ANGLE_270 - getRightBendAngle(nondominatedPopulation.get(0), nondominatedPopulation.get(2));
      delta[0] = gamma[0];
      setFitness(nondominatedPopulation.get(0), Math.max(alpha[0], gamma[0]), KEY_BEND_ANGLE_FITNESS);

      alpha[1] = bendAngle(nondominatedPopulation.get(0), nondominatedPopulation.get(1), nondominatedPopulation.get(2));
      beta[1] = alpha[1];
      gamma[1] = bendAngle(nondominatedPopulation.get(0), nondominatedPopulation.get(1), nondominatedPopulation.get(3));
      delta[1] = gamma[1];
      setFitness(nondominatedPopulation.get(1), Math.max(alpha[1], gamma[1]), KEY_BEND_ANGLE_FITNESS);

      alpha[size - 2] = bendAngle(nondominatedPopulation.get(size - 3), nondominatedPopulation.get(size - 2),
            nondominatedPopulation.get(size - 1));
      beta[size - 2] = bendAngle(nondominatedPopulation.get(size - 4), nondominatedPopulation.get(size - 2),
            nondominatedPopulation.get(size - 1));
      gamma[size - 2] = alpha[size - 2];
      delta[size - 2] = beta[size - 2];
      setFitness(nondominatedPopulation.get(size - 2), Math.max(alpha[size - 2], beta[size - 2]),
            KEY_BEND_ANGLE_FITNESS);

      alpha[size - 1] = ANGLE_270
            - getLeftBendAngle(nondominatedPopulation.get(size - 1), nondominatedPopulation.get(size - 2));
      beta[size - 1] = ANGLE_270
            - getLeftBendAngle(nondominatedPopulation.get(size - 1), nondominatedPopulation.get(size - 3));
      gamma[size - 1] = alpha[size - 1];
      delta[size - 1] = beta[size - 1];

      setFitness(nondominatedPopulation.get(size - 1), Math.max(alpha[size - 1], beta[size - 1]),
            KEY_BEND_ANGLE_FITNESS);

      for(int i = 2; i < size - 2; i++) {
         alpha[i] = bendAngle(nondominatedPopulation.get(i - 1), nondominatedPopulation.get(i),
               nondominatedPopulation.get(i + 1));
         beta[i] = bendAngle(nondominatedPopulation.get(i - 2), nondominatedPopulation.get(i),
               nondominatedPopulation.get(i + 1));
         gamma[i] = bendAngle(nondominatedPopulation.get(i - 1), nondominatedPopulation.get(i),
               nondominatedPopulation.get(i + 2));
         delta[i] = bendAngle(nondominatedPopulation.get(i - 2), nondominatedPopulation.get(i),
               nondominatedPopulation.get(i + 2));

         setFitness(nondominatedPopulation.get(i), MathUtil.max(alpha[i], beta[i], gamma[i], delta[i]),
               KEY_BEND_ANGLE_FITNESS);
      }
   }

   /**
    * Calculates the bulge fitness as stated in the working paper of me and
    * Prad. The convex hull of individual minima is calculated from
    * {@link Fitness#nondominatedPopulation}.
    */
   public void bulgeFitness() {
      final Solution[] chim = obtainCHIM();

      // Calculate minima and maxima
      final double[] minima = new double[nObj];
      final double[] maxima = new double[nObj];

      for(int obj = 0; obj < nObj; obj++) {
         minima[obj] = Double.MAX_VALUE;
         maxima[obj] = Double.MIN_VALUE;

         // Consider all points of the CHIM
         for(int ext = 0; ext < nObj; ext++) {
            maxima[obj] = Math.max(maxima[obj], chim[ext].getObjective(obj));
            minima[obj] = Math.min(minima[obj], chim[ext].getObjective(obj));
         }
      }

      bulgeFitness(minima, maxima);
   }

   /**
    * Calculates bulge fitness according to the working paper by me and Prad.
    * Minima and maxima are provided by the user and not computed on the fly.
    * This is because the CHIM of the first non-dominated front serves as CHIM
    * for all other fronts as well.
    *
    * @param minima
    *           The individual minima of each objective
    * @param maxima
    *           The individual maximum objective values over all minima
    *           solutions.
    */
   public void bulgeFitness(final double[] minima, final double[] maxima) {
      for(int curSol = 0; curSol < nondominatedPopulation.size(); curSol++) {
         double sum = 0.0;
         for(int obj = 0; obj < nObj; obj++) {
            if(Math.abs(minima[obj] - maxima[obj]) < BULGE_FITNESS_EPS) {
               sum += (nondominatedPopulation.get(curSol).getObjective(obj) - minima[obj])
                     / (maxima[obj] - minima[obj]);
            }
         }
         final double fitness = (-1 + sum) / Math.sqrt(nObj);
         setFitness(nondominatedPopulation.get(curSol), fitness, KEY_BULGE_FITNESS);
      }
   }

   /**
    * Calculates fitness values for {@link Fitness#nondominatedPopulation} on the basis of
    * the Chebyshev method, i.e. F = max w*(f_i - u_i) where u is the Utopia
    * point. The minimum objectives of all solutions in {@link #nondominatedPopulation}
    * serve as Utopia point.
    */
   public void chebyshevFitness() {
      chebyshevFitness(MathUtil.colMin(writeObjectivesToMatrix(nondominatedPopulation)));
   }

   /**
    * Calculates fitness values for {@link Fitness#nondominatedPopulation} on the basis of
    * the Chebyshev method, i.e. F = max w*(f_i - a_i) where a is the
    * aspiration point.
    *
    * @param aspirationPoint
    *           The aspiration point (or Utopia point), which is subtracted
    *           from all objective vector for calculating the fitness values.
    */
   public void chebyshevFitness(final double[] aspirationPoint) {
      for(final Solution s : nondominatedPopulation) {
         setFitness(s, MathUtil.max(MathUtil.subtract(s.getObjectives(), aspirationPoint)), KEY_CHEBYSHEV_FITNESS);
      }
   }

   /**
    * Calculates fitness values for {@link Fitness#nondominatedPopulation} on the basis of
    * the Chebyshev method, i.e. F = max w*(f_i - a_i) where a is the
    * aspiration point.
    *
    * @param aspirationPoint
    *           The aspiration point (or Utopia point), which is subtracted
    *           from all objective vector for calculating the fitness values.
    * @param weights
    *           An array of weight vectors, by which each objective difference
    *           is multiplied. Allows articulating preferences for individual
    *           objectives.
    */
   public void chebyshevFitness(final double[] aspirationPoint, final double[] weights) {
      for(final Solution s : nondominatedPopulation) {
         setFitness(s, MathUtil.max(MathUtil.multiply(weights, MathUtil.subtract(s.getObjectives(), aspirationPoint))),
               KEY_CHEBYSHEV_FITNESS);
      }
   }

   /**
    * /** Calculates fitness values for {@link Fitness#nondominatedPopulation} on the
    * basis of the Chebyshev method, i.e. F = max w*(f_i - u_i) where u is the
    * Utopia point. The minimum objectives of all solutions in
    * {@link #nondominatedPopulation} serve as Utopia point.
    *
    * @param weights
    *           An array of scalar value, by which individual objectives can
    *           be weighted.
    */
   public void chebyshevFitness2(final double[] weights) {
      chebyshevFitness(MathUtil.colMin(writeObjectivesToMatrix(nondominatedPopulation)), weights);
   }

   /**
    * Calculates fitness values using the Cobb-Douglas production function. As
    * objectives have the same weight, so no exponentiation is performed.
    */
   public void cobbDouglasFitness() {
      for(final Solution s : nondominatedPopulation) {
         double product = s.getObjective(0);
         for(int o = 1; o < nObj; o++) {
            product *= s.getObjective(o);
         }
         setFitness(s, product, KEY_COBB_DOUGLAS_FITNESS);
      }
   }

   /**
    * Calculates fitness values using the Cobb-Douglas production function.
    * Each objective is raised by a weight that is a real number. Transformed
    * objectives are then multiplied
    *
    * @param weights
    *           The weights by which objectives are raised
    */
   public void cobbDouglasFitness(final double[] weights) {
      for(final Solution s : nondominatedPopulation) {
         double product = 1.0;
         for(int o = 0; o < nObj; o++) {
            product *= Math.pow(s.getObjective(o), weights[o]);
         }
         setFitness(s, product, KEY_COBB_DOUGLAS_FITNESS);
      }
   }

   /**
    * Calculates the convergence-diversity rank used in CDEA giving equal
    * weights to convergence and diversity criteria.
    *
    * @param convergence
    *           An {@link AbstractComparator} that addresses the convergence
    *           criterion
    * @param diversity
    *           An {@link AbstractComparator} that addresses the diversity
    *           criterion
    */
   public void convergenceDiversityRanking(final Comparator<Solution> convergence,
         final Comparator<Solution> diversity) {
      convergenceDiversityRanking(convergence, diversity, 1.0, 1.0);
   }

   /**
    * Calculates the convergence-diversity rank used in CDEA. All solutions are
    * ranked with respect to convergence and diversity. The
    * convergence-diversity is the sum of the positions of both solutions in
    * the convergence and diversity ranking, respectively. The influence of
    * both ranks be increased or decreased by two additional weight parameters
    *
    * @param convergence
    *           An {@link AbstractComparator} that addresses the convergence
    *           criterion
    * @param diversity
    *           An {@link AbstractComparator} that addresses the diversity
    *           criterion
    * @param c
    *           Weight for the convergence rank
    * @param d
    *           Weight for the diversity rank
    */
   public void convergenceDiversityRanking(final Comparator<Solution> convergence, final Comparator<Solution> diversity,
         final double c, final double d) {
      nondominatedPopulation.sort(convergence);
      for(int rank = 0; rank < nondominatedPopulation.size(); rank++) {
         nondominatedPopulation.get(rank).setAttribute("momot_convergence_distance_rank", c * rank);
      }

      nondominatedPopulation.sort(diversity);
      for(int rank = 0; rank < nondominatedPopulation.size(); rank++) {
         nondominatedPopulation.get(rank).setAttribute("momot_convergence_distance_rank",
               (Double) nondominatedPopulation.get(rank).getAttribute("momot_convergence_distance_rank") + d * rank);
      }
   }

   /**
    * Calculates fitness values on the basis of the egalitarian welfare
    * function. The fitness of a solution corresponds to the maximum of its
    * objective values.
    */
   public void egalitarianFitness() {
      for(final Solution s : nondominatedPopulation) {
         setFitness(s, MathUtil.max(s.getObjectives()), KEY_EGALITARIAN_FITNESS);
      }
   }

   /**
    * Calculates the expected marginal utility for a solution at position i in
    * the {@link Fitness#nondominatedPopulation}.
    *
    * @param i
    *           Index of the solution in {@link Fitness#nondominatedPopulation}.
    * @return The fitness value according to the utility knee fitness
    */
   private double expectedMarginalUtility(final int i) {
      return marginalUtilityKneeIntegralFunction(i, getWeightForEqualUtility(i - 1, i + 1))
            - marginalUtilityKneeIntegralFunction(i, getWeightForEqualUtility(i - 1, i))
            + marginalUtilityKneeIntegralFunction(i, getWeightForEqualUtility(i, i + 1))
            - marginalUtilityKneeIntegralFunction(i, getWeightForEqualUtility(i - 1, i + 1));
   }

   /**
    * Computes the vector holding the best objective values for each objective
    * in the underlying {@link NondominatedPopulation}.
    *
    * @return Vector holding the best objective values for each objective in
    *         the underlying {@link NondominatedPopulation}.
    */
   private double[] getBestObjectives() {
      final double[] best = new double[nObj];
      for(int i = 0; i < nObj; i++) {
         best[i] = Double.POSITIVE_INFINITY;
      }

      for(final Solution solution : nondominatedPopulation) {
         for(int i = 0; i < nObj; i++) {
            if(solution.getObjective(i) < best[i]) {
               best[i] = solution.getObjective(i);
            }
         }
      }
      return best;
   }

   public Double getFitness(final Solution solution) {
      return (Double) solution.getAttribute(KEY_FITNESS);
   }

   private double getLeftBendAngle(final Solution solution, final Solution leftNeighbor) {
      return Math.toDegrees(Math.atan((solution.getObjective(0) - leftNeighbor.getObjective(0))
            / (leftNeighbor.getObjective(1) - solution.getObjective(1))));
   }

   /**
    * Method for retrieving the {@link NondominatedPopulation} of this
    * <code>Fitness</code> instance.
    *
    * @return The {@link NondominatedPopulation} of this <code>Fitness</code> instance,
    *         {@link Fitness#nondominatedPopulation}.
    */
   public NondominatedPopulation getNondominatedPopulation() {
      return nondominatedPopulation;
   }

   public Double getProperUtility(final Solution solution) {
      return (Double) solution.getAttribute(KEY_PROPER_UTILITY);
   }

   private double getRightBendAngle(final Solution solution, final Solution rightNeighbor) {
      return Math.toDegrees(Math.atan((solution.getObjective(1) - rightNeighbor.getObjective(1))
            / (rightNeighbor.getObjective(0) - solution.getObjective(0))));
   }

   /**
    * Calculates the weight that gives both solutions the same utility when
    * using the utility function lambda * f_1 + (1 - lambda) f_2
    *
    * @param i
    *           Index of solution 1 in {@link Fitness#nondominatedPopulation}
    * @param j
    *           Index of solution 2 in {@link Fitness#nondominatedPopulation}
    * @return The weight giving both solutions the same fitness
    */
   private double getWeightForEqualUtility(final int i, final int j) {
      final Solution sol1 = nondominatedPopulation.get(i);
      final Solution sol2 = nondominatedPopulation.get(j);

      if(sol1.getObjectives().length != sol2.getObjectives().length) {
         throw new RuntimeException("Solutions do not have the same number of objectives");
      }

      return (sol2.getObjective(1) - sol1.getObjective(1))
            / (sol1.getObjective(0) - sol2.getObjective(0) + sol2.getObjective(1) - sol1.getObjective(1));
   }

   /**
    * Computes the vector holding the worst objective values for each objective
    * in the underlying {@link NondominatedPopulation}.
    *
    * @return Vector holding the worst objective values for each objective in
    *         the underlying {@link NondominatedPopulation}.
    */
   public double[] getWorstObjectives() {
      final double[] worst = new double[nObj];
      for(int i = 0; i < nObj; i++) {
         worst[i] = Double.NEGATIVE_INFINITY;
      }

      for(final Solution solution : nondominatedPopulation) {
         for(int i = 0; i < nObj; i++) {
            if(solution.getObjective(i) > worst[i]) {
               worst[i] = solution.getObjective(i);
            }
         }
      }
      return worst;
   }

   /**
    * Calculates the upper or lower integration limit of the utility knee
    * fitness.
    *
    * @param i
    *           Index of the solution in {@link Fitness#nondominatedPopulation}.
    * @param alpha
    *           Integration bound
    * @return Lower or upper integration limit of the utility knee fitness.
    */
   private double marginalUtilityKneeIntegralFunction(final int i, final double alpha) {
      final double f1x = nondominatedPopulation.get(i).getObjective(0);
      final double f2x = nondominatedPopulation.get(i).getObjective(1);
      final double f1y = nondominatedPopulation.get(i - 1).getObjective(0);
      final double f2y = nondominatedPopulation.get(i - 1).getObjective(1);

      final double alphaSquare = 1.0 / 2.0 * Math.pow(alpha, 2);

      return alphaSquare * (f1x - f1y) + (1 - alphaSquare) * (f2x - f2y);
   }

   /**
    * Calculates fitness values according to the max-min notion. Objective are
    * multiplied by scalar weights provided by the user for prioritizing goals.
    * The larger the weight, the more important is an individual goal. The
    * maximum of all weighted objectives then constitutes a solution's fitness
    * value.
    *
    * @param weights
    *           An array of scalar weights, by which objectives are
    *           multiplied.
    */
   public void maxMinFitness(final double[] weights) {
      for(final Solution s : nondominatedPopulation) {
         setFitness(s, MathUtil.max(MathUtil.multiply(weights, s.getObjectives())), KEY_MAXMIN_FITNESS);
      }
   }

   /**
    *
    */
   public void minmaxTradeoffFitness() {
      final double[] best = getBestObjectives();
      final double[] worst = getWorstObjectives();

      for(final Solution solution : nondominatedPopulation) {
         final double[] objectives = solution.getObjectives();
         setFitness(solution,
               MathUtil.max(MathUtil.divide(MathUtil.subtract(objectives, best), MathUtil.subtract(worst, objectives))),
               KEY_MINMAX_TRADEOFF_FITNESS);
      }
   }

   /**
    * Fitness values are chosen as results of the Nash bargaining solution. For
    * more information, see {@link #nashFitness(double[])}. The worst objective
    * values of {@link #nondominatedPopulation} are chosen as disagreement point, which is
    * basically the current best estimate of the Nadir point. Behold that
    * {@link #nondominatedPopulation} should only contain non-dominated solutions.
    * Otherwise outliers may perturb the fitness values.
    */
   public void nashFitness() {
      nashFitness(MathUtil.colMax(writeObjectivesToMatrix(nondominatedPopulation)));
   }

   /**
    * This fitness function assignment method is based on the Nash bargaining
    * solution with a user-provided disagreement point. We transformed Nash's
    * notion for compliance with minimization problems. Objective values are
    * subtracted from the <code>disagreement point</code> and then multiplied.
    *
    * @param disagreementPoint
    *           In economics, the disagreement point represents the allocation
    *           of goods if no agreement is reached between the bargaining
    *           parties. We can regard it as the worst possible outcome. In
    *           the optimization context, the disagreement point should be the
    *           vector of the worst objectives a decision maker is willing to
    *           accept, such he is indifferent between accepting and rejecting
    *           a solution holding such an objective value. In practical
    *           applications, it makes sense to use the Nadir point as the
    *           disagreement point or its current best estimate.
    */
   public void nashFitness(final double[] disagreementPoint) {
      for(final Solution s : nondominatedPopulation) {
         double fitness = 1.0;
         for(int o = 0; o < nObj; o++) {
            fitness *= disagreementPoint[o] - s.getObjective(o);
         }
         setFitness(s, fitness, KEY_NASH_FITNESS);
      }
   }

   /**
    * Calculates fitness values by simply adding up all objective values
    */
   public void objectiveSumFitness() {
      for(final Solution s : nondominatedPopulation) {
         double value = 0.0;
         for(int i = 0; i < s.getNumberOfObjectives(); i++) {
            value += s.getObjective(i);
         }
         setFitness(s, value, KEY_OBJECTIVE_SUM_FITNESS);
      }
   }

   /**
    * Calculates the convex hull of individual minima (CHIM) of the
    * {@link Fitness#nondominatedPopulation}.
    *
    * @return
    */
   public Solution[] obtainCHIM() {
      final Solution[] chim = new Solution[nObj];

      final LexicographicalComparator comparator = new LexicographicalComparator();
      for(int obj = 0; obj < nObj; obj++) {
         Solution bestKnown = nondominatedPopulation.get(0);
         Solution candidateSolution;
         int flag;
         for(int i = 1; i < nondominatedPopulation.size(); i++) {
            candidateSolution = nondominatedPopulation.get(i);
            flag = comparator.compare(bestKnown, candidateSolution);
            if(flag == +1) {
               bestKnown = candidateSolution;
            }
         }
         chim[obj] = bestKnown;
      }

      return chim;
   }

   /**
    * The fitness value is the distance of the point holding the smallest
    * objectives of solutions in {@link #nondominatedPopulation} to the given solution in
    * objective space. A p-norm is utilized to calculate the distance.
    *
    * @param norm
    *           The exponent used for calculating the p-norm
    */
   public void pNormFitness(final double norm) {
      pNormFitness(getBestObjectives(), norm);
   }

   /**
    * Fitness values are calculated as p-norm distances between the solution in
    * objective space and a utopia point. The utopia point serves as maximum
    * aspiration level.
    *
    * @param utopiaPoint
    *           An aspiration point holding the best achievable values for
    *           each objective.
    * @param norm
    *           The exponent used for calculating the p-norm
    */
   public void pNormFitness(final double[] utopiaPoint, final double norm) {
      for(final Solution s : nondominatedPopulation) {
         setFitness(s, MathUtil.pNorm(MathUtil.subtract(utopiaPoint, s.getObjectives()), norm), KEY_PNORM_FITNESS);
      }
   }

   /**
    * Calculates proper utilities for each {@link Solution} of
    * {@link Fitness#nondominatedPopulation}. See
    * "Theory and Algorithms for Finding Knees" by Shukla et al. for a
    * mathematical definition of the notion.
    */
   public void properUtility() {
      // Delete fitness values from previous iterations
      for(final Solution solution : nondominatedPopulation) {
         setProperUtility(solution, 0.0);
      }

      for(int cur = 0; cur < nondominatedPopulation.size(); cur++) {
         final Solution current = nondominatedPopulation.get(cur);

         for(int oth = cur + 1; oth < nondominatedPopulation.size(); oth++) {
            final Solution other = nondominatedPopulation.get(oth);

            final double[] diff = MathUtil.subtract(nondominatedPopulation.get(cur).getObjectives(),
                  nondominatedPopulation.get(oth).getObjectives());
            final double max = MathUtil.max(diff);
            final double min = MathUtil.min(diff);

            // if max <= 0 current dominates other
            // if min >= 0 other dominates current
            if(max > 0 && min < 0) {
               setProperUtility(current, Math.max(getProperUtility(current), -max / min));
               setProperUtility(other, Math.max(getProperUtility(other), -min / max));
               setFitness(current, getProperUtility(current), KEY_PROPER_UTILITY_FITNESS);
               setFitness(other, getProperUtility(other), KEY_PROPER_UTILITY_FITNESS);
            }
         }
      }
   }

   /**
    * Calculates proper utilities for each {@link Solution} of
    * {@link Fitness#nondominatedPopulation}, however imposes a minimum threshold. The
    * proper utility of solutions having a smaller value than
    * <code>tradeoff</code> is set to <code>tradeoff</code>.
    *
    * <p>
    * <code> solution.properUtility = max(solution.properUtility, tradeoff)</code>
    *
    * @param tradeoff
    *           A minimum threshold underneath all proper utilities are set to
    *           <code>tradeoff</code>.
    */
   public void properUtility(final double tradeoff) {
      properUtility();
      for(final Solution sol : nondominatedPopulation) {
         setProperUtility(sol, Math.max(getProperUtility(sol), tradeoff));
         setFitness(sol, getProperUtility(sol), KEY_PROPER_UTILITY_FITNESS);
      }
   }

   public void setFitness(final Solution solution, final Double fitness) {
      solution.setAttribute(KEY_FITNESS, fitness);
   }

   public void setFitness(final Solution solution, final Double fitness, final String key) {
      setFitness(solution, fitness);
      solution.setAttribute(key, fitness);
   }

   public void setProperUtility(final Solution solution, final Double fitness) {
      solution.setAttribute(KEY_PROPER_UTILITY, fitness);
   }

   /**
    * Calculates the utility fitness based on the paper
    * "Finding knees in multi-objective optimization" by Branke et al.
    */
   public void utilityKneeFitness() {
      if(nondominatedPopulation.isEmpty()) {
         return;
      }

      // Distinguish between 2D and higher dimensions
      if(nObj == 2) {
         utilityKneeFitness2D();
         // else
         // TODO: do something about those weight vectors
         // utilityKneeFitnessHigherDimensions();
      }
   }

   /**
    * Calculates fitness values based on the utility knee for two dimensional
    * problems.
    */
   private void utilityKneeFitness2D() {
      // Bring solutions in lexicographical order
      nondominatedPopulation.sort(new LexicographicalComparator());

      // Set fitness of last and first individually
      setFitness(nondominatedPopulation.get(0), Double.MAX_VALUE, KEY_UTILITY_KNEE_FITNESS_2D);
      setFitness(nondominatedPopulation.get(nondominatedPopulation.size() - 1), Double.MAX_VALUE,
            KEY_UTILITY_KNEE_FITNESS_2D);

      for(int i = 1; i < nondominatedPopulation.size() - 1; i++) {
         final Solution current = nondominatedPopulation.get(i);
         setFitness(current, expectedMarginalUtility(i), KEY_UTILITY_KNEE_FITNESS_2D);
      }
   }

   /**
    * Calculates fitness values based on the utility knee for higher
    * dimensional problems.
    */
   public void utilityKneeFitnessHigherDimensions(final double[][] lambda) {
      // Set all fitness values to zero
      for(int i = 0; i < nondominatedPopulation.size(); i++) {
         setFitness(nondominatedPopulation.get(i), 0.0);
      }

      for(final double[] element : lambda) {
         final double[] fitness = new double[nondominatedPopulation.size()];
         double minFitness = Double.MAX_VALUE;
         int indexMinFitness = 0;
         for(int j = 0; j < nondominatedPopulation.size(); j++) {
            fitness[j] = 0.0;
            for(int k = 0; k < element.length; k++) {
               fitness[j] += nondominatedPopulation.get(j).getObjective(k) * element[k];
            }
            if(fitness[j] < minFitness) {
               minFitness = fitness[j];
               indexMinFitness = j;
            }
         }
         Arrays.sort(fitness);
         final Solution update = nondominatedPopulation.get(indexMinFitness);
         setFitness(update, getFitness(update) + fitness[1] - minFitness, KEY_UTILITY_KNEE_FITNESS_HIGHER_DIMENSIONS);
         // update.setFitness(update.getFitness() + 1.0);
         // String print = "Lambda: ";
         // for(int a = 0 ; a < lambda[i].length ; a++) {
         // print += lambda[i][a] + " ";
         // }
         // print += "Point: " + update.toString();
         // System.out.println(print);

      }
   }

   /**
    * Each objective is multiplied by a weight. Weighted objectives are then
    * summed.
    *
    * @param weights
    *           A array of double values holding the weights by which
    *           individual objectives are multiplied.
    */
   public void weightedSumFitness(final double[] weights) {
      for(final Solution s : nondominatedPopulation) {
         setFitness(s, MathUtil.sum(MathUtil.multiply(s.getObjectives(), weights)), KEY_WEIGHTED_SUM_FITNESS);
      }
   }

   public double[] writeFitnessToArray(final NondominatedPopulation population) {
      final double[] fitness = new double[population.size()];
      int index = 0;
      for(final Solution s : population) {
         fitness[index++] = getFitness(s);
      }
      return fitness;
   }

   /**
    * Copies the objectives of the solution set to a matrix. Each row
    * represents the objective values of a single solution.
    *
    * @return A matrix containing the objectives
    */
   public double[][] writeObjectivesToMatrix(final NondominatedPopulation population) {
      if(population.size() == 0) {
         return null;
      }
      double[][] objectives;
      objectives = new double[population.size()][population.get(0).getNumberOfObjectives()];
      for(int i = 0; i < population.size(); i++) {
         for(int j = 0; j < population.get(0).getNumberOfObjectives(); j++) {
            objectives[i][j] = population.get(i).getObjective(j);
         }
      }
      return objectives;
   }
}
