package com.musula.backend.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class ModelMapperUtil {


    private static ModelMapper modelMapper;

    public static synchronized ModelMapper getInstance() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            modelMapper.getConfiguration().setAmbiguityIgnored(true);
        }
        return modelMapper;
    }


}
