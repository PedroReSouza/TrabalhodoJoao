package Carros.java;

public class SUV extends Veiculo {

    public SUV(String placa, String modelo, int ano) {
        super(placa, modelo, ano);
    }

    @Override
    public double calcularDiaria() {
        return 220.00;
    }

    @Override
    public double calcularSeguro() {
        return 60.00;
    }

    @Override
    public double calcularManutencao() {
        return 40.00;
    }
}