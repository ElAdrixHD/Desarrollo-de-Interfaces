package es.adrianmmudarra.inventory.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.ArrayList;

import es.adrianmmudarra.inventory.R;
import es.adrianmmudarra.inventory.data.model.Dependency;
import es.adrianmmudarra.inventory.data.repository.DependencyRepository;

public class DependencyAdapter extends RecyclerView.Adapter<DependencyAdapter.DependencyViewHolder> {

    private ArrayList<Dependency> list;
    private onManageDependencyListener listener;

    public DependencyAdapter() {
        list = DependencyRepository.getInstance().getDependencies();
    }

    @NonNull
    @Override
    public DependencyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dependency_item, parent,false);
        return new DependencyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DependencyViewHolder holder, int position) {
        holder.name.setText(list.get(position).getName());
        holder.description.setText(list.get(position).getDescription());
        holder.icon.setLetter(list.get(position).getUriImage());

        holder.bind(list.get(position),listener);
    }

    public void setOnManageDependencyListener(onManageDependencyListener listener){
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class DependencyViewHolder extends RecyclerView.ViewHolder{
        MaterialLetterIcon icon;
        TextView name, description;

        DependencyViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.iconItem);
            name = itemView.findViewById(R.id.tvName);
            description = itemView.findViewById(R.id.tvDescription);
        }


        public void bind(final Dependency dependency, final onManageDependencyListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onEditDependencyListener(dependency);
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listener.onDeleteDependencyListener(dependency);
                    return true;
                }
            });
        }
    }

    public interface onManageDependencyListener{
        void onEditDependencyListener(Dependency dependency);
        void onDeleteDependencyListener(Dependency d);
    }
}
