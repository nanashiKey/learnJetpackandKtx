package irfan.sampling.testjetpack

import android.app.Application
import irfan.sampling.testjetpack.data.ContactRepo


/**
 *   created by Irfan Assidiq on 3/29/19
 *   email : assidiq.irfan@gmail.com
 **/

class StartApp : Application(){
    /**
     * repositori data yg terpusat
     */
    fun getPeopleRepo() = ContactRepo(this)
}