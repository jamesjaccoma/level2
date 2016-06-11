/*This code is was adapted from a 6 year old blog post I found, it was created by the owner ofthe Silent Development blog
*/
public class Runner {
 
private final static int MIN_HEAP = 511;
private final static int RECOMMENDED_HEAP = 1024;

 public static void main(String[] args) throws Exception {

    // Do we have enough memory already (some VMs and later Java 6
    // revisions have bigger default heaps based on total machine memory)?
    float heapSizeMegs = (Runtime.getRuntime().maxMemory()/1024)/1024;

    // Yes so start
    if (heapSizeMegs > MIN_HEAP) {
      Main.main(args);



 } else {
      String pathToJar = Runner.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
      ProcessBuilder pb = new ProcessBuilder("java","-Xmx"+RECOMMENDED_HEAP+"m", "-classpath", pathToJar, "Main");
      pb.start();
    }
  }
}
