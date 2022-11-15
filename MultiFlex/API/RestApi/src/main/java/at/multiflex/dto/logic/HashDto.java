package at.multiflex.dto.logic;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HashDto {
    private String hashValue;

    private Type type;
}
