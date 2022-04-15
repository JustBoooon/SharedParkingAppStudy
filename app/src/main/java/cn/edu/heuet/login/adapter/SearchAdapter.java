package cn.edu.heuet.login.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import cn.edu.heuet.login.R;
import cn.edu.heuet.login.activity.NewsDetailActivity;
import cn.edu.heuet.login.bean.Shared;

/**
 * 适配器，布局管理
 * 继承于RecyclerView里的Adapter
 * 类里给了一个泛型<SearchAdapter.MyViewHolder>
 */
public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder> {
    private List<Shared> sharedList;

    /**
     * 构造方法，接收数据
     *
     * @param sharedList 新闻列表
     */
    public SearchAdapter(List<Shared> sharedList) {
        this.sharedList = sharedList;
    }

    /**
     * 填充布局
     *
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //获取子布局
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search, parent, false);
        //子布局做参传入new MyViewHolder()
        return new MyViewHolder(view);
    }
    /**
     * 作为泛型
     */
    static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        ImageView ivPicture;

        // 被new后，通过构造器，接收onCreateViewHolder传进来的view布局文件，对子布局初始化
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            ivPicture = itemView.findViewById(R.id.iv_picture);
        }
    }

    /**
     * 传入MyViewHolder，并在该方法里赋值
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Shared shared = sharedList.get(position);

        String community = shared.getCommunity();
        String picture = shared.getLocation();
        // 设置 Title 、 Picture
        holder.tvTitle.setText(community);

        //Glide填充图片
        Glide.with(holder.itemView.getContext())
                .load(picture)
                .into(holder.ivPicture);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), NewsDetailActivity.class);
                intent.putExtra("news", shared);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sharedList.size();
    }
}
