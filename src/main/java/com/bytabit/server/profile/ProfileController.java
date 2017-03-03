package com.bytabit.server.profile;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/api/v1/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    private static ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(method = POST, produces = "application/json", consumes = "application/json")
    public Profile post(@RequestBody Profile profile) {
        return profileService.create(profile);
    }

    @RequestMapping(path = "/{pubkey}", method = PUT, produces = "application/json", consumes = "application/json")
    public Profile put(@PathVariable String pubkey, @RequestBody Profile profile) {
        return profileService.update(pubkey, profile);
    }

    @RequestMapping(method = GET, produces = "application/json")
    public Iterable<Profile> getAll(@RequestParam(required = false) String since) throws IOException {

        LocalDateTime sinceDateTime = null;
        if (since != null && since.length() > 0) {
            sinceDateTime = LocalDateTime.parse(since);
        }
        return profileService.findAll();
    }
}
