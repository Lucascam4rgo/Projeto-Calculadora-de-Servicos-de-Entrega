package CalculadoraDeServiçosDeEntrega.entities;

public class Entrega {

    public static final double TARIFA_POR_KM = 1.20;
    public static final double TARIFA_POR_PESO = 3.0;
    public static final double VALOR_ENTREGA = 8.90;
    public static final double TARIFA_POR_ENTREGA_EXPRESSA = 10.0;
    public static final double AUMENTO_FIM_DE_SEMANA = 15.0;

    public double distanciaKm;
    public double pesoKg;
    public int tipoEntrega;
    public boolean fimDeSemana;

    public double precoDistancia () {
        return distanciaKm * TARIFA_POR_KM;
    }

    public double precoKilo () {
        return pesoKg * TARIFA_POR_PESO;
    }

    public double tipoDeEntrega() {
        if (tipoEntrega == 1) {
            return VALOR_ENTREGA;
        }
        else if (tipoEntrega == 2){
            return VALOR_ENTREGA + (VALOR_ENTREGA * TARIFA_POR_ENTREGA_EXPRESSA/100);
        }

        return VALOR_ENTREGA;
    }

    public boolean isFimDeSemana() {
        return fimDeSemana;
    }

    public double aplicarTaxaFimdeSemana() {
        if (isFimDeSemana()) {
            return AUMENTO_FIM_DE_SEMANA;
        }
        else {
            return 0.0;
        }
    }

    public double valorTotal() {
        double valorTotal = 0;
        return valorTotal + (precoDistancia() + precoKilo() + tipoDeEntrega() + aplicarTaxaFimdeSemana());
    }




}
