package job.tracker.tracker.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import job.tracker.tracker.entities.User;

@RestController
public class ApplicationsController {
    private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public User greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new User(counter.incrementAndGet(), String.format(template, name));
	}
}
