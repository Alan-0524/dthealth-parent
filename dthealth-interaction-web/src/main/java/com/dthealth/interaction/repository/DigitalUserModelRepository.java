package com.dthealth.interaction.repository;

import com.dthealth.interaction.entity.DigitalUserModel;
import org.springframework.stereotype.Component;

@Component
public class DigitalUserModelRepository extends BaseRepository<DigitalUserModel>{
    @Override
    Class getEntityClass(){
        return DigitalUserModel.class;
    }
}
