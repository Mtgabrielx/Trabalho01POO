package ImoveisPOO;

class ConjuntoApartamento extends Agencia {
    private Apartamento[] conjuntoApartamento;
    private int totalVagas = 0;
    private int vagasOcupadas = 0;
    private int promocoesAtivas = 0;

    public void numeroApartamento(int numeroApartamento){
        setTotalVagas(numeroApartamento);
        conjuntoApartamento = new Apartamento[getTotalVagas()];
    }

    @Override
    public void Incluir(float area, String bairro, String cidade, String tipoContrato, String valorContrato, int codigo, String quarto, String banheiro, String vagaAutomovel){
        if(getTotalVagas() != getVagasOcupadas()){
            conjuntoApartamento[getVagasOcupadas()] = new Apartamento(area, bairro, cidade, tipoContrato, valorContrato, codigo, quarto, banheiro, vagaAutomovel);
            setVagasOcupadas(getVagasOcupadas()+1);
            setPromocoesAtivas(getPromocoesAtivas()+1);
        }
        else{
            System.out.println("Maximo de apartamentos cadastrados");
        }

    }

    @Override
    public void Alterar(int codigoApartamento, float area, String bairro, String cidade, String tipoContrato, String valorContrato, int codigo, String quarto, String banheiro, String vagaAutomovel, boolean estaAtivo){
        int contador = 0;
        boolean existe = false;
        while(!existe && contador < getVagasOcupadas()){
            if(conjuntoApartamento[contador].getCodigo() == codigoApartamento){
                existe = true;
            }
            contador++;
        }
        if(existe){
            conjuntoApartamento[contador-1].Alterar(area, bairro, cidade, tipoContrato, valorContrato, codigo, quarto, banheiro,vagaAutomovel, estaAtivo);
        }
        else{
            System.out.println("Codigo de imovel não encontrado");
        }
    }

    @Override
    public void Remover(ConjuntoApartamento apartamento){
        System.out.println("Informe o codigo do apartamento a ser removido");
        int codigo = Util.readInt();
        int contador = 0;
        boolean existe = false;
        boolean estaAtivo = false;
        while(!existe && contador < getVagasOcupadas()){
            if(conjuntoApartamento[contador].getCodigo() == codigo){
                existe = true;
                estaAtivo = conjuntoApartamento[contador].getAtivo();
                conjuntoApartamento[contador] = null;
            }
            contador++;
        }
        if(existe){
            System.out.println(contador);
            while(contador < getVagasOcupadas()){
                conjuntoApartamento[contador] = conjuntoApartamento[contador];
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


   // @Override
    public void AtivoDesativo(){
        System.out.println("Digite o valor do Codigo: ");
        int codigo = Util.readInt();
        int contador = 0;
        boolean encontrado = false;
        while (!encontrado && contador < this.getVagasOcupadas() ){
            if(codigo == this.conjuntoApartamento[contador].getCodigo()){
                encontrado = true;

                if(this.conjuntoApartamento[contador].getAtivo()){
                    setPromocoesAtivas(getPromocoesAtivas()-1);
                }
                else{
                    setPromocoesAtivas(getPromocoesAtivas()+1);
                }
                this.conjuntoApartamento[contador].setAtivo(!this.conjuntoApartamento[contador].getAtivo());
            }
            contador++;
        }
    }

   // encontra apartamentos com o tipo de contrato locacao
    public int encontrarLocacao(){
        int contador = 0;
        int resultado = 0;
        while ( contador < this.getVagasOcupadas() ){
            if(this.conjuntoApartamento[contador].getTipoContrato().equals("locação") || this.conjuntoApartamento[contador].getTipoContrato().equals("locacao")){
                resultado++;
            }
            contador++;
        }
        return resultado;
    }

    // encontra apartamentos com o tipo de contrato venda
    public int encontrarVenda(){
        int contador = 0;
        int resultado = 0;
        while ( contador < this.getVagasOcupadas() ){
            if(this.conjuntoApartamento[contador].getTipoContrato().equals("venda")){
                resultado++;
            }
            contador++;
        }
        return resultado;
    }

    @Override
    public int vendaLocacaoAtiva(){
        int contador = 0, totalOfertas = 0;
        while (contador < this.getVagasOcupadas()){
            if(this.conjuntoApartamento[contador].getAtivo()){
                totalOfertas++;
            }
            contador++;
        }
        return totalOfertas;
    }

    public int getTotalVagas() {
        return totalVagas;
    }

    public void setTotalVagas(int numeroApartamento) {
        this.totalVagas = numeroApartamento;
    }

    public int getVagasOcupadas() {
        return vagasOcupadas;
    }

    public void setVagasOcupadas(int ocupados) {
        this.vagasOcupadas = ocupados;
    }

    public int getPromocoesAtivas() {
        return promocoesAtivas;
    }

    public void setPromocoesAtivas(int ativos) {
        this.promocoesAtivas = ativos;
    }
}
