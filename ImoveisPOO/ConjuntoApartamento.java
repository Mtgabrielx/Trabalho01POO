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
    public void Incluir(){
        if(getTotalVagas() != getVagasOcupadas()){
            System.out.println("area: ");
            float area = (float) Util.readDbl();

            System.out.println("bairro: ");
            String bairro = Util.readStr();

            System.out.println("cidade: ");
            String cidade = Util.readStr();

            System.out.println("Tipo contrato: ");
            String tipoContrato = Util.readStr();

            System.out.println("Valor contrato: ");
            String valorContrato = Util.readStr();

            System.out.println("codigo: ");
            int codigo = Util.readInt();

            System.out.println("Quantidade de quartos: ");
            String quarto = Util.readStr();

            System.out.println("Quantidade de banheiros: ");
            String banheiro = Util.readStr();

            System.out.println("Quantidade de vagas de automovel: ");
            String vagaAutomovel = Util.readStr();

            conjuntoApartamento[getVagasOcupadas()] = new Apartamento(area, bairro, cidade, tipoContrato, valorContrato, codigo, quarto, banheiro, vagaAutomovel);
            setVagasOcupadas(getVagasOcupadas()+1);
            setPromocoesAtivas(getPromocoesAtivas()+1);
        }
        else{
            System.out.println("Maximo de apartamentos cadastrados");
        }

    }

    @Override
    public void Alterar(){
        System.out.println("Qual o código do apartamento?");
        int codigoApartamento = Util.readInt();

        System.out.println("area: ");
        float area = (float) Util.readDbl();

        System.out.println("bairro: ");
        String bairro = Util.readStr();

        System.out.println("cidade: ");
        String cidade = Util.readStr();

        System.out.println("Tipo contrato: ");
        String tipoContrato = Util.readStr();

        System.out.println("Valor contrato: ");
        String valorContrato = Util.readStr();

        System.out.println("codigo: ");
        int codigo = Util.readInt();

        System.out.println("Quantidade de quartos: ");
        String quarto = Util.readStr();

        System.out.println("Quantidade de banheiros: ");
        String banheiro = Util.readStr();

        System.out.println("Quantidade de vagas de automovel: ");
        String vagaAutomovel = Util.readStr();

        System.out.println("Está ativo?(true/false)");
        String vendido = Util.readStr();
        boolean estaAtivo = vendido.equals("true");

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
    public void Remover(){
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

    @Override
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
