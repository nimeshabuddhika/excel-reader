package com.github.nimeshabuddhika;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Nimesha Buddhika on 8/27/2019 4:53 PM
 */
public class ExcelReader {


    public <T> List<T> read(Class<T> clazz, InputStream file) throws IOException, IllegalAccessException, InstantiationException {
        return read(clazz, file, 0);
    }

    public <T> List<T> read(Class<T> clazz, InputStream file, int sheetNumber) throws IOException, IllegalAccessException, InstantiationException {
        List<T> list = new ArrayList<>();

        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(sheetNumber);

        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();
        Row row;

        int fieldNo;
        while (rowIterator.hasNext()) {
            row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            T obj = clazz.newInstance();

            fieldNo = 0;
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                Field field = obj.getClass().getDeclaredFields()[fieldNo];
                switch (cell.getCellType()) {
                    case BOOLEAN:
                        field.set(obj, cell.getBooleanCellValue());
                        break;
                    case NUMERIC:
                        field.set(obj, cell.getNumericCellValue());
                        break;
                    case STRING:
                        field.set(obj, cell.getStringCellValue());
                        break;
                }
                fieldNo++;
            }
            list.add(obj);
        }
        return list;
    }
}
