// Exemplo de como usar a função de instalação
// Suponha que o usuário digitou "pkg install com.whatsapp"
String comando = "pkg install com.whatsapp";

if (comando.startsWith("pkg install")) {
    String[] partes = comando.split(" ");
    if (partes.length > 1) {
        String nomeDoPacote = partes[1];
        // Chame a função para iniciar a instalação
        PackageManager.installPackage(getContext(), nomeDoPacote);
    }
}