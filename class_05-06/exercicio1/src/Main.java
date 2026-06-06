import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static void main(String[] args) {
        Produto notebook = new Produto("Notebook", 3500.00, 1800);
        Produto teclado = new Produto("Teclado", 180.00, 700);
        Produto mouse = new Produto("Mouse", 90.00, 200);
        Produto monitor = new Produto("Monitor", 1200.00, 3200);

        KitPromocional kitHomeOffice = new KitPromocional("Kit Home Office", 10.0);
        kitHomeOffice.adicionarProduto(notebook);
        kitHomeOffice.adicionarProduto(teclado);
        kitHomeOffice.adicionarProduto(mouse);

        CarrinhoCompra carrinho = new CarrinhoCompra();
        carrinho.adicionarItem(monitor);

        KitPromocional kitEscritorioCompleto = new KitPromocional("Kit Escritório Completo", 5.0);

        kitEscritorioCompleto.adicionarProduto(kitHomeOffice);

        kitEscritorioCompleto.adicionarProduto(monitor);

        CarrinhoCompra carrinho2 = new CarrinhoCompra();

        carrinho2.adicionarItem(kitEscritorioCompleto);

        System.out.println("Itens do carrinho:");
        System.out.println(carrinho2.getDescricao());

        System.out.printf("%nPreço total: R$ %.2f%n", carrinho2.calcularPrecoTotal());
        System.out.printf("Peso total: %.0f g%n", carrinho2.calcularPesoTotal());

        /*
         * Novo requisito:
         *
         * A loja agora quer criar um "Kit Escritório Completo" contendo:
         * - o Kit Home Office;
         * - o Monitor.
         *
         * A implementação atual não permite isso diretamente, pois KitPromocional
         * armazena apenas Produto. Para resolver corretamente, refatore o projeto
         * aplicando o padrão Composite.
         */
    }
}

interface ItemCarrinho {
    double getPesoGramas();
    double getPreco();
    String getDescricao();
}

class Produto implements ItemCarrinho {
    private final String nome;
    private final double preco;
    private final double pesoGramas;

    public Produto(String nome, double preco, double pesoGramas) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do produto não pode ser vazio.");
        }
        if (preco < 0) {
            throw new IllegalArgumentException("O preço não pode ser negativo.");
        }
        if (pesoGramas < 0) {
            throw new IllegalArgumentException("O peso não pode ser negativo.");
        }

        this.nome = nome;
        this.preco = preco;
        this.pesoGramas = pesoGramas;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public double getPesoGramas() {
        return pesoGramas;
    }

    public String getDescricao() {
        return nome + " - R$ " + String.format("%.2f", preco);
    }
}

class KitPromocional implements ItemCarrinho {
    private final List<ItemCarrinho> produtos = new ArrayList<>();
    private final String nome;
    private final double percentualDesconto;

    public KitPromocional(String nome, double percentualDesconto) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do kit não pode ser vazio.");
        }
        if (percentualDesconto < 0 || percentualDesconto > 100) {
            throw new IllegalArgumentException("O desconto deve estar entre 0 e 100.");
        }

        this.nome = nome;
        this.percentualDesconto = percentualDesconto;
    }

    public String getNome() {
        return nome;
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    public void adicionarProduto(ItemCarrinho produto) {
        if (produto == null) {
            throw new IllegalArgumentException("O produto não pode ser nulo.");
        }

        produtos.add(produto);
    }

    public List<ItemCarrinho> getProdutos() {
        return Collections.unmodifiableList(produtos);
    }

    public double calcularPreco() {
        double total = 0.0;

        for (ItemCarrinho produto : produtos) {
            total += produto.getPreco();
        }

        return total * (1.0 - percentualDesconto / 100.0);
    }

    public double calcularPesoGramas() {
        double total = 0.0;

        for (ItemCarrinho produto : produtos) {
            total += produto.getPesoGramas();
        }

        return total;
    }

    public String getDescricao() {
        StringBuilder descricao = new StringBuilder();

        descricao.append(nome)
                .append(" (")
                .append(String.format("%.1f", percentualDesconto))
                .append("% de desconto)")
                .append(System.lineSeparator());

        for (ItemCarrinho produto : produtos) {
            descricao.append(" - ")
                    .append(produto.getDescricao())
                    .append(System.lineSeparator());
        }

        return descricao.toString();
    }

    public double getPesoGramas() {
        double peso = 0.0;
        for (ItemCarrinho item : produtos) {
            peso += item.getPesoGramas();
        }
        return peso;
    }
    public double getPreco() {
        double preco = 0.0;
        for (ItemCarrinho item : produtos) {
            preco += item.getPreco();
        }
        return preco;
    }

}

class CarrinhoCompra {
    private final List<ItemCarrinho> produtos = new ArrayList<>();

    public void adicionarItem(ItemCarrinho produto) {
        if (produto == null) {
            throw new IllegalArgumentException("O produto não pode ser nulo.");
        }

        produtos.add(produto);
    }

    public double calcularPrecoTotal() {
        double total = 0.0;

        for (ItemCarrinho produto : produtos) {
            total += produto.getPreco();
        }

        return total;
    }

    public double calcularPesoTotal() {
        double total = 0.0;

        for (ItemCarrinho produto : produtos) {
            total += produto.getPesoGramas();
        }

        return total;
    }

    public String getDescricao() {
        StringBuilder descricao = new StringBuilder();

        for (ItemCarrinho produto : produtos) {
            descricao.append(produto.getDescricao())
                    .append(System.lineSeparator());
        }

        return descricao.toString();
    }
}
