package retry;


import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class danielRetry implements IRetryAnalyzer {
    private int maxRetries = 2;
    private int retryCount =0;

    public boolean retry(ITestResult iTestResult) {
        if (retryCount < maxRetries) {
            retryCount++;
            return true;
        }
             return false;
    }
}
