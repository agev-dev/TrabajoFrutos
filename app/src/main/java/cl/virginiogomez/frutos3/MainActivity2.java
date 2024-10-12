package cl.virginiogomez.frutos3;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsCompat.Type;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    Button btListar;
    TextView tvListar;
    SensorManager smr;


    protected void onCreopvgate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);


        btListar = findViewById(R.id.btListar);
        tvListar = findViewById(R.id.tvListar);
        smr = (SensorManager) getSystemService(Context.SENSOR_SERVICE);


        btListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Sensor> sensorList = smr.getSensorList(Sensor.TYPE_GYROSCOPE);
                StringBuilder stringBuilder = new StringBuilder();

                if (sensorList != null && !sensorList.isEmpty()) {
                    for (Sensor s : sensorList) {
                        stringBuilder.append(s.getName()).append("\n");
                    }
                } else {
                    stringBuilder.append("Giroscopio no disponible.");
                }

                tvListar.setText(stringBuilder.toString());
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}