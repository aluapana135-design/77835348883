import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import fi.iki.elonen.NanoHTTPD;

public class MyCodeServer extends NanoHTTPD {

    private final String rootDir;

    public MyCodeServer(String rootDir) throws IOException {
        super(8080); // O servidor rodará na porta 8080
        this.rootDir = rootDir;
        start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
    }

    @Override
    public Response serve(IHTTPSession session) {
        String uri = session.getUri();
        File file = new File(rootDir, uri);

        // Verifique se o arquivo existe
        if (!file.exists()) {
            return newFixedLengthResponse(Response.Status.NOT_FOUND, MIME_PLAINTEXT, "Arquivo não encontrado: " + uri);
        }

        // Verifique a extensão do arquivo para determinar como processá-lo
        String fileName = file.getName().toLowerCase();
        if (fileName.endsWith(".php")) {
            // Lógica para executar PHP
            // Esta é a parte que você precisaria de um interpretador PHP embutido
            // Exemplo: return executePhpScript(file);
            return newFixedLengthResponse(Response.Status.OK, MIME_HTML, "PHP script processing not implemented yet.");
        } else if (fileName.endsWith(".py")) {
            // Lógica para executar Python
            // Exemplo: return executePythonScript(file);
            return newFixedLengthResponse(Response.Status.OK, MIME_HTML, "Python script processing not implemented yet.");
        } else if (fileName.endsWith(".html") || fileName.endsWith(".css") || fileName.endsWith(".js")) {
            // Lógica para arquivos estáticos
            try {
                InputStream inputStream = new FileInputStream(file);
                String mimeType = getMimeType(fileName);
                return newFixedLengthResponse(Response.Status.OK, mimeType, inputStream, file.length());
            } catch (IOException e) {
                return newFixedLengthResponse(Response.Status.INTERNAL_ERROR, MIME_PLAINTEXT, "Erro ao ler o arquivo: " + e.getMessage());
            }
        } else {
            // Outros tipos de arquivo
            return newFixedLengthResponse(Response.Status.OK, MIME_PLAINTEXT, "Tipo de arquivo não suportado: " + fileName);
        }
    }

    private String getMimeType(String fileName) {
        if (fileName.endsWith(".css")) {
            return "text/css";
        } else if (fileName.endsWith(".js")) {
            return "application/javascript";
        } else {
            return "text/html";
        }
    }
}