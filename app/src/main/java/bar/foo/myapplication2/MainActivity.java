package bar.foo.myapplication2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler);
        List<String> dataSet = generateDataSet(new String[] {"Kim", "Lee", "Won", "Park"});
        recyclerView.setAdapter(new MyAdapter(dataSet));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


    }


    private List<String> generateDataSet(String[] seed) {

        List<String> dataSet = new ArrayList<>();

        for(int i = 0; i < seed.length * 100; i++) {
            dataSet.add(seed[i % 4]);
        }
        return dataSet;
    }

}
