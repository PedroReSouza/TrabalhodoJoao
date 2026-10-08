package Locacao;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Locacao {

    private Cliente cliente;
    private Veiculo veiculo;

    private LocalDate dataRetirada;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoReal;

    private double valorTotal;
    private StatusLocacao status;

    public Locacao(
            Cliente cliente,
            Veiculo veiculo,
            LocalDate dataRetirada,
            LocalDate dataDevolucaoPrevista) {

        if (cliente == null) {
            throw new IllegalArgumentException(
                "O cliente nao pode ser nulo."
            );
        }

        if (veiculo == null) {
            throw new IllegalArgumentException(
                "O veiculo nao pode ser nulo."
            );
        }

        if (dataRetirada == null || dataDevolucaoPrevista == null) {
            throw new IllegalArgumentException(
                "As datas nao podem ser nulas."
            );
        }

        if (dataDevolucaoPrevista.isBefore(dataRetirada)) {
            throw new IllegalArgumentException(
                "A data de devolucao prevista nao pode ser anterior a retirada."
            );
        }

        if (!veiculo.isDisponivel()) {
            throw new IllegalStateException(
                "O veiculo ja esta ocupado."
            );
        }

        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataRetirada = dataRetirada;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.dataDevolucaoReal = null;
        this.valorTotal = 0.0;
        this.status = StatusLocacao.ABERTA;

        // O veiculo fica indisponivel enquanto estiver alugado.
        veiculo.setDisponivel(false);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public LocalDate getDataRetirada() {
        return dataRetirada;
    }

    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public LocalDate getDataDevolucaoReal() {
        return dataDevolucaoReal;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public StatusLocacao getStatus() {
        return status;
    }

    public long calcularDiasPrevistos() {
        long dias = ChronoUnit.DAYS.between(
            dataRetirada,
            dataDevolucaoPrevista
        );

        return Math.max(1, dias);
    }

    public long calcularDiasReais() {

        if (dataDevolucaoReal == null) {
            return calcularDiasPrevistos();
        }

        long dias = ChronoUnit.DAYS.between(
            dataRetirada,
            dataDevolucaoReal
        );

        return Math.max(1, dias);
    }

    public double calcularValorEstimado() {

        long dias = calcularDiasPrevistos();

        double diaria = veiculo.calcularDiaria();
        double seguro = veiculo.calcularSeguro();

        return (diaria + seguro) * dias;
    }

    public void encerrar(LocalDate dataDevolucaoReal) {

        if (status == StatusLocacao.ENCERRADA) {
            throw new IllegalStateException(
                "A locacao ja esta encerrada."
            );
        }

        if (dataDevolucaoReal == null) {
            throw new IllegalArgumentException(
                "A data de devolucao nao pode ser nula."
            );
        }

        if (dataDevolucaoReal.isBefore(dataRetirada)) {
            throw new IllegalArgumentException(
                "A devolucao nao pode ser anterior a retirada."
            );
        }

        this.dataDevolucaoReal = dataDevolucaoReal;

        long dias = calcularDiasReais();

        double diaria = veiculo.calcularDiaria();
        double seguro = veiculo.calcularSeguro();

        this.valorTotal = (diaria + seguro) * dias;

        this.status = StatusLocacao.ENCERRADA;

        // O veiculo volta a ficar disponivel.
        veiculo.setDisponivel(true);
    }

    public void exibirDados() {

        System.out.println("================================");
        System.out.println("CLIENTE: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());

        System.out.println("VEICULO: " + veiculo.getModelo());
        System.out.println("PLACA: " + veiculo.getPlaca());

        System.out.println("DATA RETIRADA: " + dataRetirada);
        System.out.println(
            "DEVOLUCAO PREVISTA: " + dataDevolucaoPrevista
        );

        System.out.println(
            "DEVOLUCAO REAL: " +
            (dataDevolucaoReal == null
                ? "Ainda nao devolvido"
                : dataDevolucaoReal)
        );

        System.out.println("STATUS: " + status);

        System.out.println(
            "DIAS PREVISTOS: " + calcularDiasPrevistos()
        );

        if (status == StatusLocacao.ENCERRADA) {
            System.out.println(
                "DIAS REAIS: " + calcularDiasReais()
            );
        }

        System.out.printf(
            "DIARIA: R$ %.2f%n",
            veiculo.calcularDiaria()
        );

        System.out.printf(
            "SEGURO: R$ %.2f%n",
            veiculo.calcularSeguro()
        );

        if (status == StatusLocacao.ABERTA) {

            System.out.printf(
                "VALOR ESTIMADO: R$ %.2f%n",
                calcularValorEstimado()
            );

        } else {

            System.out.printf(
                "VALOR TOTAL: R$ %.2f%n",
                valorTotal
            );
        }

        System.out.println("================================");
    }
}
```
