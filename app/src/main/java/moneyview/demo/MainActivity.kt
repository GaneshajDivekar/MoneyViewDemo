package moneyview.demo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import moneyview.demo.adapter.MoviesAdapter
import moneyview.demo.base.BaseActivity
import moneyview.demo.databinding.ActivityMainBinding
import moneyview.demo.utili.MoviesLoadStateAdapter
import moneyview.demo.viewmodel.MainViewModel

@AndroidEntryPoint
@ActivityScoped
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mViewBinding.root)
        initView()

    }

    private fun initView() {
        val passengersAdapter = MoviesAdapter()
        mViewBinding.recyclerMyOrders.layoutManager = LinearLayoutManager(this)
        mViewBinding.recyclerMyOrders.setHasFixedSize(true)
        mViewBinding.recyclerMyOrders.adapter = passengersAdapter.withLoadStateHeaderAndFooter(
            header = MoviesLoadStateAdapter { passengersAdapter.retry() },
            footer = MoviesLoadStateAdapter { passengersAdapter.retry() }
        )
        lifecycleScope.launch {
            mViewModel!!.passengers.collectLatest { pagedData ->
                passengersAdapter.submitData(pagedData)
            }
        }

    }


    override val mViewModel: MainViewModel by viewModels()
    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
}
