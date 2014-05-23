/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.lasalle.poo.classe;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException; import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
/**
 *
 * @author Tamara
 */
public class Ordenando {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("No hay archivos");
            System.exit(1);
        }
        else
        {
            File f_entrada = new File(args[0]);
            File f_salida = new File(args[1]); 
            LinkedList<String> lista = new LinkedList<String>();
            try {
                //   FileInputStream fstream = new FileInputStream("/Users/Tamara/Desktop/padrones-beneficiarios-financiamiento-a-bosques.csv");
            //DataInputStream entrada = new DataInputStream(fstream);
            //BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
            //fichero = new FileWriter("/Users/Tamara/Desktop/Salida");
                FileReader fr = new FileReader("/Users/Tamara/Desktop/padrones-beneficiarios-financiamiento-a-bosques.csv");
                BufferedReader br = new BufferedReader(fr);
                FileWriter fw = new FileWriter("/Users/Tamara/Desktop/Salida");
                PrintWriter pw = new PrintWriter(fw);
                String linea = null;
                while ((linea = br.readLine()) != null){
                    lista.add(linea);
                }
                Collections.sort(lista);
                Iterator iter = lista.iterator();
                String cadena;
                while (iter.hasNext()){
                    cadena = (String) iter.next(); 
                    pw.println(cadena); 
                    System.out.println(cadena);
                }
                br.close();
                fr.close();
                pw.close();
                fw.close();
            }catch (FileNotFoundException e) { 
                System.err.println("No se ha encontrado el fichero");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}