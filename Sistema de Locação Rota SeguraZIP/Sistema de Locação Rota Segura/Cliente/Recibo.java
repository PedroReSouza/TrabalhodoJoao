package Cliente;

public class Recibo implements Documento {

    @Override
    public void gerar(Locacao locacao) {

        if (locacao == null) {
            throw new IllegalArgumentException(
                "A locacao nao pode ser nula."
            );
        }

        if (locacao.getStatus() != StatusLocacao.ENCERRADA) {
            throw new IllegalStateException(
                "O recibo so pode ser gerado apos o encerramento da locacao."
            );
        }

        System.out.println();
        System.out.println("========================================");
        System.out.println("              RECIBO");
        System.out.println("========================================");

        System.out.println(
            "CLIENTE: " + locacao.getCliente().getNome()
        );

        System.out.println(
            "CPF: " + locacao.getCliente().getCpf()
        );

        System.out.println(
            "VEICULO: " + locacao.getVeiculo().getModelo()
        );

        System.out.println(
            "PLACA: " + locacao.getVeiculo().getPlaca()
        );

        System.out.println(
            "RETIRADA: " + locacao.getDataRetirada()
        );

        System.out.println(
            "DEVOLUCAO: " + locacao.getDataDevolucaoReal()
        );

        System.out.println(
            "DIAS: " + locacao.calcularDiasReais()
        );

        System.out.printf(
            "VALOR TOTAL: R$ %.2f%n",
            locacao.getValorTotal()
        );

        System.out.println("========================================");
    }
}