// Generated code from Butter Knife. Do not modify!
package id.ilhamsuaib.androidprintbluetooth;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view2131165218;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    target.etText = Utils.findRequiredViewAsType(source, R.id.et_text, "field 'etText'", EditText.class);
    target.size = Utils.findRequiredViewAsType(source, R.id.size, "field 'size'", EditText.class);
    target.size2 = Utils.findRequiredViewAsType(source, R.id.size2, "field 'size2'", EditText.class);
    target.size3 = Utils.findRequiredViewAsType(source, R.id.size3, "field 'size3'", EditText.class);
    target.etText2 = Utils.findRequiredViewAsType(source, R.id.et_text2, "field 'etText2'", EditText.class);
    target.etText3 = Utils.findRequiredViewAsType(source, R.id.et_text3, "field 'etText3'", EditText.class);
    target.etText4 = Utils.findRequiredViewAsType(source, R.id.et_text4, "field 'etText4'", EditText.class);
    target.jumlah = Utils.findRequiredViewAsType(source, R.id.jumlah, "field 'jumlah'", EditText.class);
    target.jumlah2 = Utils.findRequiredViewAsType(source, R.id.jumlah2, "field 'jumlah2'", EditText.class);
    target.jumlah3 = Utils.findRequiredViewAsType(source, R.id.jumlah3, "field 'jumlah3'", EditText.class);
    target.add = Utils.findRequiredViewAsType(source, R.id.add, "field 'add'", EditText.class);
    target.tvStatus = Utils.findRequiredViewAsType(source, R.id.tv_status, "field 'tvStatus'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_print_text, "method 'printText'");
    view2131165218 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.printText(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.etText = null;
    target.size = null;
    target.size2 = null;
    target.size3 = null;
    target.etText2 = null;
    target.etText3 = null;
    target.etText4 = null;
    target.jumlah = null;
    target.jumlah2 = null;
    target.jumlah3 = null;
    target.add = null;
    target.tvStatus = null;

    view2131165218.setOnClickListener(null);
    view2131165218 = null;
  }
}
