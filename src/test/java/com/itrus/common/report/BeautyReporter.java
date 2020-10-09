package com.itrus.common.report;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ResourceCDN;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.TestAttribute;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.ExtentHtmlReporterConfiguration;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * 单元测试html报告生成器
 *
 * @author minghu.zhang
 */
public class BeautyReporter implements IReporter {

    //默认路径
    private static final String OUTPUT_FOLDER = "target/surefire-reports/";
    //报告文件名
    private static final String FILE_NAME = "report.html";
    //报告名称
    private static final String REPORT_NAME = "单元测试";

    /**
     * 生成报告
     */
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        ExtentReports report = getExtentReports();

        boolean createSuiteNode = false;
        if (suites.size() > 1) {
            createSuiteNode = true;
        }
        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();
            //如果suite里面没有任何用例，直接跳过，不在报告里生成
            if (result.size() == 0) {
                continue;
            }
            //统计suite下的成功、失败、跳过的总用例数
            int suiteFailSize = 0;
            int suitePassSize = 0;
            int suiteSkipSize = 0;
            ExtentTest suiteTest = null;
            //存在多个suite的情况下，在报告中将同一个一个suite的测试结果归为一类，创建一级节点。
            if (createSuiteNode) {
                suiteTest = report.createTest(suite.getName()).assignCategory(suite.getName());
            }
            boolean createSuiteResultNode = false;
            if (result.size() > 1) {
                createSuiteResultNode = true;
            }
            for (ISuiteResult r : result.values()) {
                ExtentTest resultNode;
                ITestContext context = r.getTestContext();
                if (createSuiteResultNode) {
                    //没有创建suite的情况下，将在SuiteResult的创建为一级节点，否则创建为suite的一个子节点。
                    if (null == suiteTest) {
                        resultNode = report.createTest(r.getTestContext().getName());
                    } else {
                        resultNode = suiteTest.createNode(r.getTestContext().getName());
                    }
                } else {
                    resultNode = suiteTest;
                }
                if (resultNode != null) {
                    resultNode.getModel().setName(suite.getName() + " : " + r.getTestContext().getName());
                    if (resultNode.getModel().hasCategory()) {
                        resultNode.assignCategory(r.getTestContext().getName());
                    } else {
                        resultNode.assignCategory(suite.getName(), r.getTestContext().getName());
                    }
                    resultNode.getModel().setStartTime(r.getTestContext().getStartDate());
                    resultNode.getModel().setEndTime(r.getTestContext().getEndDate());
                    //统计SuiteResult下的数据
                    int passSize = r.getTestContext().getPassedTests().size();
                    int failSize = r.getTestContext().getFailedTests().size();
                    int skipSize = r.getTestContext().getSkippedTests().size();
                    suitePassSize += passSize;
                    suiteFailSize += failSize;
                    suiteSkipSize += skipSize;
                    if (failSize > 0) {
                        resultNode.getModel().setStatus(Status.FAIL);
                    }
                    resultNode.getModel().setDescription(String.format("Pass: %s ; Fail: %s ; Skip: %s ;", passSize, failSize, skipSize));
                }
                buildTestNodes(report, resultNode, context.getFailedTests(), Status.FAIL);
                buildTestNodes(report, resultNode, context.getSkippedTests(), Status.SKIP);
                buildTestNodes(report, resultNode, context.getPassedTests(), Status.PASS);
            }
            if (suiteTest != null) {
                suiteTest.getModel().setDescription(String.format("Pass: %s ; Fail: %s ; Skip: %s ;", suitePassSize, suiteFailSize, suiteSkipSize));
                if (suiteFailSize > 0) {
                    suiteTest.getModel().setStatus(Status.FAIL);
                }
            }

        }

        report.flush();
    }

    /**
     * 创建报告对象
     *
     * @return 报告对象
     */
    private ExtentReports getExtentReports() {
        ExtentReports extent = new ExtentReports();
        File reportDir = new File(OUTPUT_FOLDER);
        if (!reportDir.exists() && !reportDir.isDirectory()) {
            boolean failure = !reportDir.mkdir();
            if (failure) {
                throw new RuntimeException("打包失败，创建文件夹" + reportDir + "失败，请确认有足够权限");
            }
        }
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(OUTPUT_FOLDER + FILE_NAME);

        ExtentHtmlReporterConfiguration config = htmlReporter.config();
        config.setDocumentTitle(REPORT_NAME);
        config.setReportName(REPORT_NAME);
        config.setChartVisibilityOnOpen(true);
        config.setTestViewChartLocation(ChartLocation.TOP);
        //设置标准主题STANDARD（默认）,DARK
        config.setTheme(Theme.STANDARD);
        config.setResourceCDN(ResourceCDN.EXTENTREPORTS);
        config.setCSS(".end-time{background:#6600BB} .node.level-1  ul{ display:none;} .node.level-1.active ul{display:block;} div.test-attributes>div{margin-bottom:10px;}");
        //设置时间格式
        config.setTimeStampFormat("yyyy-MM-dd HH:mm:ss.SSS");

        extent.attachReporter(htmlReporter);
        extent.setReportUsesManualConfiguration(true);

        return extent;
    }

    /**
     * 构建Test数据
     */
    private void buildTestNodes(ExtentReports report, ExtentTest extenttest, IResultMap tests, Status status) {
        //存在父节点时，获取父节点的标签
        String[] categories = new String[0];
        if (extenttest != null) {
            List<TestAttribute> categoryList = extenttest.getModel().getCategoryContext().getAll();
            categories = new String[categoryList.size()];
            for (int index = 0; index < categoryList.size(); index++) {
                categories[index] = categoryList.get(index).getName();
            }
        }

        ExtentTest test;
        if (tests.size() > 0) {
            //调整用例排序，按时间排序
            Set<ITestResult> treeSet = new TreeSet<>((o1, o2) -> {
                if (o1.getStartMillis() == o2.getStartMillis()) {
                    return 0;
                }
                return o1.getStartMillis() < o2.getStartMillis() ? -1 : 1;
            });
            treeSet.addAll(tests.getAllResults());
            for (ITestResult result : treeSet) {
                //获取调用Method
                Method method = result.getMethod().getConstructorOrMethod().getMethod();

                //设置描述
                String description = result.getMethod().getDescription() + "<br/>" + result.getMethod().getQualifiedName();

                //设置名称
                Test annotation = method.getDeclaredAnnotation(Test.class);
                String name = result.getMethod().getMethodName();
                //若设置TestName 则追加到测试名称
                if (!"".equals(annotation.testName().trim())) {
                    name += "[" + annotation.testName().trim() + "]";
                }

                if (status == Status.FAIL || status == Status.FATAL) {
                    name = "<span style=\"color:#FF0000 !important\"><b>" + name + "</b></span>";
                } else if (status == Status.SKIP) {
                    name = "<span style=\"color:#999999 !important\">" + name + "</span>";
                }

                if (extenttest == null) {
                    test = report.createTest(name, description);
                } else {
                    //作为子节点进行创建时，设置同父节点的标签一致，便于报告检索。
                    test = extenttest.createNode(name, description).assignCategory(categories);
                }

                //添加当前Group
                for (String group : result.getMethod().getGroups()) {
                    test.assignCategory(group);
                }

                //设置作者
                if (method.isAnnotationPresent(Author.class)) {
                    Author author = method.getDeclaredAnnotation(Author.class);
                    test.assignAuthor(author.names());
                }

                //将用例的log输出报告中
                List<String> outputList = Reporter.getOutput(result);
                for (String output : outputList) {
                    test.log(Status.DEBUG, "<pre>" + output + "</pre>");
                }

                //将异常信息输出到报告中
                if (result.getThrowable() != null) {
                    test.log(status, result.getThrowable());
                } else {
                    test.log(status, "<pre> Test " + status.toString().toLowerCase() + "ed </pre>");
                }

                test.getModel().setStartTime(new Date(result.getStartMillis()));
                test.getModel().setEndTime(new Date(result.getEndMillis()));
            }
        }
    }
}

