package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/*public class SearchActivity extends AppCompatActivity {
    TextView name;
    ListView listView;
    Button btnProducts;
    private AppDatabase appDatabase;
    private ProductDao productDao;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList=new ArrayList<String>();
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        name=findViewById(R.id.product_input_search);
        listView=findViewById(R.id.list_view_container_search);
        btnProducts=findViewById(R.id.product_button_search);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Check User...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setProgress(0);

        btnProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!emptyValidation()) {
                    progressDialog.show();
                    adapter.clear();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ProductDao products = AppDatabase.getInstance(this).productDao();

                            if (products.size()> 0) {
                                // Toast.makeText(ImageActivity.this, "IMAAA", Toast.LENGTH_SHORT).show();
                                for (int i=0; i<products.size(); i++) {
                                    arrayList.add("Ime: "+products.get(i).getTitle().toString());
                                    adapter.notifyDataSetChanged();
                                }
                            } else {
                                Toast.makeText(SearchActivity.this, "No users, or incorrect", Toast.LENGTH_SHORT).show();
                            }
                            progressDialog.dismiss();
                        }
                    }, 1000);

                } else {
                    Toast.makeText(SearchActivity.this, "Empty Fields", Toast.LENGTH_SHORT).show();
                }

            }
        });


        }

    private boolean emptyValidation() {
        if (TextUtils.isEmpty(name.getText().toString())) {
            return true;
        } else {
            return false;
        }

    }
}*/
