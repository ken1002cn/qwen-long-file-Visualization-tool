package com.yundee.domain;

import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
public class FileItem {
   private String id;
   private String object;
   private String bytes;
   private String created_at;
   private String filename;
   private String purpose;
   private String extract;
   private String processed;

   @Override
   public String toString() {
      return filename;
   }
}
