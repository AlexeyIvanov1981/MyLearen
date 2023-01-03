package File;

import java.io.*;

public class Main {


    public static void main(String[] args) {
        String text = "Helllllllo!!!";
        // String filePrefix = "./src/";

        File file = new File("Test1.txt");
        //System.out.println(file.exists() ? "file is exist " : "file isn't exist");

//        try {
//            System.out.println("File " + (file.createNewFile() ? "is created" : "isn't created"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        File dir = new File("../StreamTest1");
//        if (dir.isDirectory()) {
//            for (String path : dir.list()) {
//                System.out.print("Объект " + path + " - ");
//                System.out.println(new File(path).isDirectory());
//            }
//        }

//        try (OutputStream outputStream = new FileOutputStream(file);
//             InputStream inputStream = new FileInputStream(file)) {
//
//            outputStream.write(text.getBytes());
//
//            int error = 5 / 0;
//
//            int currentByte = 0;
//            while ((currentByte = inputStream.read()) != -1) {
//                System.out.print(Character.toString(currentByte));
//            }
//            System.out.println();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file));
//             BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
//
//            outputStream.write(text.getBytes());
//            outputStream.close();
//
//            int currentByte = 0;
//            while ((currentByte = inputStream.read()) != -1) {
//                System.out.print(Character.toString(currentByte));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try (Writer writer = new FileWriter(file);
             Reader reader = new FileReader(file)) {

            writer.write(text);
            writer.close();

            int currentByte = 0;
            while ((currentByte = reader.read()) != -1) {
                System.out.print(Character.toString(currentByte));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("OK");
        while (true) ;
    }


    static void printFolder(String path) {
        File file = new File(path);

//        if (!file.exists()) return;
        if (file.isDirectory()) {
            System.out.println("Директория - " + path);
            for (String pathDir : file.list()) {
                printFolder(pathDir);
            }
        } else {
            System.out.println("Файл - " + path);
        }
    }
}
