package ImoveisPOO;

public class Menu {
    public static void main(String[] args){
        int escolha = 1, escolhaTipo, escolhaContrato, codigoApartamento, codigo, codigoEscritorio ;
        float area;
        String vagaAutomovel, bairro, cidade, tipoContrato, valorContrato, quarto, banheiro, reunioes, internet, vendido, apartamentoOuSala;

        boolean existeSalaReunioes, existeInternet, estaAtivo;

        System.out.println("Por favor defina a quantidade de ofertas para apartamentos");
        int totalApartamento = Util.readInt();
        System.out.println("Por favor defina a quantidade de ofertas para escritórios");
        int totalEscritorio = Util.readInt();
        Agencia agencia = new Agencia(totalApartamento, totalEscritorio);


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
            System.out.println("9- Buscar por ofertas de locação ou venda para apartamentos ou salas");
            System.out.println("10- Buscar por ofertas de locação e venda para apartamentos e salas");
            System.out.println("11- Lista das salas comercializadas");
            escolha = Util.readInt();

            switch (escolha){
                case(0):
                    break;
                case(1):
                    System.out.println("area: ");
                    area = (float) Util.readDbl();

                    System.out.println("bairro: ");
                    bairro = Util.readStr();

                    System.out.println("cidade: ");
                    cidade = Util.readStr();

                    System.out.println("Tipo contrato: ");
                    tipoContrato = Util.readStr();

                    System.out.println("Valor contrato: ");
                    valorContrato = Util.readStr();

                    System.out.println("codigo: ");
                    codigo = Util.readInt();

                    System.out.println("Quantidade de quartos: ");
                    quarto = Util.readStr();

                    System.out.println("Quantidade de banheiros: ");
                    banheiro = Util.readStr();

                    System.out.println("Quantidade de vagas de automovel: ");
                    vagaAutomovel = Util.readStr();

                    agencia.apartamentos.Incluir(area, bairro, cidade, tipoContrato, valorContrato, codigo, quarto, banheiro, vagaAutomovel );
                    break;
                case(2):
                    System.out.println("area: ");
                    area = (float) Util.readDbl();

                    System.out.println("bairro: ");
                    bairro = Util.readStr();

                    System.out.println("cidade: ");
                    cidade = Util.readStr();

                    System.out.println("Tipo contrato: ");
                    tipoContrato = Util.readStr();

                    System.out.println("Valor contrato: ");
                    valorContrato = Util.readStr();

                    System.out.println("codigo: ");
                    codigo = Util.readInt();

                    System.out.println("Sala de reunioes(true/false): ");
                    reunioes = Util.readStr();
                    existeSalaReunioes = reunioes.equals("true");

                    System.out.println("Internet(true/false): ");
                    internet = Util.readStr();
                    existeInternet = reunioes.equals("true");

                    agencia.escritorios.Incluir(area, bairro, cidade, tipoContrato, valorContrato, codigo, existeInternet, existeSalaReunioes);
                    break;
                case(3):
                    System.out.println("Qual o código do apartamento?");
                    codigoApartamento = Util.readInt();

                    System.out.println("area: ");
                    area = (float) Util.readDbl();

                    System.out.println("bairro: ");
                    bairro = Util.readStr();

                    System.out.println("cidade: ");
                    cidade = Util.readStr();

                    System.out.println("Tipo contrato: ");
                    tipoContrato = Util.readStr();

                    System.out.println("Valor contrato: ");
                    valorContrato = Util.readStr();

                    System.out.println("codigo: ");
                    codigo = Util.readInt();

                    System.out.println("Quantidade de quartos: ");
                    quarto = Util.readStr();

                    System.out.println("Quantidade de banheiros: ");
                    banheiro = Util.readStr();

                    System.out.println("Quantidade de vagas de automovel: ");
                    vagaAutomovel = Util.readStr();

                    System.out.println("Está ativo?(true/false)");
                    vendido = Util.readStr();
                    estaAtivo = vendido.equals("true");

                    agencia.apartamentos.Alterar(codigoApartamento, area, bairro, cidade, tipoContrato, valorContrato, codigo, quarto, banheiro, vagaAutomovel, estaAtivo);
                    break;
                case(4):
                    System.out.println("Qual o código do escritorio?");
                    codigoEscritorio = Util.readInt();

                    System.out.println("area: ");
                    area = (float) Util.readDbl();

                    System.out.println("bairro: ");
                    bairro = Util.readStr();

                    System.out.println("cidade: ");
                    cidade = Util.readStr();

                    System.out.println("Tipo contrato: ");
                    tipoContrato = Util.readStr();

                    System.out.println("Valor contrato: ");
                    valorContrato = Util.readStr();

                    System.out.println("codigo: ");
                    codigo = Util.readInt();

                    System.out.println("Sala de reunioes(true/false): ");
                    reunioes = Util.readStr();
                    existeSalaReunioes = reunioes.equals("true");

                    System.out.println("Internet(true/false): ");
                    internet = Util.readStr();
                    existeInternet = reunioes.equals("true");

                    System.out.println("Está ativo?(true/false)");
                    vendido = Util.readStr();
                    estaAtivo = vendido.equals("true");

                    agencia.escritorios.Alterar(codigoEscritorio, area, bairro, cidade, tipoContrato, valorContrato, codigo, existeInternet, existeSalaReunioes,  estaAtivo);
                    break;
                case(5):
                    agencia.apartamentos.Remover(agencia.apartamentos);
                    break;
                case(6):
                    agencia.escritorios.Remover(agencia.escritorios);
                    break;
                case(7):
                    agencia.apartamentos.AtivoDesativo();
                    break;
                case(8):
                    agencia.escritorios.AtivoDesativo();
                    break;
                case(9):
                    System.out.println("Informe o tipo de contrato(locacao/venda): ");
                    tipoContrato = Util.readStr();
                    System.out.println("Informe se é apartamento ou sala: ");
                    apartamentoOuSala = Util.readStr();
                    agencia.VendasAtivas(tipoContrato,apartamentoOuSala);
                    break;
                case(10):
                    System.out.println("O total de ofertas de venda e locacao de casas e apartamentos eh: " + agencia.vendaLocacaoAtiva());
                    break;
                case(11):
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
