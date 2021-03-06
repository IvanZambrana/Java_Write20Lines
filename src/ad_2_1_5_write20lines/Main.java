package ad_2_1_5_write20lines;

import java.io.*;
import java.util.Scanner;
/**
 *
 * @author Iván Zambrana Naranjo
 */
public class Main {

    
    public static void main(String[] args) {
        
            String texto;
            String lectura;
            //Pedimos ruta para crear fichero
            Scanner sc = new Scanner(System.in);
            System.out.println("Inserte ruta del fichero a crear: ");
            String ruta = sc.next();
        try
        {
            //Creamos fichero
            File file = new File(ruta);
       
            //Creamos bufferedWriter
            BufferedWriter bW = new BufferedWriter(new FileWriter(file, true));
            
            if(file.exists())
            {
                //Creamos fichero
                file.createNewFile();
                System.out.println("A continuación escribirá 20 líneas por teclado:");
                //Bucle de funcionamiento
                for(int i = 0; i < 20; i++)
                {
                    texto = sc.next();
                    bW.write(texto);
                    bW.newLine();
                }
                System.out.println("Fichero creado con éxito.\n\n\n");
                
                //Cerramos bufferedWrite 
                bW.close();
                
                //Creamos bufferedRead
                BufferedReader bR = new BufferedReader(new FileReader(file));
                
                //Mostramos por pantalla fichero
                System.out.println("Se mostrará por pantalla el contenido del fichero " + file);
                lectura = bR.readLine();
                while(lectura != null) { 
                    System.out.println(lectura);
                    lectura = bR.readLine();
                } 
                
                //Cerramos bufferedRead
                bR.close();
            }
            else
            {
                System.out.println("-ERROR- El fichero ya existe.");
            }
        } catch (IOException e)
        {
            System.out.println("-ERROR-: " + e);
        }
        
    }
}
