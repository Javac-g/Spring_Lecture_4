package com.company.Service;

import com.company.Controller.personDTO;
import com.company.Model.DataEntity;

import java.util.List;

public interface EntityServiceImplement {
    List<DataEntity> getData();
    void setData(personDTO person);
}
