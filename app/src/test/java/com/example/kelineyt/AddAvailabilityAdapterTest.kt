import org.junit.Test
import org.mockito.Mockito.mock
import android.view.View
import android.view.ViewGroup
import com.example.kelineyt.adapters.AddAvailabilityAdapter
import com.example.kelineyt.data.Scheduling
import org.junit.Assert.assertEquals

class AddAvailabilityAdapterTest {

    @Test
    fun getItemCount() {
        // Create a list of Scheduling items for testing
        val schedulingList = ArrayList<Scheduling>()
        schedulingList.add(Scheduling("Name 1", "Speciality 1", "Address 1", "Date 1", "From 1", "To 1"))
        schedulingList.add(Scheduling("Name 2", "Speciality 2", "Address 2", "Date 2", "From 2", "To 2"))

        val adapter = AddAvailabilityAdapter(schedulingList)

        // Check if getItemCount returns the correct number of items in the list
        assertEquals(2, adapter.itemCount)
    }



}
