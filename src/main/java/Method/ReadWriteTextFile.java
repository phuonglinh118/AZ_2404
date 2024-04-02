package Method;

import org.testng.annotations.Test;

import java.io.*;

public class ReadWriteTextFile {
    public static void createNewTextFile (String pathNameTextFile) throws Exception{
//        String pathNameTextFile = ""; //Create File In D: Driver.
        File fileClass = new File(pathNameTextFile); //Created object of java File class.
        fileClass.createNewFile(); //Create file.
    }
    public static void writingIntoTextFile (String pathNameTextFile, String output) throws Exception {
        try {
            //Create Object of java FileWriter and BufferedWriter class.
            FileWriter fw = new FileWriter(pathNameTextFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
//            bw.newLine(); //To write next string on new line.
            bw.append("c");
            bw.write(output); //Writing In To File.
            System.out.println("Writing In To File.");
        }
        catch (IOException exception){
            exception.printStackTrace();
        }
    }
    public static void writingIntoTextFile_FileWriter (String pathNameTextFile, String output) throws Exception {
        try {
            //Create Object of java FileWriter and BufferedWriter class.
            FileWriter fw = new FileWriter(pathNameTextFile,true);
           fw.write("ABC");
            System.out.println("Writing In To File.");
        }
        catch (IOException exception){
            exception.printStackTrace();
        }
    }
    public static void writingIntoTextFile_FileOutputStream (String pathNameTextFile, String output) throws Exception {
        try {
            FileOutputStream outputStream = new FileOutputStream(pathNameTextFile);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-16");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write(output);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writingIntoTextFile_FileOutputStream_offset (String pathNameTextFile, String output, int offset) throws Exception {
        try {
            FileOutputStream outputStream = new FileOutputStream(pathNameTextFile);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-16");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write(output,offset, 8);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void stopWritingIntoTextFile_FileOutputStream  (String pathNameTextFile) throws Exception {
        FileOutputStream outputStream = new FileOutputStream (pathNameTextFile);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-16");
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        bufferedWriter.close();
    }
    public static void stopWritingIntoTextFile (String pathNameTextFile) throws Exception {
        FileWriter fw = new FileWriter(pathNameTextFile);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.close();
    }

    public static String ReadingAllFromTextFile (String pathNameTextFile) throws Exception {
        String content;
        //Create Object of java FileReader and BufferedReader class.
        FileReader fReader = new FileReader(pathNameTextFile);
        BufferedReader bufferedReader = new BufferedReader(fReader);
        //Loop to read all lines one by one from file and print It.
        while ((content=bufferedReader.readLine())!=null){
            return content;
        }
        return null;
    }
    @Test
    public static void testWR () throws Exception {
        String pathNameTextFile = "src/main/resources/TextFile/log.txt";
        createNewTextFile(pathNameTextFile);
//        writingIntoTextFile(pathNameTextFile, "This is first line");
//        writingIntoTextFile(pathNameTextFile, "This is two line");
//        writingIntoTextFile_FileWriter(pathNameTextFile, "123");
//        stopWritingIntoTextFile(pathNameTextFile);
//        writingIntoTextFile_FileOutputStream_offset(pathNameTextFile, "1234567890" +"",2);
//        stopWritingIntoTextFile_FileOutputStream(pathNameTextFile);
    }
    public static void readAndWriteToFile (File fileName, String output) throws IOException {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            if(!fileName.exists()){
                fileName.createNewFile();
            }
            fw = new FileWriter(fileName.getAbsoluteFile(),true);
            bw = new BufferedWriter(fw);
            bw.newLine();
            bw.write(output);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                if(bw!=null){
                    bw.close();
                }
                if(fw!=null){
                    fw.close();
                }
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }
}
