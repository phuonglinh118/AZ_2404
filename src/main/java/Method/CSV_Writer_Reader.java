package Method;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSV_Writer_Reader {
    private static final String COMMA = ",";
    private static final String DEFAULT_SEPARATOR = COMMA;
    private static final String DOUBLE_QUOTES = "\"";
    private static final String EMBEDDED_DOUBLE_QUOTES = "\"\"";
    private static final String NEW_LINE_UNIX = "\n";
    private static final String NEW_LINE_WINDOWS = "\r\n";

//    public static void main(String[] args) throws IOException {
//
//        CSV_Writer_Reader writer = new CSV_Writer_Reader();
//        writer.writeToCsvFile(createCsvDataSpecial(), new File("src/main/resources/CSV/monitor.csv"));
//
//    }

    public static String convertToCsvFormat(final String[] line) {
        return convertToCsvFormat(line, DEFAULT_SEPARATOR);
    }

    public static String convertToCsvFormat(final String[] line, final String separator) {
        return convertToCsvFormat(line, separator, true);
    }

    // if quote = true, all fields are enclosed in double quotes
    public static String convertToCsvFormat(
            final String[] line,
            final String separator,
            final boolean quote) {

        return Stream.of(line)                              // convert String[] to stream
                .map(l -> formatCsvField(l, quote))         // format CSV field
                .collect(Collectors.joining(separator));    // join with a separator

    }

    // put your extra login here
    public static String formatCsvField(final String field, final boolean quote) {

        String result = field;

        if (result.contains(COMMA)
                || result.contains(DOUBLE_QUOTES)
                || result.contains(NEW_LINE_UNIX)
                || result.contains(NEW_LINE_WINDOWS)) {

            // if field contains double quotes, replace it with two double quotes \"\"
            result = result.replace(DOUBLE_QUOTES, EMBEDDED_DOUBLE_QUOTES);

            // must wrap by or enclosed with double quotes
            result = DOUBLE_QUOTES + result + DOUBLE_QUOTES;

        } else {
            // should all fields enclosed in double quotes
            if (quote) {
                result = DOUBLE_QUOTES + result + DOUBLE_QUOTES;
            }
        }

        return result;

    }

    // a standard FileWriter, CSV is a normal text file
    public static void writeToCsvFile(List<String[]> list, File file) throws IOException {
        List<String> collect = list.stream()
                .map(CSV_Writer_Reader::convertToCsvFormat) //static thay this = className
                .collect(Collectors.toList());

        // CSV is a normal text file, need a writer
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String line : collect) {
                bw.write(line);
                bw.newLine();
            }
        }
    }
    public static void writeToCsvFile_String(String line, File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String getLine = br.readLine();
        long countLine = br.lines().count();
        if (getLine != null){
            System.out.println("Line: " + getLine);
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                bw.write(getLine);
                bw.newLine();
                bw.write(line);
                bw.newLine();
            }
        }
        else {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                bw.write(line);
                bw.newLine();
            }
        }
    }
    public static void readAndWrite_Scanner (String line, File file) throws Exception {
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()){
        }
    }

    private static List<String[]> createCsvDataSpecial() {
        String[] header = {"Make", "Model", "Description", "Price"};
        String[] record1 = {"Dell", "P3421W", "Dell 34, Curved, USB-C Monitor", "2499.00"};
        String[] record2 = {"Dell", "", "Alienware 38 Curved \"Gaming Monitor\"", "6699.00"};
        String[] record3 = {"Samsung", "", "49\" Dual QHD, QLED, HDR1000", "6199.00"};
        String[] record4 = {"Samsung", "", "Promotion! Special Price\n49\" Dual QHD, QLED, HDR1000", "4999.00"};
        List<String[]> list = new ArrayList<>();
        list.add(header);
        list.add(record1);
        list.add(record2);
        list.add(record3);
        list.add(record4);
        return list;
    }
}
