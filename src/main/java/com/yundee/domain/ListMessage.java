package com.yundee.domain;

import lombok.Data;

import java.util.List;

@Data
public class ListMessage {
    private String object;
    private String has_more;
    private List<FileItem> data;
}
