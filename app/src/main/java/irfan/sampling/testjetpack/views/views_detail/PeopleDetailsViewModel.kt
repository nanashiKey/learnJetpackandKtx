package irfan.sampling.testjetpack.views.views_detail

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import irfan.sampling.testjetpack.StartApp
import irfan.sampling.testjetpack.data.data_model.People


/**
 *   created by Irfan Assidiq on 3/31/19
 *   email : assidiq.irfan@gmail.com
 **/
class PeopleDetailsViewModel(application: Application) : AndroidViewModel(application) {
    private val peopleRepo = getApplication<StartApp>().getPeopleRepo()
    private val peopleId = MutableLiveData<Int>()

    fun getPeopleDetails(id: Int): LiveData<People>{
        peopleId.value = id
        val peopleDetails =
                Transformations.switchMap<Int, People>(peopleId){ id ->
                    peopleRepo.findPeople(id)
                }
        return peopleDetails
    }
}