package com.bytabit.server.profile;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/v1/profiles")
public class ProfileController {

    private final ProfileService profileService;

    private static ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @RequestMapping(method = POST, produces = "application/json", consumes = "application/json")
    public Profile post(@RequestBody Profile profile) {
        return profileService.create(profile);
    }

    @RequestMapping(path = "/{pubkey}", method = PUT, produces = "application/json", consumes = "application/json")
    public Profile put(@PathVariable String pubkey, @RequestBody Profile profile) {
        return profileService.update(pubkey, profile);
    }

    @RequestMapping(method = GET, produces = "application/json")
    public Iterable<Profile> getAll(@RequestParam(required = false) Boolean isArbitrator) throws IOException {
        return profileService.findAll(isArbitrator);
    }
}
