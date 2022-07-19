import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Filme {

    @SerializedName("title")
    private String titulo;

    @SerializedName("imDbRating")
    private String avaliacao;

    @SerializedName("image")
    private String imagem;

}
