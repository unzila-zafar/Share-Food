package android.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new food.sharefood.com.sharefood.DataBinderMapperImpl());
  }
}
