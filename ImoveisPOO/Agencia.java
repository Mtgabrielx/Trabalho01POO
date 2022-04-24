package ImoveisPOO;

import java.util.Arrays;

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

    public void Incluir(){}
    public void Alterar(){}
    public void Remover(){}
    public void AtivoDesativo(){} // olha essa

    public void VendasAtivas(int escolhaContrato, int escolhaTipo){
        if(escolhaTipo == 1){
            if(escolhaContrato == 1){
                System.out.println(this.escritorios.encontrarVenda());
            }
            else{
                System.out.println(this.escritorios.encontrarLocacao());
            }
        }
        else{
            if(escolhaContrato == 1){
                System.out.println(this.apartamentos.encontrarVenda());
            }
            else{
                System.out.println(this.apartamentos.encontrarLocacao());
            }
        }
    }

    public void salasComercializadas(){
        String[] resultado = this.escritorios.salaComercializada();
        for(int contador = 0; contador < resultado.length; contador++){
            System.out.println((contador+1) + ": " + resultado[contador]);
        }
    }
}
