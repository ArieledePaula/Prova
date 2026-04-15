import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Produto {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nome;
    private int codigo;
    private int preco;
    private int qtdEstoque;

    public Produto(String nome, int codigo, int preco, int qtdEstoque) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getNome() {return nome;}

    public int getCodigo() {return codigo;}

    public int getPreco() {return preco;}

    public int getQtdEstoque() {return qtdEstoque;}



    public void setNome(String nome) {this.nome = nome;}

    public void  setCodigo(int nome) {this.codigo = codigo;}

    public void setPreco(int preco) {this.preco = preco;}

    public void setQtdEstoque(int qtdEstoque) {this.qtdEstoque = qtdEstoque;}


}