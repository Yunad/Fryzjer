package com.fryzjerappbackend.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class CustomListener extends TestListenerAdapter {
    private static final Logger LOG = LogManager.getLogger(com.fryzjerappbackend.config.CustomListener.class);
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        LOG.info(" Test{}",iTestResult.getName());
        super.onTestSuccess(iTestResult);
    }


}

