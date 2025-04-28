package com.skillbox.sb_practice.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
@Getter
@Setter
public class CommentCounters {
    private Long comments;
}
