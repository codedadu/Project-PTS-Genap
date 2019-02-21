package ind.std.codedadu.pts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import ind.std.codedadu.pts.alertdialog.AlertActivity;
import ind.std.codedadu.pts.intentexplicit.ExplicitIntentActivity;
import ind.std.codedadu.pts.snackbar.SnackbarActivity;
import ind.std.codedadu.pts.toast.ActivityToast;

public class MainActivity extends AppCompatActivity {

    String[] nm_menu = {
            "Toast",
            "Alert Dialog",
            "Snackbar",
            "Intent Explicit",
            "Intent Implicit",
            "Button",
            "Floating Action Button",
            "Recycler View",
            "List View",
            "Image View",
            "Image Button",
            "CheckBox",
            "Radio Group & Button",
            "Web View",
            "ProgressBar",
            "Spinner",
            "Scroll View",
            "Text View"
    };

    String[] fn_menu = {
            "Berfungsi untuk menampilkan Pop Up Android",
            "Menampilkan Kotak dialog di Android",
            "Menampilkan info text pada bagian bawah layar android",
            "Layanan untuk berpindah activity, atau mengirim data ke activity tujuan",
            "Layanan yang sama seperti Explicit, tetapi dapat mengakses resource diluar apps",
            "Sebuah view yang dapat digunakan sebagai sebuah action, untuk klik",
            "Floating sama bisa disebut sebagai button, hanya saja penempatannya yang dinamis",
            "Dapat menampilkan setiap konten dengan tampilan list yang dinamis dan lebih ringan dengan recycler",
            "Dapat menampilkan konten dalam bentuk list yang dinamis namun tidak memiliki recycler",
            "Menampilkan konten gambar dengan Ext: PNG, JPG, JPEG dll.",
            "Menampilkan konten gambar dengan Ext: PNG, JPG, JPEG dll. namun juga memiliki fungsi action klik",
            "Berfungsi untuk menampilkan dan ditujukan untuk multiple choice",
            "Berfungsi untuk menampilkan dan ditujukan untuk single choice",
            "Berfungsi untuk menampilkan konten web di aplikasi dengan mengakses internet",
            "Berfungsi untuk membuat tampilan loading disebut progressbar",
            "Bertujuan sebagai pemilih dengan sebuah pilihan tertentu dalam drop list",
            "Dapat menampilkan konten activity dengan scroll jika konten memenuhi lebih dari ukuran activity normal",
            "Menampilkan sebuah konten text untuk kebutuhan user"
    };

    ListView lv_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomListMenu clAdapter = new CustomListMenu(this, nm_menu, fn_menu);
        lv_menu = (ListView) findViewById(R.id.listMenu);
        lv_menu.setAdapter(clAdapter);

        lv_menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Toast.makeText(MainActivity.this, fn_menu[position], Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, ActivityToast.class));
                        finish();
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, fn_menu[position], Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, AlertActivity.class));
                        finish();
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, fn_menu[position], Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, SnackbarActivity.class));
                        finish();
                        break;
                    case 3:
                        Toast.makeText(MainActivity.this, fn_menu[position], Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, ExplicitIntentActivity.class));
                        finish();
                        break;
                }
            }
        });
    }
}