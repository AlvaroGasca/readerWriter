/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package readerWriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author alvarogasca
 */

public class LecturaEscritura {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
//        File archivo = new File("//Users//alvarogasca//NetBeansProjects//Dam2//src//readerWriter//archivo.txt");

        System.out.println("Escribe y termina usando '#'");

//          try {
// BufferedWriter f1= new BufferedWriter(new FileWriter("archivo.txt", true)) ;
// String t=null;
// Scanner atr = new Scanner (System.in);
//t= atr.nextLine();
//while(!t.equals(".")){
//f1.write(t);
//t= atr.nextLine();
//f1.flush();
//f1.newLine();
//}
//f1.close();
//         } catch (Exception e) {
//}

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("archivo.txt", true))) {
            while (true) {
                String linea = sc.nextLine();
                if (linea.contains("#")) {
                    break;
                }
                bw.write(linea);
                bw.newLine(); 
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }

        System.out.println("Archivo guardado como archivo.txt");

        System.out.println("¿Deseas leer el contenido? (y/n)");
        String respuesta = sc.nextLine();
        if (respuesta.equalsIgnoreCase("y")) {
            try (BufferedReader reader = new BufferedReader(new FileReader("archivo.txt"))) {
                String contenido;
                while ((contenido = reader.readLine()) != null) {
                    System.out.println(contenido);
                }
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }
        } else if (respuesta.equalsIgnoreCase("n")) {
            System.out.println("Adiós");
        } else {
            System.out.println("Carácter incorrecto");
        }
    }
}
