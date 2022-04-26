package ImoveisPOO;

public class Agencia {

    protected ConjuntoApartamento apartamentos;
    protected ConjuntoEscritorio escritorios;

    public Agencia(){}

    protected Agencia(int numeroApartamentos, int numeroEscritorio){
        apartamentos = new ConjuntoApartamento();
        escritorios = new ConjuntoEscritorio();
        apartamentos.numeroApartamento(numeroApartamentos);
        escritorios.numeroSalaEscritorio(numeroEscritorio);
    }

    public void Incluir(float area, String bairro, String cidade, String tipoContrato, String valorContrato, int codigo, String quarto, String banheiro, String vagaAutomovel){}
    public void Incluir(float area, String bairro, String cidade, String tipoContrato, String valorContrato, int codigo, boolean internet, boolean salaReuniaoComunitaria){}
    public void Alterar(int codigoEscritorio, float area, String bairro, String cidade, String tipoContrato, String valorContrato, int codigo, boolean existeInternet, boolean existeSalaReunioes, boolean estaAtivo){}
    public void Alterar(int codigoApartamento, float area, String bairro, String cidade, String tipoContrato, String valorContrato, int codigo, String quarto, String banheiro, String vagaAutomovel, boolean estaAtivo){}
    public void Remover(ConjuntoApartamento apartamento){}
    public void Remover(ConjuntoEscritorio escritorio){}
    public void AtivoDesativo(ConjuntoEscritorio escritorio){} // olha essa

    // ele procura o tipo de contrato se eh venda ou locacao e o tipo de venda sala ou escritorio
    public void VendasAtivas(String escolhaContrato, String escolhaTipo){
        if(escolhaTipo.equals("escritorio")){
            if(escolhaContrato.equals("venda")){
                System.out.println(this.escritorios.encontrarVenda());
            }
            else{
                System.out.println(this.escritorios.encontrarLocacao());
            }
        }
        else{
            if(escolhaContrato.equals("venda")){
                System.out.println(this.apartamentos.encontrarVenda());
            }
            else{
                System.out.println(this.apartamentos.encontrarLocacao());
            }
        }
    }


    public int vendaLocacaoAtiva(){
        return this.apartamentos.vendaLocacaoAtiva() +this.escritorios.vendaLocacaoAtiva();
    }

    // ele retorna um vetor de string informando um codigo de um sala e se ela esta comercializada
    public void salasComercializadas(){
        String[] resultado = this.escritorios.salaComercializada();
        for(int contador = 0; contador < resultado.length; contador++){
            System.out.println((contador+1) + ": " + resultado[contador]);
        }
    }
}
