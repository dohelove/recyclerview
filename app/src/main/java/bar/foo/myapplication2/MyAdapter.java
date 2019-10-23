package bar.foo.myapplication2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private final ItemViewListener itemViewListener;
    private List<String> mDataSet;

    public MyAdapter(List<String> dataSet, ItemViewListener itemViewListener) {
        this.mDataSet = dataSet;
        this.itemViewListener = itemViewListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.single_item, viewGroup, false);
        MyViewHolder viewHolder = new MyViewHolder(view, itemViewListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {
        viewHolder.textView.setText(mDataSet.get(i));
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView textView;
        public ItemViewListener itemViewListener;

        public MyViewHolder(@NonNull View itemView, final ItemViewListener itemViewListener) {
            super(itemView);
            this.itemViewListener = itemViewListener;
            textView = itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            itemViewListener.textViewClick(getAdapterPosition());
        }
    }

    public interface ItemViewListener {
        void textViewClick(int position);
    }
}
