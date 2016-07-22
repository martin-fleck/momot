package at.ac.tuwien.big.momot.examples.ecore;

public class CaseStudy {

   public static CaseStudy MINI_HTML = new CaseStudy("MiniHTML", "input/MiniHTML.xmi", 18, 18, 5);

   public static CaseStudy HTML = new CaseStudy("HTML", "input/HTML_module.xmi", 62, 62, 62);
   public static CaseStudy JAVA = new CaseStudy("JAVA", "input/JAVA_module.xmi", 132, 132, 132);
   public static CaseStudy OCL = new CaseStudy("OCL", "input/OCL_module.xmi", 77, 77, 77);
   public static CaseStudy QVT = new CaseStudy("QVT", "input/QVT_module.xmi", 151, 151, 151);

   protected String name;
   protected String inputModel;
   protected int nrEntities;
   protected int solutionLength;
   protected int nrModules;

   public CaseStudy(final String name, final String inputModel, final int nrEntities) {
      this(name, inputModel, nrEntities, nrEntities, nrEntities);
   }

   public CaseStudy(final String name, final String inputModel, final int nrEntities, final int solutionLength) {
      this(name, inputModel, nrEntities, solutionLength, nrEntities);
   }

   public CaseStudy(final String name, final String inputModel, final int nrEntities, final int solutionLength,
         final int nrModules) {
      this.name = name;
      this.inputModel = inputModel;
      this.nrEntities = nrEntities;
      this.solutionLength = solutionLength;
      this.nrModules = nrModules;
   }

   public String getInputModel() {
      return inputModel;
   }

   public String getName() {
      return name;
   }

   public int getNrEntities() {
      return nrEntities;
   }

   public int getNrModules() {
      return nrModules;
   }

   public int getSolutionLength() {
      return solutionLength;
   }

   public void setInputModel(final String inputModel) {
      this.inputModel = inputModel;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setNrEntities(final int nrEntities) {
      this.nrEntities = nrEntities;
   }

   public void setNrModules(final int nrModules) {
      this.nrModules = nrModules;
   }

   public void setSolutionLength(final int solutionLength) {
      this.solutionLength = solutionLength;
   }
}
