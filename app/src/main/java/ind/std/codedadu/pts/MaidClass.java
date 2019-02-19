package ind.std.codedadu.pts;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

public class MaidClass {

    public void toast(Context activity, String pesan) {
        Toast.makeText(activity, pesan, Toast.LENGTH_SHORT).show();
    }

    public void set_EditTextError(EditText editTextError, String textError) {
        editTextError.setError(textError);
    }
}
