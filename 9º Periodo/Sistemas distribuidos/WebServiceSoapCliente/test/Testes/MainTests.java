package Testes;

import java.text.NumberFormat;
import java.util.Locale;

public class MainTests {

    public static void main(String[] args) {
        NumberFormat numberFormat = NumberFormat.getInstance(new Locale("pt", "BR"));
        numberFormat.setMaximumFractionDigits(2);
        float numero1 = (float) 15.57564564;
        float numero2 = (float) 12.25456465;
        System.out.println(numberFormat.format(numero1));
        System.out.println(numberFormat.format(numero2));
    }
}
