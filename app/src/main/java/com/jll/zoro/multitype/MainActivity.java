package com.jll.zoro.multitype;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class MainActivity extends AppCompatActivity {
    private MultiTypeAdapter adapter;
    private RecyclerView recyclerView;

    /* Items 等价于 ArrayList<Object> */
    private Items items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.list);
        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(gridLayoutManager);//这里用线性显示 类似于listview
        items = new Items();
        adapter = new MultiTypeAdapter(items);

        /* 注册类型和 View 的对应关系 */
        adapter.register(Category.class, new CategoryViewProvider());
        adapter.register(Song.class, new SongViewProvider());

        /* 模拟加载数据，也可以稍后再加载，然后使用
         * adapter.notifyDataSetChanged() 刷新列表 */
        for (int i = 0; i < 20; i++) {
            items.add(new Category("Songs"));
            items.add(new Song("小艾大人", R.drawable.image, this));
            items.add(new Song("许岑", R.drawable.image, this));
        }

        recyclerView.setAdapter(adapter);
    }
}
