package com.example.ls.myvideoview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import com.example.ls.myvideoview.util.DisplayUtils;
import com.shizhefei.guide.GuideHelper;

import static android.view.Gravity.BOTTOM;

public class Main2Activity extends Activity {

    private View iconView;
    private View cityView;
    private View infoLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        iconView = findViewById(R.id.iv_icon);
        cityView = findViewById(R.id.citys);
        infoLayout = findViewById(R.id.infoLayout);

      View  button = findViewById(R.id.button1);
      button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              final GuideHelper guideHelper = new GuideHelper(Main2Activity.this);

              View test =guideHelper.inflate(R.layout.custom_view_show);
              GuideHelper.TipData tipData = new GuideHelper.TipData(test,Gravity.CENTER);
              guideHelper.addPage(tipData);
//              guideHelper.addPage(new GuideHelper.TipData(test, Gravity.CENTER));

              GuideHelper.TipData tipData1 = new GuideHelper.TipData(R.drawable.tip1,Gravity.RIGHT|BOTTOM,iconView);
              tipData1.setLocation(0,-DisplayUtils.dipToPix(view.getContext(),50));
              guideHelper.addPage(tipData1);

              GuideHelper.TipData tipData2 = new GuideHelper.TipData(R.drawable.tip2,cityView);
              guideHelper.addPage(tipData2);

              GuideHelper.TipData tipData3 = new GuideHelper.TipData(R.drawable.tip3,infoLayout);
              GuideHelper.TipData tipData4 = new GuideHelper.TipData(R.drawable.next,Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL);
              tipData4.setLocation(0,-DisplayUtils.dipToPix(view.getContext(),100));
              tipData4.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      guideHelper.nextPage();
                  }
              });
              guideHelper.addPage(false,tipData3,tipData4);
               guideHelper.addPage(tipData1,tipData2,tipData3);

              View closeView= guideHelper.inflate(R.layout.custom_view_with_close);
              closeView.findViewById(R.id.guide_close).setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      guideHelper.dismiss();
                  }
              });

              GuideHelper.TipData tipDataClose = new GuideHelper.TipData(closeView,Gravity.CENTER);
              guideHelper.addPage(false,tipDataClose);

              guideHelper.show(false);

          }
      });
    }
}
