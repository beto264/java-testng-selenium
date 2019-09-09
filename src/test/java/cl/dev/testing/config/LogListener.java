package cl.dev.testing.config;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class LogListener implements ITestListener {

  private static final Logger LOGGER = LoggerFactory.getLogger(LogListener.class);

  private static final String TESTS_OK_TAG = "TESTS CORRECTOS";
  private static final String TESTS_NOK_TAG = "TESTS FALLIDOS";
  private static final String TESTS_FINAL_MESSAGE_TAG = "TESTS COMPLETADOS A LAS: ";

  @Override
  public void onFinish(ITestContext testContext) {
    LOGGER.info(TESTS_OK_TAG + "(" + testContext.getPassedTests().size() + ")");
    testContext.getPassedTests().getAllResults()
            .forEach(result -> {
              LOGGER.info(result.getName());
            });

    LOGGER.info(TESTS_NOK_TAG + "(" + testContext.getFailedTests().size() + ")");

    testContext.getFailedTests().getAllResults()
            .forEach(result -> {
              LOGGER.info(result.getName());
            });

    Long dateTime = testContext.getEndDate().getTime();
    DateTime someDate = new DateTime(Long.valueOf(dateTime), DateTimeZone.getDefault());
    DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    DateTime jodatime = dtf.parseDateTime(someDate.toString());
    DateTimeFormatter dtfOut = DateTimeFormat.forPattern("HH:mm:ss.SSS dd-MM-yyyy");

    LOGGER.info(
            TESTS_FINAL_MESSAGE_TAG + dtfOut.print(jodatime));
  }

  @Override
  public void onTestStart(ITestResult iTestResult) {

  }

  @Override
  public void onTestSuccess(ITestResult iTestResult) {

  }

  @Override
  public void onTestFailure(ITestResult iTestResult) {

  }

  @Override
  public void onTestSkipped(ITestResult iTestResult) {

  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

  }

  @Override
  public void onStart(ITestContext iTestContext) {

  }

}
