package com.leonardogg.demospringboots3.model.vm;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Asset {


	private byte[] content;
    private String contentType;
    

}
