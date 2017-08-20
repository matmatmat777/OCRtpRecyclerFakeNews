package com.example.mathieu.openclassroomexorecyclerview;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;
import com.oc.rss.fake.FakeNews;



import java.util.List;

/**
 * Created by mathieu on 20/08/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.FakeNewsViewHolder> {
    private final List<FakeNews> _list;

    public MyAdapter(List<FakeNews> list) {
        _list = list;
    }

    @Override
    public int getItemCount() {
        return _list.size();
    }

    @Override
    public FakeNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_cell, parent, false);
        return new FakeNewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FakeNewsViewHolder holder, int position) {
        holder.bind(_list.get(position));
    }

    public static class FakeNewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView _title;
        private FakeNews _news;

        public FakeNewsViewHolder(View itemView) {
            super(itemView);

            _title = ((TextView) itemView.findViewById(R.id.title));

            itemView.setOnClickListener(this);
        }

        public void bind(FakeNews news) {
            _news = news;
            _title.setText(news.title);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), ReadNewsActivity.class);
            intent.putExtra(ReadNewsActivity.ARTICLE_TITLE, _news.title);
            intent.putExtra(ReadNewsActivity.ARTICLE_HTML_CONTENT, _news.htmlContent);
            view.getContext().startActivity(intent);
        }
    }

}
