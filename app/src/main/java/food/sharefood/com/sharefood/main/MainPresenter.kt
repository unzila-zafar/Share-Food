package food.sharefood.com.sharefood.main

import android.content.Context
import food.sharefood.com.sharefood.R

class MainPresenter(private var mainView: MainView, private val mainInteractor: MainInteractor)
    : MainInteractor.OnFinishedListener {


    fun getListData(context: Context)
    {
        mainView.showProgress()
        mainInteractor.requestData(context,this)
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