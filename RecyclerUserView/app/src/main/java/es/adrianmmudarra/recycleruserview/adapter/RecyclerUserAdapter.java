package es.adrianmmudarra.recycleruserview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import es.adrianmmudarra.recycleruserview.R;
import es.adrianmmudarra.recycleruserview.model.User;
import es.adrianmmudarra.recycleruserview.repository.RepositoryUser;

public class RecyclerUserAdapter extends RecyclerView.Adapter<RecyclerUserAdapter.RecyclerUserViewHolder> {

    //private Context context;
    private ArrayList<User> list;
    private OnItemClickListener listener;
    private OnUserClickListener listener2;

    /*
        Opcion 1: Heredar View.OnClickListener
     */
    public interface OnItemClickListener extends View.OnClickListener{
        @Override
        void onClick(View v);
    }

    /*
        Opcion 2: Definir un Listener propio
     */
    public interface OnUserClickListener{
        void onClick(User user);
    }

    public RecyclerUserAdapter(OnItemClickListener listener) {
        //this.context = context;
        //this.listener = listener;
        list = RepositoryUser.getInstance().getUsers();

    }

    public void setOnUserClickListener(OnUserClickListener listener) {
        this.listener2 = listener;
    }

    @NonNull
    @Override
    public RecyclerUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item,parent,false);
        v.setOnClickListener(listener);
        return new RecyclerUserViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerUserViewHolder holder, int position) {
        holder.tvUser.setText(list.get(position).getUser());
        holder.tvEmail.setText(list.get(position).getEmail());
        if (listener2 != null){
            holder.bind(listener2,position);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public User getUser(int pos){
        return list.get(pos);
    }

    class RecyclerUserViewHolder extends RecyclerView.ViewHolder{

        private TextView tvUser, tvEmail;

        public RecyclerUserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUser = itemView.findViewById(R.id.tv_item_one);
            tvEmail = itemView.findViewById(R.id.tv_item_two);
        }

        public void bind(final OnUserClickListener onUserClickListener, final int position) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onUserClickListener.onClick(list.get(position));
                }
            });
        }
    }
}
