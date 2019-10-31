package es.adrianmmudarra.recycleruserview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import es.adrianmmudarra.recycleruserview.model.User;
import es.adrianmmudarra.recycleruserview.repository.RepositoryUser;

public class RecyclerUserAdapter extends RecyclerView.Adapter<RecyclerUserAdapter.RecyclerUserViewHolder> {

    private Context context;
    private ArrayList<User> list;

    public RecyclerUserAdapter(Context context) {
        this.context = context;
        list = RepositoryUser.getInstance().getUsers();

    }

    @NonNull
    @Override
    public RecyclerUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.recycler_view_item,parent,false);
        return new RecyclerUserViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerUserViewHolder holder, int position) {
        holder.tvUser.setText(list.get(position).getUser());
        holder.tvEmail.setText(list.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RecyclerUserViewHolder extends RecyclerView.ViewHolder{

        private TextView tvUser, tvEmail;

        public RecyclerUserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUser = itemView.findViewById(R.id.tv_item_one);
            tvEmail = itemView.findViewById(R.id.tv_item_two);
        }

    }
}
