package com.ccicnavi.bims.tools;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.StrUtil;
import com.ccicnavi.bims.tools.excel.ExcelUtil;
import com.ccicnavi.bims.tools.excel.ExcelWriter;
import com.ccicnavi.bims.tools.excel.sax.Excel03SaxReader;
import com.ccicnavi.bims.tools.excel.sax.handler.RowHandler;
import com.ccicnavi.bims.tools.excel.style.StyleUtil;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.junit.Test;

import java.util.List;

/**
 * @Auther: husky
 * @Date: 2018/11/22 10:14
 * @Version 0.1
 * @Description:
 */
public class Demo {

    @Test
    public void readerExcel() {
        String path = "C:/test/testExcel6.xls";
        ExcelUtil.readBySax(path, 0, new RowHandler() {
            @Override
            public void handle(int sheetIndex, int rowIndex, List<Object> rowList) {
                if (StrUtil.isAllEmpty(Convert.toStrArray(rowList))) {
                    return;
                }
                Console.log(rowList);
            }
        });
    }

    @Test
    public void excel03Test() {
        Excel03SaxReader reader = new Excel03SaxReader(new RowHandler() {
            @Override
            public void handle(int sheetIndex, int rowIndex, List<Object> rowList) {

            }
        });
        reader.read("C:/test/testExcel.xls", 1);
//		Console.log("Sheet index: [{}], Sheet name: [{}]", reader.getSheetIndex(), reader.getSheetName());
        ExcelUtil.read03BySax("C:/test/testExcel.xls", -1, new RowHandler() {
            @Override
            public void handle(int sheetIndex, int rowIndex, List<Object> rowList) {
                Console.log(rowList);
            }
        });

    }

    @Test
    public void writeExcel(){
        List<?> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd", DateUtil.date(), 3.22676575765);
        List<?> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1", DateUtil.date(), 250.7676);
        List<?> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2", DateUtil.date(), 0.111);
        List<?> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3", DateUtil.date(), 35);
        List<?> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4", DateUtil.date(), 28.00);

        List<List<?>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);

        // 通过工具类创建writer
        String path = "C:/test/testExcel1.xls";
        FileUtil.del(path);
        ExcelWriter writer = ExcelUtil.getWriter(path);
        CellStyle style = writer.getStyleSet().getHeadCellStyle();
        StyleUtil.setColor(style, IndexedColors.RED, FillPatternType.SOLID_FOREGROUND);

        // 跳过当前行，既第一行，非必须，在此演示用
        writer.passCurrentRow();
        // 合并单元格后的标题行，使用默认标题样式
        writer.merge(row1.size() - 1, "测试标题");
        // 一次性写出内容，使用默认样式
        writer.write(rows);

        // 合并单元格后的标题行，使用默认标题样式
        writer.merge(7, 10, 4, 10, "测试Merge", false);

        // 关闭writer，释放内存
        writer.close();
    }

    @Test
    public void writeBeanTest() {
        TestBean bean1 = new TestBean();
        bean1.setName("张三");
        bean1.setAge(22);
        bean1.setPass(true);
        bean1.setScore(66.30);
        bean1.setExamDate(DateUtil.date());

        TestBean bean2 = new TestBean();
        bean2.setName("李四");
        bean2.setAge(28);
        bean2.setPass(false);
        bean2.setScore(38.50);
        bean2.setExamDate(DateUtil.date());

        List<TestBean> rows = CollUtil.newArrayList(bean1, bean2);
        // 通过工具类创建writer
        String file = "C:/test/testExcel6.xls";
        FileUtil.del(file);
        ExcelWriter writer = ExcelUtil.getWriter(file);
        // 自定义标题
        writer.addHeaderAlias("name", "姓名");
        writer.addHeaderAlias("age", "年龄");
        writer.addHeaderAlias("score", "分数");
        writer.addHeaderAlias("isPass", "是否通过");
        writer.addHeaderAlias("examDate", "考试时间");
        // 合并单元格后的标题行，使用默认标题样式
        writer.merge(4, "一班成绩单");
        // 一次性写出内容，使用默认样式
        writer.write(rows);
        // 关闭writer，释放内存
        writer.close();
    }
}
