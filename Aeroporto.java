public class Aeroporto implements Cloneable{

    private int codigo;
    private String cidade;
    ListaSimplesDesordenada<Voo> listaDeVoos = new ListaSimplesDesordenada<>();

    /************* CONSTRUTORES *****************************/
     public Aeroporto(String nomeCidade, int codAero, ListaSimplesDesordenada<Voo> voos){
        this.cidade = nomeCidade;
        this.codigo = codAero;
        this.listaDeVoos = voos;
    }
    public Aeroporto(int codigo){
        this.codigo = codigo;
    }

    /************* GETTERS *****************************/

    public String getCidade() {
        return cidade;
    }
    public int getCodigo() {
        return codigo;
    }
    public ListaSimplesDesordenada<Voo> getListaDeVoos() {
        return this.listaDeVoos;
    }
    public int qtdDeVoos(){
        return this.listaDeVoos.getQuantidade();
    }

    /************* SETTERS *****************************/
   
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public void setCodigo(int cod) throws Exception {
        this.codigo = cod;
    }
    public void setVoos(ListaSimplesDesordenada<Voo> voos) {
        this.listaDeVoos = voos;
    }

    /************* MÉTODOS *****************************/

    public void removaUmVooDoAeroporto(ListaSimplesDesordenada<Voo>listaVoos, int numVoo)throws Exception{

        ListaSimplesDesordenada<Voo> listaCopia = (ListaSimplesDesordenada<Voo>) listaDeVoos.clone();
        ListaSimplesDesordenada<Voo> lista = new ListaSimplesDesordenada<>();

        if(listaVoos == null){
            throw new Exception();
        }

        for(int i=0; i<listaDeVoos.getQuantidade();i++){
            if(numVoo==listaCopia.recupereItemDoInicio().getNumeroVoo()){
                listaCopia.removaItemDoInicio();
            }else {
                lista.guardeUmItemNoInicio(listaCopia.recupereItemDoInicio());
                listaCopia.removaItemDoInicio();
            }
        }
        this.listaDeVoos = lista;
    }
    /************* METODOS OBRIGATÓRIOS *****************************/

    @Override
    public String toString() {
        return cidade + " " + codigo;
    }
    @Override
    public int hashCode() {
        int hash = 2;
        hash = 3 * hash + cidade.hashCode();
        hash = 5 * hash + Integer.valueOf(this.codigo).hashCode();
        hash = 7 * hash + listaDeVoos.hashCode();

        if (hash < 0) hash = -hash;
        return hash;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;

        if (this.getClass() != obj.getClass()) return false;

        Aeroporto a = (Aeroporto) obj;

        return cidade.equals(a.cidade) && codigo== a.codigo && listaDeVoos.equals(a.listaDeVoos);
    }
    public Aeroporto (Aeroporto modelo) throws Exception
    {
        if (modelo==null)
            throw new Exception ("Modelo ausente");

        //this.indiceAeroporto = modelo.indiceAeroporto;
        this.cidade = modelo.cidade;
        this.codigo = modelo.codigo;
        this.listaDeVoos  = (ListaSimplesDesordenada<Voo>) modelo.listaDeVoos.clone();
    }
    public Object clone ()
    {
       Aeroporto ret=null;

        try
        {
            ret = new Aeroporto (this);
        }
        catch (Exception erro)
        {} // sei que this NUNCA é null e o contrutor de copia da erro quando seu parametro é null

        return ret;
    }
}