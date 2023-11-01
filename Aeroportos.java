public class Aeroportos{
   
    static ListaSimplesDesordenada<Aeroporto> listaDeAeroportos = new ListaSimplesDesordenada<>();
    static String nomeCidade = null;
    static String codAeroporto = null;

    //construtor que nao entendi muito bem a utilidade
    public Aeroportos() {
        Aeroportos.listaDeAeroportos = new ListaSimplesDesordenada<>();
    }

    // CADASTRO DE AEROPORTO
    public static void cadastrarAeroporto(String nomeDoAero, String CodDoAero) throws Exception{
        int codEmInt;
        try {
            codEmInt = Integer.parseInt(CodDoAero); // converte pra int o numero passado pelo usuário
        } catch (Exception e) {
            throw new NumberFormatException
            ("\n---------------------------------------------------------------------------------------\n"+
            "| Valor INVÁLIDO: O código do aeroporto deve ser com números inteiros. Ex: 1, 2, 3... |\n"+
            "---------------------------------------------------------------------------------------");
        }if(temAeroporto(codEmInt)){
            throw new Exception
            ("------------------------------------------------------------\n"+
            "| Aeroporto já existente com esse código! Use outro código |\n"+
            "------------------------------------------------------------");
        }else{
            ListaSimplesDesordenada<Voo> listaDeVoos = new ListaSimplesDesordenada<>();
            Aeroporto aeroporto = new Aeroporto(nomeDoAero, codEmInt, listaDeVoos);
            listaDeAeroportos.guardeUmItemNoFinal(aeroporto);
        }
    }

    //LISTAR TODOS OS AEROPORTOS
    public static void listarAeroportos() throws Exception{ 
        if (Aeroportos.listaDeAeroportos.getQuantidade() != 0){
            System.out.println("\nAeroporto(s) já cadastrado(s):\n");
            for(int i = 0; i < Aeroportos.listaDeAeroportos.getQuantidade(); i++){
                System.out.print("Codigo: " + Aeroportos.listaDeAeroportos.getIezimo(i).getCodigo() 
                + " .............. " + "Nome: " + Aeroportos.listaDeAeroportos.getIezimo(i).getCidade() + "\n");
            }
            System.out.println();
        }
    }

    //RECUPERAR UM AEROPORTO ESPECIFICO
    public static Aeroporto recuperaAeroporto(int codigoAeroporto) throws Exception {
        Aeroporto aeroportoEncontrado = null;
        for (int i = 0; i < listaDeAeroportos.getQuantidade(); i++) {
            Aeroporto aeroporto = listaDeAeroportos.getIezimo(i);
            if (aeroporto.getCodigo() == codigoAeroporto) {
                aeroportoEncontrado = aeroporto;
                break;
            }
        }
        if (aeroportoEncontrado == null) {
            throw new Exception
            ("---------------------------------------------------"+
            "| Não foi encontrado um aeroporto com este código |\n"+
            "---------------------------------------------------");
        }
        return aeroportoEncontrado;
    }

    //SE EXISTE CERTO AEROPORTO OU NÃO PELO SEU CÓDIGO
    public static boolean temAeroporto(int codAeroporto) throws Exception{
        Aeroporto a1 = new Aeroporto(codAeroporto);
        for(int i = 0; i < listaDeAeroportos.getQuantidade(); i++){
            Aeroporto aeroporto = Aeroportos.listaDeAeroportos.getIezimo(i); 
            if(aeroporto.getCodigo() == a1.getCodigo()){
                return true;
            }
        }
        return false;
    }

    //PARA VERIFICAR SE A LISTA DE AEROPORTO ESTÁ VAZIA OU NÃO
    public static void isListaAeroportoEmpty() throws Exception{
        if(listaDeAeroportos.getQuantidade()<=1){
                throw new Exception
                ("-------------------------------------------------------------------------------------------"+
                "\n| Quantidade de aeroportos cadastrados insuficientes! Por favor, cadastre pelo menos dois! |\n"+
                "-------------------------------------------------------------------------------------------");
        }
    }

    //INSERIR VOO A UM AEROPORTO ESPECIFICO
    public static void insereVoo(Aeroporto a1, Voo v1) throws Exception {

        if(a1 == null)
            throw new Exception("Aeroporto nao pode ser nulo!");

        if(v1 == null)
            throw new Exception("Lista de Voos nao pode ser nulo!");

        a1.getListaDeVoos().guardeUmItemNoFinal(v1);
    }
}