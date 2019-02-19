package ind.std.codedadu.pts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import ind.std.codedadu.pts.alertdialog.AlertActivity;
import ind.std.codedadu.pts.toast.ActivityToast;

public class MainActivity extends AppCompatActivity {

    String[] nm_menu = {
            "Toast",
            "Alert Dialog",
            "Snackbar"
    };

    String[] fn_menu = {
            "Berfungsi untuk menampilkan Pop Up Android",
            "Menampilkan Kotak dialog di Android",
            "Menampilkan info text pada bagian bawah layar android"
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
                        break;
                }
            }
        });
    }
}