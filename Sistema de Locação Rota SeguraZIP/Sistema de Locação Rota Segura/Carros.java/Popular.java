package Carros.java;

public class Popular extends Veiculo {

    public Popular(String placa, String modelo, int ano) {
        super(placa, modelo, ano);
    }

    @Override
    public double calcularDiaria() {
        return 100.00;
    }

    @Override
    public double calcularSeguro() {
        return 30.00;
    }

    @Override
    public double calcularManutencao() {
        return 20.00;
    }
}