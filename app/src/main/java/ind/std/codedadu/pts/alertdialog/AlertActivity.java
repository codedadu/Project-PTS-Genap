package ind.std.codedadu.pts.alertdialog;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ind.std.codedadu.pts.MaidClass;
import ind.std.codedadu.pts.MainActivity;
import ind.std.codedadu.pts.R;
import ind.std.codedadu.pts.toast.ActivityToast;

public class AlertActivity extends AppCompatActivity {

    MaidClass maidClass = new MaidClass();

    EditText getPut;

    Button bt_alert_withAction, bt_alert_gettext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

        getPut = (EditText)findViewById(R.id.edt_put_txt);
        bt_alert_withAction = (Button)findViewById(R.id.btn_alert_with_action);
        bt_alert_gettext = (Button)findViewById(R.id.btn_alert_with_get_put);

        bt_alert_withAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maidClass.alertdialogwithAction(AlertActivity.this);
            }
        });

        bt_alert_gettext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmpty(getPut)) {
                    maidClass.set_EditTextError(getPut, "EditText Put is Empty!");
                    getPut.setFocusable(true);
                } else {
                    String text_fromedt = getPut.getText().toString().trim();
                    maidClass.alertwithgetText(AlertActivity.this, text_fromedt);
                }

            }
        });
    }

    // Method
    static boolean isEmpty(EditText editText) {
        String input = editText.getText().toString().trim();
        return  input.length() == 0;
    }

    public void basicAlert(View view) {
        maidClass.alertdailogBasic(AlertActivity.this);
    }

    public void backtoList(View view) {
        startActivity(new Intent(AlertActivity.this, MainActivity.class));
        finish();
    }
}
