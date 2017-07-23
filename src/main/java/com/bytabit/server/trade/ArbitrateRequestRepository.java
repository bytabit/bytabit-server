package com.bytabit.server.trade;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface ArbitrateRequestRepository extends CrudRepository<ArbitrateRequest, String> {

    List<ArbitrateRequest> findByArbitratorProfilePubKey(String arbitratorProfilePubKey);

}
