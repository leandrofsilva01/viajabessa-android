package br.com.leandro.viajabessaandroid.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;

import br.com.leandro.viajabessaandroid.R;
import br.com.leandro.viajabessaandroid.model.Promotion;
import br.com.leandro.viajabessaandroid.util.StringUtil;

/**
 * Created by leandro on 5/3/15.
 */
public class DetailActivity extends Activity
{

    private ImageView imageView;
    private TextView txtTitle;
    private TextView txtValue;
    private TextView txtDetail;
    private Button btnBuy;
    private Promotion promotion;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        this.promotion = (Promotion) getIntent().getSerializableExtra("promotion");

        imageView = (ImageView) findViewById(R.id.imageViewDetail);
        txtTitle = (TextView) findViewById(R.id.txtTitleDetail);
        txtValue = (TextView) findViewById(R.id.txtValueDetail);
        txtDetail = (TextView) findViewById(R.id.txtDescriptionDetail);
        btnBuy = (Button) findViewById(R.id.btnBuyDetail);

        UrlImageViewHelper.setUrlDrawable(imageView, promotion.getImageurl());
        txtTitle.setText(StringUtil.replacePlus(promotion.getTitle()));
        txtValue.setText("$" + promotion.getValue());
        txtDetail.setText(StringUtil.replacePlus(promotion.getPackage_descripton()));
    }

    public void buy(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Pacote comprado com sucesso.")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
