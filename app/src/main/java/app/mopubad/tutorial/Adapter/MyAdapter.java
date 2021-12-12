package app.mopubad.tutorial.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import app.mopubad.tutorial.Model.Item;
import app.mopubad.tutorial.R;
import app.mopubad.tutorial.databinding.ItemLayoutBinding;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Activity activity;
    private List<Item> itemList;

    public MyAdapter(Activity activity, List<Item> itemList) {
        this.activity = activity;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(
                LayoutInflater.from(activity).inflate(
                        R.layout.item_layout,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bindData(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    protected class MyViewHolder extends RecyclerView.ViewHolder {

        ItemLayoutBinding binding;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemLayoutBinding.bind(itemView);
        }

        private void bindData(Item item) {
            Glide.with(activity)
                    .load(item.getImage())
                    .into(binding.ivItemIcon);
            binding.tvItemName.setText(item.getName());
            binding.tvItemDescription.setText(item.getDescription());
        }
    }
}
