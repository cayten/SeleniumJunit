package day11;

public class C04_ileExist {

    /*
    import org.junit.Assert;
import org.junit.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
public class C04_FileExist {
    @Test
    public void name() {
        System.out.println(System.getProperty("user.dir"));//C:\Users\Ramazan\IdeaProjects\cananIleJunit
        //Şuanki içinde bulunduğum yolu gösterir
        System.out.println(System.getProperty("user.home"));//C:\Users\Ramazan
        //Geçerli kullanıcının ana dizinini verir
        String anaDizin=System.getProperty("user.home");
        String coverLetter="C:/Users/Ramazan/Desktop/coverletter.pdf";
        Assert.assertTrue(Files.exists(Paths.get(coverLetter)));
         /*
        Bir web sitesinden indirdiğimiz yada windows içinde oluşturduğumuz dosyanın indiğini yada orda olduğunu
        test edebilmem için o dosyanın üzerine shift tuşuna basılı olarak sağ klik yapıp dosyanın yolunu kopyalayıp
        bir string değişkene atarız ve dosyayı doğrulamak için
        Assert.assertTrue(Files.exists(Paths.get(coverLetter))); bu methodu kullanırız
         */
}



