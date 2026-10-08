package Main;

import model.Popular;
import model.Sedan;
import model.SUV;
import model.Veiculo;
import service.Frota;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        // CRIANDO FROTA
     
        Frota frota = new Frota();

        // CRIANDO VEÍCULOS

        Veiculo popular = new Popular(
            "TYG1234",
            "Gol",
            2020
        );

        Veiculo sedan = new Sedan(
            "ERA5678",
            "Corolla",
            2022
        );

        Veiculo suv = new SUV(
            "GOK9012",
            "Compass",
            2024
        );

        // ADICIONANDO À FROTA
       

        frota.adicionarVeiculo(popular);
        frota.adicionarVeiculo(sedan);
        frota.adicionarVeiculo(suv);


        // LISTA DA FROTA


        System.out.println(
            "===== FROTA DE VEICULOS ====="
        );

        frota.listarVeiculos();


        System.out.println();
        System.out.println(
            "===== POLIMORFISMO ====="
        );

        for (Veiculo veiculo : frota.getVeiculos()) {

            System.out.println(
                "Veiculo: " + veiculo.getModelo()
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

        try {

            // CLIENTE

            Cliente cliente = new Cliente(
                "Pedro",
                "123.456.789-00",
                "(14) 99999-9999",
                "pedro@email.com"
            );

            System.out.println(
                "===== CLIENTE ====="
            );

            cliente.exibirDados();

            System.out.println();

            // VEÍCULO

            Veiculo veiculo = new SUV(
                "ABC1234",
                "Jeep Compass",
                2024
            );

            System.out.println(
                "===== VEICULO ====="
            );

            veiculo.exibirDados();

            System.out.println();

            // LOCAÇÃO

            Locacao locacao = new Locacao(
                cliente,
                veiculo,
                LocalDate.of(2026, 10, 10),
                LocalDate.of(2026, 10, 15)
            );

            System.out.println(
                "===== LOCACAO ====="
            );

            locacao.exibirDados();

            // TENTAR ALUGAR O MESMO VEÍCULO
    

            System.out.println();
            System.out.println(
                "===== TESTE DE EXCECAO ====="
            );

            System.out.println(
                "Tentando alugar o mesmo veiculo novamente..."
            );

            Locacao segundaLocacao = new Locacao(
                cliente,
                veiculo,
                LocalDate.of(2026, 10, 20),
                LocalDate.of(2026, 10, 25)
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                "Erro de validacao: " + e.getMessage()
            );

        } catch (IllegalStateException e) {

            System.out.println(
                "Erro de estado: " + e.getMessage()
            );
        }
        Documento documento = new Contrato();

documento.gerar(locacao);

locacaoService.devolverVeiculo(
    suv,
    LocalDate.of(2026, 10, 15)

    PersistenciaService persistencia =
    new PersistenciaService();

persistencia.salvarLocacao(locacao);
);

documento = new Recibo();

documento.gerar(locacao);
    }