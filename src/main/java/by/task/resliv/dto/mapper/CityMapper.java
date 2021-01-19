package by.task.resliv.dto.mapper;

import by.task.resliv.domain.City;
import by.task.resliv.dto.CityDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class CityMapper {

    public City map(final CityDto cityDto) {
        return City.builder()
                .id(cityDto.getId())
                .city(cityDto.getCity())
                .recommendation(cityDto.getRecommendation())
                .build();
    }


    public CityDto map(final City city) {
        return CityDto.builder()
                .id(city.getId())
                .city(city.getCity())
                .recommendation(city.getRecommendation())
                .build();
    }

    public void update(final CityDto from, final City to) {
        to.setCity(from.getCity());
        to.setRecommendation(from.getRecommendation());
    }
}
