import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class PackageManager {

    public static void installPackage(Context context, String packageName) {
        try {
            // Tenta abrir a página do aplicativo na Google Play Store
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + packageName));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (android.content.ActivityNotFoundException e) {
            // Se a Play Store não estiver instalada, abre o navegador
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + packageName));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }
}