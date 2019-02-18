package com.util.page;

import java.util.List;

public class DataGrid {
	
	private static final DataGrid datagrid=DataGrid.init();

	private Long total;
	
	private List<?> rows;

	public DataGrid(){}
	
	public static DataGrid init(){
		return new DataGrid();
	}
	
	public DataGrid(Long total,List<?> rows){
		this.total=total;
		this.rows=rows;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public static DataGrid getDatagrid() {
		return datagrid;
	}

	
}
