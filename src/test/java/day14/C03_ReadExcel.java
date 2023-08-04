package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
public class C03_ReadExcel {
    @Test
    public void readExcel() throws IOException {
        //Belirtilen satırNo ve sutunNo değerlerini parametre olarak alıp o cell'deki datayı konsola yazdıralım
        //Sonucun konsolda yazanla aynı olduğunu doğrulayın
        int satir=4;
        int sutun=2;
        String dosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        String actualData=workbook.getSheet("Sayfa1").getRow(satir-1).getCell(sutun-1).toString();
        String expectedData="Aljiers";
        Assert.assertEquals(expectedData,actualData);
    }
}