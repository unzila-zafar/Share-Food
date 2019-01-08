package food.sharefood.com.sharefood.databinding;
import food.sharefood.com.sharefood.R;
import food.sharefood.com.sharefood.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityLoginBindingImpl extends ActivityLoginBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.top_layout, 1);
        sViewsWithIds.put(R.id.imageView, 2);
        sViewsWithIds.put(R.id.mid_layout, 3);
        sViewsWithIds.put(R.id.email_layout, 4);
        sViewsWithIds.put(R.id.email, 5);
        sViewsWithIds.put(R.id.password_layout, 6);
        sViewsWithIds.put(R.id.password, 7);
        sViewsWithIds.put(R.id.forget_text, 8);
        sViewsWithIds.put(R.id.button_layout, 9);
        sViewsWithIds.put(R.id.buttonSignIn, 10);
        sViewsWithIds.put(R.id.buttonForget, 11);
        sViewsWithIds.put(R.id.textOr, 12);
        sViewsWithIds.put(R.id.textSignwith, 13);
        sViewsWithIds.put(R.id.buttonFB, 14);
        sViewsWithIds.put(R.id.textRegister, 15);
    }
    // views
    @NonNull
    private final android.support.constraint.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityLoginBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }
    private ActivityLoginBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[14]
            , (android.widget.Button) bindings[11]
            , (android.support.constraint.ConstraintLayout) bindings[9]
            , (android.widget.Button) bindings[10]
            , (android.support.design.widget.TextInputEditText) bindings[5]
            , (android.support.design.widget.TextInputLayout) bindings[4]
            , (android.widget.TextView) bindings[8]
            , (android.widget.ImageView) bindings[2]
            , (android.support.constraint.ConstraintLayout) bindings[3]
            , (android.support.design.widget.TextInputEditText) bindings[7]
            , (android.support.design.widget.TextInputLayout) bindings[6]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[13]
            , (android.support.constraint.ConstraintLayout) bindings[1]
            );
        this.mboundView0 = (android.support.constraint.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}