package com.nagp.customer.mapper;

import com.nagp.customer.dto.CustomerDto;
import com.nagp.customer.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModelDtoMapper {

    public CustomerDto toDto(Customer customer);
}
