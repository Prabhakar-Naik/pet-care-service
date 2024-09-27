package com.springboot.petcareservice.dtos;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author prabhakar, @Date 17-09-2024
 */
@Component
@RequiredArgsConstructor
public class EntityConverter<T, D> {

    private final ModelMapper modelMapper;

    public D mapEntityToDto(T entity, Class<D> dtoClass){
        return this.modelMapper.map(entity,dtoClass);
    }


    public T mapDtoToEntity(D dtoClass, Class<T> entity){
        return this.modelMapper.map(dtoClass,entity);
    }

//    public List<ProductDto> getConvertedProducts(List<Product> products){
//        return products.stream().map(this::convertToDto).toList();
//    }



}
