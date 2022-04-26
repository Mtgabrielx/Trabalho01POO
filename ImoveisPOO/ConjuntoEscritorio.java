package ImoveisPOO;

public class ConjuntoEscritorio extends Agencia{
    private SalaEscritorio[] conjuntoSalaEscritorio;
    private int totalVagas = 0;
    private int vagasOcupadas = 0;
    private int promocoesAtivas = 0;

    public void numeroSalaEscritorio(int numeroSalaEscritorio){
        setTotalVagas(numeroSalaEscritorio);
        this.conjuntoSalaEscritorio = new SalaEscritorio[getTotalVagas()];
    }

    @Override
    public void Incluir(float area, String bairro, String cidade, String tipoContrato, String valorContrato, int codigo, boolean existeInternet, boolean existeSalaReunioes){
        if(getTotalVagas() != getVagasOcupadas()){
            conjuntoSalaEscritorio[getVagasOcupadas()] = new SalaEscritorio(area, bairro, cidade, tipoContrato, valorContrato, codigo, existeInternet, existeSalaReunioes);
            setPromocoesAtivas(getPromocoesAtivas()+1);
            setVagasOcupadas(getVagasOcupadas()+1);
        }
        else{
            System.out.println("Maximo de escritorios cadastrados");
        }
    }

    @Override
    public void Alterar(int codigoEscritorio, float area, String bairro, String cidade, String tipoContrato, String valorContrato, int codigo, boolean existeInternet, boolean existeSalaReunioes, boolean estaAtivo){
        int contador = 0;
        boolean existe = false;

        while(!existe && contador < getVagasOcupadas()){
            if(conjuntoSalaEscritorio[contador].getCodigo() == codigoEscritorio){
                existe = true;
            }
            contador++;
        }
        if(existe){
            conjuntoSalaEscritorio[contador-1].Alterar(area, bairro, cidade, tipoContrato, valorContrato, codigo, existeInternet, existeSalaReunioes,estaAtivo);
        }
        else{
            System.out.println("Codigo de imovel não encontrado");
        }
    }

    @Override
    public void Remover(ConjuntoEscritorio escritorio){
        System.out.println("Digite o codigo do escritório");
        int codigo = Util.readInt();
        int contador = 0;
        boolean existe = false;
        boolean estaAtivo = false;
        while(!existe && contador < getVagasOcupadas()){
            if(conjuntoSalaEscritorio[contador].getCodigo() == codigo){
                existe = true;
                estaAtivo = conjuntoSalaEscritorio[contador].getAtivo();
            }
            contador++;
        }
        if(existe){
            while(contador < getVagasOcupadas()){
                conjuntoSalaEscritorio[contador] = conjuntoSalaEscritorio[contador];
                contador++;
            }
            if(estaAtivo){
                setPromocoesAtivas(getPromocoesAtivas()-1);
            }
            setVagasOcupadas(getVagasOcupadas()-1);
            System.out.println("Removido com sucesso!");
        }
        else{
            System.out.println("Codigo de imovel não encontrado");
        }
    }


    //@Override
    public void AtivoDesativo(){
        System.out.println("Digite o número do Codigo: ");
        int codigo = Util.readInt();
        int contador = 0;
        boolean encontrado = false;
        while (!encontrado && contador < this.getVagasOcupadas() ){
            if(codigo == this.conjuntoSalaEscritorio[contador].getCodigo()){
                encontrado = true;

                if(this.conjuntoSalaEscritorio[contador].getAtivo()){
                    setPromocoesAtivas(getPromocoesAtivas()-1);
                }
                else{
                    setPromocoesAtivas(getPromocoesAtivas()+1);
                }
                this.conjuntoSalaEscritorio[contador].setAtivo(!this.conjuntoSalaEscritorio[contador].getAtivo());

            }
            contador++;
        }
    }

    //encontra o tipo proposta de locacao
    public int encontrarLocacao(){
        int contador = 0;
        int resultado = 0;
        while ( contador < this.getVagasOcupadas() ){
            if(this.conjuntoSalaEscritorio[contador].getTipoContrato().equals("locação") ||this.conjuntoSalaEscritorio[contador].getTipoContrato().equals("locacao") ){
                resultado++;
            }
            contador++;
        }
        return resultado;
    }

    //encontra o tipo proposta de locacao
    public int encontrarVenda(){
        int contador = 0;
        int resultado = 0;
        while ( contador < this.getVagasOcupadas() ){
            if(this.conjuntoSalaEscritorio[contador].getTipoContrato().equals("venda")){
                resultado++;
            }
            contador++;
        }
        return resultado;
    }

    //Define um vetor lista informando se uma sala foi ou não vendida
    public String[] salaComercializada(){
        int contador;
        String[] resultado = new String[this.getTotalVagas()];
        for(contador = 0; contador < this.getVagasOcupadas(); contador++){
            resultado[contador] = ("Sala de código" + this.conjuntoSalaEscritorio[contador].getCodigo());
            if(!this.conjuntoSalaEscritorio[contador].getAtivo()){
                resultado[contador] = " vendido";
            }
        }
        return resultado;
    }

    @Override
    public int vendaLocacaoAtiva(){
        int contador = 0, totalOfertas = 0;
        while (contador < this.getVagasOcupadas()){
            if(this.conjuntoSalaEscritorio[contador].getAtivo()){
                totalOfertas++;
            }
            contador++;
        }
        return totalOfertas;
    }

    public int getTotalVagas() {
        return totalVagas;
    }

    public void setTotalVagas(int totalVagas) {
        this.totalVagas = totalVagas;
    }

    public int getVagasOcupadas() {
        return vagasOcupadas;
    }

    public void setVagasOcupadas(int vagasOcupadas) {
        this.vagasOcupadas = vagasOcupadas;
    }

    public int getPromocoesAtivas() {
        return promocoesAtivas;
    }

    public void setPromocoesAtivas(int promocoesAtivas) {
        this.promocoesAtivas = promocoesAtivas;
    }
}
