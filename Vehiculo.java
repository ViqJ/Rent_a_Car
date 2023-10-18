class Vehiculo{
    private int id;
    private String tipo;
    private String color;
    private String combustible;
    private String disponible;
    private String asegurado;
    private String cliente;
    private int precio;

    
    public Vehiculo(){
        
    }

    public Vehiculo(int id, String tipo, String color, String combustible, String disponible, String asegurado, String cliente, int precio){
        this.id = id;
        this.tipo = tipo;
        this.color = color;
        this.combustible = combustible;
        this.disponible = disponible;
        this.asegurado = asegurado;
        this.cliente = cliente;
        this.precio = precio;
    }

    public void setCliente(String cliente){
        this.cliente = cliente;
    }
    public void setAsegurado(String asegurado){
        this.asegurado = asegurado;
    }
    public void setDisponible(String disponible){
        this.disponible = disponible;
    }
    
    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getColor() {
        return color;
    }

    public String getCombustible() {
        return combustible;
    }

    public String getDisponible() {
        return disponible;
    }

    public String getAsegurado() {
        return asegurado;
    }

    public String getCliente() {
        return cliente;
    }

    public int getPrecio() {
        return precio;
    }
    
}