package com.util.excel;

import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import com.plan.model.MonthPlan;

public class ExcelUtil {

    /**
     * 创建excel文档，
     * @param list 数据
     * @param keys list中map的key数组集合
     * @param columnNames excel列名
     * */

	
    public static Workbook createWorkBook(List<Map<String, Object>> list,String []keys,String columnNames[],MonthPlan monthPlan2) {
    	
    	
    	// 创建excel工作簿
    	HSSFWorkbook wb = new HSSFWorkbook();
    	//合并单元格（行）
    	CellRangeAddress callRangeAddress = new CellRangeAddress(0,0,0,7);//起始行,结束行,起始列,结束列
    	CellRangeAddress callRangeAddress20 = new CellRangeAddress(1,1,0,7);//起始行,结束行,起始列,结束列
       /* CellRangeAddress callRangeAddress21 = new CellRangeAddress(1,1,2,4);//起始行,结束行,起始列,结束列
        CellRangeAddress callRangeAddress22 = new CellRangeAddress(1,1,5,7);//起始行,结束行,起始列,结束列
*/      
      
       
        // 创建第一个sheet（页），并命名
    	HSSFSheet sheet = wb.createSheet("月计划");
        // 手动设置列宽。第一个参数表示要为第几列设；，第二个参数表示列的宽度，n为列高的像素数。
       /* for(int i=0;i<keys.length;i++){
            sheet.setColumnWidth((short) i, (short) (35.7 * 150));
        }*/
    	//单元格宽度设置（列）
    	int number=0;
    	int inumber=0;
    	 sheet.setColumnWidth((short) 0, (short) (11 * 250));
    	 sheet.setColumnWidth((short) 1, (short) (31.5 * 250));
    	 sheet.setColumnWidth((short) 2, (short) (16 * 250));
    	 sheet.setColumnWidth((short) 3, (short) (27.5 * 250));
    	 sheet.setColumnWidth((short) 4, (short) (8.5 * 250));
    	 sheet.setColumnWidth((short) 5, (short) (21 * 250));
    	
    	 sheet.setColumnWidth((short) 6, (short) (10 * 250));
    	 sheet.setColumnWidth((short) 7, (short) (11 * 250));
    	 
    	 
    	 
    	 
    	//方法样式
        HSSFCellStyle headStyle = createCellStyle(wb,(short)20,true,true,false);
        HSSFCellStyle headStyle2 = createCellStyle(wb,(short)14,false,false,true);
        HSSFCellStyle headStyle3 = createCellStyle(wb,(short)14,false,true,true);
        HSSFCellStyle headStyle4 = createCellStyle(wb,(short)14,true,false,true);
       
      
        HSSFCellStyle sanStyle = createCellStyle(wb,(short)12,false,true,false);
        HSSFCellStyle cellStyle = createCellStyle(wb,(short)12,false,true,true);
        HSSFCellStyle sanStyle2 = createCellStyle(wb,(short)12,false,false,false);
        //标题样式
        HSSFCellStyle colStyle = createCellStyle(wb,(short)12,false,true,true);
        //加载合并的单元格样式
        sheet.addMergedRegion(callRangeAddress);
    
        sheet.addMergedRegion(callRangeAddress20);
       /* sheet.addMergedRegion(callRangeAddress21);
        sheet.addMergedRegion(callRangeAddress22);*/
      
        
        //3.1创建头标题行;并且设置头标题
        HSSFRow row = sheet.createRow(0);
        //创建行0为第1行
        HSSFCell cell2 = row.createCell(0);
        //加载单元格样式
        cell2.setCellStyle(headStyle);
        cell2.setCellValue("月度计划工作表");
       
        HSSFRow rowsan = sheet.createRow(1);
        HSSFCell cellsan = rowsan.createCell(0);
        HSSFCell cellsani = rowsan.createCell(2);
        HSSFCell cellsanii = rowsan.createCell(5);
        
        //加载单元格样式
       
        cellsan.setCellStyle(sanStyle);
        cellsan.setCellValue("协作单位："+monthPlan2.getDepartmentname()
        		+"                         员工姓名："+monthPlan2.getName()
        		+"                         考评时段："+monthPlan2.getMonths()+"月1日——"+monthPlan2.getMonths()+"月30日");
        /*cellsani.setCellStyle(sanStyle);
        cellsani.setCellValue("员工姓名："+monthPlan2.getName());
        cellsanii.setCellStyle(sanStyle);
        cellsanii.setCellValue("考评时段："+monthPlan2.getMonths()+"月1日——"+monthPlan2.getMonths()+"月30日");*/
       
       
      /*  //设置列名
        HSSFRow row2 = sheet.createRow(3);
        for(int i=0;i<columnNames.length;i++){
            Cell cell = row2.createCell(i);
            cell.setCellValue(columnNames[i]);
            cell.setCellStyle(cs);
        }*/
        HSSFRow row2 = sheet.createRow(2);
     
        for(int i=0;i<columnNames.length;i++)
        {
            HSSFCell cell3 = row2.createCell(i);
            //加载单元格样式
            cell3.setCellStyle(colStyle);
            cell3.setCellValue(columnNames[i]);
         }
        HSSFRow  rowsan2  = sheet.createRow(3);
        HSSFCell cellsan1 = rowsan2.createCell(0);
        HSSFCell cellsan2 = rowsan2.createCell(1);
        HSSFCell cellsan3 = rowsan2.createCell(2);
        HSSFCell cellsan4 = rowsan2.createCell(3);
        HSSFCell cellsan5 = rowsan2.createCell(4);
        HSSFCell cellsan6 = rowsan2.createCell(5);
        HSSFCell cellsan7 = rowsan2.createCell(6);
        HSSFCell cellsan8 = rowsan2.createCell(7);
        cellsan1.setCellStyle(colStyle);
        cellsan1.setCellValue("岗位职责");
        cellsan2.setCellStyle(colStyle);
        cellsan2.setCellValue("详见《岗位职责说明书》");
        cellsan3.setCellStyle(colStyle);
        cellsan3.setCellValue("");
        cellsan4.setCellStyle(colStyle);
        cellsan4.setCellValue("按规定时间保质保量完成");
        cellsan5.setCellStyle(colStyle);
        cellsan5.setCellValue("");
        cellsan6.setCellStyle(colStyle);
        cellsan6.setCellValue("完成");
        cellsan7.setCellStyle(colStyle);
        cellsan7.setCellValue("");
        cellsan8.setCellStyle(colStyle);
        cellsan8.setCellValue("");
        
        //加载单元格样式
       
      
        //设置单元格高度
        wb.getSheetAt(0).getRow(0).setHeight((short)850);
      	 wb.getSheetAt(0).getRow(1).setHeight((short)650);
      	wb.getSheetAt(0).getRow(2).setHeight((short)870);
    	wb.getSheetAt(0).getRow(3).setHeight((short)870);
/*      	wb.getSheetAt(0).getRow(3).setHeight((short)750);*/
        //设置每行每列的值
    	
        for (short i = 1; i < list.size(); i++) {
        	
                //创建数据行,前面有两行,头标题行和列标题行
                HSSFRow row3 = sheet.createRow(i+3);
                HSSFCell cell0 = row3.createCell(1);
                cell0.setCellStyle(cellStyle);
               inumber=i;
                number=i+3;
            // Row 行,Cell 方格 , Row 和 Cell 都是从0开始计数的
            // 创建一行，在页sheet上
           /* Row row1 = sheet.createRow((short) i);*/
            // 在row行上创建一个方格
               
            for(short j=0;j<keys.length;j++){
                Cell cell = row3.createCell(j);
                cell.setCellValue(list.get(i).get(keys[j]) == null?" ": list.get(i).get(keys[j]).toString());
                cell.setCellStyle(colStyle);
            }
            HSSFCell cell00 = row3.createCell(0);
            cell00.setCellStyle(colStyle);
            cell00.setCellValue("计划内重点工作");
        	wb.getSheetAt(0).getRow(i+3).setHeight((short)870);
        }
        //style方法单元格边框，必须创建列不然无效
        CellRangeAddress callRangeAddress31 = new CellRangeAddress(number+1,number+2,0,0);//起始行,结束行,起始列,结束列
        HSSFRow row4 = sheet.createRow(number+1);
        HSSFCell cell4 = row4.createCell(0);
        HSSFCell cell41 =row4.createCell(1);
        HSSFCell cell42 =row4.createCell(2);
        HSSFCell cell43 =row4.createCell(3);
        HSSFCell cell44 =row4.createCell(4);
        HSSFCell cell45 =row4.createCell(5);
        HSSFCell cell46 =row4.createCell(6);
        HSSFCell cell47 =row4.createCell(7);
        
        cell4.setCellStyle(cellStyle); cell41.setCellStyle(cellStyle);
        cell42.setCellStyle(cellStyle); cell43.setCellStyle(cellStyle);
        cell44.setCellStyle(cellStyle); cell45.setCellStyle(cellStyle);
        cell46.setCellStyle(cellStyle); cell47.setCellStyle(cellStyle);
        HSSFRow row5 = sheet.createRow(number+2);
        HSSFCell cell5 = row5.createCell(0);
        HSSFCell cell51 =row5.createCell(1);
        HSSFCell cell52 =row5.createCell(2);
        HSSFCell cell53 =row5.createCell(3);
        HSSFCell cell54 =row5.createCell(4);
        HSSFCell cell55 =row5.createCell(5);
        HSSFCell cell56 =row5.createCell(6);
        HSSFCell cell57 =row5.createCell(7);
        cell5.setCellStyle(cellStyle);
        cell51.setCellStyle(cellStyle);  cell52.setCellStyle(cellStyle);
        cell53.setCellStyle(cellStyle);  cell54.setCellStyle(cellStyle);
        cell55.setCellStyle(cellStyle);  cell56.setCellStyle(cellStyle);  cell57.setCellStyle(cellStyle);
        cell4.setCellValue("其他新增及领导交办任务");
        CellRangeAddress callRangeAddress23 = new CellRangeAddress(number-(inumber-1),number,0,0);//起始行,结束行,起始列,结束列
        CellRangeAddress callRangeAddress24 = new CellRangeAddress(number+3,number+3,0,1);//起始行,结束行,起始列,结束列
        CellRangeAddress callRangeAddress25 = new CellRangeAddress(number+3,number+3,2,4);//起始行,结束行,起始列,结束列
        CellRangeAddress callRangeAddress26 = new CellRangeAddress(number+4,number+4,0,1);//起始行,结束行,起始列,结束列
        CellRangeAddress callRangeAddress27 = new CellRangeAddress(number+4,number+4,2,4);//起始行,结束行,起始列,结束列
        CellRangeAddress callRangeAddress28 = new CellRangeAddress(number+5,number+5,0,1);//起始行,结束行,起始列,结束列
        CellRangeAddress callRangeAddress29 = new CellRangeAddress(number+5,number+5,2,4);//起始行,结束行,起始列,结束列
        CellRangeAddress callRangeAddress30 = new CellRangeAddress(number+6,number+6,0,4);//起始行,结束行,起始列,结束列
        sheet.addMergedRegion(callRangeAddress23);
        sheet.addMergedRegion(callRangeAddress24);
        sheet.addMergedRegion(callRangeAddress25);
        sheet.addMergedRegion(callRangeAddress26);
        sheet.addMergedRegion(callRangeAddress27);
        sheet.addMergedRegion(callRangeAddress28);
        sheet.addMergedRegion(callRangeAddress29);
        sheet.addMergedRegion(callRangeAddress30);
        sheet.addMergedRegion(callRangeAddress31);
        HSSFRow rowsan6 = sheet.createRow(number+3);
        HSSFCell cellsan66 = rowsan6.createCell(0);
        HSSFCell cellsan61 = rowsan6.createCell(1); HSSFCell cellsan62 = rowsan6.createCell(2);
        HSSFCell cellsan63 = rowsan6.createCell(3); HSSFCell cellsan64 = rowsan6.createCell(4);
        HSSFCell cellsan55 = rowsan6.createCell(5); HSSFCell cellsan67 = rowsan6.createCell(6);
        HSSFCell cellsan68 = rowsan6.createCell(7); 
        cellsan66.setCellStyle(headStyle2);cellsan61.setCellStyle(headStyle2);
        cellsan62.setCellStyle(headStyle2);cellsan63.setCellStyle(headStyle2);
        cellsan64.setCellStyle(headStyle2);cellsan67.setCellStyle(headStyle2);
        cellsan68.setCellStyle(headStyle2);cellsan66.setCellStyle(headStyle2);
        cellsan66.setCellValue("受表扬情况说明");
        cellsan55.setCellStyle(headStyle3);
        cellsan55.setCellValue("表扬加分");
        HSSFRow rowsan7 = sheet.createRow(number+4);
        HSSFCell cellsan77 = rowsan7.createCell(0);
        HSSFCell cellsan71 = rowsan7.createCell(1);
        HSSFCell cellsan72 = rowsan7.createCell(2);
        HSSFCell cellsan73 = rowsan7.createCell(3);
        HSSFCell cellsan74 = rowsan7.createCell(4);
        HSSFCell cellsan777 = rowsan7.createCell(5);
        HSSFCell cellsan76 = rowsan7.createCell(6);
        HSSFCell cellsan78 = rowsan7.createCell(7);
        cellsan77.setCellStyle(headStyle2);  cellsan71.setCellStyle(headStyle2);
        cellsan72.setCellStyle(headStyle2);  cellsan73.setCellStyle(headStyle2);
        cellsan74.setCellStyle(headStyle2);  cellsan76.setCellStyle(headStyle2);  cellsan78.setCellStyle(headStyle2);
        cellsan77.setCellValue("受批评情况说明");
        cellsan777.setCellStyle(headStyle3);
        cellsan777.setCellValue("批评加分");
        HSSFRow rowsan8 = sheet.createRow(number+5);
        HSSFCell cellsan88 = rowsan8.createCell(0);
        HSSFCell cellsan888 = rowsan8.createCell(2);
        HSSFCell cellsan81 = rowsan8.createCell(1);HSSFCell cellsan82 = rowsan8.createCell(3);
        HSSFCell cellsan83 = rowsan8.createCell(4);HSSFCell cellsan84 = rowsan8.createCell(5);
        HSSFCell cellsan85 = rowsan8.createCell(6);HSSFCell cellsan86 = rowsan8.createCell(7);
        cellsan88.setCellStyle(headStyle4);cellsan82.setCellStyle(headStyle4);
        cellsan81.setCellStyle(headStyle4);cellsan83.setCellStyle(headStyle4);
        cellsan84.setCellStyle(headStyle4);cellsan85.setCellStyle(headStyle4);
        cellsan86.setCellStyle(headStyle4);
        cellsan88.setCellValue("加减分汇总");
        cellsan888.setCellStyle(headStyle4);
        cellsan888.setCellValue("本月绩效得分");
        HSSFRow rowsan9 = sheet.createRow(number+6);
        HSSFCell cellsan9 = rowsan9.createCell(0);
        cellsan9.setCellStyle(sanStyle);
        cellsan9.setCellValue("部门负责人：                                        " +
        		"                               " +
        		"                         集团分管领导：");
        
      
        wb.getSheetAt(0).getRow(number+1).setHeight((short)870);
        wb.getSheetAt(0).getRow(number+2).setHeight((short)870);
        wb.getSheetAt(0).getRow(number+3).setHeight((short)870);
        wb.getSheetAt(0).getRow(number+4).setHeight((short)870);
        wb.getSheetAt(0).getRow(number+5).setHeight((short)870);
        wb.getSheetAt(0).getRow(number+6).setHeight((short)870);
      
        return wb;
    }
    private static HSSFCellStyle createCellStyle(HSSFWorkbook workbook, short fontsize,boolean flag,boolean flag1,boolean flag2) {
        // TODO Auto-generated method stub
        HSSFCellStyle style = workbook.createCellStyle();
        
        style.setWrapText(true);    
      
        //是否水平居中
        if(flag1){
        	style.setAlignment(CellStyle.ALIGN_CENTER);//水平居中
        }
       
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//垂直居中
        //创建字体
        HSSFFont font = workbook.createFont();
        //是否加粗字体
        if(flag){
            font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        }
        font.setFontHeightInPoints(fontsize);
        //加载字体
        style.setFont(font);
        
        if(flag2){
        style.setBorderBottom(CellStyle.BORDER_THIN); //下边框
        style.setBorderLeft(CellStyle.BORDER_THIN);//左边框
        style.setBorderTop(CellStyle.BORDER_THIN);//上边框
        style.setBorderRight(CellStyle.BORDER_THIN);//右边框
        }
        return style;
    }
}
