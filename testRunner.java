import org.testng.TestNG;
import java.util.Collections;

public class testRunner {
    public static void main(String[] args) {
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[]{
                Language.class,
                Categories.class,
                NavBar.class,
                Skills.class,
                Logic.class,
                SearchBar.class,
                Trivia.class,
                Atari.class
        });
        testng.setVerbose(2); //Detailed Logging
        testng.setDefaultSuiteName("CoolMathGameSuite");
        testng.setDefaultTestName("AllFeatureTests");
        testng.run();
    }
}
