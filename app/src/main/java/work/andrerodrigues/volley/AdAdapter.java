package work.andrerodrigues.volley;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Andre on 07/12/2015.
 */
public class AdAdapter extends RecyclerView.Adapter<AdAdapter.AdsViewHolder> {

    protected static final String TAG = "andrerodrigues";
    private final List<Ad> ads;
    private final Context context;
    private final AdOnClickListener adOnClickListener;

    public interface AdOnClickListener {
        public void onClickAd(View view, int idx);
    }

    public AdAdapter(Context context, List<Ad> ads, AdOnClickListener adOnClickListener) {
        this.context = context;
        this.ads = ads;
        this.adOnClickListener = adOnClickListener;
    }

    @Override
    public AdsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_ad,parent,false);
        AdsViewHolder holder = new AdsViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final AdsViewHolder holder, final int position) {
        // Update View
        Ad a = ads.get(position);
        holder.name.setText(a.getName());

        // Click
        if (adOnClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    //
                    adOnClickListener.onClickAd(holder.itemView, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return this.ads != null ? ads.size() : 0;
    }

    public static class AdsViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private View itemView;
        public AdsViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            name = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
