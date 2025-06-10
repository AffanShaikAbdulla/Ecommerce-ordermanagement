package com.ecommerce.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperUtil {
	private ModelMapper modelMapper;

	public ModelMapperUtil() {
		// TODO Auto-generated constructor stub
		this.modelMapper = new ModelMapper();
		this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

	}

	public<D> D map(Object source,  Class<D> destinationType){
		return modelMapper.map(source, destinationType);
	}

}
