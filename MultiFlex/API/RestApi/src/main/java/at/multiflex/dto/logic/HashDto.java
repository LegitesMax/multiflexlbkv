package at.multiflex.dto.logic;

import lombok.*;

/**
 * A Data Transfer Object for hashes
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HashDto {
    private String hashValue;

    private Type type;
}
