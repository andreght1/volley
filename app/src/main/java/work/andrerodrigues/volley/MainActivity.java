package work.andrerodrigues.volley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private AdAdapter mAdAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Ad> ads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // RecyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(true);

        // Set Adapter
        ads = AdService.getAds(this);
        mAdAdapter = new AdAdapter(this, ads, onClickAd());
        mRecyclerView.setAdapter(mAdAdapter);
    }

    private AdAdapter.AdOnClickListener onClickAd() {
        return new AdAdapter.AdOnClickListener() {
            @Override
            public void onClickAd(View view, int idx) {
                Ad a = ads.get(idx);
                Toast.makeText(getApplicationContext(), "Anúncio: " + a.getName(), Toast.LENGTH_SHORT).show();
            }
        };
    };
}