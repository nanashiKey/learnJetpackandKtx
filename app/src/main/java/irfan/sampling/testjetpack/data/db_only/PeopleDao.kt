package irfan.sampling.testjetpack.data.db_only

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import irfan.sampling.testjetpack.data.data_model.People


/**
 *   created by Irfan Assidiq on 3/31/19
 *   email : assidiq.irfan@gmail.com
 **/
@Dao
interface PeopleDao {
    //query select
    @Query("Select * from people Order by id desc")
    fun getAll(): LiveData<List<People>>

    //query insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(people: People)

    //query delete
    @Query("Delete from people")
    fun deleteAll()

    //query select by id
    @Query("Select * from people where id = :id")
    fun find(id: Int): LiveData<People>
}