package Locacao;

import model.Locacao;
import model.StatusLocacao;

public class RelatorioService {

    private LocacaoService locacaoService;

    public RelatorioService(LocacaoService locacaoService) {
        if (locacaoService == null) {
            throw new IllegalArgumentException(
                "O servico de locacao nao pode ser nulo."
            );
        }

        this.locacaoService = locacaoService;
    }

    public void gerarRelatorioFechamento() {

        double total = 0.0;
        int quantidade = 0;

        System.out.println();
        System.out.println("========================================");
        System.out.println("       RELATORIO DE FECHAMENTO");
        System.out.println("========================================");

        for (Locacao locacao : locacaoService.getLocacoes()) {

            if (locacao.getStatus() == StatusLocacao.ENCERRADA) {

                quantidade++;
                total += locacao.getValorTotal();

                System.out.println(
                    "Cliente: " + locacao.getCliente().getNome()
                );

                System.out.println(
                    "Veiculo: " + locacao.getVeiculo().getModelo()
                );

                System.out.printf(
                    "Valor: R$ %.2f%n",
                    locacao.getValorTotal()
                );

                System.out.println("----------------------------------------");
            }
        }

        System.out.println("Quantidade de locacoes encerradas: " + quantidade);

        System.out.printf(
            "Faturamento total: R$ %.2f%n",
            total
        );

        System.out.println("========================================");
    }
}