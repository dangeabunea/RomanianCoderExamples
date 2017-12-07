package rc.demo

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface HotelRepository : CrudRepository<Hotel,Long> {
    fun findByName(name: String): List<Hotel>
}