/**
 * @author SargerasWang
 */
package com.itrus.common.excel;

import com.itrus.common.utils.excel.ExcelLog;
import com.itrus.common.utils.excel.ExcelLogs;
import com.itrus.common.utils.excel.ExcelUtil;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;


/**
 * <p>
 * 测试导入excel功能
 * </p>
 *
 * @author hzq
 * @since 2020/3/30
 */
public class TestImportExcel {
    /**
     * 导入excel 转为Bean集合
     *
     * @throws FileNotFoundException
     */
    @Test
    public void importXlsxBean() throws FileNotFoundException {
        File f = new File("src/test/resources/personBean.xlsx");
        InputStream inputStream = new FileInputStream(f);

        ExcelLogs logs = new ExcelLogs();
        Collection<TestBean> importExcel = ExcelUtil.importExcel(TestBean.class, inputStream, "yyyy/MM/dd HH:mm:ss", logs, 0);

        for (TestBean m : importExcel) {
            System.out.println(m.toString());
        }
        if (logs.getHasError()) {
            for (ExcelLog excelLog : logs.getErrorLogList()) {
                System.out.println("error:" + excelLog.getRowNum() + ", " + excelLog.getLog());
            }
        }
    }

    /**
     * 导入excel转为map集合
     * @throws FileNotFoundException
     */
    @Test
    public void importXlsxMap() throws FileNotFoundException {
        File f = new File("src/test/resources/personBean.xlsx");
        InputStream inputStream = new FileInputStream(f);

        ExcelLogs logs = new ExcelLogs();
        Collection<Map> importExcel = ExcelUtil.importExcel(Map.class, inputStream, "yyyy/MM/dd HH:mm:ss", logs, 0);

        for (Map m : importExcel) {
            System.out.println(m);
        }
    }

}
