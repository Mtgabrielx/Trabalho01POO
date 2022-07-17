package ImoveisPOO;

public class Menu {
    public static void main(String[] args){
        System.out.println("Por favor defina a quantidade de ofertas para apartamentos");
        int totalApartamento = Util.readInt();
        System.out.println("Por favor defina a quantidade de ofertas para escritórios");
        int totalEscritorio = Util.readInt();
        Agencia agencia = new Agencia(totalApartamento, totalEscritorio);

        int escolha = 1;
        int escolhaTipo;
        int escolhaContrato;
        while(escolha !=0){
            System.out.println("\nMenu da Agencia, por favor escolha dentre uma das opções abaixo");
            System.out.println("0 -Sair");
            System.out.println("1 -Incluir apartamento");
            System.out.println("2- Incluir escritório");
            System.out.println("3- Alterar dados apartamento");
            System.out.println("4- Alterar dados escritório");
            System.out.println("5- Remover dados apartamento");
            System.out.println("6- Remover dados escritório");
            System.out.println("7- Invetar ativo e inativo para um apartamento");
            System.out.println("8- Invetar ativo e inativo para um escritório");
            System.out.println("9- Total de locação disponíveis para um apartamento");
            System.out.println("10- Total de locação disponíveis para um escritório");
            System.out.println("11- Total de venda disponiveis para um apartamento");
            System.out.println("12- Total de venda disponiveis  para um escritório");
            System.out.println("13- Lista das salas comercializadas");
            escolha = Util.readInt();

            switch (escolha){
                case(0):
                    break;
                case(1):
                    agencia.apartamentos.Incluir();
                    break;
                case(2):
                    agencia.escritorios.Incluir();
                    break;
                case(3):
                    agencia.apartamentos.Alterar();
                    break;
                case(4):
                    agencia.escritorios.Alterar();
                    break;
                case(5):
                    agencia.apartamentos.Remover();
                    break;
                case(6):
                    agencia.escritorios.Remover();
                    break;
                case(7):
                    agencia.apartamentos.AtivoDesativo();
                    break;
                case(8):
                    agencia.escritorios.AtivoDesativo();
                    break;
                case(9):
                    agencia.VendasAtivas(0,0);
                    break;
                case(10):
                    agencia.VendasAtivas(0,1);
                    break;
                case(11):
                    agencia.VendasAtivas(1,0);
                    break;
                case(12):
                    agencia.VendasAtivas(1,1);
                    break;
                case(13):
                    agencia.salasComercializadas();
                    break;
                default:
                    System.out.println("Valor inválido!");
                    break;
            }
            System.out.println("\n\n");
        }
        System.out.println("Programa finalizado...");
    }
}
