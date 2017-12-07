package com.harlan.lhc.listviewitemedittext.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import com.harlan.lhc.listviewitemedittext.R;
import com.harlan.lhc.listviewitemedittext.bean.Student;

import java.util.List;



public class AddTypeAdapter extends BaseAdapter {
    List<Student> data;
    /**
     * 上下文对象
     */
    private Context mContext = null;

    /**
     * @param
     */
    public AddTypeAdapter(Context ctx, List<Student> mdata) {
       this.mContext = ctx;
        this.data=mdata;


    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    ViewHolder holder;
    @Override
    public View getView( final int mposition, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.edit_item, parent, false);
            holder = new ViewHolder();

            holder.valuse= (EditText) convertView.findViewById(R.id.name);

            convertView.setTag(holder);

        } else {// 有直接获得ViewHolder
            holder = (ViewHolder)convertView.getTag();
        }
        final Student itemObj = data.get(mposition);




        if (holder.valuse.getTag() instanceof TextWatcher) {
            holder.valuse.removeTextChangedListener((TextWatcher) holder.valuse.getTag());
        }
        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s != null && !"".equals(s.toString())) {

                    itemObj.setValuse(s.toString());
                }
            }
        };

        holder.valuse.addTextChangedListener(watcher);
        holder.valuse.setTag(watcher);
        holder.valuse.setText(itemObj.getValuse());
        return convertView;
    }
    public void addType(){
        Student secret=new Student();
        data.add(secret);
        notifyDataSetChanged();
    }

    public void deleteType(int position){
        data.remove(position);
        notifyDataSetChanged();

    }
    public List<Student> getData(){
        return data;
    }
    private class ViewHolder {

        EditText valuse;


    }


}