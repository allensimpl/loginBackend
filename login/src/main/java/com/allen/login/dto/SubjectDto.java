package com.allen.login.dto;

import lombok.*;

@Builder
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class SubjectDto {
    private int id;
    private long createdOn;
    private long validTill;
}
