package romaniancoder.booking;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {
    private BookingRepository bookingRepository;

    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @GetMapping(value = "/all")
    public List<HotelBooking> getAll() {
        return bookingRepository.findAll();
    }

    @GetMapping(value = "/affordable/{price}")
    public List<HotelBooking> getAffordable(@PathVariable double price) {
        return bookingRepository.findByPricePerNightLessThan(price);
    }

    @PostMapping(value = "/create")
    public List<HotelBooking> create(@RequestBody HotelBooking hotelBooking) {
        bookingRepository.save(hotelBooking);

        return bookingRepository.findAll();
    }

    @PostMapping(value = "/delete/{id}")
    public List<HotelBooking> remove(@PathVariable long id) {
        bookingRepository.delete(id);

        return bookingRepository.findAll();
    }
}
