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

}
