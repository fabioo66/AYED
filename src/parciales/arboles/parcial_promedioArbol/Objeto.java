package parciales.arboles.parcial_promedioArbol;

public class Objeto {
    private int suma;
    private int cant;

    public Objeto(){
        this.suma = 0;
        this.cant = 0;
    }

    public void sumar(int valor){
        this.suma += valor;
        this.cant++;
    }

    public int getSuma(){
        return this.suma;
    }

    public int getCant(){
        return this.cant;
    }

    public int getPromedio(){
        if (this.cant == 0){
            return 0;
        }else{
            return this.suma / this.cant;
        }
    }
}
