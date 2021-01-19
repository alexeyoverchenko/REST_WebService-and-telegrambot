package by.task.resliv.service;

import by.task.resliv.dto.CityDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CityService {

    Page<CityDto> findAll(final Pageable Pageable);

    CityDto findById(final Long id);

    CityDto save(final CityDto dto);

    void deleteByIds(final List<Long> id);

    CityDto findByCity(final String telegramMessage);
}

