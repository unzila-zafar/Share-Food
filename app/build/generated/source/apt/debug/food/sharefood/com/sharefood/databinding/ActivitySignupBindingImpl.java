package food.sharefood.com.sharefood.databinding;
import food.sharefood.com.sharefood.R;
import food.sharefood.com.sharefood.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivitySignupBindingImpl extends ActivitySignupBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.imageView, 1);
        sViewsWithIds.put(R.id.name_layout, 2);
        sViewsWithIds.put(R.id.nameEdit, 3);
        sViewsWithIds.put(R.id.email_layout, 4);
        sViewsWithIds.put(R.id.emailEdit, 5);
        sViewsWithIds.put(R.id.password_layout, 6);
        sViewsWithIds.put(R.id.signup_password, 7);
        sViewsWithIds.put(R.id.confirm_layout, 8);
        sViewsWithIds.put(R.id.confirmPwdEdit, 9);
        sViewsWithIds.put(R.id.address_layout, 10);
        sViewsWithIds.put(R.id.addressEdit, 11);
        sViewsWithIds.put(R.id.spinner, 12);
        sViewsWithIds.put(R.id.button_signup, 13);
    }
    // views
    @NonNull
    private final android.support.constraint.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivitySignupBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }
    private ActivitySignupBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.support.design.widget.TextInputEditText) bindings[11]
            , (android.support.design.widget.TextInputLayout) bindings[10]
            , (android.widget.Button) bindings[13]
            , (android.support.design.widget.TextInputLayout) bindings[8]
            , (android.support.design.widget.TextInputEditText) bindings[9]
            , (android.support.design.widget.TextInputEditText) bindings[5]
            , (android.support.design.widget.TextInputLayout) bindings[4]
            , (android.widget.ImageView) bindings[1]
            , (android.support.design.widget.TextInputEditText) bindings[3]
            , (android.support.design.widget.TextInputLayout) bindings[2]
            , (android.support.design.widget.TextInputLayout) bindings[6]
            , (android.support.design.widget.TextInputEditText) bindings[7]
            , (android.widget.Spinner) bindings[12]
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