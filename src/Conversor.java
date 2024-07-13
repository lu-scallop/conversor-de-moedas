import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {
    public ParDeMoeda converteMoeda(String moedaBase, String moedaAlvo, double quantidade){
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/97f0d9fdc2f82641aee6a6b1/pair/"+moedaBase+"/"+moedaAlvo+"/"+quantidade);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), ParDeMoeda.class);

        } catch (Exception e) {
            throw new RuntimeException("Valor numérico inválido: " + e);
        }

    }


    public String formatarResultado(ParDeMoeda parDeMoeda, double valorEntrada) {
        return String.format("Valor %.2f [%s] corresponde a ===> %.4f [%s]", valorEntrada, parDeMoeda.base_code(),
                parDeMoeda.conversion_result(), parDeMoeda.target_code());
    }
}
