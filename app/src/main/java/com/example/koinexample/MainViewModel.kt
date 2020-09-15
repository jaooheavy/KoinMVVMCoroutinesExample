import com.example.koinexample.RequestAPI

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class MainViewModel(private val requestAPI: RequestAPI) : ViewModel() {

    val name: MutableLiveData<String> = MutableLiveData()
    var clicks: Int = 0

    init {
        name.value = "Clique aqui"
    }

    fun loadData(){
        CoroutineScope(Dispatchers.Main).launch {
            val result = async {
                clicks++
                requestAPI.getFromAPIData(clicks)
            }.await()
            name.value = result
        }
    }
}