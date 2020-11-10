package se.sda.devnews.demo.hello;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String Hello() {
        return "Hello World";
    }

    @RequestMapping("/hello/{name}")
    public String helloPerson(@PathVariable String name){

        return "Hello " + name;
    }

    @RequestMapping("/hello-age")
    public String helloAge(@RequestParam String name, @RequestParam Integer age){

        return "Hello " + name + " your age is " + age;
    }

}
