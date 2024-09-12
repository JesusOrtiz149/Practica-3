package alumnos;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frmAlumnos pantalla = new frmAlumnos();
                pantalla.setVisible(true);

                pantalla.setBotonGuardarListener(new BotonGuardarListener() {
                    @Override
                    public void guardando(Alumno persona) {
                        String fecha = persona.getCURP();
                        int edad = 0;
                        System.out.println("Nombre: "+persona.getNombre());
                        System.out.println("A. Paterno: "+persona.getApPaterno());
                        System.out.println("A. Materno: "+persona.getApMaterno());
                        System.out.println("CURP: "+persona.getCURP());
                        System.out.println("Sexo: "+persona.getSexo());
                        System.out.println("Correo: "+persona.getCorreo());
                        System.out.println("Teléfono: "+persona.getTelefono());
                        System.out.println("Discapacidad: "+persona.getDiscapacidad());
                        edad = persona.calcularEdad(fecha);
                        System.out.println("Edad: "+edad);



                        Path path = Path.of("C:\\A\\Prueba.txt");
                        String content = persona.getNombre()+"\n"+
                                         persona.getApPaterno()+"\n"+
                                         persona.getApMaterno()+"\n"+
                                         persona.getCURP()+"\n"+
                                         persona.getSexo()+"\n"+
                                         persona.getCorreo()+"\n"+
                                         persona.getTelefono()+"\n"+
                                         persona.getDiscapacidad()+"\n"+
                                         edad;
                        try(FileWriter archivo = new FileWriter(path.toFile(),true)){
                            PrintWriter pw = new PrintWriter(archivo);
                            pw.println(content);
                            //archivo.write(content);
                        }
                        catch(IOError e){
                            e.getMessage();
                        }
                        catch(IOException e){
                            throw new RuntimeException(e);
                        }
                    }
                });
            }
        });
    }
}