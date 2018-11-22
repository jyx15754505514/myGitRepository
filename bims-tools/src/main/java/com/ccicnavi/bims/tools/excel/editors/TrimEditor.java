package com.ccicnavi.bims.tools.excel.editors;

import cn.hutool.core.util.StrUtil;
import com.ccicnavi.bims.tools.excel.cell.CellEditor;
import org.apache.poi.ss.usermodel.Cell;

/**
 * 去除String类型的单元格值两边的空格
 *
 */
public class TrimEditor implements CellEditor {

	@Override
	public Object edit(Cell cell, Object value) {
		if(value instanceof String) {
			return StrUtil.trim((String)value);
		}
		return value;
	}

}
