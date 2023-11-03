/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package music.data;
import java.io.*;
import java.util.*;
import music.business.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 *
 * @author Nam
 */
public class ProductIO {
    private static ArrayList<Product> products = null;
    public static ArrayList<Product> getProducts(String path) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(path);
        Scanner sc = new Scanner(path);
        ArrayList<Product> prods = new ArrayList<>();
        try {
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                if(!line.isEmpty()) {
                    String code = line.split("\\|")[0];
                    String description = line.split("\\|")[1];
                    String priceStr = line.split("\\|")[2];
                    double price = Double.parseDouble(priceStr);
                    products.add(new Product(code, description, price));
                }
            }
            sc.close();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        return products;
    }
    public static Product getProduct(String prodCode, String path) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(path);
        Scanner sc = new Scanner(path);
        Product product = new Product();
        try {
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                if(!line.isEmpty()) {
                    String code = line.split("\\|")[0];
                    if(code.equals(prodCode)) {
                        String description = line.split("\\|")[1];
                        String priceStr = line.split("\\|")[2];
                        double price = Double.parseDouble(priceStr);
                        product = new Product(code, description, price);
                        break;
                    }
                }
            }
            sc.close();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        return product;
    }
    public static boolean exists(String prodCode, String path) throws FileNotFoundException {
        ArrayList<Product> products = getProducts(path);
        for (Product p : products) {
            if (prodCode != null && prodCode.equalsIgnoreCase(p.getCode())) {
                return true;
            }
        }
        return false;
    }
    private static void saveProducts(ArrayList<Product> products, String path) {
        try {
            File file = new File(path);
            PrintWriter out = new PrintWriter(new FileWriter(file));
            for (Product p : products) {
                out.println(p.getCode() + "|" + p.getDescription() + "|" + p.getPrice());
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void insert(Product product, String path) throws FileNotFoundException {
        ArrayList<Product> products = getProducts(path);
        products.add(product);
        saveProducts(products, path);
    }
    public static void update(Product product, String path) throws FileNotFoundException {
        ArrayList<Product> products = getProducts(path);
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            if(product.getCode() != null && product.getCode().equalsIgnoreCase(p.getCode())) {
                products.set(i, product);
            }
        }
        saveProducts(products, path);
    }
    public static void delete(Product product, String path) throws FileNotFoundException {
        ArrayList<Product> products = getProducts(path);
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            if (product != null && product.getCode().equalsIgnoreCase(p.getCode())) {
                products.remove(i);
            }
        }
        saveProducts(products, path);
    }
}
