package rc.demo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class SpringBootKotlinDemoApplication

/**
 * In Kotlin, "static" methods are defined outside the class. They are package level
 * methods
 */
fun main(args: Array<String>) {
    SpringApplication.run(SpringBootKotlinDemoApplication::class.java, *args)
}
