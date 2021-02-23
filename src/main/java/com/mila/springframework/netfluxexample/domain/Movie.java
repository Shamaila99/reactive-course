package com.mila.springframework.netfluxexample.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
//annotation makes it a mongoDb document
@Data //saves us a lot of boilerplate code
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    private String id;
    @NonNull //checks the value is not null - if it is, will throw NullPointer
    private String title;

}
