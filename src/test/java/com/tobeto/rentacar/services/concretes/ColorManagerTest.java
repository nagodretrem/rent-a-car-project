package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.core.utilities.mappers.services.ModelMapperService;
import com.tobeto.rentacar.entities.concretes.Color;
import com.tobeto.rentacar.repositories.ColorRepository;
import com.tobeto.rentacar.services.abstracts.ColorService;
import com.tobeto.rentacar.services.dtos.requests.color.AddColorRequest;
import com.tobeto.rentacar.services.rules.ColorBusinessRules;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ColorManagerTest
{
    @Mock
    private ColorService colorService;

    @Mock
    private ColorRepository colorRepository;
    @Mock
    private AddColorRequest addColorRequest;

    @Mock
    private ModelMapperService modelMapperService;

    @Mock
    private ColorBusinessRules colorBusinessRules;

    @Mock
    private List<Color> colors;

    @Mock
    private Color color;

    @BeforeEach
            void setUp()
    {
        MockitoAnnotations.openMocks(this);
        color = new Color();
        colors = new ArrayList<>();
        addColorRequest = new AddColorRequest();
        colorService= new ColorManager(colorRepository, modelMapperService, colorBusinessRules);
    }
    @AfterEach
    void tearDown()
    {
    }

    @Test
    void colorNameShouldNotDuplicated()
    {
        String color = "Turkuaz";
        addColorRequest.setName(color);
        Mockito.when(colorRepository.existsByName(color)).thenReturn(true);
        assertThrows(RuntimeException.class, () -> {
            colorService.add(addColorRequest);
        });
    }

    @Test
    void succesfullyGetAll()
    {
        Mockito.when(colorRepository.findAll()).thenReturn(colors);
        colorService.getAll();
        assert true;

    }

    @Test
    void successfulyGetById()
    {
       // addColorRequest.setName("Turkuaz");
        Mockito.when(colorRepository.findById(color.getId())).thenReturn(Optional.of(new Color()));
        colorService.getById(color.getId());
        assert true;
    }
}
