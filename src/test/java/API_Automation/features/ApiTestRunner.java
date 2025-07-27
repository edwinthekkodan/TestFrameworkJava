package API_Automation.features;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.Test;

public class ApiTestRunner {
    
    @Test
    public void testApi() {
        Results results = Runner.path("classpath:API_Automation/api").parallel(1);
        System.out.println("Features run: " + results.getFeaturesTotal());
        System.out.println("Scenarios run: " + results.getScenariosTotal());
        System.out.println("Failed: " + results.getFailCount());
        if (results.getFailCount() > 0) {
            throw new RuntimeException("There are test failures");
        }
    }
}