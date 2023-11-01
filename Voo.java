public class Voo implements Cloneable{

    private int numeroVoo;
    private int codigoDestino;
    private String nomeDestino;
    
    //construtores
    public Voo(int numeroVoo, int codDestino, String nomeDestino){
        this.numeroVoo = numeroVoo;
        this.codigoDestino = codDestino;
        this.nomeDestino = nomeDestino;
    }
    public Voo(int numVoo){
        this.numeroVoo = numVoo;
    }

    //getters
    public int getNumeroVoo() {
        return numeroVoo;
    }
    public int getCodigoDestino() {
        return codigoDestino;
    }
    public String getNomeDestino(){
        return nomeDestino;
    }

    //setters
    public void setCodigoDestino(int codDestino){
        this.codigoDestino = codDestino;
    }
    public void setNumeroVoo(int numeroDoVoo){
        this.numeroVoo = numeroDoVoo;
    }
    public void setNomeDestino(String nomeDestino) {
        this.nomeDestino = nomeDestino;
    }

   
    @Override
    public String toString(){
        String ret = "(N°:" + this.numeroVoo + ", Aeroporto Destino:" + this.codigoDestino+")";

        return ret;
    }

    @Override
    public boolean equals (Object obj){
        if (this==obj)
            return true;
        if (obj==null)
            return false;
        if (!(obj instanceof Voo))
            return false;

        Voo voo = (Voo)obj;

        if (this.numeroVoo == voo.numeroVoo){
            return true;
        }
        if (this.codigoDestino == voo.codigoDestino){
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        final int PRIMO = 13;

        int ret=5;

        ret = PRIMO * ret +  Integer.valueOf(this.numeroVoo).hashCode();
        ret = PRIMO * ret +  Integer.valueOf(this.codigoDestino).hashCode();

        if (ret<0) ret = -ret;
        return ret;
    }

  
    public Voo (Voo modelo) throws Exception
    {
        if (modelo==null)
            throw new Exception ("Modelo ausente");

        this.numeroVoo = modelo.numeroVoo;
        this.codigoDestino = modelo.codigoDestino; 
    }


    public Object clone ()
    {
        Voo ret=null;

        try
        {
            ret = new Voo (this);
        }
        catch (Exception erro)
        {} // this NUNCA é null 
        return ret;
    }
}