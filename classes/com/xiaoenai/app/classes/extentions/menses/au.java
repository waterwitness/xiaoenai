package com.xiaoenai.app.classes.extentions.menses;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ScrollView;

class au
  implements View.OnTouchListener
{
  au(MensesSettingActivity paramMensesSettingActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      MensesSettingActivity.i(this.a).requestDisallowInterceptTouchEvent(false);
      return false;
    }
    MensesSettingActivity.i(this.a).requestDisallowInterceptTouchEvent(true);
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\menses\au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */