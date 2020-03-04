package com.sap.cloud.lm.sl.cf.web.api;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sap.cloud.lm.sl.cf.web.api.Constants.Endpoints;
import com.sap.cloud.lm.sl.cf.web.api.Constants.PathVariables;
import com.sap.cloud.lm.sl.cf.web.api.Constants.RequestVariables;
import com.sap.cloud.lm.sl.cf.web.api.Constants.Resources;
import com.sap.cloud.lm.sl.cf.web.api.model.Mta;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@Api(description = "the mtas API")
@RestController
@RequestMapping(Resources.MTAS)
public class MtasApi {

    @Inject
    private MtasApiService delegate;

    @GetMapping(path = Endpoints.MTA, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
    @ApiOperation(value = "", notes = "Retrieves Multi-Target Application in a space ", response = Mta.class, authorizations = {
        @Authorization(value = "oauth2", scopes = {

        }) }, tags = {})
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Mta.class) })
    public ResponseEntity<Mta> getMta(@PathVariable(PathVariables.SPACE_GUID) String spaceGuid,
                                      @PathVariable(RequestVariables.MTA_ID) String mtaId) {
        return delegate.getMta(spaceGuid, mtaId);
    }

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
    @ApiOperation(value = "", notes = "Retrieves all Multi-Target Applications in a space ", response = Mta.class, responseContainer = "List", authorizations = {
        @Authorization(value = "oauth2", scopes = {

        }) }, tags = {})
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Mta.class, responseContainer = "List") })
    public ResponseEntity<List<Mta>> getMtas(@PathVariable(PathVariables.SPACE_GUID) String spaceGuid) {
        return delegate.getMtas(spaceGuid);
    }

}
