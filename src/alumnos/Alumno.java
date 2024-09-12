package alumnos;

import java.time.LocalDate;
import java.time.Period;

public class Alumno{
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String CURP;
    private String sexo;
    private String Telefono;
    private String Correo;
    private boolean discapacidad;
    private int edad;

    public Alumno(String Nombre, String apPaterno, String apMaterno,String CURP,String sexo,String Telefono, String Correo, boolean discapacidad){

        this.nombre = Nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.CURP = CURP;
        this.sexo = sexo;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.discapacidad = discapacidad;
        //this.edad = edad;
    }
    String getNombre(){
        return nombre;
    }
    String getApPaterno(){
        return apPaterno;
    }
    String getApMaterno(){
        return apMaterno;
    }
    String getCURP(){
        return CURP;
    }
    String getSexo(){
        return sexo;
    }
    String getTelefono(){
        return Telefono;
    }
    String getCorreo(){
        return Correo;
    }
    boolean isDiscapacidad(){
        return discapacidad;
    }
    public String getDiscapacidad(){
        if (discapacidad)
                return "Sí";
        else
            return "No";
    }

        public int calcularEdad(String txtCURP){
            int year = Integer.parseInt(txtCURP.substring(4,6));
            int mes = Integer.parseInt(txtCURP.substring(6,8));
            int dia = Integer.parseInt(txtCURP.substring(8,10));
            // si es de los 2000's
            if (year >= 0 && year <= 20)
                year += 2000;
            else // en caso de que sea de 1900
                year +=1900;

            LocalDate fechaN = LocalDate.of(year,mes,dia);//fecha nacimiento
            LocalDate fechaActual = LocalDate.now();//fecha actual del sistema
            Period edad = Period.between(fechaN,fechaActual);// este calcula la edad

            //System.out.println("Edad: "+ edad.getYears());
            return edad.getYears();//regreso la edad
        }
    }


