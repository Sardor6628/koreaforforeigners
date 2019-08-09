package com.example.ibrokhimov.draft_final;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mblogList;

    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabase= FirebaseDatabase.getInstance().getReference().child("Blog");


        mblogList=(RecyclerView)findViewById(R.id.blog_list);
        mblogList.setHasFixedSize(true);
        mblogList.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<blog, BlogViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<blog, BlogViewHolder>(
                blog.class,
                R.layout.blog_raw,
                BlogViewHolder.class,
                mDatabase
        ) {
            @Override
            protected void populateViewHolder(BlogViewHolder viewHolder, blog model, int position) {
                viewHolder.setTitle(model.getTitle());
                viewHolder.setdescription(model.getDescription());
                viewHolder.setPhone(model.getContactNumber());
                viewHolder.setImage(getApplicationContext(),model.getImage());
            }
        };

      mblogList.setAdapter(firebaseRecyclerAdapter);
    }

    public static class BlogViewHolder extends RecyclerView.ViewHolder{
        View mView;
        public BlogViewHolder(View itemView) {
            super(itemView);
            mView=itemView;
        }
    public void setTitle(String title){
        TextView post_title=(TextView)mView.findViewById(R.id.post_title);
        post_title.setText(title);
    }

    public void setdescription(String desc){
        TextView post_Desc=(TextView)mView.findViewById(R.id.post_text);
        post_Desc.setText(desc);
    }
    public void setPhone(String phone){
        TextView post_Phone=(TextView)mView.findViewById(R.id.post_number);
        post_Phone.setText(phone);
    }
    public void setImage(Context ctx, String image){
        ImageView post_image=(ImageView)mView.findViewById(R.id.post_img);
        Picasso.with(ctx).load(image).into(post_image);
    }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            if(item.getItemId()==R.id.action_add) {
            } startActivity(new Intent(MainActivity.this,Post_activity.class));
        return super.onOptionsItemSelected(item);
    }
}
