package academy.devdojo.maratonajava.javacore.Sformatacao.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SimpleDateFormatTest01 {
    public static void main(String[] args) {
        String pattern = "'Belém', dd 'de' MMMM 'de' yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        System.out.println(sdf.format(Calendar.getInstance().getTime()));

        // Formatação inversa (Voltando para o padrão Date ou Calendar output, etc..)
        try {
            System.out.println(sdf.parse("Belém, 23 de March de 2022"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
