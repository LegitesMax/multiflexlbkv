package org.acme.mapper;

import org.acme.DTO.RegalDto;
import org.acme.DTO.WareDto;
import org.acme.model.Regal;
import org.acme.model.Ware;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class MappingHelper {
    @Inject
    ObjectMapper om;
}
