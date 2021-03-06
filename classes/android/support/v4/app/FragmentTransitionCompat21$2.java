package android.support.v4.app;

import android.transition.Transition;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class FragmentTransitionCompat21$2
  implements ViewTreeObserver.OnPreDrawListener
{
  FragmentTransitionCompat21$2(View paramView1, Transition paramTransition, View paramView2, FragmentTransitionCompat21.ViewRetriever paramViewRetriever, Map paramMap1, Map paramMap2, ArrayList paramArrayList) {}
  
  public boolean onPreDraw()
  {
    this.val$container.getViewTreeObserver().removeOnPreDrawListener(this);
    if (this.val$enterTransition != null) {
      this.val$enterTransition.removeTarget(this.val$nonExistentView);
    }
    View localView = this.val$inFragment.getView();
    if (localView != null)
    {
      if (!this.val$nameOverrides.isEmpty())
      {
        FragmentTransitionCompat21.findNamedViews(this.val$renamedViews, localView);
        this.val$renamedViews.keySet().retainAll(this.val$nameOverrides.values());
        Iterator localIterator = this.val$nameOverrides.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          Object localObject = (String)localEntry.getValue();
          localObject = (View)this.val$renamedViews.get(localObject);
          if (localObject != null) {
            ((View)localObject).setTransitionName((String)localEntry.getKey());
          }
        }
      }
      if (this.val$enterTransition != null)
      {
        FragmentTransitionCompat21.access$000(this.val$enteringViews, localView);
        this.val$enteringViews.removeAll(this.val$renamedViews.values());
        this.val$enteringViews.add(this.val$nonExistentView);
        FragmentTransitionCompat21.addTargets(this.val$enterTransition, this.val$enteringViews);
      }
    }
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\app\FragmentTransitionCompat21$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */