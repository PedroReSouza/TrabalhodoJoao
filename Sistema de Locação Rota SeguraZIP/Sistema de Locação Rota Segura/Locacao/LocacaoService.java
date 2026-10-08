package Locacao;

import java.time.LocalDate;
import java.util.ArrayList;

import model.Cliente;
import model.Locacao;
import model.StatusLocacao;
import model.Veiculo;

public class LocacaoService {

    private ArrayList<Locacao> locacoes;

    public LocacaoService() {
        locacoes = new ArrayList<>();
    }

    public Locacao criarLocacao(
            Cliente cliente,
            Veiculo veiculo,
            LocalDate dataRetirada,
            LocalDate dataDevolucaoPrevista) {

        if (cliente == null) {
            throw new IllegalArgumentException(
                "Cliente nao encontrado."
            );
        }

        if (veiculo == null) {
            throw new IllegalArgumentException(
                "Veiculo nao encontrado."
            );
        }

        Locacao locacao = new Locacao(
            cliente,
            veiculo,
            dataRetirada,
            dataDevolucaoPrevista
        );

        locacoes.add(locacao);

        return locacao;
    }

    public Locacao buscarLocacaoAbertaPorVeiculo(Veiculo veiculo) {

        for (Locacao locacao : locacoes) {

            if (locacao.getVeiculo() == veiculo &&
                locacao.getStatus() == StatusLocacao.ABERTA) {

                return locacao;
            }
        }

        return null;
    }

    public void devolverVeiculo(
            Veiculo veiculo,
            LocalDate dataDevolucaoReal) {

        Locacao locacao =
            buscarLocacaoAbertaPorVeiculo(veiculo);

        if (locacao == null) {
            throw new IllegalArgumentException(
                "Nao existe locacao aberta para esse veiculo."
            );
        }

        locacao.encerrar(dataDevolucaoReal);

        System.out.println(
            "Veiculo devolvido e locacao encerrada com sucesso."
        );
    }

    public void listarLocacoes() {

        if (locacoes.isEmpty()) {
            System.out.println(
                "Nenhuma locacao cadastrada."
            );
            return;
        }

        System.out.println("========== LOCACOES ==========");

        for (Locacao locacao : locacoes) {

            locacao.exibirDados();

            System.out.println();
        }
    }

    public ArrayList<Locacao> getLocacoes() {
        return locacoes;
    }
}