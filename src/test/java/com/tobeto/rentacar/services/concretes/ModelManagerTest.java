package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.core.utilities.mappers.services.ModelMapperService;
import com.tobeto.rentacar.entities.concretes.Model;
import com.tobeto.rentacar.repositories.ModelRepository;
import com.tobeto.rentacar.services.abstracts.ModelService;
import com.tobeto.rentacar.services.dtos.requests.model.AddModelRequest;
import com.tobeto.rentacar.services.dtos.responses.model.GetModelListResponse;
import com.tobeto.rentacar.services.rules.ModelBusinessRules;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ModelManagerTest
{
    @Mock
    private ModelRepository modelRepository;

    @Mock
    private ModelService modelService;

    @Mock
    private AddModelRequest addModelRequest;

    @Mock
    private ModelBusinessRules modelBusinessRules;

    @Mock
    private ModelMapperService modelMapperService;

    @Mock
    private Model model;

    @Mock
    private List<Model> models;

    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.openMocks(this);
        modelService = new ModelManager(modelRepository, modelMapperService, modelBusinessRules);
        addModelRequest = new AddModelRequest();
        models = new ArrayList<>();
        model = new Model();
    }
    @AfterEach
    void tearDown()
    {

    }

    @Test
    void isModelDuplicated()
    {
        String model = "Model Y";
        addModelRequest.setName(model);
        Mockito.when(modelRepository.existsByName(model)).thenReturn(true);
        assertThrows(RuntimeException.class, () -> {
            modelService.add(addModelRequest);
        });

    }

    @Test
    void isGetAllSuccessfullyRun() {
        List<Model> models = new ArrayList<>();
        Mockito.when(modelRepository.findAll()).thenReturn(models);
        List<GetModelListResponse> result = modelService.getAll();
        assertEquals(models, result);
    }

    @Test
    void isGetByIdSuccesfullyRun()
    {
        Mockito.when(modelRepository.findById(model.getId())).thenReturn(Optional.of(new Model()));
        modelService.getById(model.getId());
        assert true;
    }
}
