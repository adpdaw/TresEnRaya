/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trigonometria;

import java.util.Objects;

/**
 *
 * @author CAD Alfred
 */
public class Triangulo {

    private double ladoA;
    private double ladoB;
    private double ladoC;
    private Angulo anguloA;
    private Angulo anguloB;
    private Angulo anguloC;

    //a Creación del Triangulo a partir de tres lados.
    public Triangulo(double ladoA, double ladoB, double ladoC) {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
        this.anguloA = new Angulo(Angulo.toGrados(Angulo.aCos(
                ((ladoB * ladoB) + (ladoC * ladoC) - (ladoA * ladoA))
                / (2 * ladoB * ladoC))));
        this.anguloB = new Angulo(Angulo.toGrados(Angulo.aCos(
                ((ladoA * ladoA) + (ladoC * ladoC) - (ladoB * ladoB))
                / (2 * ladoA * ladoC))));
        this.anguloC = new Angulo(anguloFaltante(anguloA, anguloB));
    }
    // b Creación del Triángulo a partir de un lado, y los dos ángulos 
    // adyacentes a ese lado.

    public Triangulo(double ladoA, Angulo anguloB, Angulo anguloC) {
        this.anguloA = new Angulo(anguloFaltante(anguloC, anguloB));
        this.anguloB = new Angulo(anguloB);
        this.anguloC = new Angulo(anguloC);
        this.ladoA = ladoA;
        this.ladoB = ladoA *(anguloB.getSeno()) / (anguloA.getSeno());
        this.ladoC = ladoA *(anguloC.getSeno()) / (anguloA.getSeno());
        
    }
    //c  Creación del Triangulo a partir de dos lados, y el ángulo que forman.

    public Triangulo(double ladoA, double ladoB, Angulo anguloC) {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = Math.sqrt((ladoA*ladoA)+(ladoB*ladoB)-(2* ladoA*ladoB)*(anguloC.getCoseno()));
        this.anguloA = new Angulo (Angulo.aCos(ladoA * (anguloC.getSeno()) / ladoC));
        this.anguloC = new Angulo(anguloC);
        this.anguloB = anguloFaltante(anguloA,this.anguloC);

    }

    public Triangulo(double area, Angulo anguloA, Angulo anguloB, Angulo anguloC){ 
        
        this.anguloA = new Angulo(anguloA);
        this.anguloB = new Angulo(anguloB);
        this.anguloC = new Angulo(anguloC);
        this.ladoA = Math.sqrt( (2 * area  * (anguloA.getSeno())) /
                (anguloB.getSeno() * anguloC.getSeno()));
        this.ladoB = ladoA * anguloB.getSeno() / anguloA.getSeno();
        this.ladoC = ladoA * anguloC.getSeno() / anguloA.getSeno();
        
        
                
    }

    public Triangulo(Triangulo triangulo) {
        this(triangulo.ladoA, triangulo.ladoB, triangulo.ladoC);
    }

    public double getArea() {
        return (Math.sqrt(getSemiperimetro()
                * (getSemiperimetro() - this.ladoA)
                * (getSemiperimetro() - this.ladoB)
                * (getSemiperimetro() - this.ladoC)));

    }

    public double getPerimetro() {
        return (this.ladoA + this.ladoB + this.ladoC);
    }

    public double getSemiperimetro() {
        return (getPerimetro()) / 2;
    }

    public double getAlturaA() {
        return 2 / (this.ladoA * getArea());

    }

    public double getAlturaB() {
        return 2 / (this.ladoB * getArea());

    }

    public double getAlturaC() {
        return 2 / (this.ladoC * getArea());

    }

    public double getMedianaA() {
        return Math.sqrt(2 * ((Math.pow(this.ladoB, 2)) + 
                (Math.pow(this.ladoC, 2))) - (Math.pow(this.ladoA, 2))) / 2;
    }

    public double getMedianaB() {
        return Math.sqrt(2 * ((Math.pow(this.ladoA, 2)) + 
                (Math.pow(this.ladoC, 2))) - (Math.pow(this.ladoB, 2))) / 2;
    }

    public double getMedianaC() {
        return Math.sqrt(2 * ((Math.pow(this.ladoA, 2)) + 
                (Math.pow(this.ladoB, 2))) - (Math.pow(this.ladoC, 2))) / 2;
    }

    public double getRadioCircunscrito() {
        return (this.ladoA * this.ladoB * this.ladoC) / (4 * (Math.sqrt(getArea())));
    }

    public double getRadioInscrito() {
        return Math.sqrt(((getSemiperimetro()) - ((this.ladoA))) * 
                (((getSemiperimetro()) - (this.ladoB))) * 
                ((getSemiperimetro()) - ((this.ladoC))) / getSemiperimetro());

    }
//getTipoAngulos: Devolverá el String “Acutángulo”, 
    //“Rectángulo” u “Obtusángulo” según el tipo de Triangulo que sea.
    public String getTipoAngulos() {
        if (this.anguloA.getGrados() < 90 &&  this.anguloB.getGrados() < 90 && this.anguloC.getGrados()< 90 ) {
           return("Acutangulo");
        } else if (this.anguloA.getGrados() == 90 || this.anguloB.getGrados() == 90 || this.anguloC.getGrados() == 90) {
           return("Rectangulo");
        } else {
            return("Obtusangulo");
        }
    } 
    
    public String getTipoLados(){
        
        if (ladoA == ladoB && ladoC == ladoB) {
            return("Triangulo equilatero");
        } else if (ladoA == ladoB && ladoC != ladoB) {
            return("Triangulo isosceles");

        } else {
            return("Triangulo escaleno");
        }
    }
    
    public boolean esSemejante(Triangulo triangulo){
       return (this.anguloA == triangulo.anguloA && 
           this.anguloB == triangulo.anguloB &&
           this.anguloC == triangulo.anguloC );     
    }
     
     
    @Override
    public String toString(){
        String texto = "";
        texto += String.valueOf(this.ladoA) + " cm.\n ";
        texto += String.valueOf(this.ladoB) + " cm.\n ";
        texto += String.valueOf(this.ladoC) + " cm.\n ";
        texto += String.valueOf((this.anguloA.getGrados())) + "º\n";
        texto += String.valueOf(this.anguloB.getGrados()) + "º\n";
        texto += String.valueOf(this.anguloC.getGrados()) + "º\n";
        texto += String.valueOf(this.getArea());
        return texto;
    }

    public void visualizar(){
        System.out.println(this.toString());
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.ladoA) ^ (Double.doubleToLongBits(this.ladoA) >>> 32));
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.ladoB) ^ (Double.doubleToLongBits(this.ladoB) >>> 32));
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.ladoC) ^ (Double.doubleToLongBits(this.ladoC) >>> 32));
        hash = 31 * hash + Objects.hashCode(this.anguloA);
        hash = 31 * hash + Objects.hashCode(this.anguloB);
        hash = 31 * hash + Objects.hashCode(this.anguloC);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Triangulo other = (Triangulo) obj;
        if (Double.doubleToLongBits(this.ladoA) != Double.doubleToLongBits(other.ladoA)) {
            return false;
        }
        if (Double.doubleToLongBits(this.ladoB) != Double.doubleToLongBits(other.ladoB)) {
            return false;
        }
        if (Double.doubleToLongBits(this.ladoC) != Double.doubleToLongBits(other.ladoC)) {
            return false;
        }
        if (!Objects.equals(this.anguloA, other.anguloA)) {
            return false;
        }
        if (!Objects.equals(this.anguloB, other.anguloB)) {
            return false;
        }
        if (!Objects.equals(this.anguloC, other.anguloC)) {
            return false;
        }
        return true;
    }
    
    
    public static Angulo anguloFaltante(Angulo anguloA, Angulo anguloB){
      return new Angulo(180 - anguloA.getGrados() - anguloB.getGrados());
       
       
    }

    public static Angulo anguloQueForman(double ladoB, double ladoC, Angulo anguloC){
         Angulo anguloB = new Angulo(Angulo.aCos(ladoB * anguloC.getSeno() / ladoC));
         
          return(Triangulo.anguloFaltante(anguloB, anguloC));
    
    }
}
