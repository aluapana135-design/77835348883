import java.io.IOException;
import java.util.Map;
import fi.iki.elonen.NanoHTTPD;

public class MyWebServer extends NanoHTTPD {

    public MyWebServer() throws IOException {
        super(8080); // O servidor vai rodar na porta 8080
        start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
        System.out.println("Servidor rodando em http://localhost:8080/");
    }

    @Override
    public Response serve(IHTTPSession session) {
        String htmlContent = "<html><body><h1>Olá, Mundo!</h1></body></html>";
        return newFixedLengthResponse(htmlContent);
    }
}