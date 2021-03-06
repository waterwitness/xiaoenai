package com.sina.weibo.sdk.component.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.cmd.WbAppActivator;
import com.sina.weibo.sdk.component.WeiboSdkBrowser;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import com.sina.weibo.sdk.net.NetUtils;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.utils.ResourceManager;

public class AttentionComponentView
  extends FrameLayout
{
  private static final String ALREADY_ATTEND_EN = "Following";
  private static final String ALREADY_ATTEND_ZH_CN = "已关注";
  private static final String ALREADY_ATTEND_ZH_TW = "已關注";
  private static final String ATTEND_EN = "Follow";
  private static final String ATTEND_ZH_CN = "关注";
  private static final String ATTEND_ZH_TW = "關注";
  private static final String ATTENTION_H5 = "http://widget.weibo.com/relationship/followsdk.php";
  private static final String FRIENDSHIPS_SHOW_URL = "https://api.weibo.com/2/friendships/show.json";
  private static final String TAG = AttentionComponentView.class.getName();
  private FrameLayout flButton;
  private RequestParam mAttentionParam;
  private TextView mButton;
  private volatile boolean mIsLoadingState = false;
  private ProgressBar pbLoading;
  
  public AttentionComponentView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public AttentionComponentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public AttentionComponentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void execAttented()
  {
    Object localObject = new WidgetRequestParam(getContext());
    ((WidgetRequestParam)localObject).setUrl("http://widget.weibo.com/relationship/followsdk.php");
    ((WidgetRequestParam)localObject).setSpecifyTitle(ResourceManager.getString(getContext(), "Follow", "关注", "關注"));
    ((WidgetRequestParam)localObject).setAppKey(this.mAttentionParam.mAppKey);
    ((WidgetRequestParam)localObject).setAttentionFuid(this.mAttentionParam.mAttentionUid);
    ((WidgetRequestParam)localObject).setAuthListener(this.mAttentionParam.mAuthlistener);
    ((WidgetRequestParam)localObject).setToken(this.mAttentionParam.mAccessToken);
    ((WidgetRequestParam)localObject).setWidgetRequestCallback(new AttentionComponentView.3(this));
    localObject = ((WidgetRequestParam)localObject).createRequestParamBundle();
    Intent localIntent = new Intent(getContext(), WeiboSdkBrowser.class);
    localIntent.putExtras((Bundle)localObject);
    getContext().startActivity(localIntent);
  }
  
  private void init(Context paramContext)
  {
    StateListDrawable localStateListDrawable = ResourceManager.createStateListDrawable(paramContext, "common_button_white.9.png", "common_button_white_highlighted.9.png");
    this.flButton = new FrameLayout(paramContext);
    this.flButton.setBackgroundDrawable(localStateListDrawable);
    int i = ResourceManager.dp2px(getContext(), 6);
    int j = ResourceManager.dp2px(getContext(), 2);
    int k = ResourceManager.dp2px(getContext(), 6);
    this.flButton.setPadding(0, i, j, k);
    this.flButton.setLayoutParams(new FrameLayout.LayoutParams(ResourceManager.dp2px(getContext(), 66), -2));
    addView(this.flButton);
    this.mButton = new TextView(getContext());
    this.mButton.setIncludeFontPadding(false);
    this.mButton.setSingleLine(true);
    this.mButton.setTextSize(2, 13.0F);
    paramContext = new FrameLayout.LayoutParams(-2, -2);
    paramContext.gravity = 17;
    this.mButton.setLayoutParams(paramContext);
    this.flButton.addView(this.mButton);
    this.pbLoading = new ProgressBar(getContext(), null, 16842873);
    this.pbLoading.setVisibility(8);
    paramContext = new FrameLayout.LayoutParams(-2, -2);
    paramContext.gravity = 17;
    this.pbLoading.setLayoutParams(paramContext);
    this.flButton.addView(this.pbLoading);
    this.flButton.setOnClickListener(new AttentionComponentView.1(this));
    showFollowButton(false);
  }
  
  private void loadAttentionState(RequestParam paramRequestParam)
  {
    if (this.mIsLoadingState) {
      return;
    }
    WbAppActivator.getInstance(getContext(), paramRequestParam.mAppKey).activateApp();
    this.mIsLoadingState = true;
    startLoading();
    WeiboParameters localWeiboParameters = new WeiboParameters(paramRequestParam.mAppKey);
    localWeiboParameters.put("access_token", paramRequestParam.mAccessToken);
    localWeiboParameters.put("target_id", paramRequestParam.mAttentionUid);
    localWeiboParameters.put("target_screen_name", paramRequestParam.mAttentionScreenName);
    NetUtils.internalHttpRequest(getContext(), "https://api.weibo.com/2/friendships/show.json", localWeiboParameters, "GET", new AttentionComponentView.2(this));
  }
  
  private void requestAsync(Context paramContext, String paramString1, WeiboParameters paramWeiboParameters, String paramString2, RequestListener paramRequestListener)
  {
    NetUtils.internalHttpRequest(paramContext, paramString1, paramWeiboParameters, paramString2, paramRequestListener);
  }
  
  private void showFollowButton(boolean paramBoolean)
  {
    stopLoading();
    if (paramBoolean)
    {
      this.mButton.setText(ResourceManager.getString(getContext(), "Following", "已关注", "已關注"));
      this.mButton.setTextColor(-13421773);
      localDrawable = ResourceManager.getDrawable(getContext(), "timeline_relationship_icon_attention.png");
      this.mButton.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
      this.flButton.setEnabled(false);
      return;
    }
    this.mButton.setText(ResourceManager.getString(getContext(), "Follow", "关注", "關注"));
    this.mButton.setTextColor(33280);
    Drawable localDrawable = ResourceManager.getDrawable(getContext(), "timeline_relationship_icon_addattention.png");
    this.mButton.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
    this.flButton.setEnabled(true);
  }
  
  private void startLoading()
  {
    this.flButton.setEnabled(false);
    this.mButton.setVisibility(8);
    this.pbLoading.setVisibility(0);
  }
  
  private void stopLoading()
  {
    this.flButton.setEnabled(true);
    this.mButton.setVisibility(0);
    this.pbLoading.setVisibility(8);
  }
  
  public void setAttentionParam(RequestParam paramRequestParam)
  {
    this.mAttentionParam = paramRequestParam;
    if (paramRequestParam.hasAuthoriz()) {
      loadAttentionState(paramRequestParam);
    }
  }
  
  public static class RequestParam
  {
    private String mAccessToken;
    private String mAppKey;
    private String mAttentionScreenName;
    private String mAttentionUid;
    private WeiboAuthListener mAuthlistener;
    
    public static RequestParam createRequestParam(String paramString1, String paramString2, String paramString3, WeiboAuthListener paramWeiboAuthListener)
    {
      RequestParam localRequestParam = new RequestParam();
      localRequestParam.mAppKey = paramString1;
      localRequestParam.mAttentionUid = paramString2;
      localRequestParam.mAttentionScreenName = paramString3;
      localRequestParam.mAuthlistener = paramWeiboAuthListener;
      return localRequestParam;
    }
    
    public static RequestParam createRequestParam(String paramString1, String paramString2, String paramString3, String paramString4, WeiboAuthListener paramWeiboAuthListener)
    {
      RequestParam localRequestParam = new RequestParam();
      localRequestParam.mAppKey = paramString1;
      localRequestParam.mAccessToken = paramString2;
      localRequestParam.mAttentionUid = paramString3;
      localRequestParam.mAttentionScreenName = paramString4;
      localRequestParam.mAuthlistener = paramWeiboAuthListener;
      return localRequestParam;
    }
    
    private boolean hasAuthoriz()
    {
      return !TextUtils.isEmpty(this.mAccessToken);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\component\view\AttentionComponentView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */