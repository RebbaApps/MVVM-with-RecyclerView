package com.mvvm_with_recyclerview.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.mvvm_with_recyclerview.R;
import com.mvvm_with_recyclerview.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    Context context;
    List<User> usersList = new ArrayList<>();
    public UserAdapter(MainActivity mainActivity, List<User> users) {
        this.context = mainActivity;
        this.usersList = users;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_card,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        holder.userId.setText("ID : " + usersList.get(position).getId()+"");
        holder.userName.setText("Name : " + usersList.get(position).getName());
        holder.userEmail.setText("Email : " + usersList.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        if(usersList != null)
        {
            return usersList.size();
        }
        else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView userId;
        TextView userName;
        TextView userEmail;
        ConstraintLayout cl_constraint_layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userId = itemView.findViewById(R.id.tv_user_id);
            userName = itemView.findViewById(R.id.tv_user_name);
            userEmail = itemView.findViewById(R.id.tv_user_email);
            cl_constraint_layout = itemView.findViewById(R.id.cl_constraint_layout);

            cl_constraint_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String message = "User Id : "+usersList.get(getLayoutPosition()).getId()+" \n"+
                            "User Name : "+usersList.get(getLayoutPosition()).getName()+" \n" +
                            "User Email : "+usersList.get(getLayoutPosition()).getEmail();
                    Toast.makeText(context, message, Toast.LENGTH_LONG).show();
                }
            });


        }
    }
}
