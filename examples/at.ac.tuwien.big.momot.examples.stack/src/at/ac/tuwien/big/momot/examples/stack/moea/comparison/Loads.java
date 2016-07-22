package at.ac.tuwien.big.momot.examples.stack.moea.comparison;

import java.util.Random;

public class Loads {
   public static Integer[] createRandomLoads(final int nrStacks) {
      return createRandomLoads(nrStacks, nrStacks * 2);
   }

   public static Integer[] createRandomLoads(final int nrStacks, final int maxLoad) {
      final Integer[] loads = new Integer[nrStacks];
      for(int i = 0; i < nrStacks; i++) {
         loads[i] = new Random().nextInt(maxLoad);
      }
      return loads;
   }

   public static Integer[] getProblem100() {
      return new Integer[] { 107, 145, 175, 191, 62, 35, 53, 179, 68, 45, 136, 89, 155, 90, 64, 146, 167, 48, 126, 84,
            171, 124, 166, 45, 119, 52, 67, 88, 26, 134, 188, 147, 50, 158, 153, 99, 186, 113, 106, 138, 90, 17, 36, 59,
            110, 92, 95, 14, 192, 97, 131, 191, 17, 56, 171, 71, 97, 36, 183, 195, 163, 182, 157, 82, 59, 173, 43, 66,
            123, 147, 27, 37, 76, 49, 1, 66, 76, 139, 44, 191, 146, 173, 119, 46, 198, 176, 45, 166, 13, 69, 68, 194,
            192, 136, 81, 45, 49, 160, 86, 153 };
   }

   public static Integer[] getProblem15() {
      return new Integer[] { 23, 17, 6, 6, 20, 25, 29, 16, 21, 11, 20, 12, 25, 5, 8 };
   }

   public static Integer[] getProblem50() {
      return new Integer[] { 77, 49, 76, 41, 56, 86, 98, 0, 50, 76, 85, 98, 25, 57, 66, 13, 56, 75, 4, 31, 24, 23, 71,
            17, 69, 87, 18, 27, 21, 54, 36, 91, 58, 12, 36, 98, 42, 52, 61, 18, 99, 67, 22, 67, 97, 20, 66, 89, 81,
            84 };
   }
}
