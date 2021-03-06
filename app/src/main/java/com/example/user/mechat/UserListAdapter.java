package com.example.user.mechat;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by USER on 16-Jan-18.
 */

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UsersHolder> {
    List<User> users;
    private LayoutInflater inflater;
    private Context context;
    SharedPreferences mylocaldata;
    RecyclerView rvusers;

    public UserListAdapter(Context context, List<User> users){
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.users = users;
        mylocaldata= context.getSharedPreferences("mylocaldata", MODE_PRIVATE);
    }
    @Override
    public UserListAdapter.UsersHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_user, parent, false);
        UserListAdapter.UsersHolder holder = new UserListAdapter.UsersHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(UserListAdapter.UsersHolder holder, int position) {
        User current = users.get(position);
        holder.setData(current, position);
        holder.setListeners();
    }

    @Override
    public int getItemCount() {

        return users.size();
    }

    public class UsersHolder extends RecyclerView.ViewHolder {
        View itemView;
        TextView tvuser, tvnomor, tvemail;
        CardView thisuser;
        LinearLayout linearLayout;
        int position;
        User current;
        public UsersHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            thisuser = (CardView)itemView.findViewById(R.id.cvItemUser);
            tvuser = (TextView)itemView.findViewById(R.id.tvuser);
            tvnomor = (TextView)itemView.findViewById(R.id.tvnomor);
            tvemail = (TextView)itemView.findViewById(R.id.tvemail);
            linearLayout=(LinearLayout)itemView.findViewById(R.id.userlist);



        }
        public void setData(User current, int position) {
            tvuser.setText(current.getNama());
            tvnomor.setText(current.getTelepon());
            tvemail.setText(current.getEmail());
            String uid = mylocaldata.getString("uid","");
            this.position = position;
            this.current = current;
        }
        public void setListeners() {
            thisuser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (linearLayout.getVisibility() == View.GONE) {
                        linearLayout.setVisibility(View.VISIBLE);
                    } else {
                        linearLayout.setVisibility(View.GONE);
                    }

                }
            });

        }
    }
}
