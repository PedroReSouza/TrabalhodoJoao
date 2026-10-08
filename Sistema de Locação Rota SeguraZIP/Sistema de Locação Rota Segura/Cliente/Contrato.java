package Cliente;

public class Contrato implements Documento {

    @Override
    public void gerar(Locacao locacao) {

        if (locacao == null) {
            throw new IllegalArgumentException(
                "A locacao nao pode ser nula."
            );
        }

        System.out.println();
        System.out.println("========================================");
        System.out.println("           CONTRATO DE LOCACAO");
        System.out.println("========================================");

        System.out.println("CLIENTE: " + locacao.getCliente().getNome());
        System.out.println("CPF: " + locacao.getCliente().getCpf());

        System.out.println(
            "VEICULO: " + locacao.getVeiculo().getModelo()
        );

        System.out.println(
            "PLACA: " + locacao.getVeiculo().getPlaca()
        );

        System.out.println(
            "DATA DE RETIRADA: " + locacao.getDataRetirada()
        );

        System.out.println(
            "DEVOLUCAO PREVISTA: " +
            locacao.getDataDevolucaoPrevista()
        );

        System.out.printf(
            "VALOR ESTIMADO: R$ %.2f%n",
            locacao.calcularValorEstimado()
        );

        System.out.println("STATUS: " + locacao.getStatus());

        System.out.println("========================================");
    }
}