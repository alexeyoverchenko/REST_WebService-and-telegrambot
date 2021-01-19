package by.task.resliv.service.Impl;

import by.task.resliv.domain.City;
import by.task.resliv.dto.CityDto;
import by.task.resliv.dto.mapper.CityMapper;
import by.task.resliv.repository.CityRepository;
import by.task.resliv.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityMapper cityMapper;
    private final CityRepository cityRepository;

    public Page<CityDto> findAll(final Pageable pageable) {
        return cityRepository.findAll(pageable).map(cityMapper::map);
    }

    public CityDto findById(final Long cityId) {
        return cityRepository.findById(cityId).map(cityMapper::map).orElseThrow();
    }

    public CityDto save(CityDto cityDto) {
        City city = Optional.ofNullable(cityDto.getId())
                .map(item -> {
                    final City existing = cityRepository
                            .findById(cityDto.getId())
                            .orElseThrow();
                    cityMapper.update(cityDto, existing);
                    return existing;
                })
                .orElseGet(() -> cityMapper.map(cityDto));

        final City saved = cityRepository.save(city);
        return cityMapper.map(saved);
    }

    @Transactional
    public void deleteByIds(final List<Long> id) {
            cityRepository.deleteByIds(id);
    }

    @Override
    public CityDto findByCity(String telegramMessage) {
        City city = cityRepository.findOneByCity(telegramMessage).orElse(null);
        return city != null ? cityMapper.map(city) : null;
    }
}
