package ind.std.codedadu.pts;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomListMenu extends ArrayAdapter<String> {

    private final Activity contex;

    private final String[] namaMenu;
    private final String[] fungsiMenu;

    public CustomListMenu(Activity contex, String[] namaMenu, String[] fungsiMenu) {
        super(contex, R.layout.item_menu, namaMenu);
        this.contex = contex;
        this.namaMenu = namaMenu;
        this.fungsiMenu = fungsiMenu;
    }

    public View getView(int posisi, View view, ViewGroup parent) {
        LayoutInflater inflater = contex.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.item_menu, null, true);

        TextView nama_menu = (TextView)rowView.findViewById(R.id.txt_namamenu);
        TextView func_menu = (TextView)rowView.findViewById(R.id.txt_funcmenu);

        nama_menu.setText(namaMenu[posisi]);
        func_menu.setText(fungsiMenu[posisi]);

        return rowView;
    }
}
