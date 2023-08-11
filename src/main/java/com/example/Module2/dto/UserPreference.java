package com.example.Module2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Component
public class UserPreference {
    String id;
    String operation;
    String watchList;
    List<String> stockName;
}
