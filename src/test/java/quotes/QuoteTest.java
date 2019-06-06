package quotes;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class QuoteTest {

    @Test
    public void test_toString1() {
        Quote quote = new Quote(new ArrayList<String>(), "Ricky Bobby", "1", "I'm too drunk to taste this chicken");
        assertEquals("quotes should match",
                "Author: Ricky Bobby\n" +
                "Quote: I'm too drunk to taste this chicken",
                quote.toString() );
    }

    @Test(expected = IOException.class)
    public void test_bad_file_throws_IO() throws IOException {
        App.readFromJson("/thisisabadname");
    }

    @Test
    public void test_file_reads_properly() throws IOException {
        Quote[] test = App.readFromJson("src/main/resources/recentquotes.json");
        assertEquals("Size of array is 138", 138, test.length);
    }

    @Test
    public void test_file_reads_properly2() throws IOException {
        Quote[] test = App.readFromJson("src/main/resources/recentquotes.json");
        assertEquals("First quote is from Marilyn Monroe", "Marilyn Monroe", test[0].author);
    }

    @Test
    public void test_file_reads_properly3() throws IOException {
        Quote[] test = App.readFromJson("src/main/resources/recentquotes.json");
        assertEquals("Last quote is from 办理明尼苏达大学双城分校毕业证[学历认证University of Minnesota Twin Cities",
                "办理明尼苏达大学双城分校毕业证[学历认证University of Minnesota Twin Cities",
                test[137].author);
    }
}