package moneyview.demo.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import moneyview.demo.network.APIService
import moneyview.demo.repository.MainRepository
import moneyview.demo.utili.MoviesDataSource
import javax.inject.Inject

class MainViewModel @ViewModelInject constructor(private val apiService: APIService) :
    ViewModel() {
    val passengers = Pager(PagingConfig(pageSize = 10)) {
        MoviesDataSource(apiService)
    }.flow.cachedIn(viewModelScope)

   /* private var _topMoviesFirstPageResponse = MutableLiveData<Any>()
    private var _topMoviesNextPageResponse = MutableLiveData<Any>()

    fun requestFirstPageTopMovies(currentPage: Int) {
        mainRepository.loadPage(_topMoviesFirstPageResponse , currentPage)
    }

    fun requestFirstNextPageMovies(currentPage: Int) {
        mainRepository.loadPage(_topMoviesNextPageResponse , currentPage)
    }
    val topMoviesFirstPageResponse : LiveData<Any>
        get() = _topMoviesFirstPageResponse
    val topMoviesNextPageResponse : LiveData<Any>
        get() = _topMoviesNextPageResponse*/
}