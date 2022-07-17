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

            System.out.println("Sala de reunioes(true/false): ");
            String reunioes = Util.readStr();
            boolean existeSalaReunioes = reunioes.equals("true");

            System.out.println("Internet(true/false): ");
            String internet = Util.readStr();
            boolean existeInternet = reunioes.equals("true");

            conjuntoSalaEscritorio[getVagasOcupadas()] = new SalaEscritorio(area, bairro, cidade, tipoContrato, valorContrato, codigo, existeInternet, existeSalaReunioes);
            setPromocoesAtivas(getPromocoesAtivas()+1);
            setVagasOcupadas(getVagasOcupadas()+1);
        }
        else{
            System.out.println("Maximo de escritorios cadastrados");
        }
    }

    @Override
    public void Alterar(){
        System.out.println("Qual o código do escritorio?");
        int codigoEscritorio = Util.readInt();

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

        System.out.println("Sala de reunioes(true/false): ");
        String reunioes = Util.readStr();
        boolean existeSalaReunioes = reunioes.equals("true");

        System.out.println("Internet(true/false): ");
        String internet = Util.readStr();
        boolean existeInternet = reunioes.equals("true");

        System.out.println("Está ativo?(true/false)");
        String vendido = Util.readStr();
        boolean estaAtivo = vendido.equals("true");

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
    public void Remover(){
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

    @Override
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

    public String[] salaComercializada(){
        int contador;
        String[] resultado =new String[this.getTotalVagas()];
        for(contador = 0; contador < this.getVagasOcupadas(); contador++){
            if(this.conjuntoSalaEscritorio[contador].getAtivo()){
                resultado[contador] = "Não vendido";
            }
            else{
                resultado[contador] = "vendido";
            }
        }
        while (contador < this.getTotalVagas()){
            resultado[contador] = "Não Anuciado";
            contador++;
        }
        return resultado;
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
