package com.bridgelabz.test;

import com.bridgelabz.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

public class WebTableHandle extends BaseClass {
    @Test
    public void staticWebTableHandle(){
        driver.get("https://demo.guru99.com/test/web-table-element.php");
        //No.of Columns
        List<WebElement> col = driver.findElements(By.xpath(".//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
        System.out.println("No of cols are : " +col.size());
        //No.of rows
        List <WebElement> rows = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
        System.out.println("No of rows are : " + rows.size());
    }

    @Test
    public void dynamicWebTableHandle(){
        driver.get("https://demo.guru99.com/test/web-table-element.php");
        WebElement baseTable = driver.findElement(By.tagName("table"));

        //To find third row of table
        WebElement tableRow = baseTable.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[3]"));
        String rowtext = tableRow.getText();
        System.out.println("Third row of table : "+rowtext);

        //to get 3rd row's 2nd column data
        WebElement cellIneed = tableRow.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[3]/td[2]"));
        String valueIneed = cellIneed.getText();
        System.out.println("Cell value is : " + valueIneed);
    }

    @Test
    public void getAllValueFromDynamicTable() {
        driver.get("https://demo.guru99.com/test/table.html");
        //To locate table.
        WebElement myTable = driver.findElement(By.xpath("/html/body/table/tbody"));
        //To locate rows of table.
        List < WebElement > rows_table = myTable.findElements(By.tagName("tr"));
        //To calculate no of rows In table.
        int rows_count = rows_table.size();
        //Loop will execute till the last row of table.
        for (int row = 0; row < rows_count; row++) {
            //To locate columns(cells) of that specific row.
            List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));
            //To calculate no of columns (cells). In that specific row.
            int columns_count = Columns_row.size();
            System.out.println("Number of cells In Row " + row + " are " + columns_count);
            //Loop will execute till the last cell of that specific row.
            for (int column = 0; column < columns_count; column++) {
                // To retrieve text from that specific cell.
                String celtext = Columns_row.get(column).getText();
                System.out.println("Cell Value of row number " + row + " and column number " + column + " Is " + celtext);
            }
            System.out.println("-------------------------------------------------- ");
        }
    }
}
