package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.core.utilities.mappers.services.ModelMapperService;
import com.tobeto.rentacar.entities.concretes.Brand;
import com.tobeto.rentacar.repositories.BrandRepository;
import com.tobeto.rentacar.services.abstracts.BrandService;
import com.tobeto.rentacar.services.dtos.requests.brand.AddBrandRequest;
import com.tobeto.rentacar.services.rules.BrandBusinessRules;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

class BrandManagerTest {
    @Mock
    private BrandService brandService;

    @Mock
    private BrandRepository brandRepository;

    @Mock
    private ModelMapperService modelMapperService;

    @Mock
    private BrandBusinessRules brandBusinessRules;

    @Mock
    private AddBrandRequest addBrandRequest;

    @Mock
    private List<Brand> brands;

    @Mock
    private Brand brand;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        addBrandRequest = new AddBrandRequest();
        brands = new ArrayList<>();
        brand = new Brand();
        brandService = new BrandManager(brandRepository, modelMapperService, brandBusinessRules);
        ModelMapper modelMapperForMock = Mockito.mock(ModelMapper.class);
        Mockito.when(modelMapperService.forRequest()).thenReturn(modelMapperForMock);
        Mockito.when(modelMapperService.forResponse()).thenReturn(modelMapperForMock);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void nameWithTwoLettersShouldThrowException()
    {

    // 3A =>1ARRANGE (HAZIRLIK "setUp")
        addBrandRequest.setName("ab");
        //ARRANGE
    // 3A =>2ACT (AKSİYON)
        assertThrows(RuntimeException.class, () -> {
            brandService.add(addBrandRequest);
        });
        //ACT

    // 3A =>3ASSERT (DOĞRULAMA) Expected = ?
       // assert true/false, "assertThrows()->(Exception fırlarsa test başarılı olur, fırlamazsa failure)"
    }

    @Test
    void brandWithSameNameShouldNotExist()
    {

        addBrandRequest.setName("Mercedes");
        when(brandRepository.existsByName("Mercedes")).thenReturn((true));
        assertThrows(RuntimeException.class, () ->{
            brandService.add(addBrandRequest);
        });
    }

    @Test
    void regularModelCanBeAdd()
    {
        addBrandRequest.setName("Renault");
        assertThrows(RuntimeException.class, () -> {
            brandService.add(addBrandRequest);
    });
    }

    @Test
    void succesfullyDelete() {

    }

    @Test
    void succesfullyGetAll(){
        Mockito.when(brandRepository.findAll()).thenReturn(brands);
        brandService.getAll();
        assert true;
    }

    @Test
    void succesfullyGetbyId()
    {
        Mockito.when(brandRepository.findById(brand.getId())).thenReturn(Optional.of(new Brand()));
        brandService.getById(brand.getId());
        assert true;
    }
}
