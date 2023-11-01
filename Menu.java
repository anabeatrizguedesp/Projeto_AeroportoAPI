import java.util.Scanner;

public class Menu {
     public static void exibirMenu() throws Exception{
          Scanner sc = new Scanner(System.in);   
          
          int opcao = 9;
         
          while(opcao != 0){
                    System.out.println("\nBem vindo à VARIG -----------------------------------------------\n");
                    System.out.println("1. Cadastrar um novo Aeroporto");
                    System.out.println("2. Cadastrar voos entre aeroportos");
                    System.out.println("3. Remover voo pelo número");
                    System.out.println("4. Listar voos de um aeroporto");
                    System.out.println("0. Sair\n");
                    System.out.println("Qual a opção que você deseja escolher?\n");
                    opcao = sc.nextInt();
               
           
     /*Cadastrar voo: chamar o listar para mostrar todos os aeroportos

     * Adicionar voo: metodo listarAeroportos para mostrar cada aeroporto, depois pede digitacao do codigo do aero,
     metodos listar voos do aeroporto digitado e ai sim pede a digitacao do codigo do aeroporto, chamando o adcVoo.

     * Excluir voos: chama a lista de aeroportos, depois pede o codigo do aeroporto, chama o metodo listarVoos desse aeroporto
     e ai pede o numero do voo, para o usuario saber quais voos estao cadastrar

     *Listar voos: chama metodo listarAeroportos que tenho que criar, pede codigo e ai chama metodo
     */

               switch(opcao){
                    case 1: 
                         boolean cadastro = false;
                         boolean verificaCod = false;
                         try{
                              System.out.println("\n--------- CADASTRAR AEROPORTO ---------\n");
                              try {
                                   Aeroportos.listarAeroportos();
                              } catch (Exception e) {
                                   System.out.println(e.getMessage());
                              }
                              while(!cadastro || !verificaCod){

                                   System.out.println("\nDigite o nome do aeroporto a ser cadastrado ou 'v' para sair:");
                                   String nomeAeroportoCadastro = sc.next();
                                   if(nomeAeroportoCadastro.equals("v")){
                                        System.out.println("\n<< Você retornou! <<");
                                        cadastro = true;
                                        verificaCod = true;
                                   }
                                   else{
                                        while(!verificaCod){
                                             System.out.println("\nDigite o código do aeroporto a ser cadastrado ou 'v' para voltar:");
                                             String codAeroCadastroStr = sc.next();
                                             if(codAeroCadastroStr.equals("v")){
                                                  System.out.println("\n<< Você retornou! <<");
                                                  verificaCod = true;
                                             }
                                             else{
                                                  try {
                                                       Aeroportos.cadastrarAeroporto(nomeAeroportoCadastro, codAeroCadastroStr);
                                                       System.out.println("\n>>>>> Aeroporto cadastrado com SUCESSO <<<<<");
                                                       verificaCod = true;
                                                       cadastro = true;
                                                  } 
                                                  catch (Exception e) {
                                                     System.out.println(e.getMessage());
                                                  }
                                             }
                                        }
                                   }
                              }
                         } 
                         catch (Exception e) {
                              System.out.println(e.getMessage());
                         }
                    break;

                    case 2:
                         try {
                              boolean cadastroVoo = false;
                              boolean verifCodDes = false;
                              boolean verifVoo = false;
                              System.out.println("\n--------- CADASTRAR VOO ---------\n");

                              Aeroportos.isListaAeroportoEmpty();
                              while(!cadastroVoo || !verifCodDes || !verifVoo){
                                   Aeroportos.listarAeroportos();
                                   System.out.println("\nDigite o código do aeroporto de PARTIDA para adicionar um voo ou 'v' para voltar:");
                                   String aeroPartidaAdc = sc.next();
                                   if(aeroPartidaAdc.equals("v")){
                                        System.out.println("\n<< Você retornou! <<");
                                        cadastroVoo = true; //fecha primeiro loop
                                        verifCodDes = true;
                                        verifVoo    = true;         
                                   }
                                   else{
                                        verifCodDes = false;
                                        verifVoo = false;
                                        try {
                                             while(!verifCodDes || !verifVoo){
                                                  Voos.listarVoosPorCod(aeroPartidaAdc); /* código do aeroporto no qual deseja listar seus voos */
                                                  System.out.println("\nDigite o código do aeroporto de DESTINO ou 'v' para voltar:");
                                                  String aeroDestinoAdc = sc.next();
                                                  if(aeroDestinoAdc.equals("v")){
                                                       System.out.println("\n<< Você retornou! <<");
                                                       verifCodDes = true; //fecha segundo loop, volta pro primeiro
                                                       verifVoo = true;
                                                  }
                                                  else{
                                                       while(!verifVoo){
                                                            System.out.println("\nDigite o número do Voo para finalizar o cadastro de Voo ou 'v' para voltar:");
                                                            String numeroVoo = sc.next();
                                                            if(numeroVoo.equals("v")){
                                                                 System.out.println("\n<< Você retornou! <<");
                                                                 verifVoo = true; //fecha terceiro loop, volta pro segundo
                                                            }
                                                            else{
                                                                 try {
                                                                      Voos.adicionarVoo(aeroPartidaAdc, aeroDestinoAdc, numeroVoo);
                                                                      System.out.println("\n>>>>> Voo incluído com SUCESSO <<<<<");
                                                                      cadastroVoo = true;
                                                                      verifCodDes = true; //fecha todos os loops, pois deu certo
                                                                      verifVoo = true;
                                                                 } 
                                                                 catch (Exception e) {
                                                                      System.out.println(e.getMessage());
                                                                 }
                                                            }
                                                       }
                                                  }
                                             }
                                        } catch (Exception e) {
                                             System.out.println(e.getMessage());
                                        } 
                                   }
                              }  
                         } 
                         catch (Exception e) {
                              System.out.println(e.getMessage());
                         }
                    break;
                    
                    case 3: 
                         try {
                              System.out.println("\n--------- REMOVER VOO ---------\n");
                              Aeroportos.isListaAeroportoEmpty();
                         } 
                         catch (Exception e) {
                              System.out.println(e.getMessage());
                         }
                         boolean exlusaoConfere = false;
                         boolean nmrVooConfere  = false;

                         while(!exlusaoConfere || !nmrVooConfere){
                              try {
                                   Aeroportos.listarAeroportos();
                              } catch (Exception e) {
                                   System.out.println(e.getMessage());
                              }
                              System.out.println("\nDigite o código do aeroporto no qual você deseja excluir um voo ou 'v' para voltar:");
                              String aeroCod = sc.next();
                              if(aeroCod.equals("v")){
                                   System.out.println("\n<< Você retornou! <<");
                                   exlusaoConfere = true;
                                   nmrVooConfere = true;
                              }
                              else{
                                   nmrVooConfere = false;
                                   while(!nmrVooConfere){
                                        try {
                                             Voos.listarVoosPorCod(aeroCod);/* código do aeroporto no qual deseja listar seus voos */
                                             System.out.println("\nDigite o número do voo no qual voce deseja excluir ou 'v' para voltar:");
                                             String numeroVooExclusao = sc.next();
                                             if(numeroVooExclusao.equals("v")){
                                                  System.out.println("\n<< Você retornou! <<");
                                                  nmrVooConfere = true;
                                             }
                                             else{
                                                  try {
                                                       Voos.removerVoo(aeroCod, numeroVooExclusao);
                                                       System.out.println("\n>>>>> Voo removido com SUCESSO <<<<<");
                                                       nmrVooConfere  = true;
                                                       exlusaoConfere = true;
                                                  } catch (Exception e) {
                                                       System.out.println(e.getMessage());
                                                  }
                                             }
                                        } 
                                        catch (Exception e) {
                                             System.out.println(e.getMessage());
                                        }
                                   }
                              }
                         }
                         
                    break;

                    case 4:   
                         try {
                              System.out.println("\n--------- LISTAR VOOS ---------\n");
                              Aeroportos.isListaAeroportoEmpty();
                              Aeroportos.listarAeroportos();
                              boolean listagemAero = false;
                              while(!listagemAero){
                                   System.out.println("Digite o código aeroporto no qual você deseja listar seus voos ou 'v' para voltar");
                                   String codAeroLista = sc.next();
                                   if(codAeroLista.equals("v")){
                                        System.out.println("\n<< Você retornou! <<");
                                        listagemAero = true;
                                   }
                                   else{
                                        Voos.listarVoosPorCod(codAeroLista); //teste no método   
                                        listagemAero = true;     
                                   }
                              }  
                         }
                         catch (Exception e) {
                              System.out.println(e.getMessage());
                         } 
                    break;

                    case 0:
                         System.out.println("Obrigado por acessar nosso app!");
                    break;
                    
                    default:
                         System.out.println("Opção invalida");
                    break; 
               }
          }
          sc.close();
     }
}
