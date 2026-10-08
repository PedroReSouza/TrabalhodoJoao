package Cliente;

import java.util.ArrayList;

import model.Cliente;

public class ClienteService {

    private ArrayList<Cliente> clientes;

    public ClienteService() {
        clientes = new ArrayList<>();
    }

    // CADASTRAR CLIENTE


    public void cadastrarCliente(Cliente cliente) {

        if (cliente == null) {
            throw new IllegalArgumentException(
                "O cliente nao pode ser nulo."
            );
        }

        if (buscarPorCpf(cliente.getCpf()) != null) {
            throw new IllegalArgumentException(
                "Ja existe um cliente cadastrado com esse CPF."
            );
        }

        clientes.add(cliente);
    }

    // BUSCAR CLIENTE PELO CPF


    public Cliente buscarPorCpf(String cpf) {

        for (Cliente cliente : clientes) {

            if (cliente.getCpf().equalsIgnoreCase(cpf)) {
                return cliente;
            }
        }

        return null;
    }

    // LISTAR CLIENTES

    public void listarClientes() {

        if (clientes.isEmpty()) {
            System.out.println(
                "Nenhum cliente cadastrado."
            );
            return;
        }

        System.out.println(
            "========== CLIENTES =========="
        );

        for (Cliente cliente : clientes) {

            cliente.exibirDados();

            System.out.println(
                "------------------------------"
            );
        }
    }

    // GETTER

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
}
```
