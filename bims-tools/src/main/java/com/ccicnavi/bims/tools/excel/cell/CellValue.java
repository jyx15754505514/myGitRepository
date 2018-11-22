package com.ccicnavi.bims.tools.excel.cell;

/**
 * 抽象的单元格值接口，用于判断不同类型的单元格值
 * 
 * @param <T> 值得类型
 */
public interface CellValue<T> {
	/**
	 * 获取单元格值
	 * 
	 * @return 值
	 */
	T getValue();
}
