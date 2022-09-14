package at.multiflex.mapper;

import at.multiflex.dto.CategoryDto;

import java.util.List;

public class MappingHelper {
    public <T> void getList(List<T> test){
        var x = test.getClass();
        x.getName();
    }
}
