package com.example.recyclerviewexample;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v17.leanback.widget.VerticalGridView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recyclerviewexample.dummy.DummyContent;
import com.example.recyclerviewexample.dummy.DummyContent.DummyItem;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListItemClickedListener}
 * interface.
 */
public class ItemFragment extends Fragment {

  private OnListItemClickedListener listener;

  /**
   * Mandatory empty constructor for the fragment manager to instantiate the
   * fragment (e.g. upon screen orientation changes).
   */
  public ItemFragment() {
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_item_list, container, false);

    VerticalGridView verticalGridView = (VerticalGridView) view.findViewById(R.id.vertical_grid_view);
    verticalGridView.setAdapter(new MyItemAdapter(DummyContent.ITEMS, listener));
    return view;
  }

  @Override
  public void onAttach(Activity activity) {
    super.onAttach(activity);
    if (activity instanceof OnListItemClickedListener) {
      listener = (OnListItemClickedListener) activity;
    } else {
      throw new RuntimeException(activity.toString()
          + " must implement OnListItemClickedListener");
    }
  }

  @Override
  public void onDetach() {
    super.onDetach();
    listener = null;
  }

  /**
   * This interface must be implemented by activities that contain this
   * fragment to allow an interaction in this fragment to be communicated
   * to the activity and potentially other fragments contained in that
   * activity.
   * <p/>
   * See the Android Training lesson <a href=
   * "http://developer.android.com/training/basics/fragments/communicating.html"
   * >Communicating with Other Fragments</a> for more information.
   */
  public interface OnListItemClickedListener {
    void onListItemClicked(DummyItem item);
  }
}
