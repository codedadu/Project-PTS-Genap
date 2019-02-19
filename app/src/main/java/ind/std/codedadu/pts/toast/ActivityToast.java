package ind.std.codedadu.pts.toast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ind.std.codedadu.pts.MaidClass;
import ind.std.codedadu.pts.MainActivity;
import ind.std.codedadu.pts.R;

public class ActivityToast extends AppCompatActivity {

    EditText tvInputToast;
    Button btShowInputToast;

    EditText proc_a, proc_b;
    Button btShowResultfromProc;

    MaidClass maidClass = new MaidClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        tvInputToast = (EditText)findViewById(R.id.edt_inputtoast);
        btShowInputToast = (Button)findViewById(R.id.btn_toastInput);

        btShowInputToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Statement if
                if (isEmpty(tvInputToast)) {
                    maidClass.set_EditTextError(tvInputToast, "Isi dulu inputan!");
                } else {
                    showFromInput(tvInputToast.getText().toString());
                }
            }
        });

        proc_a = (EditText)findViewById(R.id.edt_proc1);
        proc_b = (EditText)findViewById(R.id.edt_proc2);
        btShowResultfromProc = (Button)findViewById(R.id.btn_toastproces);

        btShowResultfromProc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Statement if
                if (isEmpty(proc_a)) {
                    maidClass.set_EditTextError(proc_a, "Text A is Empty!");
                    proc_a.setFocusable(true);
                } else if (isEmpty(proc_b)) {
                    maidClass.set_EditTextError(proc_b, "Text B is Empty!");
                    proc_b.setFocusable(true);
                } else {
                    showFromInput("Inputan Yang anda Masukan adalah: " +proc_a.getText().toString() + " " + proc_b.getText().toString());
                }
            }
        });
    }

    // OnClick
    public void toastBasic(View view) {
        maidClass.toast(this, "This basic toast for your Pop up.");
    }

    // Method
    void showFromInput(String get_text) {
        maidClass.toast(this, get_text);
    }

    // Method
    static boolean isEmpty(EditText editText) {
        String input = editText.getText().toString().trim();
        return  input.length() == 0;
    }

    public void backtoList(View view) {
        startActivity(new Intent(ActivityToast.this, MainActivity.class));
        finish();
    }
}
