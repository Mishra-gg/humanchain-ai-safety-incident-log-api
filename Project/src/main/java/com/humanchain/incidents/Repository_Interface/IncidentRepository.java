package com.humanchain.incidents.Repository_Interface;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.humanchain.incidents.Model.Incident;

public interface IncidentRepository extends MongoRepository<Incident, String>{

}
