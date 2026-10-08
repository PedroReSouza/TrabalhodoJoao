package Carros.java;

public class Sedan extends Veiculo {

    public Sedan(String placa, String modelo, int ano) {
        super(placa, modelo, ano);
    }

    @Override
    public double calcularDiaria() {
        return 150.00;
    }

    @Override
    public double calcularSeguro() {
        return 45.00;
    }

    @Override
    public double calcularManutencao() {
        return 30.00;
    }
}