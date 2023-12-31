package day14;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class C01_ReadExcel {
    @Test
    public void ReadExcelTest() throws IOException {
        //- Dosya yolunu bir String degiskene atayalim
        String dosyaYolu=".\\src\\resources\\ulkeler.xlsx";
        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);
        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //- WorkbookFactory.create(fileInputStream)
        Workbook workbook=WorkbookFactory.create(fis);//Workbook objesiyle fis oblesi ile akışa aldığımız dosyamızla bir excell dosyası create ettik
        //- Sheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet=workbook.getSheet("Sayfa1");//Excel dosyamızda çalışmak istediğimiz sayfayı bu şekilde seçeriz
        //- Row objesi olusturun sheet.getRow(index)
        Row row=sheet.getRow(3);
        //- Cell objesi olusturun row.getCell(index)
        Cell cell=row.getCell(2);
        //- 3. index'deki satirin 3. index'indeki datanin Cezayir oldugunu test edin
        String expectedData="Cezayir";
        String actualData=cell.toString();
        Assert.assertEquals(expectedData,actualData);
        System.out.println(actualData);
    }
}