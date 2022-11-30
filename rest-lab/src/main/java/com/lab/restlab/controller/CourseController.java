package com.lab.restlab.controller;

import com.lab.restlab.dto.CourseDto;
import com.lab.restlab.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/courses")
@RestController
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping()
    public List<CourseDto> getAll() {
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public CourseDto getById(@PathVariable int id) {
        return courseService.getById(id);
    }

    @PostMapping()
    public void save(@RequestBody CourseDto courseDto) {
        courseService.save(courseDto);
    }

    @PutMapping("/{id}")
    public CourseDto update(@PathVariable int id, @RequestBody CourseDto courseDto) {
        return courseService.update(id, courseDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        courseService.delete(id);
    }
}
