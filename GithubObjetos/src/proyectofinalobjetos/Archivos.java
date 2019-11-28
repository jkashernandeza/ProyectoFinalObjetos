
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alumno
 */
public class Archivos {
    String ruta_nombre;
    FileWriter sw;
    FileReader fr;
    
    public boolean Metodo1(JTable jt, String identificacion){
        //1-Leer el archivo sin identificacion y lo metes en una matriz
        String matrix[] = new String[10000];
        boolean resultado = true;
        int m=0;
        try{
            fr = new FileReader(ruta_nombre);
            BufferedReader br=new BufferedReader(fr);
            String registro = br.readLine();
            while(registro != null){
                String reg[]= registro.split("\\|");
                if(!reg[2].equals(identificacion)){
                    matrix[m]=registro;
                    m++;
                }
                registro = br.readLine();
            }
            br.close();
            fr.close();
        }catch(Exception e){
            resultado=false;
        }
         //2-Guardar el JT como va
        //3.-Vacio la matriz que copie
        try{
            sw=new FileWriter(ruta_nombre, true);
            for(int i=0; i<m; i++){
                sw.write(matrix[i]);
            }
            sw.close();
        }catch(Exception e){
            
        }
        return resultado;
}
}
//hola
