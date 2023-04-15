package ai.podcastle.gradleTest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/")
    public String test() {
        return "Hi, this should be 0.1.0";
    }

    @GetMapping(value = "/testload/{duration}")
    public String loadCustom(@PathVariable Long duration) throws InterruptedException {
        List<TestLoad> testLoads = new ArrayList<>(8);
        for (int th = 0; th < 8; th++) {
            var tl = new TestLoad("Thread" + th, 1.0, duration * 1000);
            tl.start();
            testLoads.add(tl);
        }
        while (testLoads.stream().anyMatch(TestLoad::isRunning)) {
            Thread.sleep(500);
        }

        return "OK";
    }

    @GetMapping("/health")
    public ResponseEntity health() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
