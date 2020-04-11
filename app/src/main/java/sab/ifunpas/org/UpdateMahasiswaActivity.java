package sab.ifunpas.org;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateMahasiswaActivity extends AppCompatActivity {
    EditText nrp, nama, prodi;
    Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_mahasiswa);

        nrp = (EditText) findViewById(R.id.nrpMhs);
        nama = (EditText) findViewById(R.id.namaMhs);
        prodi = (EditText) findViewById(R.id.prodi);
        update = (Button) findViewById(R.id.btnUpdate);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sNrp = nrp.getText().toString().trim();
                String sNama = nama.getText().toString().trim();
                String sProdi = prodi.getText().toString().trim();


                DatabaseHelper dbHelper = new DatabaseHelper( UpdateMahasiswaActivity.this);

                SQLiteDatabase db = dbHelper.getWritableDatabase();
                dbHelper.createMahasiswaTable(db);
                dbHelper.updateDataMahasiswa(db, sNrp, sNama, sProdi);
                Toast.makeText(UpdateMahasiswaActivity.this, "Update Data Mahasiswa Success", Toast.LENGTH_LONG).show();

                nrp.setText("");
                nama.setText("");
                prodi.setText("");

            }
        });
    }
}
