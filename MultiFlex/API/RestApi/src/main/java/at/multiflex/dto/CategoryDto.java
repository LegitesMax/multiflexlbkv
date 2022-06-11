package at.multiflex.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    //<editor-fold desc="Common Fields">
    private Integer id;

    private String name;

    //</editor-fold>
    //<editor-fold desc="Navigation Help">
    private List<Integer> product_ids = new ArrayList<>();
    //</editor-fold>
}
