package genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplementation implements IRetryAnalyzer {

	int count=1;
	int maxCount =5;
	
	@Override
	public boolean retry(ITestResult result) {
		//1<=5 -> true -> retry... 2<=5 -> true -> retry
		while(count<=maxCount) {
			count++;
			return true;
		}
		return false;
	}

}
