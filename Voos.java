public class Voos {

    private ListaSimplesDesordenada<Voo> listaDeVoos;


    /************* CONSTRUTORES *****************************/
    public Voos() {
        this.listaDeVoos = new ListaSimplesDesordenada<>();
    }

    /************* SETTER *****************************/
    public void setVoos(ListaSimplesDesordenada<Voo> voos) {
        this.listaDeVoos = voos;
    }

    public ListaSimplesDesordenada<Voo> getListaDeVoos() {
        return listaDeVoos;
    }
    

    /************* METODOS *****************************/
    public static void adicionarVoo(String codPartidaString, String codDestinoString, String numeroVooString) throws Exception{
      
        if(codPartidaString == null || codPartidaString.equals("")){
            throw new Exception("\n------------------------------------------------------\n"+
                                  "| O código está vazio! Digite o número do aeroporto! |\n"+
                                  "------------------------------------------------------");
        }
        int codPartida;
        try {
            codPartida = Integer.parseInt(codPartidaString);
        } catch (Exception e) {
            throw new NumberFormatException
            ("\n---------------------------------------------------------------------------------------\n"+
               "| Valor INVÁLIDO: O código do aeroporto deve ser com números inteiros. Ex: 1, 2, 3... |\n"+
               "---------------------------------------------------------------------------------------");
        }

        Aeroporto aeroportoPartida = null; 
        int i=0;
        
        while (i<Aeroportos.listaDeAeroportos.getQuantidade()){
            Aeroporto aeroporto = Aeroportos.listaDeAeroportos.getIezimo(i);
            if (aeroporto.getCodigo() == codPartida) {
                aeroportoPartida = aeroporto; //se existir, esse tal elemento é atribuido ao variavel do tipo aeroporto
                break; //se existir da um break no while caso o elemento percorrido for igual ao digitado
            }   
            i++;
        }
        if(aeroportoPartida == null){ // se for nulo, é porque nao existe
            throw new Exception("\n----------------------------------------------------\n"+
                                  "| Não foi encontrado um Aeroporto com este código! |\n"+
                                  "----------------------------------------------------");
        }
        
        if(codDestinoString == null || codDestinoString.equals("")){
            throw new Exception
            ("\n------------------------------------------------------\n"+
               "| O código está vazio! Digite o número do aeroporto! |\n"+
               "------------------------------------------------------");
        }

        int codDestino;
        try {
            codDestino = Integer.parseInt(codDestinoString);
        } catch (Exception e) {
            throw new NumberFormatException
            ("\n---------------------------------------------------------------------------------------\n"+
               "| Valor INVÁLIDO: O código do aeroporto deve ser com números inteiros. Ex: 1, 2, 3... |\n"+
               "---------------------------------------------------------------------------------------");
        }

        Aeroporto aeroportoDestino = null; 
        int j=0;

        while (j <Aeroportos.listaDeAeroportos.getQuantidade()){
            Aeroporto aeroporto = Aeroportos.listaDeAeroportos.getIezimo(j);
            if (aeroporto.getCodigo() == codDestino) {
                aeroportoDestino = aeroporto;
                break;
            }
            j++; 
        }

        if(aeroportoDestino == null)
        throw new Exception
        ("\n----------------------------------------------------\n"+
           "| Não foi encontrado um Aeroporto com este código! |\n"+
           "----------------------------------------------------");

        if(codPartida == codDestino)
        throw new Exception
        ("\n--------------------------------------------------------------------------------------\n"+
           "| Os códigos de aeroporto de partida e destino estão iguais! Precisam ser diferentes |\n"+
           "--------------------------------------------------------------------------------------");

        if(numeroVooString == null || numeroVooString.equals("")){
            throw new Exception
            ("\n----------------------------------------------------------------\n"+
               "| O número do voo está vazio! Você precisa digitar um valor... |\n"+
               "----------------------------------------------------------------");
        }

        int numeroVoo;
        try {
            numeroVoo = Integer.parseInt(numeroVooString);
        } catch (Exception e) {
            throw new NumberFormatException
            ("\n---------------------------------------------------------------------------------\n"+
               "| Valor INVÁLIDO: O numero do voo deve ser com números inteiros. Ex: 1, 2, 3... |\n"+
               "---------------------------------------------------------------------------------");
        }
        if (numeroVoo < 0) {
            throw new Exception
            ("\n---------------------------------------------------------\n"+
               "| Número inválido! O número de voo deve ser maior que 0 |\n"+
               "---------------------------------------------------------");
        }

        //cria uma variavel que recebe o aeroporto com o codigo digitado pelo usuario
        Aeroporto aeroporto1 = Aeroportos.recuperaAeroporto(codPartida);
        Voo voo = new Voo(numeroVoo); //cria um novo objeto de voo com esse numero  


        //procura esse voo na lista de voos, se existir, lança excecao
        if(voo.equals(aeroportoPartida.listaDeVoos.recupereItemIndicado(voo))){
            throw new Exception
            ("\n---------------------------------------------------------------------\n"+
               "| Já existe um voo Cadastrado com esse número! Digite outro número! |\n"+
               "---------------------------------------------------------------------");
        }
        
        Voo v1 = new Voo(numeroVoo, aeroportoDestino.getCodigo(), aeroportoDestino.getCidade());
        Aeroportos.listaDeAeroportos.recupereItemIndicado(aeroporto1).getListaDeVoos().guardeUmItemNoFinal(v1);
    }           

    public static void removerVoo(String codigoAeroportoStr, String numeroVooStr) throws Exception {
        //verifica se o codigo esta vazio e se é realmente numeros inteiros
        if(codigoAeroportoStr == null || codigoAeroportoStr.equals("")){
            throw new Exception
            ("\n------------------------------------------------------\n"+
             "| O código está vazio! Digite o número do aeroporto! |\n"+
             "------------------------------------------------------");
        }
        int codigoAeroporto;
        try {
            codigoAeroporto = Integer.parseInt(codigoAeroportoStr);
        } catch (Exception e) {
            throw new NumberFormatException
            ("\n---------------------------------------------------------------------------------------\n"+
              "| Valor INVÁLIDO: O código do aeroporto deve ser com números inteiros. Ex: 1, 2, 3... |\n"+
              "---------------------------------------------------------------------------------------");
        }


        //cria uma variavel do tipo aeroporto e inicializa ela como nula
        Aeroporto aeroportoPesquisa = null;
        int i=0;
        //verifica se existe o aeroporto com determinado código
        while (i<Aeroportos.listaDeAeroportos.getQuantidade()){
            //cria uma variavel do tipo aeroporto que vai receber a lista de aeroporto com o variavel incrementativa i
            Aeroporto aeroporto = Aeroportos.listaDeAeroportos.getIezimo(i);
           
            if (aeroporto.getCodigo() == codigoAeroporto) {
                //se for, atribui esse valor a variavel aeroportoPesquisa e fecha o loop, afinal ja encontrou o aeroporto que queria
                aeroportoPesquisa = aeroporto;
                break;
            }
            //incrementa no i para poder andar caso nao entre no if
            i++;   
        }

        //lanca excecao se ele nao existir
        if(aeroportoPesquisa == null){
            throw new Exception
            ("\n---------------------------------------------------\n"+
               "| Nao foi encontrado um aeroporto com este codigo |\n"+
               "---------------------------------------------------");
        }
        //conversao do numero do voo
        int numeroVoo;
        try {
            numeroVoo = Integer.parseInt(numeroVooStr);
        } catch (Exception e) {
            throw new NumberFormatException
            ("\n---------------------------------------------------------------------------------\n"+
               "| Valor INVÁLIDO: O numero do voo deve ser com números inteiros. Ex: 1, 2, 3... |\n"+
               "---------------------------------------------------------------------------------");
        }

        //caso seja menor do que 0, invalido
        if(numeroVoo<0){
            throw new Exception
            ("\n-----------------------------------------------------\n"+
               "| número INVÁLIDO: O numero do deve ser maior que 0 |\n"+
               "-----------------------------------------------------");
        }

        Voo voo = new Voo(numeroVoo); // cria um novo objeto de voo com o numero de voo
        Voo v1 = null; //cria uma nova variavel do tipo voo v1
       
        //percorre o for até a quantiade maxima da lista de aeroporto
        for(int a=0; a < Aeroportos.listaDeAeroportos.getQuantidade(); a++){
            Aeroporto aeroporto = Aeroportos.listaDeAeroportos.getIezimo(a);
            v1 = aeroporto.getListaDeVoos().recupereItemIndicado(voo);
            if(v1==null){
                //v1 recebe o primeiro item da lista de voos, com o objeto de voos no parametro da busca, objeto esse que foi criado com o numero de voo pesquisado
                aeroportoPesquisa = aeroporto;
                break;
            }
            //se v1 nao for nulo, fecha um for
            if(v1!=null){
                break;
            }
        }

        if(v1 == null){
            throw new Exception
            ("\n-------------------------------------------------------------------------------\n"+
               "| Número de voo INEXISTENTE: Você só pode excluir voos que já foram incluídos |\n"+
               "-------------------------------------------------------------------------------");
        }
        Aeroportos.listaDeAeroportos.removaItemIndicado(aeroportoPesquisa);
        aeroportoPesquisa.removaUmVooDoAeroporto(aeroportoPesquisa.getListaDeVoos(),numeroVoo);
        Aeroportos.listaDeAeroportos.guardeUmItemNoFinal(aeroportoPesquisa);
    }

    public static void listarVoosPorCod(String codAeroStr) throws Exception{
        int codigoAero;
        try {
           codigoAero = Integer.parseInt(codAeroStr); 
        } catch (Exception e) {
            throw new Exception
            ("\n---------------------------------------------------------------------------------------\n"+
               "| Valor INVÁLIDO: O código do Aeroporto deve ser com números inteiros. Ex: 1, 2, 3... |\n"+
               "---------------------------------------------------------------------------------------");
        }
        if(codigoAero < 0){
            throw new Exception
            ("\n------------------------------------------------------------------\n"+
               "| Valor INVÁLIDO: O código do Aeroporto deve ser com maior que 0 |\n"+
               "------------------------------------------------------------------");
        }
        if(!Aeroportos.temAeroporto(codigoAero)){
            throw new Exception
            ("\n----------------------------------------------------------------\n"+
               "| código INVÁLIDO: Não existe nenhum aeroporto com esse código |\n"+
               "----------------------------------------------------------------");
        }
        
        Aeroporto aeroportoPes = null;
        aeroportoPes = Aeroportos.recuperaAeroporto(codigoAero);

        if(aeroportoPes.qtdDeVoos()<=0){
            System.out.println("\n>>> Ainda não há voos cadastrados nesse aeroporto <<<");
        }
        else{
            System.out.println("\nVoos do aeroporto do código " + aeroportoPes.getCodigo()+": ------------------------------------------\n");
            
            for(int d = 0; d < aeroportoPes.qtdDeVoos(); d++){ 
                if (d == aeroportoPes.qtdDeVoos() - 1) {
                    System.out.println("Numero do voo: " + aeroportoPes.getListaDeVoos().getIezimo(d).getNumeroVoo()
                    + " | Código Aeroporto Destino: " + aeroportoPes.getListaDeVoos().getIezimo(d).getCodigoDestino()
                    + " | Nome Aeroporto Destino: "+ aeroportoPes.getListaDeVoos().getIezimo(d).getNomeDestino());
                    break;
                }
                System.out.println("Numero do voo: " + aeroportoPes.getListaDeVoos().getIezimo(d).getNumeroVoo()
                    + " | Código Aeroporto Destino: " + aeroportoPes.getListaDeVoos().getIezimo(d).getCodigoDestino()
                    + " | Nome Aeroporto Destino: "+ aeroportoPes.getListaDeVoos().getIezimo(d).getNomeDestino());
            }
        }
    }
}