public class Principal{
    public static void main(String[] args) throws Exception {

        //cadastro de aeroportos descritos na atividade
        Aeroportos.cadastrarAeroporto("BSB (Brasilia)", "1");
        Aeroportos.cadastrarAeroporto("CNF (BH)", "2");
        Aeroportos.cadastrarAeroporto("GIG (Rio)", "3");
        Aeroportos.cadastrarAeroporto("GRU (SP)", "4");
        Aeroportos.cadastrarAeroporto("SSA (Salvador)", "5");

         //cadastro de voos desses aeroportos
        Voos.adicionarVoo("1", "5", "107");
        Voos.adicionarVoo("2", "5", "214");
        Voos.adicionarVoo("2", "3", "555");
        Voos.adicionarVoo("2", "4", "111");
        Voos.adicionarVoo("3", "2", "554");
        Voos.adicionarVoo("3", "4", "90");
        Voos.adicionarVoo("4", "1", "50");
        Voos.adicionarVoo("4", "3", "89");
        Voos.adicionarVoo("4", "2", "102");
        Voos.adicionarVoo("5", "2", "215");

       Menu.exibirMenu(); 
    }
}
