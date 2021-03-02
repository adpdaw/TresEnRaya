/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trigonometria;

/**
 *
 * @author CAD Alfred
 */
public class Angulo {

   
    private double grado;
    
    
    public Angulo(){}
    
    public Angulo(double grado) {
         this.grado = grado;
         this.simplificar();
    }
  // b Creacion de un Angulo a partir de otro Angulo
    public Angulo(Angulo angulo) {
       this.grado=(angulo.grado);
       
    }

    public double toRadianes() {
        return  Math.toRadians(this.grado);

    }

    public double getGrados() {
        return this.grado;
    }

    public void setGrados(double grados) {
        this.grado = grados%360;
        
        

    }

    public double getSeno() {
        return  Math.sin(toRadianes());

    }

    public double getCoseno() {
        return  Math.cos(toRadianes());

    }

    public double getTangente() {
        return Math.tan(toRadianes());

    }

    public boolean esAgudo() {
        return (this.grado >= 0 && this.grado < 90); 
       
    }

    public boolean esRecto() {
        return (this.grado == 90);
    }

    public boolean esObtuso() {
        return (this.grado > 90 && this.grado < 180);
    }
    
    
    public  void simplificar(){
        this.grado = this.grado %360;
    
    }
   
    public String toString(){
       return  String.valueOf(this.grado)+ "º";
  
    }
    
    public void visualizar(){
        System.out.println(this.toString());
    
    }
    
    

   
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.grado) ^ (Double.doubleToLongBits(this.grado) >>> 32));
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
        final Angulo other = (Angulo) obj;
        if (Double.doubleToLongBits(this.grado) != Double.doubleToLongBits(other.grado)) {
            return false;
        }
        return true;
    }
   

    public static double toGrados(double radianes){
       return Math.toDegrees(radianes);

    }
    public static double aSin(double seno){
        return Math.asin(seno);
    }
    public static double aCos(double coseno){
        return Math.acos(coseno);
    }
    public static double aTan(double tangente){
        return Math.atan(tangente);
    }
}
