package sg.edu.rp.c346.id20019018.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement;
    EditText etIndexElement;
    Button btnAdd;
    Button btnRem;
    Button btnUpd;
    ListView lvColour;
    ArrayList<String> alColours;
    ArrayAdapter<String> aaColour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        etIndexElement = findViewById(R.id.editTextIndex);
        btnAdd = findViewById(R.id.buttonAddColour);
        btnRem = findViewById(R.id.buttonRemoveColour);
        btnUpd = findViewById(R.id.buttonUpdateColour);
        lvColour = findViewById(R.id.listViewColour);

        alColours = new ArrayList<>();

        alColours.add("Red");
        alColours.add("Orange");

        aaColour = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,alColours);

        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour = etElement.getText().toString();
                //alColours.add(colour);
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                pos += -1;
                if(pos > alColours.size())
                {
                    alColours.add(colour);
                }
                else if(pos < 0)
                {
                    alColours.add(0,colour);
                }
                else
                {
                    alColours.add(pos, colour);
                }
                aaColour.notifyDataSetChanged();
            }
        });
        btnRem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                pos += -1;
                if(alColours.size() == 0)
                {
                    Toast.makeText(MainActivity.this, "There are no more colours", Toast.LENGTH_SHORT).show();
                }
                else if(pos >= alColours.size())
                {
                    alColours.remove(alColours.size()-1);
                }
                else
                {
                    alColours.remove(pos);
                }
                aaColour.notifyDataSetChanged();
            }
        });
        btnUpd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour = etElement.getText().toString();
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                pos += pos -1;
                if(alColours.size() == 0)
                {
                    Toast.makeText(MainActivity.this, "There are no more colours", Toast.LENGTH_SHORT).show();
                }
                else if(pos > alColours.size())
                {
                    alColours.set(alColours.size()-1,colour);
                }
                else
                {
                    alColours.set(pos,colour);
                }
                aaColour.notifyDataSetChanged();
            }
        });
        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Colour  = alColours.get(position);

                Toast.makeText(MainActivity.this, Colour + " was selected", Toast.LENGTH_SHORT).show();
            }
        });
    }
}