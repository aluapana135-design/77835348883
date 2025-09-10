// A URI do arquivo APK que você quer instalar
val apkFileUri = FileProvider.getUriForFile(
    context,
    "com.MM.index.code.editor",
    File(caminhoDoAPK)
)

val installIntent = Intent(Intent.ACTION_VIEW).apply {
    setDataAndType(apkFileUri, "application/vnd.android.package-archive")
    flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
}

context.startActivity(installIntent)