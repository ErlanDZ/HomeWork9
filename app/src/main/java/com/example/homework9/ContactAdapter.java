package com.example.homework9;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    Activity activity;
    List<ContactModel>  contactModels;
    private Call call;

    public  ContactAdapter (Activity activity, List<ContactModel>contactModels){
        this.activity = activity;
        this.contactModels = contactModels;
        notifyDataSetChanged();
    }

 public  void  itemClick (Call call){
        this.call = call;
 }


    @NonNull
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new ContactAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ViewHolder holder, int position) {
        ContactModel model = contactModels.get(position);
        holder.name.setText(model.getName());
        holder.number.setText(model.getNumber());
        holder.bind(contactModels.get(position));
    }

    @Override
    public int getItemCount() {
        return contactModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name, number;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txt_name);
            number = itemView.findViewById(R.id.txt_number);
        }

        public void bind(ContactModel model) {
            itemView.setOnClickListener(v -> {
            call.itemClick(getAdapterPosition(), model);
            });
        }
    }

}
