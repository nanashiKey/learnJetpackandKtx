package irfan.sampling.testjetpack.data.data_model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


/**
 *   created by Irfan Assidiq on 3/29/19
 *   email : assidiq.irfan@gmail.com
 *   source https://www.raywenderlich.com/6729-android-jetpack-architecture-components-getting-started
 **/
@Entity
data class People (
    var name : String = "",
    var metAt : String = "",
    var contact: String = "",
    var email: String = "",
    var facebook: String = "",
    var twitter: String = "",
    @PrimaryKey(autoGenerate = true)var id: Int = 0
)