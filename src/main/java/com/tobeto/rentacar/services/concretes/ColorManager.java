package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentacar.entities.Color;
import com.tobeto.rentacar.repositories.ColorRepository;
import com.tobeto.rentacar.services.abstracts.ColorService;
import com.tobeto.rentacar.services.dtos.requests.color.AddColorRequest;
import com.tobeto.rentacar.services.dtos.requests.color.UpdateColorRequest;
import com.tobeto.rentacar.services.dtos.responses.color.GetColorListResponse;
import com.tobeto.rentacar.services.dtos.responses.color.GetColorResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ColorManager implements ColorService {
    private final ColorRepository colorRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetColorListResponse> getAll() {
        List<Color> colors=this.colorRepository.findAll();
        List<GetColorListResponse> response=colors.stream()
                .map(color -> this.modelMapperService.forResponse()
                        .map(color,GetColorListResponse.class)).collect(Collectors.toList());
        return response;
    }

    @Override
    public GetColorResponse getById(int id) {
        Color color=this.colorRepository.findById(id).orElseThrow();
        GetColorResponse response=this.modelMapperService.forResponse()
                .map(color,GetColorResponse.class);
        return response;
    }

    @Override
    public void add(AddColorRequest addColorRequest) {
        if (colorRepository.existsByName(addColorRequest.getName())){
            throw new RuntimeException("Ayni renk tekrar eklenilemez");
        }
        Color color=this.modelMapperService.forRequest().map(addColorRequest,Color.class);
        this.colorRepository.save(color);

    }

    @Override
    public void update(UpdateColorRequest updateColorRequest) {
        Color color=this.modelMapperService.forRequest().map(updateColorRequest,Color.class);
        this.colorRepository.save(color);

    }

    @Override
    public void delete(int id) {
        this.colorRepository.deleteById(id);

    }
}
