package food.sharefood.com.sharefood.main

class MainPresenter(private var mainView: MainView, private val mainInteractor: MainInteractor)
    : MainInteractor.OnFinishedListener {


    fun getListData()
    {
        mainView.showProgress()
        mainInteractor.requestData(this)
    }


    override fun onResultSuccess(arrFoodList: List<FoodPostModel>) {
        mainView.hideProgress()
        mainView.setData(arrFoodList)
    }

    override fun onResultFail(strError: String) {
        mainView.hideProgress()
    }

    fun onItemClick(adapterPosition: Int) {
        mainView.onItemClick(adapterPosition)
    }

}