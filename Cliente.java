class Cliente{
    private int id;
    private String tipoPersona;
    private String lugarResidencia;
    private String direccionExacta;
    private int numeroTarjeta;
    private String tipoTarjeta;
    private String nombreCliente;

    public Cliente(){

    }

    public Cliente(int id, String tipoPersona, String lugarResidencia,String direccionExacta,int numeroTarjeta,String tipoTarjeta,String nombreCliente){
        this.id = id;
        this.tipoPersona = tipoPersona;
        this.lugarResidencia = lugarResidencia;
        this.direccionExacta = direccionExacta;
        this.numeroTarjeta = numeroTarjeta;
        this.tipoTarjeta = tipoTarjeta;
        this.nombreCliente = nombreCliente;
    }

    public String getNombreCliente(){
        return nombreCliente;
    }

    public int getId(){
        return id;
    }

    public String getTipoPersona(){
        return tipoPersona;
    }

    public String getLugarResidencia(){
        return lugarResidencia;
    }

    public String getDireccionExacta(){
        return direccionExacta;
    }

    public int getNumeroTarjeta(){
        return numeroTarjeta;
    }

    public String getTipoTarjeta(){
        return tipoTarjeta;
    }


}