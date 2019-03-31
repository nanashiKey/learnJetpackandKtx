package irfan.sampling.testjetpack.views.views_list

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import irfan.sampling.testjetpack.StartApp
import irfan.sampling.testjetpack.data.data_model.People


/**
 *   created by Irfan Assidiq on 3/31/19
 *   email : assidiq.irfan@gmail.com
 **/
class PeopleListViewModel(application: Application) :AndroidViewModel(application) {
    private val peopleRepo = getApplication<StartApp>()
        .getPeopleRepo()
    private val peopleList = MediatorLiveData<List<People>>()

    init {
        getAllPeople()
    }

    fun getPeopleList(): LiveData<List<People>>{
        return peopleList
    }

    fun getAllPeople(){
        peopleList.addSource(peopleRepo.getAllPeple()){
            peoples -> peopleList.postValue(peoples)
        }
    }
}