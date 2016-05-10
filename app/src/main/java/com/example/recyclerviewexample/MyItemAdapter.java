package com.example.recyclerviewexample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recyclerviewexample.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link ItemFragment.OnListItemClickedListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemAdapter extends RecyclerView.Adapter<MyItemAdapter.ViewHolder> {

  private final List<DummyItem> values;
  private final ItemFragment.OnListItemClickedListener listener;

  public MyItemAdapter(List<DummyItem> items, ItemFragment.OnListItemClickedListener listener) {
    this.values = items;
    this.listener = listener;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.fragment_item, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, int position) {
    holder.item = values.get(position);
    holder.idView.setText(values.get(position).id);
    holder.contentView.setText(values.get(position).content);

    holder.view.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (null != listener) {
          // Notify the active callbacks interface (the activity, if the
          // fragment is attached to one) that an item has been selected.
          listener.onListItemClicked(holder.item);
        }
      }
    });
  }

  @Override
  public int getItemCount() {
    return values.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    public final View view;
    public final TextView idView;
    public final TextView contentView;
    public DummyItem item;

    public ViewHolder(View view) {
      super(view);
      this.view = view;
      idView = (TextView) view.findViewById(R.id.id);
      contentView = (TextView) view.findViewById(R.id.content);
    }

    @Override
    public String toString() {
      return super.toString() + " '" + contentView.getText() + "'";
    }
  }
}
