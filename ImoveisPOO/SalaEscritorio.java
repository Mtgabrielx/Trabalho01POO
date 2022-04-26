package ImoveisPOO;

public class SalaEscritorio {
    private float area;
    private String bairro;
    private String cidade;
    private String tipoContrato;
    private String valorContrato;
    private int codigo;
    private boolean internet;
    private boolean salaReuniaoComunitaria;
    private boolean ativo;

    // Metodo Construtor
    public SalaEscritorio(float area, String bairro, String cidade, String tipoContrato, String valorContrato, int codigo, boolean internet, boolean salaReuniaoComunitaria){
        setArea(area);
        setBairro(bairro);
        setCidade(cidade);
        setCodigo(codigo);
        setTipoContrato(tipoContrato);
        setValorContrato(valorContrato);
        setSalaReuniaoComunitaria(salaReuniaoComunitaria);
        setInternet(internet);
        setAtivo(true);
    }

    // Metodo para alterar valores de um salaEscritorio
    public void Alterar(float area, String bairro, String cidade, String tipoContrato, String valorContrato, int codigo, boolean internet, boolean salaReuniaoComunitaria, boolean estaAtivo){
        setArea(area);
        setBairro(bairro);
        setCidade(cidade);
        setCodigo(codigo);
        setTipoContrato(tipoContrato);
        setValorContrato(valorContrato);
        setSalaReuniaoComunitaria(salaReuniaoComunitaria);
        setInternet(internet);
        setAtivo(estaAtivo);
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public String getValorContrato() {
        return valorContrato;
    }

    public void setValorContrato(String valorContrato) {
        this.valorContrato = valorContrato;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public boolean isInternet() {
        return internet;
    }

    public void setInternet(boolean internet) {
        this.internet = internet;
    }

    public boolean isSalaReuniaoComunitaria() {
        return salaReuniaoComunitaria;
    }

    public void setSalaReuniaoComunitaria(boolean salaReuniaoComunitaria) {
        this.salaReuniaoComunitaria = salaReuniaoComunitaria;
    }

    public boolean getAtivo(){
        return this.ativo;
    }

    public void setAtivo(Boolean ativo){
        this.ativo = ativo;
    }
}

