package Locacao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import model.Locacao;

public class PersistenciaService {

    private static final String ARQUIVO = "historico_locacoes.txt";

    public void salvarLocacao(Locacao locacao) {

        if (locacao == null) {
            throw new IllegalArgumentException(
                "A locacao nao pode ser nula."
            );
        }

        try (
            FileWriter fileWriter = new FileWriter(ARQUIVO, true);
            PrintWriter writer = new PrintWriter(fileWriter)
        ) {

            writer.println("========================================");
            writer.println("REGISTRO DE LOCACAO");
            writer.println("Cliente: " + locacao.getCliente().getNome());
            writer.println("CPF: " + locacao.getCliente().getCpf());
            writer.println("Veiculo: " + locacao.getVeiculo().getModelo());
            writer.println("Placa: " + locacao.getVeiculo().getPlaca());
            writer.println("Data retirada: " + locacao.getDataRetirada());
            writer.println(
                "Devolucao prevista: " +
                locacao.getDataDevolucaoPrevista()
            );
            writer.println(
                "Devolucao real: " +
                locacao.getDataDevolucaoReal()
            );
            writer.println("Status: " + locacao.getStatus());
            writer.printf(
                "Valor total: R$ %.2f%n",
                locacao.getValorTotal()
            );
            writer.println("========================================");
            writer.println();

        } catch (IOException e) {

            throw new RuntimeException(
                "Erro ao salvar historico da locacao.",
                e
            );
        }
    }

    public void exibirHistorico() {

        java.io.File arquivo = new java.io.File(ARQUIVO);

        if (!arquivo.exists()) {
            System.out.println(
                "Nenhum historico encontrado."
            );
            return;
        }

        try {

            java.util.Scanner scanner =
                new java.util.Scanner(arquivo);

            System.out.println();
            System.out.println("========== HISTORICO ==========");

            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }

            scanner.close();

        } catch (IOException e) {

            throw new RuntimeException(
                "Erro ao ler o historico.",
                e
            );
        }
    }
}