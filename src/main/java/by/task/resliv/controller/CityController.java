package by.task.resliv.controller;

import by.task.resliv.dto.CityDto;
import by.task.resliv.service.Impl.CityServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("resliv/city")
public class CityController {

    private final CityServiceImpl cityService;

    @GetMapping
    public Page<CityDto> findAll(@PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) final Pageable pageable) {
        return cityService.findAll(pageable); }

    @GetMapping("/{id}")
    public CityDto findById(@PathVariable final Long id) {
        return cityService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CityDto save(@RequestBody final CityDto cityDto) {
        return cityService.save(cityDto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public CityDto update(@RequestBody final CityDto cityDto) {
        return cityService.save(cityDto);
    }

    @PostMapping("/delete-list")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestBody final List<Long> deleteList) {
        cityService.deleteByIds(deleteList);
    }

}
