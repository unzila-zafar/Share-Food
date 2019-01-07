package food.sharefood.com.sharefood.databinding;
import food.sharefood.com.sharefood.R;
import food.sharefood.com.sharefood.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class DialogFilterBindingImpl extends DialogFilterBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.textTitle, 1);
        sViewsWithIds.put(R.id.name_layout, 2);
        sViewsWithIds.put(R.id.search_name_edit, 3);
        sViewsWithIds.put(R.id.email_layout, 4);
        sViewsWithIds.put(R.id.search_email_edit, 5);
        sViewsWithIds.put(R.id.phone_layout, 6);
        sViewsWithIds.put(R.id.search_number_edit, 7);
        sViewsWithIds.put(R.id.sufficient_for_layout, 8);
        sViewsWithIds.put(R.id.search_sufficient_edit, 9);
        sViewsWithIds.put(R.id.pick_layout, 10);
        sViewsWithIds.put(R.id.search_picktime_edit, 11);
        sViewsWithIds.put(R.id.add_location_layout, 12);
        sViewsWithIds.put(R.id.search_location_edit, 13);
        sViewsWithIds.put(R.id.fooditems_layout, 14);
        sViewsWithIds.put(R.id.search_fooditems_edit, 15);
        sViewsWithIds.put(R.id.searchbutton, 16);
        sViewsWithIds.put(R.id.cancelButton, 17);
    }
    // views
    @NonNull
    private final android.support.constraint.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public DialogFilterBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }
    private DialogFilterBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.support.design.widget.TextInputLayout) bindings[12]
            , (android.widget.Button) bindings[17]
            , (android.support.design.widget.TextInputLayout) bindings[4]
            , (android.support.design.widget.TextInputLayout) bindings[14]
            , (android.support.design.widget.TextInputLayout) bindings[2]
            , (android.support.design.widget.TextInputLayout) bindings[6]
            , (android.support.design.widget.TextInputLayout) bindings[10]
            , (android.support.design.widget.TextInputEditText) bindings[5]
            , (android.support.design.widget.TextInputEditText) bindings[15]
            , (android.support.design.widget.TextInputEditText) bindings[13]
            , (android.support.design.widget.TextInputEditText) bindings[3]
            , (android.support.design.widget.TextInputEditText) bindings[7]
            , (android.support.design.widget.TextInputEditText) bindings[11]
            , (android.support.design.widget.TextInputEditText) bindings[9]
            , (android.widget.Button) bindings[16]
            , (android.support.design.widget.TextInputLayout) bindings[8]
            , (android.widget.TextView) bindings[1]
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