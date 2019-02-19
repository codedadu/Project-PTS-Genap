package ind.std.codedadu.pts.snackbar;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ind.std.codedadu.pts.MaidClass;
import ind.std.codedadu.pts.MainActivity;
import ind.std.codedadu.pts.R;
import ind.std.codedadu.pts.toast.ActivityToast;

public class SnackbarActivity extends AppCompatActivity {

    MaidClass maidClass = new MaidClass();

    Button bt_snackbarBasic, bt_backto_list;

    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar);

        bt_snackbarBasic = (Button)findViewById(R.id.btn_basic_snackbar);
        coordinatorLayout = (CoordinatorLayout)findViewById(R.id.lay_coordinator);
        bt_backto_list = (Button)findViewById(R.id.btn_backtolist_snbar);

        bt_snackbarBasic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maidClass.snackbarBasic(coordinatorLayout);
            }
        });

        bt_backto_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SnackbarActivity.this, MainActivity.class));
                finish();
            }
        });
    }

    public void snackbarwithAction(View view) {
        maidClass.snackbarwithAction(SnackbarActivity.this, coordinatorLayout, "https://www.facebook.com/septiyadii/");
    }
}
