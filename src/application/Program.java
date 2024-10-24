package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import model.entities.Product;

public class Program {
    public static void main(String[] args) {

        // Gets Paths
        String appPath = new File("").getAbsolutePath();
        String filesFolderPath = appPath + "\\src\\files";

        // Gets the name of the file which will be read
        String fileName;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Write the name of the file which will be read");
            fileName = sc.nextLine();
        } catch (Exception e) {
            fileName = "in.csv";
            e.getMessage();
        }

        String pathFileIn = filesFolderPath + "\\" + fileName;

        // Makes out folder if not exists
        boolean mkdir = new File(filesFolderPath + "\\out").mkdir();

        if (mkdir) {
            System.out.println("Message: out folder created");
        } else {
            System.out.println("Message: out folder already exists");
        }

        // Define summary.csv path
        String pathFileOut = filesFolderPath + "\\out\\summary.csv";

        try (
                BufferedReader br = new BufferedReader(new FileReader(pathFileIn));
                BufferedWriter bw = new BufferedWriter(new FileWriter(pathFileOut));) {

            String line = br.readLine();

            // read the file until the end
            while (line != null) {
                // Get a line and split by comma
                String[] productStringList = line.split(",");

                // Create product Object with line info
                Product product = new Product(
                        productStringList[0],
                        Double.valueOf(productStringList[1]),
                        Integer.valueOf(productStringList[2]));

                // System.out.println(product.toString());

                // Create a line to write to summary.csv
                StringBuilder sb = new StringBuilder();
                sb.append(product.getName());
                sb.append(",");
                sb.append(String.valueOf(product.calcTotalValue()));
                sb.append("\n");

                // System.out.println(sb.toString());

                // Write line
                bw.write(sb.toString());

                // Read next line from in.csv
                line = br.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
