public class Main {
    public static void main(String[] args) {
        ProdutoEstoque notebook = new ProdutoEstoque("Notebook", 10, 3);

        PainelEstoque painel = new PainelEstoque();
        AlertaReposicao alerta = new AlertaReposicao();

        notebook.setPainelEstoque(painel);
        notebook.setAlertaReposicao(alerta);

        notebook.registrarEntrada(5);
        notebook.registrarSaida(4);
        notebook.registrarSaida(9);

        /*
         * Novo requisito:
         *
         * A loja agora quer adicionar outros comportamentos quando o estoque mudar:
         * - registrar histórico de auditoria;
         * - enviar e-mail ao gerente;
         * - atualizar um painel web em tempo real;
         * - integrar automaticamente com fornecedores.
         *
         * A implementação atual não é adequada para isso, pois ProdutoEstoque
         * precisaria ser alterada sempre que um novo comportamento fosse adicionado.
         *
         * Refatore o projeto aplicando um padrão de projeto adequado para permitir
         * que ProdutoEstoque avise objetos interessados em suas mudanças sem conhecer
         * suas classes concretas.
         */
    }
}

/**
 * Representa um produto controlado pelo módulo de estoque.
 *
 * <p>
 * Esta versão inicial possui acoplamento direto com as classes que reagem às
 * alterações de estoque. Esse acoplamento é intencional neste código inicial,
 * pois representa o problema de projeto a ser refatorado.
 * </p>
 */
class ProdutoEstoque {
    private final String nome;
    private int quantidade;
    private final int estoqueMinimo;

    private PainelEstoque painelEstoque;
    private AlertaReposicao alertaReposicao;

    /**
     * Cria um produto controlado pelo estoque.
     *
     * @param nome nome do produto.
     * @param quantidade quantidade inicial disponível.
     * @param estoqueMinimo quantidade mínima aceitável antes de reposição.
     */
    public ProdutoEstoque(String nome, int quantidade, int estoqueMinimo) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do produto não pode ser vazio.");
        }
        if (quantidade < 0) {
            throw new IllegalArgumentException("A quantidade inicial não pode ser negativa.");
        }
        if (estoqueMinimo < 0) {
            throw new IllegalArgumentException("O estoque mínimo não pode ser negativo.");
        }

        this.nome = nome;
        this.quantidade = quantidade;
        this.estoqueMinimo = estoqueMinimo;
    }

    /**
     * Define o painel de estoque que será atualizado quando a quantidade mudar.
     *
     * @param painelEstoque painel a ser atualizado.
     */
    public void setPainelEstoque(PainelEstoque painelEstoque) {
        this.painelEstoque = painelEstoque;
    }

    /**
     * Define o alerta de reposição que será verificado quando a quantidade mudar.
     *
     * @param alertaReposicao alerta a ser verificado.
     */
    public void setAlertaReposicao(AlertaReposicao alertaReposicao) {
        this.alertaReposicao = alertaReposicao;
    }

    /**
     * Registra entrada de unidades no estoque.
     *
     * @param unidades quantidade de unidades recebidas.
     */
    public void registrarEntrada(int unidades) {
        if (unidades <= 0) {
            throw new IllegalArgumentException("A entrada deve ser positiva.");
        }

        quantidade += unidades;
        notificarAlteracao();
    }

    /**
     * Registra saída de unidades do estoque.
     *
     * @param unidades quantidade de unidades retiradas.
     */
    public void registrarSaida(int unidades) {
        if (unidades <= 0) {
            throw new IllegalArgumentException("A saída deve ser positiva.");
        }
        if (unidades > quantidade) {
            throw new IllegalArgumentException("Não há estoque suficiente para a saída solicitada.");
        }

        quantidade -= unidades;
        notificarAlteracao();
    }

    /**
     * Notifica os objetos atualmente acoplados a esta classe.
     *
     * <p>
     * Este método evidencia o problema: cada novo comportamento exige uma nova
     * dependência concreta e uma nova chamada explícita.
     * </p>
     */
    private void notificarAlteracao() {
        if (painelEstoque != null) {
            painelEstoque.atualizar(this);
        }

        if (alertaReposicao != null) {
            alertaReposicao.verificar(this);
        }
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }
}

/**
 * Representa um painel operacional que exibe a quantidade atual de um produto.
 */
class PainelEstoque {
    /**
     * Atualiza a exibição do painel para o produto informado.
     *
     * @param produto produto cujo estoque foi alterado.
     */
    public void atualizar(ProdutoEstoque produto) {
        System.out.printf(
                "[PAINEL] Produto: %s | Quantidade atual: %d%n",
                produto.getNome(),
                produto.getQuantidade()
        );
    }
}

/**
 * Representa uma regra de alerta quando o produto fica abaixo do estoque mínimo.
 */
class AlertaReposicao {
    /**
     * Verifica se o produto precisa de reposição.
     *
     * @param produto produto cujo estoque foi alterado.
     */
    public void verificar(ProdutoEstoque produto) {
        if (produto.getQuantidade() < produto.getEstoqueMinimo()) {
            System.out.printf(
                    "[ALERTA] Reposição necessária para %s. Quantidade atual: %d | Mínimo: %d%n",
                    produto.getNome(),
                    produto.getQuantidade(),
                    produto.getEstoqueMinimo()
            );
        }
    }
}
