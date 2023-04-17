package com.rijai.omt.omtserver.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
public class Credential {
    String clientName;
    String clientEmail;
}
