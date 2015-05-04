package br.com.leandro.viajabessaandroid.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;

import java.util.List;

import br.com.leandro.viajabessaandroid.R;
import br.com.leandro.viajabessaandroid.model.Promotion;
import br.com.leandro.viajabessaandroid.util.StringUtil;

/**
 * Created by leandro on 5/3/15.
 */
public class PromotionAdapter extends BaseAdapter
{
    private final Activity context;
    private final List<Promotion> promotions;

    public PromotionAdapter(Activity context,  List<Promotion> promotions)
    {
        this.context = context;
        this.promotions = promotions;
    }

    @Override
    public int getCount()
    {
        return promotions.size();
    }

    @Override
    public Object getItem(int location)
    {
        return promotions.get(location);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent)
    {
        Promotion promotion = promotions.get(position);

        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_promotion, null, true);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);
        UrlImageViewHelper.setUrlDrawable(imageView, promotion.getImageurl());

        TextView txtTitle = (TextView) rowView.findViewById(R.id.txtTitle);
        txtTitle.setText(StringUtil.replacePlus(promotion.getTitle()));

        TextView txtValue = (TextView) rowView.findViewById(R.id.txtValue);
        txtValue.setText("$" + promotion.getValue());

        return rowView;
    }
}