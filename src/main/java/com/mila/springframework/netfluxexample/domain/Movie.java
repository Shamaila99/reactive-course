package com.mila.springframework.netfluxexample.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
//annotation makes it a mongoDb document
@Data //saves us a lot of boilerplate code
@NoArgsConstructor
@RequiredArgsConstructor
public class Movie {

    private String id;
    @NonNull //checks the value is not null - if it is, will throw NullPointer
    private String title;

}
