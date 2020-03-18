package com.example.basedemo.recy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.basedemo.R;
import com.example.basedemo.model.Account;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ManRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private Context context;
    private ManRecycleAdapter adapter;
    private List<Account> accounts;
    private int type;//是否是头 足 中
    private boolean hasHead, hasFoot;

    public ManRecycleAdapter(Context context, List<Account> accounts)
    {
        this.context = context;
        this.accounts = accounts;
    }

    @Override
    public int getItemViewType(int position)
    {
        if (position == 0)
        {
            return 1;
        } else if (position == accounts.size() + 2)//加上第一个和最后一个
        {
            return -1;
        }
        return super.getItemViewType(position);
    }

    @Override
    public long getItemId(int position)
    {
        return super.getItemId(position - 1);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = View.inflate(context, R.layout.recycler_item, null);
        RecyclerView.ViewHolder viewHolder = null;
        if (viewType == 1)
        {
            viewHolder = new FirstHolder(view);

        } else if (viewType == -1)
        {
            viewHolder = new LastHolder(view);
        } else
            viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
    {
        if (position == 0 && holder instanceof FirstHolder)
        {
            hasHead = true;
        } else if (position == accounts.size() + 1 && holder instanceof LastHolder)
        {
            hasFoot = true;

        } else
        {
            adapter.onBindViewHolder(holder, position - 1);
            ((MyViewHolder) holder).name.setText(accounts.get(position).getName());
            ((MyViewHolder) holder).age.setText(accounts.get(position).getAge() + "");
        }
    }

    @Override
    public int getItemCount()
    {
        return accounts.size() + 2;
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView name, age;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            name = itemView.findViewById(R.id.item_name);
            age = itemView.findViewById(R.id.item_age);
        }
    }

    class FirstHolder extends RecyclerView.ViewHolder
    {
        public TextView name, age;

        public FirstHolder(@NonNull View itemView)
        {
            super(itemView);
            name = itemView.findViewById(R.id.item_name);
            name.setText("asss");
            age = itemView.findViewById(R.id.item_age);
            age.setVisibility(View.GONE);
        }
    }

    class LastHolder extends RecyclerView.ViewHolder
    {
        public TextView name, age;

        public LastHolder(@NonNull View itemView)
        {
            super(itemView);
            name = itemView.findViewById(R.id.item_name);
            name.setText("asss-111");
            age = itemView.findViewById(R.id.item_age);
            age.setVisibility(View.GONE);
        }
    }
}
