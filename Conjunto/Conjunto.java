package TrabalhoPOO;

public class Conjunto {
    private int [] conjunto;
    public int indice;

    public void CriarConjuntos(){
        this.conjunto = new int[100];
        this.indice = 0;
        //System.out.println("Conjunto criado com sucesso");
    }

    public void InserirValor(int valor){
        this.conjunto[this.indice] = valor;
        //System.out.println("O valor " + this.conjunto[this.indice]+ " foi adicionado com sucesso");
        this.indice++;
    }

    public boolean PresenteConjunto(int procurando){
        int posicao = 0;
        while( posicao < this.indice && this.conjunto[posicao] != procurando ){
            posicao++;
        }
        //System.out.println("Valor não encontrado");
        //System.out.println("Valor encontrado na posição " + posicao);
        return posicao != this.indice;
    }

    public void EstaContidoConjunto(Conjunto Contem){
        int inicio = 0 , fim;
        fim = this.indice;

        while(inicio != fim && Contem.PresenteConjunto(this.conjunto[inicio])){
            inicio++;
        }
        if(inicio == fim ){
            System.out.println("O primeiro conjunto está contido no segundo");
        }
        else{
            System.out.println("O primeiro conjunto não está contido no segundo");
        }
    }

    public Conjunto UnirConjunto(Conjunto SerUnido){
        Conjunto unido = new Conjunto();
        unido.CriarConjuntos();
        int posicaoUm = 0, posicaoDois = 0;
        while (posicaoUm < this.indice && posicaoDois < SerUnido.indice){
            if( this.conjunto[posicaoUm] == SerUnido.conjunto[posicaoDois]){
                unido.InserirValor(this.conjunto[posicaoUm]);
                posicaoUm++;
                posicaoDois++;
            }
            else if(this.conjunto[posicaoUm] < SerUnido.conjunto[posicaoDois]){
                unido.InserirValor( this.conjunto[posicaoUm]);
                posicaoUm++;
            }
            else{
                unido.InserirValor( SerUnido.conjunto[posicaoDois]);
                posicaoDois++;
            }
        }
        if(this.indice == posicaoUm && SerUnido.indice > posicaoDois){
            while(posicaoDois < SerUnido.indice){
                unido.InserirValor(SerUnido.conjunto[posicaoDois]);
                posicaoDois++;
            }
        }
        else if(SerUnido.indice == posicaoDois && this.indice > posicaoUm  ){
            unido.InserirValor(this.conjunto[posicaoUm]);
            posicaoUm++;
        }
        return unido;
    }

    public Conjunto interseccao(Conjunto SerIntersec){
        Conjunto inter = new Conjunto();
        inter.CriarConjuntos();
        int contador = 0 , posicao = 0;
        while(contador < this.indice && posicao < SerIntersec.indice){
            if( this.conjunto[contador] < SerIntersec.conjunto[posicao]){
                contador++;
            }
            if( this.conjunto[contador] == SerIntersec.conjunto[posicao] ){
                inter.InserirValor(this.conjunto[contador]);
                contador++;
                posicao++;
            }
            else{
                posicao++;
            }
        }
        if(posicao != SerIntersec.indice){
            while(posicao < SerIntersec.indice){
                if(SerIntersec.conjunto[posicao] == this.conjunto[contador-1]){
                    inter.InserirValor(SerIntersec.conjunto[posicao]);
                }
                posicao++;
            }
        }
        else if(contador != this.indice){
            while(contador < this.indice){
                if(this.conjunto[contador] == SerIntersec.conjunto[posicao-1]){
                    inter.InserirValor(this.conjunto[contador]);
                }
                contador++;
            }
        }

        return inter;
    }

    public Conjunto Diferenca(Conjunto diferente){
        Conjunto resultado = new Conjunto();
        resultado.CriarConjuntos();
        int contador = 0 , posicao = 0;
        while(contador < this.indice && posicao < diferente.indice){
            if( this.conjunto[contador] < diferente.conjunto[posicao]){
                resultado.InserirValor(this.conjunto[contador]);
                contador++;
            }
            else if( this.conjunto[contador] == diferente.conjunto[posicao] ){
                contador++;
                posicao++;
            }
            else{
                posicao++;
            }
        }
        if(contador != this.indice){
            while(contador < this.indice){
                if(this.conjunto[contador] != diferente.conjunto[posicao-1]){
                    resultado.InserirValor(this.conjunto[contador]);
                }
                contador++;
            }
        }

        return resultado;
    }

    public void Apresentar(){
        int i;
        for( i = 0; i < this.indice; i++){
            System.out.println(this.conjunto[i]);
        }
    }

    public static void main(String[] args){
        Conjunto a = new Conjunto();
        Conjunto b = new Conjunto();
        Conjunto c = new Conjunto();
        Conjunto d = new Conjunto();
        a.CriarConjuntos();
        b.CriarConjuntos();
        c.CriarConjuntos();
        d.CriarConjuntos();

        a.InserirValor(0);
        a.InserirValor(1);
        a.InserirValor(2);
        a.InserirValor(3);
        a.InserirValor(4);
        a.InserirValor(5);
        a.InserirValor(6);
        a.InserirValor(7);
        a.InserirValor(8);
        a.InserirValor(9);

        b.InserirValor(0);
        b.InserirValor(2);
        b.InserirValor(4);
        b.InserirValor(6);
        b.InserirValor(8);

        c.InserirValor(1);
        c.InserirValor(3);
        c.InserirValor(5);
        c.InserirValor(7);
        c.InserirValor(9);

        d.InserirValor(2);
        d.InserirValor(3);
        d.InserirValor(5);
        d.InserirValor(7);
        d.InserirValor(9);
        d.InserirValor(11);
        d.InserirValor(13);
        d.InserirValor(17);
        d.InserirValor(19);
        d.InserirValor(23);

        System.out.println("Se o conjunto 4 é subconjunto de si mesmo\n");
        a.EstaContidoConjunto(a);

        System.out.println("A pertinência dos conjuntos 2, 3 e 4 no conjunto 1\n");
        b.EstaContidoConjunto(a);
        c.EstaContidoConjunto(a);
        d.EstaContidoConjunto(a);

        System.out.println("Se a união de 2 e 3 é igual ao conjunto 1;\n");
        Conjunto UniaoBC = b.UnirConjunto(c);
        UniaoBC.EstaContidoConjunto(a);

        System.out.println("Se a intersecção dos conjuntos 1 e 2 é vazia");
        Conjunto AinterB = a.interseccao(b);
        AinterB.Apresentar();

        System.out.println("Qual diferença entre os conjuntos 1 e 2;\n");
        Conjunto DifAB = a.Diferenca(b);
        DifAB.Apresentar();
    }
}

