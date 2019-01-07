package food.sharefood.com.sharefood.databinding;
import food.sharefood.com.sharefood.R;
import food.sharefood.com.sharefood.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityViewFoodPostBindingImpl extends ActivityViewFoodPostBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new android.databinding.ViewDataBinding.IncludedLayouts(20);
        sIncludes.setIncludes(0, 
            new String[] {"post_toolbar"},
            new int[] {1},
            new int[] {R.layout.post_toolbar});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.images_post_List, 2);
        sViewsWithIds.put(R.id.layout_food, 3);
        sViewsWithIds.put(R.id.textPostItems, 4);
        sViewsWithIds.put(R.id.textPostItemValues, 5);
        sViewsWithIds.put(R.id.layout_sufficient, 6);
        sViewsWithIds.put(R.id.textSufficientHeading, 7);
        sViewsWithIds.put(R.id.value_sufficent, 8);
        sViewsWithIds.put(R.id.layout_pickup, 9);
        sViewsWithIds.put(R.id.textPickupItems, 10);
        sViewsWithIds.put(R.id.textPickupTime, 11);
        sViewsWithIds.put(R.id.layout_location, 12);
        sViewsWithIds.put(R.id.textHeadingLocation, 13);
        sViewsWithIds.put(R.id.textLocation, 14);
        sViewsWithIds.put(R.id.viewMap, 15);
        sViewsWithIds.put(R.id.layout_sharing, 16);
        sViewsWithIds.put(R.id.textSharingHeading, 17);
        sViewsWithIds.put(R.id.text_sharing, 18);
        sViewsWithIds.put(R.id.checkBox1, 19);
    }
    // views
    @NonNull
    private final android.support.constraint.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityViewFoodPostBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 20, sIncludes, sViewsWithIds));
    }
    private ActivityViewFoodPostBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.support.v7.widget.AppCompatCheckBox) bindings[19]
            , (android.support.v7.widget.RecyclerView) bindings[2]
            , (android.support.constraint.ConstraintLayout) bindings[3]
            , (android.support.constraint.ConstraintLayout) bindings[12]
            , (android.support.constraint.ConstraintLayout) bindings[9]
            , (android.support.constraint.ConstraintLayout) bindings[16]
            , (android.support.constraint.ConstraintLayout) bindings[6]
            , (food.sharefood.com.sharefood.databinding.PostToolbarBinding) bindings[1]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[18]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[15]
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
        postBar.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (postBar.hasPendingBindings()) {
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
        postBar.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangePostBar((food.sharefood.com.sharefood.databinding.PostToolbarBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangePostBar(food.sharefood.com.sharefood.databinding.PostToolbarBinding PostBar, int fieldId) {
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
        executeBindingsOn(postBar);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): postBar
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}