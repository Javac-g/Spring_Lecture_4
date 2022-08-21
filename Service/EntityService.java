package com.company.Service;

import com.company.Controller.personDTO;
import com.company.Model.DataEntity;
import com.company.Reposytory.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("EntityService")
public class EntityService implements EntityServiceImplement{
    @Autowired
    private DataRepository dataRepository;
    @Override
    public List<DataEntity> getData() {
        return dataRepository.findAll();
    }

    @Override
    public void setData(personDTO person) {
        DataEntity dataEntity = new DataEntity();
        dataEntity.setId(person.getId());
        dataEntity.setName(person.getName());
        dataEntity.setSalary(person.getSalary());
        dataRepository.save(dataEntity);
    }
}
