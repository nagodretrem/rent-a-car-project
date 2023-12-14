package com.tobeto.rentacar.core.utilities.mappers;

import com.tobeto.rentacar.entities.Model;
import org.modelmapper.ModelMapper;

public interface ModelMapperService {
    ModelMapper forResponse();
    ModelMapper forRequest();
}
