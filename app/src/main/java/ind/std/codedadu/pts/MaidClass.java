package ind.std.codedadu.pts;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MaidClass {

    public static void toast(Context activity, String pesan) {
        Toast.makeText(activity, pesan, Toast.LENGTH_SHORT).show();
    }

    public static void set_EditTextError(EditText editTextError, String textError) {
        editTextError.setError(textError);
    }

    public static void alertdailogBasic(Context context) {
        AlertDialog.Builder builderAlert = new AlertDialog.Builder(context);
        builderAlert
                .setTitle("Title: Alert Dialog Basic")
                .setMessage("Message: Ini adalah pesan dari alert dialog basic di android");
        AlertDialog buildDialog = builderAlert.create();
        buildDialog.show();
    }

    public static void alertdialogwithAction(final Context context) {
        AlertDialog.Builder builderAlert = new AlertDialog.Builder(context);
        builderAlert
                .setTitle("Title: Alert Dialog with Action")
                .setMessage("Message: Ini adalah pesan dari alert dialog dengan Action di android")

                .setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        toast(context, "Anda baru saja menekan aksi Positif Button");
                    }
                })

                .setNegativeButton("Tutup", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        toast(context, "Anda baru saja menekan aksi Negative Button");
                    }
                })

                .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        toast(context,"Anda baru saja menekan aksi Netral Button");
                    }
                });

        AlertDialog buildDialog = builderAlert.create();
        buildDialog.show();
    }

    public static void alertwithgetText(Context context, String inputan) {
        AlertDialog.Builder builderAlert = new AlertDialog.Builder(context);
        builderAlert
                    .setTitle("Title: Alert Get Text from Input")
                    .setMessage("Message: Pesan yang anda masukan pada EditText adalah: `" + inputan + "`");
        AlertDialog buildDialog = builderAlert.create();
        buildDialog.show();
    }

    public void snackbarBasic(CoordinatorLayout layout) {
        Snackbar notifySnacbar = Snackbar.make(layout, "Informasi by Snackbar", Snackbar.LENGTH_SHORT);
        notifySnacbar.show();
    }

    public void snackbarwithAction(final Context context, CoordinatorLayout layout, final String link) {
        @SuppressLint("ResourceAsColor")
        Snackbar notifySnacbar = Snackbar.make(layout, "Tampilkan Link: "+ link +" di Alert Dialog", Snackbar.LENGTH_LONG)
                .setActionTextColor(Color.WHITE)
                .setAction("View", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertwithgetText(context, "Link: " + link);
                }
            });
        notifySnacbar.show();
    }
}
