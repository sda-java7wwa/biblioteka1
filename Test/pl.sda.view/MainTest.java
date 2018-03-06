package pl.sda.view;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by x on 2018-03-05 at 19:35
 */
public class MainTest //extends TestCase{
{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanup() {
        System.setOut(System.out);
        System.setIn(System.in);
    }

    @Test
    public void mainTest() throws Exception {
        String newLine = System.getProperty("line.separator");

        String inputData =


                "2" + newLine +
                "Krzysztof" + newLine +
                "Krupa" + newLine +
                "Krisu" + newLine +
                "123456" + newLine +
                "123456" + newLine;

        String expectedOut =
                "Wybierz:" + newLine +
                "1 - Logowanie" + newLine +
                "2 - Rejestracja" + newLine +
                "0 - Zakonczenie Programu" + newLine +

                "Podaj Imie:" + newLine +

                "Podaj Nazwisko:" + newLine +

                "Podaj Login:" + newLine +

                "Podaj Hasło:" + newLine +

                "Podaj Hasło (potwierdzenie):" + newLine +
                "Nie udało pobrać się z bazy" + newLine ;

              //  "" + newLine;

        System.setIn(new ByteArrayInputStream(inputData.getBytes()));

        Main.main(new String[]{});

        assertEquals(expectedOut, outContent.toString());


    }

//    public static void main(String[] args) {
//        junit.textui.TestRunner.run(MainTest.class);
//    }
}
