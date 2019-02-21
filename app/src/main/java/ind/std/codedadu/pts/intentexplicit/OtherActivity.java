package ind.std.codedadu.pts.intentexplicit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ind.std.codedadu.pts.R;

public class OtherActivity extends AppCompatActivity {

    @BindView(R.id.tv_getdata_single)
    TextView tvGetdataSingle;
    @BindView(R.id.tv_getdata_1)
    TextView tvGetdata1;
    @BindView(R.id.tv_getdata_2)
    TextView tvGetdata2;
    @BindView(R.id.tv_getdata_3)
    TextView tvGetdata3;
    @BindView(R.id.tv_getdata_4)
    TextView tvGetdata4;
    @BindView(R.id.cv_1)
    CardView cv1;
    @BindView(R.id.cv_2)
    CardView cv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        ButterKnife.bind(this);

        // Get Put Extra (Single Data) Getter
        Intent getIntentPutExtra = getIntent();
        String getDataText = getIntentPutExtra.getStringExtra("SINGLE_DATA");

        if (getDataText == "") {
            tvGetdataSingle.setText("Tidak ada data yang dikirim!, coba lagi.");
        } else {
            tvGetdataSingle.setText(getDataText);
        }

        // Get Put Extras (Multiple Data) Getter
        Bundle getIntentPutExtras = getIntent().getExtras();
        String getData1 = getIntentPutExtras.getString("PT_1");
        int getData2 = getIntent().getIntExtra("PT_2", 0);
        float getData3 = getIntent().getFloatExtra("PT_3", 0);
        double getData4 = getIntent().getDoubleExtra("PT_4", 0);

        tvGetdata1.setText(getData1);
        tvGetdata2.setText("" + getData2);
        tvGetdata3.setText("" + getData3);
        tvGetdata4.setText("" + getData4);
    }

    public void backtoList(View view) {
        startActivity(new Intent(OtherActivity.this, ExplicitIntentActivity.class));
        finish();
    }
}
