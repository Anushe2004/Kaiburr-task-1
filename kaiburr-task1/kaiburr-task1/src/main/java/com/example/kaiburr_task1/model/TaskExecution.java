package com.example.kaiburr_task1.model;

import lombok.*;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskExecution {
    private Instant startTime;
    private Instant endTime;
    private String output;
}

