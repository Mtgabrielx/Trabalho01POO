package ImoveisPOO;

public class Apartamento {
    private float area;
    private String bairro;
    private String cidade;
    private String tipoContrato;
    private String valorContrato;
    private int codigo;
    private String quarto;
    private String banheiro;
    private String vagaAutomovel;
    private boolean ativo;

    public Apartamento(float area, String bairro, String cidade, String tipoContrato, String valorContrato, int codigo, String quarto, String banheiro, String vagaAutomovel){
        setArea(area);
        setBairro(bairro);
        setBanheiro(banheiro);
        setCidade(cidade);
        setCodigo(codigo);
        setQuarto(quarto);
        setTipoContrato(tipoContrato);
        setVagaAutomovel(vagaAutomovel);
        setValorContrato(valorContrato);
        setAtivo(true);
    }

    public void Alterar(float area, String bairro, String cidade, String tipoContrato, String valorContrato, int codigo, String quarto, String banheiro, String vagaAutomovel, boolean ativo){
        setArea(area);
        setBairro(bairro);
        setBanheiro(banheiro);
        setCidade(cidade);
        setCodigo(codigo);
        setQuarto(quarto);
        setTipoContrato(tipoContrato);
        setValorContrato(valorContrato);
        setAtivo(ativo);
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

    public String getQuarto() {
        return quarto;
    }

    public void setQuarto(String quarto) {
        this.quarto = quarto;
    }

    public String getBanheiro() {
        return banheiro;
    }

    public void setBanheiro(String banheiro) {
        this.banheiro = banheiro;
    }

    public String getVagaAutomovel() {
        return vagaAutomovel;
    }

    public void setVagaAutomovel(String vagaAutomovel) {
        this.vagaAutomovel = vagaAutomovel;
    }

    public boolean getAtivo(){
        return this.ativo;
    }

    public void setAtivo(Boolean ativo){
        this.ativo = ativo;
    }
}
