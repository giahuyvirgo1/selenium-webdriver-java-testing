package javatester;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_01_Data_Type {
    // Kieu du lieu trong nhom java - 2 nhom

    // I - Kieu du lieu nguyen thuy (Primitive Type)
    // 8 loai
    // So nguyen: byte - short - int - long
    // So thuc: float - double
    // Co phan thap phan: diem/luong/....
    // Ki tu: char
    //Dai dien cho 1 ky tu
    char c = 's';
    // Logic: boolean
    // ket qua bai test: pass/fail
    boolean status = false;

    // II - Kieu du lieu tham chieu (Reference Type )
    //Class
    FirefoxDriver firefoxDriver = new FirefoxDriver();

    //Interface
    WebDriver driver;

    JavascriptExecutor javascriptExecutor;



    //Object
    Object name = "Auto FC";

    //Array
    int[] studentAge = {15,20,8};

    String[] studentName = {"auto", "test"};

    //Collection: List/Set/ Queue
    //String - chuoi ki tu
    //String name = "Minh";

    //Khai bao 1 bien de luu tru 1 loai du lieu nao do
    //Access Modifier: Pham vi truy cap (public/ private/ protected/ default)
    //Kieu du lieu
    //Ten bien
    //Gia tri cua bien - gan vao vs phep =
    //Neu nhu khong gan: du lieu mac dinh
}
