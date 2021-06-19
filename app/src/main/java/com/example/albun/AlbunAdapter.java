package com.example.albun;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class AlbunAdapter extends RecyclerView.Adapter<AlbunAdapter.ViewHolder> {

    private List<Albun> listaAlbunes;

    protected View.OnClickListener onClickListener;

    public AlbunAdapter(List<Albun> listaContactos) {
        this. listaAlbunes = listaContactos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.albun_item, parent, false);
        v.setOnClickListener(onClickListener);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        String name =  listaAlbunes.get(position).getNombre();
        long id =  listaAlbunes.get(position).getId();
        holder.id=id;

        holder.textViewRowName.setText(name);
        holder.textViewRowId.setText(id+"");
    }

    @Override
    public int getItemCount() {
        return listaAlbunes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        private TextView textViewRowName;
        private TextView textViewRowId;

        public long id;

        public ViewHolder(View v) {
            super(v);
            textViewRowId = (TextView) v.findViewById(R.id.id);
            textViewRowName = (TextView) v.findViewById(R.id.AlbunTextName);

        }

        @Override
        public void onClick(View view) {
            Albun contact = Albun.findById(Albun.class, id);


        }



    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}

