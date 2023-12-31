package pdf_splitter;

import java.io.*;

public class pdfSplitter {
    public static void main(String[] args) {
        try {
            byte[] buffer = new byte[1000000];
            int partNumber = 1;

            InputStreamReader ins = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(ins);

            System.out.println("Enter the path of the source or original file you want to split: ");
            String sourceFilePath = br.readLine();

            FileInputStream fis = new FileInputStream(sourceFilePath);
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                String partFileName = String.format("%s.%03d", sourceFilePath, partNumber);
                FileOutputStream fos = new FileOutputStream(partFileName);
                fos.write(buffer, 0, bytesRead);
                fos.close();
                System.out.println("Part " + partNumber + " created.");
                partNumber++;
            }

            System.out.println("File splitted successfully.");
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
