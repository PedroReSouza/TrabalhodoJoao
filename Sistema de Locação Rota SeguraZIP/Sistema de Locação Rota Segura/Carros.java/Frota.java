package Carros.java;

import java.util.ArrayList;
import model.Veiculo;

public class Frota {

    private ArrayList<Veiculo> veiculos;

    public Frota() {
        veiculos = new ArrayList<>();
    }

    // =========================
    // ADICIONAR VEÍCULO
    // =========================

    public void adicionarVeiculo(Veiculo veiculo) {

        if (veiculo == null) {
            throw new IllegalArgumentException(
                "O veiculo nao pode ser nulo."
            );
        }

        veiculos.add(veiculo);
    }

    // LISTAR VEÍCULOS

    public void listarVeiculos() {

        if (veiculos.isEmpty()) {
            System.out.println(
                "Nenhum veiculo cadastrado."
            );
            return;
        }

        for (Veiculo veiculo : veiculos) {

            System.out.println(
                "=============================="
            );

            veiculo.exibirDados();
        }

        System.out.println(
            "=============================="
        );
    }


    //VALOR DA FROTA


    public void mostrarValores() {

        for (Veiculo veiculo : veiculos) {

            System.out.println(
                "Modelo: " + veiculo.getModelo()
            );

            System.out.printf(
                "Diaria: R$ %.2f%n",
                veiculo.calcularDiaria()
            );

            System.out.printf(
                "Seguro: R$ %.2f%n",
                veiculo.calcularSeguro()
            );

            System.out.printf(
                "Manutencao: R$ %.2f%n",
                veiculo.calcularManutencao()
            );

            System.out.println(
                "------------------------------"
            );
        }
    }


    // BUSCA PELA PLACA


    public Veiculo buscarPorPlaca(String placa) {

        for (Veiculo veiculo : veiculos) {

            if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                return veiculo;
            }
        }

        return null;
    }


    // GETTER LISTA
   

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

public void listarDisponiveis() {

    boolean encontrou = false;

    System.out.println(
        "===== VEICULOS DISPONIVEIS ====="
    );

    for (Veiculo veiculo : veiculos) {

        if (veiculo.isDisponivel()) {

            System.out.println(
                "Placa: " + veiculo.getPlaca()
            );

            System.out.println(
                "Modelo: " + veiculo.getModelo()
            );

            System.out.printf(
                "Diaria: R$ %.2f%n",
                veiculo.calcularDiaria()
            );

            System.out.println(
                "------------------------------"
            );

            encontrou = true;
        }
    }

    if (!encontrou) {
        System.out.println(
            "Nenhum veiculo disponivel."
        );
    }
}

}