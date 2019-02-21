package ind.std.codedadu.pts.intentexplicit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import ind.std.codedadu.pts.MaidClass;
import ind.std.codedadu.pts.MainActivity;
import ind.std.codedadu.pts.R;

public class ExplicitIntentActivity extends AppCompatActivity {

    @BindView(R.id.edt_singleMessage)
    EditText edtSingleMessage;
    @BindView(R.id.edt_put1)
    EditText edtPut1;
    @BindView(R.id.edt_put2)
    EditText edtPut2;
    @BindView(R.id.edt_put3)
    EditText edtPut3;
    @BindView(R.id.edt_put4)
    EditText edtPut4;

    MaidClass maidClass = new MaidClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent);
        ButterKnife.bind(this);

    }

    public void gotoOtherActivity(View view) {
        Intent intentgotoToast = new Intent(ExplicitIntentActivity.this, OtherActivity.class);
        startActivity(intentgotoToast);
        finish();
    }

    public void backtoList(View view) {
        startActivity(new Intent(ExplicitIntentActivity.this, MainActivity.class));
        finish();
    }

    public void act_SendPutExtras(View view) {
        if (isEmpty(edtPut1)) {
            maidClass.set_EditTextError(edtPut1, "Input 1 is Empty!");
            edtPut1.setFocusable(true);
        } else if (isEmpty(edtPut2)) {
            maidClass.set_EditTextError(edtPut2, "Input 2 is Empty!");
            edtPut2.setFocusable(true);
        } else if (isEmpty(edtPut3)) {
            maidClass.set_EditTextError(edtPut3, "Input 3 is Empty!");
            edtPut3.setFocusable(true);
        } else if (isEmpty(edtPut4)) {
            maidClass.set_EditTextError(edtPut4, "Input 4 is Empty!");
            edtPut4.setFocusable(true);
        } else {
            String _getdt1 = edtPut1.getText().toString().trim();
            int _getdt2 = Integer.parseInt(edtPut2.getText().toString().trim());
            float _getdt3 = Float.parseFloat(edtPut3.getText().toString().trim());
            double _getdt4 = Double.parseDouble(edtPut4.getText().toString().trim());

            intentPutExtras(_getdt1, _getdt2, _getdt3, _getdt4);
        }
    }

    public void act_SendPutExtra(View view) {
        if (isEmpty(edtSingleMessage)) {
            maidClass.set_EditTextError(edtSingleMessage, "Input is Empty!");
            edtSingleMessage.setFocusable(true);
        } else {
            String _puttextData = edtSingleMessage.getText().toString().trim();
            Intent kirimData = new Intent(ExplicitIntentActivity.this, OtherActivity.class);
            kirimData.putExtra("SINGLE_DATA", _puttextData);
            startActivity(kirimData);
        }
    }

    // Method
    static boolean isEmpty(EditText editText) {
        String input = editText.getText().toString().trim();
        return input.length() == 0;
    }

    void intentPutExtras(String inpt1, int inpt2, float inpt3, double inpt4) {
        Bundle setPackage = new Bundle();
        setPackage.putString("PT_1", inpt1);
        setPackage.putInt("PT_2", inpt2);
        setPackage.putFloat("PT_3", inpt3);
        setPackage.putDouble("PT_4", inpt4);

        Intent sendPackage = new Intent(ExplicitIntentActivity.this, OtherActivity.class);
        sendPackage.putExtras(setPackage);
        startActivity(sendPackage);
    }
}
