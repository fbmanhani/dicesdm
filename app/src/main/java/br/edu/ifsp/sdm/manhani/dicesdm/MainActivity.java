package br.edu.ifsp.sdm.manhani.dicesdm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Random random;

    private TextView resultadoTextView;
    private ImageView resultadoImageView;
    private ImageView resultado2ImageView;
    private Spinner spinner;
    private EditText numFacesEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        random = new Random(System.currentTimeMillis());

        resultadoTextView = findViewById(R.id.resultadoTextView);
        resultadoImageView = findViewById(R.id.resultadoImageView);
        resultado2ImageView = findViewById(R.id.resultado2ImageView);
        spinner = findViewById(R.id.spinner);
        numFacesEditText = findViewById(R.id.numFacesEditText);
        numFacesEditText.setHint("Campo Obrigatório...");
    }


    public void jogarDado(View view) {
        if (view.getId() == R.id.jogarDadoButton) {
            int numDices = Integer.parseInt(spinner.getSelectedItem().toString());
            String numFacesStr = numFacesEditText.getText().toString().trim();
            int numFaces = numFacesStr.equals("") ? 0 : Integer.parseInt(numFacesEditText.getText().toString());


            if (numFaces > 0) {
                if (numFaces > 6) {
                    resultado2ImageView.setVisibility(View.GONE);
                    resultadoImageView.setVisibility(View.GONE);
                } else {
                    resultadoImageView.setVisibility(View.VISIBLE);
                    if (numDices == 2) {
                        resultado2ImageView.setVisibility(View.VISIBLE);
                    } else {
                        resultado2ImageView.setVisibility(View.GONE);
                    }
                }

                for (int i = 1; i <= numDices; i++) {
                    int resultado = random.nextInt(numFaces) + 1;

                    ImageView viewGenerica = i == 1 ? resultadoImageView : resultado2ImageView;

                    switch (resultado) {
                        case 1:
                            viewGenerica.setImageResource(R.drawable.dice_1);
                            break;
                        case 2:
                            viewGenerica.setImageResource(R.drawable.dice_2);
                            break;
                        case 3:
                            viewGenerica.setImageResource(R.drawable.dice_3);
                            break;
                        case 4:
                            viewGenerica.setImageResource(R.drawable.dice_4);
                            break;
                        case 5:
                            viewGenerica.setImageResource(R.drawable.dice_5);
                            break;
                        case 6:
                            viewGenerica.setImageResource(R.drawable.dice_6);
                            break;
                        default:
                            break;
                    }
                }
            } else {
                Toast.makeText(this, "Número de faces precisa ser maior que zero", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
