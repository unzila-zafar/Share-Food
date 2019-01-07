package food.sharefood.com.sharefood.databinding;
import food.sharefood.com.sharefood.R;
import food.sharefood.com.sharefood.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityAddPostBindingImpl extends ActivityAddPostBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new android.databinding.ViewDataBinding.IncludedLayouts(18);
        sIncludes.setIncludes(0, 
            new String[] {"app_toolbar"},
            new int[] {1},
            new int[] {R.layout.app_toolbar});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.add_photo_list, 2);
        sViewsWithIds.put(R.id.name_layout, 3);
        sViewsWithIds.put(R.id.add_name_edit, 4);
        sViewsWithIds.put(R.id.email_layout, 5);
        sViewsWithIds.put(R.id.add_email_edit, 6);
        sViewsWithIds.put(R.id.phone_layout, 7);
        sViewsWithIds.put(R.id.add_number_edit, 8);
        sViewsWithIds.put(R.id.sufficient_for_layout, 9);
        sViewsWithIds.put(R.id.add_sufficient_edit, 10);
        sViewsWithIds.put(R.id.pick_layout, 11);
        sViewsWithIds.put(R.id.add_picktime_edit, 12);
        sViewsWithIds.put(R.id.add_location_layout, 13);
        sViewsWithIds.put(R.id.add_location_edit, 14);
        sViewsWithIds.put(R.id.fooditems_layout, 15);
        sViewsWithIds.put(R.id.add_fooditems_edit, 16);
        sViewsWithIds.put(R.id.buttonAdd, 17);
    }
    // views
    @NonNull
    private final android.support.constraint.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityAddPostBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }
    private ActivityAddPostBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.support.design.widget.TextInputEditText) bindings[6]
            , (android.support.design.widget.TextInputEditText) bindings[16]
            , (android.support.design.widget.TextInputEditText) bindings[14]
            , (android.support.design.widget.TextInputLayout) bindings[13]
            , (android.support.design.widget.TextInputEditText) bindings[4]
            , (android.support.design.widget.TextInputEditText) bindings[8]
            , (android.support.v7.widget.RecyclerView) bindings[2]
            , (android.support.design.widget.TextInputEditText) bindings[12]
            , (android.support.design.widget.TextInputEditText) bindings[10]
            , (food.sharefood.com.sharefood.databinding.AppToolbarBinding) bindings[1]
            , (android.widget.Button) bindings[17]
            , (android.support.design.widget.TextInputLayout) bindings[5]
            , (android.support.design.widget.TextInputLayout) bindings[15]
            , (android.support.design.widget.TextInputLayout) bindings[3]
            , (android.support.design.widget.TextInputLayout) bindings[7]
            , (android.support.design.widget.TextInputLayout) bindings[11]
            , (android.support.design.widget.TextInputLayout) bindings[9]
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
                mDirtyFlags = 0x2L;
        }
        addToolbar.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (addToolbar.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    public void setLifecycleOwner(@Nullable android.arch.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        addToolbar.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeAddToolbar((food.sharefood.com.sharefood.databinding.AppToolbarBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeAddToolbar(food.sharefood.com.sharefood.databinding.AppToolbarBinding AddToolbar, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
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
        executeBindingsOn(addToolbar);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): addToolbar
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}